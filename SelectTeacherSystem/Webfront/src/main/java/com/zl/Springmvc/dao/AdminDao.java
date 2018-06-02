package com.zl.Springmvc.dao;

import com.zl.Springmvc.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service(value="adminDao")
public interface AdminDao {
    Admin findByAdminNameAndAdminPassword(@Param("adminName")String adminName,
                                          @Param("adminPassword")String adminPassword);
}
