/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class PaymentDetail {
    private String date;
    private int monthIndex;
    private String month;
    private String paymentType;
    private int paymentSum;

    public PaymentDetail() {
    }

    public PaymentDetail(String date, String paymentType, int paymentSum) {
        this.date = date;
        this.paymentType = paymentType;
        this.paymentSum = paymentSum;
    }

    public PaymentDetail(int monthIndex, String month, String paymentType, int paymentSum) {
        this.monthIndex = monthIndex;
        this.month = month;
        this.paymentType = paymentType;
        this.paymentSum = paymentSum;
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
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the paymentSum
     */
    public int getPaymentSum() {
        return paymentSum;
    }

    /**
     * @param paymentSum the paymentSum to set
     */
    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    /**
     * @return the paymentSum
     */
   
    
}
