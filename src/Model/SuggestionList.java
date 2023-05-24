package Model;

import DB.DB;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import sqllogger.SQLLog;

public class SuggestionList {
    
    static int i = 0;
    static boolean key = true;
    
    static  SQLLog writeToSql = new SQLLog();
    public static synchronized void showList(JTextField txtField, JComboBox suggestBox, String sqlQuery, String columnName, KeyEvent evt, String classTag) {
        key = true;
        if (txtField.getText().isEmpty()) {
            suggestBox.hidePopup();
        } else {
            String s = txtField.getText().substring(0, txtField.getSelectionStart());
            if (evt.getKeyCode() == 38 || evt.getKeyCode() == 40) {
                txtField.setText(s);
            }
            try {
                if (Character.isDefined(evt.getKeyChar()) && evt.getKeyCode() != 10) {
                    ResultSet r = DB.search(sqlQuery);
                    writeToSql.writeToFileSearch(sqlQuery, "Successfull", null, classTag);
                    Vector v = new Vector();
                    while (r.next()) {
                        v.add(r.getString(columnName));
                    }
                    DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
                    suggestBox.setModel(dcm);
                    if (!(suggestBox.getItemCount() == 0)) {
                        suggestBox.showPopup();
                        if (evt.getKeyCode() == 8 || evt.getKeyCode() == 127) {
                            txtField.setText(s);
                        } else {
                            int x = txtField.getText().length();
                            txtField.setText(suggestBox.getSelectedItem().toString());
                            txtField.setSelectionStart(x);
                        }
                    }
                }
            } catch (Exception e) {
                writeToSql.writeToFileSearch(sqlQuery, "Successfull", e.toString(), classTag);
                
                e.printStackTrace();
            }

            if (suggestBox.isPopupVisible()) {
                int count = suggestBox.getItemCount();
                switch (evt.getKeyCode()) {
                    case 38:
                        txtField.setText(s);
                        i--;
                        if (i == -1) {
                            i = count - 1;
                        }
                        suggestBox.setSelectedIndex(i);
                        break;
                    case 40:
                        txtField.setText(s);
                        i++;
                        if (i == count) {
                            i = 0;
                        }
                        suggestBox.setSelectedIndex(i);
                        break;
                    case 10:
                        suggestBox.setSelectedIndex(i);
                        txtField.setText(suggestBox.getSelectedItem().toString());
                        suggestBox.hidePopup();
                        i = 0;
                        break;
                    default:
                        i = 0;
                        break;
                }
            }
        }
        key = false;
    }
    
    public static synchronized void setSelectedItem(JTextField txtField, JComboBox suggestBox) {
        if (key == false) {
            txtField.setText(suggestBox.getSelectedItem().toString());
        }
    }
}
