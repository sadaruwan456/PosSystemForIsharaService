package GUI;

import static Model.Backup.write;
import Model.FrameIcon;
import Model.Settings;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author OLE
 */
public class Setting extends javax.swing.JFrame {

    private static Setting o;
    JFileChooser fc;

    private Setting() {
        initComponents();
        FrameIcon.setIcon(this);
        switch (Settings.getObject().theme) {
            case "com.jtattoo.plaf.hifi.HiFiLookAndFeel":
                jRadioButton1.setSelected(true);
                break;
            case "com.jtattoo.plaf.acryl.AcrylLookAndFeel":
                jRadioButton2.setSelected(true);
                break;
            case "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel":
                jRadioButton3.setSelected(true);
                break;
            case "com.jtattoo.plaf.mcwin.McWinLookAndFeel":
                jRadioButton4.setSelected(true);
                break;
            case "com.jtattoo.plaf.aero.AeroLookAndFeel":
                jRadioButton5.setSelected(true);
                break;
            case "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel":
                jRadioButton6.setSelected(true);
                break;
            case "com.jtattoo.plaf.texture.TextureLookAndFeel":
                jRadioButton7.setSelected(true);
                break;
            case "com.jtattoo.plaf.mint.MintLookAndFeel":
                jRadioButton8.setSelected(true);
                break;
        }
        backPath.setText(Settings.getObject().backupPath);
    }

    public static synchronized Setting getObject() {
        if (o == null) {
            o = new Setting();
        }
        return o;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        backPath = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();

        setTitle("Settings");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Theme", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Black Theme");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton6.setText("Aluminium");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Light Theme");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton7.setText("Texture");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton3.setText("Yellow Theme");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton8.setText("Mint");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton4.setText("Mac Theme");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton5.setText("Aero");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5))
                    .addComponent(jRadioButton8))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Backup and Restore", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Backup Path :");

        backPath.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Backup Now");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        status.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(backPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(backPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(status))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void setTheme() {
        try {
            UIManager.setLookAndFeel(Settings.getObject().theme);
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
            if (fc != null) {
                SwingUtilities.updateComponentTreeUI(fc);
            }
            MainHome.getObject().setIcons();
            SwingUtilities.updateComponentTreeUI(MainHome.getObject());
            MainHome.getObject().pack();
            if (Home.o != null) {
                Home.getObject().setIcons();
                SwingUtilities.updateComponentTreeUI(Home.o);
                Home.getObject().pack();
            }
            if (StockNotifications.o != null) {
                SwingUtilities.updateComponentTreeUI(StockNotifications.o);
            }

            if (Customer.o != null) {
                SwingUtilities.updateComponentTreeUI(Customer.o);
            }
            if (Stock.o != null) {
                SwingUtilities.updateComponentTreeUI(Stock.o);
            }
            if (Employee.o != null) {
                try {
                    if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {

                        Employee.o.capture.setIcon(new ImageIcon(ImageIO.read(Employee.class.getResource("/Images/capture_w.png"))));

                    }else{
                        Employee.o.capture.setIcon(new ImageIcon(ImageIO.read(Employee.class.getResource("/Images/capture_b.png"))));
                    }
                } catch (IOException ex) {

                }
                SwingUtilities.updateComponentTreeUI(Employee.o);
            }
            if (Employee_Maneger.o != null) {
                SwingUtilities.updateComponentTreeUI(Employee_Maneger.o);
            }
            if (Supplier.o != null) {
                SwingUtilities.updateComponentTreeUI(Supplier.o);
            }
            if (Employee.o != null) {
                SwingUtilities.updateComponentTreeUI(Employee.o);
            }
            if (Report.o != null) {
                SwingUtilities.updateComponentTreeUI(Report.o);
            }
            if (Attendance.o != null) {
                SwingUtilities.updateComponentTreeUI(Attendance.o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.aero.AeroLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.texture.TextureLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        Settings.getObject().theme = "com.jtattoo.plaf.mint.MintLookAndFeel";
        setTheme();
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        status.setText("Writing backup...");
        new Thread() {
            @Override
            public void run() {
                try {
                    write();
                    status.setText("Backup written.");
                } catch (Exception e) {
                    e.printStackTrace();
                    status.setText("Couldn't write backup.");
                }
            }
        }.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            } else if (fc.getFileSystemView().getSystemTypeDescription(new File(fRoot)).equals("Local Disk")) {
                if (JOptionPane.showConfirmDialog(this, "The path you selected is on a Local Disk.\nIf your local hard disk was to fail, you won't be able to\nrecover your backup data.\n\nDo you want to Continue ?", "Local Disk", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                    Settings.getObject().backupPath = f.getAbsolutePath();
                    m();
                }
            } else {
                Settings.getObject().backupPath = f.getAbsolutePath();
                m();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    void m() {
        backPath.setText(Settings.getObject().backupPath);
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
                    }
                    File p = new File(Settings.getObject().backupPath + "\\Privilege");
                    File prv = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Privilege");
                    if (prv.exists()) {
                        p.mkdirs();
                        File f[] = prv.listFiles();
                        for (File pv : f) {
                            Files.copy(pv.toPath(), new File(p, pv.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        }
                        status.setText("Backup location changed.");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField backPath;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JRadioButton jRadioButton2;
    public javax.swing.JRadioButton jRadioButton3;
    public javax.swing.JRadioButton jRadioButton4;
    public javax.swing.JRadioButton jRadioButton5;
    public javax.swing.JRadioButton jRadioButton6;
    public javax.swing.JRadioButton jRadioButton7;
    public javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
