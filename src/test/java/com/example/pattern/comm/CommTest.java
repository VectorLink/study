package com.example.pattern.comm;

import com.alibaba.fastjson.JSON;
import com.example.comm.MenuJson;
import com.example.comm.V3SupplierMenu;
import com.example.utils.JsonTreeUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
public class CommTest {

    @Test
    public void MysqlGenernaterTest() throws Exception{
        File file =new File("D:\\menu.json");
        InputStream reader=new FileInputStream(file);

        byte[] data=new byte[102400];
        int lenth;
        StringBuffer stringBuffer=new StringBuffer();
        while ((lenth=reader.read(data))!=-1){
            stringBuffer.append(new String(data));
        }
        reader.close();
        String str=stringBuffer.toString();

        MenuJson root=JSON.parseObject(str,MenuJson.class);
        List<V3SupplierMenu> resutl=JsonTreeUtil.json2List(str);

        List<MenuJson> jsonResult=JsonTreeUtil.toMenuJson(resutl);

        String t=JSON.toJSONString(jsonResult.get(0));

        Assert.isTrue(JSON.toJSONString(root).equals(t),"不相同");


    }
}
