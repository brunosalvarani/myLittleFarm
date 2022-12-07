/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.javafxminiproject.model;

/**
 *
 * @author bruno
 */
public class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*
        TODO make a proper login interface and user system.
        TODO Login should verify username and passwords.
        TODO Login must have a way to create new "Admin" user, this action must be bound by a "key"
        TODO "Admin user" can create accounts for their employees.
        TODO Employee system, where they must have the required access to be allowed to use each and every part of the system.
        TODO Changes made by employees should be kept in a historyLog.

     */
}
