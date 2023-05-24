/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.SuggestionList;
import Model.TableAlign;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lakshan
 */
public class RegisterNewVehicle extends javax.swing.JFrame {

    DefaultTableModel dtm;

    public RegisterNewVehicle() {
        initComponents();
        FrameIcon.setIcon(this);
        TableAlign.alignCenter(jTable1);
        dtm = (DefaultTableModel) jTable1.getModel();
        loadTable();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int[] rows = jTable1.getSelectedRows();
                    if (rows.length == 0) {
                        delbtn.setEnabled(false);
                    } else {
                        if (rows.length == 1) {
                            vBrand.setText(jTable1.getValueAt(rows[0], 0).toString());
                            vModel.setText(jTable1.getValueAt(rows[0], 1).toString());
                            vType.setText(jTable1.getValueAt(rows[0], 2).toString());
                        } else {
                            nullify();
                        }
                        delbtn.setEnabled(true);
                    }
                }
            }
        });
    }

    void loadTable() {
        try {
            dtm.setRowCount(0);
            ResultSet r = DB.search("SELECT brand_name, model_name, vehicle_type FROM vehicle_model INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id INNER JOIN vehicle_type ON vehicle_model.vehicle_type_id = vehicle_type.id ORDER BY brand_name, model_name");
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("brand_name"));
                v.add(r.getString("model_name"));
                v.add(r.getString("vehicle_type"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void nullify() {
        vBrand.setText(null);
        vModel.setText(null);
        vType.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        vBrand = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        vModel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        vType = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        delbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register New Vehicle Model");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Vehicle Brand :");

        vBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vBrandKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vBrandKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Vehicle Model :");

        vModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vModelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vModelKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle Type :");

        vType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vTypeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vTypeKeyReleased(evt);
            }
        });

        addbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addbtn.setText("Add / Update");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand", "Model", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        delbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delbtn.setText("Delete Selected");
        delbtn.setEnabled(false);
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vType)
                                    .addComponent(vModel)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vBrand)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(vBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(vType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vBrandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vBrandKeyReleased
        SuggestionList.showList(vBrand, jComboBox1, "SELECT brand_name FROM vehicle_brand WHERE brand_name like '" + vBrand.getText() + "%'", "brand_name", evt, this.getClass().getName());
    }//GEN-LAST:event_vBrandKeyReleased

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(vBrand, jComboBox1);
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void vModelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vModelKeyReleased
        SuggestionList.showList(vModel, jComboBox2, "SELECT model_name FROM vehicle_model WHERE model_name like '" + vModel.getText() + "%'", "model_name", evt, this.getClass().getName());
    }//GEN-LAST:event_vModelKeyReleased

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(vModel, jComboBox2);
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void vTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vTypeKeyReleased
        SuggestionList.showList(vType, jComboBox3, "SELECT vehicle_type FROM vehicle_type WHERE vehicle_type like '" + vType.getText() + "%'", "vehicle_type", evt, this.getClass().getName());
    }//GEN-LAST:event_vTypeKeyReleased

    private void jComboBox3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox3PopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(vType, jComboBox3);
    }//GEN-LAST:event_jComboBox3PopupMenuWillBecomeInvisible

    private void vBrandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vBrandKeyPressed
        if (evt.getKeyCode() == 10) {
            vBrandKeyReleased(evt);
            vModel.grabFocus();
        }
    }//GEN-LAST:event_vBrandKeyPressed

    private void vModelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vModelKeyPressed
        if (evt.getKeyCode() == 10) {
            vModelKeyReleased(evt);
            vType.grabFocus();
        }
    }//GEN-LAST:event_vModelKeyPressed

    private void vTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vTypeKeyPressed
        if (evt.getKeyCode() == 10) {
            vTypeKeyReleased(evt);
            addbtn.grabFocus();
        }
    }//GEN-LAST:event_vTypeKeyPressed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        String vt = vType.getText().trim();
        if (vBrand.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vehicle Brand Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            vBrand.grabFocus();
        } else if (vModel.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vehicle Model Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            vModel.grabFocus();
        } else if (vType.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vehicle Type Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            vType.grabFocus();
        } else {
            try {
                ResultSet r = DB.search("SELECT id FROM vehicle_type WHERE vehicle_type = '" + vt + "'");
                if (r.next()) {
                    m(r.getInt("id"));
                } else {
                    setEnabled(false);
                    new VehicleType(this, vt).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_addbtnActionPerformed

    public void m(int type) throws Exception {
        String vb = vBrand.getText().trim();
        ResultSet r = DB.search("SELECT id FROM vehicle_brand WHERE brand_name = '" + vb + "'");
        int brand;
        if (r.next()) {
            brand = r.getInt("id");
        } else {
            DB.iud("INSERT INTO vehicle_brand(brand_name) VALUES('" + vb + "')");
            r = DB.search("SELECT id FROM vehicle_brand WHERE brand_name = '" + vb + "'");
            r.next();
            brand = r.getInt("id");
        }

        String vm = vModel.getText().trim();
        r = DB.search("SELECT id, vehicle_type_id FROM vehicle_model WHERE model_name = '" + vm + "' AND vehicle_brand_id = '" + brand + "'");
        if (r.next()) {
            int Model = r.getInt("id");
            if (r.getInt("vehicle_type_id") != type) {
                r = DB.search("SELECT vehicle_model_id FROM customer_vehicle WHERE vehicle_model_id = '" + Model + "'");
                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "Can't Update Vehicle type of \'" + vb + " " + vm + "\' since there are invoice records related to this Vehicle Model.", "Vehicle Model in use", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DB.iud("UPDATE vehicle_model SET vehicle_type_id = '" + type + "' WHERE id = '" + Model + "'");
                }
            }
        } else {
            DB.iud("INSERT INTO vehicle_model(model_name, vehicle_brand_id, vehicle_type_id) VALUES('" + vm + "', '" + brand + "', '" + type + "')");
        }
        loadTable();
        nullify();
        vBrand.grabFocus();
        Customer.getObject().loadCombos();
    }

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int[] rows = jTable1.getSelectedRows();
            for (int row : rows) {
                String vm = jTable1.getValueAt(row, 1).toString();
                String vb = jTable1.getValueAt(row, 0).toString();

                ResultSet r = DB.search("SELECT id FROM vehicle_brand WHERE brand_name = '" + vb + "'");
                r.next();
                int brand = r.getInt("id");
                r = DB.search("SELECT id, vehicle_type_id FROM vehicle_model WHERE model_name = '" + vm + "' AND vehicle_brand_id = '" + brand + "'");
                if (r.next()) {
                    int Model = r.getInt("id");
                    int type = r.getInt("vehicle_type_id");
                    r = DB.search("SELECT vehicle_model_id FROM customer_vehicle WHERE vehicle_model_id = '" + Model + "'");
                    if (r.next()) {
                        JOptionPane.showMessageDialog(this, "Can't Delete Vehicle Model \'" + vb + " " + vm + "\' since there are invoice records related to this Vehicle Model.", "Vehicle Model in use", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        r = DB.search("SELECT vehicle_model_id FROM vehicle_part_details WHERE vehicle_model_id = '" + Model + "'");
                        if (r.next()) {
                            JOptionPane.showMessageDialog(this, "Can't Delete Vehicle Model \'" + vb + " " + vm + "\' since there are vehicle parts related to this Vehicle Model.", "Vehicle Model in use", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            DB.iud("DELETE FROM vehicle_model WHERE id = '" + Model + "'");
                            r = DB.search("SELECT id FROM vehicle_model WHERE vehicle_brand_id = '" + brand + "'");
                            if (!r.next()) {
                                DB.iud("DELETE FROM vehicle_brand WHERE id = '" + brand + "'");
                            }
                            r = DB.search("SELECT id FROM vehicle_model WHERE vehicle_type_id = '" + type + "'");
                            if (!r.next()) {
                                DB.iud("DELETE FROM service_price WHERE vehicle_type_id = '" + type + "'");
                                DB.iud("DELETE FROM vehicle_type WHERE id = '" + type + "'");
                            }
                        }
                    }
                }
            }
            loadTable();
            Customer.getObject().loadCombos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home.getObject().setEnabled(true);
        Home.getObject().requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home.getObject().setEnabled(true);
        Home.getObject().requestFocus();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterNewVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterNewVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterNewVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterNewVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterNewVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField vBrand;
    private javax.swing.JTextField vModel;
    private javax.swing.JTextField vType;
    // End of variables declaration//GEN-END:variables
}
