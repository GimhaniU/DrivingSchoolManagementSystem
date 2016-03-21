/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class StudentController {

    public static int addNewStudent(Student student) throws ClassNotFoundException {
        int returnvalue = 0;
        int result;
        DBConnection dbconn;
        Connection conn = null;
        try {
            dbconn = DBConnection.getDBConnection();
            conn = dbconn.getConnection();

            conn.setAutoCommit(false);

            String sql = "Insert into Student Values('" + student.getStudentId() + "','" + student.getNameWithInitials() + "','" + student.getSurName() + "','" + student.getAddress() + "','" + student.getNic() + "','" + student.getStudentTel() + "','" + student.getGender() + "');";

            result = DBHandler.setData(conn, sql);

            if (result > 0) {

                int resReg = RegistrationController.addNewRegistration(student.getRegistration());

                if (resReg > 0) {
                } else {
                    conn.rollback();
                    returnvalue = 0;
                }
                conn.commit();
                returnvalue = 1;
            } else {
                conn.rollback();
                returnvalue = 0;
            }
        } catch (SQLException ex) {
            try {
                System.out.println(ex.getMessage());
                conn.rollback();
                if (conn == null) {
                    throw ex;
                }
            } catch (SQLException ex1) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnvalue;
    }

    public static Student searchStudent(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Student where studentId='" + studentId + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Student student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            return student;
        } else {
            return null;
        }
    }

    public static Student searchStudentByNic(String nic) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Student where nic='" + nic + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Student student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            return student;
        } else {
            return null;
        }
    }

    public static boolean isAStudent(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Student where studentId='" + studentId + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        boolean bool;
        Student student = null;
        if (rst.next()) {
            student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            if (student != null) {
                bool = true;
            } else {
                bool = false;
            }
        } else {
            bool = false;
        }
        return bool;
    }

    public static int updateStudent(Student student) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update  Student Set nameWithInitials='" + student.getNameWithInitials() + "',surName='" + student.getSurName() + "',address='" + student.getAddress() + "',nic='" + student.getNic() + "',studentTel='" + student.getStudentTel() + "' where studentId='" + student.getStudentId() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int updateStudentCompletely(Student student) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        int returnValue = 0;
        try {
            conn = DBConnection.getDBConnection().getConnection();

            String sql = "Update  Student Set nameWithInitials='" + student.getNameWithInitials() + "',surName='" + student.getSurName() + "',address='" + student.getAddress() + "',nic='" + student.getNic() + "',studentTel='" + student.getStudentTel() + "' where studentId='" + student.getStudentId() + "'";
            int res = DBHandler.setData(conn, sql);
            if (res > 0) {
                if (student.getRegistration() != null) {
                    int resReg = RegistrationController.updateRegistrationCompletely(student.getRegistration());

                    if (resReg > 0) {
                    } else {
                        conn.rollback();
                        returnValue = 0;
                    }
                }
                conn.commit();
                returnValue = 1;
            } else {
                conn.rollback();
                returnValue = 0;
            }

        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    throw ex;
                } catch (SQLException ex1) {
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        return returnValue;
    }

    public static int deleteStudent(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();

        String sql = "Delete From Student where studentId='" + studentId + "'";
        int res = DBHandler.setData(conn, sql);
        return res;

    }

    public static ArrayList<Student> getAllStudent() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Student";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            studentList.add(student);
        }
        return studentList;
    }
}
