/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.Registration;
import dsms.models.StudentAttendance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StudentAttendanceController {

    public static int addStudentAttendance(StudentAttendance studentAttendance) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Insert into StudentAttendance Values('" + studentAttendance.getRegistrationId() + "','" + studentAttendance.getInstructorId() + "','" + studentAttendance.getDate() + "','" + studentAttendance.getTurn() + "')";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static boolean searchAttendance(StudentAttendance studentAttendance) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from StudentAttendance where date='" + studentAttendance.getDate() + "' and instructorId='" + studentAttendance.getInstructorId() + "'and registrationId='" + studentAttendance.getRegistrationId() + "' and turn='" + studentAttendance.getTurn() + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        boolean bool;
        StudentAttendance studentAttendance1 = null;
        if (rst.next()) {
            studentAttendance1 = new StudentAttendance(rst.getString("registrationId"), rst.getString("instructorId"), rst.getString("date"), rst.getString("turn"));
        }
        if (studentAttendance1 != null) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public static ArrayList<StudentAttendance> searchAttendanceOfDate(String date) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from StudentAttendance where date='" + date + "' order by turn ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<StudentAttendance> studentAttendances = new ArrayList<>();
        while (rst.next()) {
            StudentAttendance studentAttendance = new StudentAttendance(rst.getString("registrationId"), rst.getString("instructorId"), rst.getString("date"), rst.getString("turn"));
            studentAttendances.add(studentAttendance);
        }
        return studentAttendances;
    }

    public static int getAttendanceCount(Registration reg) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from StudentAttendance where registrationId='" + reg.getRegistrationId() + "'  ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<StudentAttendance> studentAttendances = new ArrayList<>();
        while (rst.next()) {
            StudentAttendance studentAttendance = new StudentAttendance(rst.getString("registrationId"), rst.getString("instructorId"), rst.getString("date"), rst.getString("turn"));
            studentAttendances.add(studentAttendance);
        }
        return studentAttendances.size();
    }
}
