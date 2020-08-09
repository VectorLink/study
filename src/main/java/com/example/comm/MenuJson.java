package com.example.comm;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuJson implements Serializable {
    @JSONField(ordinal = 0)
    String name;
    @JSONField(ordinal = 1)
    String url;
    @JSONField(ordinal = 2)
    boolean isIgnorePermission;
    @JSONField(ordinal = 3)
    List<MenuJson> children;
}
