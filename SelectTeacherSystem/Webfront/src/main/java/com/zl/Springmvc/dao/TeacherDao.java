package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.Teacher;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="teacherDao")
public interface TeacherDao {
 Teacher findByTeacherIdAndTeacherPassword(@Param("teacherId")String teacherId,
                                           @Param("teacherPassword")String teacherPassword);
 Teacher findByTeacherId(@Param("teacherId")String teacherId );
 boolean saveTeacher(@Param("teacherId")String teacherId,@Param("teacherName")String teacherName);
 List<Teacher> findAllTeacher();
 boolean deteleTeacherById(String teacherId);
    Teacher findByTeacherid(String teacherId);
 void updateTeacher(Teacher teacher);
 Teacher selectTeacherName(@Param("teacherName") String teacherName);
 List<Teacher> findTeacherIdBy(@Param("teacherId")String teacherId );
 void updateTeacherPerson(Teacher teacher);
 void updateTeacherPassword(Teacher teacher);
}