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

        System.out.println("**************");
        System.out.println("***** SQL ****");

        adminRepository.findAllAdmin();

        System.out.println("**************");
        System.out.println("***** HQL ****");

        adminRepository.findAllAdmin2();
    }



}