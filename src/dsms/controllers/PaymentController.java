/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.common_classes.CalculationMaker;
import dsms.models.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PaymentController {

    public static int addPayment(Payment payment) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Insert into Payment Values('" + payment.getPaymentId() + "','" + payment.getRegistrationId() + "','" + payment.getType() + "','" + payment.getDate() + "','" + payment.getAmount() + "','" + payment.getAttempt() + "')";
        int res = DBHandler.setData(conn, sql);

        return res;
    }

    public static ArrayList<Payment> searchPaymentsOfARegistration(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Payment where registrationId='" + registrationId + "' order by date desc";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Payment> paymentList = new ArrayList<>();

        while (rst.next()) {
            Payment payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
            paymentList.add(payment);

        }
        return paymentList;
    }

    public static ArrayList<String> searchPaymentDates() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select distinct date from Payment where date>'(year(curDate)-1)-month(curDate())-dayOfMonth(curDate())' order by date desc";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<String> dateSet = new ArrayList<>();

        while (rst.next()) {
            String date = rst.getString("date");
            dateSet.add(date);

        }
        return dateSet;
    }

    public static ArrayList<Payment> searchAllPaymentsOfAStudent(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        ArrayList<Payment> paymentList = new ArrayList<>();
        ArrayList<Registration> registrations = RegistrationController.searchAllRegistrations(studentId);
        for (Registration registration : registrations) {
            String sql = "Select * from Payment where registrationId='" + registration.getRegistrationId() + "' order by date desc";
            ResultSet rst = DBHandler.getData(conn, sql);
            while (rst.next()) {
                Payment payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
                paymentList.add(payment);
            }
        }
        return paymentList;
    }

    public static ArrayList<PaymentDetail> searchAllPaymentsOfADate(String date) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        ArrayList<PaymentDetail> paymentList = new ArrayList<>();

        String sql = "Select date,type,sum(amount) as paymentSum from Payment p,Registration r where p.registrationId=r.registrationId and date='" + date + "' group by type ";
        ResultSet rst = DBHandler.getData(conn, sql);
        while (rst.next()) {
            PaymentDetail paymentDetail = new PaymentDetail(rst.getString("date"), rst.getString("type"), rst.getInt("paymentSum"));
            paymentList.add(paymentDetail);
        }

        return paymentList;
    }

    public static ArrayList<PaymentDetail> searchAllPaymentsOfAMonth(String month) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        ArrayList<PaymentDetail> paymentList = new ArrayList<>();
        int monthIndex = CalculationMaker.selectMonthIndex(month);
        String sql = "Select month(date),type,sum(amount) as paymentSum from Payment p,Registration r where p.registrationId=r.registrationId and month(date)=" + monthIndex + "'group by type ";
        ResultSet rst = DBHandler.getData(conn, sql);
        while (rst.next()) {
            PaymentDetail paymentDetail = new PaymentDetail(rst.getInt("month(date)"), month, rst.getString("type"), rst.getInt("paymentSum"));
            paymentList.add(paymentDetail);
        }

        return paymentList;
    }

    public static ArrayList<Payment> searchAllTrainingFeePayments(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Payment where registrationId='" + registrationId + "' and type='Training Fee'  order by date desc";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Payment> paymentList = new ArrayList<>();
        while (rst.next()) {
            Payment payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
            paymentList.add(payment);
        }

        return paymentList;
    }

    public static ArrayList<Payment> searchExamFeePayments(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Payment where registrationId='" + registrationId + "' and type='Exam Fee later attempt' order by date desc ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Payment> paymentList = new ArrayList<>();
        while (rst.next()) {
            Payment payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
            paymentList.add(payment);
        }

        return paymentList;
    }

    public static boolean isExamFeeDone(ExamDetail examDetail) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        int attempt = 0;
        boolean returnVal;
        if (examDetail.getResult() == 0) {
            attempt = examDetail.getAttempt();
        } else if (examDetail.getResult() == -1) {
            attempt = examDetail.getAttempt() + 1;
        }
        String sql = "Select * from Payment where registrationId='" + examDetail.getRegistrationId() + "' and attempt='" + attempt + "' and type='Exam Fee later attempt' order by date desc ";
        ResultSet rst = DBHandler.getData(conn, sql);
        Payment payment = null;
        while (rst.next()) {
            payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
        }
        if (payment != null) {
            returnVal = true;
        } else {
            returnVal = false;
        }

        return returnVal;
    }

    public static boolean isTrialFeeDone(TrialDetail trialDetail) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        int attempt = 0;
        boolean returnVal;
        if (trialDetail.getResult() == 0) {
            attempt = trialDetail.getAttempt();
        } else if (trialDetail.getResult() == -1) {
            attempt = trialDetail.getAttempt() + 1;
        }
        String sql = "Select * from Payment where registrationId='" + trialDetail.getRegistrationId() + "' and attempt='" + attempt + "' and type='Trial Fee later attempt' order by date desc ";
        ResultSet rst = DBHandler.getData(conn, sql);
        Payment payment = null;
        while (rst.next()) {
            payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
        }
        if (payment != null) {
            returnVal = true;
        } else {
            returnVal = false;
        }

        return returnVal;
    }

    public static boolean isTriainingFeeDone(TrialDetail trialDetail) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        int attempt = 0;
        boolean returnVal;
        if (trialDetail.getResult() == 0) {
            attempt = trialDetail.getAttempt();
        } else if (trialDetail.getResult() == -1) {
            attempt = trialDetail.getAttempt() + 1;
        }
        Registration registration = RegistrationController.searchRegistration(trialDetail.getRegistrationId());
        double paidTotal = CalculationMaker.paymentsAdder(registration.getRegistrationId());

        if (registration.getTotalFee() - registration.getDiscount() - paidTotal > 0) {
            returnVal = false;
        } else {
            returnVal = true;
        }

        return returnVal;
    }

    public static ArrayList<Payment> searchTrialFeePayments(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Payment where registrationId='" + registrationId + "' and type='Trial Fee later attempt' order by date desc ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Payment> paymentList = new ArrayList<>();
        while (rst.next()) {
            Payment payment = new Payment(rst.getString("paymentId"), rst.getString("registrationId"), rst.getString("type"), rst.getString("date"), rst.getDouble("amount"), rst.getInt("attempt"));
        }
        return paymentList;
    }

    public static int deletePaymentSet(String registrationId) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Delete from Payment where registrationId='" + registrationId + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int addPaymentSet(ArrayList<Payment> paymentList) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        int res = 0;

        for (Payment payment : paymentList) {
            String sql = "Insert into Payment Values('" + payment.getPaymentId() + "','" + payment.getRegistrationId() + "','" + payment.getType() + "','" + payment.getDate() + "','" + payment.getAmount() + "','" + payment.getAttempt() + "')";
            res += DBHandler.setData(conn, sql);
        }
        return res;
    }

    public static int updatePaymentSet(ArrayList<Payment> paymentList) throws ClassNotFoundException {
        int result = 0, returnVal = 0;
        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection().getConnection();
            Statement stm = conn.createStatement();
            conn.setAutoCommit(false);
            int res = deletePaymentSet(paymentList.get(0).getRegistrationId());

            if (res > 0) {
                result = addPaymentSet(paymentList);
            } else {
                returnVal = 0;
                conn.rollback();
            }
            if (result == paymentList.size()) {
                returnVal = 1;
            } else {
                returnVal = 0;
                conn.rollback();
            }
            if (returnVal == 1) {
                conn.commit();
            }

        } catch (SQLException ex) {

            try {
                conn.rollback();
                if (conn == null) {
                    throw ex;
                }
            } catch (SQLException ex1) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex1);
            }

        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnVal;
    }
}
