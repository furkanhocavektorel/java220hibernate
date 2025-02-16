package com.vektorel.repository;

import com.vektorel.entity.Admin;
import com.vektorel.entity.Gender;
import com.vektorel.util.DbConnection;

import java.util.ArrayList;
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
    public List<Admin> findAllAdmin(){
        try {
            dbConnection.openSession();
            List<Admin> adminList=dbConnection.session
                   .createNativeQuery("select * from admins",Admin.class).getResultList();

            dbConnection.closeSession();

            return adminList;
        }catch (Exception e){
            e.printStackTrace();
            dbConnection.rollBack();
            return new ArrayList<>();
        }


    }

    // HQL SORGUSU -> Hibernate Quary Langueage
    public List<Admin> findAllAdmin2(){

        try {
            dbConnection.openSession();
            List<Admin> adminList = dbConnection.session
                    // Admin -> Admins
                    .createSelectionQuery("from Admin",Admin.class).getResultList();

            dbConnection.closeSession();
            return adminList;

        }catch (Exception e){
            e.printStackTrace();
            dbConnection.rollBack();
            return new ArrayList<>();
        }
    }

}
