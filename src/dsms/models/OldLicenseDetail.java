/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class OldLicenseDetail {

    private String studentId;
    private String oldDriverLicenceNo;
    private String oldDriverLicenceIssueDate;
    private String oldDriverLicenceExpireDate;
    private String classes;

    public OldLicenseDetail() {
    }

    public OldLicenseDetail(String studentId, String oldDriverLicenceNo, String oldDriverLicenceIssueDate, String oldDriverLicenceExpireDate, String classes) {
        this.studentId = studentId;
        this.oldDriverLicenceNo = oldDriverLicenceNo;
        this.oldDriverLicenceIssueDate = oldDriverLicenceIssueDate;
        this.oldDriverLicenceExpireDate = oldDriverLicenceExpireDate;
        this.classes = classes;
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
     * @return the oldDriverLicenceNo
     */
    public String getOldDriverLicenceNo() {
        return oldDriverLicenceNo;
    }

    /**
     * @param oldDriverLicenceNo the oldDriverLicenceNo to set
     */
    public void setOldDriverLicenceNo(String oldDriverLicenceNo) {
        this.oldDriverLicenceNo = oldDriverLicenceNo;
    }

    /**
     * @return the oldDriverLicenceIssueDate
     */
    public String getOldDriverLicenceIssueDate() {
        return oldDriverLicenceIssueDate;
    }

    /**
     * @param oldDriverLicenceIssueDate the oldDriverLicenceIssueDate to set
     */
    public void setOldDriverLicenceIssueDate(String oldDriverLicenceIssueDate) {
        this.oldDriverLicenceIssueDate = oldDriverLicenceIssueDate;
    }

    /**
     * @return the oldDriverLicenceExpireDate
     */
    public String getOldDriverLicenceExpireDate() {
        return oldDriverLicenceExpireDate;
    }

    /**
     * @param oldDriverLicenceExpireDate the oldDriverLicenceExpireDate to set
     */
    public void setOldDriverLicenceExpireDate(String oldDriverLicenceExpireDate) {
        this.oldDriverLicenceExpireDate = oldDriverLicenceExpireDate;
    }

    /**
     * @return the classes
     */
    public String getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }
    
}
