/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.controllers;

import dbUtilities.DBConnection;
import dbUtilities.DBHandler;
import dsms.models.Lecture;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LectureController {

    public static int addNewLecture(Lecture lecture) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Lecture lecture1 = searchLecture(lecture.getLectureDate());
        int res = 0;
        if (lecture1 == null) {
            String sql = "Insert into  Lecture VALUES( '" + lecture.getLectureDate() + "','" + lecture.getLecturer() + "')";
            res = DBHandler.setData(conn, sql);
        } else {
            int result = updateLecture(lecture);
            if (result > 0) {
                res = 2;
            }
        }
        return res;
    }

    public static ArrayList<Lecture> searchComingLectures() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Lecture where lectureDate>=curDate() ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Lecture> lectureList = new ArrayList<>();
        while (rst.next()) {
            Lecture lecture = new Lecture(rst.getString("lectureDate"), rst.getString("lecturer"));
            lectureList.add(lecture);
        }
        return lectureList;
    }

    public static Lecture searchLecture(String date) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Lecture where lectureDate='" + date + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        Lecture lecture = null;
        if (rst.next()) {
            lecture = new Lecture(rst.getString("lectureDate"), rst.getString("lecturer"));

        } else {
            lecture = null;
        }

        return lecture;
    }

    public static int updateLecture(Lecture lecture) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update Lecture set lecturer='" + lecture.getLecturer() + "' where lectureDate='" + lecture.getLectureDate() + "' ";
        int res = DBHandler.setData(conn, sql);


        return res;
    }
}
