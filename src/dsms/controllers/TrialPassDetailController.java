/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.common_classes.CalculationMaker;
import dsms.models.TrialPassDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TrialPassDetailController {

    public static ArrayList< TrialPassDetail> searchMonthlyPassed(String instructorId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "select month(date) as monthIndex,year(date) as year,count(t.registrationId) as trialPassedCount from trialdetail t,registration r where t.registrationId=r.registrationId and t.result=1 and r.instructorId='" + instructorId + "' and date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())' group by month(date) order by month(date) ";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> passDetails = new ArrayList<>();
        while (rst.next()) {
            String month = CalculationMaker.selectMonthName(rst.getInt("monthIndex"));
            TrialPassDetail tpd = new TrialPassDetail(rst.getInt("monthIndex"), rst.getInt("year"), month, rst.getInt("trialPassedCount"));
            passDetails.add(tpd);
        }
        return passDetails;
    }

    public static ArrayList< TrialPassDetail> searchMonthlyFailed(String instructorId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "select month(date) as monthIndex,year(date) as year,count(t.registrationId) as trialPassedCount from trialdetail t,registration r where t.registrationId=r.registrationId and t.result=-1 and r.instructorId='" + instructorId + "' and date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())' group by month(date) order by month(date) ";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> failDetails = new ArrayList<>();
        while (rst.next()) {
            String month = CalculationMaker.selectMonthName(rst.getInt("monthIndex"));
            TrialPassDetail tpd = new TrialPassDetail(rst.getInt("monthIndex"), rst.getInt("year"), month, rst.getInt("trialPassedCount"));
            failDetails.add(tpd);
        }
        return failDetails;
    }

    public static ArrayList< TrialPassDetail> searchInstructorPassed(String month) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        int monthIndex = CalculationMaker.selectMonthIndex(month);
        String sql1 = "select i.instructorId,i.name,count(r.registrationId) as noOfStudents from registration r,trialdetail t,instructor i where t.registrationId=r.registrationId and i.instructorId=r.instructorId and month(date)=" + monthIndex + " and t.result=1 and date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())' group by r.instructorid;";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> passDetails = new ArrayList<>();
        while (rst.next()) {
            TrialPassDetail tpd = new TrialPassDetail(rst.getString("instructorId"), rst.getString("name"), rst.getInt("noOfStudents"));
            passDetails.add(tpd);
        }
        return passDetails;
    }

    public static ArrayList< TrialPassDetail> searchInstructorPassed() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();

        String sql1 = "select i.instructorId,i.name,count(r.registrationId) as noOfStudents from registration r,trialdetail t,instructor i where t.registrationId=r.registrationId and i.instructorId=r.instructorId and  t.result=1 and date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())' group by r.instructorid;";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> passDetails = new ArrayList<>();
        while (rst.next()) {
            TrialPassDetail tpd = new TrialPassDetail(rst.getString("instructorId"), rst.getString("name"), rst.getInt("noOfStudents"));
            passDetails.add(tpd);
        }
        return passDetails;
    }

    public static ArrayList< TrialPassDetail> searchInstructorFailed(String month) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        int monthIndex = CalculationMaker.selectMonthIndex(month);
        String sql1 = "select i.instructorId,i.name,count(r.registrationId) as noOfStudents from registration r,trialdetail t,instructor i where t.registrationId=r.registrationId and i.instructorId=r.instructorId and month(date)=" + monthIndex + " and t.result=-1 and date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())'  group by r.instructorid;";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> failDetails = new ArrayList<>();
        while (rst.next()) {
            TrialPassDetail tpd = new TrialPassDetail(rst.getString("instructorId"), rst.getString("name"), rst.getInt("noOfStudents"));
            failDetails.add(tpd);
        }
        return failDetails;
    }

    public static ArrayList< TrialPassDetail> searchInstructorFailed() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "select i.instructorId,i.name,count(r.registrationId) as noOfStudents from registration r,trialdetail t,instructor i where t.registrationId=r.registrationId and i.instructorId=r.instructorId and  t.result=-1 and date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())'  group by r.instructorid;";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> failDetails = new ArrayList<>();
        while (rst.next()) {
            TrialPassDetail tpd = new TrialPassDetail(rst.getString("instructorId"), rst.getString("name"), rst.getInt("noOfStudents"));
            failDetails.add(tpd);
        }
        return failDetails;
    }

    public static ArrayList< TrialPassDetail> searchMonthlyPassed() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "select month(date) as monthIndex,year(date) as year,count(t.registrationId) as trialPassedCount from trialdetail t,registration r where t.registrationId=r.registrationId and t.result=1 and  date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())' group by month(date) order by month(date) ";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> passDetails = new ArrayList<>();
        while (rst.next()) {
            String month = CalculationMaker.selectMonthName(rst.getInt("monthIndex"));
            TrialPassDetail tpd = new TrialPassDetail(rst.getInt("monthIndex"), rst.getInt("year"), month, rst.getInt("trialPassedCount"));
            passDetails.add(tpd);
        }
        return passDetails;
    }

    public static ArrayList< TrialPassDetail> searchMonthlyFailed() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "select month(date) as monthIndex,year(date) as year,count(t.registrationId) as trialPassedCount from trialdetail t,registration r where t.registrationId=r.registrationId and t.result=-1 and  date>'(year(curDate())-1)-month(curDate())-dayOfMonth(curDate())' group by month(date) order by month(date) ";
        ResultSet rst = DBHandler.getData(conn, sql1);
        ArrayList< TrialPassDetail> failDetails = new ArrayList<>();
        while (rst.next()) {
            String month = CalculationMaker.selectMonthName(rst.getInt("monthIndex"));
            TrialPassDetail tpd = new TrialPassDetail(rst.getInt("monthIndex"), rst.getInt("year"), month, rst.getInt("trialPassedCount"));
            failDetails.add(tpd);
        }
        return failDetails;
    }
}
