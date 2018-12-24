package com.wk.bo;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Student implements Serializable{
    //存放redis 一定要实现序列化
   @Id
    private int id;

    private String name;


    private String sex;

     private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
