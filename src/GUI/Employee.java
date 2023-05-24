/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Cryptography.Cryption;
import DB.DB;
import Model.Settings;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.sql.ResultSet;

import java.sql.Savepoint;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sqllogger.SQLLog;
import validation.Validation;

/**
 *
 * @author Lakshan
 */
public class Employee extends javax.swing.JPanel {

    public String title = "Employee Details";
    Savepoint sp;
    public String ButtonType = "ADD";
    SQLLog WriteToSql = new SQLLog();
    String NIC;
    String gender;
    String DOB;
    String mob;
    String lname;
    String fname;
    String add_line1;
    String add_line2;
    String add_no;
    String employeeId;
    String NICOfEmployee;
    boolean changevalue = false;
    Icon ImageOfUse;
    File fsrc;
    File des;
    String path;
    String address;
    DefaultTableModel dtm;
    File f;
    BufferedImage image;
    Image setimg;
    ImageIcon imgset;
    int SelectedRow;
    JFileChooser chooser;
    boolean b;

    /**
     * Creates new form Employee
     */
    private Employee() {

        initComponents();
        male.setSelected(true);
        genarateCode();
        loadDataTotable();
        if (!"com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
            try {
                capture.setIcon(new ImageIcon(ImageIO.read(Employee.class.getResource("/Images/capture_b.png"))));
            } catch (IOException ex) {

            }
        }

//Document Listner For NIC
        nic.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!(Validation.validateNic(nic.getText())) && b) {
                    resetWithoutNIC();

                }
                enableButton();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!(Validation.validateNic(nic.getText())) && b) {
                    resetWithoutNIC();

                }
                enableButton();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!(Validation.validateNic(nic.getText())) && b) {
                    resetWithoutNIC();

                }
                enableButton();
            }

            void enableButton() {

                NICOfEmployee = nic.getText();
                if (Validation.validateNic(nic.getText())) {
                    capture.setEnabled(true);
                    img.setEnabled(true);
                    b = true;
                    checkStatus();
                    if (ButtonType.equals("ADD")) {
                        adddata.setEnabled(true);
                        adddata.setText("Add User");
                    }

                    if (ButtonType.equalsIgnoreCase("UPDATE")) {

                        if (!(nic.getText().isEmpty())) {
                            setDataWithOutNic(nic.getText());

                        }
                        adddata.setEnabled(false);

                    }
                    if (ButtonType.equalsIgnoreCase("DELETE")) {

                        adddata.setEnabled(false);
                        delete.setEnabled(false);

                    }

                } else {
                    adddata.setEnabled(false);
                    delete.setEnabled(false);
                    activateuser.setEnabled(false);

                }
            }

        });
        // Selection Listner
        dtm = (DefaultTableModel) jTable1.getModel();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (jTable1.getSelectedRowCount() == 1) {

                    String searchNic = dtm.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    nic.setText(searchNic);
                    jTable1.grabFocus();

                } else {
                    resetWithoutNIC();

                }
            }
        });
        //Document Listner For search
        search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                dataSorter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                dataSorter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                dataSorter();
            }
        });
        emp_type.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    enableUpdate();
                } catch (Exception ex) {
                }
            }
        });
    }
    public static Employee o;

    public static Employee getObject() {
        if (o == null) {
            o = new Employee();
        }
        // o.nic.grabFocus();
        o.adddata.setEnabled(false);
        o.delete.setEnabled(false);
        o.activateuser.setEnabled(false);
        o.change.setVisible(false);
        // o.nic.setText(o.nic.getText());
        return o;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        adddata = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        address_no = new javax.swing.JTextField();
        address_street = new javax.swing.JTextField();
        address_city = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        emp_type = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        ShowDate = new javax.swing.JTextField();
        activateuser = new javax.swing.JButton();
        change = new javax.swing.JButton();
        capture = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(843, 648));
        setPreferredSize(new java.awt.Dimension(843, 648));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add / Update Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NIC :");

        nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nicFocusGained(evt);
            }
        });
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nicKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nicKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("First Name :");

        firstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstname.setMinimumSize(new java.awt.Dimension(100, 100));
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstnameKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Last Name :");

        lastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastname.setMinimumSize(new java.awt.Dimension(100, 100));
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        lastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastnameKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Gender :");

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Moblile :");

        mobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mobile.setMinimumSize(new java.awt.Dimension(100, 100));
        mobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobileFocusLost(evt);
            }
        });
        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mobileKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("DOB :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Address :");

        img.setForeground(new java.awt.Color(204, 204, 204));
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setText("Click To Add");
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        img.setEnabled(false);
        img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Image :");

        adddata.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adddata.setText("Add/Update");
        adddata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddataActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delete.setText("Delete Selected");
        delete.setPreferredSize(new java.awt.Dimension(57, 25));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        address_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address_no.setText("NO.");
        address_no.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address_noFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_noFocusLost(evt);
            }
        });
        address_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_noActionPerformed(evt);
            }
        });
        address_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                address_noKeyTyped(evt);
            }
        });

        address_street.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address_street.setText("Street");
        address_street.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address_streetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_streetFocusLost(evt);
            }
        });
        address_street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_streetActionPerformed(evt);
            }
        });
        address_street.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_streetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                address_streetKeyTyped(evt);
            }
        });

        address_city.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address_city.setText("City");
        address_city.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address_cityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                address_cityFocusLost(evt);
            }
        });
        address_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_cityActionPerformed(evt);
            }
        });
        address_city.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                address_cityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                address_cityKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Employee Type :");

        emp_type.setPreferredSize(new java.awt.Dimension(64, 23));

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setMinimumSize(new java.awt.Dimension(100, 100));
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ShowDate.setEditable(false);
        ShowDate.setPreferredSize(new java.awt.Dimension(6, 23));

        activateuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        activateuser.setText("Activate/View User");
        activateuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activateuserActionPerformed(evt);
            }
        });

        change.setText("Change");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        capture.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        capture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/capture_w.png"))); // NOI18N
        capture.setAutoscrolls(true);
        capture.setEnabled(false);
        capture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emp_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(address_no)
                                    .addComponent(address_city)
                                    .addComponent(address_street))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(male)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(female))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(change)))
                                .addGap(0, 16, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(firstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                    .addComponent(mobile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ShowDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(capture, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(adddata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(activateuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(female)
                        .addComponent(jLabel6)
                        .addComponent(male))
                    .addComponent(ShowDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(emp_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(address_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address_street, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(capture, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adddata)
                    .addComponent(activateuser))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIC", "First Name", "Last Name", "Daily Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Search :");

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 498, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        deleteEmployee();
        JOptionPane.showMessageDialog(this, "Data " + "DELETE" + " Successful", "Successful", JOptionPane.INFORMATION_MESSAGE);
        reset();
        nic.grabFocus();
        loadDataTotable();

        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void nicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_nicKeyTyped
    private void adddataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddataActionPerformed

        b = false;
        checkStatus();

        if (validateInputs()) {
            setParameaters();
            if (ButtonType.equalsIgnoreCase("ADD")) {

                insertIntoDataBase();
                JOptionPane.showMessageDialog(this, "Data " + ButtonType + " Successful", "successfull", JOptionPane.INFORMATION_MESSAGE);

            } else if (ButtonType.equalsIgnoreCase("UPDATE")) {
                setParameaters();
                updateDatabase();
                JOptionPane.showMessageDialog(this, "Data " + ButtonType + " Successful", "successfull", JOptionPane.INFORMATION_MESSAGE);
                changevalue = false;
            }
            nic.grabFocus();
            reset();
            loadDataTotable();
            Payroll.getObject().tableLoad();
            b = true;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_adddataActionPerformed

    private void address_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_noKeyTyped
        enableUpdate();
    }//GEN-LAST:event_address_noKeyTyped

    private void address_streetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_streetKeyTyped
        enableUpdate();
    }//GEN-LAST:event_address_streetKeyTyped

    private void address_cityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_cityKeyTyped
        enableUpdate();
    }//GEN-LAST:event_address_cityKeyTyped

    private void address_streetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_streetActionPerformed
        // TODO add your handling code here:
        address_city.grabFocus();
    }//GEN-LAST:event_address_streetActionPerformed
    public void resetNic() {
        if (!(Validation.validateNic(nic.getText()))) {
            nic.setText(null);
        }
    }
    private void address_noFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_noFocusGained
        if ("NO.".equals(address_no.getText())) {
            address_no.setText(null);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_address_noFocusGained

    private void address_streetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_streetFocusGained
        // TODO add your handling code here:
        if ("Street".equals(address_street.getText())) {
            address_street.setText(null);
        }
    }//GEN-LAST:event_address_streetFocusGained

    private void address_cityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_cityFocusGained
        // TODO add your handling code here:
        if ("City".equals(address_city.getText())) {
            address_city.setText(null);
        }
    }//GEN-LAST:event_address_cityFocusGained

    private void imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgMouseClicked
        if (b) {
        }
            imageSet();

        adddata.setEnabled(true);
    }//GEN-LAST:event_imgMouseClicked
    
    private void imageSet() {
        try {
            if (chooser == null) {
                chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "gif", "png", "jpeg");
                chooser.setFileFilter(filter);
            }
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File Sorce = chooser.getSelectedFile();
                String so = Sorce.toString().replace("\\", "/");
                fsrc = new File(so);

                File folder = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img");
                if (!(folder.exists())) {
                    folder.mkdirs();
                }
                int targetWidth = img.getWidth();
                int targetHeight = img.getHeight();

                Image img = ImageIO.read(fsrc);
                double w = img.getWidth(null);
                double h = img.getHeight(null);
                if (w < h) {
                    double d = h / targetHeight;
                    targetWidth = (int) (w / d);
                } else {
                    double d = w / targetWidth;
                    targetHeight = (int) (h / d);
                }
                BufferedImage bi = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
                final Graphics2D g2D = bi.createGraphics();
                g2D.setComposite(AlphaComposite.Src);
                g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2D.drawImage(img, 0, 0, targetWidth, targetHeight, null);
                g2D.dispose();
                fsrc = new File(folder, "tmp");
                ImageIO.write(bi, "jpg", fsrc);
                ImageIcon imgset = new ImageIcon(bi);
                this.img.setText(null);
                this.img.setIcon(imgset);
                saveImage();

            }
        } catch (NullPointerException nulle) {
            JOptionPane.showMessageDialog(this, "Please Note The file You entered is not valid image file \n please  enter your image again", "invalid file", JOptionPane.INFORMATION_MESSAGE);
            imageSet();

            //saveImage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_nicKeyPressed
    public void setCaptureImage() {
        try {
            File folder = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img");
            if (!(folder.exists())) {
                folder.mkdirs();
            }
            int targetWidth = img.getWidth();
            int targetHeight = img.getHeight();
            fsrc = new File("capture.jpg");
            Image img = ImageIO.read(fsrc);
            double w = img.getWidth(null);
            double h = img.getHeight(null);
            if (w < h) {
                double d = h / targetHeight;
                targetWidth = (int) (w / d);
            } else {
                double d = w / targetWidth;
                targetHeight = (int) (h / d);
            }
            BufferedImage bi = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            final Graphics2D g2D = bi.createGraphics();
            g2D.setComposite(AlphaComposite.Src);
            g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.drawImage(img, 0, 0, targetWidth, targetHeight, null);
            g2D.dispose();
            fsrc = new File(folder, "tmp");
            ImageIO.write(bi, "jpg", fsrc);
            ImageIcon imgset = new ImageIcon(bi);
            this.img.setText(null);
            this.img.setIcon(imgset);
            saveImage();
        } catch (Exception e) {
        }

    }
    private void nicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicKeyReleased

    }//GEN-LAST:event_nicKeyReleased

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        male.grabFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void address_noFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_noFocusLost
        if (address_no.getText().isEmpty()) {
            address_no.setText("NO.");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_address_noFocusLost

    private void address_streetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_streetFocusLost
        // TODO add your handling code here:

        if (address_street.getText().isEmpty()) {
            address_street.setText("Street");
        }
    }//GEN-LAST:event_address_streetFocusLost

    private void address_cityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address_cityFocusLost
        // TODO add your handling code here:
        if (address_city.getText().isEmpty()) {
            address_city.setText("City");
        }
    }//GEN-LAST:event_address_cityFocusLost

    private void mobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyReleased
        enableUpdate();
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileKeyReleased

    private void mobileFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileFocusLost
        // TODO add your handling code here:
        if (Validation.validateMobile(mobile.getText())) {

        } else {
            if (!mobile.getText().isEmpty()) {

                mobile.setText(null);
                JOptionPane.showMessageDialog(this, "Incorrect Mobile", "Error", JOptionPane.ERROR_MESSAGE);
                mobile.grabFocus();
            }
        }
    }//GEN-LAST:event_mobileFocusLost

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        if (mobile.getText().length() == 10) {
            evt.consume();
        }
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_mobileKeyTyped
    private void loadDataTotable() {
        String qry = "this is not a sql error";
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setRowCount(0);
            qry = "SELECT * FROM employee WHERE status=1 AND nic <> 0 AND status=1";
            ResultSet rs = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("nic"));
                v.add(rs.getString("fname"));
                v.add(rs.getString("lname"));
                qry = "SELECT salary FROM employee_type WHERE id= '" + rs.getString("employee_type_id") + "'";
                ResultSet sal = DB.search(qry);
                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
                if (sal.next()) {

                    v.add(sal.getString("salary"));
                }

                dtm.addRow(v);

            }
        } catch (Exception e) {
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();

        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked
    private void setData(String NIC) {
        if (NIC.equals(nic.getText())) {

        }
        String qry = "This is not a sql error";
        try {

            qry = "SELECT * FROM employee WHERE nic = '" + NIC + "' OR nic = '" + Validation.convertNIC(NIC) + "' AND nic <> 0";
            ResultSet rs = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            if (rs.next()) {
                nic.setText(rs.getString("nic"));
                firstname.setText(rs.getString("fname"));
                lastname.setText(rs.getString("lname"));
                mobile.setText(rs.getString("mobile"));

                Date day = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dob"));

                jDateChooser1.setDate(day);

                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());

                if (rs.getString("gender_id").equals("2")) {

                    female.setSelected(true);

                } else {
                    male.setSelected(true);
                }

                qry = "SELECT * FROM employee_type WHERE id = '" + rs.getString("employee_type_id") + "'";

                ResultSet type = DB.search(qry);
                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
                if (type.next()) {
                    emp_type.setSelectedItem(type.getString("type"));
                }

                String full_address = rs.getString("address");
                String[] s = full_address.split(",");
                String no = s[0];
                String ln1 = s[1];
                String ln2 = s[2];

                address_no.setText(no);
                address_street.setText(ln1);
                address_city.setText(ln2);

                image = ImageIO.read(new File(rs.getString("photo")));

                imgset = new ImageIcon(image);

                img.setIcon(imgset);

            }

        } catch (IOException i) {
            JOptionPane.showMessageDialog(this, "We Are Sorry! We can not find the image that you seek. Please insert the image again and update", "File not found", JOptionPane.ERROR_MESSAGE);
            imageSet();

        } catch (Exception e) {
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        jTable1.grabFocus();

    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reset();
        loadDataTotable();
        nic.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        firstname.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        firstname.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        lastname.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        mobile.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void address_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_noActionPerformed
        address_street.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_address_noActionPerformed

    private void address_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_cityActionPerformed
        img.grabFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_address_cityActionPerformed

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed
        // TODO add your handling code here:
        jDateChooser1.grabFocus();


    }//GEN-LAST:event_mobileActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        loaddate();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void activateuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activateuserActionPerformed

        if (activateuser.getText().equalsIgnoreCase("Activate User")) {
            activatePassword();
        } else {
            try {
                Object[] option = {"View Details", "Activeate User"};
                int ans = JOptionPane.showOptionDialog(this, "Do you want to view or activate this user", "Activate/View", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, null);
                if (ans == JOptionPane.YES_OPTION) {
                    setData(nic.getText());
                    activateuser.setText("Activate User");
                } else {
                    activatePassword();
                }

            } catch (Exception e) {

            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_activateuserActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed

        String qry = "SELECT * FROM employee where nic='" + nic.getText() + "' OR nic = '" + Validation.convertNIC(nic.getText()) + "' AND nic <> 0";

        changeNIC(nic.getText(), qry);
        change.setVisible(false);


    }//GEN-LAST:event_changeActionPerformed

    private void firstnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyReleased
        enableUpdate();
    }//GEN-LAST:event_firstnameKeyReleased

    private void lastnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyReleased
        enableUpdate();
    }//GEN-LAST:event_lastnameKeyReleased

    private void address_streetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_streetKeyReleased

        enableUpdate();
    }//GEN-LAST:event_address_streetKeyReleased

    private void address_cityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_address_cityKeyReleased

        enableUpdate();
    }//GEN-LAST:event_address_cityKeyReleased

    private void firstnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameKeyTyped

    private void nicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nicFocusGained

    }//GEN-LAST:event_nicFocusGained

    private void captureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureActionPerformed
        new PhotoCapture().setVisible(true);

    }//GEN-LAST:event_captureActionPerformed
    public void reset() {
        nic.setText(null);
        firstname.setText(null);
        lastname.setText(null);
        mobile.setText(null);
        jDateChooser1.setDate(null);
        emp_type.setSelectedIndex(0);
        img.setIcon(null);
        male.setSelected(true);
        address_city.setText("City");
        address_no.setText("NO.");
        address_street.setText("Street");
        if (activateuser.getText().equalsIgnoreCase("Activate User")) {
            activateuser.setText("Activate/View User");
        }
        adddata.setText("Add/Update");
        jTable1.clearSelection();
        nic.grabFocus();
        img.setText("Click To Add");
        capture.setEnabled(false);
        img.setEnabled(false);

        b = false;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ShowDate;
    private javax.swing.JButton activateuser;
    private javax.swing.JButton adddata;
    private javax.swing.JTextField address_city;
    private javax.swing.JTextField address_no;
    private javax.swing.JTextField address_street;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton capture;
    private javax.swing.JButton change;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> emp_type;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField firstname;
    public javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastname;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mobile;
    public javax.swing.JTextField nic;
    public javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables

    public void genarateCode() {
        String qry = "SELECT type FROM employee_type WHERE id <> 0";
        emp_type.removeAllItems();
        try {
            ResultSet rs = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            while (rs.next()) {
                emp_type.addItem(rs.getString("type"));
            }
        } catch (Exception e) {
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void loaddate() {
        if (!(jDateChooser1.getDate() == null)) {

            ShowDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate()));
        }
    }

    private boolean validateInputs() {
        setParameaters();
        Exception ex = new Exception();
        boolean validation = true;
        JTextField tx = nic;
        JRadioButton radio = male;
        String ObjectType = "javax.swing.JTextField";

        try {
            //NIC
            //------------------------------------------------------------------------------

            if (!(Validation.validateNic(nic.getText()))) {
                System.out.println("sss");
                System.out.println(NIC);
                JOptionPane.showMessageDialog(this, "Incorrect NIC", "Error", JOptionPane.ERROR_MESSAGE);
                tx = nic;
                throw ex;

            }
            //----------------------------------------------------------------------------------------

            // Validate First Name 
            //---------------------------------------------------------------------------------
            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "First name can not be empty", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                validation = false;
                tx = firstname;
                throw ex;
            }
            //----------------------------------------------------------------------------------
            // Validate Last Name
            //----------------------------------------------------------------------------------
            if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Last name can not be empty", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                validation = false;
                tx = lastname;
                throw ex;
            }
            //------------------------------------------------------------------------------------
            // Validate Gender
            if (!(Validation.validateGenderFromNic(nic.getText(), gender))) {
                JOptionPane.showMessageDialog(this, "Your gender does not match with your NIC we will automaticaly set correct gender for you", "Data Missmatch", JOptionPane.INFORMATION_MESSAGE);
                validation = false;
                if (male.isSelected()) {
                    radio = female;
                }
                ObjectType = "javax.swing.JRadioButton";
                throw ex;
            }
            //-------------------------------------------------------------------------------------
            // Validate Mobile
            //-------------------------------------------------------------------------------------
            if (mob.isEmpty()) {
                JOptionPane.showMessageDialog(this, "mobile can not be empty", "Empty Field Error", JOptionPane.ERROR_MESSAGE);
                validation = false;
                tx = mobile;
                throw ex;
            }
            //--------------------------------------------------------------------------------------
            //Validate DOB 

            try {
                DOB = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
                if (!(Validation.validateDobFromNic(nic.getText(), jDateChooser1.getDate()))) {
                    JOptionPane.showMessageDialog(this, "Your DOB does not matchur DOB  with your NIC we will automaticaly set correct DOB for you", "Data Mismatch", JOptionPane.INFORMATION_MESSAGE);
                    ObjectType = "com.toedter.calendar.JDateChooser";
                    validation = false;
                    throw ex;
                }
            } catch (NullPointerException e) {

                JOptionPane.showMessageDialog(this, "Date can not be empty we will automaticaly set correct DOB for you", "Invalid date", JOptionPane.INFORMATION_MESSAGE);
                ObjectType = "com.toedter.calendar.JDateChooser";
                validation = false;
                throw ex;
            }
            //--------------------------------------------------------------------------------------
            //Validate Address 
            if (add_no.isEmpty() && add_line1.isEmpty() && add_line2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Address is invalid", "Field Error", JOptionPane.ERROR_MESSAGE);
                if (add_no.isEmpty()) {
                    tx = address_no;
                    throw ex;
                } else if (add_line1.isEmpty()) {
                    tx = address_street;
                    throw ex;
                } else {
                    tx = address_city;
                    throw ex;

                }
            }
            //---------------------------------------------------------------------------------------
            //Image Validation 
            if (ImageOfUse == null) {
                JOptionPane.showMessageDialog(this, "Sorry we cant find the image please insert the image of your nic", "Image not found", JOptionPane.ERROR_MESSAGE);
                ObjectType = "javax.swing.JLabel";
                validation = false;
                throw ex;

            }
            //-------------------------------------------------------------------------------------------

            //THIS IS THE CATCH PART 
        } catch (Exception e) {
            if (ObjectType.equals("javax.swing.JTextField")) {
                tx.grabFocus();
            } else if (ObjectType.equals("javax.swing.JRadioButton")) {
                radio.setSelected(true);
                mobile.grabFocus();
            } else if (ObjectType.equals("com.toedter.calendar.JDateChooser")) {
                try {
                    String RealDOBString = Validation.getDOBFromNIC(nic.getText());
                    Date RealDate = new SimpleDateFormat("yyyy-MM-dd").parse(RealDOBString);
                    jDateChooser1.setDate(RealDate);

                } catch (ParseException ex1) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } else if (ObjectType.equals("javax.swing.JLabel")) {
                imageSet();
            }
        }

        return validation;
    }

    private void setParameaters() {

        ImageOfUse = img.getIcon();
        employeeId = emp_type.getSelectedItem().toString();
        if (male.isSelected()) {
            gender = male.getText();
        } else {
            gender = female.getText();
        }
        if (address_no.getText().equals("NO.")) {
            add_no = null;
        } else {
            add_no = address_no.getText();
        }
        if (address_street.getText().equals("Street")) {
            add_line1 = null;
        } else {
            add_line1 = address_street.getText();
        }
        if (address_city.getText().equals("City")) {
            add_line2 = null;
        } else {
            add_line2 = address_city.getText();
        }
        fname = firstname.getText();
        lname = lastname.getText();

        mob = mobile.getText();
        ImageOfUse = img.getIcon();
        address = add_no + "," + add_line1 + "," + add_line2;
    }

    void checkStatus() {

        String qry = "SELECT * FROM employee where nic='" + NICOfEmployee + "' OR nic = '" + Validation.convertNIC(NICOfEmployee) + "'  AND nic <> 0 AND status = 1";

        try {

            ResultSet rs = DB.search(qry);

            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());

            if (rs.next()) {
                ButtonType = "UPDATE";
                adddata.setText("Update");
                delete.setEnabled(true);
                // setDataWithOutNic(nic.getText());

                if (nic.getText().length() == 12 && Validation.convertNIC(nic.getText()).equals(rs.getString("nic"))) {
                    int ans = JOptionPane.showConfirmDialog(this, "Seems Like You has bean upgradet to the ne NIC type \n So you Want to update our system NIC to your new", "Update NIC", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        changeNIC(nic.getText(), qry);
                    } else {
                        change.setVisible(true);
                    }

                }

            } else {
                ButtonType = "ADD";
            }
            qry = "SELECT status FROM employee where nic='" + nic.getText() + "'  OR nic = '" + Validation.convertNIC(nic.getText()) + "' ";
            rs = DB.search(qry);
            if (rs.next()) {
                if (rs.getInt("status") == 0) {
                    activateuser.setEnabled(true);
                    adddata.setEnabled(false);
                    delete.setEnabled(false);
                    ButtonType = "DELETE";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveImage() {
        try {
            File f1 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img\\tmp");
            File f2 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img\\" + nic.getText());
            if (f2.exists()) {
                f2.delete();
            }
            f1.renameTo(f2);
            path = f2.getAbsolutePath();
            Files.copy(f2.toPath(), new File(Settings.getObject().backupPath + "\\img\\" + nic.getText()).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertIntoDataBase() {
        String qry = "this is not a sql error";
        try {

            String gen_id;
            qry = "SELECT id FROM gender WHERE type ='" + gender + "'";
            ResultSet gender_id = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            if (gender_id.next()) {
                gen_id = gender_id.getString(1);
            } else {
                gen_id = "1";
            }
            String emp_type_id;
            qry = "SELECT id FROM employee_type WHERE type ='" + emp_type.getSelectedItem().toString() + "'";
            ResultSet emp_id = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            if (emp_id.next()) {

                emp_type_id = emp_id.getString("id");
            } else {
                emp_type_id = "1";
            }

            Date d = new Date();
            String reg_date = new SimpleDateFormat("yyyy-MM-dd").format(d);

            qry = "INSERT INTO employee(nic,lname,fname,dob,mobile,photo,employee_type_id,gender_id,date,address,status) VALUES('" + nic.getText() + "','" + lname + "','" + fname + "','" + DOB + "','" + mob + "','" + (System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img\\" + NICOfEmployee).replace("\\", "\\\\") + "','" + emp_type_id + "','" + gen_id + "','" + reg_date + "','" + address + "',1)";
            DB.iud(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());

        } catch (Exception e) {
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                DB.getConnection().rollback(sp);
            } catch (Exception ex) {

            }

        }
    }

    public void updateDatabase() {

        String qry = "This is not a sql error";
        try {
            qry = "SELECT * FROM employee_type WHERE type='" + emp_type.getSelectedItem().toString() + "'";
            ResultSet get_emp_id = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            if (get_emp_id.next()) {

                String id = get_emp_id.getString("id");

                qry = "UPDATE employee set lname='" + lname + "',fname = '" + fname + "',mobile='" + mob + "',employee_type_id='" + id + "',address='" + address + "' WHERE nic = '" + NICOfEmployee + "' OR nic ='" + Validation.convertNIC(NICOfEmployee) + "' ";
                DB.iud(qry);
                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());

                adddata.setEnabled(false);

            }
        } catch (Exception e) {
            e.printStackTrace();
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void deleteEmployee() {
        String qry = "UPDATE employee set status=0  WHERE nic = '" + nic.getText() + "' ";
        try {
            DB.iud(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());

        } catch (Exception e) {

            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void dataSorter() {

        TableRowSorter<TableModel> soter = new TableRowSorter<TableModel>(((DefaultTableModel) jTable1.getModel()));
        soter.setRowFilter(RowFilter.regexFilter("(?i)" + search.getText()));
        jTable1.setRowSorter(soter);
    }

    private void ActvateUser() {
        String qry = "UPDATE employee SET status = 1 WHERE nic='" + NICOfEmployee + "' or nic ='" + Validation.convertNIC(NICOfEmployee) + "'";
        try {
            DB.iud(qry);
            JOptionPane.showMessageDialog(this, "Employee activate successfull", "Activated", JOptionPane.INFORMATION_MESSAGE);
            WriteToSql.writeToFileSearch(qry, "Successfull", null, this.getClass().getName());
            reset();
        } catch (Exception e) {
            WriteToSql.writeToFileSearch(qry, "Successfull", null, this.getClass().getName());
        }
    }

    private void activatePassword() {
        JPasswordField pf = new JPasswordField();
        int okcan = JOptionPane.showConfirmDialog(this, pf, "Enter Administrator Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (okcan == JOptionPane.OK_OPTION) {
            String qry = "this is not a sql error";
            try {
                String pw = Cryption.encript(pf.getText());
                qry = "SELECT username FROM user WHERE user_type_id=1 or user_type_id=0  AND password='" + pw + "' ";
                ResultSet rs = DB.search(qry);
                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
                if (rs.next()) {
                    ActvateUser();

                    loadDataTotable();
                    reset();

                } else {
                    JOptionPane.showMessageDialog(this, "Password you enterd is invalid or not an administrator", "invalid password", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {

            }
        }

    }

    private void upgradeNIC(String text) {
        String qry = "this is not a sql error";
        try {

            qry = "UPDATE user SET employee_nic='" + text + "' WHERE employee_nic ='" + Validation.convertNIC(text) + "'";
            DB.iud(qry);
            WriteToSql.writeToFileSearch(qry, "Successfull", null, this.getClass().getName());
            qry = "UPDATE attendence SET employee_nic='" + text + "' WHERE employee_nic ='" + Validation.convertNIC(text) + "'";
            DB.iud(qry);
            WriteToSql.writeToFileSearch(qry, "Successfull", null, this.getClass().getName());
            qry = "UPDATE employee SET nic='" + text + "' WHERE nic ='" + Validation.convertNIC(text) + "'";
            DB.iud(qry);
            WriteToSql.writeToFileSearch(qry, "Successfull", null, this.getClass().getName());

        } catch (Exception e) {
            e.printStackTrace();
            WriteToSql.writeToFileSearch(qry, "Successfull", e.toString(), this.getClass().getName());
        }
    }

    public void setDataWithOutNic(String NIC) {

        String qry = "This is not a sql error";
        try {

            qry = "SELECT * FROM employee WHERE nic = '" + NIC + "' OR nic = '" + Validation.convertNIC(NIC) + "' AND nic <> 0";
            ResultSet rs = DB.search(qry);
            WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
            if (rs.next()) {

                firstname.setText(rs.getString("fname"));
                lastname.setText(rs.getString("lname"));
                mobile.setText(rs.getString("mobile"));

                Date day = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("dob"));

                jDateChooser1.setDate(day);

                if (rs.getString("gender_id").equals("2")) {

                    female.setSelected(true);

                } else {
                    male.setSelected(true);
                }
                qry = "SELECT * FROM employee_type WHERE id = '" + rs.getString("employee_type_id") + "'";

                ResultSet type = DB.search(qry);
                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());
                if (type.next()) {
                    emp_type.setSelectedItem(type.getString("type"));
                }

                String full_address = rs.getString("address");
                String[] s = full_address.split(",");
                String no = s[0];
                String ln1 = s[1];
                String ln2 = s[2];

                address_no.setText(no);
                address_street.setText(ln1);
                address_city.setText(ln2);

                System.gc();

                f = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img\\" + nic.getText());
                image = ImageIO.read(f);
                imgset = new ImageIcon(image);
                img.setText(null);
                img.setIcon(imgset);

                System.gc();
            }

        } catch (IOException i) {
            JOptionPane.showMessageDialog(this, "We Are Sorry! We can not find the image that you seek. Please insert the image again and update", "File not found", JOptionPane.ERROR_MESSAGE);
            imageSet();

        } catch (Exception e) {
            try {

                WriteToSql.writeToFileSearch(qry, "unsuccessful", e.toString(), this.getClass().getName());
            } catch (Exception ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void resetWithoutNIC() {
        b = false;
        firstname.setText(null);
        lastname.setText(null);
        mobile.setText(null);
        jDateChooser1.setDate(null);
        emp_type.setSelectedIndex(0);

        img.setIcon(null);

        male.setSelected(true);
        address_city.setText("City");
        address_no.setText("NO.");
        address_street.setText("Street");
        if (activateuser.getText().equalsIgnoreCase("Activate User")) {
            activateuser.setText("Activate/View User");
        }
        adddata.setText("Add/Update");
        img.setText("Click To Add");
        capture.setEnabled(false);
        img.setEnabled(false);

        nic.grabFocus();
    }

    private void changeNIC(String nic, String sql) {
        String qry = "this is not a sql error";
        try {
            ResultSet rs = DB.search(sql);
            if (rs.next()) {
                String oldNic = rs.getString("nic");
                String firstName = rs.getString("fname");
                String lasetName = rs.getString("lname");
                String dateOfBirth = rs.getString("dob");
                String mobileNo = rs.getString("mobile");
                int ans = JOptionPane.showConfirmDialog(this, "Add new NIC image", "image", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    updateNICImage(nic);
                }

                new File(rs.getString("photo")).delete();
                String employee_type = rs.getString("employee_type_id");
                String gender_id = rs.getString("gender_id");
                String dateOfEmployee = rs.getString("date");
                String emailOfEmployee;
                emailOfEmployee = rs.getString("email");
                String addressOfEmployee = rs.getString("address");

                qry = "INSERT INTO employee(nic,lname,fname,dob,mobile,photo,employee_type_id,gender_id,date,email,address,status) VALUES('" + nic + "','" + firstName + "','" + lasetName + "','" + dateOfBirth + "','" + mobileNo + "','" + (System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\img\\" + nic).replace("\\", "\\\\") + "','" + employee_type + "','" + gender_id + "','" + dateOfEmployee + "','" + emailOfEmployee + "','" + addressOfEmployee + "',1)";
                DB.iud(qry);
                WriteToSql.writeToFileSearch(qry, "Successful", null, this.getClass().getName());

                DB.iud("UPDATE attendence SET employee_nic = '" + nic + "' WHERE employee_nic = '" + oldNic + "'");
                DB.iud("UPDATE user SET employee_nic='" + nic + "' WHERE employee_nic='" + oldNic + "'");
                DB.iud("UPDATE salary SET employee_nic='" + nic + "' WHERE employee_nic='" + oldNic + "'");
                DB.iud("UPDATE loan SET nic='" + nic + "' WHERE nic='" + oldNic + "'");
                DB.iud("DELETE FROM employee WHERE nic='" + oldNic + "'");

                JOptionPane.showMessageDialog(this, "Successfully Updated", "Successfull", JOptionPane.INFORMATION_MESSAGE);
                loadDataTotable();
            }
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
    }

    private void updateNICImage(String NIC) {
        try {
            imageSet();
            saveImage();

        } catch (Exception e) {
        }

    }

    private void enableUpdate() {

        if (NICOfEmployee.equals(nic.getText())) {
            adddata.setEnabled(true);

        }

    }

}
