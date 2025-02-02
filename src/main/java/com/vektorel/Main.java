package com.vektorel;


import com.vektorel.controller.AdminController;
import com.vektorel.entity.Admin;
import com.vektorel.entity.Customer;
import com.vektorel.util.DbConnection;

public class Main {

    // FRONT SIM
    public static void main(String[] args) {

        AdminController adminController= new AdminController();
       // adminController.save("test@gmail.com","testtest");

        Admin admin= adminController.findById(1);

        System.out.println(admin.ozellikGetir());


    }



}