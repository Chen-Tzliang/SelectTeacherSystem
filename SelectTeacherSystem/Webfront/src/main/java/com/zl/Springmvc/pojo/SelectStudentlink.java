package com.zl.Springmvc.pojo;

public class SelectStudentlink {
    private String studentName;
    private String studentCourse;
    private String teacherName;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
