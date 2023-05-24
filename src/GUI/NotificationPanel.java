package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class NotificationPanel extends javax.swing.JWindow {

    static AudioClip infoClip = Applet.newAudioClip(NotificationPanel.class.getResource("/Sounds/Info.wav"));
    static AudioClip warnClip = Applet.newAudioClip(NotificationPanel.class.getResource("/Sounds/Warn.wav"));
    static AudioClip errorClip = Applet.newAudioClip(NotificationPanel.class.getResource("/Sounds/Error.wav"));
    static AudioClip successClip = Applet.newAudioClip(NotificationPanel.class.getResource("/Sounds/Success.wav"));
    static boolean mouseover;
    boolean shown;
    Thread t;
    public final static String INFO = "Info";
    public final static String WARN = "Warn";
    public final static String SUCCESS = "Success";
    public final static String ERROR = "Error";

    private NotificationPanel() {
        initComponents();
    }

    public static synchronized void showNotification(String title, String msg, String msg2, String msgType) {
        NotificationPanel np = new NotificationPanel();
        np.setFocusableWindowState(false);
        np.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width, 40);
        np.t = new Thread() {
            @Override
            public synchronized void run() {
                try {
                    np.jLabel1.setIcon(new ImageIcon(ImageIO.read(NotificationPanel.class.getResource("/Images/" + msgType + ".png"))));
                    np.title.setText(title);
                    np.msg1.setText(msg);
                    np.msg2.setText(msg2);
                    np.setVisible(true);
                    switch (msgType) {
                        case "Info":
                            infoClip.play();
                            break;
                        case "Warn":
                            warnClip.play();
                            break;
                        case "Error":
                            errorClip.play();
                            break;
                        case "Success":
                            successClip.play();
                            break;
                    }
                    int w = Toolkit.getDefaultToolkit().getScreenSize().width;
                    int fw = np.getWidth();
                    for (int i = 0; i < fw + 40; i += 2) {
                        np.setLocation(w - i, 40);
                        Thread.sleep(1);
                    }
                    np.shown = true;
                    Thread.sleep(5000);
                    for (int i = fw + 40; i > 0; i --) {
                        np.setLocation(np.getLocation().x + 1, 40);
                        Thread.sleep(1);
                    }
                    np.dispose();
                } catch (Exception ex) {
                }
            }
        };
        np.t.setPriority(Thread.MAX_PRIORITY);
        np.t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        msg1 = new javax.swing.JLabel();
        msg2 = new javax.swing.JLabel();

        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(64, 64, 64));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(240, 240, 240));
        title.setText(" ");

        msg1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        msg1.setForeground(new java.awt.Color(240, 240, 240));
        msg1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        msg1.setText(" ");
        msg1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        msg2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        msg2.setForeground(new java.awt.Color(240, 240, 240));
        msg2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        msg2.setText(" ");
        msg2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(msg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(msg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg1)
                        .addGap(0, 0, 0)
                        .addComponent(msg2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (title.getText().equals("Minimum quota has been reached.")) {
            if (StockNotifications.o == null) {
                StockNotifications.getObject().loadTable();
            }
            StockNotifications.getObject().setVisible(true);
        }
        if (title.getText().equals("Obsolete Item.")) {
            Stock.getObject().setVisible(true);
        }
        new Thread() {
            @Override
            public synchronized void run() {
                int fw = getWidth();
                try {
                    for (int i = fw + 40; i > 0; i--) {
                        setLocation(getLocation().x + 1, 40);
                        Thread.sleep(1);
                    }
                    dispose();
                } catch (InterruptedException ex) {
                }
            }
        }.start();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        mouseover = true;
        if (shown) {
            t.interrupt();
        }
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        mouseover = false;
        t = new Thread() {
            @Override
            public synchronized void run() {
                int fw = getWidth();
                try {
                    Thread.sleep(2000);
                    shown = false;
                    for (int i = fw + 40; i > 0; i--) {
                        setLocation(getLocation().x + 1, 40);
                        Thread.sleep(1);
                    }
                    dispose();
                } catch (InterruptedException ex) {
                }
            }
        };
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }//GEN-LAST:event_jPanel1MouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msg1;
    private javax.swing.JLabel msg2;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
