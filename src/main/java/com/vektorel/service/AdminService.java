package com.vektorel.service;

import com.vektorel.entity.Admin;
import com.vektorel.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

public class AdminService {

    private AdminRepository adminRepository;

    public AdminService() {
        this.adminRepository = new AdminRepository();
    }

    public void save(String email,String password){

        Admin admin= new Admin();
        admin.setEmail(email);
        admin.setPassword(password);

        adminRepository.save(admin);
    }

    public Admin findById(long id){
        Optional<Admin> optionalAdmin= adminRepository.findById(id);

        if (optionalAdmin.isPresent()){
            return optionalAdmin.get();
        }
        return null;
    }

    public List<Admin> getAllAdmin(){
       return adminRepository.findAllAdmin();
    }

    public List<Admin> getAllAdminHql(){
        return adminRepository.findAllAdmin2();
    }


}
