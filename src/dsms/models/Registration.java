/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class Registration {

    private String registrationId;
    private String studentId;
    private String classId;
    private String instructorId;
    private String dateOfRegistration;
    private double discount;
    private double totalFee;
    private String lectureDate;
    private int status;
    private Payment payment;
    private DocumentSet docs;
    private OldLicenseDetail oldLicensedetail;

    public Registration() {
    }

    public Registration(String registrationId, String studentId, String classId, String instructorId, String dateOfRegistration, double discount, double totalFee, String lectureDate, int status) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.classId = classId;
        this.instructorId = instructorId;
        this.dateOfRegistration = dateOfRegistration;
        this.discount = discount;
        this.totalFee = totalFee;
        this.lectureDate = lectureDate;
        this.status = status;
    }

    public Registration(String registrationId, String studentId, String classId, String instructorId, String dateOfRegistration, double discount, double totalFee, int status) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.classId = classId;
        this.instructorId = instructorId;
        this.dateOfRegistration = dateOfRegistration;
        this.discount = discount;
        this.totalFee = totalFee;
        this.status = status;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
     *
     *
     * /
     **
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the totalFee
     */
    public double getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee the totalFee to set
     */
    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
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
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * @return the docs
     */
    public DocumentSet getDocs() {
        return docs;
    }

    /**
     * @param docs the docs to set
     */
    public void setDocs(DocumentSet docs) {
        this.docs = docs;
    }

    /**
     * @return the oldLicensedetail
     */
    public OldLicenseDetail getOldLicensedetail() {
        return oldLicensedetail;
    }

    /**
     * @param oldLicensedetail the oldLicensedetail to set
     */
    public void setOldLicensedetail(OldLicenseDetail oldLicensedetail) {
        this.oldLicensedetail = oldLicensedetail;
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
}
