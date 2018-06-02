package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.Admin;
import com.zl.Springmvc.pojo.Student;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.AdminService;
import com.zl.Springmvc.service.StudentService;
import com.zl.Springmvc.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Resource(name="adminService")
    private AdminService adminService;
    @Resource(name="studentService")
    private StudentService studentService;
    @Resource(name="teacherService")
    private TeacherService teacherService;
    @RequestMapping(value="/Admin/login",method = RequestMethod.POST)
    public String adminLogin(String adminName,String adminPassword,HttpSession session){
        Admin admin=adminService.findByAdminNameAndAdminPassword(adminName,adminPassword);
        if(admin!=null){
            session.setAttribute("adminName",admin.getAdminName());
            return "Admin/adminIndex";
        }
        else{
            return "Admin/adminFail";
        }
    }
    @RequestMapping(value="/Student/login",method = RequestMethod.POST)
    public String studentLogin(String studentId,String studentPassword,HttpSession session) {
        Student student = studentService.findByStudentNameAndStudentPassword(studentId, studentPassword);
        if (student != null) {
            session.setAttribute("studentId",student.getStudentId());
            session.setAttribute("studentName", student.getStudentName());
            session.setAttribute("studentEmail", student.getStudentEmail());
            return "Student/studentIndex";
        } else {
            return "Student/studentFail";
        }

    }
    @RequestMapping(value="/Teacher/login",method = RequestMethod.POST)
    public String teacherLogin(String teacherId,String teacherPassword,HttpSession session) {
        Teacher teacher = teacherService.findByTeacherIdAndTeacherPassword(teacherId,teacherPassword);
        if (teacher != null) {
            session.setAttribute("teacherId", teacher.getTeacherId());
            session.setAttribute("teacherName",teacher.getTeacherName());
            session.setAttribute("teacherEmail",teacher.getTeacherEmail());
            return "Teacher/teacherIndex";
        } else {
            return "Teacher/teacherFail";
        }

    }
}
