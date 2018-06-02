package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.SelectstudentDao;
import com.zl.Springmvc.pojo.Selectstudent;
import com.zl.Springmvc.service.SelectStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="selectstudentService")
public class SelectStudentServiceImpl implements SelectStudentService{
    @Resource
    private SelectstudentDao selectstudentDao;

    @Override
    public boolean insertSelectstudent(String selectStudentId, String studentId, String teacherId) {
        return selectstudentDao.insertSelectstudent(selectStudentId,studentId,teacherId);
    }

    @Override
    public List<Selectstudent> selectStudent(String teacherId) {
        return selectstudentDao.selectStudent(teacherId);
    }

    @Override
    public Selectstudent selectStudentById(String studentId) {
        return selectstudentDao.selectStudentById(studentId);
    }

    @Override
    public boolean deleteStudent(String studentId) {
        return selectstudentDao.deleteStudent(studentId);
    }

    @Override
    public List<Selectstudent> findAllSelectStudent() {
        return selectstudentDao.findAllSelectStudent();
    }
}
