package GUI;

import Cryptography.Cryption;
import DB.DB;
import Model.Settings;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SelectBackup extends javax.swing.JPanel {

    Color mouseOver = new Color(32, 32, 32, 220);
    Color mouseExit = new Color(0, 0, 0, 100);
    JFileChooser fc;
    Connection con;
    String h;
    String u;
    String ps;
    String prt;

    public SelectBackup(Connection con, String h, String u, String ps, String prt) {
        initComponents();
        this.h = h;
        this.con = con;
        this.u = u;
        this.ps = ps;
        this.prt = prt;
        Color c = new Color(0, 0, 0, 60);
        setBackground(mouseExit);
        loginlbl.setBackground(mouseExit);
        exitlbl.setBackground(mouseExit);
        createDB.setBackground(mouseExit);
        restoreDB.setBackground(mouseExit);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        createDB = new javax.swing.JLabel();
        loginlbl = new javax.swing.JLabel();
        exitlbl = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        restoreDB = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(270, 380));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Build Database");
        jLabel5.setIconTextGap(0);

        createDB.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        createDB.setForeground(new java.awt.Color(204, 204, 255));
        createDB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dbdown.png"))); // NOI18N
        createDB.setText("Create an empty Database");
        createDB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        createDB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createDB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createDB.setIconTextGap(0);
        createDB.setOpaque(true);
        createDB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createDBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createDBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createDBMouseExited(evt);
            }
        });

        loginlbl.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        loginlbl.setForeground(new java.awt.Color(204, 204, 255));
        loginlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lgbtn.png"))); // NOI18N
        loginlbl.setText("Next");
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

        restoreDB.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        restoreDB.setForeground(new java.awt.Color(204, 204, 255));
        restoreDB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restoreDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dbup.png"))); // NOI18N
        restoreDB.setText("Restore from a previous Backup");
        restoreDB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        restoreDB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restoreDB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        restoreDB.setIconTextGap(0);
        restoreDB.setOpaque(true);
        restoreDB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        restoreDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restoreDBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restoreDBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restoreDBMouseExited(evt);
            }
        });

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
                    .addComponent(createDB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(exitlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restoreDB, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createDB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restoreDB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitlbl))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseClicked
        if (status.getText().equals("Database built.") || status.getText().equals("Database Restored.") || status.getText().equals("Backup Restored.")) {
            DecorationHelper.decorateWindows(true);
            if (fc == null) {
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setAcceptAllFileFilterUsed(false);
            }
            if (fc.showDialog(null, "Set Backup Path") == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                String sysRoot = new File(System.getenv("SystemRoot")).getAbsolutePath().substring(0, 3);
                String fRoot = f.getAbsolutePath().substring(0, 3);
                if (fRoot.equals(sysRoot)) {
                    JOptionPane.showMessageDialog(this, "You can't choose the system partition to save your backup.", "Choose another path", JOptionPane.INFORMATION_MESSAGE);
                    loginlblMouseClicked(null);
                } else if (fc.getFileSystemView().getSystemTypeDescription(new File(fRoot)).equals("Local Disk")) {
                    if (JOptionPane.showConfirmDialog(this, "The path you selected is on a Local Disk.\nIf your local hard disk was to fail, you won't be able to\nrecover your backup data.\n\nDo you want to Continue ?", "Local Disk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                        m(f);
                    } else {
                        loginlblMouseClicked(null);
                    }
                } else {
                    m(f);
                }
                DecorationHelper.decorateWindows(false);
            }
        }
    }//GEN-LAST:event_loginlblMouseClicked

    void m(File f) {
        Settings.getObject().backupPath = f.getAbsolutePath();
        try {
            ResultSet r = DB.search("SELECT id FROM user WHERE employee_nic = '0'");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseEntered
        loginlbl.setBackground(mouseOver);
    }//GEN-LAST:event_loginlblMouseEntered

    private void loginlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseExited
        loginlbl.setBackground(mouseExit);
    }//GEN-LAST:event_loginlblMouseExited

    private void exitlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitlblMouseClicked

    private void exitlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseEntered
        exitlbl.setBackground(mouseOver);
    }//GEN-LAST:event_exitlblMouseEntered

    private void exitlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseExited
        exitlbl.setBackground(mouseExit);
    }//GEN-LAST:event_exitlblMouseExited

    private void createDBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createDBMouseEntered
        if (createDB.isEnabled()) {
            createDB.setBackground(mouseOver);
        }
    }//GEN-LAST:event_createDBMouseEntered

    private void restoreDBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreDBMouseEntered
        if (restoreDB.isEnabled()) {
            restoreDB.setBackground(mouseOver);
        }
    }//GEN-LAST:event_restoreDBMouseEntered

    private void createDBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createDBMouseExited
        if (createDB.isEnabled()) {
            createDB.setBackground(mouseExit);
        }
    }//GEN-LAST:event_createDBMouseExited

    private void restoreDBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreDBMouseExited
        if (restoreDB.isEnabled()) {
            restoreDB.setBackground(mouseExit);
        }
    }//GEN-LAST:event_restoreDBMouseExited

    private void createDBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createDBMouseClicked
        if (createDB.isEnabled()) {
            createDB.setEnabled(false);
            restoreDB.setEnabled(false);
            createDB.setBackground(mouseExit);
            restoreDB.setBackground(mouseExit);
            new Thread() {
                public void run() {
                    try {
                        status.setText("Building Database...");
                        ResultSet r = con.createStatement().executeQuery("SELECT @@basedir");
                        r.next();
                        String path = (r.getString(1) + "bin\\mysql.exe");
                        String s = (System.getProperty("user.dir") + "\\EmptyDB.sql");
                        String[] cmd = new String[]{path, "--user=" + u, "--password=" + ps, "-e", "source " + s};
                        Process runtimeProcess;
                        runtimeProcess = Runtime.getRuntime().exec(cmd);
                        int processComplete = runtimeProcess.waitFor();
                        if (processComplete == 0) {
                            status.setText("Database built.");
                            Settings.getObject().mySqlPath = path;
                            Settings.getObject().mySqlDumpPath = (r.getString(1) + "bin\\mysqldump.exe");
                        } else {
                            status.setText("Couldn't build Database.");
                            createDB.setEnabled(true);
                            restoreDB.setEnabled(true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_createDBMouseClicked

    private void restoreDBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreDBMouseClicked
        DecorationHelper.decorateWindows(true);
        if (restoreDB.isEnabled()) {
            restoreDB.setEnabled(false);
            createDB.setEnabled(false);
            createDB.setBackground(mouseExit);
            restoreDB.setBackground(mouseExit);
            if (fc == null) {
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setAcceptAllFileFilterUsed(false);
            }
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File dir = fc.getSelectedFile();
                if (new File(dir, "DBBackup.sql").exists()) {
                    new Thread() {
                        public void run() {
                            try {
                                status.setText("Restoring Database...");
                                ResultSet r = con.createStatement().executeQuery("SELECT @@basedir");
                                r.next();
                                String path = (r.getString(1) + "bin\\mysql.exe");
                                String s = (dir.getAbsolutePath() + "\\DBBackup.sql");
                                String[] cmd = new String[]{path, "--user=" + u, "--password=" + ps, "-e", "source " + s};
                                Process runtimeProcess;
                                runtimeProcess = Runtime.getRuntime().exec(cmd);
                                int processComplete = runtimeProcess.waitFor();
                                if (processComplete == 0) {
                                    status.setText("Database Restored.");
                                    File img = new File(dir.getAbsolutePath() + "\\img");
                                    if (img.exists()) {
                                        status.setText("Copying Data...");
                                        File imgTarget = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img");
                                        if (imgTarget.exists()) {
                                            deleteFolder(imgTarget);
                                        }
                                        imgTarget.mkdirs();
                                        File f[] = img.listFiles();
                                        for (File i : f) {
                                            Files.copy(i.toPath(), new File(imgTarget, i.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                                        }
                                        status.setText("Backup Restored.");
                                    }

                                    File prv = new File(dir.getAbsolutePath() + "\\Privilege");
                                    if (prv.exists()) {
                                        status.setText("Copying Data...");
                                        File prvTarget = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Privilege");
                                        if (prvTarget.exists()) {
                                            deleteFolder(prvTarget);
                                        }
                                        prvTarget.mkdirs();
                                        File f[] = prv.listFiles();
                                        for (File i : f) {
                                            Files.copy(i.toPath(), new File(prvTarget, i.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                                        }
                                        status.setText("Backup Restored.");
                                    }

                                    File sett = new File(dir.getAbsolutePath() + "\\Settings.cfg");
                                    if (sett.exists()) {
                                        Settings.loadSettingsFromBackup(sett);
                                        Settings.getObject().host = Cryption.encript(h);
                                        Settings.getObject().user = Cryption.encript(u);
                                        Settings.getObject().pass = Cryption.encript(ps);
                                        Settings.getObject().port = Cryption.encript(prt);
                                    }
                                    Settings.getObject().mySqlPath = path;
                                    Settings.getObject().mySqlDumpPath = (r.getString(1) + "bin\\mysqldump.exe");
                                    NotificationPanel.showNotification("Backup Restored", "Backup has been restored from", dir.getAbsolutePath(), NotificationPanel.SUCCESS);
                                } else {
                                    status.setText("Couldn't Restore Database.");
                                    restoreDB.setEnabled(true);
                                    createDB.setEnabled(true);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    JOptionPane.showMessageDialog(this, "Couldn't find any backups in the selected folder.", "Invalid Folder", JOptionPane.ERROR_MESSAGE);
                    restoreDB.setEnabled(true);
                    createDB.setEnabled(true);
                }
            } else {
                restoreDB.setEnabled(true);
                createDB.setEnabled(true);
            }
        }
        DecorationHelper.decorateWindows(false);
    }//GEN-LAST:event_restoreDBMouseClicked

    void deleteFolder(File Folder) {
        File f[] = Folder.listFiles();
        for (File f1 : f) {
            if (f1.isFile()) {
                f1.delete();
            } else {
                deleteFolder(f1);
            }
        }
        Folder.delete();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel createDB;
    private javax.swing.JLabel exitlbl;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel loginlbl;
    private javax.swing.JLabel restoreDB;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
