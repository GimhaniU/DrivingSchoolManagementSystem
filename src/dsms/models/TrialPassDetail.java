/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class TrialPassDetail {

    private int monthIndex;
    private String month;
    private int year;
    private int trialPassed;
   
    private String instructorId;
    private String instructorName;
    private int noOfStudents;

    public TrialPassDetail(String instructorId, String instructorName, int noOfStudents) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.noOfStudents = noOfStudents;
    }

   

    public TrialPassDetail() {
    }

    public TrialPassDetail(int monthIndex, String month, int trialPassed) {
        this.monthIndex = monthIndex;
        this.month = month;
        this.trialPassed = trialPassed;
    }

    public TrialPassDetail(int monthIndex, int year,String month,  int trialPassed) {
        this.monthIndex = monthIndex;
        this.month = month;
        this.year = year;
        this.trialPassed = trialPassed;
    }
    

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public int getTrialPassed() {
        return trialPassed;
    }

    public void setTrialPassed(int trialPassed) {
        this.trialPassed = trialPassed;
    }

    /**
     * @return the monthIndex
     */
    public int getMonthIndex() {
        return monthIndex;
    }

    /**
     * @param monthIndex the monthIndex to set
     */
    public void setMonthIndex(int monthIndex) {
        this.monthIndex = monthIndex;
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
     * @return the instructorName
     */
    public String getInstructorName() {
        return instructorName;
    }

    /**
     * @param instructorName the instructorName to set
     */
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    /**
     * @return the noOfStudents
     */
    public int getNoOfStudents() {
        return noOfStudents;
    }

    /**
     * @param noOfStudents the noOfStudents to set
     */
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

  
}
