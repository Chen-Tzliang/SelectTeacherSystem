package com.zl.Springmvc.controller;

import com.zl.Springmvc.pojo.*;
import com.zl.Springmvc.service.CourseService;
import com.zl.Springmvc.service.MessageService;
import com.zl.Springmvc.service.StudentService;
import com.zl.Springmvc.service.TeacherService;
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
@RequestMapping(value="/Message")
public class MessageController {
    @Resource
    private CourseService courseService;
    @Resource
    private MessageService messageService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentService studentService;
    @RequestMapping(value="/ListCourse/{studentId}")
    public String listCourse(@PathVariable String studentId, Model model, HttpSession session){
        session.setAttribute("studentId",studentId);
        List<Course> courseList=courseService.findAllCourse();
        model.addAttribute("courseList",courseList);
        return "/Student/studentListMessage";
    }
    @RequestMapping(value="/intoMessage/{studentId}/Id/{teacherName}")
    public String intoMessage(@PathVariable String studentId,@PathVariable String teacherName,HttpSession session,Model model){
        session.setAttribute("studentId",studentId);
        Teacher teacher=teacherService.selectTeacherName(teacherName);
        model.addAttribute("teacherName",teacher.getTeacherName());
        model.addAttribute("teacherId",teacher.getTeacherId());
        return "/Student/studentInsertMessage";
    }
    @RequestMapping(value="/insertMessage/{studentId}")
    public String insertMessage(@PathVariable String studentId, Message message,HttpSession session){
        session.setAttribute("studentId",studentId);

        if(messageService.findByStudentIdAndTeacherId(studentId,message.getTeacherId())!=null){
            return "/Student/studentMessageNotice1";
        }
        String messageId= UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String teacherId=message.getTeacherId();
        String messageContext=message.getMessageContext();
        if(messageService.insertMessage(messageId,teacherId,studentId,messageContext)){
            return "/Student/studentIndex";
        }else{
            return "/error";
        }
    }
    @RequestMapping(value="/ListMessage/{studentId}")
    public String listMessage(@PathVariable String studentId,Model model,HttpSession session){
        if(messageService.findByStudentId(studentId)==null){
            return "/Student/studentMessageNotice";
        }
        List<Message> messageList=messageService.findByStudentId(studentId);
        List<Messagelink> messagelinkList=new ArrayList<Messagelink>();
        for (int i=0;i<messageList.size();i++){
            Teacher teacher=teacherService.findByTeacherId(messageList.get(i).getTeacherId());
            Student student=studentService.findStudentById(messageList.get(i).getStudentId());
            Messagelink messagelink=new Messagelink();
            messagelink.setStudentName(student.getStudentName());
            messagelink.setTeacherName(teacher.getTeacherName());
            messagelink.setMessageContext(messageList.get(i).getMessageContext());
            messagelinkList.add(messagelink);
        }
        model.addAttribute("messageList",messagelinkList);
        return "/Student/studentMessageList";
    }
    @RequestMapping(value="/messageContext/{messageContext}")
    public String messageContext(@PathVariable String messageContext,Model model){
        model.addAttribute("message",messageContext);
        return"/Student/studentmessageContext";
    }


    @RequestMapping(value="/TeacherListMessage/{teacherId}")
    public String teacherListMessage(@PathVariable String teacherId,Model model){
        if(messageService.findByTeacherId(teacherId)==null){
            return "/Teacher/teacherMessageNotice";
        }
        List<Message> messageList=messageService.findByTeacherId(teacherId);
        List<Messagelink> messagelinkList=new ArrayList<Messagelink>();
        for (int i=0;i<messageList.size();i++){
            Teacher teacher=teacherService.findByTeacherId(messageList.get(i).getTeacherId());
            Student student=studentService.findStudentById(messageList.get(i).getStudentId());
            Messagelink messagelink=new Messagelink();
            messagelink.setStudentName(student.getStudentName());
            messagelink.setTeacherName(teacher.getTeacherName());
            messagelink.setMessageContext(messageList.get(i).getMessageContext());
            messagelinkList.add(messagelink);
        }
        model.addAttribute("messageList",messagelinkList);
        return "/Teacher/teacherMessageList";
    }
    @RequestMapping(value="/teachermessageContext/{messageContext}/Name/{studentName}")
    public String teachermessageContext(@PathVariable String messageContext,@PathVariable String studentName,Model model){
        model.addAttribute("studentName",studentName);
        model.addAttribute("messageContext",messageContext);
        return "/Teacher/teachermessageContext";
    }
    @RequestMapping(value="updateMessage/{studentId}/Id/{teacherName}")
    public String updateMessage(@PathVariable String studentId,@PathVariable String teacherName,Model model,HttpSession session){
        session.setAttribute("studentId",studentId);
        Teacher teacher=teacherService.selectTeacherName(teacherName);
        Message messageL=messageService.findByStudentIdAndTeacherId(studentId,teacher.getTeacherId());

        if(messageL!=null){
        model.addAttribute("message",messageL);
        return "/Student/studentUpdateMessage";}
        else{
            return "/Student/studentMessageNotice";
        }
    }
    @RequestMapping(value="/updateToMessage/{studentId}")
    public String updateToMessage(Message message,@PathVariable String studentId,HttpSession session){
        session.setAttribute("studentId",studentId);
            if(messageService.updateMessage(message)){
                return "/Student/studentIndex";
            }else{
                return null;
            }
    }
}
