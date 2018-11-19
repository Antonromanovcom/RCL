package com.antonromanov.springhibernate.model;


public class User {

    private Long id;
    private String name;

    public User(String targetcompany) {

        this.name = targetcompany;
    }


    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}
