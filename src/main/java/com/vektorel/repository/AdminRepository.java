package com.vektorel.repository;

import com.vektorel.entity.Admin;
import com.vektorel.entity.Gender;
import com.vektorel.util.DbConnection;

import java.util.List;
import java.util.Optional;

public class AdminRepository {
    private DbConnection dbConnection;

    public AdminRepository() {
        this.dbConnection = new DbConnection();
    }

    public void save(Admin admin){
        dbConnection.openSession();
        try {
            dbConnection.session.save(admin);
            dbConnection.closeSession();
        }catch (Exception e){
            e.printStackTrace();
            dbConnection.rollBack();
        }
    }

    public Optional<Admin> findById (long id){
        try {
            dbConnection.openSession();
            Optional<Admin> admin=Optional.of(dbConnection.session.find(Admin.class,id));
            dbConnection.closeSession();
            return admin;
        }catch (Exception e){
            dbConnection.rollBack();
            e.printStackTrace();
            return null;
        }
    }


    // SQL SORGUSU -> Native Sorgu
    public void findAllAdmin(){

        try {
            dbConnection.openSession();
            List<Admin> adminList=dbConnection.session
                   .createNativeQuery("select * from tbl_admin",Admin.class).getResultList();

            for (Admin a:adminList) {
                System.out.println(a.toString());
            }

            dbConnection.closeSession();

        }catch (Exception e){
            e.printStackTrace();
            dbConnection.rollBack();
        }


    }

    // HQL SORGUSU -> Hibernate Quary Langueage
    public void findAllAdmin2(){

        try {
            dbConnection.openSession();
            List<Admin> adminList = dbConnection.session
                    .createSelectionQuery("from Admin",Admin.class).getResultList();

            for (Admin a:adminList) {
                System.out.println(a.toString());
            }

            dbConnection.closeSession();


        }catch (Exception e){
            e.printStackTrace();
            dbConnection.rollBack();
        }


    }

}
