/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Pasindu Kalana
 */
public class Privilege implements Serializable{
    public boolean  coustomerval;
    public boolean  stockval;
    public boolean  supplierval;
    public boolean  employeeval;
    public boolean  employeeManagerval;
    public boolean  reportval;
    public boolean  attendanceval;
    public boolean  employeePayrollval;
    public boolean  loginHistoryval;
    public boolean  settingsval;
    public boolean  manageAccountval;
    
    private  Privilege(){
        
    }
    public static Privilege o ;
    public static Privilege getObject(){
        if(o==null){
            o=new Privilege();
        }
        return o;
    }
    public void loadObject(String name){
         File f = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Privilege\\"+name+".cfg");
        try {
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                o = (Privilege) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SaveObject(String name){
        try {
            File f = new File(System.getenv("PROGRAMDATA") + "\\Ishara Auto Service\\Privilege");
            if (!f.exists()) {
                f.mkdir();
            }
            f = new File(f,name+".cfg");

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(getObject());
            oos.close();
            File f1 = new File(Settings.getObject().backupPath + "\\Privilege");
            if (!f1.exists()) {
                f1.mkdir();
            }
            Files.copy(f.toPath(), new File(f1, f.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
