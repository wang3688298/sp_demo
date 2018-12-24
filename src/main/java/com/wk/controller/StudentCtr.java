package com.wk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wk.bo.Student;
import com.wk.bo.Teacher;
import com.wk.cacheUtil.RedisUtil;
import com.wk.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentCtr {
    private static  final  Logger logger=Logger.getLogger(StudentCtr.class);
    @Autowired
     private StudentService studentService;

    @Autowired
     RedisUtil redisUtil;
    @RequestMapping(value="/getbyId")
    //@Cacheable(value = "stuname")
    public String select(int id) {
        System.out.print("没走缓存");
        Student stu = studentService.select(id);
        Teacher te=new Teacher();
        te.setTid("1");
        te.setTame("王老师");
        stu.setTeacher(te);
        redisUtil.set("uname",stu);
        return  redisUtil.get("uname");
    }

    @RequestMapping(value="/sav")
    public int save() {
        return 1;
    }

    @RequestMapping(value="/lis")
    public List<Student> getstus(String sex) {
        PageHelper.startPage(1,1);
        List<Student> s=studentService.getstus(sex);
        logger.info("水电费水电费水电费水电费收到");
        return s;
    }

    public static void main(String[] args) {
        int num=1;
        for(int i=0;i<5;i++){
            if(i==3){
                num=i;
                break;
            }
            num=i;
        }
        System.out.print(num);
    }

}
