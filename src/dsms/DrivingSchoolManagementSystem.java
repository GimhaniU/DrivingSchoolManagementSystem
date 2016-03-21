/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import dsms.views.StartProgressBar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author User
 */
public class DrivingSchoolManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
           
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DrivingSchoolManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        StartProgressBar start = new StartProgressBar();
        start.setVisible(true);
    }
}
