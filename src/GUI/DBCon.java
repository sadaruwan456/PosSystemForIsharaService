package GUI;

import Cryptography.Cryption;
import DB.DB;
import Model.Settings;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DBCon extends javax.swing.JPanel {

    Color mouseOver = new Color(32, 32, 32, 220);
    Color mouseExit = new Color(0, 0, 0, 100);
    Connection c;
    JFileChooser fc;

    public DBCon() {
        initComponents();
        Color c = new Color(0, 0, 0, 60);
        setBackground(mouseExit);
        host.setBackground(c);
        uname.setBackground(c);
        pw.setBackground(c);
        port.setBackground(c);
        loginlbl.setBackground(mouseExit);
        exitlbl.setBackground(mouseExit);
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
        port = new javax.swing.JTextField();
        exitlbl = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(270, 380));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Setup MySQL Connection");
        jLabel5.setIconTextGap(0);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/db.png"))); // NOI18N
        jLabel10.setIconTextGap(0);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("Username :");

        uname.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        uname.setForeground(new java.awt.Color(204, 204, 255));
        uname.setText("root");
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
        loginlbl.setText("Connect");
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
        jLabel9.setText("Port :");

        port.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        port.setForeground(new java.awt.Color(204, 204, 255));
        port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portActionPerformed(evt);
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
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText(" ");

        host.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        host.setForeground(new java.awt.Color(204, 204, 255));
        host.setText("localhost");
        host.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("Host :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(port))
                    .addComponent(exitlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(host, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(uname)
                            .addComponent(pw))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
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
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitlbl)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        pw.grabFocus();
    }//GEN-LAST:event_unameActionPerformed

    private void loginlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseClicked
        if (loginlbl.isEnabled()) {
            String h = host.getText();
            String u = uname.getText();
            String ps = pw.getText();
            String prt = port.getText();
            if (loginlbl.getText().equals("Connect")) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            if (!(u.equals("") || ps.equals("") || prt.equals(""))) {
                                loginlbl.setEnabled(false);
                                status.setText("Connecting...");
                                Class.forName("com.mysql.jdbc.Driver");
                                c = DriverManager.getConnection("jdbc:mysql://" + h + ":" + prt + "/", u, ps);
                                status.setText("Connection OK.");
                                Settings.getObject().host = Cryption.encript(h);
                                Settings.getObject().user = Cryption.encript(u);
                                Settings.getObject().pass = Cryption.encript(ps);
                                Settings.getObject().port = Cryption.encript(prt);
                                loginlbl.setText("Next");
                            }
                        } catch (SQLException e) {
                            status.setText("Connection Failed.");
                        } catch (Exception e) {
                            status.setText("Couldn't build Database.");
                        }
                        loginlbl.setEnabled(true);
                    }
                }.start();
            } else {
                loginlbl.setEnabled(false);
                new Thread() {
                    public void run() {
                        try {
                            ResultSet r = c.createStatement().executeQuery("SELECT SCHEMA_NAME FROM information_schema.SCHEMATA WHERE SCHEMA_NAME = 'ishara_service'");
                            if (r.next()) {
                                if (isBackupConfigured()) {
                                    m();
                                } else {
                                    if (fc == null) {
                                        fc = new JFileChooser();
                                        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                        fc.setAcceptAllFileFilterUsed(false);
                                    }
                                    DecorationHelper.decorateWindows(true);
                                    if (fc.showDialog(null, "Set Backup Path") == JFileChooser.APPROVE_OPTION) {
                                        File f = fc.getSelectedFile();
                                        String sysRoot = new File(System.getenv("SystemRoot")).getAbsolutePath().substring(0, 3);
                                        String fRoot = f.getAbsolutePath().substring(0, 3);
                                        if (fRoot.equals(sysRoot)) {
                                            JOptionPane.showMessageDialog(null, "You can't choose the system partition to save your backup.", "Choose another path", JOptionPane.INFORMATION_MESSAGE);
                                            loginlbl.setEnabled(true);
                                            loginlblMouseClicked(null);
                                        } else if (fc.getFileSystemView().getSystemTypeDescription(new File(fRoot)).equals("Local Disk")) {
                                            if (JOptionPane.showConfirmDialog(null, "The path you selected is on a Local Disk.\nIf your local hard disk was to fail, you won't be able to\nrecover your backup data.\n\nDo you want to Continue ?", "Local Disk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                                                Settings.getObject().backupPath = f.getAbsolutePath();
                                                m();
                                            } else {
                                                loginlbl.setEnabled(true);
                                                loginlblMouseClicked(null);
                                            }
                                        } else {
                                            Settings.getObject().backupPath = f.getAbsolutePath();
                                            m();
                                        }
                                        DecorationHelper.decorateWindows(false);
                                    } else {
                                        loginlbl.setEnabled(true);
                                    }
                                }
                            } else {
                                LogIn.parentPanel.removeAll();
                                LogIn.parentPanel.add(new SelectBackup(c, h, u, ps, prt));
                                LogIn.parentPanel.repaint();
                                LogIn.parentPanel.revalidate();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        }
    }//GEN-LAST:event_loginlblMouseClicked

    boolean isBackupConfigured() {
        if (Settings.getObject().backupPath == null) {
            return false;
        } else {
            File f = new File(Settings.getObject().backupPath);
            return f.exists();
        }
    }

    void m() throws SQLException, ClassNotFoundException {
        ResultSet r = c.createStatement().executeQuery("SELECT @@basedir");
        r.next();
        Settings.getObject().mySqlPath = (r.getString(1) + "bin\\mysql.exe");
        Settings.getObject().mySqlDumpPath = (r.getString(1) + "bin\\mysqldump.exe");
        r = DB.search("SELECT id FROM user WHERE employee_nic = '0'");
        if (r.next()) {
            Settings.saveSettings();
            LogIn.parentPanel.removeAll();
            LogIn.parentPanel.add(LogIn.jPanel2);
            LogIn.parentPanel.repaint();
            LogIn.parentPanel.revalidate();
        } else {
            LogIn.parentPanel.removeAll();
            LogIn.parentPanel.add(new VerifyAdminEmail());
            LogIn.parentPanel.repaint();
            LogIn.parentPanel.revalidate();
        }
    }

    private void loginlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseEntered
        loginlbl.setBackground(mouseOver);
    }//GEN-LAST:event_loginlblMouseEntered

    private void loginlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseExited
        loginlbl.setBackground(mouseExit);
    }//GEN-LAST:event_loginlblMouseExited

    private void portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portActionPerformed
        loginlblMouseClicked(null);
    }//GEN-LAST:event_portActionPerformed

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        port.grabFocus();
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

    private void hostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostActionPerformed
        uname.grabFocus();
    }//GEN-LAST:event_hostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitlbl;
    private javax.swing.JTextField host;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel loginlbl;
    private javax.swing.JTextField port;
    private javax.swing.JPasswordField pw;
    private javax.swing.JLabel status;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
