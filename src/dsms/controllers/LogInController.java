/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.LogIn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LogInController {

    public static int addNewUser(LogIn logIn) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Insert into LogIn Values('" + logIn.getUser() + "','" + logIn.getPassword() + "'," + logIn.getAbility() + ")";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int updateUser(LogIn logIn) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Update LogIn set password=(select password('" + logIn.getPassword() + "')),ability=" + logIn.getAbility() + " where user='" + logIn.getUser() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int updatePassword(LogIn logIn) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Update LogIn set password=(select password('" + logIn.getPassword() + "')) where user='" + logIn.getUser() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static ArrayList<LogIn> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from LogIn ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<LogIn> logIns = new ArrayList<>();
        while (rst.next()) {
            LogIn logIn = new LogIn(rst.getString("user"), rst.getString("password"), rst.getInt("ability"));
            logIns.add(logIn);
        }
        return logIns;
    }

    public static LogIn searchUser(String user) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from LogIn where user='" + user + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        LogIn logIn = null;
        while (rst.next()) {
            logIn = new LogIn(rst.getString("user"), rst.getString("password"), rst.getInt("ability"));
        }
        return logIn;
    }

    public static boolean matchPassword(String user, String entertext) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select password,(select password('" + entertext + "')) as entered from LogIn where user='" + user + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        boolean matched = false;

        while (rst.next()) {
            System.out.println("bool");
            if (rst.getString("password").equals(rst.getString("entered"))) {
                matched = true;
                System.out.println("t");
            } else {
                matched = false;
                System.out.println("f");
            }
        }
        return matched;
    }
}
