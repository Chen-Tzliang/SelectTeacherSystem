package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="messageDao")
public interface MessageDao {
List<Message> findByTeacherId(@Param("teacherId")String teacherId);
List<Message> findByStudentId(@Param("studentId")String studentId);
boolean insertMessage(@Param("messageId")String messageId,@Param("teacherId")String teacherId,
                      @Param("studentId")String studentId,@Param("messageContext") String messageContext
                      );
Message findByStudentIdAndTeacherId(@Param("studentId")String studentId,@Param("teacherId")String teacherId);
boolean updateMessage(Message message);
}
