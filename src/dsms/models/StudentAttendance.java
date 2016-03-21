/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class StudentAttendance {

    private String registrationId;
    private String instructorId;
    private String date;
    private String turn;

    public StudentAttendance() {
    }

    public StudentAttendance(String registrationId, String instructorId, String date, String turn) {
        this.registrationId = registrationId;
        this.instructorId = instructorId;
        this.date = date;
        this.turn = turn;
    }

    /**
     * @return the registrationId
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * @param registrationId the registrationId to set
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * @return the instructorId
     */
    public String getInstructorId() {
        return instructorId;
    }

    /**
     * @param instructorId the instructorId to set
     */
    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the turn
     */
    public String getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(String turn) {
        this.turn = turn;
    }

    
}
