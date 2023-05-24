/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import Model.TableAlign;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 *
 * @author Lakshan
 */
public class Stock extends javax.swing.JPanel {

    public String title = "Stock";
    public static Stock o;
    DefaultTableModel dtm;
    SimpleDateFormat DBSDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");

    private Stock() {
        initComponents();
        TableAlign.alignCenter(stockTable, new int[]{0, 1, 2, 3, 4, 7, 8});
        TableAlign.alignRight(stockTable, new int[]{5, 6});
        dtm = (DefaultTableModel) stockTable.getModel();

        loadCombos();
        stockTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int[] rows = stockTable.getSelectedRows();
                    String s;
                    switch (rows.length) {
                        case 0:
                            obs.setEnabled(false);
                            genBar.setEnabled(false);
                            break;
                        case 1:
                            s = stockTable.getValueAt(rows[0], 8).toString();
                            if (s.equals("Active")) {
                                obs.setText("Mark As Obsolete");
                                genBar.setEnabled(true);
                            } else {
                                obs.setText("Mark As Active");
                                genBar.setEnabled(false);
                            }
                            obs.setEnabled(true);
                            break;
                        default:
                            s = stockTable.getValueAt(rows[0], 8).toString();
                            if (s.equals("Active")) {
                                obs.setText("Mark As Obsolete");
                                genBar.setEnabled(true);
                            } else {
                                obs.setText("Mark As Active");
                                genBar.setEnabled(false);
                            }
                            obs.setEnabled(true);
                            for (int i = 1; i < rows.length; i++) {
                                if (!stockTable.getValueAt(rows[i], 8).toString().equals(s)) {
                                    obs.setEnabled(false);
                                    genBar.setEnabled(false);
                                    break;
                                }
                            }
                            break;
                    }
                }
            }
        });
    }

    public static Stock getObject() {
        if (o == null) {
            o = new Stock();
        }
        return o;
    }

    void loadCombos() {
        try {
            item_category.removeAllItems();
            item_category.addItem("All");
            ResultSet r = DB.search("SELECT category_name FROM part_category");
            while (r.next()) {
                item_category.addItem(r.getString("category_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        item_category = new javax.swing.JComboBox<>();
        search = new javax.swing.JTextField();
        obs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        itemBrand = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        genBar = new javax.swing.JButton();

        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Category:");

        item_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        item_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_categoryActionPerformed(evt);
            }
        });

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        obs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        obs.setText("Mark As Obsolete");
        obs.setEnabled(false);
        obs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obsActionPerformed(evt);
            }
        });

        stockTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock ID", "Item", "Brand", "Model / Type", "Qty", "Buying Price", "Selling Price", "Stock Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(stockTable);
        if (stockTable.getColumnModel().getColumnCount() > 0) {
            stockTable.getColumnModel().getColumn(7).setMinWidth(160);
            stockTable.getColumnModel().getColumn(8).setPreferredWidth(80);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Brand :");

        itemBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBrandActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("View Stocks that need to be refilled");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        genBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genBar.setText("Generate Barcodes");
        genBar.setEnabled(false);
        genBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genBarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(search))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(genBar, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(obs, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(obs)
                    .addComponent(genBar)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void obsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obsActionPerformed
        try {
            int[] rows = stockTable.getSelectedRows();
            for (int row : rows) {
                String stockID = stockTable.getValueAt(row, 0).toString();
                if (obs.getText().equals("Mark As Obsolete")) {
                    stockTable.setValueAt("Obsolete", row, 8);
                    DB.iud("UPDATE stock SET status_id = '0' WHERE id = '" + stockID + "'");
                    DB.iud("DELETE FROM notified_stock WHERE stock_id = " + stockID);
                    if (Customer.o != null) {
                        for (int i = 0; i < Customer.getObject().itemTable.getRowCount(); i++) {
                            String itC = stockTable.getValueAt(row, 1).toString();
                            String itB = stockTable.getValueAt(row, 2).toString();
                            String itM = stockTable.getValueAt(row, 3).toString();
                            if (Customer.getObject().itemTable.getValueAt(i, 0).toString().equals(itC) && Customer.getObject().itemTable.getValueAt(i, 1).toString().equals(itB) && Customer.getObject().itemTable.getValueAt(i, 2).toString().equals(itM)) {
                                Customer.getObject().dtm.removeRow(i);
                                String s;
                                if (itM.equals("N/A")) {
                                    s = itB + " " + itC;
                                } else {
                                    s = itB + " " + itC + " [ " + itM + " ]";
                                }
                                NotificationPanel.showNotification("Removed From Invoice", s,"Stock " + stockID + " was already on the Invoice Item List.", NotificationPanel.WARN);
                                break;
                            }
                        }
                    }
                    genBar.setEnabled(false);
                } else {
                    stockTable.setValueAt("Active", row, 8);
                    DB.iud("UPDATE stock SET status_id = '1' WHERE id = '" + stockID + "'");
                    ResultSet r = DB.search("SELECT min_quota FROM part_category WHERE category_name = '" + stockTable.getValueAt(row, 1) + "'");
                    r.next();
                    double min = r.getDouble("min_quota");
                    if (Double.parseDouble(stockTable.getValueAt(row, 4).toString()) <= min) {
                        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        DB.iud("INSERT INTO notified_stock(ns_date, stock_id) VALUES ('" + now + "', '" + stockID + "') ON DUPLICATE KEY UPDATE ns_date = '" + now + "';");
                    }
                    genBar.setEnabled(true);
                }
            }
            if (obs.getText().equals("Mark As Obsolete")) {
                obs.setText("Mark As Active");
            } else {
                obs.setText("Mark As Obsolete");
            }
            if (Customer.o != null) {
                Customer.getObject().loadCombos();
            }
            StockNotifications.getObject().loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_obsActionPerformed

    private void item_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_categoryActionPerformed
        try {
            if (item_category.getItemCount() != 0) {
                itemBrand.removeAllItems();
                itemBrand.addItem("All");
                ResultSet r;
                if (item_category.getSelectedItem().toString().equals("All")) {
                    r = DB.search("SELECT DISTINCT(brand_name) FROM part_brand");
                } else {
                    r = DB.search("SELECT DISTINCT(brand_name) FROM part INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + item_category.getSelectedItem().toString() + "'");
                }
                while (r.next()) {
                    itemBrand.addItem(r.getString("brand_name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_item_categoryActionPerformed

    private void itemBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBrandActionPerformed
        try {
            if (itemBrand.getItemCount() != 0) {
                dtm.setRowCount(0);
                String itCat = item_category.getSelectedItem().toString();
                String itBrand = itemBrand.getSelectedItem().toString();
                ResultSet r;
                if (itCat.equals("All") && itBrand.equals("All")) {
                    r = DB.search("SELECT DISTINCT(stock.id), category_name, brand_name, part_model, stock.qty, buy_price, selling_price, `datetime`, status_id FROM stock INNER JOIN (SELECT part_model_id, MAX(buying_price) AS buy_price FROM grn_item GROUP BY part_model_id) AS g ON stock.part_model_id = g.part_model_id INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id");
                } else if (itBrand.equals("All")) {
                    r = DB.search("SELECT DISTINCT(stock.id), category_name, brand_name, part_model, stock.qty, buy_price, selling_price, `datetime`, status_id FROM stock INNER JOIN (SELECT part_model_id, MAX(buying_price) AS buy_price FROM grn_item GROUP BY part_model_id) AS g ON stock.part_model_id = g.part_model_id INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + itCat + "'");
                } else if (itCat.equals("All")) {
                    r = DB.search("SELECT DISTINCT(stock.id), category_name, brand_name, part_model, stock.qty, buy_price, selling_price, `datetime`, status_id FROM stock INNER JOIN (SELECT part_model_id, MAX(buying_price) AS buy_price FROM grn_item GROUP BY part_model_id) AS g ON stock.part_model_id = g.part_model_id INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE brand_name = '" + itBrand + "'");
                } else {
                    r = DB.search("SELECT DISTINCT(stock.id), category_name, brand_name, part_model, stock.qty, buy_price, selling_price, `datetime`, status_id FROM stock INNER JOIN (SELECT part_model_id, MAX(buying_price) AS buy_price FROM grn_item GROUP BY part_model_id) AS g ON stock.part_model_id = g.part_model_id INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + itCat + "' AND brand_name = '" + itBrand + "'");
                }
                while (r.next()) {
                    Vector v = new Vector();
                    v.add(r.getInt("id"));
                    v.add(r.getString("category_name"));
                    v.add(r.getString("brand_name"));
                    v.add(r.getString("part_model"));
                    v.add(r.getString("qty"));
                    v.add(r.getString("buy_price"));
                    v.add(r.getString("selling_price"));
                    v.add(SDF.format(DBSDF.parse(r.getString("datetime"))));
                    if (r.getInt("status_id") == 1) {
                        v.add("Active");
                    } else {
                        v.add("Obsolete");
                    }
                    dtm.addRow(v);
                }
                search.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemBrandActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        TableRowSorter ts = new TableRowSorter(dtm);
        ts.setRowFilter(RowFilter.regexFilter("(?i)" + search.getText()));
        stockTable.setRowSorter(ts);
    }//GEN-LAST:event_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (StockNotifications.o == null) {
            StockNotifications.getObject().loadTable();
        }
        StockNotifications.getObject().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void genBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genBarActionPerformed

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        if (fc.showDialog(this, "Generate Barcodes") == JFileChooser.APPROVE_OPTION) {
            genBar.setText("Generating Barcodes ...");
            genBar.setEnabled(false);
            new Thread() {
                @Override
                public void run() {
                    try {
                        File f = fc.getSelectedFile();
                        Code39Bean bean = new Code39Bean();
                        int dpi = 150;
                        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi));
                        bean.setWideFactor(3);
                        bean.doQuietZone(false);
                        int[] rows = stockTable.getSelectedRows();
                        for (int row : rows) {
                            String s;
                            if (stockTable.getValueAt(row, 3).toString().equals("N/A")) {
                                s = stockTable.getValueAt(row, 2) + " " + stockTable.getValueAt(row, 1) + " STK" + stockTable.getValueAt(row, 0) + ".png";
                            } else {
                                s = stockTable.getValueAt(row, 2) + " " + stockTable.getValueAt(row, 1) + " " + stockTable.getValueAt(row, 3) + " STK" + stockTable.getValueAt(row, 0) + ".png";
                            }
                            File outputFile = new File(f, s);
                            OutputStream os = new FileOutputStream(outputFile);
                            BitmapCanvasProvider canvas = new BitmapCanvasProvider(os, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
                            bean.generateBarcode(canvas, "STK-" + String.format("%010d", stockTable.getValueAt(row, 0)) + "E");
                            canvas.finish();
                            os.close();
                        }
                        NotificationPanel.showNotification("Barcode", rows.length + " barcode(s) have been generated to", f.getAbsolutePath(), NotificationPanel.SUCCESS);
                        genBar.setText("Generate Barcodes");
                        genBar.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }//GEN-LAST:event_genBarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton genBar;
    private javax.swing.JComboBox<String> itemBrand;
    private javax.swing.JComboBox<String> item_category;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton obs;
    private javax.swing.JTextField search;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
