/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class CodeGenerateController {

    static String currentId;

    public static void getNextID(JTextField txtID, String prefix, String column, String table) {
        try {
            DBConnection dbconn = DBConnection.getDBConnection();
            java.sql.Connection conn = dbconn.getConnection();

            String sql = "SELECT " + column + " FROM " + table + " ORDER BY  " + column + " DESC LIMIT 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(3);
            String current = prefix + "0000";
            while (rst.next()) {
                current = rst.getString(1);
            }
            ////////////////////////////
            int index = current.length();
            for (int i = current.length() - 1; i >= 0; i--) {
                String part = current.substring(i, current.length());
                try {
                    Integer.parseInt(part);
                } catch (Exception e) {
                    index = i + 1;
                    break;
                }
            }
            String s = current.substring(index);
            int i = Integer.parseInt(s);
            i++;
            txtID.setText(current.substring(0, index) + nf.format(i));

        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static String getNextID(String prefix, String column, String table) {
        String next = null;
        try {
            DBConnection dbconn = DBConnection.getDBConnection();
            java.sql.Connection conn = dbconn.getConnection();

            String sql = "SELECT " + column + " FROM " + table + " ORDER BY  " + column + " DESC LIMIT 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(3);
            String current = prefix + "0000";
            while (rst.next()) {
                current = rst.getString(1);
            }
            ////////////////////////////
            int index = current.length();
            for (int i = current.length() - 1; i >= 0; i--) {
                String part = current.substring(i, current.length());
                try {
                    Integer.parseInt(part);
                } catch (Exception e) {
                    index = i + 1;
                    break;
                }
            }
            String s = current.substring(index);
            int i = Integer.parseInt(s);
            i++;
            next = (current.substring(0, index) + nf.format(i));

        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return next;
    }
//    public static void getNextIDLikeName(JTextField txtID, String prefix, String column,String nameLike, String table,String namePrefix) {
//        try {
//          DBConnection dbconn=DBConnection.getDBConnection();
//		java.sql.Connection conn=dbconn.getConnection();
//           
//            String sql="SELECT " + column + " FROM " + table + " where "+nameLike+" like '"+namePrefix+"%'ORDER BY  "+column+" DESC LIMIT 1";
//             ResultSet rst = DBHandler.getData(conn, sql);
//            NumberFormat nf = NumberFormat.getInstance();
//            nf.setMinimumIntegerDigits(3);
//            String current = prefix + "0000";
//            while (rst.next()) {
//                current = rst.getString(1);
//            }
//            ////////////////////////////
//            int index = current.length();
//            for (int i = current.length() - 1; i >= 0; i--) {
//                String part = current.substring(i, current.length());
//                try {
//                    Integer.parseInt(part);
//                } catch (Exception e) {
//                    index = i + 1;
//                    break;
//                }
//            }
//            String s = current.substring(index);
//            int i = Integer.parseInt(s);
//            i++;
//            txtID.setText(current.substring(0, index) + nf.format(i));
//
//        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
//            e.printStackTrace();
//        }
//    }
}
