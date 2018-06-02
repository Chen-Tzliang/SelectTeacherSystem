package com.zl.Springmvc.service.Impl;

import com.zl.Springmvc.dao.HaveClassDao;
import com.zl.Springmvc.pojo.HaveClass;
import com.zl.Springmvc.service.HaveClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="haveClassService")
public class HaveClassServiceImpl implements HaveClassService{
    @Resource
    private HaveClassDao haveClassDao;

    @Override
    public boolean insertHaveClass(String haveClassId,String teacherId,String courseId) {
        return haveClassDao.insertHaveClass(haveClassId,teacherId,courseId);
    }

    @Override
    public boolean deleteHaveClass(String courseId) {
        return haveClassDao.deleteHaveClass(courseId);
    }




    @Override
    public List<HaveClass> findCourseId(String teacherId) {
        return haveClassDao.findCourseId(teacherId);
    }
}
