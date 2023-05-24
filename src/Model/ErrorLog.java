/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pasindu Kalana
 */
public class ErrorLog {

    public void writeToFileSearch(String Reason, String NameOfTheClass) {

        try {
            Date d = new Date();
            String DateOfError = new SimpleDateFormat("yyyy-MM-dd").format(d);
            String TimeOfError = new SimpleDateFormat("hh:mm:ss a").format(d);

            File folder = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service");
            File folder2 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\SQL Details");

            File file = new File(folder2, "Error.log");

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
            br.write("---------------------------------------------------------------------------------------------------------------------------------------\n");
            br.write(Reason + "\n");
            br.write(DateOfError + "\n");
            br.write(TimeOfError + "\n");
            br.write(NameOfTheClass + "\n");
            br.write("---------------------------------------------------------------------------------------------------------------------------------------\n");
            if (file.length() > 1000000L) {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(file));

                            List<String> temp = new ArrayList<String>();
                            String line;
                            while ((line = reader.readLine()) != null) {

                                temp.add(line);
                            }

                            for (int i = temp.size() - 1; i >= 500; i--) {
                                file.delete();
                                file.createNewFile();
                                br.write(temp.get(i));
                            }
                        } catch (Exception e) {
                        }

                    }

                };
                t.setPriority(Thread.NORM_PRIORITY);
                t.start();
            }
            file.setWritable(false);
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sorry!!, Could not write to Log Files.\n Please check your hard drive or contact RUU SOFT.");
        }
    }
}
