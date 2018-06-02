package com.zl.Springmvc.pojo;

public class HaveClass {
    private String haveClassId;

    private String teacherId;

    private String courseId;

    public String getHaveClassId() {
        return haveClassId;
    }

    public void setHaveClassId(String haveClassId) {
        this.haveClassId = haveClassId == null ? null : haveClassId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }
}