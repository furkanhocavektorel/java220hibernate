package com.vektorel;


import com.vektorel.controller.AdminController;
import com.vektorel.entity.Admin;
import com.vektorel.entity.Customer;
import com.vektorel.entity.Gender;
import com.vektorel.repository.AdminRepository;
import com.vektorel.util.DbConnection;

public class Main {

    // FRONT SIM
    public static void main(String[] args) {


        AdminRepository adminRepository= new AdminRepository();

        Admin admin= new Admin();
        admin.setAd("test2");
        admin.setEmail("test2@gmail.com");
        admin.setGender(Gender.ERKEK);
        admin.setSoyad("tests2");
        admin.setPassword("testpass2");
        adminRepository.save(admin);

        AdminController controller= new AdminController();

        for(Admin a : controller.getAllAdminNative()){
            System.out.println(a.getAd()+", soyad:"+ a.getSoyad());
        }

    }



}