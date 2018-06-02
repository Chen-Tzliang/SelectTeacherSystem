package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.Course;
import com.zl.Springmvc.pojo.Student;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/Course")
public class CourseController {
    @Resource
    private CourseService courseService;
    @Resource
    private HaveClassService haveClassService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentService studentService;
    @Resource
    private SelectStudentService selectStudentService;
    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public void CourseIdCheck(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String courseId=request.getParameter("courseId");
        Course course=courseService.findByCourseId(courseId);
        if(course!=null){
            out.println("课程号已经存在，请重新输入新的课程号！");
        }else{
            out.println("课程号可以使用！");
        }
        out.flush();
        out.close();
    }
    @RequestMapping(value="/ListAllCourse")
    public String ListAllCourse(Model model){
        if(courseService.findAllCourse()!=null){
            model.addAttribute("courseList",courseService.findAllCourse());
            return "/Admin/adminListAllCourse";
        }
        return "/Admin/adminIndex";
    }
    @RequestMapping(value="/ListAllTeacherCourse")
    public String ListAllCourseTeacher(Model model){
        if(courseService.findAllCourse()!=null){
            model.addAttribute("courseList",courseService.findAllCourse());
            return "/Admin/adminListAllTeacherCourse";
        }
        return "/Admin/adminIndex";
    }
    @RequestMapping(value="/deleteCourse/{courseId}")
    public String deleteCourse(@PathVariable String courseId){

        if(haveClassService.deleteHaveClass(courseId))
            if(courseService.deleteCourse(courseId)){
               return"redirect:/Course/ListAllCourse";
            }

          return"/Admin/adminIndex";

    }
    /*
    * 以下是属于学生部分的controller*/
   @RequestMapping(value="/studentListCourse/{studentId}")
    public String studentListCourse(@PathVariable String studentId, HttpSession session,  Model model){
       session.setAttribute("studentId",studentId);
       List<Course> courseList=courseService.findAllCourse();
       model.addAttribute("courseList",courseList);
       return "/Student/studentListCourse";
   }
   @RequestMapping(value="/studentCourseSelect/{studentId}")
    public String studentCourseSelect(@PathVariable String studentId, HttpSession session,  Model model){
       session.setAttribute("studentId",studentId);
       List<Course> courses=courseService.findAllCourse();
       List<Course> courseList=new ArrayList<Course>();

       for (int i=0;i<courses.size();i++){
           String courseAnaly=courses.get(i).getCourseAnalysis();
           List<Student> studentList=studentService.findByStudentFirst(courses.get(i).getCourseName());
           int courseTc=Integer.parseInt(courseAnaly);
           int courseSc=studentList.size();
           System.out.println(courseSc);
           if(courseTc>courseSc)
               courseList.add(courses.get(i));
       }
       Student student =studentService.findStudentById(studentId);
       model.addAttribute("courseList", courseList);
       if (selectStudentService.selectStudentById(studentId)!=null){
           return "/Student/studentNotice";
       }
       if(student.getStudentFirst()!=null&&!student.getStudentFirst().equals(""))
           return "Student/studentNoticeCourse";
       else
           return "Student/studentCourseSelect";


   }
   @RequestMapping(value="/getBycourseId/{courseId}/Id/{studentId}")
    public String studentCourseX(@PathVariable String studentId,@PathVariable String courseId,HttpSession session,  Model model){
       session.setAttribute("studentId",studentId);
       Course course=courseService.findByCourseId(courseId);
       model.addAttribute("course",course);
       return "/Student/studentListCourseS";
   }
   @RequestMapping(value="/getBycourseTeacher/{courseTeacher}/Id/{studentId}")
    public String studentTeacherX(@PathVariable String studentId,@PathVariable String courseTeacher,HttpSession session, Model model){
       session.setAttribute("studentId",studentId);
       Teacher teacher=teacherService.selectTeacherName(courseTeacher);
       model.addAttribute("teacher",teacher);
       return "/Student/studentListTeacher";
   }
   @RequestMapping(value="/studentCourseSelectAgain/{studentId}")
    public String studentCourseSelectAgain(@PathVariable String studentId, HttpSession session,  Model model){
       session.setAttribute("studentId",studentId);
       List<Course> courseList=courseService.findAllCourse();
       model.addAttribute("courseList", courseList);
       return "/Student/studentCourseSelect";
   }


   /*
   * 教师的Controller*/


   @RequestMapping(value="/getCourse/{courseId}")
    public String getCourse(Model model,@PathVariable String courseId){
       Course course=courseService.findByCourseId(courseId);
       System.out.println(course.getCourseName());
      List<Student> studentList=studentService.findByStudentFirst(course.getCourseName());
       if(studentList.size()!=0){
           return"/Teacher/teacherCourseNotice1";
       }else {
           model.addAttribute("course", course);
           return "/Teacher/teacherEditCourse";
       }
   }
   @RequestMapping(value="/updateCourse/{teacherId}")
    public String updateCourse(@PathVariable String teacherId, Course course,HttpSession session){
       session.setAttribute("teacherId",teacherId);
       if(courseService.updateCourse(course)){
           return "/Teacher/teacherIndex";
       }else {
           return null;
       }
   }
   @RequestMapping(value="/deleteCourse1/{courseId}")
    public String deleteCourse1(@PathVariable String courseId){

       if(haveClassService.deleteHaveClass(courseId))
           if(courseService.deleteCourse(courseId)){
               return "/Teacher/teacherIndex";
           }
           return null;
   }

}