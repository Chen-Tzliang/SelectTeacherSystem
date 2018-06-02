package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.HaveClass;

import java.util.List;

public interface HaveClassService {
   boolean insertHaveClass(String haveClassId,String teacherId,String courseId);
   boolean deleteHaveClass(String courseId);

   List<HaveClass> findCourseId(String teacherId);
}
