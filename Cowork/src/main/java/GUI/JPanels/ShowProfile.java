/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.JPanels;

import Classes.User;
import GUI.JFrames.Login;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.bson.Document;

/**
 *
 * @author mairo
 */
public class ShowProfile extends javax.swing.JPanel {
    User currentUser;
    MongoClient client;
    MongoCollection users;
    Document user;

    
    public ShowProfile(User currentUser, MongoClient client) {
        initComponents();        
        this.currentUser = currentUser;
        this.client = client;
        this.user = null;
        
        MongoDatabase dataBase = client.getDatabase("cowork");
        this.users = dataBase.getCollection("users");
        
        Document filter = new Document("email", currentUser.getEmail());
        this.user = (Document) users.find(filter).first();
        
        errorLabel.setText("");
        NameProfile.setText(this.currentUser.getName());
        EmailProfile.setText(this.currentUser.getEmail());
        PasswordProfile.setText((String) user.get("password"));
        
        
                        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NameProfile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        EmailProfile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordProfile = new javax.swing.JPasswordField();
        ButtomProfile = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(620, 470));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Correo Electronico");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        NameProfile.setEditable(false);
        NameProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameProfileActionPerformed(evt);
            }
        });
        add(NameProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 205, -1));

        jLabel2.setText("Nombre");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        EmailProfile.setEditable(false);
        EmailProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailProfileActionPerformed(evt);
            }
        });
        add(EmailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 205, -1));

        jLabel3.setText("Contrasena");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        PasswordProfile.setEditable(false);
        PasswordProfile.setText("jPasswordField1");
        add(PasswordProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 210, 20));

        ButtomProfile.setBackground(new java.awt.Color(243, 243, 243));
        ButtomProfile.setText("Editar Perfil");
        ButtomProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtomProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtomProfileActionPerformed(evt);
            }
        });
        add(ButtomProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 90, -1));

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("Error Label");
        add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        logOut.setBackground(new java.awt.Color(243, 243, 243));
        logOut.setText("Cerrar sesion");
        logOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        add(logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void NameProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameProfileActionPerformed

    private void EmailProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailProfileActionPerformed

    private void ButtomProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtomProfileActionPerformed
        errorLabel.setForeground(Color.red);
        errorLabel.setText("");
        
        String buttom = ButtomProfile.getText();
        if (buttom.equals("Editar Perfil")){
            NameProfile.setEditable(true);
            EmailProfile.setEditable(true);
            PasswordProfile.setEditable(true);
            PasswordProfile.setEchoChar((char) 0);
            ButtomProfile.setText("Guardar Cambios");
            
        }
        else if(buttom.equals("Guardar Cambios")){                        
            
            // Buscar si existe un documento con el correo proporcionada            
            if (user != null){
                
                String newName = NameProfile.getText();
                String newEmail = EmailProfile.getText();
                String newPassword = PasswordProfile.getText();
                
                if(newName.isBlank() || newEmail.isBlank() || newPassword.isBlank()){
                    errorLabel.setText("Error: ingrese todos los campos del formulario");
                }
                else if(!newEmail.contains("@gmail.com") && !newEmail.contains("@hotmail.com") && 
                        !newEmail.contains("@correo.unimet.edu.ve") && !newEmail.contains("@outlook.com")){
                    errorLabel.setText("Error: correo no valido");
                }
                else if(newPassword.length() < 8){
                    errorLabel.setText("Error: contraseña no valida, minimo 8 caracteres");
                }
                else{
                    Document filter = new Document("email", currentUser.getEmail());

                    currentUser.setName(NameProfile.getText());
                    currentUser.setEmail(EmailProfile.getText());

                    Document update = new Document("$set", new Document()
                        .append("name", currentUser.getName())
                        .append("email", currentUser.getEmail())
                        .append("password", PasswordProfile.getText()) 
                    );
                    
                    users.findOneAndUpdate(filter, update);
                    errorLabel.setForeground(Color.green);
                    errorLabel.setText("Cambios realizados con exito");
                    
                    NameProfile.setEditable(false);
                    EmailProfile.setEditable(false);
                    PasswordProfile.setEditable(false);
                    ButtomProfile.setText("Editar Perfil");
                }
                
                
            }else{
                errorLabel.setText("Error: no se encontro el usuario");
            }
            

            
            
            
            
        }
    }//GEN-LAST:event_ButtomProfileActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(ShowProfile.this);                
        parentFrame.dispose();
        new Login(client).setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtomProfile;
    private javax.swing.JTextField EmailProfile;
    private javax.swing.JTextField NameProfile;
    private javax.swing.JPasswordField PasswordProfile;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logOut;
    // End of variables declaration//GEN-END:variables
}
