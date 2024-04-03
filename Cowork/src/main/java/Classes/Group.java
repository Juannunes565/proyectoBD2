/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.Color;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author mairo
 */
public class Group {
    private String nameGroup;
    private String LeaderEmail;
    private ArrayList<Document> members;
    private ArrayList<Document> tasks;
    private Color colorGroup;

    public Group(String groupName, String LeaderEmail, ArrayList<Document> members, ArrayList<Document> tasks, Color groupColor) {
        this.nameGroup = groupName;
        this.LeaderEmail = LeaderEmail;
        this.members = members;
        this.tasks = tasks;
        this.colorGroup = groupColor;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getLeaderEmail() {
        return LeaderEmail;
    }

    public void setLeaderEmail(String LeaderEmail) {
        this.LeaderEmail = LeaderEmail;
    }

    public ArrayList<Document> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Document> members) {
        this.members = members;
    }    

    public Color getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(Color colorGroup) {
        this.colorGroup = colorGroup;
    }

    public ArrayList<Document> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Document> tasks) {
        this.tasks = tasks;
    }
    

    @Override
    public String toString() {
        return "Group{" + "nameGroup=" + nameGroup + ", LeaderEmail=" + LeaderEmail + ", members=" + members + ", tasks=" + tasks + ", colorGroup=" + colorGroup + '}';
    }
    
    
    
    
    
}
