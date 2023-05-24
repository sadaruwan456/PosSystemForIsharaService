/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Cryptography.Cryption;
import DB.DB;
import Model.Email;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author OLE
 */
public class verify_Email extends javax.swing.JFrame {

    String charSet = "ab1c3de2fghi5jk8lmn4opq6rstuv97wx0yz";
    StringBuilder sb = new StringBuilder();
    Random rnd = new Random();
    String OTP;
    String usr;
    Color mouseOver = new Color(32, 32, 32, 220);
    Color mouseExit = new Color(0, 0, 0, 100);
    public verify_Email() {
        initComponents();
        Color c = new Color(0, 0, 0, 0);
        Color c1 = new Color(0, 0, 0, 60);
        jPanel2.setBackground(mouseExit);
        jLabel3.setBackground(c);
        jLabel4.setBackground(c);
        jLabel5.setBackground(c);
        user_email.setBackground(c1);
        verifycode.setBackground(c1);
        sendCodeBtn.setBackground(mouseExit);
        jLabel6.setBackground(mouseExit);
        jLabel7.setBackground(mouseExit);

        jPanel3.setBackground(mouseExit);
        jLabel8.setBackground(c);
        jLabel9.setBackground(c);
        jLabel10.setBackground(c);
        jLabel11.setBackground(c);
        user_name.setBackground(c1);
        jPasswordField1.setBackground(c1);
        jPasswordField2.setBackground(c1);
        sendCodeBtn.setBackground(mouseExit);
        changePass.setBackground(mouseExit);
        close.setBackground(mouseExit);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        parentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        user_email = new javax.swing.JTextField();
        verifycode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sendCodeBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        changePass = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        status1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        parentPanel.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reset Password");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText("Enter Email :");
        jLabel4.setOpaque(true);

        user_email.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        user_email.setForeground(new java.awt.Color(204, 204, 255));
        user_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_emailActionPerformed(evt);
            }
        });

        verifycode.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        verifycode.setForeground(new java.awt.Color(204, 204, 255));
        verifycode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifycodeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Verify Code :");
        jLabel5.setOpaque(true);

        sendCodeBtn.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        sendCodeBtn.setForeground(new java.awt.Color(204, 204, 255));
        sendCodeBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendCodeBtn.setText("Send Verification Code");
        sendCodeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sendCodeBtn.setOpaque(true);
        sendCodeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendCodeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendCodeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendCodeBtnMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Next");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Close");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        status.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(204, 204, 255));
        status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        status.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(verifycode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendCodeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(user_email)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(status)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendCodeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verifycode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        parentPanel.add(jPanel2, "card2");

        jPanel3.setMinimumSize(new java.awt.Dimension(280, 380));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Set Password");
        jLabel8.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("User name :");
        jLabel9.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("New Password :");
        jLabel10.setOpaque(true);

        user_name.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        user_name.setForeground(new java.awt.Color(204, 204, 255));
        user_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        user_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        user_name.setOpaque(true);
        user_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_nameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                user_nameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                user_nameMouseExited(evt);
            }
        });

        changePass.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        changePass.setForeground(new java.awt.Color(204, 204, 255));
        changePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changePass.setText("Change Password");
        changePass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        changePass.setOpaque(true);
        changePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePassMouseExited(evt);
            }
        });

        close.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        close.setForeground(new java.awt.Color(204, 204, 255));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("Close");
        close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        close.setOpaque(true);
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });

        status1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        status1.setForeground(new java.awt.Color(204, 204, 255));
        status1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        status1.setText(" ");

        jPasswordField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N

        jPasswordField2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("Confirm New Password :");
        jLabel11.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(status1))
                    .addComponent(jLabel11)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePass, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(status1)))
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(changePass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        parentPanel.add(jPanel3, "card2");

        jPanel1.add(parentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/startup.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 674, 414));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_emailActionPerformed

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setBackground(mouseOver);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void sendCodeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendCodeBtnMouseEntered
        if (sendCodeBtn.isEnabled()) {
            sendCodeBtn.setBackground(mouseOver);
        }
    }//GEN-LAST:event_sendCodeBtnMouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setBackground(mouseOver);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void sendCodeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendCodeBtnMouseExited
        if (sendCodeBtn.isEnabled()) {
            sendCodeBtn.setBackground(mouseExit);
        }
    }//GEN-LAST:event_sendCodeBtnMouseExited

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setBackground(mouseExit);
    }//GEN-LAST:event_jLabel7MouseExited

    private void sendCodeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendCodeBtnMouseClicked
        if (sendCodeBtn.isEnabled()) {
            String eml = user_email.getText().trim();
            try {
                ResultSet r = DB.search("SELECT username, email FROM user INNER JOIN employee ON user.employee_nic = employee.nic WHERE email = '" + eml + "'");
                if (r.next()) {
                    sendCodeBtn.setEnabled(false);
                    usr = Cryption.decript(r.getString("username"));
                    user_name.setText(usr);
                    new Thread() {
                        @Override
                        public synchronized void run() {
                            try {
                                while (sb.length() < 6) {
                                    int index = (int) (rnd.nextFloat() * charSet.length());
                                    sb.append(charSet.charAt(index));
                                }
                                OTP = sb.toString();
                                status.setText("Sending Code...");
                                Email.sendMail(eml, "Ishara Auto Service & Motors", "Hi " + usr + ", Your One Time Password is : " + OTP);
                                status.setText("Code sent.");
                                NotificationPanel.showNotification("Code Sent", "An OTP code has been sent to", eml, NotificationPanel.SUCCESS);
                                verifycode.grabFocus();
                                new Thread() {
                                    @Override
                                    public synchronized void run() {
                                        for (int i = 30; i > 0; i--) {
                                            sendCodeBtn.setText("Re-send again in " + i + " sec.s");
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException ex) {
                                            }
                                        }
                                        sendCodeBtn.setText("Re-Send Verification Code");
                                        sendCodeBtn.setEnabled(true);
                                        sendCodeBtn.setBackground(mouseExit);
                                    }
                                }.start();
                            } catch (Exception ex) {
                                DecorationHelper.decorateWindows(true);
                                if (ex.getMessage().equals("Unknown SMTP host: smtp.gmail.com")) {
                                    JOptionPane.showMessageDialog(null, "Make sure this computer is connected to the Internet.", "Unable to connect to Mail Host", JOptionPane.INFORMATION_MESSAGE);
                                }
                                if (ex.getMessage().equals("Invalid Addresses")) {
                                    JOptionPane.showMessageDialog(null, "Make sure the E-mail address is correct.", "Invalid Email Address", JOptionPane.INFORMATION_MESSAGE);
                                }
                                DecorationHelper.decorateWindows(false);
                                status.setText("Code not sent.");
                                NotificationPanel.showNotification("Sending Failed", "Couldn't Send Code.", "Check your e-mail and connection.", NotificationPanel.ERROR);
                                sendCodeBtn.setEnabled(true);
                            }
                        }
                    }.start();
                } else {
                    DecorationHelper.decorateWindows(true);
                    JOptionPane.showMessageDialog(null, "There's no user by the Email Address you provided", "Invalid Email Address", JOptionPane.INFORMATION_MESSAGE);
                    DecorationHelper.decorateWindows(false);
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_sendCodeBtnMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (verifycode.getText().equals(OTP)) {
            jPanel2.setVisible(false);
            jPanel3.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "The code you entered is incorrect. Please try again.", "Invalid Code", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void user_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_nameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameMouseClicked

    private void user_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_nameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameMouseEntered

    private void user_nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_nameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameMouseExited

    private void changePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMouseClicked
        try {
            if (jPasswordField1.getText().equals(jPasswordField2.getText())) {
                DB.iud("UPDATE user SET password = '" + Cryption.encript(jPasswordField1.getText()) + "' WHERE username = '" + Cryption.encript(user_name.getText()) + "'");
                new LogIn().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Passwords", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_changePassMouseClicked

    private void changePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMouseEntered
        changePass.setBackground(mouseOver);
    }//GEN-LAST:event_changePassMouseEntered

    private void changePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassMouseExited
        changePass.setBackground(mouseExit);
    }//GEN-LAST:event_changePassMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        close.setBackground(mouseOver);
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        close.setBackground(mouseExit);
    }//GEN-LAST:event_closeMouseExited

    private void verifycodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifycodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verifycodeActionPerformed

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
                if ("numbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(verify_Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verify_Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verify_Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verify_Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verify_Email().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changePass;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JLabel sendCodeBtn;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status1;
    private javax.swing.JTextField user_email;
    private javax.swing.JLabel user_name;
    private javax.swing.JTextField verifycode;
    // End of variables declaration//GEN-END:variables
}
