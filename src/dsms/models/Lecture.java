/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class Lecture {

    private String lectureDate;
    private String lecturer;

    public Lecture() {
    }

    public Lecture(String lectureDate, String lecturer) {
        this.lectureDate = lectureDate;
        this.lecturer = lecturer;
    }

    /**
     * @return the lectureDate
     */
    public String getLectureDate() {
        return lectureDate;
    }

    /**
     * @param lectureDate the lectureDate to set
     */
    public void setLectureDate(String lectureDate) {
        this.lectureDate = lectureDate;
    }

    /**
     * @return the lecturer
     */
    public String getLecturer() {
        return lecturer;
    }

    /**
     * @param lecturer the lecturer to set
     */
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

}
