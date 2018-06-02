package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.Course;
import com.zl.Springmvc.pojo.Selectstudent;
import com.zl.Springmvc.pojo.Student;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.CourseService;
import com.zl.Springmvc.service.SelectStudentService;
import com.zl.Springmvc.service.StudentService;
import com.zl.Springmvc.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/SelectStudent")
public class SelectStudentController {
    @Resource
    private SelectStudentService selectStudentService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @RequestMapping(value="/addStudentName/{teacherId}")
    public String addStudentName(@PathVariable String teacherId, @RequestParam(value="studentId") String studentIdStr, HttpSession session)
    {
        String studentId[]=studentIdStr.split(",");
        session.setAttribute("teacherId",teacherId);
        if(selectStudentService.selectStudent(teacherId).size()+studentId.length>3){
            return "/Teacher/teacherNotice";
        }

        for(int i=0;i<studentId.length;i++){
            String selectStudentId= UUID.randomUUID().toString().replace("-", "").toUpperCase();
           if(selectStudentService.insertSelectstudent(selectStudentId,studentId[i],teacherId))
               continue;
           else
           return "/Teacher/teacherNotice1";

        }
         return "/Teacher/teacherIndex";
    }
    @RequestMapping(value="/LookTeacherSelect/{teacherId}")
    public String LookTeacherSelect(@PathVariable String teacherId,Model model,HttpSession session){
        session.setAttribute("teacherId",teacherId);
        List<Selectstudent> selectstudentList=selectStudentService.selectStudent(teacherId);
        List<Student> studentList = new ArrayList<Student>();
        for(int i=0;i<selectstudentList.size();i++){
            List<Student> student=studentService.findByStudentid(selectstudentList.get(i).getStudentId());
            if(student!=null){
                for (int j=0;j<student.size();j++){
                studentList.add(student.get(j));
            }
        }
        }
        model.addAttribute("studentList",studentList);
        return "/Teacher/teacherSelectStudentList";
    }
    @RequestMapping(value="/deleteStudent/{studentId}/Id/{teacherId}")
    public String deleteStudent(@PathVariable String studentId,@PathVariable String teacherId, HttpSession session){
     session.setAttribute("teacherId",teacherId);
     if(selectStudentService.deleteStudent(studentId)){
         return "/Teacher/teacherIndex";
     }else {
         return "/error";
     }
}
    @RequestMapping(value="/listStudent/{studentName}")
    public String listStudent(@PathVariable String studentName,Model model){
        Student student=studentService.findByStudentId(studentName);
        model.addAttribute("student",student);
        return "/Teacher/teacherListStudent";
    }
    @RequestMapping(value="/ListTeacher/{studentId}")
    public String listTeacher(@PathVariable String studentId,Model model,HttpSession session){
        session.setAttribute("studentId",studentId);
        Selectstudent selectstudent=selectStudentService.selectStudentById(studentId);
        Student student=studentService.findStudentById(studentId);
        if(selectstudent!=null){
            Teacher teacher=teacherService.findByTeacherId(selectstudent.getTeacherId());
            model.addAttribute("student",student);
            model.addAttribute("teacher",teacher);
            return "/Student/studentTeacherList";
        }
        return "/Student/studentNotice1";
    }
}
