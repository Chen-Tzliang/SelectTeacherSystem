package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.Course;
import com.zl.Springmvc.pojo.HaveClass;
import com.zl.Springmvc.pojo.Teacher;
import com.zl.Springmvc.service.CourseService;
import com.zl.Springmvc.service.HaveClassService;
import com.zl.Springmvc.service.TeacherService;
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
@RequestMapping(value="/Teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @Resource
    private HaveClassService haveClassService;
    @RequestMapping(value ="/addTeacher",method = RequestMethod.POST)                        //添加教师账号
    public String RegisterTeacher(Teacher teacher){
        String teacherName=teacher.getTeacherName();
        int max=0;
        List<Teacher> teacherList=teacherService.findAllTeacher();
        for(int i=0;i<teacherList.size();i++){
            String teacherS=teacherList.get(i).getTeacherId();
            int change=Integer.parseInt(teacherS);
            if(change>max)max=change;
        }
        int get=max+1;
        String teacherId=String.valueOf(get);
        if (teacherService.selectTeacherName(teacherName)!=null){
            return "Admin/adminAddTeacherAccount";
        }else {
            teacherService.saveTeacher(teacherId,teacherName);
            return "Admin/adminIndex";
        }
    }
    @RequestMapping(value="/ListAllTeacher")                                                 //查询所有教师
    public String ListAllTeacher(Model model){
        List<Teacher> teacherList=teacherService.findAllTeacher();
        model.addAttribute("teacherList",teacherList);
        return "/Admin/adminListAllTeacher";
    }
    @RequestMapping(value="/deleteTeacher",method = RequestMethod.GET)                       //根据教师id删除教师
    public void deleteTeacher(String teacherId,HttpServletRequest request,HttpServletResponse response){
        String result = "{\"result\":\"error\"}";
        if(teacherService.deteleTeacherById(teacherId)){
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value="/getTeacher/{teacherId}")
    public String getTeacher(@PathVariable String teacherId,HttpServletRequest request,Model model){
        Teacher teacher =teacherService.findByTeacherId(teacherId);
        request.setAttribute("teacher",teacher);
        model.addAttribute("teacher",teacher);
        return "/Admin/adminEditTeacher";
    }
    @RequestMapping(value="/update")
    public String updateTeacher(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return"redirect:/Teacher/ListAllTeacher";
    }
    @RequestMapping(value="/nameCheck")                                                       //根据教师的姓名查找
    public void TeacherNameCheck(HttpServletResponse response, HttpServletRequest request) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String courseTeachername=request.getParameter("courseTeachername");
        Teacher teacher=teacherService.selectTeacherName(courseTeachername);
        if(teacher!=null){
            out.println("可以添加这个指导教师！");
        }else{
            out.println("指导教师不存在，请重新输入指导教师！");
        }
        out.flush();
        out.close();
    }
    @RequestMapping(value="/idCheck")
    public void TeacherIdCheck(HttpServletResponse response, HttpServletRequest request) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String courseTeachername=request.getParameter("courseTeachername");
        Teacher teacher=teacherService.selectTeacherName(courseTeachername);
        if(teacher!=null){
            out.println("指导教师不存在，请重新输入指导教师！");
        }else{
            out.println("可以添加这个指导教师！");
        }
        out.flush();
        out.close();
    }
    /*
    * 以下是teacher的controller*/

    @RequestMapping(value="/teacherListTeacher/{teacherId}")
    public String teacherListTeacher(@PathVariable String teacherId, HttpSession session, Model model){
        session.setAttribute("teacherId",teacherId);
        model.addAttribute("teacherList",teacherService.findTeacherIdBy(teacherId));
        return "/Teacher/teacherList";
    }
    @RequestMapping(value="/teacherEditTeacher/{teacherId}")
    public String teacherEditTeacher(@PathVariable String teacherId,HttpServletRequest request, HttpSession session,Model model){
        session.setAttribute("teacherId",teacherId);
        Teacher teacher =teacherService.findByTeacherid(teacherId);
        request.setAttribute("teacher",teacher);
        model.addAttribute("teacher",teacher);
        return "Teacher/teacherEdit";
    }
    @RequestMapping(value="/teacherUpdateTeacher/{teacherId}")
    public String teacherUpdateTeacher(@PathVariable String teacherId,Teacher teacher, HttpSession session){
        session.setAttribute("teacherId",teacherId);
        teacherService.updateTeacherPerson(teacher);
        return "/Teacher/teacherIndex";
    }
    @RequestMapping(value="/teacherUpdateTeacherPassword/{teacherId}")
    public String teacherUpdateTeacherPassword(@PathVariable String teacherId,Teacher teacher, HttpSession session){
        session.setAttribute("teacherId",teacherId);
        teacherService.updateTeacherPassword(teacher);
        return "/Teacher/teacherIndex";
    }
    @RequestMapping(value="/teacherEditPassword/{teacherId}")
    public String teacherEditPassword(@PathVariable String teacherId,Model model,HttpServletRequest request){
      Teacher teacher=  teacherService.findByTeacherid(teacherId);
        model.addAttribute("teacher",teacher);
        request.setAttribute("teacher",teacher);
        return "Teacher/teacherEditPassword";
    }
    @RequestMapping(value="/teacherListCourse/{teacherId}")
    public String teacherListCourse(@PathVariable String teacherId,Model model){
        List<HaveClass> haveClassList=haveClassService.findCourseId(teacherId);
        List<Course> courseList=new ArrayList<Course>();
        for(int i=0;i<haveClassList.size();i++){
            List<Course> courses=courseService.FindByCourseId(haveClassList.get(i).getCourseId());
            if(courses!=null){
                for (int j=0;j<courses.size();j++){
                    courseList.add(courses.get(j));
                }
            }
        }

        model.addAttribute("courseList",courseList);
        return "/Teacher/teacherListCourse";
    }
    @RequestMapping(value="/teacherAddCourse/{teacherId}")
    public String teacherAddCourse(@PathVariable String teacherId, HttpSession session){
        session.setAttribute("teacherId",teacherId);
        return"/Teacher/teacherAddCourse";
    }
}
