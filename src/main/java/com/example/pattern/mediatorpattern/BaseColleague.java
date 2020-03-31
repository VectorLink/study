package com.example.pattern.mediatorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 16:47
 */
public abstract  class BaseColleague {
    Mediator mediator;

    String name;

    Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    /**
     * 发布消息
     *
     * @param content
     */
    abstract void sendMessage(String content);

    /**
     * 接收消息
     *
     * @param content
     */
    abstract void acceptMessage(String content);
}
