package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.SelectStudentlink;
import com.zl.Springmvc.pojo.Selectstudent;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.AdminService;
import com.zl.Springmvc.service.SelectStudentService;
import com.zl.Springmvc.service.StudentService;
import com.zl.Springmvc.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/Admin")
public class AdminController {
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private SelectStudentService selectStudentService;
    @Resource
    private AdminService adminService;
    @RequestMapping(value="/ListAllTeacher")
    public String ListSelectStudent(Model model){
        List<Selectstudent> selectstudent=selectStudentService.findAllSelectStudent();
        if(selectstudent==null){
            return "/Admin/adminStudentNotice";
        }
        List<SelectStudentlink> studentlinkList=adminService.findAllSelectStudentLink();
        model.addAttribute("studentLinkList",studentlinkList);
        return "/Admin/adminListSelectStudent";
    }
    @RequestMapping(value="/ListTeacherStudent")
    public String ListTeacherStudent(Model model){
        List<Selectstudent> selectstudent=selectStudentService.findAllSelectStudent();
        if(selectstudent==null){
            return "/Admin/adminStudentNotice";
        }
        List<SelectStudentlink> studentlinkList=adminService.findAllSelectStudentLink();
        model.addAttribute("studentLinkList",studentlinkList);
        return "/Admin/adminListSelectTeacher";
    }
    @RequestMapping(value="/adminAddCourseAccount")
    public String adminAddCourseAccount(Model model){
        List<Teacher> teacherList=teacherService.findAllTeacher();
        model.addAttribute("teacherList",teacherList);

        return "/Admin/adminAddCourseAccount";

    }


}
