package GUI;

import Model.FrameIcon;
import Model.Settings;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Home extends javax.swing.JFrame {

    public static Home o;

    private Home() {
        initComponents();
        FrameIcon.setIcon(this);
        setSize(Settings.getObject().w, Settings.getObject().h);
        setLocation(Settings.getObject().lx, Settings.getObject().ly);
        setExtendedState(Settings.getObject().windowState);
        if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
            try {
                if (MainHome.getObject().nsCount != 0) {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_wred.png"))));
                }
            } catch (Exception e) {
            }
        } else {
            setIcons();
        }
    }

    public static synchronized Home getObject() {
        if (o == null) {
            o = new Home();
        }
        return o;
    }

    void setIcons() {
        try {
            if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
                homebtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Home_w.png"))));
                customerbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/customer_w.png"))));
                if (MainHome.getObject().nsCount == 0) {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_w.png"))));
                } else {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_wred.png"))));
                }
                employeebtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/employee_w.png"))));
                employeemngerbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/emp_management_w.png"))));
                supplierbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/supplier_w.png"))));
                reportbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/report_w.png"))));
                attendancebtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/attendance_w.png"))));
                logoutbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/logout_w.png"))));
            } else {
                homebtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/home_b.png"))));
                customerbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/customer_b.png"))));
                if (MainHome.getObject().nsCount == 0) {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_b.png"))));
                } else {
                    stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_bred.png"))));
                }
                employeebtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/employee_b.png"))));
                employeemngerbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/emp_managemnt_b.png"))));
                supplierbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/supplier_b.png"))));
                reportbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/report_b.png"))));
                attendancebtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/attendance_b.png"))));
                logoutbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/logout_b.png"))));
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Theme = new javax.swing.ButtonGroup();
        parentPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        customerbtn = new javax.swing.JButton();
        stockbtn = new javax.swing.JButton();
        employeebtn = new javax.swing.JButton();
        employeemngerbtn = new javax.swing.JButton();
        supplierbtn = new javax.swing.JButton();
        reportbtn = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();
        homebtn = new javax.swing.JButton();
        attendancebtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setTitle("Home");
        setMinimumSize(new java.awt.Dimension(1300, 752));
        setPreferredSize(new java.awt.Dimension(1300, 752));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        parentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        parentPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                parentPanelComponentAdded(evt);
            }
        });
        parentPanel.setLayout(new java.awt.CardLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        customerbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customer_w.png"))); // NOI18N
        customerbtn.setText("Customer");
        customerbtn.setFocusPainted(false);
        customerbtn.setHideActionText(true);
        customerbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerbtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        customerbtn.setIconTextGap(20);
        customerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerbtnActionPerformed(evt);
            }
        });

        stockbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Stock_w.png"))); // NOI18N
        stockbtn.setText("Stock");
        stockbtn.setFocusPainted(false);
        stockbtn.setHideActionText(true);
        stockbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stockbtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        stockbtn.setIconTextGap(20);
        stockbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockbtnActionPerformed(evt);
            }
        });

        employeebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee_w.png"))); // NOI18N
        employeebtn.setText("Employee");
        employeebtn.setFocusPainted(false);
        employeebtn.setHideActionText(true);
        employeebtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        employeebtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        employeebtn.setIconTextGap(20);
        employeebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeebtnActionPerformed(evt);
            }
        });

        employeemngerbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeemngerbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emp_management_w.png"))); // NOI18N
        employeemngerbtn.setText("Employee Manager");
        employeemngerbtn.setFocusPainted(false);
        employeemngerbtn.setHideActionText(true);
        employeemngerbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        employeemngerbtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        employeemngerbtn.setIconTextGap(20);
        employeemngerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeemngerbtnActionPerformed(evt);
            }
        });

        supplierbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        supplierbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supplier_w.png"))); // NOI18N
        supplierbtn.setText("Supplier");
        supplierbtn.setFocusPainted(false);
        supplierbtn.setHideActionText(true);
        supplierbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        supplierbtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        supplierbtn.setIconTextGap(20);
        supplierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierbtnActionPerformed(evt);
            }
        });

        reportbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reportbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/report_w.png"))); // NOI18N
        reportbtn.setText("Report");
        reportbtn.setFocusPainted(false);
        reportbtn.setHideActionText(true);
        reportbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportbtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        reportbtn.setIconTextGap(20);
        reportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportbtnActionPerformed(evt);
            }
        });

        logoutbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logoutbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout_w.png"))); // NOI18N
        logoutbtn.setText("Logout");
        logoutbtn.setFocusPainted(false);
        logoutbtn.setHideActionText(true);
        logoutbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutbtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        logoutbtn.setIconTextGap(20);
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        homebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Home_w.png"))); // NOI18N
        homebtn.setText("Home");
        homebtn.setFocusPainted(false);
        homebtn.setHideActionText(true);
        homebtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homebtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        homebtn.setIconTextGap(20);
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });

        attendancebtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        attendancebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/attendance_w.png"))); // NOI18N
        attendancebtn.setText("Attendance");
        attendancebtn.setFocusPainted(false);
        attendancebtn.setHideActionText(true);
        attendancebtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        attendancebtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        attendancebtn.setIconTextGap(20);
        attendancebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendancebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeemngerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(attendancebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stockbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeemngerbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(attendancebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {attendancebtn, customerbtn, employeebtn, employeemngerbtn, homebtn, logoutbtn, reportbtn, stockbtn, supplierbtn});

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        title.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        title.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title)
                .addGap(6, 6, 6))
        );

        jMenu2.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Copy");
        jMenu2.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Cut");
        jMenu2.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Past");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("About Us");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (getExtendedState() == ICONIFIED) {
            Settings.getObject().windowState = NORMAL;
        } else {
            Settings.getObject().windowState = getExtendedState();
        }
        MainHome.getObject().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getExtendedState() == NORMAL) {
                    Settings.getObject().h = getSize().height;
                    Settings.getObject().w = getSize().width;
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                if (getExtendedState() == NORMAL) {
                    Settings.getObject().lx = getLocation().x;
                    Settings.getObject().ly = getLocation().y;
                }
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }

        });
    }//GEN-LAST:event_formWindowOpened

    private void stockbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockbtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Stock.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_stockbtnActionPerformed

    private void customerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerbtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Customer.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_customerbtnActionPerformed

    private void employeebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeebtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Employee.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_employeebtnActionPerformed

    private void employeemngerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeemngerbtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Employee_Maneger.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_employeemngerbtnActionPerformed

    private void supplierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierbtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Supplier.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_supplierbtnActionPerformed

    private void reportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportbtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Report.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_reportbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        setVisible(false);
        MainHome.getObject().setVisible(true);
        MainHome.getObject().requestFocus();
    }//GEN-LAST:event_homebtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        new LgOut(this, true).setVisible(true);
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void attendancebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendancebtnActionPerformed
        parentPanel.removeAll();
        parentPanel.add(Attendance.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_attendancebtnActionPerformed

    private void parentPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_parentPanelComponentAdded
        switch (parentPanel.getComponent(0).getClass().getCanonicalName().substring(4)) {
            case "Customer":
                title.setText(Customer.getObject().title);
                Customer.getObject().vNumber.grabFocus();
                break;
            case "Stock":
                title.setText(Stock.getObject().title);
                break;
            case "Employee":
                title.setText(Employee.getObject().title);
                break;
            case "Supplier":
                title.setText(Supplier.getObject().title);
                break;
            case "About_Us":
                title.setText(About_Us.getObject().title);
                break;
            case "Payroll":
                title.setText(Payroll.getObject().title);
                break;
            case "Employee_Maneger":
                title.setText(Employee_Maneger.getObject().title);
                break;
            case "Report":
                title.setText(Report.getObject().title);
                break;
            case "Attendance":
                title.setText(Attendance.getObject().title);
                break;
            case "Login_History":
                title.setText(Login_History.getObject().title);
                break;
            case "Manege_Account":
                title.setText(Manege_Account.getObject().title);
                break;
        }
    }//GEN-LAST:event_parentPanelComponentAdded

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        parentPanel.removeAll();
        parentPanel.add(About_Us.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        parentPanel.removeAll();
        parentPanel.add(About_Us.getObject());
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_jMenu1MouseClicked

    public void setVisible(boolean b, JPanel p) {
        super.setVisible(b);
        parentPanel.removeAll();
        parentPanel.add(p);
        parentPanel.repaint();
        parentPanel.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Theme;
    public javax.swing.JButton attendancebtn;
    public javax.swing.JButton customerbtn;
    public javax.swing.JButton employeebtn;
    public javax.swing.JButton employeemngerbtn;
    public javax.swing.JButton homebtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton logoutbtn;
    public javax.swing.JPanel parentPanel;
    public javax.swing.JButton reportbtn;
    public javax.swing.JButton stockbtn;
    public javax.swing.JButton supplierbtn;
    public javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
