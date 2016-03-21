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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RegistrationController {

    public static int addNewRegistration(Registration registration) throws ClassNotFoundException {
        Connection conn = null;
        int returnvalue = 0;
        try {
            conn = DBConnection.getDBConnection().getConnection();
            conn.setAutoCommit(false);
            String sql = "Insert into Registration Values('" + registration.getRegistrationId() + "','" + registration.getStudentId() + "','" + registration.getClassId() + "','" + registration.getInstructorId() + "','" + registration.getDateOfRegistration() + "'," + registration.getDiscount() + "," + registration.getTotalFee() + ",'" + registration.getLectureDate() + "','" + registration.getStatus() + "')";
            int res = DBHandler.setData(conn, sql);
            if (res > 0) {
                int resDoc = DocumentSetController.addDocumentSet(registration.getDocs());
                if (resDoc > 0) {
                    if (resDoc > 0) {
                        if (registration.getOldLicensedetail() == null | registration.getOldLicensedetail().getOldDriverLicenceIssueDate() == null) {
                            System.out.println("123");
                        } else {
                            OldLicenseDetail old = OldLicenseDetailController.searchOldLicenseDetail(registration.getStudentId());
                            int resLic = 0;
                            if (old == null) {
                                System.out.println("1234");
                                resLic = OldLicenseDetailController.addOldLicenseDetail(registration.getOldLicensedetail());
                            } else {
                                System.out.println("1674");
                                resLic = OldLicenseDetailController.updateOldLicenseDetail(registration.getOldLicensedetail());
                            }

                        }
                    } else {
                        System.out.println("a");
                        conn.rollback();
                        returnvalue = 0;
                    }
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
            if (conn != null) {
                try {
                    throw ex;
                } catch (SQLException ex1) {
                    Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        return returnvalue;
    }

    public static Registration searchLastRegistration(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Registration where studentId='" + studentId + "' order by dateOfRegistration desc limit 1";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Registration registration = new Registration(rst.getString("registrationId"), rst.getString("studentId"), rst.getString("classId"), rst.getString("instructorId"), rst.getString("dateOfRegistration"), rst.getDouble("discount"), rst.getDouble("totalFee"), rst.getString("lectureDate"), rst.getInt("status"));
            return registration;
        } else {
            return null;
        }
    }

    public static Registration searchRegistration(String studentId, String classId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Registration where studentId='" + studentId + "' and classId='" + classId + "' order by dateOfRegistration desc limit 1";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Registration registration1 = new Registration(rst.getString("registrationId"), rst.getString("studentId"), rst.getString("classId"), rst.getString("instructorId"), rst.getString("dateOfRegistration"), rst.getDouble("discount"), rst.getDouble("totalFee"), rst.getString("lectureDate"), rst.getInt("status"));
            return registration1;
        } else {
            return null;
        }
    }

    public static Registration searchRegistration(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Registration where registrationId='" + registrationId + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Registration registration1 = new Registration(rst.getString("registrationId"), rst.getString("studentId"), rst.getString("classId"), rst.getString("instructorId"), rst.getString("dateOfRegistration"), rst.getDouble("discount"), rst.getDouble("totalFee"), rst.getString("lectureDate"), rst.getInt("status"));
            return registration1;
        } else {
            return null;
        }
    }

    public static ArrayList<RegistrationCount> countRegistrationsOfMonths() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "select month(dateOfRegistration) as monthIndex,year(dateOfRegistration) as year,count(registrationId) as registrationCount from registration where dateOfRegistration>'(year(curDate)-1)-month(curDate())-dayOfMonth(curDate())' group by month(dateOfRegistration) ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<RegistrationCount> list = new ArrayList<>();
        while (rst.next()) {
            String month = CalculationMaker.selectMonthName(rst.getInt("monthIndex"));
            System.out.println(rst.getInt("monthIndex") + " " + month);
            RegistrationCount registrationCount = new RegistrationCount(rst.getInt("monthIndex"), month, rst.getInt("year"), rst.getInt("registrationCount"));
            list.add(registrationCount);
        }
        return list;
    }

    public static ArrayList<RegistrationCount> countRegistrationsOfClasses() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "select r.classId,classType,count(registrationId) as registrationCount from registration r,vehicleClassSet v where r.classId=v.classId and dateOfRegistration>'(year(curDate)-1)-month(curDate())-dayOfMonth(curDate())' group by r.classId ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<RegistrationCount> list = new ArrayList<>();
        while (rst.next()) {

            RegistrationCount registrationCount = new RegistrationCount(rst.getString("classId"), rst.getString("classType"), rst.getInt("registrationCount"));
            list.add(registrationCount);
        }
        return list;
    }

    public static ArrayList<Registration> searchAllRegistrations(String studentId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Registration where studentId='" + studentId + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Registration> registrations = new ArrayList<>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("registrationId"), rst.getString("studentId"), rst.getString("classId"), rst.getString("instructorId"), rst.getString("dateOfRegistration"), rst.getDouble("discount"), rst.getDouble("totalFee"), rst.getString("lectureDate"), rst.getInt("status"));
            registrations.add(registration);
        }
        return registrations;
    }

    public static int deleteRegistration(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Delete From Registration where registrationId='" + registrationId + "'";
        int res = DBHandler.setData(conn, sql);
        return res;

    }

    public static int updateRegistration(Registration registration) throws ClassNotFoundException, SQLException {

        int returnvalue = 0;

        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        String sql = "Update  Registration set studentId='" + registration.getStudentId() + "',classId='" + registration.getClassId() + "',instructorId='" + registration.getInstructorId() + "',dateOfRegistration='" + registration.getDateOfRegistration() + "',discount='" + registration.getDiscount() + "',totalFee=" + registration.getTotalFee() + ",lectureDate='" + registration.getLectureDate() + "',status='" + registration.getStatus() + "' where registrationId='" + registration.getRegistrationId() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;

    }

    public static int updateRegistrationCompletely(Registration registration) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        int returnvalue = 0;
        try {
            conn = DBConnection.getDBConnection().getConnection();
            conn.setAutoCommit(false);
            String sql = "Update  Registration set studentId='" + registration.getStudentId() + "',classId='" + registration.getClassId() + "',instructorId='" + registration.getInstructorId() + "',dateOfRegistration='" + registration.getDateOfRegistration() + "',discount='" + registration.getDiscount() + "',totalFee=" + registration.getTotalFee() + ",lectureDate='" + registration.getLectureDate() + "',status='" + registration.getStatus() + "'  where registrationId='" + registration.getRegistrationId() + "'";
            int res = DBHandler.setData(conn, sql);

            if (res > 0) {
                int resDoc = 0;
                if (registration.getDocs() == null) {
                } else {
                    DocumentSet docs = DocumentSetController.searchDocumentSet(registration.getStudentId());
                    int resLic = 0;
                    if (docs == null) {
                        resDoc = DocumentSetController.addDocumentSet(registration.getDocs());
                    } else {
                        resDoc = DocumentSetController.updateDocumentSet(registration.getDocs());
                    }

                }
                // if(registration.getDocs()!=null){
                // int resDoc = DocumentSetController.addDocumentSet(registration.getDocs());

                if (resDoc > 0) {
                    if (registration.getOldLicensedetail() == null | registration.getOldLicensedetail().getOldDriverLicenceIssueDate() == null) {
                    } else {
                        OldLicenseDetail old = OldLicenseDetailController.searchOldLicenseDetail(registration.getStudentId());
                        int resLic = 0;
                        if (old == null) {
                            resLic = OldLicenseDetailController.addOldLicenseDetail(registration.getOldLicensedetail());
                        } else {
                            resLic = OldLicenseDetailController.updateOldLicenseDetail(registration.getOldLicensedetail());
                        }
                        if (resLic == -1) {
                            returnvalue = -1;
                        }
                    }
                } else {
                    System.out.println("a");
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
            if (conn != null) {
                try {
                    throw ex;
                } catch (SQLException ex1) {
                    Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        return returnvalue;
    }

    public static ArrayList<Student> searchStudentsOfInstructors(String instructorId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Registration r,Student s where instructorId='" + instructorId + "' and r.status=1 and s.studentId=r.studentId";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Student> studentlist = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            studentlist.add(student);
        }
        return studentlist;
    }

    public static ArrayList<Student> getAllStudentTraining() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        ResultSet rst = DBHandler.getData(conn, "select * from student where studentId in (select studentId from registration where status=1 );");
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {

            Student student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            studentList.add(student);
        }
        return studentList;
    }

    public static ArrayList<Student> getAllStudentFinished() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();

        ResultSet rst = DBHandler.getData(conn, "select * from student where studentId not in (select studentId from registration where status=1 );");
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getString("studentId"), rst.getString("nameWithInitials"), rst.getString("surName"), rst.getString("address"), rst.getString("nic"), rst.getString("studentTel"), rst.getString("gender"));
            studentList.add(student);
        }
        return studentList;
    }
}
