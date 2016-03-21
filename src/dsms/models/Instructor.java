/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class Instructor {

    private String instructorId;
     private String classId;
    private String name;
     private String nic;
    private String address;
    private String instructorTel;
    private String dateOfRegistration;
    private String driverLicenceNo;
    private String driverLicenceExpireDate;
    private String teachingLicenceNo;
    private String teachingLicenceExpireDate;
    private int status;

    public Instructor() {
    }

    public Instructor(String instructorId, String classId, String name,String nic, String address, String instructorTel,String dateOfRegistration, String driverLicenceNo, String driverLicenceExpireDate, String teachingLicenceNo, String teachingLicenceExpireDate, int status) {
        this.instructorId = instructorId;
        this.classId = classId;
        this.name = name;
        this.nic=nic;
        this.address = address;
        this.instructorTel = instructorTel;
        this.dateOfRegistration= dateOfRegistration;
        this.driverLicenceNo = driverLicenceNo;
        this.driverLicenceExpireDate = driverLicenceExpireDate;
        this.teachingLicenceNo = teachingLicenceNo;
        this.teachingLicenceExpireDate = teachingLicenceExpireDate;
        this.status = status;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the instructorTel
     */
    public String getInstructorTel() {
        return instructorTel;
    }

    /**
     * @param instructorTel the instructorTel to set
     */
    public void setInstructorTel(String instructorTel) {
        this.instructorTel = instructorTel;
    }

    /**
     * @return the driverLicenceNo
     */
    public String getDriverLicenceNo() {
        return driverLicenceNo;
    }

    /**
     * @param driverLicenceNo the driverLicenceNo to set
     */
    public void setDriverLicenceNo(String driverLicenceNo) {
        this.driverLicenceNo = driverLicenceNo;
    }

    /**
     * @return the driverLicenceExpireDate
     */
    public String getDriverLicenceExpireDate() {
        return driverLicenceExpireDate;
    }

    /**
     * @param driverLicenceExpireDate the driverLicenceExpireDate to set
     */
    public void setDriverLicenceExpireDate(String driverLicenceExpireDate) {
        this.driverLicenceExpireDate = driverLicenceExpireDate;
    }

    /**
     * @return the teachingLicenceNo
     */
    public String getTeachingLicenceNo() {
        return teachingLicenceNo;
    }

    /**
     * @param teachingLicenceNo the teachingLicenceNo to set
     */
    public void setTeachingLicenceNo(String teachingLicenceNo) {
        this.teachingLicenceNo = teachingLicenceNo;
    }

    /**
     * @return the teachingLicenceExpireDate
     */
    public String getTeachingLicenceExpireDate() {
        return teachingLicenceExpireDate;
    }

    /**
     * @param teachingLicenceExpireDate the teachingLicenceExpireDate to set
     */
    public void setTeachingLicenceExpireDate(String teachingLicenceExpireDate) {
        this.teachingLicenceExpireDate = teachingLicenceExpireDate;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the dateOfRegistration
     */
    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    /**
     * @param dateOfRegistration the dateOfRegistration to set
     */
    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
    
   
}
