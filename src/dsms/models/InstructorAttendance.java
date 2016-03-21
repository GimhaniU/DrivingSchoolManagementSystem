/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class InstructorAttendance {

    private String instructorId;
    private String date;
    private String intime;
    private String outtime;

    public InstructorAttendance() {
    }

    public InstructorAttendance(String instructorId, String date, String intime, String outtime) {
        this.instructorId = instructorId;
        this.date = date;
        this.intime = intime;
        this.outtime = outtime;
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
     * @return the intime
     */
    public String getIntime() {
        return intime;
    }

    /**
     * @param intime the intime to set
     */
    public void setIntime(String intime) {
        this.intime = intime;
    }

    /**
     * @return the outtime
     */
    public String getOuttime() {
        return outtime;
    }

    /**
     * @param outtime the outtime to set
     */
    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }
    
}
