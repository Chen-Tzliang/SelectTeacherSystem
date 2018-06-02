package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.StudentDao;
import com.zl.Springmvc.pojo.Student;
import com.zl.Springmvc.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="studentService")
public class StudentServiceImpl implements StudentService {
    @Resource(name="studentDao")
    private StudentDao studentDao;

    @Override
    public Student findByStudentNameAndStudentPassword(String studentId, String studentPassword) {
        return studentDao.findByStudentIdAndStudentPassword(studentId,studentPassword);
    }

    @Override
    public Student findByStudentId(String studentId) {
        return studentDao.findByStudentId(studentId);
    }

    @Override
    public boolean saveStudent(String studentName,String studentId) {
       return studentDao.saveStudent(studentName,studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean deleteStudentById(String studentId) {
        return studentDao.deleteStudentById(studentId);
    }

    @Override
    public Student findStudentById(String studentId) {
        return studentDao.findStudentById(studentId);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> findByStudentid(String studentId) {
        return studentDao.findByStudentid(studentId);
    }

    @Override
    public void updateStudentPerson(Student student) {
        studentDao.updateStudentPerson(student);
    }

    @Override
    public void updateStudentPassword(Student student) {
        studentDao.updateStudentPassword(student);
    }

    @Override
    public void addstudentCourse(Student student) {
        studentDao.addstudentCourse(student);
    }

    @Override
    public List<Student> findByStudentFirst(String studentFirst) {
        return studentDao.findByStudentFirst(studentFirst);
    }



}
