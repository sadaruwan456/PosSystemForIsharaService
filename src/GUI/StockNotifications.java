package GUI;

import DB.DB;
import Model.FrameIcon;
import Model.Settings;
import Model.TableAlign;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lakshan
 */
public class StockNotifications extends javax.swing.JFrame {

    public static StockNotifications o;
    DefaultTableModel dtm;
    SimpleDateFormat DBSDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");

    private StockNotifications() {
        initComponents();
        FrameIcon.setIcon(this);
        if (!LogIn.type.equals("Admin")) {
            jButton1.setEnabled(false);
        }
        TableAlign.alignCenter(notiTable);
        dtm = (DefaultTableModel) notiTable.getModel();
    }

    void loadTable() {
        try {
            dtm.setRowCount(0);
            ResultSet r = DB.search("SELECT ns_date, brand_name, category_name, part_model, stock_id, min_quota, qty FROM notified_stock INNER JOIN stock ON notified_stock.stock_id = stock.id INNER JOIN part_model ON stock.part_model_id = part_model.id INNER JOIN part ON part_model.part_id = part.id INNER JOIN part_category ON part.part_category_id = part_category.id INNER JOIN part_brand ON part.part_brand_id = part_brand.id ORDER BY ns_date DESC");
            while (r.next()) {
                Vector v = new Vector();
                v.add(SDF.format(DBSDF.parse(r.getString("ns_date"))));
                if (r.getString("part_model").equals("N/A")) {
                    v.add(r.getString("brand_name") + " " + r.getString("category_name"));
                } else {
                    v.add(r.getString("brand_name") + " " + r.getString("category_name") + " [ " + r.getString("part_model") + " ]");
                }
                v.add(r.getString("stock_id"));
                v.add(r.getString("min_quota"));
                v.add(r.getString("qty"));
                dtm.addRow(v);
            }
            if (notiTable.getRowCount() == 0) {
                if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
                    Home.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_w.png"))));
                    MainHome.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/stockw.png"))));
                } else {
                    Home.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_b.png"))));
                    MainHome.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/stockb.png"))));
                }
            } else {
                if ("com.jtattoo.plaf.hifi.HiFiLookAndFeel".equals(Settings.getObject().theme)) {
                    Home.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_wred.png"))));
                    MainHome.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/stockwred.png"))));
                } else {
                    Home.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/Stock_bred.png"))));
                    MainHome.getObject().stockbtn.setIcon(new ImageIcon(ImageIO.read(Home.class.getResource("/Images/stockbred.png"))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StockNotifications getObject() {
        if (o == null) {
            o = new StockNotifications();
        }
        return o;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        notiTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Stock Notifications");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        notiTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date & Time", "Item", "Stock ID", "Minimum Quota", "Available Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(notiTable);
        if (notiTable.getColumnModel().getColumnCount() > 0) {
            notiTable.getColumnModel().getColumn(0).setMinWidth(140);
            notiTable.getColumnModel().getColumn(1).setMinWidth(160);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Change Minimum Quota Limits");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Stocks that need Refilling");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ChangeMinQuota(this, true).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Home.getObject().requestFocus();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable notiTable;
    // End of variables declaration//GEN-END:variables
}
