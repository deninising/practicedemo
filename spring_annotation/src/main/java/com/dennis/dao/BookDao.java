package com.dennis.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private String lab = "1";


    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }


    @Override
    public String toString() {
        return "BookDao{" +
                "lab='" + lab + '\'' +
                '}';
    }
}
