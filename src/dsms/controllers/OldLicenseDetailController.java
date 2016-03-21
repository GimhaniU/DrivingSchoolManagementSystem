/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.OldLicenseDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class OldLicenseDetailController {

    public static int addOldLicenseDetail(OldLicenseDetail oldLicenseDetail) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        int res = 0;

        String sql = "Insert into OldLicenseDetail Values('" + oldLicenseDetail.getStudentId() + "','" + oldLicenseDetail.getOldDriverLicenceNo() + "','" + oldLicenseDetail.getOldDriverLicenceIssueDate() + "','" + oldLicenseDetail.getOldDriverLicenceExpireDate() + "','" + oldLicenseDetail.getClasses() + "')";
        res = DBHandler.setData(conn, sql);
        return res;
    }

    public static OldLicenseDetail searchOldLicenseDetail(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from OldLicenseDetail where studentId='" + studentId + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            OldLicenseDetail oldLicenseDetail = new OldLicenseDetail(rst.getString("studentId"), rst.getString("oldDriverLicenceNo"), rst.getString("oldDriverLicenceIssueDate"), rst.getString("oldDriverLicenceExpireDate"), rst.getString("classes"));
            return oldLicenseDetail;
        } else {
            return null;
        }
    }

    public static int checkLicenseValidity(String oldDriverLicenceIssueDate) throws ClassNotFoundException, SQLException {
        int result;
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = " Select YEAR(curDate())-YEAR('" + oldDriverLicenceIssueDate + "') as yearDifference,MONTH(curDate())-MONTH('" + oldDriverLicenceIssueDate + "') as monthDifference,DAYOFMONTH(curDate())-DAYOFMONTH('" + oldDriverLicenceIssueDate + "') as DateDifference";
        ResultSet rst = DBHandler.getData(conn, sql);
        int yearDifference = 0, monthDifference = 0, dateDifference = 0;
        if (rst.next()) {
            yearDifference = rst.getInt("yearDifference");
            monthDifference = rst.getInt("monthDifference");
            dateDifference = rst.getInt("dateDifference");
        }
        if (yearDifference < 2 | (yearDifference > 2 & monthDifference < 0) | (yearDifference > 2 & dateDifference < 0)) {
            result = 0;
        } else {
            result = 1;
        }
        return result;

    }

    public static int updateOldLicenseDetail(OldLicenseDetail oldLicenseDetail) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String issueDate = oldLicenseDetail.getOldDriverLicenceIssueDate();
        int res;
        int validity = OldLicenseDetailController.checkLicenseValidity(issueDate);
        if (validity > 0) {
            String sql = "Update OldLicenseDetail set oldDriverLicenceNo='" + oldLicenseDetail.getOldDriverLicenceNo() + "',oldDriverLicenceIssueDate='" + oldLicenseDetail.getOldDriverLicenceIssueDate() + "',oldDriverLicenceExpireDate='" + oldLicenseDetail.getOldDriverLicenceExpireDate() + "',classes='" + oldLicenseDetail.getClasses() + "' where studentId='" + oldLicenseDetail.getStudentId() + "'";
            res = DBHandler.setData(conn, sql);
        } else {
            res = -1;
        }

        return res;
    }
}
