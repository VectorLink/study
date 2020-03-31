package com.example.pattern.observerpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 14:26
 */
public class StudentObserver implements Observer  {

    private TeacherSubject teacherSubject;
    private String name;

    public StudentObserver(TeacherSubject teacherSubject, String name) {
        this.teacherSubject = teacherSubject;
        this.name = name;
        teacherSubject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println(name+"收到了来自"+teacherSubject.getInfo()+"的消息");
    }
}
