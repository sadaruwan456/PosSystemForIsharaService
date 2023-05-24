/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import DB.DB;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pasindu Kalana
 */
public class atd {

    Date d = new Date();
    SimpleDateFormat sdf;

    public void loadAttendance() {

        sdf = new SimpleDateFormat("HH");
        int SetTime = 12;
        int GetTime = Integer.parseInt(sdf.format(d));
        try {
            String EmployeeCount;
            String AttendanceCount;
            String AbsentCount;

            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String TodayString = sdf.format(d);
            ResultSet rs;
            String qry;
            if (GetTime <= SetTime) {
                qry = "SELECT COUNT(employee_nic) AS morningCount FROM employee,attendence WHERE employee.nic = attendence.employee_nic AND employee.status = 1 And Morning =1 AND attendence.date = '" + TodayString + "'";
                rs = DB.search(qry);
                if (rs.next()) {

                    AttendanceCount = rs.getString("morningCount");
                } else {
                    AttendanceCount = "0";
                }
            } else {
                qry = "SELECT COUNT(employee_nic) AS eveningCount FROM employee,attendence WHERE employee.nic = attendence.employee_nic AND employee.status = 1 And Evening =1 AND attendence.date = '" + TodayString + "'";
                rs = DB.search(qry);
                if (rs.next()) {
                    AttendanceCount = rs.getString("eveningCount");
                } else {
                    AttendanceCount = "0";
                }
            }
            qry = "SELECT COUNT(nic) as nicCount FROM employee WHERE status =1 AND nic<>0";
            rs = DB.search(qry);
            if (rs.next()) {
                EmployeeCount = rs.getString("nicCount");
            } else {
                EmployeeCount = "0";
            }

            
            AbsentCount = String.valueOf(Integer.parseInt(EmployeeCount) - Integer.parseInt(AttendanceCount));
            GUI.Attendance.getObject().AttCount.setText(AttendanceCount);
            GUI.Attendance.getObject().EmpCount.setText(EmployeeCount);
            GUI.Attendance.getObject().AbCount.setText(AbsentCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}