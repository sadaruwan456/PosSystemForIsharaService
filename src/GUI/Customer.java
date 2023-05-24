package GUI;

import DB.DB;
import Model.SuggestionList;
import Model.TableAlign;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import validation.Validation;

/**
 *
 * @author Lakshan
 */
public class Customer extends javax.swing.JPanel {

    public String title;
    public static Customer o;
    DefaultTableModel dtm;
    PropertyChangeListener pc2;
    DecimalFormat df;
    DecimalFormat df2;
    NativeKeyListener nkl;
    GlobalScreen gs;
    int invoiceid;
    boolean printbutton = false;

    private Customer() {
        initComponents();
        print.setEnabled(printbutton);
        df = new DecimalFormat("0.##");
        df2 = new DecimalFormat("0.###");
        try {
            ResultSet r = DB.search("SELECT MAX(id) FROM invoice");
            if (r.next()) {
                if (r.getString(1) == null) {
                    title = "Customer [Invoice ID - 1]";
                } else {
                    title = "Customer [Invoice ID - " + String.valueOf(r.getInt(1) + 1) + "]";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GlobalScreen.registerNativeHook();
            nkl = new NativeKeyListener() {
                ArrayList<Character> al = new ArrayList<>();
                String txt;
                boolean isTF;
                JTextField tf;
                boolean isKeyEventOver;

                @Override
                public void nativeKeyPressed(NativeKeyEvent nke) {
                }

                @Override
                public void nativeKeyReleased(NativeKeyEvent nke) {
                }

                @Override
                public void nativeKeyTyped(NativeKeyEvent nke) {
                    if (Home.getObject().parentPanel.getComponent(0).getClass().getCanonicalName().substring(4).equals("Customer")) {
                        char c = nke.getKeyChar();
                        switch (c) {
                            case 'S':
                                Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                                isTF = comp instanceof JTextField;
                                if (isTF) {
                                    tf = (JTextField) comp;
                                    txt = tf.getText();
                                } else if (comp instanceof JComboBox) {
                                    Customer.getObject().grabFocus();
                                }
                                al.clear();
                                al.add(c);
                                break;
                            case 'T':
                                if (al.size() == 1) {
                                    al.add(c);
                                } else {
                                    al.clear();
                                }
                                break;
                            case 'K':
                                if (al.size() == 2) {
                                    al.add(c);
                                } else {
                                    al.clear();
                                }
                                break;
                            case '-':
                                if (al.size() == 3) {
                                    al.add(c);
                                } else {
                                    al.clear();
                                }
                                break;
                            case 'E':
                                if (al.size() == 14) {
                                    al.add(c);
                                } else {
                                    al.clear();
                                }
                                break;
                            default:
                                if (Character.isDigit(c)) {
                                    if (al.size() >= 4 && al.size() < 14) {
                                        al.add(c);
                                    } else {
                                        al.clear();
                                    }
                                } else {
                                    al.clear();
                                }
                        }
                        if (al.size() == 15) {
                            if (al.get(0) == 'S' && al.get(1) == 'T' && al.get(2) == 'K' && al.get(3) == '-' && al.get(14) == 'E') {
                                isKeyEventOver = false;
                                String s = "";
                                for (int i = 4; i < 14; i++) {
                                    s = s + al.get(i);
                                }
                                int stockID = Integer.parseInt(s);
                                try {
                                    ResultSet r = DB.search("SELECT status_id, category_name, brand_name, part_model, selling_price FROM STOCK INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand on part.part_brand_id = part_brand.id WHERE stock.id = " + stockID);
                                    if (r.next()) {
                                        if (r.getInt("status_id") == 1) {
                                            item_category.setSelectedItem(r.getString("category_name"));
                                            itemBrand.setSelectedItem(r.getString("brand_name"));
                                            itemType.setSelectedItem(r.getString("part_model"));
                                            stPrice.setSelectedItem("Rs. " + r.getString("selling_price"));
                                            qty.setText("1");
                                            pc2.propertyChange(null);
                                            if (addbtn.isEnabled()) {
                                                addbtnActionPerformed(null);
                                            } else {
                                                NotificationPanel.showNotification("Unrecognized Item", "This item is not added to any stocks yet.", "Please make sure the stock is up to date.", NotificationPanel.WARN);
                                            }
                                        } else {
                                            NotificationPanel.showNotification("Obsolete Item", "This item belongs to an old stock", "Mark Stock ID " + stockID + " as Active to add this item.", NotificationPanel.WARN);
                                        }
                                    }
                                } catch (Exception e) {
                                }
                                if (isTF) {
                                    new Thread() {
                                        public void run() {
                                            while (true) {
                                                if (isKeyEventOver) {
                                                    tf.setText(txt);
                                                    txt = null;
                                                    tf = null;
                                                    Customer.getObject().grabFocus();
                                                    break;
                                                }
                                            }
                                        }
                                    }.start();
                                }
                            }
                            al.clear();
                        }
                    }
                    isKeyEventOver = true;
                }

            };
            gs = GlobalScreen.getInstance();
            gs.addNativeKeyListener(nkl);
        } catch (Exception e) {
        }

        PropertyChangeListener pc1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Double d = Double.parseDouble(itemCost.getText()) + Double.parseDouble(servCharge.getText());
                netTotal.setText(df.format(d));
                if (dueAmount.getText().equals("")) {
                    dueAmount.setText("0");
                }
                subTotal.setText(df.format(d + Double.parseDouble(dueAmount.getText())));
            }
        };

        itemCost.addPropertyChangeListener("text", pc1);
        servCharge.addPropertyChangeListener("text", pc1);

        loadCombos();
        pc2 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (checkqty()) {
                    addbtn.setEnabled(true);
                } else {
                    addbtn.setEnabled(false);
                }
            }

