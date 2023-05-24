package Model;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableAlign {
    public static void alignCenter(JTable t) {
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(0);
        for (int i = 0; i < t.getColumnCount(); i++) {
            t.getColumnModel().getColumn(i).setCellRenderer(cr);
        }
    }
    
    public static void alignCenter(JTable t, int[] cols) {
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(0);
        for (int i = 0; i < cols.length; i++) {
            t.getColumnModel().getColumn(cols[i]).setCellRenderer(cr);
        }
    }
    
    public static void alignRight(JTable t, int[] cols) {
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(4);
        for (int i = 0; i < cols.length; i++) {
            t.getColumnModel().getColumn(cols[i]).setCellRenderer(cr);
        }
    }
}