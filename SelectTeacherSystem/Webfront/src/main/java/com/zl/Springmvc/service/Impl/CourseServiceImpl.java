package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.CourseDao;
import com.zl.Springmvc.pojo.Course;
import com.zl.Springmvc.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="courseService")
public class CourseServiceImpl implements CourseService{
    @Resource(name="courseDao")
    private CourseDao courseDao;

    @Override
    public Course findByCourseId(String courseId) {
        return courseDao.findByCourseId(courseId);
    }

    @Override
    public boolean saveCourse(String teacherId, String teacherName, String courseTeachername, String courseApplytime, String courseSum,String courseAnalysis, String courseCol) {
        return courseDao.saveCourse(teacherId,teacherName,courseTeachername,courseApplytime,courseSum,courseAnalysis,courseCol);
    }


    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    @Override
    public boolean deleteCourse(String courseId) {
        return courseDao.deleteCourse(courseId);
    }

    @Override
    public List<Course> FindByCourseId(String courseId) {
        return courseDao.FindByCourseId(courseId);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public Course findByCourseName(String courseName) {
        return courseDao.findByCourseName(courseName);
    }

    @Override
    public void updateCourseCount(String courseId, String courseCount) {
        courseDao.updateCourseCount(courseId,courseCount);
    }
}
