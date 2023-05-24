package GUI;

import DB.DB;
import Model.TableAlign;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import validation.Validation;

public class Employee_Maneger extends javax.swing.JPanel {

    public String title = "Employee Maneger";
    DefaultTableModel dtm;
    DecimalFormat df;

    private Employee_Maneger() {
        initComponents();
        df = new DecimalFormat("0.##");
        TableAlign.alignCenter(jTable1, new int[]{0});
        TableAlign.alignRight(jTable1, new int[]{1});
        dtm = (DefaultTableModel) jTable1.getModel();
        try {
            ResultSet r = DB.search("SELECT type, salary FROM employee_type WHERE type <> 'Admin'");
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("type"));
                v.add(r.getString("Salary"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
        }

        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.UPDATE) {
                    svbtn.setEnabled(true);
                }
            }
        });

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int[] rows = jTable1.getSelectedRows();
                    if (rows.length == 0) {
                        delbtn.setEnabled(false);
                    } else {
                        delbtn.setEnabled(true);
                    }
                }
            }
        });
    }
    public static Employee_Maneger o;

    public static synchronized Employee_Maneger getObject() {
        if (o == null) {
            o = new Employee_Maneger();
        }
        return o;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        eType = new javax.swing.JTextField();
        salary = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        svbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Employee Type :");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Salary :");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Type", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        eType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eTypeKeyTyped(evt);
            }
        });

        salary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salaryKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        svbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        svbtn.setText("Save");
        svbtn.setEnabled(false);
        svbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtnActionPerformed(evt);
            }
        });

        delbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delbtn.setText("Delete Selected");
        delbtn.setEnabled(false);
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eType)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salary)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 297, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(svbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {delbtn, svbtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(eType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svbtn)
                    .addComponent(delbtn)
                    .addComponent(jButton4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String et = eType.getText().trim();
        boolean b = true;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (et.equalsIgnoreCase(jTable1.getValueAt(i, 0).toString()) || et.equalsIgnoreCase("Admin")) {
                b = false;
                break;
            }
        }
        if (b) {
            String s = salary.getText().trim();
            if (!et.equals("") && !s.equals("")) {
                Vector v = new Vector();
                v.add(et);
                v.add(s);
                dtm.addRow(v);
                eType.setText(null);
                salary.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "User Type already exists.", "Duplicate User Type", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void svbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtnActionPerformed
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
                String type = jTable1.getValueAt(i, 0).toString();
                String s = df.format(Double.parseDouble(jTable1.getValueAt(i, 1).toString()));
                ResultSet r = DB.search("SELECT id FROM employee_type WHERE type = '" + type + "'");
                if (r.next()) {
                    DB.iud("UPDATE employee_type SET salary = '" + s + "' WHERE id = '" + r.getInt("id") + "'");
                } else {
                    DB.iud("INSERT INTO employee_type(type, salary) VALUES('" + type + "', '" + s + "')");
                }
                Employee.getObject().genarateCode();
                svbtn.setEnabled(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_svbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int[] rows = jTable1.getSelectedRows();
            for (int row : rows) {
                String type = jTable1.getValueAt(row, 0).toString();
                ResultSet r = DB.search("SELECT id FROM employee_type WHERE type = '" + type + "'");
                r.next();
                int id = r.getInt("id");
                r = DB.search("SELECT employee_type_id FROM employee WHERE employee_type_id = '" + id + "'");
                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "Can't delete employee type \'" + type + "\' since there are employees assingned to this employee type.", "Employee type in use", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DB.iud("DELETE FROM employee_type WHERE id = '" + id + "'");
                    dtm.removeRow(row);
                }
            }
            Employee.getObject().genarateCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void salaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryKeyTyped
        Validation.validateAmount(evt, salary);
    }//GEN-LAST:event_salaryKeyTyped

    private void eTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eTypeKeyTyped
        Validation.validateItemName(evt, eType);
    }//GEN-LAST:event_eTypeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField eType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField salary;
    private javax.swing.JButton svbtn;
    // End of variables declaration//GEN-END:variables
}
