/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.TableAlign;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import validation.Validation;

/**
 *
 * @author Lakshan
 */
public class RegisterItem extends javax.swing.JFrame {

    DecimalFormat df;

    public RegisterItem() {
        initComponents();
        FrameIcon.setIcon(this);
        loadCombo();
        df = new DecimalFormat("0.###");
        TableAlign.alignCenter(jTable1);
        TableAlign.alignCenter(jTable2);
        dtm = (DefaultTableModel) jTable1.getModel();
        dtm2 = (DefaultTableModel) jTable2.getModel();
        loadTable();
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    int[] rows = jTable2.getSelectedRows();
                    if (rows.length == 0) {
                        delbtn.setEnabled(false);
                    } else {
                        if (rows.length == 1) {
                            jButton4ActionPerformed(null);
                            String itC = jTable2.getValueAt(rows[0], 0).toString();
                            String itB = jTable2.getValueAt(rows[0], 1).toString();
                            String itM = jTable2.getValueAt(rows[0], 2).toString();
                            itemCategory.setText(itC);
                            itemBrand.setText(itB);
                            if (itM.equals("N/A")) {
                                itemModel.setText(null);
                            } else {
                                itemModel.setText(itM);
                            }
                            try {
                                ResultSet r = DB.search("SELECT part_model.id FROM part_model INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + itC + "' AND brand_name = '" + itB + "' AND part_model = '" + itM + "'");
                                r.next();
                                r = DB.search("SELECT brand_name, model_name FROM vehicle_part_details INNER JOIN vehicle_model ON vehicle_part_details.vehicle_model_id = vehicle_model.id INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id WHERE part_model_id = '" + r.getInt("id") + "'");
                                while (r.next()) {
                                    Vector v = new Vector();
                                    v.add(r.getString("brand_name"));
                                    v.add(r.getString("model_name"));
                                    dtm.addRow(v);
                                    vModel.removeItem("N/A");
                                    if (vModel.getItemCount() == 1) {
                                        vModel.removeAllItems();
                                        jButton3.setEnabled(false);
                                    } else {
                                        vModel.removeItem(r.getString("model_name") + "  [" + r.getString("brand_name") + "]");
                                    }
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            itemCategory.setText(null);
                            itemBrand.setText(null);
                            itemModel.setText(null);
                            jButton4ActionPerformed(null);
                        }
                        delbtn.setEnabled(true);
                    }
                }
            }
        });

