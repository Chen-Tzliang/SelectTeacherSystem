package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.TeacherDao;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="teacherService")
public class TeacherServiceImpl implements TeacherService{
@Resource(name="teacherDao")
private TeacherDao teacherDao;
    @Override
    public Teacher findByTeacherIdAndTeacherPassword(String teacherId, String teacherPassword) {
        return teacherDao.findByTeacherIdAndTeacherPassword(teacherId,teacherPassword);
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {
        return teacherDao.findByTeacherId(teacherId);
    }

    @Override
    public boolean saveTeacher(String teacherId,String teacherName) {
        return teacherDao.saveTeacher(teacherId,teacherName);
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherDao.findAllTeacher();
    }

    @Override
    public boolean deteleTeacherById(String teacherId) {
        return teacherDao.deteleTeacherById(teacherId);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public Teacher selectTeacherName(String teacherName) {
        return teacherDao.selectTeacherName(teacherName);
    }

    @Override
    public List<Teacher> findTeacherIdBy(String teacherId) {
        return teacherDao.findTeacherIdBy(teacherId);
    }

    @Override
    public void updateTeacherPerson(Teacher teacher) {
        teacherDao.updateTeacherPerson(teacher);
    }

    @Override
    public void updateTeacherPassword(Teacher teacher) {
       teacherDao.updateTeacherPassword(teacher);
    }

    @Override
    public Teacher findByTeacherid(String teacherId) {
        return teacherDao.findByTeacherid(teacherId);
    }
}
