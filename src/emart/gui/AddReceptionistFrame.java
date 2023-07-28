package emart.gui;

import emart.dao.ReceptionistDao;
import emart.pojo.UserPojo;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

public class AddReceptionistFrame extends javax.swing.JFrame {

//   we take a HashMap as a class level variable because it will be need in many places
    Map<String, String> receptionistMap;

    public AddReceptionistFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
//        now we make a method which will get a map(ID,name) and store id in our map
        loadReceptionistDetails();
    }

//////////////////////////////////////////////ValidateInput()//////////////////////////////////////////////////////////////////////////////
    public int validateInput() {
        if( pwdPassword.getPassword().length < 4 || pwdConfirmPassword.getPassword().length < 4 )
            return 0;
        else if( txtUserId.getText().trim().isEmpty() )
            return -1;
        else
            return 1;
    }
    public boolean isPasswordMatched(String pwdPassword , String pwdConfirmPassword){
        return pwdPassword.equals(pwdConfirmPassword);
    }
//////////////////////////////////////////////ValidateInput()//////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcID = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        txtUserId = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();
        pwdConfirmPassword = new javax.swing.JPasswordField();
        btnAddRecep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Receptionist Frame");

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Back");

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Logout");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee Details");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employee Name");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User ID");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Password");

        jcID.setBackground(new java.awt.Color(0, 0, 0));
        jcID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcID.setForeground(new java.awt.Color(255, 255, 255));
        jcID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcIDActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.setBackground(new java.awt.Color(0, 0, 0));
        txtName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));

        txtUserId.setBackground(new java.awt.Color(0, 0, 0));
        txtUserId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUserId.setForeground(new java.awt.Color(255, 255, 255));

        pwdPassword.setBackground(new java.awt.Color(0, 0, 0));
        pwdPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdPassword.setForeground(new java.awt.Color(255, 255, 255));

        pwdConfirmPassword.setBackground(new java.awt.Color(0, 0, 0));
        pwdConfirmPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));

        btnAddRecep.setBackground(new java.awt.Color(0, 0, 0));
        btnAddRecep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAddRecep.setForeground(new java.awt.Color(255, 255, 255));
        btnAddRecep.setText("Add");
        btnAddRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 141, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcID, 0, 131, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(pwdConfirmPassword)
                            .addComponent(pwdPassword)
                            .addComponent(txtUserId))))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(btnAddRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcIDActionPerformed
        if (jcID.getItemCount() == 0) {
            return;
        }
        txtName.setText(receptionistMap.get(jcID.getSelectedItem().toString()));
    }//GEN-LAST:event_jcIDActionPerformed

//////////////////////////////////////////////i made it/////////////////////////////////////////////////////////////////////////////////
    private void btnAddRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecepActionPerformed
        int result = validateInput();
        if( result == 0 ){
            JOptionPane.showMessageDialog(null, "Password length should be of minimum 4 characters!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if( result == -1 ) {
            JOptionPane.showMessageDialog(null, "Please fill all the details properly!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char pwd[] = pwdPassword.getPassword();
        char conPwd[] = pwdConfirmPassword.getPassword();
        String spwd = String.valueOf(pwd);
        String sconPwd = String.valueOf(conPwd);
        if( !isPasswordMatched(spwd,sconPwd) ) {
            JOptionPane.showMessageDialog(null, "Passwords are not matched!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            
            UserPojo user = new UserPojo();
            user.setEmpId(jcID.getSelectedItem().toString());
            user.setPassword(String.valueOf(pwdPassword.getPassword()));
            user.setUserId(txtUserId.getText().trim());
            user.setUserName(txtName.getText());
            user.setUserType("Receptionist");
            
            boolean ans = ReceptionistDao.addReceptionist(user);
            if( ans ){
                JOptionPane.showMessageDialog(null, "Reseptionist ragistered/added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearText();
                loadReceptionistDetails();
                return;
            }
            JOptionPane.showMessageDialog(null, "Reseptionist is not registered!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "Error in DB while adding receptionist", "Error", JOptionPane.ERROR_MESSAGE);
            sq.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnAddRecepActionPerformed
//////////////////////////////////////////////i made it/////////////////////////////////////////////////////////////////////////////////

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
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReceptionistFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReceptionistFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecep;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcID;
    private javax.swing.JPasswordField pwdConfirmPassword;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables

    private void loadReceptionistDetails() {
        try {
//             call dao class which return a map containing (ID,name) of un-registered receptionists
            receptionistMap = ReceptionistDao.getNonRegisteredReceptionists();

//            we check whether any unregistered receptionist is presented or not
            if (receptionistMap.size() == 0) {
//                if it's size is 0 means all the receptionists are registered in users table for using the app 
                JOptionPane.showMessageDialog(null, "All Receptionists are added successfully!", "Error", JOptionPane.ERROR_MESSAGE);
                btnAddRecep.setEnabled(false);
                return;
            }

//            if we came here means data came in receptionistMap , so now enable the button
            btnAddRecep.setEnabled(true);
//            now we iterate on receptionistMap

//            in receptionistMap we have id's and valus we and we don't need to iterate on values(Because we wanna add id's in the comboBox) , that's why here we use a hashmap's method called keyset , which returns us an object of set , why set? because set is a callection of unique values and id's are unique
            Set keys = receptionistMap.keySet();

//            now create iterator for traversing on keys
            Iterator<String> it = keys.iterator();
//            now remove all items from the comboBox
            jcID.removeAllItems();
//            iterate hasmap
            while (it.hasNext()) {
                jcID.addItem(it.next());
            }
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "Error in DB while adding receptionist", "Error", JOptionPane.ERROR_MESSAGE);
            sq.printStackTrace();
            return;
        }
    }

    private void clearText() {
        pwdPassword.setText("");
        pwdConfirmPassword.setText("");
        txtUserId.setText("");
    }
}
