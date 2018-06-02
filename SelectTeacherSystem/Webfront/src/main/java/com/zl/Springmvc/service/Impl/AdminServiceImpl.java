package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.AdminDao;
import com.zl.Springmvc.dao.SelectstudentDao;
import com.zl.Springmvc.dao.StudentDao;
import com.zl.Springmvc.dao.TeacherDao;
import com.zl.Springmvc.pojo.*;
import com.zl.Springmvc.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService {
@Resource(name="adminDao")
private AdminDao adminDao;
@Resource(name="teacherDao")
private TeacherDao teacherDao;
@Resource(name="studentDao")
private StudentDao studentDao;
@Resource(name="selectstudentDao")
private SelectstudentDao selectstudentDao;
    @Override
    public Admin findByAdminNameAndAdminPassword(String adminName, String adminPassword) {
        return adminDao.findByAdminNameAndAdminPassword(adminName,adminPassword);
    }

    @Override
    public List<SelectStudentlink> findAllSelectStudentLink() {
        List<Selectstudent> selectstudentList=selectstudentDao.findAllSelectStudent();
        List<SelectStudentlink> studentlinkList=new ArrayList<SelectStudentlink>();
        for(int i=0;i<selectstudentList.size();i++){
            Teacher teacher=teacherDao.findByTeacherId(selectstudentList.get(i).getTeacherId());
            Student student=studentDao.findStudentById(selectstudentList.get(i).getStudentId());
            SelectStudentlink selectStudentlink=new SelectStudentlink();
            selectStudentlink.setStudentCourse(student.getStudentFirst());
            selectStudentlink.setStudentName(student.getStudentName());
            selectStudentlink.setTeacherName(teacher.getTeacherName());
            studentlinkList.add(selectStudentlink);
        }
        return studentlinkList;
    }
}
