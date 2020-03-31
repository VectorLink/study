package com.example.pattern.mediatorpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GM20170901
 * @date 2020/3/31 16:50
 */
public class HouseMediator implements Mediator{

    List<BaseColleague> baseColleagues = new ArrayList<>();

    @Override
    public Mediator addColleague(BaseColleague baseColleague) {
        baseColleagues.add(baseColleague);
        return this;
    }

    @Override
    public void notifyOtherColleague(final BaseColleague baseColleague, String content) {
        final String translateContent = baseColleague.getName() + content;
        if(!baseColleagues.isEmpty()){
            List<BaseColleague> others =  baseColleagues.stream()
                    .filter(x->!baseColleague.getType().equals(x.getType())).collect(Collectors.toList());
            if(others.isEmpty()){
                return;
            }
            others.stream().forEach(x->{
                x.acceptMessage(translateContent);
            });
        }
    }
}