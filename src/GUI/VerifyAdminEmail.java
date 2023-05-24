package GUI;

import Model.Email;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;

import java.util.Random;
import javax.swing.JOptionPane;

public class VerifyAdminEmail extends javax.swing.JPanel {

    Color mouseOver = new Color(32, 32, 32, 220);
    Color mouseExit = new Color(0, 0, 0, 100);
    String charSet = "ab1c3de2fghi5jk8lmn4opq6rstuv97wx0yz";
    StringBuilder sb = new StringBuilder();
    Random rnd = new Random();
    String OTP;

    public VerifyAdminEmail() {
        initComponents();
        Color c = new Color(0, 0, 0, 60);
        setBackground(mouseExit);
        em.setBackground(c);
        cd.setBackground(c);
        sndCode.setBackground(mouseExit);
        verifybtn.setBackground(mouseExit);
        exitlbl.setBackground(mouseExit);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sndCode = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        verifybtn = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cd = new javax.swing.JTextField();
        exitlbl = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(270, 380));

        sndCode.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        sndCode.setForeground(new java.awt.Color(204, 204, 255));
        sndCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sndCode.setText("Send Verification Code");
        sndCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sndCode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sndCode.setOpaque(true);
        sndCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sndCodeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sndCodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sndCodeMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Verify Admin Email");
        jLabel5.setIconTextGap(0);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adm.png"))); // NOI18N
        jLabel10.setIconTextGap(0);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("Email :");

        em.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        em.setForeground(new java.awt.Color(204, 204, 255));
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });

        verifybtn.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        verifybtn.setForeground(new java.awt.Color(204, 204, 255));
        verifybtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verifybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lgbtn.png"))); // NOI18N
        verifybtn.setText("Verify");
        verifybtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        verifybtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verifybtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        verifybtn.setIconTextGap(14);
        verifybtn.setOpaque(true);
        verifybtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verifybtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verifybtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verifybtnMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Code :");

        cd.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        cd.setForeground(new java.awt.Color(204, 204, 255));
        cd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdActionPerformed(evt);
            }
        });

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

        status.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(204, 204, 255));
        status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        status.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verifybtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(exitlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cd)
                            .addComponent(em)
                            .addComponent(sndCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(status)))
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
                    .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sndCode)
                .addGap(6, 6, 6)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verifybtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitlbl)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        sndCodeMouseClicked(null);
    }//GEN-LAST:event_emActionPerformed

    private void verifybtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifybtnMouseClicked
        if (cd.getText().equals(OTP)) {
            LogIn.parentPanel.removeAll();
            LogIn.parentPanel.add(new AddAdmin(em.getText()));
            LogIn.parentPanel.repaint();
            LogIn.parentPanel.revalidate();
            LogIn.parentPanel.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "The Code you entered is invalid.", "Invalid Code", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_verifybtnMouseClicked

    private void verifybtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifybtnMouseEntered
        verifybtn.setBackground(mouseOver);
    }//GEN-LAST:event_verifybtnMouseEntered

    private void verifybtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verifybtnMouseExited
        verifybtn.setBackground(mouseExit);
    }//GEN-LAST:event_verifybtnMouseExited

    private void cdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdActionPerformed
        verifybtnMouseClicked(null);
    }//GEN-LAST:event_cdActionPerformed

    private void exitlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitlblMouseClicked

    private void exitlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseEntered
        exitlbl.setBackground(mouseOver);
    }//GEN-LAST:event_exitlblMouseEntered

    private void exitlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseExited
        exitlbl.setBackground(mouseExit);
    }//GEN-LAST:event_exitlblMouseExited

    private void sndCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sndCodeMouseEntered
        if (sndCode.isEnabled()) {
            sndCode.setBackground(mouseOver);
        }
    }//GEN-LAST:event_sndCodeMouseEntered

    private void sndCodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sndCodeMouseExited
        if (sndCode.isEnabled()) {
            sndCode.setBackground(mouseExit);
        }
    }//GEN-LAST:event_sndCodeMouseExited

    private void sndCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sndCodeMouseClicked
        if (sndCode.isEnabled()) {
            sndCode.setEnabled(false);
            String eml = em.getText().trim();
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
                        Email.sendMail(eml, "Ishara Auto Service & Motors", "Verification Code : " + OTP);
                        status.setText("Code sent.");
                        NotificationPanel.showNotification("Code Sent", "An OTP code has been sent to", eml, NotificationPanel.SUCCESS);
                        cd.grabFocus();
                        new Thread() {
                            @Override
                            public synchronized void run() {
                                for (int i = 30; i > 0; i--) {
                                    sndCode.setText("Re-send again in " + i + " sec.s");
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException ex) {
                                    }
                                }
                                sndCode.setText("Re-Send Verification Code");
                                sndCode.setEnabled(true);
                                sndCode.setBackground(mouseExit);
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
                        NotificationPanel.showNotification("Couldn't Send Code", "o", eml, NotificationPanel.ERROR);
                        sndCode.setEnabled(true);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_sndCodeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cd;
    private javax.swing.JTextField em;
    private javax.swing.JLabel exitlbl;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel sndCode;
    private javax.swing.JLabel status;
    private javax.swing.JLabel verifybtn;
    // End of variables declaration//GEN-END:variables
}
