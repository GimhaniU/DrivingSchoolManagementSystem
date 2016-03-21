/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.common_classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class PatternsChecker {

    public static String checkNIC(String nicText) {
        int result = 0;
            if (nicText.length() == 10) {
            Pattern pattern = Pattern.compile("[0-9]{9}[VX]");
            Matcher matcher = pattern.matcher(nicText);
            if (matcher.find()) {
            } else {
                nicText = nicText.substring(0, nicText.length() - 1);
            }
        } else if (nicText.length() < 10) {
            Pattern pattern = Pattern.compile("[0-9]{" + nicText.length() + "}");
            Matcher matcher = pattern.matcher(nicText);
            if (matcher.find()) {
            } else {
                nicText = nicText.substring(0, nicText.length() - 1);
            }

        } else if(nicText.length()> 10) {
            nicText = nicText.substring(0, nicText.length() - 1);
        }
        return nicText;
    }

    public static String  checkTelNum(String telText) {
        int result;
        if (telText.length() == 1) {
            Character c = telText.charAt(0);
            Pattern pattern = Pattern.compile("0");
            Matcher matcher = pattern.matcher(c.toString());
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() == 2 | telText.length() == 3) {
            Pattern pattern = Pattern.compile("[0][1-9]{" + (telText.length() - 1) + "}");
            Matcher matcher = pattern.matcher(telText);
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() > 3 & telText.length() <= 10) {
            Pattern pattern = Pattern.compile("[0][1-9]{2}[0-9]{" + (telText.length() - 3) + "}");
            Matcher matcher = pattern.matcher(telText);
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        }  else if(telText.length()> 10){
           telText = telText.substring(0, telText.length() - 1);
        }
        return telText;
    }
 public static String  checkTelNumAction(String telText) {
        int result;
        if (telText.length()>0) {
            Character c = telText.charAt(0);
            Pattern pattern = Pattern.compile("0");
            Matcher matcher = pattern.matcher(c.toString());
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() == 2 | telText.length() == 3) {
            Pattern pattern = Pattern.compile("[0][1-9]{" + (telText.length() - 1) + "}");
            Matcher matcher = pattern.matcher(telText);
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        } else if (telText.length() > 3 & telText.length() <= 10) {
            Pattern pattern = Pattern.compile("[0][1-9]{2}[0-9]{" + (telText.length() - 3) + "}");
            Matcher matcher = pattern.matcher(telText);
            if (!matcher.find()) {
                telText = telText.substring(0, telText.length() - 1);
            }
        }  else if(telText.length()> 10){
           telText = telText.substring(0, telText.length() - 1);
        }
        return telText;
    }
    public static String checkDecimal(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[0-9.]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);
            }
        }
        return text;

    }
    public static String checkPrice(String text) {
        int result = 0;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[.]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }    
        }
         if (result == 0) {
                text = text.concat(".00");
            }
        return text;
    }

    public static String checkInteger(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);

            }
        }
        return text;

    }
    public static String checkDate(String text) {
        int result;
        for (int i = 1; i < text.length() + 1; i++) {
            Character c = text.charAt(i - 1);
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(c.toString());
            if (matcher.find()) {
                result = 1;
            } else {
                result = 0;
            }
            if (result == 0) {
                text = text.substring(0, i - 1);

            }
        }
        return text;

    }
}
