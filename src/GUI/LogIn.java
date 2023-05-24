package GUI;

import Cryptography.Cryption;
import static Model.Backup.write;
import Model.FrameIcon;
import Model.Privilege;
import Model.Settings;
import com.jtattoo.plaf.DecorationHelper;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class LogIn extends javax.swing.JFrame {

    static String type;
    Color mouseOver = new Color(32, 32, 32, 220);
    Color mouseExit = new Color(0, 0, 0, 100);
    JFileChooser fc;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public LogIn() {
        Color c = new Color(0, 0, 0, 60);
        initComponents();
        FrameIcon.setIcon(this);
        jPanel2.setBackground(mouseExit);
        uname.setBackground(c);
        pw.setBackground(c);
        loginlbl.setBackground(mouseExit);
        exitlbl.setBackground(mouseExit);
        checkValid();
        Settings.loadSettings();
        if (Settings.getObject().firstrun == true) {
            parentPanel.removeAll();
            parentPanel.add(new DBCon());
            parentPanel.repaint();
            parentPanel.revalidate();
            Settings.getObject().theme = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
        }
        if (Settings.getObject().backupPath != null) {
            new Thread() {
                @Override
                public void run() {
                    File bkp = new File(Settings.getObject().backupPath);
                    if (!bkp.exists()) {
                        DecorationHelper.decorateWindows(true);
                        JOptionPane.showMessageDialog(null, "Backup Location \"" + Settings.getObject().backupPath + "\"is not available.\nChoose a new location to proceed.", "Backup", JOptionPane.INFORMATION_MESSAGE);
                        changeBackupLocation();
                        DecorationHelper.decorateWindows(false);
                    }
                }
            }.start();
        }
        File f = new File("C:\\ProgramData\\Jasper_sub_report");
        String s = System.getProperty("user.dir");
        if (!f.exists()) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        f.mkdirs();
                        Files.copy(new File(s + "\\invoitems.jasper").toPath(), new File(f, "invoitems.jasper").toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(new File(s + "\\subitem.jasper").toPath(), new File(f, "subitem.jasper").toPath(), StandardCopyOption.REPLACE_EXISTING);
                        File f2 = new File("C:\\ProgramData\\Jasper_image");
                        f2.mkdirs();
                        Files.copy(new File(s + "\\Ishara.png").toPath(), new File(f2, "Ishara.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        parentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        loginlbl = new javax.swing.JLabel();
        exitlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 420));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        status.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 10, 360, -1));

        parentPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                parentPanelComponentRemoved(evt);
            }
        });
        parentPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login.png"))); // NOI18N
        jLabel2.setText("Login");
        jLabel2.setIconTextGap(20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("User Name :");

        uname.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        uname.setForeground(new java.awt.Color(204, 204, 255));
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText("Password :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Forgot your password ?");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

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
        loginlbl.setText("Login");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uname)
                            .addComponent(pw)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loginlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(loginlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitlbl)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        parentPanel.add(jPanel2, "card2");

        jPanel1.add(parentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 380));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/startup.gif"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(680, 420));
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

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        pw.grabFocus();
    }//GEN-LAST:event_unameActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new verify_Email().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked
    private int attempt_count = 1;
    private void loginlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseEntered
        loginlbl.setBackground(mouseOver);
    }//GEN-LAST:event_loginlblMouseEntered

    private void loginlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseExited
        loginlbl.setBackground(mouseExit);
    }//GEN-LAST:event_loginlblMouseExited

    private void loginlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginlblMouseClicked
        if (attempt_count > 3) {
            NotificationPanel.showNotification("Login Status", "You are blocked for 15s", "Too many attemps were used", NotificationPanel.ERROR);
            this.dispose();
            Block_system bs = new Block_system();
            bs.setVisible(true);
        }
        try {
            File file = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Login Details\\atmpt.dat");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st = br.readLine();
            attempt_count = Integer.parseInt(st);

        } catch (Exception e) {
        }

        if (uname.getText().isEmpty() || pw.getText().isEmpty()) {
            logger.Logger.writeLogger("Undifined", "Undifined", "fail", attempt_count);
            DecorationHelper.decorateWindows(true);
            JOptionPane.showMessageDialog(this, "Username Or Password Is Empty", "Unsuccessfull", JOptionPane.ERROR_MESSAGE);
            DecorationHelper.decorateWindows(false);
            attempt_count++;
            NotificationPanel.showNotification("Login Status", "" + (attempt_count - 1) + " Attempts were used", "" + (4 - attempt_count) + " Attemps left", NotificationPanel.WARN);
            if (attempt_count > 3) {
                NotificationPanel.showNotification("Login Status", "You are blocked for 15s", "Too many attemps were used", NotificationPanel.ERROR);
                this.dispose();
                Block_system bs = new Block_system();
                bs.setVisible(true);
            }

        } else {
            try {
                String username = uname.getText();
                String password = pw.getText();
                String username_encript = Cryption.encript(username);
                String password_encript = Cryption.encript(password);

                String sql = "SELECT * FROM user WHERE username=? AND password=?";
                PreparedStatement ps = DB.DB.getConnection().prepareStatement(sql);

                ps.setString(1, username_encript);
                ps.setString(2, password_encript);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    ResultSet st = DB.DB.search("SELECT employee.status FROM user INNER JOIN employee ON user.employee_nic = employee.nic WHERE username = '" + username_encript + "' AND password = '" + password_encript + "' AND status = 1");
                    if (st.next()) {
                        this.dispose();
                        String type_id = rs.getString("user_type_id");
                        ResultSet rs2 = DB.DB.search("SELECT * FROM user_type WHERE id='" + type_id + "'");
                        rs2.next();
                        type = rs2.getString(2);
                        logger.Logger.writeLogger(username, type, "Succcessful", attempt_count);

                        NotificationPanel.showNotification("Log-In Successful", username + " logged in.", "( " + type + " )", NotificationPanel.SUCCESS);

                        attempt_count = 1;
                        try {
                            UIManager.setLookAndFeel(Settings.getObject().theme);
                        } catch (Exception e) {
                        }
                        Home.o = null;
                        MainHome.o = null;
                        Privilege.o = null;
                        MainHome.getObject().username.setText(Cryption.decript(rs.getString("username")));
                        if (!"Admin".equals(type)) {
                            Privilege.getObject().loadObject(type);
                            setPrivalage();
                            MainHome.getObject().setVisible(true);

                        } else {

                            MainHome.getObject().setVisible(true);
                            this.dispose();
                        }
                    } else {
                        attempt_count++;
                        NotificationPanel.showNotification("Login Status", "" + (attempt_count - 1) + " Attempts were used", "" + (4 - attempt_count) + " Attemps left", NotificationPanel.WARN);
                        logger.Logger.writeLogger(username, "Deleted User", "Unsuccessfull", attempt_count);
                        DecorationHelper.decorateWindows(true);
                        JOptionPane.showMessageDialog(this, "You are no longer part of the system", "Log-In Fail", JOptionPane.ERROR_MESSAGE);
                        DecorationHelper.decorateWindows(false);
                        if (attempt_count > 3) {
                            NotificationPanel.showNotification("Login Failed", "You are blocked for 15sec.s", "Too many attempt(s) were used", NotificationPanel.ERROR);
                            this.dispose();
                            Block_system bs = new Block_system();
                            bs.setVisible(true);
                        }
                    }
                } else {
                    attempt_count++;
                    NotificationPanel.showNotification("Login Failed", "" + (attempt_count - 1) + " Attempt(s) were used.", "" + (4 - attempt_count) + " Attempt(s) left", NotificationPanel.WARN);
                    logger.Logger.writeLogger(username, "Undifined", "Unsuccessfull", attempt_count);
                    DecorationHelper.decorateWindows(true);
                    JOptionPane.showMessageDialog(this, "Username Or Password Is Incorrect", "Log-In Fail", JOptionPane.ERROR_MESSAGE);
                    DecorationHelper.decorateWindows(false);
                    if (attempt_count > 3) {
                        NotificationPanel.showNotification("Login Status", "You are blocked for 15sec.s", "Too many attempt(s) were used", NotificationPanel.ERROR);
                        this.dispose();
                        Block_system bs = new Block_system();
                        bs.setVisible(true);
                    }
                }

            } catch (SQLException e) {
                DecorationHelper.decorateWindows(true);
                JOptionPane.showMessageDialog(this, "Couldn't Connect with database. Re-Enter Database Credentials.", "Log-In Fail", JOptionPane.ERROR_MESSAGE);
                DecorationHelper.decorateWindows(false);
                parentPanel.removeAll();
                parentPanel.add(new DBCon());
                parentPanel.repaint();
                parentPanel.revalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            File folder = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service");
            File folder2 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Login Details");
            File file = new File(folder2, "atmpt.dat");
            if (!(folder.exists())) {
                folder.mkdir();
            }
            if (!(folder2.exists())) {
                folder2.mkdir();
            }

            file.setWritable(true);
            if (file.exists()) {
                file.delete();

            }
            FileWriter fr = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(String.valueOf(attempt_count));
            file.setWritable(false);
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_loginlblMouseClicked

    void changeBackupLocation() {
        if (fc == null) {
            fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setAcceptAllFileFilterUsed(false);
        }
        if (fc.showDialog(this, "Set Backup Path") == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String sysRoot = new File(System.getenv("SystemRoot")).getAbsolutePath().substring(0, 3);
            String fRoot = f.getAbsolutePath().substring(0, 3);
            if (fRoot.equals(sysRoot)) {
                JOptionPane.showMessageDialog(this, "You can't choose the system partition to save your backup.", "Choose another path", JOptionPane.INFORMATION_MESSAGE);
                changeBackupLocation();
            } else if (fc.getFileSystemView().getSystemTypeDescription(new File(fRoot)).equals("Local Disk")) {
                if (JOptionPane.showConfirmDialog(this, "The path you selected is on a Local Disk.\nIf your local hard disk was to fail, you won't be able to\nrecover your backup data.\n\nDo you want to Continue ?", "Local Disk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                    Settings.getObject().backupPath = f.getAbsolutePath();
                    m();
                } else {
                    changeBackupLocation();
                }
            } else {
                Settings.getObject().backupPath = f.getAbsolutePath();
                m();
            }
        } else {
            System.exit(0);
        }
    }

    void m() {
        status.setText("Writing backup...");
        new Thread() {
            @Override
            public void run() {
                try {
                    write();
                    File img = new File(Settings.getObject().backupPath + "\\img");
                    if (img.exists()) {
                        deleteFolder(img);
                    }
                    File ig = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img");
                    if (ig.exists()) {
                        img.mkdirs();
                        File images[] = ig.listFiles();
                        for (File image : images) {
                            Files.copy(image.toPath(), new File(img, image.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                        status.setText("Backup location changed.");
                        Settings.saveSettings();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    status.setText("Couldn't write backup.");
                }
            }
        }.start();
    }

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

    private void exitlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitlblMouseClicked

    private void exitlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseEntered
        exitlbl.setBackground(mouseOver);
    }//GEN-LAST:event_exitlblMouseEntered

    private void exitlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitlblMouseExited
        exitlbl.setBackground(mouseExit);
    }//GEN-LAST:event_exitlblMouseExited

    private void parentPanelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_parentPanelComponentRemoved
        jPanel2.setVisible(true);
    }//GEN-LAST:event_parentPanelComponentRemoved

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        loginlblMouseClicked(null);
    }//GEN-LAST:event_pwActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            DecorationHelper.decorateWindows(false);
        } catch (Exception ex) {
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loginlbl;
    public static javax.swing.JPanel parentPanel;
    private javax.swing.JPasswordField pw;
    private javax.swing.JLabel status;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables

    private void checkValid() {
        new Thread() {
            @Override
            public void run() {

                try {
                    File file = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Login Details\\atmpt.dat");

                    BufferedReader br = new BufferedReader(new FileReader(file));

                    String st = br.readLine();
                    attempt_count = Integer.parseInt(st);

                    if (attempt_count > 3) {

                        dis();

                    }

                } catch (Exception e) {
                }
            }
        }.start();
    }

    private void dis() {
        this.dispose();
        Block_system bl = new Block_system();
        bl.setVisible(true);
    }

    private void setPrivalage() {
        setMainHomerivalage();
        setHomePrivalage();
    }

    private void setMainHomerivalage() {

        MainHome mh = MainHome.getObject();
        int locationx = 0;
        int locationy = 0;
        // coustomer

        if (Privilege.getObject().coustomerval == true) {

            mh.customerbtn.setVisible(true);

        } else {
            mh.customerbtn.setVisible(false);
            locationx = mh.customerbtn.getX();
            locationy = mh.customerbtn.getY();
        }
        // employee
        if (Privilege.getObject().employeeval == true) {

            if (locationx != 0 && locationy != 0) {
                mh.employeebtn.setVisible(true);
                mh.employeebtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.employeebtn.setVisible(true);

            }

        } else {
            mh.employeebtn.setVisible(false);
            locationx = mh.employeebtn.getX();
            locationy = mh.employeebtn.getY();

        }
        //stock
        if (Privilege.getObject().stockval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.stockbtn.setVisible(true);
                mh.stockbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;

            } else {
                mh.stockbtn.setVisible(true);

            }

        } else {
            mh.stockbtn.setVisible(false);
            locationx = mh.stockbtn.getX();
            locationy = mh.stockbtn.getY();
        }

        //supplier
        if (Privilege.getObject().supplierval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.supplierbtn.setVisible(true);
                mh.supplierbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.supplierbtn.setVisible(true);

            }

        } else {
            mh.supplierbtn.setVisible(false);
            locationx = mh.supplierbtn.getX();
            locationy = mh.supplierbtn.getY();
        }

        //Report
        if (Privilege.getObject().reportval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.reportbtn.setVisible(true);
                mh.reportbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.reportbtn.setVisible(true);

            }

        } else {
            mh.reportbtn.setVisible(false);
            locationx = mh.reportbtn.getX();
            locationy = mh.reportbtn.getY();
        }
        //employee Payrol
        if (Privilege.getObject().employeePayrollval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.payrollbtn.setVisible(true);
                mh.payrollbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.payrollbtn.setVisible(true);

            }

        } else {
            mh.payrollbtn.setVisible(false);
            locationx = mh.payrollbtn.getX();
            locationy = mh.payrollbtn.getY();
        }
        if (Privilege.getObject().loginHistoryval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.historybtn.setVisible(true);
                mh.historybtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.historybtn.setVisible(true);

            }

        } else {
            mh.historybtn.setVisible(false);
            locationx = mh.historybtn.getX();
            locationy = mh.historybtn.getY();
        }

        if (Privilege.getObject().manageAccountval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.accbtn.setVisible(true);
                mh.accbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.accbtn.setVisible(true);

            }

        } else {
            mh.accbtn.setVisible(false);
            locationx = mh.accbtn.getX();
            locationy = mh.accbtn.getY();
        }
        //settings
        if (Privilege.getObject().settingsval == true) {
            if (locationx != 0 && locationy != 0) {
                mh.settingsbtn.setVisible(true);
                mh.settingsbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                mh.settingsbtn.setVisible(true);

            }

        } else {
            mh.settingsbtn.setVisible(false);
            locationx = mh.settingsbtn.getX();
            locationy = mh.settingsbtn.getY();
        }

        if (locationx != 0 && locationy != 0) {
            mh.logoutbtn.setVisible(true);
            mh.logoutbtn.setLocation(locationx, locationy);
            locationx = 0;
            locationy = 0;
        } else {
            mh.logoutbtn.setVisible(true);

        }

    }

    private void setHomePrivalage() {
        Home h = Home.getObject();
        int locationx = 0;
        int locationy = 0;
        int btnHeight = h.customerbtn.getHeight();
        int btnWidth = h.customerbtn.getHeight();
        Dimension btnSize = new Dimension(btnWidth, btnHeight);
        h.homebtn.setVisible(true);
        if (Privilege.getObject().coustomerval == true) {

            h.customerbtn.setVisible(true);
            h.customerbtn.setSize(btnSize);
        } else {
            h.customerbtn.setVisible(false);
            locationx = h.customerbtn.getX();
            locationy = h.customerbtn.getY();
        }
        // Stock
        if (Privilege.getObject().stockval == true) {
            if (locationx != 0 && locationy != 0) {
                h.stockbtn.setVisible(true);
                h.stockbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                h.stockbtn.setVisible(true);

            }
            h.stockbtn.setSize(btnSize);

        } else {
            h.stockbtn.setVisible(false);
            locationx = h.stockbtn.getX();
            locationy = h.stockbtn.getY();
        }

        // employee
        if (Privilege.getObject().employeeval == true) {
            if (locationx != 0 && locationy != 0) {
                h.employeebtn.setVisible(true);
                h.employeebtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                h.employeebtn.setVisible(true);

            }
            h.employeebtn.setSize(btnSize);

        } else {
            h.employeebtn.setVisible(false);
            locationx = h.employeebtn.getX();
            locationy = h.employeebtn.getY();
        }

        //employee manager
        if (Privilege.getObject().employeeManagerval == true) {
            if (locationx != 0 && locationy != 0) {
                h.employeemngerbtn.setVisible(true);
                h.employeemngerbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                h.employeemngerbtn.setVisible(true);

            }
            h.employeemngerbtn.setSize(btnSize);

        } else {
            h.employeemngerbtn.setVisible(false);
            locationx = h.employeemngerbtn.getX();
            locationy = h.employeemngerbtn.getY();
        }
        // supplier
        if (Privilege.getObject().supplierval == true) {
            if (locationx != 0 && locationy != 0) {
                h.supplierbtn.setVisible(true);
                h.supplierbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                h.supplierbtn.setVisible(true);

            }
            h.supplierbtn.setSize(btnSize);

        } else {
            h.supplierbtn.setVisible(false);
            locationx = h.supplierbtn.getX();
            locationy = h.supplierbtn.getY();
        }
        // report
        if (Privilege.getObject().reportval == true) {
            if (locationx != 0 && locationy != 0) {
                h.reportbtn.setVisible(true);
                h.reportbtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                h.reportbtn.setVisible(true);

            }
            h.reportbtn.setSize(btnSize);

        } else {
            h.reportbtn.setVisible(false);
            locationx = h.reportbtn.getX();
            locationy = h.reportbtn.getY();
        }
        //attendance
        if (Privilege.getObject().attendanceval == true) {
            if (locationx != 0 && locationy != 0) {
                h.attendancebtn.setVisible(true);
                h.attendancebtn.setLocation(locationx, locationy);
                locationx = 0;
                locationy = 0;
            } else {
                h.attendancebtn.setVisible(true);

            }
            h.attendancebtn.setSize(btnSize);

        } else {
            h.attendancebtn.setVisible(false);
            locationx = h.attendancebtn.getX();
            locationy = h.attendancebtn.getY();
        }
        if (locationx != 0 && locationy != 0) {
            h.logoutbtn.setVisible(true);
            h.logoutbtn.setLocation(locationx, locationy);

            h.logoutbtn.setSize(btnSize);
        } else {
            h.logoutbtn.setVisible(true);
            h.logoutbtn.setSize(btnSize);

        }

    }

}
