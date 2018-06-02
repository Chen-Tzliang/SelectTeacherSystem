package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.HaveClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="haveClassDao")
public interface HaveClassDao {
   boolean insertHaveClass(@Param("haveClassId") String haveClassId,
                           @Param("teacherId") String teacherId,
                           @Param("courseId") String courseId );
   boolean deleteHaveClass(String courseId);




  List<HaveClass> findCourseId(@Param("teacherId")String teacherId);
}
