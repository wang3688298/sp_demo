package com.wk.dao;

import com.wk.bo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDao {

    Student byid( int id);


    int  insert();

    List<Student> stusbysex(String sex);
}
