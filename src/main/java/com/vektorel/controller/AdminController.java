package com.vektorel.controller;

import com.vektorel.entity.Admin;
import com.vektorel.service.AdminService;

import java.util.List;

public class AdminController {
    private AdminService adminService;

    public AdminController() {
        this.adminService = new AdminService();
    }
    public void save(String email,String password){
        adminService.save(email,password);
    }

    public Admin findById(long id){
        return adminService.findById(id);
    }

    public List<Admin> getAllAdminNative(){
        return adminService.getAllAdmin();
    }

    public List<Admin> getAllAdminHql(){
        return adminService.getAllAdminHql();
    }


}
