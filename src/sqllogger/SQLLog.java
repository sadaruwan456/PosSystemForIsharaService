/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqllogger;

import Model.ErrorLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pasindu Kalana
 */
public class SQLLog {

    ErrorLog er = new ErrorLog();

    public void writeToFileSearch(String qry, String Status, String Reason, String NameOfTheClass) {

        try {
            Date d = new Date();
            String DateOfError = new SimpleDateFormat("yyyy-MM-dd").format(d);
            String TimeOfError = new SimpleDateFormat("hh:mm:ss a").format(d);
            File folder = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service");
            File folder2 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\SQL Details");
            File folder3;

            if (Status.equalsIgnoreCase("Successful")) {
                folder3 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\SQL Details\\SQL Non-Error");
            } else {
                folder3 = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\SQL Details\\SQL Error");
            }

            File file = new File(folder3, "SQL.log");

            if (!(folder.exists())) {
                folder.mkdir();
            }
            if (!(folder2.exists())) {
                folder2.mkdir();
            }
            if (!(folder3.exists())) {
                folder3.mkdir();
            }

            if (!(file.exists())) {
                file.createNewFile();

            }

            file.setWritable(true);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write("---------------------------------------------------------------------------------------------------------------------------------------\n");
            br.write(qry + "\n");
            br.write(Status + "\n");
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
            er.writeToFileSearch(e.toString(), this.getClass().getName());

        }
    }
}
