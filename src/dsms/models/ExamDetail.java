/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class ExamDetail {

    private String registrationId;
    private int attempt;
    private String date;
    private int result;

    public ExamDetail() {
    }

    public ExamDetail(String registrationId, int attempt, String date, int result) {
        this.registrationId = registrationId;
        this.attempt = attempt;
        this.date = date;
        this.result = result;
    }

    public ExamDetail(String registrationId, int attempt, String date) {
        this.registrationId = registrationId;
        this.attempt = attempt;
        this.date = date;

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
     * @return the attempt
     */
    public int getAttempt() {
        return attempt;
    }

    /**
     * @param attempt the attempt to set
     */
    public void setAttempt(int attempt) {
        this.attempt = attempt;
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
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }
}
