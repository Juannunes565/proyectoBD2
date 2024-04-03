/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.JFrames;

import Classes.Group;
import Classes.User;
import static GUI.JFrames.TaskDialog.client;
import static GUI.JFrames.TaskDialog.currentGroup;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.Color;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author mairo
 */
public class TaskDialog extends javax.swing.JFrame {
    int xMouse, yMouse;
    static User currentUser;
    static Group currentGroup;
    static MongoClient client;
    
    
    public TaskDialog(User currentUser, Group currentGroup, MongoClient client) {
        initComponents();
        exit.setFocusable(false);
        minimize.setFocusable(false);
        
        this.currentUser = currentUser;
        this.currentGroup = currentGroup;
        this.client = client;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputTaskName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputDescription = new javax.swing.JTextArea();
        create = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(246, 246, 246));
        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(252, 252, 252));
        exit.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        exit.setText("X");
        exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        header.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        minimize.setBackground(new java.awt.Color(252, 252, 252));
        minimize.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        minimize.setText("-");
        minimize.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        header.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, 20));
        background.add(inputTaskName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 280, -1));

        inputDescription.setColumns(20);
        inputDescription.setRows(5);
        jScrollPane1.setViewportView(inputDescription);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 280, 110));

        create.setText("Crear");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        background.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error Label");
        background.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        exit.setBackground(Color.red);
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setBackground(Color.red);
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setBackground(new Color(252, 252, 252));
    }//GEN-LAST:event_exitMouseExited

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        minimize.setBackground(new Color(235, 235, 235));
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        minimize.setBackground(new Color(252, 252, 252));
    }//GEN-LAST:event_minimizeMouseExited

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
       String taskName = inputTaskName.getText();
        String description = inputDescription.getText();
        
        if(taskName.isBlank() || description.isBlank()){
            errorLabel.setText("Error: Ingrese todos los datos del formulario");
        }
        else{
            
            MongoDatabase dataBase = client.getDatabase("cowork");
            MongoCollection groups = dataBase.getCollection("groups");
            MongoCollection tasks = dataBase.getCollection("tasks");
            String idTask = Integer.toString(((int) tasks.countDocuments()));
            
            Document group = (Document) groups.find(new Document("nameGroup", currentGroup.getNameGroup()));
            if(group != null){
                
                ArrayList groupTasks = (ArrayList) group.get("tasks");
                
                Document newTask = new Document("idTask", idTask)
                        .append("taskName", taskName)
                        .append("description", description);   
                
                groupTasks.add(newTask);
                
                tasks.insertOne(newTask);
                
                Document update = new Document("$set", newTask);
                groups.updateOne(new Document("nameGroup", currentGroup.getNameGroup()), update);
                
            }
            else{
                errorLabel.setText("Grupo no encontrado");
            }
            
            
                
            
            
            
            
        }
    }//GEN-LAST:event_createActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskDialog(currentUser, currentGroup, client).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton create;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton exit;
    private javax.swing.JPanel header;
    private javax.swing.JTextArea inputDescription;
    private javax.swing.JTextField inputTaskName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton minimize;
    // End of variables declaration//GEN-END:variables
}
