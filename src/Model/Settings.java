package Model;

import GUI.Home;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Settings implements Serializable {

    public int lx;
    public int ly;
    public int h;
    public int w;
    public int windowState;
    public String theme;
    public boolean firstrun = true;

    public String host;
    public String user;
    public String pass;
    public String port;

    public String mySqlPath;
    public String mySqlDumpPath;
    public String backupPath;

    private static transient Settings s;

    private Settings() {
    }

    public static Settings getObject() {
        if (s == null) {
            s = new Settings();
        }
        return s;
    }

    public static void loadSettings() {
        File f = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Settings.cfg");
        try {
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                s = (Settings) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void loadSettingsFromBackup(File f) {
        try {
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                s = (Settings) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveSettings() {
        if (getObject().firstrun) {
            if (Home.o == null) {
                Settings.getObject().lx = (Toolkit.getDefaultToolkit().getScreenSize().width - 1300) / 2;
                Settings.getObject().ly = (Toolkit.getDefaultToolkit().getScreenSize().height - 752) / 2;
            }
            getObject().firstrun = false;
        }
        try {
            File f = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service");
            if (!f.exists()) {
                f.mkdir();
            }
            f = new File(f, "Settings.cfg");

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(getObject());
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
