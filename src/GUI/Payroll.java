/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import sqllogger.SQLLog;

/**
 *
 * @author OLE
 */
public class Payroll extends javax.swing.JPanel {

    public String title = "Employee Payroll";
    SQLLog WriteToSql = new SQLLog();
    boolean action = true;
    String DateToSearch;
    DefaultTableModel dtm;
    String nic_from_search;
    boolean printButton = false;
    public static Payroll o;
    String lastPaySalary;
    int fulldate2;
    int harfdate2;
    String totsalary2;

    public static synchronized Payroll getObject() {
        if (o == null) {
            o = new Payroll();
        }
        return o;
    }

    private Payroll() {
        initComponents();
        Snic.grabFocus();
        setDate();
        bounsEditable(false);
        print1.setEnabled(false);

        dtm = (DefaultTableModel) jTable1.getModel();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTable1.getSelectedRowCount() == 1) {
                    nic_from_search = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    setDeatils();

                } else {
                    reset();
                    bounsEditable(false);
                }
            }
        });

        PropertyChangeListener pc1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String loan = dlone.getText();
                String bon = bouns.getText();
                if (loan.equals(bon)) {
                    if (loan.equals("N/A")) {
                        loan = "0";
                    }
                    if (bon.equals("N/A")) {
                        bon = "0";
                    }
                    tsalary.setText(String.valueOf(Double.parseDouble(loan) + Double.parseDouble(bon)));
                } else {
                }
            }
        };
        tsalary.addPropertyChangeListener("text", pc1);
        tableLoad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        n_date_salary = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Snic = new javax.swing.JTextField();
        print = new javax.swing.JToggleButton();
        SDropdown = new javax.swing.JComboBox<>();
        nic = new javax.swing.JLabel();
        psalary = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        dlone = new javax.swing.JLabel();
        w_h_d = new javax.swing.JLabel();
        tsalary = new javax.swing.JLabel();
        w_f_date = new javax.swing.JLabel();
        lpay_salary_date = new javax.swing.JLabel();
        bouns = new javax.swing.JTextField();
        datetxt = new javax.swing.JTextField();
        print1 = new javax.swing.JToggleButton();
        print2 = new javax.swing.JToggleButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Nic");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Per Day Salary");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Due Loan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Bonus");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Last Paid Salary Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Salary Date");

        n_date_salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n_date_salaryMouseClicked(evt);
            }
        });
        n_date_salary.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                n_date_salaryPropertyChange(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Working Full Days");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Working Half Days");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Total Salary");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nic", "First Name", "Last Name", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        Snic.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Snic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SnicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SnicKeyReleased(evt);
            }
        });

        print.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        print.setText("Only Save");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        nic.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        nic.setText("N/A");

        psalary.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        psalary.setText("N/A");

        fname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        fname.setText("N/A");

        lname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lname.setText("N/A");

        dlone.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        dlone.setText("N/A");

        w_h_d.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        w_h_d.setText("N/A");

        tsalary.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tsalary.setText("N/A");

        w_f_date.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        w_f_date.setText("N/A");

        lpay_salary_date.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lpay_salary_date.setText("N/A");

        bouns.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bouns.setText("N/A");
        bouns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bounsMouseClicked(evt);
            }
        });
        bouns.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bounsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bounsKeyTyped(evt);
            }
        });

        datetxt.setEditable(false);
        datetxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        datetxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datetxtMouseClicked(evt);
            }
        });
        datetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datetxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                datetxtKeyTyped(evt);
            }
        });

        print1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        print1.setText("Save And Print");
        print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print1ActionPerformed(evt);
            }
        });

        print2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        print2.setText("Reset");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(print2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(print1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SDropdown, 0, 149, Short.MAX_VALUE)
                                    .addComponent(nic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(psalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(w_h_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lpay_salary_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(Snic))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fname, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(dlone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tsalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(datetxt)
                                .addGap(0, 0, 0)
                                .addComponent(n_date_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lname, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(w_f_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bouns, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dlone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addComponent(psalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bouns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lpay_salary_date))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(w_f_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(n_date_salary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(tsalary, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(w_h_d, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Snic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(print)
                        .addComponent(print2))
                    .addComponent(print1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SnicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SnicKeyPressed


    }//GEN-LAST:event_SnicKeyPressed

    private void SnicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SnicKeyReleased
        TableRowSorter<TableModel> soter = new TableRowSorter<TableModel>(((DefaultTableModel) jTable1.getModel()));
        soter.setRowFilter(RowFilter.regexFilter("(?i)" + Snic.getText()));
        jTable1.setRowSorter(soter);
    }//GEN-LAST:event_SnicKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void n_date_salaryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_n_date_salaryPropertyChange

        validateDate();
        if (!(n_date_salary.getDate() == null)) {
            datetxt.setText(new SimpleDateFormat("yyyy-MM-dd").format(n_date_salary.getDate()));
        }
        if (!nic.getText().equals("N/A")) {
            try {
                setDeatils();
                Date Today = new Date();
                Date DayFromSelected = n_date_salary.getDate();
                Date lastdate = new SimpleDateFormat("yyyy-MM-dd").parse(lpay_salary_date.getText());
                if (DayFromSelected.before(lastdate)) {

                    action = false;
                    JOptionPane.showMessageDialog(this, "Salaries have been paid", "Invalid date", JOptionPane.ERROR_MESSAGE);
                    DateToSearch = new SimpleDateFormat("yyyy-MM-dd").format(Today);
                    Date day = new SimpleDateFormat("yyyy-MM-dd").parse(DateToSearch);

                    n_date_salary.setDate(day);

                    nic.grabFocus();
                    action = true;
                }
            } catch (Exception e) {

            }

        }
    }//GEN-LAST:event_n_date_salaryPropertyChange

    private void n_date_salaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_date_salaryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_n_date_salaryMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            Date d = n_date_salary.getDate();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(d);
            ResultSet rs1 = DB.search("SELECT salary.employee_nic FROM salary WHERE salary.employee_nic='" + nic.getText() + "'");
            if (rs1.next()) {
                DB.iud("UPDATE salary SET salary.Date='" + date + "' WHERE salary.employee_nic='" + rs1.getString("salary.employee_nic") + "'");
                setDeatils();
                JOptionPane.showMessageDialog(this, "UPDATE SUCCESSFUL  ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DB.iud("INSERT INTO salary (salary.employee_nic,salary.DATE)VALUES ('" + nic.getText() + "', '" + date + "');");
                JOptionPane.showMessageDialog(this, "INSERT SUCCESSFUL ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                setDeatils();
            }
            jTable1.getSelectionModel().clearSelection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_printActionPerformed

    private void bounsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bounsKeyReleased
        setBonus();
    }//GEN-LAST:event_bounsKeyReleased

    private void bounsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bounsKeyTyped
        if (Character.isDigit(evt.getKeyChar())) {

        } else {
            evt.consume();
        }

    }//GEN-LAST:event_bounsKeyTyped

    private void bounsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bounsMouseClicked
        bouns.setText("");
    }//GEN-LAST:event_bounsMouseClicked

    private void datetxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datetxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_datetxtMouseClicked

    private void datetxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datetxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_datetxtKeyReleased

    private void datetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datetxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_datetxtKeyTyped

    private void print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print1ActionPerformed
        try {
            Date d = n_date_salary.getDate();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(d);
            ResultSet rs1 = DB.search("SELECT salary.employee_nic FROM salary WHERE salary.employee_nic='" + nic.getText() + "'");
            if (rs1.next()) {
                DB.iud("UPDATE salary SET salary.Date='" + date + "' WHERE salary.employee_nic='" + rs1.getString("salary.employee_nic") + "'");
                setDeatils();
                JOptionPane.showMessageDialog(this, "Update Successful Please Wait Report Print ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DB.iud("INSERT INTO salary (salary.employee_nic,salary.DATE)VALUES ('" + nic.getText() + "', '" + date + "');");
                JOptionPane.showMessageDialog(this, "Insert Successful Please Wait Report Print", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                setDeatils();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String nic1 = nic.getText();
        String fname1 = fname.getText();
        String lname1 = lname.getText();
        String fullname = fname1 + lname1;
        String total_salary = totsalary2;
        int work_full_days1 = fulldate2;
        int work_hulf_days1 = harfdate2;
        int shift_count1 = work_full_days1 * 2;
        int shift_count2 = work_hulf_days1 + shift_count1;
//       salary

        double per_day = Double.parseDouble(psalary.getText());
        double shift_salary = per_day / 2;
        double working_salary = shift_salary * shift_count2;
        String salaryn = "Working Salary";
        String bonusn = "Bonus";
        String loann = "Loan";
        double bonus;
        if (bouns.getText().equals("N/A")) {
            bonus = 0.0;
        } else {
            bonus = Double.parseDouble(bouns.getText());
        }

        double loan1 = Double.parseDouble(dlone.getText());
        double total_er = working_salary + bonus;
        double net_sal = total_er - loan1;
        String last_date = lastPaySalary;
        Date d1 = n_date_salary.getDate();
        String pay_date = new SimpleDateFormat("yyyy-MM-dd").format(d1);
        String type1 = null;
        String qry = "SELECT DISTINCT employee_type.`type` FROM employee INNER JOIN employee_type ON employee.employee_type_id=employee_type.id WHERE employee.nic='" + nic1 + "'";
        try {
            ResultSet rs = DB.search(qry);
            if (rs.next()) {
                type1 = rs.getString("type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("namep", fullname);
        parameters.put("nicp", nic1);
        parameters.put("net_salary", total_salary);
        parameters.put("full_day_count", work_full_days1);
        parameters.put("hulf_day_count", work_hulf_days1);
        parameters.put("work_salaryn", salaryn);
        parameters.put("work_salaryv", working_salary);
        parameters.put("Bonusn", bonusn);
        parameters.put("Bonusv", bonus);
        parameters.put("loan", loann);
        parameters.put("loanv", loan1);
        parameters.put("total_earning", total_er);
        parameters.put("total_deduction", loan1);
        parameters.put("gross_salary", total_er);
        parameters.put("net_salary", net_sal);
        parameters.put("designation", type1);
        parameters.put("Last_pay_date", last_date);
        parameters.put("salary_date", pay_date);

        try {
            InputStream jr = Payroll.class.getResourceAsStream("/BILL/patsheet.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_print1ActionPerformed

    private void print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print2ActionPerformed
        reset();
    }//GEN-LAST:event_print2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SDropdown;
    private javax.swing.JTextField Snic;
    private javax.swing.JTextField bouns;
    private javax.swing.JTextField datetxt;
    private javax.swing.JLabel dlone;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel lpay_salary_date;
    private com.toedter.calendar.JDateChooser n_date_salary;
    private javax.swing.JLabel nic;
    private javax.swing.JToggleButton print;
    private javax.swing.JToggleButton print1;
    private javax.swing.JToggleButton print2;
    private javax.swing.JLabel psalary;
    private javax.swing.JLabel tsalary;
    private javax.swing.JLabel w_f_date;
    private javax.swing.JLabel w_h_d;
    // End of variables declaration//GEN-END:variables
public void tableLoad() {
        try {
            dtm.setRowCount(0);
            ResultSet rs = DB.search("SELECT DISTINCT nic,fname,lname,mobile FROM employee  INNER JOIN attendence ON attendence.employee_nic=employee.nic  WHERE employee.`status`='1' AND nic <> 0");
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("nic"));
                v.add(rs.getString("fname"));
                v.add(rs.getString("lname"));
                v.add(rs.getString("mobile"));

                dtm.addRow(v);
            }
        } catch (Exception e) {

        }
    }

    private void validateDate() {
        Date DayFromSelected = n_date_salary.getDate();
        Date Today = new Date();
        if (DayFromSelected.after(Today)) {
            try {
                action = false;
                JOptionPane.showMessageDialog(this, "The day you enter can not be in the future", "Invalid date", JOptionPane.ERROR_MESSAGE);
                DateToSearch = new SimpleDateFormat("yyyy-MM-dd").format(Today);
                Date day = new SimpleDateFormat("yyyy-MM-dd").parse(DateToSearch);

                n_date_salary.setDate(day);

                nic.grabFocus();
                action = true;

            } catch (Exception e) {

            }

        }
    }

    private void setDate() {
        if (n_date_salary.getDate() == null) {
            try {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                DateToSearch = sdf.format(d);

                Date day = new SimpleDateFormat("yyyy-MM-dd").parse(DateToSearch);

                n_date_salary.setDate(day);
            } catch (ParseException ex) {
                Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Date d = n_date_salary.getDate();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            DateToSearch = sdf.format(d);

        }
    }

    public void setDeatils() {

        int fullday = 0;
        int harfday = 0;
        double salary = 0;

        try {
            ResultSet rs = DB.search("SELECT DISTINCT nic,fname,lname,salary  FROM employee INNER JOIN employee_type ON employee.employee_type_id =employee_type.id   WHERE employee.nic='" + nic_from_search + "' AND nic <> 0");
            if (rs.next()) {
                nic.setText(rs.getString("nic"));
                fname.setText(rs.getString("fname"));
                lname.setText(rs.getString("lname"));
                salary = Double.valueOf(rs.getString("salary"));
                psalary.setText(String.valueOf(salary));
                bounsEditable(true);
                print1.setEnabled(true);
            }

        } catch (Exception ex) {
            // ex.printStackTrace();
        }

        try {
            ResultSet rs = DB.search("SELECT * FROM salary WHERE salary.employee_nic='" + nic_from_search + "'");
            if (rs.next()) {
                lastPaySalary = rs.getString("Date");
                lpay_salary_date.setText(lastPaySalary);
            } else {
                try {
                    ResultSet rs1 = DB.search("SELECT MIN(date) FROM attendence WHERE attendence.employee_nic='" + nic_from_search + "'");
                    if (rs1.next()) {
                        lastPaySalary = rs1.getString(1);
                        lpay_salary_date.setText(lastPaySalary);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = DB.search("SELECT Loan FROM loan WHERE loan.nic='" + nic_from_search + "'");
            if (rs.next()) {
                dlone.setText(rs.getString("Loan"));
            } else {
                dlone.setText("00");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (lpay_salary_date.getText().equalsIgnoreCase(datetxt.getText())) {
            fullday = 0;
            harfday = 0;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String lastdate = lpay_salary_date.getText();
                String newday = sdf.format(n_date_salary.getDate());

                ResultSet rs = DB.search(" SELECT * FROM attendence WHERE attendence.employee_nic='" + nic_from_search + "' AND attendence.DATE BETWEEN  '" + lastdate + "' AND '" + newday + "' ");
                while (rs.next()) {

                    int moring = rs.getInt("Morning");
                    int evening = rs.getInt("Evening");
                    if (moring == 1 && evening == 1) {
                        fullday++;
                    } else if (moring == 0 && evening == 0) {
                    } else {
                        harfday++;
                    }

                }
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
        fulldate2 = fullday;
        harfdate2 = harfday;
        w_f_date.setText(String.valueOf(fullday));
        w_h_d.setText(String.valueOf(harfday));
        double lone = Double.valueOf(dlone.getText());

        double totlesalary = salary * fullday + salary / 2 * harfday - lone;
        tsalary.setText(String.valueOf(totlesalary));

    }

    public void setBonus() {
        double getbouns;
        double daysalary = Double.valueOf(psalary.getText());
        double lone = Double.valueOf(dlone.getText());
        int getFullDays = Integer.valueOf(w_f_date.getText());
        int getHalflDays = Integer.valueOf(w_h_d.getText());

        if (bouns.getText().isEmpty()) {
            getbouns = 0;
        } else {
            getbouns = Double.valueOf(bouns.getText());
        }

        double totlesalary = daysalary * getFullDays + daysalary / 2 * getHalflDays - lone + getbouns;
        totsalary2 = String.valueOf(totlesalary);
        tsalary.setText(String.valueOf(totlesalary));

    }

    public void reset() {
        nic.setText("N/A");
        fname.setText("N/A");
        lname.setText("N/A");
        lname.setText("N/A");
        psalary.setText("N/A");
        dlone.setText("N/A");
        bouns.setText("N/A");
        lpay_salary_date.setText("N/A");
        w_f_date.setText("N/A");
        w_h_d.setText("N/A");
        tsalary.setText("N/A");
        jTable1.getSelectionModel().clearSelection();
    }

    public void bounsEditable(boolean getboolean) {
        bouns.setEnabled(getboolean);
        print.setEnabled(getboolean);
        print1.setEnabled(getboolean);
        print2.setEnabled(getboolean);
        n_date_salary.setEnabled(getboolean);
    }

}
