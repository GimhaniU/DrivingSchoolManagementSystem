/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.common_classes;

import dsms.controllers.PaymentController;
import dsms.models.Payment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CalculationMaker {

    public static double paymentsAdder(String registrationId) throws ClassNotFoundException, SQLException {
        ArrayList<Payment> paymentList = PaymentController.searchAllTrainingFeePayments(registrationId);
        double paidTotal = 0;
        for (Payment payment : paymentList) {
            paidTotal += payment.getAmount();
        }
        return paidTotal;
    }

    public static double colmnAdder(DefaultTableModel dtm, int column) throws ClassNotFoundException, SQLException {
        double total = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            total += Double.valueOf(dtm.getValueAt(i, column).toString());
        }
        return total;
    }

    public static String selectMonthName(int monthIndex) throws ClassNotFoundException, SQLException {
        String month = null;
        if (monthIndex == 1) {
            month = "January";
        } else if (monthIndex == 2) {
            month = "February";
        } else if (monthIndex == 3) {
            month = "March";
        } else if (monthIndex == 4) {
            month = "April";
        } else if (monthIndex == 5) {
            month = "May";
        } else if (monthIndex == 6) {
            month = "June";
        } else if (monthIndex == 7) {
            month = "July";
        } else if (monthIndex == 8) {
            month = "August";
        } else if (monthIndex == 9) {
            month = "September";
        } else if (monthIndex == 10) {
            month = "October";
        } else if (monthIndex == 11) {
            month = "November";
        } else if (monthIndex == 12) {
            month = "December";
        } else {
            month = "error";
        }

        return month;
    }

    public static int selectMonthIndex(String month) throws ClassNotFoundException, SQLException {
        int monthIndex = 0;
        switch (month) {
            case "January":
                monthIndex = 1;
                break;
            case "February":
                monthIndex = 2;
                break;
            case "March":
                monthIndex = 3;
                break;
            case "April":
                monthIndex = 4;
                break;
            case "May":
                monthIndex = 5;
                break;
            case "June":
                monthIndex = 6;
                break;
            case "July":
                monthIndex = 7;
                break;
            case "August":
                monthIndex = 8;
                break;
            case "September":
                monthIndex = 9;
                break;
            case "October":
                monthIndex = 10;
                break;
            case "November":
                monthIndex = 11;
                break;
            case "December":
                monthIndex = 12;
                break;
            default:
                month = "error";
                break;
        }

        return monthIndex;
    }

    public static String addMonthsToDate(String date, int months) throws ClassNotFoundException, SQLException {
        StringTokenizer st = new StringTokenizer(date, "-");
        String year = st.nextToken();
        String month = st.nextToken();
        String dateOfMonth = st.nextToken();

        //  int monthVal=Integer.parseInt(month)+months;
        int remainMonths = months % 12;
        int plusYears = months / 12;
        int newMonth = Integer.parseInt(month) + remainMonths;
        if (newMonth > 12) {
            newMonth = newMonth - 12;
            plusYears++;
        }
        String newdate = Integer.toString(Integer.parseInt(year) + plusYears) + "-" + Integer.toString(newMonth) + "-" + dateOfMonth;
        System.out.println(newdate);
        return newdate;
    }

    public static void limitSpinnerValue(JSpinner spinner, int min, int max) {
        if (Integer.parseInt(spinner.getValue().toString()) <= min) {
            spinner.setValue(min);

        } else if (Integer.parseInt(spinner.getValue().toString()) >= max) {
            spinner.setValue(max);

        } else {
            spinner.setEnabled(true);
        }

    }

    public static void limitTextFieldValue(JTextField textField, int max) {
         if (textField.getText().length() > max) {
            String newtext = textField.getText().substring(0, max - 1);
            textField.setText(newtext);
        }
      
    }
}
