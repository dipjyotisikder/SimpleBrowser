package com.example.dipjyoti.browser;

/**
 * Created by DIPJYOTI on 7/9/2017.
 */

public class DataTemp {

    private int id;
    private String name;
    private String day;


    public DataTemp(String n){

        name = n;
    }


    public void setId(int id) {

        this.id = id;
    }

    public int getId() {

        return id;
    }


    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
