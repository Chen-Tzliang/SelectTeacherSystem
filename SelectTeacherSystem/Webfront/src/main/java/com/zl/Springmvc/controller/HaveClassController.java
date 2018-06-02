package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.Course;
import com.zl.Springmvc.pojo.HaveClass;
import com.zl.Springmvc.pojo.Student;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value="/HaveClass")
public class HaveClassController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @Resource
    private StudentService studentService;
    @Resource
    private HaveClassService haveClassService;
    @Resource
    private SelectStudentService selectStudentService;
    @RequestMapping(value="/saveCourse")
    public String saveCourse(Course course) {
        List<Course> courseList=courseService.findAllCourse();
           int max=0;
           for(int i=0;i<courseList.size();i++){
               String courseS=courseList.get(i).getCourseId();
               int change=Integer.parseInt(courseS);
               if(change>max)max=change;
           }
           int get=max+1;
           String courseId=String.valueOf(get);
           String courseName=course.getCourseName();
           String tacherName=course.getCourseTeachername();
           String courseApplytime=course.getCourseApplytime();
           String courseSum=course.getCourseSum();
           String courseAnalysis=course.getCourseAnalysis();
           String courseCol=course.getCourseCol();
           Teacher teacher=teacherService.selectTeacherName(tacherName);
           String teacherId=teacher.getTeacherId();
          String haveClassId=UUID.randomUUID().toString().replace("-", "").toUpperCase();
         if(courseService.saveCourse(courseId,courseName,tacherName,courseApplytime,courseSum,courseAnalysis,courseCol)){
             if(haveClassService.insertHaveClass(haveClassId,teacherId,courseId)){
                 return "/Admin/adminIndex";
             }
         }
        return "/Admin/adminAddCourseAccount";
    }
    @RequestMapping(value="/teacherAddCourse/{teacherId}")
    public String teacherSaveCourse(@PathVariable String teacherId, Course course){
        List<Course> courseList=courseService.findAllCourse();
        List<HaveClass> haveClassList=haveClassService.findCourseId(teacherId);
         if(haveClassList.size()>=3){
             return "/Teacher/teacherCourseNotice";
         }
        int max=0;
        for(int i=0;i<courseList.size();i++){
            String courseS=courseList.get(i).getCourseId();
            int change=Integer.parseInt(courseS);
            if(change>max)max=change;
        }
        int get=max+1;
        String courseId=String.valueOf(get);
        String courseName=course.getCourseName();
        String courseApplytime=course.getCourseApplytime();
        String courseSum=course.getCourseSum();
        String courseAnalysis=course.getCourseAnalysis();
        String courseCol=course.getCourseCol();
        Teacher teacher=teacherService.findByTeacherid(teacherId);
        String teacherName=teacher.getTeacherName();
        String haveClassId=UUID.randomUUID().toString().replace("-", "").toUpperCase();
        if(courseService.saveCourse(courseId,courseName,teacherName,courseApplytime,courseSum,courseAnalysis,courseCol)){
            if(haveClassService.insertHaveClass(haveClassId,teacherId,courseId)){
                return "/Teacher/teacherIndex";
            }
        }
        return "/Teacher/teacherAddCourse";
    }

   @RequestMapping(value="/teacherLookstudent/{teacherId}")
    public String teacherLookstudent(@PathVariable String teacherId, HttpSession session,  Model model) {
       session.setAttribute("teacherId", teacherId);
       List<Student> studentList = new ArrayList<Student>();
       Course course;
       List<HaveClass> haveClass = haveClassService.findCourseId(teacherId);
       for (int i = 0; i < haveClass.size(); i++) {
           course = courseService.findByCourseId(haveClass.get(i).getCourseId());
           List<Student> student = studentService.findByStudentFirst(course.getCourseName());

           if (student != null) {
               for (int j=0;j<student.size();j++){
                   if(selectStudentService.selectStudentById(student.get(j).getStudentId())!=null)continue;
                   studentList.add(student.get(j));
               }
           }
       }
       model.addAttribute("studentList", studentList);
       if (studentList.isEmpty()) {
           return "Teacher/teacherNoice";
       }
         else return "Teacher/teacherLookstudent";
   }
   @RequestMapping(value="/teacherchoicestudent/{teacherId}")
    public String teacherchoicestudent(@PathVariable String teacherId, HttpSession session,  Model model){
       session.setAttribute("teacherId", teacherId);
       if(selectStudentService.selectStudent(teacherId).size()>=3){
           return "/Teacher/teacherNotice";
       }
       List<Student> studentlist = new ArrayList<Student>();
       Course course;
       List<HaveClass> haveClass = haveClassService.findCourseId(teacherId);
       for (int i = 0; i < haveClass.size(); i++) {
           course = courseService.findByCourseId(haveClass.get(i).getCourseId());
           List<Student> student = studentService.findByStudentFirst(course.getCourseName());
           if (student != null) {
               for (int j=0;j<student.size();j++){
                   if(selectStudentService.selectStudentById(student.get(j).getStudentId())!=null)continue;
                   studentlist.add(student.get(j));
               }
           }

       }
       model.addAttribute("studentList", studentlist);
       if (studentlist.isEmpty()) {
           return "Teacher/teacherNoice";
       }
       else return "Teacher/teacherChoiceStudent";

   }
}
