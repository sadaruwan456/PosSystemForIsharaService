package GUI;

import DB.DB;
import Model.Backup;
import Model.FrameIcon;
import Model.Settings;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.jnativehook.GlobalScreen;

public class MainHome extends javax.swing.JFrame {

    public static MainHome o;
    public int nsCount;

    private MainHome() {
        initComponents();
        FrameIcon.setIcon(this);
        try {
            ResultSet r = DB.search("SELECT COUNT(*) FROM notified_stock");
            r.next();
            nsCount = r.getInt(1);
            if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
                if (nsCount != 0) {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/stockwred.png"))));
                }
            } else {
                setIcons();
            }
        } catch (Exception e) {
        }
    }

    public static synchronized MainHome getObject() {
        if (o == null) {
            o = new MainHome();
        }
        return o;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        employeebtn = new javax.swing.JButton();
        customerbtn = new javax.swing.JButton();
        stockbtn = new javax.swing.JButton();
        supplierbtn = new javax.swing.JButton();
        reportbtn = new javax.swing.JButton();
        payrollbtn = new javax.swing.JButton();
        historybtn = new javax.swing.JButton();
        accbtn = new javax.swing.JButton();
        settingsbtn = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ishara Service");
        setMinimumSize(new java.awt.Dimension(1060, 552));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        employeebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        employeebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/empw.png"))); // NOI18N
        employeebtn.setText("Employee");
        employeebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeebtn.setFocusPainted(false);
        employeebtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        employeebtn.setIconTextGap(10);
        employeebtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        employeebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeebtnActionPerformed(evt);
            }
        });

        customerbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customerbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/custw.png"))); // NOI18N
        customerbtn.setText("Customer");
        customerbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerbtn.setFocusPainted(false);
        customerbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerbtn.setIconTextGap(10);
        customerbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerbtnActionPerformed(evt);
            }
        });

        stockbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stockbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stockw.png"))); // NOI18N
        stockbtn.setText("Stock");
        stockbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockbtn.setFocusPainted(false);
        stockbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stockbtn.setIconTextGap(10);
        stockbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stockbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockbtnActionPerformed(evt);
            }
        });

        supplierbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        supplierbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/suppw.png"))); // NOI18N
        supplierbtn.setText("Supplier");
        supplierbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierbtn.setFocusPainted(false);
        supplierbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        supplierbtn.setIconTextGap(10);
        supplierbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        supplierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierbtnActionPerformed(evt);
            }
        });

        reportbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        reportbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reportsw.png"))); // NOI18N
        reportbtn.setText("Report");
        reportbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportbtn.setFocusPainted(false);
        reportbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reportbtn.setIconTextGap(10);
        reportbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportbtnActionPerformed(evt);
            }
        });

        payrollbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        payrollbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/payrol_w.png"))); // NOI18N
        payrollbtn.setText("Employee Payroll");
        payrollbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payrollbtn.setFocusPainted(false);
        payrollbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        payrollbtn.setIconTextGap(10);
        payrollbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        payrollbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollbtnActionPerformed(evt);
            }
        });

        historybtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        historybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/historyw.png"))); // NOI18N
        historybtn.setText("Logging History");
        historybtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historybtn.setFocusPainted(false);
        historybtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        historybtn.setIconTextGap(10);
        historybtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        historybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historybtnActionPerformed(evt);
            }
        });

        accbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        accbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accw.png"))); // NOI18N
        accbtn.setText("Manage Account");
        accbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accbtn.setFocusPainted(false);
        accbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accbtn.setIconTextGap(10);
        accbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        accbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accbtnActionPerformed(evt);
            }
        });

        settingsbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        settingsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settingsw.png"))); // NOI18N
        settingsbtn.setText("Settings");
        settingsbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsbtn.setFocusPainted(false);
        settingsbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settingsbtn.setIconTextGap(10);
        settingsbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        settingsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsbtnActionPerformed(evt);
            }
        });

        logoutbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoutw.png"))); // NOI18N
        logoutbtn.setText("Logout");
        logoutbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutbtn.setFocusPainted(false);
        logoutbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutbtn.setIconTextGap(10);
        logoutbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Avatar_w.png"))); // NOI18N
        username.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("System Developed By : Dilanka Sandaruwan / d.sadaru98@gmail.com / +94  71 016 4681");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ishara Auto Service Motors");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reportbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(payrollbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(historybtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(settingsbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(supplierbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(stockbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(employeebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(customerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(payrollbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(historybtn, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(accbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(settingsbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setIcons() {
        try {
            if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
                customerbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/custw.png"))));
                employeebtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/empw.png"))));
                if (nsCount == 0) {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/stockw.png"))));
                } else {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/stockwred.png"))));
                };
                supplierbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/suppw.png"))));
                reportbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/reportsw.png"))));
                payrollbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/payrol_w.png"))));
                historybtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/historyw.png"))));
                accbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/accw.png"))));
                settingsbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/settingsw.png"))));
                logoutbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/logoutw.png"))));
                username.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/Avatar_w.png"))));
            } else {
                customerbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/custb.png"))));
                employeebtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/empb.png"))));
                if (nsCount == 0) {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/stockb.png"))));
                } else {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/stockbred.png"))));
                }
                supplierbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/suppb.png"))));
                reportbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/reportsb.png"))));
                payrollbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/payrool_B.png"))));
                historybtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/historyb.png"))));
                accbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/accb.png"))));
                settingsbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/settingsb.png"))));
                logoutbtn.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/logoutb.png"))));
                username.setIcon(new ImageIcon(ImageIO.read(MainHome.class.getResource("/Images/Avatar_b.png"))));
            }
        } catch (Exception e) {
        }
    }

    private void employeebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeebtnActionPerformed
        Home.getObject().setVisible(true, Employee.getObject());
        setVisible(false);
    }//GEN-LAST:event_employeebtnActionPerformed

    private void customerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerbtnActionPerformed
        Home.getObject().setVisible(true, Customer.getObject());
        setVisible(false);
    }//GEN-LAST:event_customerbtnActionPerformed

    private void stockbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockbtnActionPerformed
        Home.getObject().setVisible(true, Stock.getObject());
        setVisible(false);
    }//GEN-LAST:event_stockbtnActionPerformed

    private void supplierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierbtnActionPerformed
        Home.getObject().setVisible(true, Supplier.getObject());
        setVisible(false);
    }//GEN-LAST:event_supplierbtnActionPerformed

    private void reportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportbtnActionPerformed
        Home.getObject().setVisible(true, Report.getObject());
        setVisible(false);
    }//GEN-LAST:event_reportbtnActionPerformed

    private void payrollbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollbtnActionPerformed
        Home.getObject().setVisible(true, Payroll.getObject());
        setVisible(false);
    }//GEN-LAST:event_payrollbtnActionPerformed

    private void historybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historybtnActionPerformed
        Login_History.o = null;
        Home.getObject().setVisible(true, Login_History.getObject());
        setVisible(false);
    }//GEN-LAST:event_historybtnActionPerformed

    private void accbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accbtnActionPerformed
        Home.getObject().setVisible(true, Manege_Account.getObject());
        setVisible(false);
    }//GEN-LAST:event_accbtnActionPerformed

    private void settingsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsbtnActionPerformed
        Setting.getObject().setVisible(true);
    }//GEN-LAST:event_settingsbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        new LgOut(this, true).setVisible(true);
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Settings.saveSettings();
        setVisible(false);
        if (Customer.o != null) {
            Customer.getObject().gs.removeNativeKeyListener(Customer.getObject().nkl);
            GlobalScreen.unregisterNativeHook();
        }
        try {
            Backup.writeBackup().join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton accbtn;
    public javax.swing.JButton customerbtn;
    public javax.swing.JButton employeebtn;
    public javax.swing.JButton historybtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JButton logoutbtn;
    public javax.swing.JButton payrollbtn;
    public javax.swing.JButton reportbtn;
    public javax.swing.JButton settingsbtn;
    public javax.swing.JButton stockbtn;
    public javax.swing.JButton supplierbtn;
    public javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
