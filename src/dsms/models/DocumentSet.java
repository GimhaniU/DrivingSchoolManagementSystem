/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class DocumentSet {

    private String registrationId;
    private int fivePhoto;
    private int medicalReport;
    private int identityCopy;
    private int bCertiCopy;
    private int licenceCopy;

    public DocumentSet() {
    }

    public DocumentSet(String registrationId, int fivePhoto, int medicalReport, int identityCopy, int bCertiCopy, int licenceCopy) {
        this.registrationId = registrationId;
        this.fivePhoto = fivePhoto;
        this.medicalReport = medicalReport;
        this.identityCopy = identityCopy;
        this.bCertiCopy = bCertiCopy;
        this.licenceCopy = licenceCopy;
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
     * @return the fivePhoto
     */
    public int getFivePhoto() {
        return fivePhoto;
    }

    /**
     * @param fivePhoto the fivePhoto to set
     */
    public void setFivePhoto(int fivePhoto) {
        this.fivePhoto = fivePhoto;
    }

    /**
     * @return the medicalReport
     */
    public int getMedicalReport() {
        return medicalReport;
    }

    /**
     * @param medicalReport the medicalReport to set
     */
    public void setMedicalReport(int medicalReport) {
        this.medicalReport = medicalReport;
    }

    /**
     * @return the identityCopy
     */
    public int getIdentityCopy() {
        return identityCopy;
    }

    /**
     * @param identityCopy the identityCopy to set
     */
    public void setIdentityCopy(int identityCopy) {
        this.identityCopy = identityCopy;
    }

    /**
     * @return the bCertiCopy
     */
    public int getbCertiCopy() {
        return bCertiCopy;
    }

    /**
     * @param bCertiCopy the bCertiCopy to set
     */
    public void setbCertiCopy(int bCertiCopy) {
        this.bCertiCopy = bCertiCopy;
    }

    /**
     * @return the licenceCopy
     */
    public int getLicenceCopy() {
        return licenceCopy;
    }

    /**
     * @param licenceCopy the licenceCopy to set
     */
    public void setLicenceCopy(int licenceCopy) {
        this.licenceCopy = licenceCopy;
    }
}
