/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.Instructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class InstructorController {

    public static int addNewInstructor(Instructor instructor) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Insert into  Instructor VALUES( '" + instructor.getInstructorId() + "','" + instructor.getClassId() + "','" + instructor.getName() + "','" + instructor.getNic() + "','" + instructor.getAddress() + "','" + instructor.getInstructorTel() + "','" + instructor.getDateOfRegistration() + "','" + instructor.getDriverLicenceNo() + "','" + instructor.getDriverLicenceExpireDate() + "','" + instructor.getTeachingLicenceExpireDate() + "','" + instructor.getTeachingLicenceExpireDate() + "'," + instructor.getStatus() + ")";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static Instructor searchInstructorByName(String name) throws ClassNotFoundException, SQLException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Select * from Instructor where name='" + name + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Instructor instructor = new Instructor(rst.getString("instructorId"), rst.getString("classId"), rst.getString("name"), rst.getString("NIC"), rst.getString("address"), rst.getString("instructorTel"), rst.getString("dateOfRegistration"), rst.getString("driverLicenceNo"), rst.getString("driverLicenceExpireDate"), rst.getString("teachingLicenceNo"), rst.getString("teachingLicenceExpireDate"), rst.getInt("status"));
            return instructor;
        } else {
            return null;
        }
    }

    public static ArrayList<Instructor> searchInstructorByVehicleClass(String classId) throws ClassNotFoundException, SQLException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Select * from Instructor where classId='" + classId + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Instructor> instructorList = new ArrayList<>();
        if (rst.next()) {
            Instructor instructor = new Instructor(rst.getString("instructorId"), rst.getString("classId"), rst.getString("name"), rst.getString("NIC"), rst.getString("address"), rst.getString("instructorTel"), rst.getString("dateOfRegistration"), rst.getString("driverLicenceNo"), rst.getString("driverLicenceExpireDate"), rst.getString("teachingLicenceNo"), rst.getString("teachingLicenceExpireDate"), rst.getInt("status"));
            instructorList.add(instructor);
        }
        return instructorList;
    }

    public static Instructor searchInstructor(String instructorId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Instructor where instructorId='" + instructorId + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Instructor instructor = new Instructor(rst.getString("instructorId"), rst.getString("classId"), rst.getString("name"), rst.getString("NIC"), rst.getString("address"), rst.getString("instructorTel"), rst.getString("dateOfRegistration"), rst.getString("driverLicenceNo"), rst.getString("driverLicenceExpireDate"), rst.getString("teachingLicenceNo"), rst.getString("teachingLicenceExpireDate"), rst.getInt("status"));
            return instructor;
        } else {
            return null;
        }
    }

    public static int updateInstructor(Instructor instructor) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update  Instructor Set name='" + instructor.getName() + "',NIC='" + instructor.getNic() + "',address='" + instructor.getAddress() + "',instructorTel='" + instructor.getInstructorTel() + "',dateOfRegistration='" + instructor.getDateOfRegistration() + "',driverLicenceNo='" + instructor.getDriverLicenceNo() + "',driverLicenceExpireDate='" + instructor.getDriverLicenceExpireDate() + "',teachingLicenceNo='" + instructor.getTeachingLicenceNo() + "',teachingLicenceExpireDate='" + instructor.getTeachingLicenceExpireDate() + "',status=" + instructor.getStatus() + " where instructorId='" + instructor.getInstructorId() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int deleteInstructor(String instructorId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();

        String sql = "Delete From Instructor where instructorId='" + instructorId + "'";
        int res = DBHandler.setData(conn, sql);
        return res;

    }

    public static ArrayList<Instructor> getAllInstructors() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        ResultSet rst = DBHandler.getData(conn, "Select * From Instructor");
        ArrayList<Instructor> instructorList = new ArrayList<>();
        while (rst.next()) {
            Instructor instructor = new Instructor(rst.getString("instructorId"), rst.getString("classId"), rst.getString("name"), rst.getString("NIC"), rst.getString("address"), rst.getString("instructorTel"), rst.getString("dateOfRegistration"), rst.getString("driverLicenceNo"), rst.getString("driverLicenceExpireDate"), rst.getString("teachingLicenceNo"), rst.getString("teachingLicenceExpireDate"), rst.getInt("status"));
            instructorList.add(instructor);
        }
        return instructorList;
    }
}
