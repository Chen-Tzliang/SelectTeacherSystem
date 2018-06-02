package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.Course;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="courseDao")
public interface CourseDao {

    boolean saveCourse(@Param("courseId")String teacherId, @Param("courseName") String courseName,
                       @Param("courseTeachername") String courseTeachername,
                       @Param("courseApplytime") String courseApplytime, @Param("courseSum") String courseSum,
                       @Param("courseAnalysis") String courseAnalysis,
                       @Param("courseCol") String courseCol);
    List<Course> findAllCourse();
   boolean deleteCourse(String courseId);

    Course findByCourseId(@Param("courseId") String courseId);
    List<Course> FindByCourseId(@Param("courseId") String courseId);
    boolean updateCourse(Course course);
    Course findByCourseName(@Param("courseName") String courseName );
    void updateCourseCount(@Param("courseId") String courseId,@Param("courseCount") String courseCount);
}
