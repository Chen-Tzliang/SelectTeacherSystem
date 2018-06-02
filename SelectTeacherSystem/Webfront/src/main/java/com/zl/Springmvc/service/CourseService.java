package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.Course;

import java.util.List;

public interface CourseService {
    Course findByCourseId(String courseId);
    boolean saveCourse(String teacherId,
                       String teacherName,
                       String courseTeachername,
                       String courseApplytime,String courseSum,String courseAnalysis,String courseCol);
    List<Course> findAllCourse();
    boolean deleteCourse(String courseId);
    List<Course> FindByCourseId(String courseId);
    boolean updateCourse(Course course);
    Course findByCourseName(String courseName);
    void updateCourseCount(String courseId,String courseCount);
}
