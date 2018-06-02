package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.MessageDao;
import com.zl.Springmvc.pojo.Message;
import com.zl.Springmvc.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="messageService")
public class MessageServiceImpl implements MessageService{
    @Resource
    private MessageDao messageDao;
    @Override
    public List<Message> findByTeacherId(String teacherId) {
        return messageDao.findByTeacherId(teacherId);
    }

    @Override
    public List<Message> findByStudentId(String studentId) {
        return messageDao.findByStudentId(studentId);
    }

    @Override
    public boolean insertMessage(String messageId, String teacherId, String studentId, String messageContext) {
        return messageDao.insertMessage(messageId,teacherId,studentId,messageContext);
    }

    @Override
    public Message findByStudentIdAndTeacherId(String studentId, String teacherId) {
        return messageDao.findByStudentIdAndTeacherId(studentId,teacherId);
    }

    @Override
    public boolean updateMessage(Message message) {
        return messageDao.updateMessage(message);
    }
}
