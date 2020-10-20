package com.job.prepareJob.service;

import com.job.prepareJob.dao.StudentDao;
import com.job.prepareJob.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public Boolean insertStudent(Student student){
        int size = StudentDao.studentDB.size();
        StudentDao.studentDB.add(student);
        return size!=StudentDao.studentDB.size();
    }
    public List<Student> getAllStudent(){
        return StudentDao.studentDB;
    }
}
