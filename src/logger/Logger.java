/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import Cryptography.Cryption;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pasindu Kalana
 */
public class Logger {

    /**
     * @param args the command line arguments
     */
    private static String username;
    private static String date;
    private static String time;
    private static String type;
    private static String status;
    private static String attempt;
    
    public static void writeLogger(String uname, String usertype,String logstatus,int att){
        Date d = new Date();
        username = uname;
        username = Cryption.encript(username);
        time = new SimpleDateFormat("hh:mm:ss a").format(d);
        time = Cryption.encript(time);
        date = new SimpleDateFormat("yyyy-MM-dd").format(d);
        date = Cryption.encript(date);
        type = usertype;
        type = Cryption.encript(type);
        status = logstatus;
        status = Cryption.encript(status);
        attempt = String.valueOf(att);
        attempt = Cryption.encript(attempt);
        writeToFile();
                
        
    }
    private static void writeToFile(){
         try {
            File folder = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service");
            File folder2 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Compleate Log");
            File file = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Compleate Log\\user.log");
            if (!(folder.exists())) {
                folder.mkdir();
            }
            if (!(folder2.exists())) {
                folder2.mkdir();
            }

            if (!(file.exists())) {
                file.createNewFile();

            }
            file.setWritable(true);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(username + "," +date+","+ time + "," + type + "," + status+","+attempt+"\n");
            file.setWritable(false);
            br.close();
            fr.close();
        } catch (Exception e) {
           
        }
    }
    
   
}

