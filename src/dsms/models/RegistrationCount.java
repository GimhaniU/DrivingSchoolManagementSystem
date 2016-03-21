/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class RegistrationCount {
    private int monthIndex;
    private String month;
    private int year;
    private int registrationCount;
    private String classId;
    private String classType;

    public RegistrationCount() {
    }

    public RegistrationCount(int monthIndex, String month, int year, int registrationCount) {
        this.monthIndex = monthIndex;
        this.month = month;
        this.year = year;
        this.registrationCount = registrationCount;
    }

    public RegistrationCount( String classId, String classType,int registrationCount) {
        this.registrationCount = registrationCount;
        this.classId = classId;
        this.classType = classType;
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
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
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

    /**
     * @return the registrationCount
     */
    public int getRegistrationCount() {
        return registrationCount;
    }

    /**
     * @param registrationCount the registrationCount to set
     */
    public void setRegistrationCount(int registrationCount) {
        this.registrationCount = registrationCount;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return the classType
     */
    public String getClassType() {
        return classType;
    }

    /**
     * @param classType the classType to set
     */
    public void setClassType(String classType) {
        this.classType = classType;
    }
    
    
}
