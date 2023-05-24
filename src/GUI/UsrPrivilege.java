/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.Privilege;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Lakshan
 */
public class UsrPrivilege extends javax.swing.JDialog {

    /**
     * Creates new form UsrPrivilege
     */
    public UsrPrivilege(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        FrameIcon.setIcon(this);
        loadType();
    }

    public static UsrPrivilege o;
   public static UsrPrivilege getObject(){
       if(o==null){
           o= new UsrPrivilege(Home.getObject(), true);
       }
       return o;
   }
    
   private void loadType() {
       try {
            String qry = "SELECT type FROM user_type WHERE `type` <> 'Admin'";
            ResultSet rs = DB.search(qry);
            while (rs.next()) {
                userType.addItem(rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        coustomer = new javax.swing.JCheckBox();
        stock = new javax.swing.JCheckBox();
        employee = new javax.swing.JCheckBox();
        attendance = new javax.swing.JCheckBox();
        report = new javax.swing.JCheckBox();
        supplier = new javax.swing.JCheckBox();
        employeePayrol = new javax.swing.JCheckBox();
        loginhistory = new javax.swing.JCheckBox();
        manageaccount = new javax.swing.JCheckBox();
        settings = new javax.swing.JCheckBox();
        employeeManager = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        userType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Privilages", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        coustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        coustomer.setText("Coustomer");

        stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stock.setText("Stock");

        employee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employee.setText("Employee");
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });

        attendance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        attendance.setText("Attendance");

        report.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        report.setText("Report");

        supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supplier.setText("Supplier");

        employeePayrol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeePayrol.setText("Employee Payroll");

        loginhistory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginhistory.setText("Login History");

        manageaccount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        manageaccount.setText("Manage Account");

        settings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        settings.setText("Settings");

        employeeManager.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeeManager.setText("Employee Manager");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Save ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        userType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userTypeItemStateChanged(evt);
            }
        });
        userType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeActionPerformed(evt);
            }
        });
        userType.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                userTypePropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User Type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(report)
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(coustomer)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(attendance)
                                    .addComponent(stock))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(supplier))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(employeePayrol)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(employee)
                                    .addComponent(loginhistory))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(settings)
                                    .addComponent(employeeManager))
                                .addGap(50, 50, 50))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(manageaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock)
                    .addComponent(supplier)
                    .addComponent(employee)
                    .addComponent(employeeManager)
                    .addComponent(coustomer))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(report)
                    .addComponent(attendance)
                    .addComponent(employeePayrol)
                    .addComponent(loginhistory)
                    .addComponent(settings))
                .addGap(18, 18, 18)
                .addComponent(manageaccount)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(coustomer.isSelected()){
            Privilege.getObject().coustomerval=true;
        }else{
            Privilege.getObject().coustomerval=false;
        }

        if(stock.isSelected()){
            Privilege.getObject().stockval=true;
        }else{
            Privilege.getObject().stockval=false;
        }

        if(supplier.isSelected()){
            Privilege.getObject().supplierval=true;
        }else{
            Privilege.getObject().supplierval=false;
        }

        if(employee.isSelected()){
            Privilege.getObject().employeeval=true;
        }else{
            Privilege.getObject().employeeval=false;
        }

        if(employeeManager.isSelected()){
            Privilege.getObject().employeeManagerval=true;

        }else{
            Privilege.getObject().employeeManagerval=false;
        }

        if(report.isSelected()){
            Privilege.getObject().reportval = true;
        }else{
            Privilege.getObject().reportval = false;
        }

        if(attendance.isSelected()){
            Privilege.getObject().attendanceval = true;
        }else{
            Privilege.getObject().attendanceval = false;
        }

        if(employeePayrol.isSelected()){
            Privilege.getObject().employeePayrollval=true;
        }else{
            Privilege.getObject().employeePayrollval=false;
        }

        if(loginhistory.isSelected()){
            Privilege.getObject().loginHistoryval=true;
        }else{
            Privilege.getObject().loginHistoryval=false;
        }

        if(settings.isSelected()){
            Privilege.getObject().settingsval=true;
        }else{
            Privilege.getObject().settingsval=false;
        }

        if(manageaccount.isSelected()){
            Privilege.getObject().manageAccountval=true;
        }else{
            Privilege.getObject().manageAccountval=false;
        }
        Privilege.getObject().SaveObject(userType.getSelectedItem().toString());
        JOptionPane.showMessageDialog(this,"Successfully Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);

       this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void userTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userTypeItemStateChanged
        String type = userType.getSelectedItem().toString();
        Privilege.getObject().loadObject(type);
        // Customer
        if(Privilege.getObject().coustomerval){
            coustomer.setSelected(true);
        }else{
            coustomer.setSelected(false);
        }
        // stock
        if(Privilege.getObject().stockval){
            stock.setSelected(true);
        }else{
            stock.setSelected(false);
        }
        // Supplier
        if(Privilege.getObject().supplierval){
            supplier.setSelected(true);
        }else{
            supplier.setSelected(false);
        }
        //Employee
        if(Privilege.getObject().employeeval){
            employee.setSelected(true);
        }else{
            employee.setSelected(false);
        }
        //Employee Manager
        if(Privilege.getObject().employeeManagerval){
            employeeManager.setSelected(true);
        }else{
            employeeManager.setSelected(false);
        }
        //Report
        if(Privilege.getObject().reportval){
            report.setSelected(true);
        }else{
            report.setSelected(false);
        }
        //Attendance
        if(Privilege.getObject().attendanceval){
            attendance.setSelected(true);
        }else{
            attendance.setSelected(false);
        }
        //EmployeePayrol
        if(Privilege.getObject().employeePayrollval){
            employeePayrol.setSelected(true);
        }else{
            employeePayrol.setSelected(false);
        }
        // Login History
        if(Privilege.getObject().loginHistoryval){
            loginhistory.setSelected(true);
        }else{
            loginhistory.setSelected(false);
        }
        //Settings
        if(Privilege.getObject().settingsval){
            settings.setSelected(true);
        }else{
            settings.setSelected(false);
        }
        //manage Account
        if(Privilege.getObject().manageAccountval){
            manageaccount.setSelected(true);
        }else{
            manageaccount.setSelected(false);
        }
    }//GEN-LAST:event_userTypeItemStateChanged

    private void userTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeActionPerformed
        if(new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\'"+userType.getSelectedItem().toString()+"'.cfg").exists()) {
            Privilege.getObject().loadObject(userType.getSelectedItem().toString());
            if(Privilege.getObject().coustomerval==true){
                coustomer.setSelected(true);
            }if(Privilege.getObject().stockval==true){
                stock.setSelected(true);
            }if(Privilege.getObject().supplierval==true){
                supplier.setSelected(true);
            }if(Privilege.getObject().employeeval==true){
                employee.setSelected(true);
            }if(Privilege.getObject().employeeManagerval==true){
                employeeManager.setSelected(true);
            }if(Privilege.getObject().reportval==true){
                report.setSelected(true);
            }if(Privilege.getObject().attendanceval==true){
                attendance.setSelected(true);
            }if(Privilege.getObject().employeePayrollval==true){
                employeePayrol.setSelected(true);
            }if(Privilege.getObject().loginHistoryval==true){
                loginhistory.setSelected(true);
            }if(Privilege.getObject().settingsval==true){
                settings.setSelected(true);
            }if(Privilege.getObject().manageAccountval==true){
                manageaccount.setSelected(true);
            }
        }
    }//GEN-LAST:event_userTypeActionPerformed

    private void userTypePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_userTypePropertyChange

    }//GEN-LAST:event_userTypePropertyChange

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
            java.util.logging.Logger.getLogger(UsrPrivilege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsrPrivilege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsrPrivilege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsrPrivilege.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsrPrivilege dialog = new UsrPrivilege(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox attendance;
    private javax.swing.JCheckBox coustomer;
    private javax.swing.JCheckBox employee;
    private javax.swing.JCheckBox employeeManager;
    private javax.swing.JCheckBox employeePayrol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox loginhistory;
    private javax.swing.JCheckBox manageaccount;
    private javax.swing.JCheckBox report;
    private javax.swing.JCheckBox settings;
    private javax.swing.JCheckBox stock;
    private javax.swing.JCheckBox supplier;
    private javax.swing.JComboBox<String> userType;
    // End of variables declaration//GEN-END:variables
}
