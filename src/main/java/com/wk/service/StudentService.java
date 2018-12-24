package com.wk.service;

import com.wk.bo.Student;

import java.util.List;

public interface StudentService {

     Student select(int id);


     int  save();

     List<Student> getstus(String sex);

}
