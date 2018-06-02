package com.zl.Springmvc.pojo;

import org.springframework.stereotype.Repository;

@Repository("courseEntity")
public class Course {
    private String courseId;

    private String courseName;

    private String courseTeachername;

    private String courseApplytime;

    private String courseSum;

    private String courseAnalysis;

    private String courseCol;
    private String courseCount;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTeachername() {
        return courseTeachername;
    }

    public void setCourseTeachername(String courseTeachername) {
        this.courseTeachername = courseTeachername == null ? null : courseTeachername.trim();
    }

    public String getCourseApplytime() {
        return courseApplytime;
    }

    public void setCourseApplytime(String courseApplytime) {
        this.courseApplytime = courseApplytime == null ? null : courseApplytime.trim();
    }

    public String getCourseSum() {
        return courseSum;
    }

    public void setCourseSum(String courseSum) {
        this.courseSum = courseSum == null ? null : courseSum.trim();
    }

    public String getCourseAnalysis() {
        return courseAnalysis;
    }

    public void setCourseAnalysis(String courseAnalysis) {
        this.courseAnalysis = courseAnalysis == null ? null : courseAnalysis.trim();
    }

    public String getCourseCol() {
        return courseCol;
    }

    public void setCourseCol(String courseCol) {
        this.courseCol = courseCol == null ? null : courseCol.trim();
    }
    public String getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(String courseCount) {
        this.courseCount = courseCount == null ? null : courseCount.trim();
    }
}