/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class TrialDetail {

    private String registrationId;
    private int attempt;
    private String date;
    private int result;
    private int month;
    private int trialPassed;
    private int trialFailed;

    public TrialDetail() {
    }
 

    public TrialDetail(int month, int trialPassed, int trialFailed) {
        this.month = month;
        this.trialPassed = trialPassed;
        this.trialFailed = trialFailed;
    }
    public TrialDetail(String registrationId, int attempt, String date, int result) {
        this.registrationId = registrationId;
        this.attempt = attempt;
        this.date = date;
        this.result = result;
    }

    public TrialDetail(String registrationId, int attempt, String date) {
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
     * @param registrationId the sid to set
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
