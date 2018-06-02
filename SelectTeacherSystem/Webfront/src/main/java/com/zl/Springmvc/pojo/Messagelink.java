package com.zl.Springmvc.pojo;

public class Messagelink {
    private String teacherName;
    private String studentName;
    private String messageContext;
    public void setTeacherName(String teacherName){this.teacherName=teacherName;}
    public void setStudentName(String studentName){this.studentName=studentName;}
    public void setMessageContext(String messageContext){this.messageContext=messageContext;}
    public String getTeacherName(){return this.teacherName;}
    public String getStudentName(){return this.studentName;}
    public String getMessageContext(){return this.messageContext;}
}
