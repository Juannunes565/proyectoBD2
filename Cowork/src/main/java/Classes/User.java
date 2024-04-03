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
    private ArrayList invitations;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.invitations = new ArrayList();
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

    public ArrayList getInvitations() {
        return invitations;
    }

    public void setInvitations(ArrayList invitations) {
        this.invitations = invitations;
    }
    
    

    
    
    
    
    
    
}
