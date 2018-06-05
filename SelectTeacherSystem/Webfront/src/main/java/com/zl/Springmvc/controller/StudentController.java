package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.Course;
import com.zl.Springmvc.pojo.Student;
import com.zl.Springmvc.service.CourseService;
import com.zl.Springmvc.service.SelectStudentService;
import com.zl.Springmvc.service.StudentService;
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
import java.util.List;

@Controller
@RequestMapping(value="/Student")
public class StudentController {
    @Resource(name="studentService")
    private StudentService studentService;
    @Resource
    private SelectStudentService selectStudentService;
    @Resource
    private CourseService courseService;
    @RequestMapping(value = "/nameCheck",method= RequestMethod.POST)         //听过学生姓名检查学生是否存在
    public void StudentIdCheck(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String studentName=request.getParameter("studentName");
        Student student=studentService.findByStudentId(studentName);
        if(student!=null){
            out.println("学生已存在，请重新输入学生姓名！");
        }else{
            out.println("学生可以被注册！");
        }
        out.flush();
        out.close();
    }
    @RequestMapping(value="/addStudent",method = RequestMethod.POST)       //添加学生账号
    public String RegisterStudent(Student student){
       String studentName=student.getStudentName();
       int max=0;
       List<Student> studentList=studentService.findAll();
       for(int i=0;i<studentList.size();i++){
        String studentS=studentList.get(i).getStudentId();
        int change=Integer.parseInt(studentS);
        if(change>max)max=change;
       }
        int get=max+1;
       String studentId=String.valueOf(get);
       if(studentService.findByStudentId(studentName)!=null){

           return "Admin/adminAddStudentAccount";
       }
       else{
           studentService.saveStudent(studentName,studentId);

           return "Admin/adminIndex";
       }

}
    @RequestMapping(value="/ListAllstudent")                               //查询所有的学生
    public String ListAllStudent(Model model){
        List<Student> studentList=studentService.findAll();
      model.addAttribute("studentList",studentList);
        return "Admin/adminListAllStudent";
    }
    @RequestMapping(value="/deleteStudent",method = RequestMethod.GET)         //删除学生信息
    public void deleteStudent(String studentId,HttpServletRequest request,HttpServletResponse response){
        String result = "{\"result\":\"error\"}";
        if(studentService.deleteStudentById(studentId)){
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
    @RequestMapping(value = "/getStudent/{studentId}",method = RequestMethod.GET)          //根据id查询学生
    public String getStudent(@PathVariable String studentId,HttpServletRequest request,Model model){
        Student student=studentService.findStudentById(studentId);
        request.setAttribute("student",student);
        model.addAttribute("student",student);
        return "Admin/adminEditStudent";
    }
    @RequestMapping(value="/update")                                            //修改学生的信息
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/Student/ListAllstudent";
}
    @RequestMapping(value="/ListAllstudentV")                                   //学生的志愿信息
    public String ListAllStudentV(Model model){
        List<Student> studentList=studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "Admin/adminListStudentV";
    }
/*
下面是关于学生
模块的Controller
*/







    @RequestMapping(value="/studentListStudent/{studentId}")
    public String studentListStudent(@PathVariable String studentId, HttpSession session,Model model){
        session.setAttribute("studentId",studentId);
        List<Student> studentList= studentService.findByStudentid(studentId);
        if(studentList!=null){
        model.addAttribute("studentList",studentList);
        return "/Student/studentList";
        }
        else{
            return "/Student/studentIndex";
        }
    }
    @RequestMapping(value="/studentEditStudent/{studentId}",method = RequestMethod.GET)
    public String studentEditStudent(@PathVariable String studentId,HttpServletRequest request, HttpSession session,Model model){
       session.setAttribute("studentId",studentId);
       Student student=studentService.findStudentById(studentId);
       request.setAttribute("student",student);
       model.addAttribute("student",student);
        return "Student/studentEdit";
    }
    @RequestMapping(value="studentUpdateStudent/{studentId}")
    public String studentUpdateStudent(@PathVariable String studentId, Student student,HttpSession session){
        studentService.updateStudentPerson(student);
        session.setAttribute("studentId",studentId);
        session.setAttribute("studentName", student.getStudentName());
        session.setAttribute("studentEmail", student.getStudentEmail());
        return "Student/studentIndex";
    }
    @RequestMapping(value="/studentEditPassword/{studentId}")
    public String studentEditPassword(@PathVariable String studentId,HttpSession session,HttpServletRequest request,Model model){
        session.setAttribute("studentId",studentId);
        Student student=studentService.findStudentById(studentId);
        request.setAttribute("student",student);
        model.addAttribute("student",student);
        return "Student/studentEditPassword";
    }
    @RequestMapping(value="/studentUpdateStudentPassword/{studentId}")
    public String studentEditStudentPassword(@PathVariable String studentId, Student student,HttpSession session){
        studentService.updateStudentPassword(student);
        session.setAttribute("studentId",studentId);
        session.setAttribute("studentName", student.getStudentName());
        session.setAttribute("studentEmail", student.getStudentEmail());
        return "Student/studentIndex";
    }
    @RequestMapping(value="/addCourseName")
    public String studentAddCourse(Student student,HttpSession session){
        studentService.addstudentCourse(student);
        session.setAttribute("studentId",student.getStudentId());
        Student studentf =studentService.findStudentById(student.getStudentId());
        session.setAttribute("studentName", studentf.getStudentName());
        session.setAttribute("studentEmail", studentf.getStudentEmail());
        return "Student/studentIndex";
    }
    @RequestMapping(value="/studentCourseSelectLook/{studentId}")
    public String studentCourseSelectLook(@PathVariable String studentId,HttpServletRequest request, HttpSession session,Model model){
        session.setAttribute("studentId",studentId);
        if (selectStudentService.selectStudentById(studentId)!=null){
            return "/Student/studentNotice";
        }
        Student student=studentService.findStudentById(studentId);
        request.setAttribute("student",student);
        model.addAttribute("student",student);
        return "/Student/studentCourseSelectLook";
    }

}
