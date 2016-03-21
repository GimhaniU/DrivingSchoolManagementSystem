/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.VehicleClassSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class VehicleClassController {

    public static VehicleClassSet searchVehicleClassSetByName(String classType) throws ClassNotFoundException, SQLException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Select * from VehicleClassSet where classType='" + classType + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            VehicleClassSet vehicleClassSet = new VehicleClassSet(rst.getString("classId"), rst.getString("classType"), rst.getString("description"), rst.getDouble("stampTax"), rst.getDouble("trainingFee"), rst.getDouble("examFee"), rst.getDouble("trialFee"));
            return vehicleClassSet;
        } else {
            return null;
        }
    }

    public static VehicleClassSet searchVehicleClassSet(String classId) throws ClassNotFoundException, SQLException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Select * from VehicleClassSet where classId='" + classId + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            VehicleClassSet vehicleClassSet = new VehicleClassSet(rst.getString("classId"), rst.getString("classType"), rst.getString("description"), rst.getDouble("stampTax"), rst.getDouble("trainingFee"), rst.getDouble("examFee"), rst.getDouble("trialFee"));
            return vehicleClassSet;
        } else {
            return null;
        }
    }

    public static int updateVehicleClassSets(ArrayList<VehicleClassSet> classSets) throws ClassNotFoundException, SQLException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        conn.setAutoCommit(false);
        int result = 0, returnVal = 0;
        for (VehicleClassSet vcs : classSets) {
            String sql = "Update VehicleClassSet set classtype='" + vcs.getClassType() + "',description='" + vcs.getDescription() + "',stampTax='" + vcs.getStampTax() + "',trainingFee='" + vcs.getTrainingFee() + "',examFee='" + vcs.getExamFee() + "',trialFee='" + vcs.getTrialFee() + "' where classId='" + vcs.getClassId() + "'";
            int res = DBHandler.setData(conn, sql);
            if (res > 0) {
                result++;
            } else {
                conn.rollback();
                returnVal = 0;
            }
        }
        if (result == classSets.size()) {
            conn.commit();
        }
        conn.setAutoCommit(true);
        return returnVal;
    }

    public static int addVehicleClass(VehicleClassSet vcs) throws ClassNotFoundException, SQLException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Insert into  VehicleClassSet Values('" + vcs.getClassId() + "','" + vcs.getClassType() + "','" + vcs.getDescription() + "','" + vcs.getStampTax() + "','" + vcs.getTrainingFee() + "','" + vcs.getExamFee() + "','" + vcs.getTrialFee() + "' )";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static ArrayList<VehicleClassSet> getAllVehicleClasses() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        ResultSet rst = DBHandler.getData(conn, "Select * From VehicleClassSet");
        ArrayList<VehicleClassSet> classList = new ArrayList<>();
        while (rst.next()) {
            VehicleClassSet vehicleClassSet = new VehicleClassSet(rst.getString("classId"), rst.getString("classType"), rst.getString("description"), rst.getDouble("stampTax"), rst.getDouble("trainingFee"), rst.getDouble("examFee"), rst.getDouble("trialFee"));
            classList.add(vehicleClassSet);

        }
        return classList;
    }
}
