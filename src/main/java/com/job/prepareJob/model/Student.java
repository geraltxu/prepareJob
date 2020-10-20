package com.job.prepareJob.model;

public class Student {
    private String student_id;
    private String student_name;
    private String student_gender;
    private int student_age;
    private Information student_info;

    public Student(){}
    public Student(String student_id,String student_name, int student_age, String student_gender, Information student_info){
        this.student_id = student_id;
        this.student_age = student_age;
        this.student_gender = student_gender;
        this.student_name = student_name;
        this.student_info = student_info;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public int getStudent_age() {
        return student_age;
    }

    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

    public Information getStudent_info() {
        return student_info;
    }

    public void setStudent_info(Information student_info) {
        this.student_info = student_info;
    }
}
