package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.Selectstudent;

import java.util.List;

public interface SelectStudentService {
    boolean insertSelectstudent(String selectStudentId,String studentId,String teacherId);
    List<Selectstudent> selectStudent(String teacherId);
    Selectstudent selectStudentById(String studentId);
    boolean deleteStudent(String studentId);
    List<Selectstudent> findAllSelectStudent();
}
