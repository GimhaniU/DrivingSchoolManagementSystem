/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DBConnection {
    private static DBConnection dbConnection;
	private Connection conn;
	
	private DBConnection()throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/DrivingSchool","root", "gimhani");
	}
	public static DBConnection getDBConnection()throws ClassNotFoundException,SQLException {
		if(dbConnection==null){
			dbConnection=new DBConnection();
		}
		return dbConnection;
	}
	public Connection getConnection()throws ClassNotFoundException,SQLException{
		return conn;
	}
}
