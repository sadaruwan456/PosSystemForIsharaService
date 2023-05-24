package GUI;

import DB.DB;
import Model.SuggestionList;
import Model.TableAlign;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import validation.Validation;

public class Supplier extends javax.swing.JPanel {

    public String title;
    public static Supplier o;
    public DefaultTableModel dtm;
    DecimalFormat df;
    DecimalFormat df2;
    int viewReportId;

    private Supplier() {
        initComponents();
        jButton6.setEnabled(false);
        df = new DecimalFormat("0.##");
        df2 = new DecimalFormat("0.###");
        try {
            ResultSet r = DB.search("SELECT MAX(id) FROM grn");
            if (r.next()) {
                if (r.getString(1) == null) {
                    title = "Supplier [GRN ID - 1]";
                } else {
                    title = "Supplier [GRN ID - " + String.valueOf(r.getInt(1) + 1) + "]";
                }
            }
        } catch (Exception e) {
        }
        loadCombos();
        TableAlign.alignCenter(itemTable, new int[]{0, 1, 2, 5});
        TableAlign.alignRight(itemTable, new int[]{3, 4, 6});
        dtm = (DefaultTableModel) itemTable.getModel();
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE || e.getType() == TableModelEvent.UPDATE) {
                    Double tot = 0d;
                    for (int i = 0; i < itemTable.getRowCount(); i++) {
                        tot = tot + Double.parseDouble(itemTable.getValueAt(i, 6).toString());
                    }
                    netTotal.setText(df.format(tot));
                    dueAmountKeyReleased(null);
                }
            }
        });

        nic.getDocument().addDocumentListener(new DocumentListener() {
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
                    ResultSet r = DB.search("SELECT fname, lname, name, due_amount FROM supplier INNER JOIN company ON supplier.company_id = company.id WHERE nic = '" + nic.getText() + "'");
                    if (r.next()) {
                        sName.setText(r.getString("fname") + " " + r.getString("lname"));
                        sCompany.setText(r.getString("name"));
                        dueAmount.setText(r.getString("due_amount"));
                    } else {
                        sName.setText(null);
                        sCompany.setText(null);
                        dueAmount.setText("0");
                    }
                    dueAmountKeyReleased(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public static Supplier getObject() {
        if (o == null) {
            o = new Supplier();
        }
        return o;
    }

    void loadCombos() {
        try {
            item_category.removeAllItems();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nicSuggestBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        sName = new javax.swing.JLabel();
        sCompany = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        item_category = new javax.swing.JComboBox<>();
        itemBrand = new javax.swing.JComboBox<>();
        itemType = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        bPrice = new javax.swing.JTextField();
        sPrice = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        netTotal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        cash = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        paidAmount = new javax.swing.JTextField();
        balance = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cheque = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        chNoc = new javax.swing.JTextField();
        branch_Codec = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bankCodec = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        chDatec = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        chequePaymentc = new javax.swing.JTextField();
        both = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        chNo = new javax.swing.JTextField();
        branch_Code = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        bankCode = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        chDate = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        chequePayment = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cashPayment = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        dueAmount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        subTotal = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Supplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        nicSuggestBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nicSuggestBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                nicSuggestBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("NIC :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Company :");

        nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nicKeyReleased(evt);
            }
        });

        sName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        sCompany.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Add / View Suppliers");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sName)
                            .addComponent(sCompany))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nicSuggestBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nic))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 0, 0)
                .addComponent(nicSuggestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sName)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sCompany))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Item :");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Item Brand :");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Item Type / Model:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Item Qty :");

        qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });

        item_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        item_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_categoryActionPerformed(evt);
            }
        });

        itemBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBrandActionPerformed(evt);
            }
        });

        itemType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypeActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add to GRN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Buying Price :");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setText("Selling Price :");

        bPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPriceActionPerformed(evt);
            }
        });
        bPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bPriceKeyTyped(evt);
            }
        });

        sPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sPriceKeyTyped(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Register New Item");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel54)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel7)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bPrice)
                            .addComponent(itemType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemBrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sPrice)
                            .addComponent(item_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qty)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(itemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(bPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(sPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        itemTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Brand", "Type", "Buying Price", "Selling Price", "Qty", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.getTableHeader().setReorderingAllowed(false);
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Net Total (Rs.):");

        netTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        netTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        netTotal.setText("00.00");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Payment Method :");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Cheque Details");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Cash");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Cheque");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.CardLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Paid Amount (Rs):");

        paidAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        paidAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountActionPerformed(evt);
            }
        });
        paidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                paidAmountKeyTyped(evt);
            }
        });

        balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        balance.setText("0.00");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Balance (Rs):");

        javax.swing.GroupLayout cashLayout = new javax.swing.GroupLayout(cash);
        cash.setLayout(cashLayout);
        cashLayout.setHorizontalGroup(
            cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashLayout.createSequentialGroup()
                .addGroup(cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paidAmount)
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(297, 297, 297))
        );
        cashLayout.setVerticalGroup(
            cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashLayout.createSequentialGroup()
                .addGroup(cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance)
                    .addComponent(jLabel22))
                .addContainerGap())
        );

        jPanel5.add(cash, "card2");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Cheque No :");

        chNoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chNoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chNocActionPerformed(evt);
            }
        });

        branch_Codec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        branch_Codec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_CodecActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Branch Code :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Bank Code :");

        bankCodec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bankCodec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankCodecActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Check Date :");

        chDatec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chDatec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chDatecKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Amount :");

        chequePaymentc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chequePaymentc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequePaymentcActionPerformed(evt);
            }
        });
        chequePaymentc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chequePaymentcKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout chequeLayout = new javax.swing.GroupLayout(cheque);
        cheque.setLayout(chequeLayout);
        chequeLayout.setHorizontalGroup(
            chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chequeLayout.createSequentialGroup()
                .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chequeLayout.createSequentialGroup()
                        .addComponent(bankCodec, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addComponent(chNoc))
                .addGap(18, 18, 18)
                .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chequeLayout.createSequentialGroup()
                        .addComponent(branch_Codec, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chDatec, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(chequeLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chequePaymentc))))
        );
        chequeLayout.setVerticalGroup(
            chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chequeLayout.createSequentialGroup()
                .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chNoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel21))
                    .addGroup(chequeLayout.createSequentialGroup()
                        .addComponent(chequePaymentc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(chDatec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(branch_Codec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(bankCodec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel5.add(cheque, "card3");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Cheque No :");

        chNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chNoActionPerformed(evt);
            }
        });

        branch_Code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        branch_Code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_CodeActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Branch Code :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Bank Code :");

        bankCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bankCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankCodeActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Check Date :");

        chDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chDateKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Cheque (Rs):");

        chequePayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chequePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequePaymentActionPerformed(evt);
            }
        });
        chequePayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chequePaymentKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Cash (Rs):");

        cashPayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cashPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashPaymentActionPerformed(evt);
            }
        });
        cashPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashPaymentKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout bothLayout = new javax.swing.GroupLayout(both);
        both.setLayout(bothLayout);
        bothLayout.setHorizontalGroup(
            bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bothLayout.createSequentialGroup()
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cashPayment)
                    .addComponent(bankCode, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chequePayment)
                    .addComponent(branch_Code, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chNo)
                    .addComponent(chDate, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
        );
        bothLayout.setVerticalGroup(
            bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bothLayout.createSequentialGroup()
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chequePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(chNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28)
                    .addComponent(cashPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(chDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(branch_Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(bankCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel5.add(both, "card3");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton3.setText("Both");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton7)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Due Payment (Rs.) :");

        dueAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dueAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dueAmount.setText("0");
        dueAmount.setMinimumSize(new java.awt.Dimension(180, 23));
        dueAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dueAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dueAmountKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Total Amonut (Rs.)");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        subTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subTotal.setText("0.00");
        subTotal.setToolTipText("");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dueAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(netTotal, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subTotal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(netTotal))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(dueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(subTotal)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        cheque.setVisible(false);
        both.setVisible(false);
        cash.setVisible(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        cash.setVisible(false);
        both.setVisible(false);
        cheque.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home.getObject().setEnabled(false);
        new SupplierReg().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chNocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chNocActionPerformed
        chequePaymentc.grabFocus();
    }//GEN-LAST:event_chNocActionPerformed

    private void branch_CodecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branch_CodecActionPerformed
        chDatec.grabFocus();
    }//GEN-LAST:event_branch_CodecActionPerformed

    private void bankCodecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankCodecActionPerformed
        branch_Codec.grabFocus();
    }//GEN-LAST:event_bankCodecActionPerformed

    private void chequePaymentcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequePaymentcActionPerformed
        bankCodec.grabFocus();
    }//GEN-LAST:event_chequePaymentcActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Home.getObject().setEnabled(false);
        new RegisterItem().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void item_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_categoryActionPerformed
        try {
            if (item_category.getItemCount() != 0) {
                itemBrand.removeAllItems();
                ResultSet r = DB.search("SELECT DISTINCT(brand_name) FROM part INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + item_category.getSelectedItem().toString() + "'");
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
                itemType.removeAllItems();
                ResultSet r = DB.search("SELECT part_model FROM part_model INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + item_category.getSelectedItem().toString() + "' AND part_brand.brand_name = '" + itemBrand.getSelectedItem().toString() + "'");
                while (r.next()) {
                    itemType.addItem(r.getString("part_model"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemBrandActionPerformed

    private void nicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyReleased
        SuggestionList.showList(nic, nicSuggestBox, "SELECT nic FROM supplier WHERE nic LIKE '" + nic.getText() + "%'", "nic", evt, this.getClass().getName());
    }//GEN-LAST:event_nicKeyReleased

    private void nicSuggestBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nicSuggestBoxPopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(nic, nicSuggestBox);
    }//GEN-LAST:event_nicSuggestBoxPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String buyPrice = bPrice.getText();
        String sellPrice = sPrice.getText();
        if (item_category.getItemCount() == 0) {
            JOptionPane.showMessageDialog(Home.getObject(), "Register some items first.", "No items", JOptionPane.INFORMATION_MESSAGE);
            jButton3ActionPerformed(null);
        } else {
            if (qty.getText().isEmpty() || Double.parseDouble(qty.getText()) == 0) {
                JOptionPane.showMessageDialog(Home.getObject(), "Quantity Cannot be 0 or Empty.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                qty.grabFocus();
            } else {
                if (Double.parseDouble(sellPrice) < Double.parseDouble(buyPrice)) {
                    JOptionPane.showMessageDialog(Home.getObject(), "Buying Price cannot be higer than Selling Price.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                    bPrice.grabFocus();
                } else {
                    String itCat = item_category.getSelectedItem().toString();
                    String itBrand = itemBrand.getSelectedItem().toString();
                    String itModel = itemType.getSelectedItem().toString();
                    double qt = Double.parseDouble(qty.getText());
                    
                    
                    int j;
                    boolean b = false;
                    
                    for (j = 0; j < itemTable.getRowCount(); j++) {
                        if (itemTable.getValueAt(j, 0).toString().equals(itCat) && itemTable.getValueAt(j, 1).toString().equals(itBrand) && itemTable.getValueAt(j, 2).toString().equals(itModel) && itemTable.getValueAt(j, 3).toString().equals(buyPrice) && itemTable.getValueAt(j, 4).toString().equals(sellPrice)) {
                            b = true;
                            break;
                        }
                    }
                    if (b) {
                        double newqt = qt + Double.parseDouble(itemTable.getValueAt(j, 5).toString());
                        itemTable.setValueAt(df.format(newqt), j, 5);
                        itemTable.setValueAt(df.format(Double.parseDouble(buyPrice) * newqt), j, 6);
                    } else {
                        Vector v = new Vector();
                        v.add(itCat);
                        v.add(itBrand);
                        v.add(itModel);
                        v.add(buyPrice);
                        v.add(sellPrice);
                        v.add(df2.format(qt));
                        v.add(df.format(Double.parseDouble(buyPrice) * qt));
                        dtm.addRow(v);
                    }
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void dueAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dueAmountKeyReleased
        if (dueAmount.getText().equals("")) {
            subTotal.setText(netTotal.getText());
        } else {
            subTotal.setText(df.format(Double.parseDouble(netTotal.getText()) + Double.parseDouble(dueAmount.getText())));
        }
        paidAmountKeyReleased(null);
    }//GEN-LAST:event_dueAmountKeyReleased

    void m() {
        try {
            Date d = new Date();
            String today = new SimpleDateFormat("yyyy-MM-dd").format(d);
            String now = new SimpleDateFormat("HH:mm:ss").format(d);
            int payMethod;
            Double due;
            Double payment;
            if (jRadioButton1.isSelected()) {
                payMethod = 0;
                if (paidAmount.getText().isEmpty()) {
                    payment = 0.0;
                } else {
                    payment = Double.parseDouble(paidAmount.getText());
                }
            } else if (jRadioButton2.isSelected()) {
                payMethod = 1;
                payment = Double.parseDouble(chequePaymentc.getText());
                DB.iud("INSERT INTO paid_cheque(supplier_nic, issued_date, cheque_no, branch_code, bank_code, cheque_date, amount) VALUES('" + nic.getText() + "', '" + today + " " + now + "', '" + chNoc.getText() + "', '" + branch_Codec.getText() + "', '" + bankCodec.getText() + "', '" + chDatec.getText() + "', '" + payment + "')");
            } else {
                payMethod = 2;
                double chkPay = Double.parseDouble(chequePayment.getText());
                payment = Double.parseDouble(cashPayment.getText()) + chkPay;
                DB.iud("INSERT INTO paid_cheque(supplier_nic, issued_date, cheque_no, branch_code, bank_code, cheque_date, amount) VALUES('" + nic.getText() + "', '" + today + " " + now + "', '" + chNo.getText() + "', '" + branch_Code.getText() + "', '" + bankCode.getText() + "', '" + chDate.getText() + "', '" + chkPay + "')");
            }
            double tot = Double.parseDouble(subTotal.getText());
            if (payment < tot) {
                due = tot - payment;
            } else {
                due = 0d;
            }
            DB.iud("UPDATE company set due_amount = '" + df.format(due) + "' WHERE name = '" + sCompany.getText() + "'");

            int GRNID = Integer.parseInt(title.substring(19, title.length() - 1));
            DB.iud("INSERT INTO grn(id, payment_method_id, payment, g_date, time, supplier_nic) VALUES('" + GRNID + "', '" + payMethod + "', '" + payment + "', '" + today + "', '" + now + "', '" + nic.getText() + "')");

            for (int j = 0; j < itemTable.getRowCount(); j++) {
                String itCat = itemTable.getValueAt(j, 0).toString();
                String itBrand = itemTable.getValueAt(j, 1).toString();
                String itModel = itemTable.getValueAt(j, 2).toString();
                double qty = Double.parseDouble(itemTable.getValueAt(j, 5).toString());
                String buyPrice = itemTable.getValueAt(j, 3).toString();
                String sellPrice = itemTable.getValueAt(j, 4).toString();

                ResultSet r = DB.search("SELECT part_model.id, min_quota FROM part_model INNER JOIN part on part_model.part_id = part.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id INNER JOIN part_category ON part.part_category_id = part_category.id WHERE category_name = '" + itCat + "' AND brand_name = '" + itBrand + "' AND part_model = '" + itModel + "'");
                r.next();
                int itModelID = r.getInt("id");
                double minQty = r.getDouble("min_quota");
                DB.iud("INSERT INTO grn_item(grn_id, part_model_id, qty, buying_price) VALUES('" + GRNID + "', '" + itModelID + "', '" + df2.format(qty) + "', '" + buyPrice + "')");

                r = DB.search("SELECT id, qty FROM stock WHERE part_model_id = '" + itModelID + "' AND selling_price = '" + sellPrice + "'");
                int stockID;
                if (r.next()) {
                    stockID = r.getInt("id");
                    qty = r.getDouble("qty") + qty;
                    DB.iud("UPDATE stock SET qty = '" + df2.format(qty) + "', status_id = '1' WHERE id = '" + stockID + "'");
                } else {
                    DB.iud("INSERT INTO stock(part_model_id, qty, selling_price, datetime) VALUES('" + itModelID + "', '" + df2.format(qty) + "', '" + sellPrice + "', '" + today + " " + now + "')");
                    r = DB.search("SELECT id, qty FROM stock WHERE part_model_id = '" + itModelID + "' AND selling_price = '" + sellPrice + "'");
                    r.next();
                    stockID = r.getInt("id");
                }
                if (qty > minQty) {
                    DB.iud("DELETE FROM notified_stock WHERE stock_id = '" + stockID + "'");
                } else {
                    r = DB.search("SELECT stock_id FROM notified_stock WHERE stock_id = '" + stockID + "'");
                    if (!r.next()) {
                        DB.iud("INSERT INTO notified_stock(ns_date, stock_id) VALUES('" + today + " " + now + "', '" + stockID + "')");
                    }
                }
            }
            jButton6.setEnabled(true);
            viewReportId = GRNID;

            title = "Supplier [GRN ID - " + String.valueOf(GRNID + 1) + "]";
            Home.getObject().title.setText(title);
            resetActivity();
            if (Customer.o != null) {
                Customer.getObject().loadCombos();
            }
            if (Stock.o != null) {
                Stock.getObject().loadCombos();
            }
            StockNotifications.getObject().loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void viewReport(int grnid) throws Exception {
        try {
            String query1 = "select DISTINCT grn.payment,company.due_amount from grn inner join supplier on supplier.nic=grn.supplier_nic inner JOIN company on company.id=supplier.company_id where grn.id='" + grnid + "'";
            String query2 = "select DISTINCT (grn_item.qty*grn_item.buying_price)as nettotal from grn_item where grn_item.grn_id='" + grnid + "'";
            double nettotal = 0.0;
            double payment = 0.0;
            double due = 0.0;
            double balance = 0.0;
            ResultSet result1 = DB.search(query1);
            ResultSet result2 = DB.search(query2);

            if (result1.next()) {
                payment = Double.parseDouble(result1.getString("payment"));
                due = Double.parseDouble(result1.getString("due_amount"));
            }
            while (result2.next()) {
                nettotal = Double.parseDouble(result2.getString("nettotal")) + nettotal;
            }
            balance = payment - (nettotal + due);

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("GRNID", grnid);
            parameter.put("NETTOTAL", nettotal);

            parameter.put("BALANCE", balance);

            //  JasperReport jr= JasperCompileManager.compileReport("C:\\Users\\Angry_Bird\\JaspersoftWorkspace\\MyReports\\nmd.jrxml"); <-MEKEDI APP EKA RUN WEN AHAMA WELAWEMA COMPILE WENAWA..SCND EKATH WADAAGTH NISA COMPL KRALA E FILE EKA STREAM EKAK WIDIYATA GANNA..
            InputStream jr = Supplier.class.getResourceAsStream("/BILL/grnn.jasper");

            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, DB.getConnection());
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (sName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(Home.getObject(), "Please Make sure the NIC is from a registered supplier.", "Invalid NIC", JOptionPane.INFORMATION_MESSAGE);
            nic.grabFocus();
        } else {
            if (itemTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(Home.getObject(), "Please add items to the GRN first.", "No Items Added", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (jRadioButton2.isSelected()) {
                    if (chequePaymentc.getText().isEmpty() || chequePaymentc.getText().equals("0")) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cheque payments cannot be 0.", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
                        chequePaymentc.grabFocus();
                    } else if (chNoc.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cheque Number cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        chNoc.grabFocus();
                    } else if (bankCodec.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Bank Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        bankCodec.grabFocus();
                    } else if (branch_Codec.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Branch Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        branch_Codec.grabFocus();
                    } else if (chDatec.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cheque Date cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        chDatec.grabFocus();
                    } else {
                        m();
                    }
                } else if (jRadioButton3.isSelected()) {
                    if (chequePayment.getText().isEmpty() || chequePayment.getText().equals("0")) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cheque payments cannot be 0.", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
                        chequePayment.grabFocus();
                    } else if (cashPayment.getText().isEmpty() || cashPayment.getText().equals("0")) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cash payment amount cannot be 0.", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
                        cashPayment.grabFocus();
                    } else if (chNo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cheque Number cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        chNo.grabFocus();
                    } else if (bankCode.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Bank Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        bankCode.grabFocus();
                    } else if (branch_Code.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Branch Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        branch_Code.grabFocus();
                    } else if (chDate.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(Home.getObject(), "Cheque Date cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        chDate.grabFocus();
                    } else {
                        m();
                    }
                } else {
                    m();
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void paidAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountActionPerformed
        jButton5.grabFocus();
    }//GEN-LAST:event_paidAmountActionPerformed

    private void paidAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountKeyReleased
        if (paidAmount.getText().equals("")) {
            balance.setText(df.format(0 - Double.parseDouble(subTotal.getText())));
        } else {
            balance.setText(df.format(Double.parseDouble(paidAmount.getText()) - Double.parseDouble(subTotal.getText())));
        }
    }//GEN-LAST:event_paidAmountKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new ChequeDetails().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void itemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypeActionPerformed
        if (itemType.getItemCount() != 0) {
            if (itemType.getSelectedItem().toString().equals("Barrel")) {
                jLabel55.setText("Buying Price per litre :");
                jLabel56.setText("Selling Price per litre :");
                jLabel54.setText("Item Qty (litres) :");
            } else {
                jLabel55.setText("Buying Price :");
                jLabel56.setText("Selling Price :");
                jLabel54.setText("Item Qty :");
            }
            try {
                ResultSet r = DB.search("SELECT buy_price, selling_price FROM stock INNER JOIN (SELECT part_model_id, MAX(buying_price) AS buy_price FROM grn_item GROUP BY part_model_id) AS g ON stock.part_model_id = g.part_model_id INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE category_name = '" + item_category.getSelectedItem().toString() + "' AND brand_name = '" + itemBrand.getSelectedItem().toString() + "' AND part_model = '" + itemType.getSelectedItem().toString() + "'");
                if (r.next()) {
                    bPrice.setText(r.getString("buy_price"));
                    sPrice.setText(r.getString("selling_price"));
                } else {
                    bPrice.setText(null);
                    sPrice.setText(null);
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_itemTypeActionPerformed

    private void chNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chNoActionPerformed
        bankCode.grabFocus();
    }//GEN-LAST:event_chNoActionPerformed

    private void branch_CodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branch_CodeActionPerformed
        chDate.grabFocus();
    }//GEN-LAST:event_branch_CodeActionPerformed

    private void bankCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankCodeActionPerformed
        branch_Code.grabFocus();
    }//GEN-LAST:event_bankCodeActionPerformed

    private void chequePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequePaymentActionPerformed
        chNo.grabFocus();
    }//GEN-LAST:event_chequePaymentActionPerformed

    private void cashPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashPaymentActionPerformed
        chequePayment.grabFocus();
    }//GEN-LAST:event_cashPaymentActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        cash.setVisible(false);
        cheque.setVisible(false);
        both.setVisible(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        resetActivity();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        bPrice.grabFocus();
        bPrice.selectAll();
    }//GEN-LAST:event_qtyActionPerformed

    private void bPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPriceActionPerformed
        sPrice.grabFocus();
        sPrice.selectAll();
    }//GEN-LAST:event_bPriceActionPerformed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        if (evt.getClickCount() == 2) {
            int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove item ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                dtm.removeRow(itemTable.getSelectedRow());
            }
        }
    }//GEN-LAST:event_itemTableMouseClicked

    private void paidAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountKeyTyped
        Validation.validateAmount(evt, paidAmount);
    }//GEN-LAST:event_paidAmountKeyTyped

    private void bPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bPriceKeyTyped
        Validation.validateAmount(evt, bPrice);
    }//GEN-LAST:event_bPriceKeyTyped

    private void sPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sPriceKeyTyped
        Validation.validateAmount(evt, sPrice);
    }//GEN-LAST:event_sPriceKeyTyped

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        Validation.validateAmount(evt, qty);
    }//GEN-LAST:event_qtyKeyTyped

    private void dueAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dueAmountKeyTyped
        Validation.validateAmount(evt, dueAmount);
    }//GEN-LAST:event_dueAmountKeyTyped

    private void chequePaymentcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chequePaymentcKeyTyped
        Validation.validateAmount(evt, chequePaymentc);
    }//GEN-LAST:event_chequePaymentcKeyTyped

    private void cashPaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashPaymentKeyTyped
        Validation.validateAmount(evt, chequePayment);
    }//GEN-LAST:event_cashPaymentKeyTyped

    private void chequePaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chequePaymentKeyTyped
        Validation.validateAmount(evt, chequePayment);
    }//GEN-LAST:event_chequePaymentKeyTyped

    private void chDatecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chDatecKeyTyped
        Validation.validateDate(evt, chDatec);
    }//GEN-LAST:event_chDatecKeyTyped

    private void chDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chDateKeyTyped
        Validation.validateDate(evt, chDate);
    }//GEN-LAST:event_chDateKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            viewReport(viewReportId);
            jButton6.setEnabled(false);
        } catch (Exception ex) {
            jButton6.setEnabled(false);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    void resetActivity() {
        nic.setText(null);
        bPrice.setText(null);
        sPrice.setText(null);
        qty.setText(null);
        dueAmount.setText("0");
        paidAmount.setText(null);
        balance.setText("0");
        cashPayment.setText(null);
        chNo.setText(null);
        chNoc.setText(null);
        chequePaymentc.setText(null);
        chequePayment.setText(null);
        bankCode.setText(null);
        bankCodec.setText(null);
        branch_Code.setText(null);
        branch_Codec.setText(null);
        chDate.setText(null);
        chDatec.setText(null);
        loadCombos();
        dtm.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bPrice;
    private javax.swing.JLabel balance;
    private javax.swing.JTextField bankCode;
    private javax.swing.JTextField bankCodec;
    private javax.swing.JPanel both;
    private javax.swing.JTextField branch_Code;
    private javax.swing.JTextField branch_Codec;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel cash;
    private javax.swing.JTextField cashPayment;
    private javax.swing.JTextField chDate;
    private javax.swing.JTextField chDatec;
    private javax.swing.JTextField chNo;
    private javax.swing.JTextField chNoc;
    private javax.swing.JPanel cheque;
    private javax.swing.JTextField chequePayment;
    private javax.swing.JTextField chequePaymentc;
    private javax.swing.JTextField dueAmount;
    private javax.swing.JComboBox<String> itemBrand;
    public javax.swing.JTable itemTable;
    private javax.swing.JComboBox<String> itemType;
    private javax.swing.JComboBox<String> item_category;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel netTotal;
    private javax.swing.JTextField nic;
    private javax.swing.JComboBox<String> nicSuggestBox;
    private javax.swing.JTextField paidAmount;
    private javax.swing.JTextField qty;
    private javax.swing.JLabel sCompany;
    private javax.swing.JLabel sName;
    private javax.swing.JTextField sPrice;
    private javax.swing.JLabel subTotal;
    // End of variables declaration//GEN-END:variables
}