            boolean checkqty() {
                if (qty.getText().equals("") || stockqty.getText().equals("0") || Double.parseDouble(qty.getText()) == 0.0d) {
                    return false;
                } else {
                    if (Double.parseDouble(qty.getText()) <= Double.parseDouble(stockqty.getText())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        };

        stockqty.addPropertyChangeListener("text", pc2);

        mobile.getDocument()
                .addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e
                    ) {
                        m();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e
                    ) {
                        m();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e
                    ) {
                        m();
                    }

                    void m() {
                        try {
                            ResultSet r = DB.search("SELECT fname, lname FROM customer WHERE mobile = '" + mobile.getText() + "'");
                            if (r.next()) {
                                fname.setText(r.getString("fname"));
                                lname.setText(r.getString("lname"));
                            } else {
                                fname.setText(null);
                                lname.setText(null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                );

        vNumber.getDocument()
                .addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e
                    ) {
                        m();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e
                    ) {
                        m();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e
                    ) {
                        m();
                    }

                    void m() {
                        try {
                            ResultSet r = DB.search("SELECT customer_mobile, due, brand_name, model_name FROM customer_vehicle INNER JOIN vehicle_model ON customer_vehicle.vehicle_model_id = vehicle_model.id INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id WHERE licen_plate = '" + vNumber.getText() + "'");
                            if (r.next()) {
                                mobile.setText(r.getString("customer_mobile"));
                                vBrand.setSelectedItem(r.getString("brand_name"));
                                vModel.setSelectedItem(r.getString("model_name"));
                                dueAmount.setText(r.getString("due"));
                                vBrand.setEnabled(false);
                                vModel.setEnabled(false);
                                vCategory.setEnabled(false);
                            } else {
                                mobile.setText(null);
                                dueAmount.setText("0");
                                vBrand.setEnabled(true);
                                vModel.setEnabled(true);
                                vCategory.setEnabled(true);
                            }
                            dueAmountKeyReleased(null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                );

        TableAlign.alignCenter(itemTable,
                new int[]{0,
                    1, 2, 3});
        TableAlign.alignRight(itemTable,
                new int[]{4
                }
        );
        dtm = (DefaultTableModel) itemTable.getModel();

        dtm.addTableModelListener(
                new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e
            ) {
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE || e.getType() == TableModelEvent.UPDATE) {
                    Double tot = 0d;
                    for (int i = 0; i < itemTable.getRowCount(); i++) {
                        tot = tot + Double.parseDouble(itemTable.getValueAt(i, 4).toString());
                    }
                    itemCost.setText(df.format(tot));
                }
            }
        }
        );
        if (!LogIn.type.equals("Admin")) {
            dueAmount.setEditable(false);
        }
    }

    public static Customer getObject() {
        if (o == null) {
            o = new Customer();
        }
        return o;
    }

    public void loadCombos() {
        try {
            vCategory.removeAllItems();
            ResultSet r = DB.search("SELECT vehicle_type FROM vehicle_type");
            while (r.next()) {
                vCategory.addItem(r.getString("vehicle_type"));
            }
            servType.removeAllItems();
            r = DB.search("SELECT service_type FROM service");
            while (r.next()) {
                servType.addItem(r.getString("service_type"));
            }

            vBrand.removeAllItems();
            r = DB.search("SELECT brand_name FROM vehicle_brand");
            while (r.next()) {
                vBrand.addItem(r.getString("brand_name"));
            }

            item_category.removeAllItems();
            r = DB.search("SELECT category_name FROM part_category");
            while (r.next()) {
                item_category.addItem(r.getString("category_name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        servCharge = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dueAmount = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        itemCost = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        netTotal = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
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
        print = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        vSuggestBox = new javax.swing.JComboBox<>();
        mobileSuggestBox = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        vCategory = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        servType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        vNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        vBrand = new javax.swing.JComboBox<>();
        vModel = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        mileage = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        item_category = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        itemBrand = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        itemType = new javax.swing.JComboBox<>();
        addbtn = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        stPrice = new javax.swing.JComboBox<>();
        netTotal2 = new javax.swing.JLabel();
        stockqty = new javax.swing.JLabel();

        setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Net Total (Rs.):");

        servCharge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        servCharge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        servCharge.setText("00.00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Due Payment (Rs.) :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Total Amonut (Rs.)");

        dueAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dueAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dueAmount.setText("0");
        dueAmount.setMinimumSize(new java.awt.Dimension(120, 23));
        dueAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dueAmountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dueAmountKeyTyped(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Save");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Item cost (Rs):");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Service charges (Rs):");

        itemCost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        itemCost.setText("00.00");

        subTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subTotal.setText("00.00");

        netTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        netTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        netTotal.setText("00.00");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Payment Method :");

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Cheque Details");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
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
                    .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
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
        chNoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chNocKeyTyped(evt);
            }
        });

        branch_Codec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        branch_Codec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_CodecActionPerformed(evt);
            }
        });
        branch_Codec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                branch_CodecKeyTyped(evt);
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
        bankCodec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bankCodecKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Check Date :");

