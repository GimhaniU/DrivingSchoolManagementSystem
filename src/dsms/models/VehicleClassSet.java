/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class VehicleClassSet {

    private String classId;
    private String classType;
    private String description;
    private double stampTax;
    private double trainingFee;
    private double examFee;
    private double trialFee;

    public VehicleClassSet() {
    }

    public VehicleClassSet(String classId, String classType,String description, double stampTax, double trainingFee, double examFee, double trialFee) {
        this.classId = classId;
        this.classType = classType;
        this.description=description;
        this.stampTax = stampTax;
        this.trainingFee = trainingFee;
        this.examFee = examFee;
        this.trialFee = trialFee;
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

    /**
     * @return the stampTax
     */
    public double getStampTax() {
        return stampTax;
    }

    /**
     * @param stampTax the stampTax to set
     */
    public void setStampTax(double stampTax) {
        this.stampTax = stampTax;
    }

    /**
     * @return the trainingFee
     */
    public double getTrainingFee() {
        return trainingFee;
    }

    /**
     * @param trainingFee the trainingFee to set
     */
    public void setTrainingFee(double trainingFee) {
        this.trainingFee = trainingFee;
    }

    /**
     * @return the examFee
     */
    public double getExamFee() {
        return examFee;
    }

    /**
     * @param examFee the examFee to set
     */
    public void setExamFee(double examFee) {
        this.examFee = examFee;
    }

    /**
     * @return the trialFee
     */
    public double getTrialFee() {
        return trialFee;
    }

    /**
     * @param trialFee the trialFee to set
     */
    public void setTrialFee(double trialFee) {
        this.trialFee = trialFee;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
