package com.zl.Springmvc.pojo;

import org.springframework.stereotype.Repository;

@Repository(value="studentEntity")
public class Student {
    private String studentId;

    private String studentName;

    private String studentPassword;

    private String studentSex;

    private String studentAge;

    private String studentAddress;

    private String studentEmail;

    private String studentPhone;

    private String studentQq;

    private String studentFirst;

    private String studentSecond;

    private String studentScore;

    private String studentEntertime;

    private String studentExperience;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword == null ? null : studentPassword.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge == null ? null : studentAge.trim();
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress == null ? null : studentAddress.trim();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone == null ? null : studentPhone.trim();
    }

    public String getStudentQq() {
        return studentQq;
    }

    public void setStudentQq(String studentQq) {
        this.studentQq = studentQq == null ? null : studentQq.trim();
    }

    public String getStudentFirst() {
        return studentFirst;
    }

    public void setStudentFirst(String studentFirst) {
        this.studentFirst = studentFirst == null ? null : studentFirst.trim();
    }

    public String getStudentSecond() {
        return studentSecond;
    }

    public void setStudentSecond(String studentSecond) {
        this.studentSecond = studentSecond == null ? null : studentSecond.trim();
    }

    public String getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(String studentScore) {
        this.studentScore = studentScore == null ? null : studentScore.trim();
    }

    public String getStudentEntertime() {
        return studentEntertime;
    }

    public void setStudentEntertime(String studentEntertime) {
        this.studentEntertime = studentEntertime == null ? null : studentEntertime.trim();
    }

    public String getStudentExperience() {
        return studentExperience;
    }

    public void setStudentExperience(String studentExperience) {
        this.studentExperience = studentExperience == null ? null : studentExperience.trim();
    }
}