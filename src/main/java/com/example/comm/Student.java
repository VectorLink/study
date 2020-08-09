package com.example.comm;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GM20170901
 * @date 2020/3/23 14:44
 */
@Data
@NoArgsConstructor
public class Student   {
    String name;
    String sex;
    Integer age;
    Integer score;
    public Student(String name, String sex, Integer age, Integer score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
    }
}
