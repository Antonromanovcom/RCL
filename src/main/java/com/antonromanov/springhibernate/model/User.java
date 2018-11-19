package com.antonromanov.springhibernate.model;


public class User {


    private Long id;
    private String name;
    public User() {
       this.name = "Vvvv";
    }

    public User(String targetcompany) {

        this.name = targetcompany;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
