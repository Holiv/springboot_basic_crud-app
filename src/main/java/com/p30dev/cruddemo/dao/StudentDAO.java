package com.p30dev.cruddemo.dao;

import com.p30dev.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    Student findByName(String name);

    Student findByLastName(String name);

    void updateStudentLastName(String currentName, String newLastName);
    void updateAllStudentsLastName();
}
