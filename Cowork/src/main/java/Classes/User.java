/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author mairo
 */
public class User {
    private String name;
    private String email;
    private ArrayList<Group> groups;
    private ArrayList<Task> tasks;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.groups = new ArrayList<Group>();
        this.tasks = new ArrayList<Task>();
    }

    public User(String name, String email, ArrayList<Group> groups, ArrayList<Task> tasks) {
        this.name = name;
        this.email = email;
        this.groups = groups;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
    
    
    
}
