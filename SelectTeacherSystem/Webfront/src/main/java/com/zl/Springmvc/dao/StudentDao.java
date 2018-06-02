package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value="studentDao")
public interface StudentDao {
    Student findByStudentIdAndStudentPassword(@Param("studentId")String studentId,
                                          @Param("studentPassword")String studentPassword);   //根据密码和账号查询用户
    Student findByStudentId(@Param("studentName")String studentName);                              //根据姓名查询用户
    boolean saveStudent(@Param("studentName")String studentName,@Param("studentId")String studentId);                                                       //注册学生
    List<Student> findAll();                                                                    //列出所有学生信息
    boolean deleteStudentById(String studentId);
    Student findStudentById(String studentId);
    void updateStudent(Student student);
    void updateStudentPerson(Student student);
    void updateStudentPassword(Student student);


    List<Student> findByStudentid(@Param("studentId")String studentId);
    void addstudentCourse(Student student);
    List<Student> findByStudentFirst(@Param("studentFirst")String studentFirst);

}