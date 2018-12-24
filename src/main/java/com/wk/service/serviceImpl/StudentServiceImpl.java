package com.wk.service.serviceImpl;

import com.wk.bo.Student;
import com.wk.dao.StudentDao;
import com.wk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="studentService")
public class StudentServiceImpl  implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public Student select(int id) {
        return studentDao.byid(id);
    }

    @Override
    public int save() {
        return 0;
    }

    @Override
    public List<Student> getstus(String sex) {
        List<Student> ls=studentDao.stusbysex(sex);
        return ls;
    }
}
