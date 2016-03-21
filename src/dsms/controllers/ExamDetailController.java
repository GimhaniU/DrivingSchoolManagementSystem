/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.ExamDetail;
import dsms.models.Registration;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ExamDetailController {

    public static int addExamDetail(ExamDetail examDetail) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Insert into ExamDetail Values('" + examDetail.getRegistrationId() + "'," + examDetail.getAttempt() + ",'" + examDetail.getDate() + "',0)";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int addExamDetailResult(ExamDetail examDetail) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();

        String sql = "Update  ExamDetail set result='" + examDetail.getResult() + "' where registrationId='" + examDetail.getRegistrationId() + "' and attempt='" + examDetail.getAttempt() + "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static ExamDetail searchLastExamResult(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from ExamDetail where registrationId='" + registrationId + "' and result!=0 order by attempt desc limit 1 ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            ExamDetail examDetail = new ExamDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            return examDetail;
        } else {
            return null;
        }
    }

    public static ExamDetail searchLastExamDetail(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from ExamDetail where registrationId='" + registrationId + "'  order by attempt desc limit 1 ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            ExamDetail examDetail = new ExamDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            return examDetail;
        } else {
            return null;
        }
    }

    public static ArrayList<ExamDetail> searchResultEnterSet() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from ExamDetail where result=0";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<ExamDetail> examResults = new ArrayList();
        while (rst.next()) {
            ExamDetail examDetail = new ExamDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            examResults.add(examDetail);
        }
        return examResults;
    }

    public static ArrayList<ExamDetail> searchExamResultsOfAStudent(String registrationId) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from ExamDetail where registrationId='" + registrationId + "'  order by attempt";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<ExamDetail> examResults = new ArrayList();
        while (rst.next()) {
            ExamDetail examDetail = new ExamDetail(rst.getString("registrationId"), rst.getInt("attempt"), rst.getString("date"), rst.getInt("result"));
            examResults.add(examDetail);
        }
        return examResults;
    }

    public static ArrayList<Registration> searchStudentsForExam() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql1 = "Select * from ExamDetail where result=-1 ";
        ResultSet rst1 = DBHandler.getData(conn, sql1);
        ArrayList<ExamDetail> examResults = new ArrayList();
        // ArrayList<Student> students = new ArrayList<>();
        ArrayList<Registration> registrations = new ArrayList<>();
        while (rst1.next()) {
            ExamDetail examDetail = new ExamDetail(rst1.getString("registrationId"), rst1.getInt("attempt"), rst1.getString("date"), rst1.getInt("result"));
            examResults.add(examDetail);
        }
        for (ExamDetail examDetail : examResults) {
            String sql2 = "Select * from ExamDetail where result=-1 and registrationId='" + examDetail.getRegistrationId() + "' and attempt=(select max(attempt) from examdetail where registrationId='" + examDetail.getRegistrationId() + "')";
            ResultSet rst2 = DBHandler.getData(conn, sql2);

            if (rst2.next()) {
                boolean res = PaymentController.isExamFeeDone(examDetail);

                if (res) {
                    Registration reg = RegistrationController.searchRegistration(examDetail.getRegistrationId());
                    registrations.add(reg);
                    //  Student student = StudentController.searchStudent(reg.getStudentId());
                    //  students.add(student);
                } else {
                }
            } else {
            }
        }
        String sql4 = "Select * from Registration r,Student s where s.studentId=r.studentId and status=1 and r.registrationId not in (select registrationId from examdetail) ";
        ResultSet rst4 = DBHandler.getData(conn, sql4);
        while (rst4.next()) {
            //Student student = new Student(rst4.getString("studentId"), rst4.getString("nameWithInitials"), rst4.getString("surName"), rst4.getString("address"), rst4.getString("nic"), rst4.getString("studentTel"), rst4.getString("gender"), rst4.getInt("status"));
            Registration registration1 = new Registration(rst4.getString("registrationId"), rst4.getString("studentId"), rst4.getString("classId"), rst4.getString("instructorId"), rst4.getString("dateOfRegistration"), rst4.getDouble("discount"), rst4.getDouble("totalFee"), rst4.getString("lectureDate"), rst4.getInt("status"));
//            int a=0;
//            for(Student s:students){
//                if(s.getStudentId().equals(student.getStudentId())){
//                    a++;
//                }
//            }
//           if(a==0){
//               students.add(student);
//           }
            registrations.add(registration1);
        }
        return registrations;
    }
}