        itemCategory.getDocument().addDocumentListener(new DocumentListener() {
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
                    ResultSet r = DB.search("SELECT min_quota FROM part_category WHERE category_name = '" + itemCategory.getText().trim() + "'");
                    if (r.next()) {
                        min.setText(r.getString("min_quota"));
                    } else {
                        min.setText(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    int i = 0;
    boolean key = true;
    DefaultTableModel dtm;
    DefaultTableModel dtm2;

    void loadCombo() {
        try {
            ResultSet r = DB.search("SELECT model_name, brand_name FROM vehicle_model INNER JOIN vehicle_brand on vehicle_model.vehicle_brand_id = vehicle_brand.id ORDER BY model_name ASC");
            while (r.next()) {
                vModel.addItem(r.getString("model_name") + "  [" + r.getString("brand_name") + "]");
            }
        } catch (Exception e) {
        }
    }

    void loadTable() {
        try {
            dtm2.setRowCount(0);
            ResultSet r = DB.search("SELECT category_name, brand_name, part_model FROM part_model INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id ORDER BY category_name, brand_name");
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("category_name"));
                v.add(r.getString("brand_name"));
                v.add(r.getString("part_model"));
                dtm2.addRow(v);
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemModel = new javax.swing.JTextField();
        itemBrand = new javax.swing.JTextField();
        itemCategory = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vModel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        delbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        min = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register New Product");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(986, 476));
        setPreferredSize(new java.awt.Dimension(986, 476));
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        itemModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemModelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemModelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemModelKeyTyped(evt);
            }
        });

        itemBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemBrandKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemBrandKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemBrandKeyTyped(evt);
            }
        });

        itemCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemCategory.setMinimumSize(new java.awt.Dimension(225, 23));
        itemCategory.setPreferredSize(new java.awt.Dimension(225, 23));
        itemCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemCategoryKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemCategoryKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemCategoryKeyTyped(evt);
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
        jLabel1.setText("Item :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Brand :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Type / Model :");

        vModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/A" }));
        vModel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vModelItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Applicable Vehicle Model(s) :");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Add / Update Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle Brand", "Vehicle Model"
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

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Add");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Brand", "Model"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        delbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delbtn.setText("Delete Selected");
        delbtn.setEnabled(false);
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Search :");

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Notify when this item's qty gets lower than :");

        min.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        min.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                minKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(vModel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(itemBrand)
                                    .addComponent(itemModel)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(itemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delbtn)
                        .addComponent(jLabel5)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(itemModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCategoryKeyReleased
        key = true;
        if (itemCategory.getText().isEmpty()) {
            jComboBox1.hidePopup();
        } else {
            String s = itemCategory.getText().substring(0, itemCategory.getSelectionStart());
            if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
                itemCategory.setText(s);
            }
            try {
                if (Character.isDefined(evt.getKeyChar()) && evt.getKeyCode() != 10) {
                    ResultSet r = DB.search("SELECT category_name FROM part_category WHERE category_name LIKE '" + itemCategory.getText() + "%'");
                    Vector v = new Vector();
                    while (r.next()) {
                        v.add(r.getString("category_name"));
                    }
                    DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
                    jComboBox1.setModel(dcm);
                    if (!(jComboBox1.getItemCount() == 0)) {
                        jComboBox1.showPopup();
                        if (evt.getKeyCode() == 8 || evt.getKeyCode() == 127) {
                            itemCategory.setText(s);
                        } else {
                            int x = itemCategory.getText().length();
                            itemCategory.setText(jComboBox1.getSelectedItem().toString());
                            itemCategory.setSelectionStart(x);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jComboBox1.isPopupVisible()) {
                int count = jComboBox1.getItemCount();
                switch (evt.getKeyCode()) {
                    case 38:
                        itemCategory.setText(s);
                        i--;
                        if (i == -1) {
                            i = count - 1;
                        }
                        jComboBox1.setSelectedIndex(i);
                        break;
                    case 40:
                        itemCategory.setText(s);
                        i++;
                        if (i == count) {
                            i = 0;
                        }
                        jComboBox1.setSelectedIndex(i);
                        break;
                    case 10:
                        jComboBox1.setSelectedIndex(i);
                        itemCategory.setText(jComboBox1.getSelectedItem().toString());
                        jComboBox1.hidePopup();
                        i = 0;
                        break;
                    default:
                        i = 0;
                        break;
                }
            }
        }
        key = false;
    }//GEN-LAST:event_itemCategoryKeyReleased

    private void itemBrandKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemBrandKeyReleased
        key = true;
        if (itemBrand.getText().isEmpty()) {
            jComboBox2.hidePopup();
        } else {
            String s = itemBrand.getText().substring(0, itemBrand.getSelectionStart());
            if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
                itemBrand.setText(s);
            }
            try {
                if (Character.isDefined(evt.getKeyChar()) && evt.getKeyCode() != 10) {
                    ResultSet r = DB.search("SELECT brand_name FROM part_brand WHERE brand_name LIKE '" + itemBrand.getText() + "%'");
                    Vector v = new Vector();
                    while (r.next()) {
                        v.add(r.getString("brand_name"));
                    }
                    DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
                    jComboBox2.setModel(dcm);
                    if (!(jComboBox2.getItemCount() == 0)) {
                        jComboBox2.showPopup();
                        if (evt.getKeyCode() == 8 || evt.getKeyCode() == 127) {
                            itemBrand.setText(s);
                        } else {
                            int x = itemBrand.getText().length();
                            itemBrand.setText(jComboBox2.getSelectedItem().toString());
                            itemBrand.setSelectionStart(x);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jComboBox2.isPopupVisible()) {
                int count = jComboBox2.getItemCount();
                switch (evt.getKeyCode()) {
                    case 38:
                        itemBrand.setText(s);
                        i--;
                        if (i == -1) {
                            i = count - 1;
                        }
                        jComboBox2.setSelectedIndex(i);
                        break;
                    case 40:
                        itemBrand.setText(s);
                        i++;
                        if (i == count) {
                            i = 0;
                        }
                        jComboBox2.setSelectedIndex(i);
                        break;
                    case 10:
                        jComboBox2.setSelectedIndex(i);
                        itemBrand.setText(jComboBox2.getSelectedItem().toString());
                        jComboBox2.hidePopup();
                        i = 0;
                        break;
                    default:
                        i = 0;
                        break;
                }
            }

        }
        key = false;
    }//GEN-LAST:event_itemBrandKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String itCat = itemCategory.getText().trim();
        String itBrand = itemBrand.getText().trim();

        if (itCat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            itemCategory.grabFocus();
        } else {
            if (itBrand.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Item Brand Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                itemBrand.grabFocus();
            } else {
                if (min.getText().isEmpty() || Double.parseDouble(min.getText()) == 0) {
                    JOptionPane.showMessageDialog(this, "Minimum quota cannot be 0 or empty.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                    min.grabFocus();
                } else {
                    if (!(itCat.equals("") || itBrand.equals(""))) {
                        String itModel = itemModel.getText().trim();
                        int catID;
                        int brandID;
                        int partID;
                        int partModelID;
                        try {
                            ResultSet r = DB.search("SELECT id, min_quota FROM part_category WHERE category_name = '" + itCat + "'");
                            if (r.next()) {
                                catID = r.getInt("id");
                                double minqty = r.getDouble("min_quota");
                                double newMinQty = Double.parseDouble(min.getText());
                                if (newMinQty != minqty) {
                                    DB.iud("UPDATE part_category SET min_quota = '" + df.format(newMinQty) + "' WHERE id = '" + catID + "'");
                                    r = DB.search("SELECT stock.id, qty FROM stock INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id WHERE part_category_id = " + catID);
                                    while (r.next()) {
                                        if (newMinQty < r.getDouble("qty")) {
                                            DB.iud("DELETE FROM notified_stock WHERE stock_id = " + r.getInt("id"));
                                        } else {
                                            String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                                            DB.iud("INSERT INTO notified_stock(ns_date, stock_id) VALUES ('" + now + "', '" + r.getInt("id") + "') ON DUPLICATE KEY UPDATE ns_date = '" + now + "'");
                                        }
                                    }
                                }
                            } else {
                                DB.iud("INSERT INTO part_category(category_Name, min_quota) VALUES('" + itCat + "', '" + df.format(Double.parseDouble(min.getText())) + "')");
                                r = DB.search("SELECT id FROM part_category WHERE category_name = '" + itCat + "'");
                                r.next();
                                catID = r.getInt("id");
                            }

                            r = DB.search("SELECT brand_name, id FROM part_brand WHERE brand_name = '" + itBrand + "'");
                            if (r.next()) {
                                brandID = r.getInt("id");
                            } else {
                                DB.iud("INSERT INTO part_brand(brand_name) VALUES('" + itBrand + "')");
                                r = DB.search("SELECT id FROM part_brand WHERE brand_name = '" + itBrand + "'");
                                r.next();
                                brandID = r.getInt("id");
                            }

                            r = DB.search("SELECT id FROM part WHERE part_category_id = '" + catID + "' AND part_brand_id = '" + brandID + "'");
                            if (r.next()) {
                                partID = r.getInt("id");
                            } else {
                                DB.iud("INSERT INTO part(part_category_id, part_brand_id) VALUES('" + catID + "', '" + brandID + "')");
                                r = DB.search("SELECT id FROM part WHERE part_category_id = '" + catID + "' AND part_brand_id = '" + brandID + "'");
                                r.next();
                                partID = r.getInt("id");
                            }

                            if (itModel.equals("")) {
                                itModel = "N/A";
                            }
                            r = DB.search("SELECT id FROM part_model WHERE part_model = '" + itModel + "' AND part_id = '" + partID + "'");
                            if (r.next()) {
                                partModelID = r.getInt("id");
                            } else {
                                DB.iud("INSERT INTO part_model(part_model, part_id) VALUES('" + itModel + "', '" + partID + "')");
                                r = DB.search("SELECT id FROM part_model WHERE part_model = '" + itModel + "' AND part_id = '" + partID + "'");
                                r.next();
                                partModelID = r.getInt("id");
                            }

                            if (!itModel.equals("")) {
                                r = DB.search("SELECT part_model_id FROM vehicle_part_details WHERE part_model_id = '" + partModelID + "'");
                                if (r.next()) {
                                    DB.iud("DELETE FROM vehicle_part_details WHERE part_model_id = '" + partModelID + "'");
                                }
                                for (int j = 0; j < jTable1.getRowCount(); j++) {
                                    r = DB.search("SELECT vehicle_model.id FROM vehicle_model INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id WHERE model_name = '" + jTable1.getValueAt(j, 1) + "' AND brand_name = '" + jTable1.getValueAt(j, 0) + "'");
                                    r.next();
                                    DB.iud("INSERT INTO vehicle_part_details(part_model_id, vehicle_model_id) VALUES('" + partModelID + "', '" + r.getInt("id") + "')");
                                }
                            }
                            jButton4ActionPerformed(null);
                            loadTable();
                            itemModel.setText("");

                            if (Customer.o != null) {
                                Customer.getObject().loadCombos();
                            }
                            if (Supplier.o != null) {
                                Supplier.getObject().loadCombos();
                            }
                            StockNotifications.getObject().loadTable();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void vModelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vModelItemStateChanged
        if (vModel.getItemCount() != 0) {
            if (vModel.getSelectedItem().toString().equals("N/A")) {
                jButton3.setEnabled(false);
            } else {
                jButton3.setEnabled(true);
            }
        }
    }//GEN-LAST:event_vModelItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Vector v = new Vector();
        v.add(vModel.getSelectedItem().toString().split("  \\[")[1].substring(0, vModel.getSelectedItem().toString().split(" \\[")[1].length() - 1));
        v.add(vModel.getSelectedItem().toString().split("  \\[")[0]);
        dtm.addRow(v);
        vModel.removeItem("N/A");
        if (vModel.getItemCount() == 1) {
            vModel.removeAllItems();
            jButton3.setEnabled(false);
        } else {
            vModel.removeItem(vModel.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dtm.setRowCount(0);
        vModel.removeAllItems();
        vModel.addItem("N/A");
        loadCombo();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        if (key == false) {
            itemCategory.setText(jComboBox1.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        if (key == false) {
            itemBrand.setText(jComboBox2.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home.getObject().setEnabled(true);
        Home.getObject().requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void itemModelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemModelKeyReleased
        key = true;
        if (itemModel.getText().isEmpty()) {
            jComboBox3.hidePopup();
        } else {
            String s = itemModel.getText().substring(0, itemModel.getSelectionStart());
            if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
                itemModel.setText(s);
            }
            try {
                if (Character.isDefined(evt.getKeyChar()) && evt.getKeyCode() != 10) {
                    ResultSet r = DB.search("SELECT part_model FROM part_model INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + itemCategory.getText().trim() + "' AND brand_name = '" + itemBrand.getText().trim() + "' AND part_model like '" + itemModel.getText() + "%'");
                    Vector v = new Vector();
                    while (r.next()) {
                        v.add(r.getString("part_model"));
                    }
                    DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
                    jComboBox3.setModel(dcm);
                    if (!(jComboBox3.getItemCount() == 0)) {
                        jComboBox3.showPopup();
                        if (evt.getKeyCode() == 8 || evt.getKeyCode() == 127) {
                            itemModel.setText(s);
                        } else {
                            int x = itemModel.getText().length();
                            itemModel.setText(jComboBox3.getSelectedItem().toString());
                            itemModel.setSelectionStart(x);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jComboBox3.isPopupVisible()) {
                int count = jComboBox3.getItemCount();
                switch (evt.getKeyCode()) {
                    case 38:
                        itemModel.setText(s);
                        i--;
                        if (i == -1) {
                            i = count - 1;
                        }
                        jComboBox3.setSelectedIndex(i);
                        break;
                    case 40:
                        itemModel.setText(s);
                        i++;
                        if (i == count) {
                            i = 0;
                        }
                        jComboBox3.setSelectedIndex(i);
                        break;
                    case 10:
                        jComboBox3.setSelectedIndex(i);
                        itemModel.setText(jComboBox3.getSelectedItem().toString());
                        jComboBox3.hidePopup();
                        i = 0;
                        break;
                    default:
                        i = 0;
                        break;
                }
            }

        }
        key = false;
    }//GEN-LAST:event_itemModelKeyReleased

    private void jComboBox3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox3PopupMenuWillBecomeInvisible
        if (key == false) {
            itemModel.setText(jComboBox3.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboBox3PopupMenuWillBecomeInvisible

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int[] rows = jTable2.getSelectedRows();
            for (int row : rows) {
                String itC = jTable2.getValueAt(row, 0).toString();
                String itB = jTable2.getValueAt(row, 1).toString();
                String itM = jTable2.getValueAt(row, 2).toString();
                ResultSet r = DB.search("SELECT part_model.id FROM part_model INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + itC + "' AND brand_name = '" + itB + "' AND part_model = '" + itM + "'");
                r.next();
                int partModel = r.getInt("id");
                r = DB.search("SELECT grn_id from grn_item WHERE part_model_id = '" + partModel + "'");
                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "Can't delete item \'" + itB + " " + itC + " (" + itM + ")\' since that item has been used before.\nYou can only delete newly added items that haven't been added to stocks.", "Item in use", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DB.iud("DELETE FROM vehicle_part_details WHERE part_model_id = '" + partModel + "'");
                    DB.iud("DELETE FROM part_model WHERE id = '" + partModel + "'");
                    itemCategory.setText(null);
                    itemBrand.setText(null);
                    itemModel.setText(null);
                    jButton4ActionPerformed(null);
                    for (int j = 0; j < Supplier.getObject().itemTable.getRowCount(); j++) {
                        if (Supplier.getObject().itemTable.getValueAt(j, 0).equals(itC) || Supplier.getObject().itemTable.getValueAt(j, 1).equals(itB) || Supplier.getObject().itemTable.getValueAt(j, 2).equals(itM)) {
                            Supplier.getObject().dtm.removeRow(j);
                            break;
                        }
                    }
                }
            }
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void itemCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCategoryKeyPressed
        if (evt.getKeyCode() == 10) {
            itemCategoryKeyReleased(evt);
            itemBrand.grabFocus();
        }
    }//GEN-LAST:event_itemCategoryKeyPressed

    private void itemBrandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemBrandKeyPressed
        if (evt.getKeyCode() == 10) {
            itemBrandKeyReleased(evt);
            itemModel.grabFocus();
        }
    }//GEN-LAST:event_itemBrandKeyPressed

    private void itemModelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemModelKeyPressed
        if (evt.getKeyCode() == 10) {
            itemModelKeyReleased(evt);
            jButton2.grabFocus();
        }
    }//GEN-LAST:event_itemModelKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Home.getObject().setEnabled(true);
        this.dispose();
        Home.getObject().requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        TableRowSorter ts = new TableRowSorter(dtm2);
        ts.setRowFilter(RowFilter.regexFilter("(?i)" + search.getText()));
        jTable2.setRowSorter(ts);
    }//GEN-LAST:event_searchKeyReleased

    private void itemCategoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCategoryKeyTyped
        Validation.validateItemName(evt, itemCategory);
    }//GEN-LAST:event_itemCategoryKeyTyped

    private void itemBrandKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemBrandKeyTyped
        Validation.validateItemName(evt, itemBrand);
    }//GEN-LAST:event_itemBrandKeyTyped

    private void itemModelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemModelKeyTyped
        Validation.validateItemName(evt, itemModel);
    }//GEN-LAST:event_itemModelKeyTyped

    private void minKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minKeyTyped
        Validation.validateAmount(evt, min);
    }//GEN-LAST:event_minKeyTyped

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        Validation.validateText(evt, search);
    }//GEN-LAST:event_searchKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField itemBrand;
    private javax.swing.JTextField itemCategory;
    private javax.swing.JTextField itemModel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField min;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> vModel;
    // End of variables declaration//GEN-END:variables
}
