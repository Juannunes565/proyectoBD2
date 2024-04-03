/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Classes.Group;
import Classes.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.bson.Document;

/**
 *
 * @author mairo
 */
public class ShowInvitations extends javax.swing.JPanel {
    User currentUser;     
    MongoClient client;
    
    public ShowInvitations(User currentUser, MongoClient client) {
        initComponents();
        setLayout(new GridBagLayout());
        this.currentUser = currentUser;        
        this.client = client;
        
        initInvitations();
    }
    
    private void initInvitations(){
        MongoDatabase dataBase = client.getDatabase("cowork");
        MongoCollection users = dataBase.getCollection("users");
        
        Document userDoc = (Document) users.find(new Document("email", currentUser.getEmail())).first();
        ArrayList<String> userInvitations = (ArrayList<String>) userDoc.get("invitations");          
        
        if(userInvitations != null){
            int i = 0;
            for(String invitation: userInvitations){
                System.out.println(invitation);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH; 
                gbc.insets = new Insets(5, 5, 5, 5);

                JPanel panel = createInvitationPanel(invitation);
                gbc.gridx = i % 4; 
                gbc.gridy = i / 4;
                add(panel, gbc);
                i++;                        
            }            
        }
        else{
            
        }                               
    }
    
    private JPanel createInvitationPanel(String invitation) {
        InvitationPanel panel = new InvitationPanel(currentUser, invitation, client);
        return panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
