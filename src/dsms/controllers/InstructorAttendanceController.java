/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.InstructorAttendance;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class InstructorAttendanceController {

    public static int addInstructorAttendance(ArrayList<InstructorAttendance> instructorAttendenceSet) throws ClassNotFoundException {
        int returnValue = 0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            conn.setAutoCommit(false);
            for (InstructorAttendance instructorAttendance : instructorAttendenceSet) {
                int res = 0;
                String sql = "Insert into  InstructorAttendance VALUES( '" + instructorAttendance.getInstructorId() + "','" + instructorAttendance.getDate() + "','" + instructorAttendance.getIntime() + "','" + instructorAttendance.getOuttime() + "')";
                res = DBHandler.setData(conn, sql);
                if (res > 0) {
                    returnValue = 1;
                } else {
                    conn.commit();
                    returnValue = 0;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InstructorAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnValue;
    }
}
