/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import com.mysql.jdbc.Connection;
import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SearchComboController {

    public static ArrayList<String> combo(String s, String table, String colum) throws ClassNotFoundException, SQLException {
        Connection conn = (Connection) DBConnection.getDBConnection().getConnection();

        String sql = "Select " + colum + " from " + table + " Where " + colum + " Like '" + s + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<String> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(rst.getString(colum));
        }
        return itemList;
    }

    public static ArrayList<String> combo(String s, String table, String colum, int condition) throws ClassNotFoundException, SQLException {
        Connection conn = (Connection) DBConnection.getDBConnection().getConnection();

        String sql = "Select " + colum + " from " + table + " Where " + colum + " Like '" + s + "' and status=" + condition + " ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<String> itemList = new ArrayList<>();
        while (rst.next()) {
            itemList.add(rst.getString(colum));
        }
        return itemList;
    }
}
