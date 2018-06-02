package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.Teacher;

import java.util.List;

public interface TeacherService {
   Teacher findByTeacherIdAndTeacherPassword(String teacherId ,String teacherPassword);
   Teacher findByTeacherId(String teacherId);
   boolean saveTeacher(String teacherId,String teacherName);
   List<Teacher> findAllTeacher();
   boolean deteleTeacherById(String teacherId);
   void updateTeacher(Teacher teacher);
   Teacher selectTeacherName(String teacherName);
   List<Teacher> findTeacherIdBy(String teacherId);
    void updateTeacherPerson(Teacher teacher);
    void updateTeacherPassword(Teacher teacher);
    Teacher findByTeacherid(String teacherId);
}
