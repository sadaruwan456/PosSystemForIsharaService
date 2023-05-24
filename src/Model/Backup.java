package Model;
import Cryptography.Cryption;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Backup {

    static File f = new File(Settings.getObject().backupPath);
    static  File s = new File(f, "Settings.cfg");
    static String cmd = "\"" + Settings.getObject().mySqlDumpPath + "\" -u" + Cryption.decript(Settings.getObject().user) + " -p" + Cryption.decript(Settings.getObject().pass) + " --add-drop-database -B ishara_service -r\"" + (Settings.getObject().backupPath + "\\DBBackup.sql\"");
    
    public static Thread writeBackup() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    write();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        return t;
    }

    public static synchronized void write() throws IOException, InterruptedException {        
        if (f.exists()) {            
            Process runtimeProcess;
            runtimeProcess = Runtime.getRuntime().exec(cmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                Settings.getObject().firstrun = true;                
                FileOutputStream fos = new FileOutputStream(s);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Settings.getObject());
                oos.close();
            }
        }
    }
}
