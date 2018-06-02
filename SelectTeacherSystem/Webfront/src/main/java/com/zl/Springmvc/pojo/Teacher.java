package com.zl.Springmvc.pojo;

import org.springframework.stereotype.Repository;

@Repository(value = "teacherEntity")
public class Teacher {
    private String teacherId;

    private String teacherPassword;

    private String teacherName;

    private String teacherSex;

    private String teacherAge;

    private String teacherAwards;

    private String teacherEmail;

    private String teacherPhone;

    private String teacherQq;

    private String teacherAddress;

    private String teacherTeaage;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge == null ? null : teacherAge.trim();
    }

    public String getTeacherAwards() {
        return teacherAwards;
    }

    public void setTeacherAwards(String teacherAwards) {
        this.teacherAwards = teacherAwards == null ? null : teacherAwards.trim();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail == null ? null : teacherEmail.trim();
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone == null ? null : teacherPhone.trim();
    }

    public String getTeacherQq() {
        return teacherQq;
    }

    public void setTeacherQq(String teacherQq) {
        this.teacherQq = teacherQq == null ? null : teacherQq.trim();
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress == null ? null : teacherAddress.trim();
    }

    public String getTeacherTeaage() {
        return teacherTeaage;
    }

    public void setTeacherTeaage(String teacherTeaage) {
        this.teacherTeaage = teacherTeaage == null ? null : teacherTeaage.trim();
    }
}