        chDatec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chDatec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chDatecKeyPressed(evt);
            }
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
                        .addComponent(bankCodec, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addComponent(chNoc))
                .addGap(18, 18, 18)
                .addGroup(chequeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chequeLayout.createSequentialGroup()
                        .addComponent(branch_Codec, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chDatec, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
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
        chNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                chNoKeyTyped(evt);
            }
        });

        branch_Code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        branch_Code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branch_CodeActionPerformed(evt);
            }
        });
        branch_Code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                branch_CodeKeyTyped(evt);
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
        bankCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bankCodeKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Check Date :");

        chDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chDateKeyPressed(evt);
            }
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
                    .addComponent(bankCode, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chequePayment)
                    .addComponent(branch_Code, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bothLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chNo)
                    .addComponent(chDate, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton8)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dueAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servCharge, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(netTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton5, jButton7, print});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(itemCost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(servCharge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(netTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(dueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton7))
                    .addComponent(subTotal)
                    .addComponent(jLabel12)
                    .addComponent(print))
                .addContainerGap())
        );

        itemTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Item Brand", "Type / Model", "Qty", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Vehicle and Service Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        vSuggestBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                vSuggestBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        mobileSuggestBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mobileSuggestBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                mobileSuggestBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Vehicle Category :");

        vCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vCategory.setPreferredSize(new java.awt.Dimension(100, 23));
        vCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCategoryActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Service Type :");

        servType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        servType.setPreferredSize(new java.awt.Dimension(100, 23));
        servType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servTypeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Vehicle No :");

        vNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vNumber.setMaximumSize(new java.awt.Dimension(100, 23));
        vNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vNumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vNumberKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Brand :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Model :");

        vBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBrandActionPerformed(evt);
            }
        });

        vModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vModelActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("New Running Mileage :");

        mileage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mileage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mileageActionPerformed(evt);
            }
        });
        mileage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mileageKeyTyped(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("View Service History");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("First Name :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mobile No :");

        mobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobileKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileKeyTyped(evt);
            }
        });

        fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnameKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Last Name :");

        lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnameKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Register New Vehicle Model");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Register Service Type");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel35)
                    .addComponent(jLabel39)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vSuggestBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mileage)
                    .addComponent(vCategory, 0, 203, Short.MAX_VALUE)
                    .addComponent(vNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mobile, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mobileSuggestBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel37)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servType, 0, 204, Short.MAX_VALUE)
                            .addComponent(vBrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fname, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lname))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vModel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(vNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(vBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(vSuggestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(vCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(mileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(servType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mobileSuggestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Item Cost Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Applied Item :");

        item_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        item_category.setMinimumSize(new java.awt.Dimension(200, 23));
        item_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_categoryActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Item Brand :");

        itemBrand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemBrand.setMinimumSize(new java.awt.Dimension(200, 23));
        itemBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBrandActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Item Type / Model :");

        itemType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemType.setMinimumSize(new java.awt.Dimension(200, 23));
        itemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTypeActionPerformed(evt);
            }
        });

        addbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addbtn.setText("Add to Invoice");
        addbtn.setEnabled(false);
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Qty :");

        qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Unit Price :");

        stPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stPrice.setMinimumSize(new java.awt.Dimension(200, 23));
        stPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stPriceActionPerformed(evt);
            }
        });

        netTotal2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        netTotal2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        netTotal2.setText("Available Qty :");

        stockqty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stockqty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stockqty.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stPrice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemBrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(item_category, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(netTotal2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockqty)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(itemBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(itemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(stPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netTotal2)
                    .addComponent(stockqty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn)
                    .addComponent(jLabel54)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Customer.getObject().setEnabled(false);
        new ViewServiceHistory().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBrandActionPerformed
        try {
            if (vBrand.getItemCount() != 0) {
                vModel.removeAllItems();
                ResultSet r = DB.search("SELECT model_name FROM vehicle_model INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id WHERE brand_name = '" + vBrand.getSelectedItem().toString() + "'");
                while (r.next()) {
                    vModel.addItem(r.getString("model_name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_vBrandActionPerformed

    private void vModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vModelActionPerformed
        try {
            if (vModel.getItemCount() != 0) {
                ResultSet r = DB.search("SELECT vehicle_type FROM vehicle_model INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id INNER JOIN vehicle_type ON vehicle_model.vehicle_type_id = vehicle_type.id WHERE brand_name = '" + vBrand.getSelectedItem().toString() + "' AND model_name = '" + vModel.getSelectedItem().toString() + "'");
                if (r.next()) {
                    vCategory.setSelectedItem(r.getString("vehicle_type"));
                }

                if (item_category.getItemCount() != 0) {
                    r = DB.search("SELECT part_model FROM vehicle_part_details INNER JOIN part_model ON vehicle_part_details.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN vehicle_model ON vehicle_part_details.vehicle_model_id = vehicle_model.id INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE vehicle_brand.brand_name = '" + vBrand.getSelectedItem().toString() + "' AND model_name = '" + vModel.getSelectedItem().toString() + "' AND category_name = '" + item_category.getSelectedItem().toString() + "' AND part_brand.brand_name = '" + itemBrand.getSelectedItem().toString() + "'");
                    if (r.next()) {
                        itemType.setSelectedItem(r.getString("part_model"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_vModelActionPerformed

    private void servTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servTypeActionPerformed
        try {
            if (servType.getItemCount() != 0) {
                ResultSet r = DB.search("SELECT price FROM service_price INNER JOIN vehicle_type ON service_price.vehicle_type_id = vehicle_type.id INNER JOIN service ON service_price.service_id = service.id WHERE vehicle_type = '" + vCategory.getSelectedItem().toString() + "' AND service_type = '" + servType.getSelectedItem().toString() + "'");
                if (r.next()) {
                    servCharge.setText(r.getString("price"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_servTypeActionPerformed

    private void vCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCategoryActionPerformed
        try {
            if (vCategory.getItemCount() != 0 && servType.getItemCount() != 0) {
                ResultSet r = DB.search("SELECT price FROM service_price INNER JOIN vehicle_type ON service_price.vehicle_type_id = vehicle_type.id INNER JOIN service ON service_price.service_id = service.id WHERE vehicle_type = '" + vCategory.getSelectedItem().toString() + "' AND service_type = '" + servType.getSelectedItem().toString() + "'");
                if (r.next()) {
                    servCharge.setText(r.getString("price"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_vCategoryActionPerformed

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

                r = DB.search("SELECT part_model FROM vehicle_part_details INNER JOIN part_model ON vehicle_part_details.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN vehicle_model ON vehicle_part_details.vehicle_model_id = vehicle_model.id INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id WHERE vehicle_brand.brand_name = '" + vBrand.getSelectedItem().toString() + "' AND model_name = '" + vModel.getSelectedItem().toString() + "' AND category_name = '" + item_category.getSelectedItem().toString() + "' AND part_brand.brand_name = '" + itemBrand.getSelectedItem().toString() + "'");
                if (r.next()) {
                    itemType.setSelectedItem(r.getString("part_model"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemBrandActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        String itCat = item_category.getSelectedItem().toString();
        String itBrand = itemBrand.getSelectedItem().toString();
        String itModel = itemType.getSelectedItem().toString();
        double qt = Double.parseDouble(qty.getText());
        String stkprce = stPrice.getSelectedItem().toString().substring(4);
        int j;
        boolean b = false;
        for (j = 0; j < itemTable.getRowCount(); j++) {
            String jstkprce = df.format(Double.parseDouble(itemTable.getValueAt(j, 4).toString()) / Double.parseDouble(itemTable.getValueAt(j, 3).toString()));
            if (itemTable.getValueAt(j, 0).toString().equals(itCat) && itemTable.getValueAt(j, 1).toString().equals(itBrand) && itemTable.getValueAt(j, 2).toString().equals(itModel) && stkprce.equals(jstkprce)) {
                b = true;
                break;
            }
        }
        stockqty.setText(df2.format(Double.parseDouble(stockqty.getText()) - qt));
        if (b) {
            double newqt = qt + Double.parseDouble(itemTable.getValueAt(j, 3).toString());
            itemTable.setValueAt(df2.format(newqt), j, 3);
            itemTable.setValueAt(df.format(Double.parseDouble(stkprce) * newqt), j, 4);
        } else {
            Vector v = new Vector();
            v.add(itCat);
            v.add(itBrand);
            v.add(itModel);
            v.add(df2.format(qt));
            v.add(df.format(Double.parseDouble(stPrice.getSelectedItem().toString().substring(4)) * Double.parseDouble(qty.getText())));
            dtm.addRow(v);
        }
    }//GEN-LAST:event_addbtnActionPerformed

    private void itemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTypeActionPerformed
        try {
            if (itemType.getItemCount() != 0) {
                stPrice.removeAllItems();
                ResultSet r = DB.search("SELECT part_model.id FROM part_model INNER JOIN part on part_model.part_id = part.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id INNER JOIN part_category ON part.part_category_id = part_category.id WHERE category_name = '" + item_category.getSelectedItem().toString() + "' AND brand_name = '" + itemBrand.getSelectedItem().toString() + "' AND part_model = '" + itemType.getSelectedItem().toString() + "'");
                r.next();
                r = DB.search("SELECT selling_price, qty FROM stock WHERE part_model_id = '" + r.getInt("id") + "' AND status_id = '1'");
                while (r.next()) {
                    stPrice.addItem("Rs. " + r.getString("selling_price"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemTypeActionPerformed

    private void stPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stPriceActionPerformed
        try {
            String itCat = item_category.getSelectedItem().toString();
            String itBrand = itemBrand.getSelectedItem().toString();
            String itModel = itemType.getSelectedItem().toString();
            String qt = qty.getText();

            if (stPrice.getItemCount() != 0) {
                String stkprce = stPrice.getSelectedItem().toString().substring(4);
                ResultSet r = DB.search("SELECT part_model.id FROM part_model INNER JOIN part on part_model.part_id = part.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id INNER JOIN part_category ON part.part_category_id = part_category.id WHERE category_name = '" + itCat + "' AND brand_name = '" + itBrand + "' AND part_model = '" + itModel + "'");
                r.next();
                r = DB.search("SELECT qty FROM stock WHERE part_model_id = '" + r.getInt("id") + "' AND selling_price = '" + stkprce + "'");
                r.next();

                int j;
                boolean b = false;
                for (j = 0; j < itemTable.getRowCount(); j++) {
                    String jstkprce = df.format(Double.parseDouble(itemTable.getValueAt(j, 4).toString()) / Double.parseDouble(itemTable.getValueAt(j, 3).toString()));
                    if (itemTable.getValueAt(j, 0).toString().equals(itCat) && itemTable.getValueAt(j, 1).toString().equals(itBrand) && itemTable.getValueAt(j, 2).toString().equals(itModel) && stkprce.equals(jstkprce)) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    double newqt = Double.parseDouble(r.getString("qty")) - Double.parseDouble(itemTable.getValueAt(j, 3).toString());
                    stockqty.setText(df2.format(newqt));
                } else {
                    stockqty.setText(r.getString("qty"));
                }
            } else {
                stockqty.setText("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_stPriceActionPerformed

    private void dueAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dueAmountKeyReleased
        if (dueAmount.getText().equals("")) {
            subTotal.setText(df.format(Double.parseDouble(itemCost.getText()) + Double.parseDouble(servCharge.getText())));
        } else {
            subTotal.setText(df.format(Double.parseDouble(itemCost.getText()) + Double.parseDouble(servCharge.getText()) + Double.parseDouble(dueAmount.getText())));
        }
    }//GEN-LAST:event_dueAmountKeyReleased

    private void vNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vNumberKeyReleased
        SuggestionList.showList(vNumber, vSuggestBox, "SELECT licen_plate FROM customer_vehicle WHERE licen_plate LIKE '" + vNumber.getText() + "%'", "licen_plate", evt, this.getClass().getName());
    }//GEN-LAST:event_vNumberKeyReleased

    void m() {
        try {
            Date d = new Date();
            String today = new SimpleDateFormat("yyyy-MM-dd").format(d);
            String now = new SimpleDateFormat("HH:mm:ss").format(d);

            ResultSet r = DB.search("SELECT mobile FROM customer WHERE mobile = '" + mobile.getText() + "'");
            if (r.next()) {
                DB.iud("UPDATE customer SET fname = '" + fname.getText() + "', lname = '" + lname.getText() + "' WHERE mobile = '" + mobile.getText() + "'");
            } else {
                DB.iud("INSERT INTO customer(mobile, fname, lname) VALUES('" + mobile.getText() + "', '" + fname.getText() + "', '" + lname.getText() + "')");
            }

            int payMethod;
            Double due;
            Double payment;
            if (jRadioButton1.isSelected()) {
                payMethod = 0;
                if (paidAmount.getText().trim().isEmpty()) {
                    payment = 0.0;
                } else {
                    payment = Double.parseDouble(paidAmount.getText());
                }
            } else if (jRadioButton2.isSelected()) {
                payMethod = 1;
                payment = Double.parseDouble(chequePaymentc.getText());
                DB.iud("INSERT INTO received_cheque(customer_mobile, issued_date, cheque_no, branch_code, bank_code, cheque_date, amount) VALUES('" + mobile.getText() + "', '" + today + " " + now + "', '" + chNoc.getText() + "', '" + branch_Codec.getText() + "', '" + bankCodec.getText() + "', '" + chDatec.getText() + "', '" + payment + "')");
            } else {
                payMethod = 2;
                double chkPay = Double.parseDouble(chequePayment.getText());
                payment = Double.parseDouble(cashPayment.getText()) + chkPay;
                DB.iud("INSERT INTO received_cheque(customer_mobile, issued_date, cheque_no, branch_code, bank_code, cheque_date, amount) VALUES('" + mobile.getText() + "', '" + today + " " + now + "', '" + chNo.getText() + "', '" + branch_Code.getText() + "', '" + bankCode.getText() + "', '" + chDate.getText() + "', '" + chkPay + "')");
            }
            double tot = Double.parseDouble(subTotal.getText());
            if (payment < tot) {
                due = tot - payment;
            } else {
                due = 0d;
            }

            r = DB.search("SELECT licen_plate FROM customer_vehicle WHERE licen_plate = '" + vNumber.getText() + "'");
            if (r.next()) {
                DB.iud("UPDATE customer_vehicle SET customer_mobile = '" + mobile.getText() + "', due = '" + df.format(due) + "' WHERE licen_plate = '" + vNumber.getText() + "'");
            } else {
                r = DB.search("SELECT vehicle_model.id FROM vehicle_model INNER JOIN vehicle_brand ON vehicle_model.vehicle_brand_id = vehicle_brand.id WHERE model_name = '" + vModel.getSelectedItem().toString() + "' AND brand_name = '" + vBrand.getSelectedItem().toString() + "'");
                r.next();
                DB.iud("INSERT INTO customer_vehicle(licen_plate, vehicle_model_id, customer_mobile, due, reg_date) VALUES('" + vNumber.getText() + "', '" + r.getInt("id") + "', '" + mobile.getText() + "', '" + due + "', '" + today + "')");
            }

            r = DB.search("SELECT id FROM service WHERE service_type = '" + servType.getSelectedItem().toString() + "'");
            r.next();
            int invID = Integer.parseInt(title.substring(23, title.length() - 1));
            DB.iud("INSERT INTO invoice(id, vehicle_licen_plate, datetime, time, service_id, mileage, service_charge, payment_method_id, payment) VALUES('" + invID + "', '" + vNumber.getText() + "', '" + today + "', '" + now + "', '" + r.getInt("id") + "', '" + df.format(Double.parseDouble(mileage.getText())) + "', '" + servCharge.getText() + "', '" + payMethod + "', '" + payment + "')");
            ArrayList<String> al = new ArrayList<>();
            int i = 0;
            for (int j = 0; j < itemTable.getRowCount(); j++) {
                String itCat = itemTable.getValueAt(j, 0).toString();
                String itBrand = itemTable.getValueAt(j, 1).toString();
                String itModel = itemTable.getValueAt(j, 2).toString();
                double qty = Double.parseDouble(itemTable.getValueAt(j, 3).toString());
                String stockPrice = df2.format(Double.parseDouble(itemTable.getValueAt(j, 4).toString()) / qty);

                r = DB.search("SELECT part_model.id, min_quota FROM part_model INNER JOIN part on part_model.part_id = part.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id INNER JOIN part_category ON part.part_category_id = part_category.id WHERE category_name = '" + itCat + "' AND brand_name = '" + itBrand + "' AND part_model = '" + itModel + "'");
                r.next();
                int itModelID = r.getInt("id");
                double minqty = r.getDouble("min_quota");
                r = DB.search("SELECT id, qty FROM stock WHERE part_model_id = '" + itModelID + "' AND selling_price = '" + stockPrice + "'");
                r.next();
                int stockID = r.getInt("id");
                double stockQty = r.getDouble("qty") - qty;
                DB.iud("INSERT INTO invoice_item(invoice_id, part_model_id, stock_id, qty) VALUES('" + invID + "', '" + itModelID + "', '" + stockID + "', '" + df2.format(qty) + "')");
                DB.iud("UPDATE stock SET qty = '" + df2.format(stockQty) + "' WHERE id = " + stockID);
                if (stockQty <= minqty) {
                    if (i == 0) {
                        if (itModel.equals("N/A")) {
                            al.add(itBrand + " " + itCat);
                        } else {
                            al.add(itBrand + " " + itCat + " [ " + itModel + " ]");
                        }
                        al.add(df.format(stockQty));
                    }
                    i++;

                    r = DB.search("SELECT stock_id FROM notified_stock where stock_id = '" + stockID + "'");
                    if (r.next()) {
                        DB.iud("UPDATE notified_stock SET ns_date = '" + today + " " + now + "' WHERE stock_id = '" + stockID + "'");
                    } else {
                        DB.iud("INSERT INTO notified_stock(ns_date, stock_id) VALUES('" + today + " " + now + "', '" + stockID + "')");
                    }
                    StockNotifications.getObject().loadTable();
                }
            }
            if (!al.isEmpty()) {
                if (i == 1) {
                    String s;
                    if (al.get(1).equals("0")) {
                        s = "None left in stock.";
                    } else {
                        s = "Only " + al.get(1) + " left in stock.";
                    }
                    NotificationPanel.showNotification("Minimum quota has been reached.", al.get(0), s, NotificationPanel.INFO);
                } else {
                    NotificationPanel.showNotification("Minimum quota has been reached.", al.get(0) + " & " + (i - 1) + " more.", "Click to see more details.", NotificationPanel.INFO);
                }
            }
            invoiceid = invID;
            title = "Customer [Invoice ID - " + String.valueOf(invID + 1) + "]";
            Home.getObject().title.setText(title);
            resetActivity();
            if (Stock.o != null) {
                Stock.getObject().loadCombos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void viewReport(int invid) throws Exception {
        double d1 = 0.0;
        String query1 = "select (stock.selling_price * invoice_item.qty) as nettotal from invoice inner join invoice_item on invoice_item.invoice_id=invoice.id inner join stock on stock.id=invoice_item.stock_id where invoice.id ='" + invid + "'";
        try {
            ResultSet result1 = DB.search(query1);
            while (result1.next()) {
                d1 = Double.parseDouble(result1.getString("nettotal")) + d1;
            }
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("invoiceid", invid);
            parameter.put("nettotal", d1);

            //  JasperReport jr= JasperCompileManager.compileReport("/BILL/Invoice.jrxml"); <-MEKEDI APP EKA RUN WEN AHAMA WELAWEMA COMPILE WENAWA..SCND EKATH WADAAGTH NISA COMPL KRALA E FILE EKA STREAM EKAK WIDIYATA GANNA..
            InputStream jr = Supplier.class.getResourceAsStream("/BILL/Invoice.jasper");
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, DB.getConnection());
            JasperViewer.viewReport(jp, false);

            //    JasperPrintManager.printReport(jp,false);
            invid++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (vNumber.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(Home.getObject(), "Vehicle Number cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            vNumber.grabFocus();
        } else if (mileage.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(Home.getObject(), "Mileage cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            mileage.grabFocus();
        } else if (mobile.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(Home.getObject(), "Customer's Mobile number cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            mobile.grabFocus();
        } else if (!Validation.validateMobile(mobile.getText())) {
            JOptionPane.showMessageDialog(Home.getObject(), "Customer's Mobile number is not valid. Please check again.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
            mobile.grabFocus();
        } else if (fname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(Home.getObject(), "Customer's First Name cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            fname.grabFocus();
        } else if (lname.getText().trim().trim().isEmpty()) {
            JOptionPane.showMessageDialog(Home.getObject(), "Customer's Last Name cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            lname.grabFocus();
        } else if (jRadioButton2.isSelected()) {
            if (chequePaymentc.getText().trim().trim().isEmpty() || chequePaymentc.getText().equals("0")) {
                JOptionPane.showMessageDialog(Home.getObject(), "Cheque payments cannot be 0.", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
                chequePaymentc.grabFocus();
            } else if (chNoc.getText().trim().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Home.getObject(), "Cheque Number cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                chNoc.grabFocus();
            } else if (bankCodec.getText().trim().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Home.getObject(), "Bank Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                bankCodec.grabFocus();
            } else if (branch_Codec.getText().trim().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Home.getObject(), "Branch Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                branch_Codec.grabFocus();
            } else if (chDatec.getText().trim().trim().isEmpty() || chDatec.getText().length() != 10) {
                JOptionPane.showMessageDialog(Home.getObject(), "Invalid cheque date.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                chDatec.grabFocus();
            } else {
                m();
            }
        } else if (jRadioButton3.isSelected()) {
            if (chequePayment.getText().trim().isEmpty() || chequePayment.getText().equals("0")) {
                JOptionPane.showMessageDialog(Home.getObject(), "Cheque payments cannot be 0.", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
                chequePayment.grabFocus();
            } else if (cashPayment.getText().trim().isEmpty() || cashPayment.getText().equals("0")) {
                JOptionPane.showMessageDialog(Home.getObject(), "Cash payment amount cannot be 0.", "Invalid Amount", JOptionPane.INFORMATION_MESSAGE);
                cashPayment.grabFocus();
            } else if (chNo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Home.getObject(), "Cheque Number cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                chNo.grabFocus();
            } else if (bankCode.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Home.getObject(), "Bank Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                bankCode.grabFocus();
            } else if (branch_Code.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(Home.getObject(), "Branch Code cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                branch_Code.grabFocus();
            } else if (chDate.getText().trim().isEmpty() || chDate.getText().length() != 10) {
                JOptionPane.showMessageDialog(Home.getObject(), "Invalid cheque date.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                chDate.grabFocus();
            } else {
                m();
            }
        } else {
            m();
        }
        printbutton = true;
        print.setEnabled(printbutton);
    }//GEN-LAST:event_jButton5ActionPerformed

    void resetActivity() {
        vNumber.setText(null);
        mileage.setText(null);
        mobile.setText(null);
        fname.setText(null);
        lname.setText(null);
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
        dtm.setRowCount(0);
        loadCombos();
    }

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        pc2.propertyChange(null);
    }//GEN-LAST:event_qtyKeyReleased

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        if (evt.getClickCount() == 2) {
            int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove item ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION) {
                dtm.removeRow(itemTable.getSelectedRow());
                stPrice.setSelectedItem(stPrice.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_itemTableMouseClicked

    private void mobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyReleased
        SuggestionList.showList(mobile, mobileSuggestBox, "SELECT mobile FROM customer WHERE mobile LIKE '" + mobile.getText() + "%'", "mobile", evt, this.getClass().getName());
    }//GEN-LAST:event_mobileKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        resetActivity();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void mileageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mileageActionPerformed
        mobile.grabFocus();
    }//GEN-LAST:event_mileageActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        lname.grabFocus();
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        qty.grabFocus();
    }//GEN-LAST:event_lnameActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        addbtn.grabFocus();
    }//GEN-LAST:event_qtyActionPerformed

    private void mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyPressed
        if (evt.getKeyCode() == 10) {
            mobileKeyReleased(evt);
            fname.grabFocus();
        }
    }//GEN-LAST:event_mobileKeyPressed

    private void vNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vNumberKeyPressed
        if (evt.getKeyCode() == 10) {
            vNumberKeyReleased(evt);
            mileage.grabFocus();
        }
    }//GEN-LAST:event_vNumberKeyPressed

    private void vSuggestBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_vSuggestBoxPopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(vNumber, vSuggestBox);
    }//GEN-LAST:event_vSuggestBoxPopupMenuWillBecomeInvisible

    private void mobileSuggestBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_mobileSuggestBoxPopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(mobile, mobileSuggestBox);
    }//GEN-LAST:event_mobileSuggestBoxPopupMenuWillBecomeInvisible

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new ChequeDetails().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new RegisterNewVehicle().setVisible(true);
        Home.getObject().setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ServiceType().setVisible(true);
        Home.getObject().setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        Validation.validateAmount(evt, qty);
    }//GEN-LAST:event_qtyKeyTyped

    private void dueAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dueAmountKeyTyped
        Validation.validateAmount(evt, dueAmount);
    }//GEN-LAST:event_dueAmountKeyTyped

    private void paidAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountKeyTyped
        Validation.validateAmount(evt, paidAmount);
    }//GEN-LAST:event_paidAmountKeyTyped

    private void chequePaymentcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chequePaymentcKeyTyped
        Validation.validateAmount(evt, chequePaymentc);
    }//GEN-LAST:event_chequePaymentcKeyTyped

    private void cashPaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashPaymentKeyTyped
        Validation.validateAmount(evt, cashPayment);
    }//GEN-LAST:event_cashPaymentKeyTyped

    private void chequePaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chequePaymentKeyTyped
        Validation.validateAmount(evt, chequePayment);
    }//GEN-LAST:event_chequePaymentKeyTyped

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        Validation.validateMobileNumber(evt, mobile);
    }//GEN-LAST:event_mobileKeyTyped

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
        Validation.validateName(evt, fname);
    }//GEN-LAST:event_fnameKeyTyped

    private void lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyTyped
        Validation.validateName(evt, lname);
    }//GEN-LAST:event_lnameKeyTyped

    private void mileageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mileageKeyTyped
        Validation.validateAmount(evt, mileage);
    }//GEN-LAST:event_mileageKeyTyped

    private void chDatecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chDatecKeyTyped
        Validation.validateDate(evt, chDatec);
    }//GEN-LAST:event_chDatecKeyTyped

    private void chDatecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chDatecKeyPressed
        if (evt.getKeyCode() == 37 || evt.getKeyCode() == 39) {
            evt.consume();
        }
    }//GEN-LAST:event_chDatecKeyPressed

    private void chDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chDateKeyPressed
        if (evt.getKeyCode() == 37 || evt.getKeyCode() == 39) {
            evt.consume();
        }
    }//GEN-LAST:event_chDateKeyPressed

    private void chDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chDateKeyTyped
        Validation.validateDate(evt, chDate);
    }//GEN-LAST:event_chDateKeyTyped

    private void chNocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chNocKeyTyped
        Validation.validateText(evt, chNoc);
    }//GEN-LAST:event_chNocKeyTyped

    private void branch_CodecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_branch_CodecKeyTyped
        Validation.validateText(evt, branch_Codec);
    }//GEN-LAST:event_branch_CodecKeyTyped

    private void bankCodecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankCodecKeyTyped
        Validation.validateText(evt, bankCodec);
    }//GEN-LAST:event_bankCodecKeyTyped

    private void chNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chNoKeyTyped
        Validation.validateText(evt, chNo);
    }//GEN-LAST:event_chNoKeyTyped

    private void branch_CodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_branch_CodeKeyTyped
        Validation.validateText(evt, branch_Code);
    }//GEN-LAST:event_branch_CodeKeyTyped

    private void bankCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankCodeKeyTyped
        Validation.validateText(evt, bankCode);
    }//GEN-LAST:event_bankCodeKeyTyped

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            if (invoiceid != 0) {
                viewReport(invoiceid);
                print.setEnabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            print.setEnabled(false);
        }
    }//GEN-LAST:event_printActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
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
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> itemBrand;
    private javax.swing.JLabel itemCost;
    public javax.swing.JTable itemTable;
    private javax.swing.JComboBox<String> itemType;
    private javax.swing.JComboBox<String> item_category;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mileage;
    private javax.swing.JTextField mobile;
    private javax.swing.JComboBox<String> mobileSuggestBox;
    private javax.swing.JLabel netTotal;
    private javax.swing.JLabel netTotal2;
    private javax.swing.JTextField paidAmount;
    private javax.swing.JButton print;
    private javax.swing.JTextField qty;
    private javax.swing.JLabel servCharge;
    public javax.swing.JComboBox<String> servType;
    private javax.swing.JComboBox<String> stPrice;
    private javax.swing.JLabel stockqty;
    private javax.swing.JLabel subTotal;
    private javax.swing.JComboBox<String> vBrand;
    private javax.swing.JComboBox<String> vCategory;
    private javax.swing.JComboBox<String> vModel;
    public javax.swing.JTextField vNumber;
    private javax.swing.JComboBox<String> vSuggestBox;
    // End of variables declaration//GEN-END:variables
}
