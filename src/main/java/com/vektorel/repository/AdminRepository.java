package com.vektorel.repository;

import com.vektorel.entity.Admin;
import com.vektorel.util.DbConnection;

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

}
