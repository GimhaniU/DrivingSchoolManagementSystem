/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.common_classes.CalculationMaker;
import dsms.models.Registration;
import dsms.models.TrialDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.apache.commons.collections.FastHashMap;

/**
 *
 * @author User
 */
public class TrialDetailController {

    public static int addTrialDetail(TrialDetail trialDetail) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Insert into TrialDetail Values('" + trialDetail.getRegistrationId() + "'," + trialDetail.getAttempt() + ",'" + trialDetail.getDate() + "',0)";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int addTrialDetailResult(TrialDetail trialDetail) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Update  TrialDetail set result=" + trialDetail.getResult() + " where registrationId='" + trialDetail.getRegistrationId() + "' and attempt=" + trialDetail.getAttempt() + ";";
        int res = DBHandler.setData(conn, sql);
        if (res > 0) {
            System.out.println("updat");
        } else {
            System.out.println("not updat");
        }
        return res;
    }

    public static TrialDetail searchLastTrialResult(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from TrialDetail where registrationId='" + registrationId + "' and result!=0 order by attempt desc limit 1 ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            TrialDetail trialDetail = new TrialDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            return trialDetail;
        } else {
            return null;
        }
    }

    public static TrialDetail searchLastTrialDetail(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from TrialDetail where registrationId='" + registrationId + "' order by attempt desc limit 1 ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            TrialDetail trialDetail = new TrialDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            return trialDetail;
        } else {
            return null;
        }
    }

    public static ArrayList<TrialDetail> searchTrialResultsOfAStudent(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from TrialDetail where registrationId='" + registrationId + "'  order by attempt";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<TrialDetail> trialResults = new ArrayList();
        while (rst.next()) {
            TrialDetail trialDetail = new TrialDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            trialResults.add(trialDetail);
        }
        return trialResults;
    }

    public static ArrayList<TrialDetail> searchResultEnterSet() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from TrialDetail where result=0";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<TrialDetail> trialResults = new ArrayList();
        while (rst.next()) {
            TrialDetail trialDetail = new TrialDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            trialResults.add(trialDetail);
        }
        return trialResults;
    }

    public static ArrayList<Registration> searchStudentsForTrial() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "Select * from TrialDetail where result=-1 ";
        ResultSet rst1 = DBHandler.getData(conn, sql1);
        ArrayList<TrialDetail> trialResults = new ArrayList();
        ArrayList<Registration> registrations = new ArrayList<>();
        while (rst1.next()) {
            TrialDetail trialDetail = new TrialDetail(rst1.getString("registrationId"), rst1.getInt("attempt"), rst1.getString("date"), rst1.getInt("result"));
            boolean result = PaymentController.isTriainingFeeDone(trialDetail);
            if (result) {
                trialResults.add(trialDetail);
            }

        }
        for (TrialDetail trialDetail : trialResults) {
            String sql2 = "Select * from TrialDetail where result=-1 and registrationId='" + trialDetail.getRegistrationId() + "' and attempt=(select max(attempt) from trialdetail where registrationId='" + trialDetail.getRegistrationId() + "')";
            ResultSet rst2 = DBHandler.getData(conn, sql2);

            if (rst2.next()) {
                boolean res = PaymentController.isTrialFeeDone(trialDetail);

                if (res) {
                    Registration reg = RegistrationController.searchRegistration(trialDetail.getRegistrationId());
                    registrations.add(reg);
                } else {
                }
            } else {
            }
        }
//        String sql4 = "Select * from Registration r,Student s where s.studentId=r.studentId and r.registrationId not in (select registrationId from trialdetail) ";
//        ResultSet rst4 = DBHandler.getData(conn, sql4);
//        while (rst4.next()) {
//            Student student = new Student(rst4.getString("studentId"), rst4.getString("nameWithInitials"), rst4.getString("surName"), rst4.getString("address"), rst4.getString("nic"), rst4.getString("studentTel"), rst4.getString("gender"));
//            students.add(student);
//        }
        return registrations;
    }

    public static ArrayList<TrialDetail> searchTrialPendingList(String date) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "Select * from TrialDetail where date='" + date + "' and attempt=1";
        ResultSet rst1 = DBHandler.getData(conn, sql1);
        ArrayList<TrialDetail> trialResults = new ArrayList();
        while (rst1.next()) {
            TrialDetail trialDetail = new TrialDetail(rst1.getString("registrationId"), rst1.getInt("attempt"), rst1.getString("date"), rst1.getInt("result"));
            trialResults.add(trialDetail);
        }
        ArrayList<TrialDetail> trialPending = new ArrayList();
        for (TrialDetail detail : trialResults) {
            double paidTotal = CalculationMaker.paymentsAdder(detail.getRegistrationId());
            Registration registration = RegistrationController.searchRegistration(detail.getRegistrationId());
            if ((registration.getTotalFee() - registration.getDiscount() - paidTotal) > 0) {
                trialPending.add(detail);
            }
        }
        return trialPending;
    }
}
