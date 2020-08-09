package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.example.comm.MenuJson;
import com.example.comm.V3SupplierMenu;

import java.util.*;
import java.util.stream.Collectors;

public class JsonTreeUtil {

    public static List<V3SupplierMenu> json2List(String jsonData){
        List<V3SupplierMenu> resutl= new ArrayList<>();
        MenuJson root=JSON.parseObject(jsonData,MenuJson.class);
        toV3SupplierMenu(resutl,root,null,null);
        return resutl;
    }


    public static List<V3SupplierMenu> toV3SupplierMenu(List<V3SupplierMenu> result, MenuJson menuJson,Integer parentId, Integer sort){
        Integer menuId=UUID.randomUUID().toString().hashCode();
        menuId=menuId<0?-menuId:menuId;
        int menusSort = sort == null ? 0 : sort;
        V3SupplierMenu.V3SupplierMenuBuilder data= V3SupplierMenu.builder()
                .isIgnorePermission(menuJson.isIgnorePermission()?1:0)
                .menuName(menuJson.getName())
                .menuUrl(menuJson.getUrl())
                .menuParentId(parentId).id(menuId).menuSort(menusSort).isValid(1);
        if (null!=parentId){
            data.menuParentId(parentId);
        }
        result.add(data.build());
        if (null!=menuJson.getChildren()&&menuJson.getChildren().size()>0){
            Integer finalMenuId = menuId;
            int size = menuJson.getChildren().size();
            for (int i = 0; i < size; i++) {
                toV3SupplierMenu(result,menuJson.getChildren().get(i), finalMenuId, i);
            }
        }
        return result;
    }

    public static List<MenuJson> toMenuJson(List<V3SupplierMenu> data){
        List<MenuJson> result=new ArrayList<>();
        List<V3SupplierMenu> rootMenu=data.stream().filter(item->item.getMenuParentId()==null).collect(Collectors.toList());
        if (rootMenu.size()!=0){
            for (V3SupplierMenu menu:rootMenu){
                result.add(toTree(data,menu));
            }
        }
        return result;
    }

    public static MenuJson toTree(List<V3SupplierMenu> data,V3SupplierMenu rootMenu){
        MenuJson rooJson=MenuJson.builder()
                .url(rootMenu.getMenuUrl())
                .isIgnorePermission(rootMenu.getIsIgnorePermission()==1)
                .name(rootMenu.getMenuName())
                .build();
        List<V3SupplierMenu> child=data.stream().filter(item->item.getMenuParentId()==rootMenu.getId())
                .collect(Collectors.toList());
        if (child.size()>0){
            child.sort(Comparator.comparingInt(V3SupplierMenu::getMenuSort));
            List<MenuJson> childJson=new ArrayList<MenuJson>(child.size());
            for (V3SupplierMenu menu:child){
                childJson.add(toTree(data,menu));
            }
            rooJson.setChildren(childJson);
        }
        return rooJson;
    }

}
