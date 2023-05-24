package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.SuggestionList;
import Model.TableAlign;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import validation.Validation;

public class ViewServiceHistory extends javax.swing.JFrame {

    DefaultTableModel dtm2;
    DecimalFormat df;

    public ViewServiceHistory() {
        initComponents();
        FrameIcon.setIcon(this);
        TableAlign.alignCenter(jTable1);
        TableAlign.alignRight(jTable2, new int[]{3});
        TableAlign.alignCenter(jTable2, new int[]{0, 1, 2, 4});
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm2 = (DefaultTableModel) jTable2.getModel();
        SimpleDateFormat DBSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
        df = new DecimalFormat("0.##");
        dtm2.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE || e.getType() == TableModelEvent.UPDATE) {
                    if (dtm2.getRowCount() != 0) {
                        Double itCost = 0d;
                        for (int i = 0; i < jTable2.getRowCount(); i++) {
                            double prc = Double.parseDouble(jTable2.getValueAt(i, 3).toString());
                            double qty = Double.parseDouble(jTable2.getValueAt(i, 4).toString());
                            itCost = itCost + prc * qty;
                        }
                        itemCost.setText(df.format(itCost));
                        total.setText(df.format(Double.parseDouble(sCharge.getText()) + itCost));
                    }
                }
            }
        });

        vNo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                m();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                m();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                m();
            }

            void m() {
                try {
                    dtm.setRowCount(0);
                    ResultSet r = DB.search("SELECT datetime, time, id FROM invoice WHERE vehicle_licen_plate = '" + vNo.getText() + "' ORDER BY id DESC");
                    while (r.next()) {
                        Vector v = new Vector();
                        v.add(SDF.format(DBSDF.parse(r.getString("datetime") + " " + r.getString("time"))));
                        v.add(r.getString("id"));
                        dtm.addRow(v);
                    }
                    if (jTable1.getRowCount() == 0) {
                        jButton1.setEnabled(false);
                    } else {
                        jButton1.setEnabled(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        vNo.setText(Customer.getObject().vNumber.getText());
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int[] rows = jTable1.getSelectedRows();
                    if (rows.length == 1) {
                        try {
                            String invID = jTable1.getValueAt(rows[0], 1).toString();
                            inID.setText(invID);
                            dt.setText(jTable1.getValueAt(rows[0], 0).toString());
                            ResultSet r = DB.search("SELECT mileage, service_charge, payment, service_type, payment_method FROM invoice INNER JOIN service ON invoice.service_id = service.id INNER JOIN payment_method ON invoice.payment_method_id = payment_method.id WHERE invoice.id = '" + invID + "'");
                            r.next();
                            milage.setText(r.getString("mileage"));
                            sCharge.setText(r.getString("service_charge"));
                            payment.setText(r.getString("payment"));
                            sType.setText(r.getString("service_type"));
                            payMethod.setText(r.getString("payment_method"));
                            dtm2.setRowCount(0);
                            r = DB.search("SELECT category_name, brand_name, part_model, selling_price, invoice_item.qty FROM invoice_item INNER JOIN part_model ON invoice_item.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id INNER JOIN stock ON invoice_item.stock_id = stock.id WHERE invoice_item.invoice_id = '" + invID + "'");
                            while (r.next()) {
                                Vector v = new Vector();
                                v.add(r.getString("category_name"));
                                v.add(r.getString("brand_name"));
                                v.add(r.getString("part_model"));
                                v.add(r.getString("selling_price"));
                                v.add(r.getString("qty"));
                                dtm2.addRow(v);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        nullify();
                    }
                }
            }
        });
    }

    void nullify() {
        String s = "N / A";
        milage.setText(s);
        sType.setText(s);
        sCharge.setText(s);
        itemCost.setText(s);
        total.setText(s);
        payment.setText(s);
        payMethod.setText(s);
        inID.setText(s);
        dt.setText(s);
        dtm2.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sType = new javax.swing.JLabel();
        sCharge = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        itemCost = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        payment = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        payMethod = new javax.swing.JLabel();
        milage = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        inID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vNo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Service History");

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

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Date", "Invoce ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(140);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Service Type :");

        sType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sType.setText("N / A");

        sCharge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sCharge.setText("N / A");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Service Charge (Rs.) :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Applied Items :");

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Brand", "Model", "Price", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Item Cost (Rs.) :");

        itemCost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemCost.setText("N / A");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Total (Rs.) :");

        total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total.setText("N / A");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Payment (Rs.) :");

        payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payment.setText("N / A");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Payment Method :");

        payMethod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payMethod.setText("N / A");

        milage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        milage.setText("N / A");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Mileage :");

        inID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inID.setText("N / A");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Invoice ID :");

        dt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dt.setText("N / A");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Service Date :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sType, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sCharge, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(milage, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemCost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(payment, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(payMethod, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sType)
                    .addComponent(jLabel17)
                    .addComponent(dt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sCharge)
                    .addComponent(jLabel16)
                    .addComponent(inID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(milage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(itemCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(payment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(payMethod))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Vehicle No.");

        vNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vNoKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("View Service Summary Report");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vNo)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(vNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vNoKeyReleased
        SuggestionList.showList(vNo, jComboBox1, "SELECT licen_plate FROM customer_vehicle WHERE licen_plate LIKE '" + vNo.getText() + "%'", "licen_plate", evt, this.getClass().getName());
    }//GEN-LAST:event_vNoKeyReleased

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(vNo, jComboBox1);
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void vNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vNoKeyTyped
        Validation.validateText(evt, vNo);
    }//GEN-LAST:event_vNoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String vehicle_no1 = vNo.getText();
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("vehicle_no", vehicle_no1);
        try {
            InputStream jr = ViewServiceHistory.class.getResourceAsStream("/BILL/Custormer_summary(ind).jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, DB.getConnection());
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewServiceHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewServiceHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewServiceHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewServiceHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewServiceHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dt;
    private javax.swing.JLabel inID;
    private javax.swing.JLabel itemCost;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel milage;
    private javax.swing.JLabel payMethod;
    private javax.swing.JLabel payment;
    private javax.swing.JLabel sCharge;
    private javax.swing.JLabel sType;
    private javax.swing.JLabel total;
    private javax.swing.JTextField vNo;
    // End of variables declaration//GEN-END:variables
}
