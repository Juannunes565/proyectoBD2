/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.JPanels;

import Classes.Group;
import Classes.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author mairo
 */
public class TaskPanel extends javax.swing.JPanel {
    static User currentUser;
    static Group currentGroup;
    static MongoClient client;
    
    public TaskPanel(String taskName, String groupName, MongoClient client) {
        initComponents();
        this.currentUser = currentUser;
        this.currentGroup = currentGroup;
        this.client = client;
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskLabel = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        groupLabel = new javax.swing.JLabel();

        taskLabel.setText("TaskLabel");

        view.setText("Ver");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        groupLabel.setText("GroupLabel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(view))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupLabel)
                            .addComponent(taskLabel))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(groupLabel)
                .addGap(18, 18, 18)
                .addComponent(taskLabel)
                .addGap(18, 18, 18)
                .addComponent(view)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        
        MongoDatabase dataBase = client.getDatabase("cowork");
        MongoCollection groups = dataBase.getCollection("groups");
        
        FindIterable<Document> groupDocs = groups.find();
        ArrayList<Document> allGroups = new ArrayList();
        
        for(Document groupDoc: groupDocs){            
            ArrayList<Document> auxMembers = (ArrayList<Document>) groupDoc.get("members");
            
            for(Document member: auxMembers){
                if(member.get("email").equals(currentUser.getEmail())){
                    allGroups.add(groupDoc);
                }
            }
        }
        
        for(Document groupDoc: allGroups){
            ArrayList<Document> tasksDocs = (ArrayList<Document>) groupDoc.get("tasks");
            
            for(Document tasksDoc: tasksDocs){
                
            }
        }
        
        
    }//GEN-LAST:event_viewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel taskLabel;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}