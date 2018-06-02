package com.zl.Springmvc.service;

import com.zl.Springmvc.pojo.Admin;
import com.zl.Springmvc.pojo.SelectStudentlink;

import java.util.List;

public interface AdminService {
  Admin findByAdminNameAndAdminPassword(String adminName,String adminPassword);
  List<SelectStudentlink> findAllSelectStudentLink();
}
