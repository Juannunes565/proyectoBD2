/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Classes.Group;
import Classes.User;
import com.mongodb.client.MongoClient;


public class GroupPanel extends javax.swing.JPanel {
    User currentUser; 
    Group currentGroup;
    MongoClient client;
    
    public GroupPanel(User currentUser, Group currentGroup, MongoClient client) {
        initComponents();
        this.currentUser = currentUser;
        this.currentGroup = currentGroup;
        this.client = client;
         
        setBackground(currentGroup.getColorGroup());
        setForeground(currentGroup.getColorGroup());
        groupName.setText(currentGroup.getNameGroup());        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupName = new javax.swing.JLabel();
        viewGroup = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder());

        groupName.setText("name");

        viewGroup.setBackground(new java.awt.Color(252, 252, 252));
        viewGroup.setText("ver");
        viewGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(viewGroup))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(groupName)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(groupName)
                .addGap(40, 40, 40)
                .addComponent(viewGroup)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGroupActionPerformed
        new GroupView(currentUser, currentGroup, client).setVisible(true);
    }//GEN-LAST:event_viewGroupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupName;
    private javax.swing.JButton viewGroup;
    // End of variables declaration//GEN-END:variables
}