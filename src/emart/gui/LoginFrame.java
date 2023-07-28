/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.gui;

import emart.dao.UserDao;
import emart.pojo.UserPojo;
import emart.pojo.UserProfile;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JFrame {

    String userid, password;

    public LoginFrame() {
        
        initComponents();
        this.setLocationRelativeTo(null);
    }


    
//    validating whether all the data has been properly filled or not
    public boolean validateInput() {

//       getting data from userid textfield , used getText() , return either empty string or returns the string which containes some character
        userid = txtUserId.getText();
//        getting data from password field , getPassword() is used , returns character array either it has some value or it doesn't have any value
        char arr[] = txtPassword.getPassword();
//        converting this character array into string
        password = String.valueOf(arr).trim();
        if (userid.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;

    }

//    validating whether user has selected usertype or not
    public String getUserType() {

//        if both of radioButtons are not selected , then we need to return
        if (!rdbManager.isSelected() && !rdbRecep.isSelected()) {
            return null;
        }

//        return selected radioButton
        if (rdbManager.isSelected()) {
            return rdbManager.getText();
        } else {
            return rdbRecep.getText();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdbManager = new javax.swing.JRadioButton();
        rdbRecep = new javax.swing.JRadioButton();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login Pannel");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User ID");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        txtUserId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUserId.setForeground(new java.awt.Color(255, 12, 241));

        jLabel4.setBackground(new java.awt.Color(199, 190, 190));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(194, 185, 194));
        jLabel4.setText("User Type");

        rdbManager.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbManager);
        rdbManager.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbManager.setText("Manager");
        rdbManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbManagerActionPerformed(evt);
            }
        });

        rdbRecep.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbRecep);
        rdbRecep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rdbRecep.setText("Receptionist");

        txtPassword.setForeground(new java.awt.Color(255, 12, 241));

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBack.setText("Back");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUserId)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(rdbManager)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbRecep)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbManager)
                    .addComponent(rdbRecep))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbManagerActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

//        validating whether all the data has been properly filled or not
        boolean ans = validateInput();
        if (ans == false) {
            JOptionPane.showMessageDialog(null, "Please fill all the details properly!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        verify whether userType has been selected or not
        String usertype = getUserType();
        if (usertype == null) {
            JOptionPane.showMessageDialog(null, "Please choose userType!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        creating UserPojo object
        UserPojo up = new UserPojo();

//        how many details we have till now we fill those details in UserPojo
        up.setUserId(userid);
        up.setPassword(password);
        up.setUserType(usertype);
//
//        System.out.println(up);
        
//        calling validateUser of DAO , since validateUser can throw exception , and if we are calling that then we should keep all the code related to validateUser() inside try and catch block
        try {

            ans = UserDao.validateUser(up);
            if (ans == false) {
                JOptionPane.showMessageDialog(null, "wrong userid/password/usertype!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            UserProfile.setUserId(userid);
            UserProfile.setUserType(usertype);
            
            if (usertype.equalsIgnoreCase("Manager")) {
//                if usertype is manager then we open manager frame , and for openeing manager frame we will make object of ManagerOptionFrame class
                ManagerOptionFrame mframe = new ManagerOptionFrame();
//            killing LoginFrame , and for killing LoginFrame we will call dispose() of LoginFrame
                this.dispose();
                mframe.setVisible(true);
            } else {
//            if usertype is receptionist then we open receptionist frame , and for openeing receptionist frame we will make object of ManageReceptionistFrame class
                ManageReceptionistFrame rframe = new ManageReceptionistFrame();
                this.dispose();
                rframe.setVisible(true);
            }
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "DB error", "Error", JOptionPane.ERROR_MESSAGE);
            sq.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdbManager;
    private javax.swing.JRadioButton rdbRecep;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
