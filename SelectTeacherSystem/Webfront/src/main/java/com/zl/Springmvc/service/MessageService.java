package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.Message;

import java.util.List;

public interface MessageService {
    List<Message> findByTeacherId(String teacherId);
    List<Message> findByStudentId(String studentId);
    boolean insertMessage(String messageId,String teacherId,String studentId,String messageContext);
    Message findByStudentIdAndTeacherId(String studentId,String teacherId);
    boolean updateMessage(Message message);
}
