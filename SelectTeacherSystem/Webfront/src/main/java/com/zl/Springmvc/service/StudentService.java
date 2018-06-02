package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.Student;

import java.util.List;

public interface StudentService {
    Student findByStudentNameAndStudentPassword(String studentId,String studentPassword);
    Student findByStudentId(String studentId);
    boolean saveStudent(String studentName,String studentId);
    List<Student> findAll();
    boolean deleteStudentById(String studentId);
    Student findStudentById(String studentId);
    void updateStudent(Student student);
    List<Student> findByStudentid(String studentId);
    void updateStudentPerson(Student student);
    void updateStudentPassword(Student student);
    void addstudentCourse(Student student);
    List<Student> findByStudentFirst(String studentFirst);

}
