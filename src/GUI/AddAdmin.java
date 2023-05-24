package GUI;

import Cryptography.Cryption;
import DB.DB;
import Model.Settings;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import javax.swing.JOptionPane;

public class AddAdmin extends javax.swing.JPanel {

    Color mouseOver = new Color(32, 32, 32, 220);
    Color mouseExit = new Color(0, 0, 0, 100);
    String eml;

    public AddAdmin(String eml) {
        initComponents();
        Color c = new Color(0, 0, 0, 60);
        setBackground(mouseExit);
        uname.setBackground(c);
        pw.setBackground(c);
        pw1.setBackground(c);
        loginlbl.setBackground(mouseExit);
        exitlbl.setBackground(mouseExit);
        this.eml = eml;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        loginlbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        exitlbl = new javax.swing.JLabel();
        pw1 = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(270, 380));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Create Admin Account");
        jLabel5.setIconTextGap(0);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adm.png"))); // NOI18N
        jLabel10.setIconTextGap(0);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("Username :");

        uname.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        uname.setForeground(new java.awt.Color(204, 204, 255));
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setText("Password :");

        pw.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        pw.setForeground(new java.awt.Color(204, 204, 255));
        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });

        loginlbl.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        loginlbl.setForeground(new java.awt.Color(204, 204, 255));
        loginlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lgbtn.png"))); // NOI18N
        loginlbl.setText("Create Account");
        loginlbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        loginlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginlbl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        loginlbl.setIconTextGap(14);
        loginlbl.setOpaque(true);
        loginlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginlblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginlblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginlblMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Confirm :");

        exitlbl.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        exitlbl.setForeground(new java.awt.Color(204, 204, 255));
        exitlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        exitlbl.setText("Close");
        exitlbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        exitlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitlbl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        exitlbl.setIconTextGap(14);
        exitlbl.setOpaque(true);
        exitlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitlblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitlblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitlblMouseExited(evt);
            }
        });

        pw1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        pw1.setForeground(new java.awt.Color(204, 204, 255));
        pw1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pw1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uname)
                            .addComponent(pw)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(exitlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(19, 19, 19)
                        .addComponent(pw1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitlbl)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        pw.grabFocus();
    }//GEN-LAST:event_unameActionPerformed

    private void loginlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseClicked
        if (!(uname.getText().equals("") || pw.getText().equals("") || pw1.getText().equals(""))) {
            if (pw.getText().equals(pw1.getText())) {
                try {
                    DB.iud("INSERT INTO employee VALUES('0', '', '', '', '', '', 0, 1, '', '" + eml + "', '', 1)");
                    DB.iud("INSERT INTO user(username, password, user_type_id, employee_nic) VALUES('" + Cryption.encript(uname.getText()) + "', '" + Cryption.encript(pw1.getText()) + "', '1', '0')");
                    Settings.saveSettings();
                    LogIn.parentPanel.removeAll();
                    LogIn.parentPanel.add(LogIn.jPanel2);
                    LogIn.parentPanel.repaint();
                    LogIn.parentPanel.revalidate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                DecorationHelper.decorateWindows(true);
                JOptionPane.showMessageDialog(null, "Passwords don't match.", "Try Again", JOptionPane.INFORMATION_MESSAGE);
                DecorationHelper.decorateWindows(false);
            }
        } else {
            DecorationHelper.decorateWindows(true);
            JOptionPane.showMessageDialog(null, "You can't leave any criterion empty.", "Empty Values", JOptionPane.INFORMATION_MESSAGE);
            DecorationHelper.decorateWindows(false);
        }
    }//GEN-LAST:event_loginlblMouseClicked

    private void loginlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseEntered
        loginlbl.setBackground(mouseOver);
    }//GEN-LAST:event_loginlblMouseEntered

    private void loginlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseExited
        loginlbl.setBackground(mouseExit);
    }//GEN-LAST:event_loginlblMouseExited

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        pw1.grabFocus();
    }//GEN-LAST:event_pwActionPerformed

    private void exitlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitlblMouseClicked

    private void exitlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseEntered
        exitlbl.setBackground(mouseOver);
    }//GEN-LAST:event_exitlblMouseEntered

    private void exitlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseExited
        exitlbl.setBackground(mouseExit);
    }//GEN-LAST:event_exitlblMouseExited

    private void pw1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pw1ActionPerformed
        loginlblMouseClicked(null);
    }//GEN-LAST:event_pw1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitlbl;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel loginlbl;
    private javax.swing.JPasswordField pw;
    private javax.swing.JPasswordField pw1;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
