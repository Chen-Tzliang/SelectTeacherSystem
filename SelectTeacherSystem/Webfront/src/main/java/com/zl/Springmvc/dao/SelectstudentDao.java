package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.Selectstudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="selectstudentDao")
public interface SelectstudentDao {
    boolean insertSelectstudent(@Param("selectStudentId")String selectStudentId,
                                @Param("studentId")String studentId,@Param("teacherId")String teacherId);
    List<Selectstudent> selectStudent(@Param("teacherId")String teacherId);
    Selectstudent selectStudentById(@Param("studentId") String studentId);
    boolean deleteStudent(@Param("studentId")String studentId);
    List<Selectstudent> findAllSelectStudent();
}
