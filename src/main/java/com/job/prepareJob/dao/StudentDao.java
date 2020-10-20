package com.job.prepareJob.dao;

import com.job.prepareJob.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDao {

    public static  List<Student> studentDB = new ArrayList<>();

}
