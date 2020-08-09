package com.example.comm;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class V3SupplierMenu implements Serializable {
    Integer id;
    @JSONField(name="name")
    String menuName;
    Integer menuParentId;
    @JSONField(name="url")
    String menuUrl;
    Integer isValid;
    Integer menuSort;
    Timestamp updateTime;
    @JSONField(name="isIgnorePermission")
    Integer isIgnorePermission;
}
