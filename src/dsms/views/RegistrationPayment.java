/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.views;

import dsms.common_classes.PatternsChecker;
import dsms.common_classes.ReportConnector;
import dsms.controllers.*;
import dsms.models.Payment;
import dsms.models.Registration;
import dsms.models.Student;
import dsms.models.VehicleClassSet;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class RegistrationPayment extends javax.swing.JDialog {

    /**
     * Creates new form RegisterPayment
     */
    static String registrationId, name, cid, discount;
    String initialPayment;
    StudentRegistration parentClass;
    Registration registration;

    public RegistrationPayment(javax.swing.JDialog parent, boolean modal, String registrationId) {
        super(parent, modal);
        constructorDetail(registrationId);
    }

    public RegistrationPayment(StudentRegistration aThis, boolean modal, String registrationId) {
        constructorDetail(registrationId);
        parentClass = aThis;
    }

    private void constructorDetail(String registrationId) {
        try {
            initComponents();
            setTitle("Registration Payment");
            setLocationRelativeTo(null);

            RegistrationPayment.registrationId = registrationId;
            registration = RegistrationController.searchRegistration(registrationId);
            RegistrationPayment.discount = Double.toString(registration.getDiscount());
            RegistrationPayment.cid = registration.getClassId();
            Student student = StudentController.searchStudent(registration.getStudentId());
            RegistrationPayment.name = student.getNameWithInitials();

            ridText.setText(registrationId);
            CodeGenerateController.getNextID(payIdText, "P", "paymentId", "payment");
            nameText.setText(name);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dateText.setText(sdf.format(d));

            initialPayText.requestFocus();
            VehicleClassSet vcs = VehicleClassController.searchVehicleClassSet(cid);

            totalFeeText.setText(Double.toString(vcs.getExamFee() + vcs.getStampTax() + vcs.getTrainingFee() + vcs.getTrialFee()));
            trainingFeeText.setText(Double.toString(vcs.getTrainingFee()));
            trialFeeText.setText(Double.toString(vcs.getTrialFee()));
            examFeeText.setText(Double.toString(vcs.getExamFee()));
            stampTaxText.setText(Double.toString(vcs.getStampTax()));
            discountText.setText(discount);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        ridText = new javax.swing.JTextField();
        payIdLabel = new javax.swing.JLabel();
        payIdText = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        totalFeeLabel = new javax.swing.JLabel();
        totalFeeText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        discountText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        trainingFeeText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        examFeeText = new javax.swing.JTextField();
        trialFeeText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        stampTaxText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        balanceToPayText = new javax.swing.JTextField();
        initialPayText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        idLabel.setText("Reg. ID:");

        ridText.setEditable(false);

        payIdLabel.setText("Payment ID:");

        payIdText.setEditable(false);

        dateLabel.setText("Date:");

        dateText.setEditable(false);

        jLabel1.setText("Name:");

        nameText.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ridText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nameText))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(payIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(ridText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(payIdLabel)
                    .addComponent(payIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        totalFeeLabel.setText("Total fee:");

        totalFeeText.setEditable(false);
        totalFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("Discount:");

        discountText.setEditable(false);
        discountText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Initial Payment:");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setText("training fee:");

        trainingFeeText.setEditable(false);
        trainingFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel5.setText("exam fee:");

        jLabel6.setText("trial fee:");

        examFeeText.setEditable(false);
        examFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        trialFeeText.setEditable(false);
        trialFeeText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setText("stamp tax:");

        stampTaxText.setEditable(false);
        stampTaxText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trainingFeeText, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(examFeeText)
                    .addComponent(stampTaxText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(trialFeeText))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(trainingFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(examFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(trialFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stampTaxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel8.setText("Balance To Pay:");

        balanceToPayText.setEditable(false);
        balanceToPayText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        initialPayText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        initialPayText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                initialPayTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                initialPayTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceToPayText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(initialPayText))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(totalFeeLabel))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(totalFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(initialPayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalFeeLabel)
                            .addComponent(totalFeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(balanceToPayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel4.add(saveButton);

        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel4.add(exitButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            this.dispose();
            //registration = RegistrationController.searchRegistration(registrationId);
            Payment payment = new Payment(payIdText.getText(), ridText.getText(), "Training fee", dateText.getText(), Double.valueOf(initialPayment), 1);
            int res = PaymentController.addPayment(payment);
            int result;
            if (res > 0) {
             //   System.out.println("ok");
             //   JOptionPane.showMessageDialog(RegistrationPayment.this, "Registration Successful!");
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/payment_bills/registrationPaymentReport.jrxml");
                HashMap map = new HashMap();
                map.put("paymentId", payIdText.getText());
                map.put("registrationId", ridText.getText());
                map.put("name", nameText.getText());
                map.put("trainingFee", trainingFeeText.getText());
                map.put("stampTax", stampTaxText.getText());
                map.put("examFee", examFeeText.getText());
                map.put("trialFee", trialFeeText.getText());
                map.put("totalFee", totalFeeText.getText());
                map.put("discount", discountText.getText());
                map.put("initialPayment", initialPayText.getText());
                map.put("balanceToPay", balanceToPayText.getText());
                JasperViewer jv = ReportConnector.sendHashMap(inputStream, map);
                ReportConnector.viewInDialog(jv);
            } else {
                System.out.println("fail");
                JOptionPane.showMessageDialog(RegistrationPayment.this, "Payment failed!");
                Student student = StudentController.searchStudent(registration.getStudentId());
                if (StudentController.isAStudent(student.getStudentId())) {
                    result = RegistrationController.deleteRegistration(registrationId);
                } else {
                    result = StudentController.deleteStudent(registration.getStudentId());
                }


            }


        } catch (JRException ex) {
            Logger.getLogger(RegistrationPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegistrationPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        parentClass.setNullText();
    }//GEN-LAST:event_saveButtonActionPerformed
    int x = 0;
    private void initialPayTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initialPayTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            x++;
            if (x == 1) {
                initialPayment = initialPayText.getText();
                balanceToPayText.setText(Double.toString(Double.valueOf(totalFeeText.getText()) - Double.valueOf(discount) - Double.valueOf(initialPayText.getText())));
            } else if (x > 1) {
                saveButton.doClick();
                x = 0;
            }
        }

        String initialPay = initialPayText.getText();
        String newVal = PatternsChecker.checkDecimal(initialPay);
        initialPayText.setText(newVal);
    }//GEN-LAST:event_initialPayTextKeyPressed

    private void initialPayTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initialPayTextKeyReleased
    }//GEN-LAST:event_initialPayTextKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                RegistrationPayment dialog = new RegistrationPayment(new javax.swing.JDialog(), true, registrationId);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balanceToPayText;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JTextField discountText;
    private javax.swing.JTextField examFeeText;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField initialPayText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel payIdLabel;
    private javax.swing.JTextField payIdText;
    private javax.swing.JTextField ridText;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField stampTaxText;
    private javax.swing.JLabel totalFeeLabel;
    private javax.swing.JTextField totalFeeText;
    private javax.swing.JTextField trainingFeeText;
    private javax.swing.JTextField trialFeeText;
    // End of variables declaration//GEN-END:variables
}