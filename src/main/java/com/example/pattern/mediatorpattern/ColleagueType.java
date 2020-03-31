package com.example.pattern.mediatorpattern;

/**
 *  合作者类型
 * @author GM20170901
 * @date 2020/3/31 16:49
 */
public enum ColleagueType {
    /**
     * 租客类型
     */
    TENANT(1),
    /**
     * 房东类型
     */
    LANDORD(2);
    private Integer value;

    ColleagueType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
