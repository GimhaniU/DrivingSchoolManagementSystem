/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.DocumentSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DocumentSetController {

    public static int addDocumentSet(DocumentSet docs) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        //Connection conn=DBConnection.getDBConnection().getConnection();
        System.out.println(docs.getRegistrationId());
        String sql = "Insert into DocumentSet Values('" + docs.getRegistrationId() + "','" + docs.getFivePhoto() + "','" + docs.getMedicalReport() + "','" + docs.getIdentityCopy() + "','" + docs.getbCertiCopy() + "','" + docs.getLicenceCopy() + "')";

        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static DocumentSet searchDocumentSet(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from DocumentSet where registrationId='" + registrationId + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            DocumentSet docs = new DocumentSet(rst.getString("registrationId"), rst.getInt("fivePhoto"), rst.getInt("medicalReport"), rst.getInt("identityCopy"), rst.getInt("bCertiCopy"), rst.getInt("licenceCopy"));
            return docs;
        } else {
            return null;
        }
    }

    public static int updateDocumentSet(DocumentSet documentSet) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        String sql = "Update  DocumentSet set fivePhoto=" + documentSet.getFivePhoto() + ",medicalReport=" + documentSet.getMedicalReport() + ",identityCopy=" + documentSet.getIdentityCopy() + ",bCertiCopy=" + documentSet.getbCertiCopy() + ",licenceCopy=" + documentSet.getLicenceCopy() + " where registrationId='" + documentSet.getRegistrationId() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }
}
