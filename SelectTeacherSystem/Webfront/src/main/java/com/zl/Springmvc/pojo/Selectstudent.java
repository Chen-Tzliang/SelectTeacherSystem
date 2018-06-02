package com.zl.Springmvc.pojo;

public class Selectstudent {
    private String selectStudentId;

    private String teacherId;

    private String studentId;

    public String getSelectStudentId() {
        return selectStudentId;
    }

    public void setSelectStudentId(String selectStudentId) {
        this.selectStudentId = selectStudentId == null ? null : selectStudentId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }
}