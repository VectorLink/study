package com.example.pattern.mediatorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 16:47
 */
public interface Mediator {
    /**
     * 添加合作者
     * @param baseColleague
     * @return
     */
    Mediator addColleague(BaseColleague baseColleague);
    /**
     * 通知其他合作者
     * @param baseColleague
     * @param content
     */
    void notifyOtherColleague(BaseColleague baseColleague, String content);
}
