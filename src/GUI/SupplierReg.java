package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.SuggestionList;
import Model.TableAlign;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import validation.Validation;

public class SupplierReg extends javax.swing.JFrame {

    DefaultTableModel dtm;

    public SupplierReg() {
        initComponents();
        FrameIcon.setIcon(this);
        TableAlign.alignCenter(jTable1);
        dtm = (DefaultTableModel) jTable1.getModel();

        comName.getDocument().addDocumentListener(new DocumentListener() {
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
                    ResultSet r = DB.search("SELECT email, contact, web, address FROM company WHERE name = '" + comName.getText() + "'");
                    if (r.next()) {
                        email.setText(r.getString("email"));
                        contact.setText(r.getString("contact"));
                        web.setText(r.getString("web"));
                        address.setText(r.getString("address"));
                    } else {
                        email.setText(null);
                        contact.setText(null);
                        web.setText(null);
                        address.setText(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
                    ResultSet r = DB.search("SELECT fname, lname, mobile, name FROM supplier INNER JOIN company ON supplier.company_id = company.id WHERE nic = '" + nic.getText() + "'");
                    if (r.next()) {
                        mobile.setText(r.getString("mobile"));
                        fname.setText(r.getString("fname"));
                        lname.setText(r.getString("lname"));
                        comName.setText(r.getString("name"));
                    } else {
                        mobile.setText(null);
                        fname.setText(null);
                        lname.setText(null);
                        comName.setText(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
                            nullify();
                            String nicNo = jTable1.getValueAt(rows[0], 0).toString();
                            String com = jTable1.getValueAt(rows[0], 3).toString();
                            nic.setText(nicNo);
                            comName.setText(com);
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
            ResultSet r = DB.search("SELECT nic, fname, lname, mobile, name, contact from supplier INNER JOIN company ON supplier.company_id = company.id ORDER BY fname, lname, name");
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("nic"));
                v.add(r.getString("fname") + " " + r.getString("lname"));
                v.add(r.getString("mobile"));
                v.add(r.getString("name"));
                v.add(r.getString("contact"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nicSuggestBox = new javax.swing.JComboBox<>();
        companySuggestBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        comName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        web = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        delbtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add / Update Supplier And Company Details");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        nicSuggestBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nicSuggestBox.setName(""); // NOI18N
        nicSuggestBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                nicSuggestBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        companySuggestBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        companySuggestBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                companySuggestBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Supplier Mobile :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Supplier NIC :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("First Name :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Last Name :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Company :");

        nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nicKeyReleased(evt);
            }
        });

        mobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
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

        comName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comNameKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Supplier Details");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Add / Update Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Company Details");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("E - mail :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Contact No. :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Address :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Web Site :");

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactKeyTyped(evt);
            }
        });

        web.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webActionPerformed(evt);
            }
        });
        web.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                webKeyTyped(evt);
            }
        });

        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addressKeyTyped(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "Name", "Supplier Mobile", "Company", "Company Tel."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Search :");

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(search)
                        .addGap(6, 6, 6)
                        .addComponent(delbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(comName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(companySuggestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(25, 25, 25)
                                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(44, 44, 44)
                                .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(51, 51, 51)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nicSuggestBox, 0, 246, Short.MAX_VALUE)
                                    .addComponent(nic))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(delbtn))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(nicSuggestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6))
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8))
                            .addComponent(comName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(companySuggestBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel10))
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12))
                            .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11))
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyReleased
        SuggestionList.showList(nic, nicSuggestBox, "SELECT nic FROM supplier WHERE nic LIKE '" + nic.getText() + "%'", "nic", evt, this.getClass().getName());
    }//GEN-LAST:event_nicKeyReleased

    private void comNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comNameKeyReleased
        SuggestionList.showList(comName, companySuggestBox, "SELECT name FROM company WHERE name LIKE '" + comName.getText() + "%'", "name", evt, this.getClass().getName());
    }//GEN-LAST:event_comNameKeyReleased

    private void companySuggestBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_companySuggestBoxPopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(comName, companySuggestBox);
    }//GEN-LAST:event_companySuggestBoxPopupMenuWillBecomeInvisible

    private void nicSuggestBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nicSuggestBoxPopupMenuWillBecomeInvisible
        SuggestionList.setSelectedItem(nic, nicSuggestBox);
    }//GEN-LAST:event_nicSuggestBoxPopupMenuWillBecomeInvisible

    void checkComValid() {
        if (comName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campany Name Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
            comName.grabFocus();
        } else {
            if (Validation.validateMobile(contact.getText())) {
                if (email.getText().isEmpty()) {
                    m();
                } else {
                    if (Validation.validateEmail(email.getText())) {
                        m();
                    } else {
                        JOptionPane.showMessageDialog(this, "Campany e-mail is invalid.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                        email.grabFocus();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Campany's Contact Number is invalid.", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                contact.grabFocus();
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (nic.getText().isEmpty()) {
            checkComValid();
        } else {
            if (Validation.validateNic(nic.getText())) {
                if (Validation.validateMobile(mobile.getText())) {
                    if (fname.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "First Name Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                        fname.grabFocus();
                    } else {
                        if (lname.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Last Name Cannot be empty.", "Empty Value", JOptionPane.INFORMATION_MESSAGE);
                            lname.grabFocus();
                        } else {
                            checkComValid();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Mobile number is Invalid", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                    mobile.grabFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "NIC number is Invalid", "Invalid Value", JOptionPane.INFORMATION_MESSAGE);
                nic.grabFocus();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void m() {
        try {
            String cName = comName.getText().trim();
            ResultSet r = DB.search("SELECT id FROM company WHERE name = '" + cName + "'");
            int comID;
            if (r.next()) {
                comID = r.getInt("id");
                DB.iud("UPDATE company SET email = '" + email.getText() + "', contact = '" + contact.getText() + "', web = '" + web.getText() + "', address = '" + address.getText() + "' WHERE id = '" + comID + "'");
            } else {
                DB.iud("INSERT INTO company(name, email, contact, web, address) VALUES('" + cName + "', '" + email.getText() + "', '" + contact.getText() + "', '" + web.getText() + "', '" + address.getText() + "')");
                r = DB.search("SELECT id FROM company WHERE name = '" + cName + "'");
                r.next();
                comID = r.getInt("id");
            }
            String snic = nic.getText().trim();
            if (!snic.equals("")) {
                r = DB.search("SELECT nic FROM supplier WHERE nic = '" + snic + "'");
                if (r.next()) {
                    DB.iud("UPDATE supplier SET fname = '" + fname.getText() + "', lname = '" + lname.getText() + "', mobile = '" + mobile.getText() + "', company_id = '" + comID + "' WHERE nic = '" + snic + "'");
                } else {
                    DB.iud("INSERT INTO supplier(nic, fname, lname, mobile, company_id) VALUES('" + snic + "', '" + fname.getText() + "', '" + lname.getText() + "', '" + mobile.getText() + "', '" + comID + "')");
                }
            }
            loadTable();
            nullify();
            nic.grabFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void nullify() {
        nic.setText(null);
        mobile.setText(null);
        fname.setText(null);
        lname.setText(null);
        comName.setText(null);
        email.setText(null);
        contact.setText(null);
        web.setText(null);
        address.setText(null);
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home.getObject().setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            int[] rows = jTable1.getSelectedRows();
            for (int row : rows) {
                String nicNo = jTable1.getValueAt(row, 0).toString();
                ResultSet r = DB.search("SELECT id from grn WHERE supplier_nic = '" + nicNo + "'");
                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "Can't delete supplier \'" + jTable1.getValueAt(row, 1).toString() + " (" + nicNo + ")\' since there are GRN records related to this supplier.\nYou can only delete newly added suppliers, that don't have any GRN records.", "Suppiler in use", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DB.iud("DELETE FROM supplier WHERE nic = '" + nicNo + "'");
                    nullify();
                }
            }
            loadTable();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        TableRowSorter ts = new TableRowSorter(dtm);
        ts.setRowFilter(RowFilter.regexFilter("(?i)" + search.getText()));
        jTable1.setRowSorter(ts);
    }//GEN-LAST:event_searchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home.getObject().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        Validation.validateMobileNumber(evt, mobile);
    }//GEN-LAST:event_mobileKeyTyped

    private void fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameKeyTyped
        Validation.validateName(evt, fname);
    }//GEN-LAST:event_fnameKeyTyped

    private void lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyTyped
        Validation.validateName(evt, lname);
    }//GEN-LAST:event_lnameKeyTyped

    private void comNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comNameKeyTyped
        Validation.validateItemName(evt, comName);
    }//GEN-LAST:event_comNameKeyTyped

    private void contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyTyped
        Validation.validateMobileNumber(evt, contact);
    }//GEN-LAST:event_contactKeyTyped

    private void webKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_webKeyTyped
        Validation.validateText(evt, web);
    }//GEN-LAST:event_webKeyTyped

    private void addressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyTyped
        Validation.validateText(evt, address);
    }//GEN-LAST:event_addressKeyTyped

    private void nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyPressed
        if (evt.getKeyCode() == 10) {
            nicKeyReleased(evt);
            mobile.grabFocus();
        }
    }//GEN-LAST:event_nicKeyPressed

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed
        fname.grabFocus();
    }//GEN-LAST:event_mobileActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        lname.grabFocus();
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        comName.grabFocus();
    }//GEN-LAST:event_lnameActionPerformed

    private void comNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comNameKeyPressed
        if (evt.getKeyCode() == 10) {
            comNameKeyReleased(evt);
            email.grabFocus();
        }
    }//GEN-LAST:event_comNameKeyPressed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        contact.grabFocus();
    }//GEN-LAST:event_emailActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        web.grabFocus();
    }//GEN-LAST:event_contactActionPerformed

    private void webActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webActionPerformed
        address.grabFocus();
    }//GEN-LAST:event_webActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        jButton1.grabFocus();
    }//GEN-LAST:event_addressActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        nic.grabFocus();
    }//GEN-LAST:event_searchActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField comName;
    private javax.swing.JComboBox<String> companySuggestBox;
    private javax.swing.JTextField contact;
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField nic;
    private javax.swing.JComboBox<String> nicSuggestBox;
    private javax.swing.JTextField search;
    private javax.swing.JTextField web;
    // End of variables declaration//GEN-END:variables
}
