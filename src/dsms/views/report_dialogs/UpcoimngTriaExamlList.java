/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.views.report_dialogs;

import dsms.common_classes.ReportConnector;
import dsms.views.StudentRegistration;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class UpcoimngTriaExamlList extends javax.swing.JDialog {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form UpcoimngTriaExamlList
     */
    public UpcoimngTriaExamlList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Upcoming Trials & Exams");
        beforeDateChooser.setDate(new Date());
        onDateChooser.setDate(new Date());
        afterDateChooser.setDate(new Date());
        beforeDateChooser.setMinSelectableDate(new Date());
        onDateChooser.setMinSelectableDate(new Date());
        afterDateChooser.setMinSelectableDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        trialListButton = new javax.swing.JButton();
        examListButton = new javax.swing.JButton();
        allUpcomingRButton = new javax.swing.JRadioButton();
        beforeRButton = new javax.swing.JRadioButton();
        onRButton = new javax.swing.JRadioButton();
        onDateChooser = new com.toedter.calendar.JDateChooser();
        beforeDateChooser = new com.toedter.calendar.JDateChooser();
        afterRButton = new javax.swing.JRadioButton();
        afterDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        trialListButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        trialListButton.setText("Trial List");
        trialListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trialListButtonActionPerformed(evt);
            }
        });

        examListButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        examListButton.setText("Exam List");
        examListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examListButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(allUpcomingRButton);
        allUpcomingRButton.setText("All upcoming");
        allUpcomingRButton.setOpaque(false);

        buttonGroup1.add(beforeRButton);
        beforeRButton.setText("Before");
        beforeRButton.setOpaque(false);
        beforeRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeRButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(onRButton);
        onRButton.setText("On");
        onRButton.setOpaque(false);

        onDateChooser.setDateFormatString("yyyy-MM-dd");

        beforeDateChooser.setDateFormatString("yyyy-MM-dd");

        buttonGroup1.add(afterRButton);
        afterRButton.setText("After");
        afterRButton.setOpaque(false);
        afterRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterRButtonActionPerformed(evt);
            }
        });

        afterDateChooser.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 116, Short.MAX_VALUE)
                .addComponent(trialListButton)
                .addGap(30, 30, 30)
                .addComponent(examListButton)
                .addGap(46, 46, 46))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(afterRButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(afterDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(onRButton)
                        .addGap(18, 18, 18)
                        .addComponent(onDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(allUpcomingRButton)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(beforeRButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(beforeDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(allUpcomingRButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(onRButton)
                    .addComponent(onDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(beforeRButton)
                    .addComponent(beforeDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(afterRButton)
                    .addComponent(afterDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examListButton)
                    .addComponent(trialListButton))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trialListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trialListButtonActionPerformed
        try {
            if (allUpcomingRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/trial_reports/allUpcomingTrialList.jrxml");
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, null);
                ReportConnector.viewInDialog(jv);
            } else if (beforeRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/trial_reports/beforeTrialList.jrxml");
                HashMap map = new HashMap();
                map.put("date", sdf.format(beforeDateChooser.getDate()));
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, map);
                ReportConnector.viewInDialog(jv);
            }else if (afterRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/trial_reports/afterTrialList.jrxml");
                HashMap map = new HashMap();
                map.put("date", sdf.format(afterDateChooser.getDate()));
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, map);
                ReportConnector.viewInDialog(jv);
            }else if (onRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/trial_reports/onTrialList.jrxml");
                HashMap map = new HashMap();
                map.put("date", sdf.format(onDateChooser.getDate()));
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, map);
                ReportConnector.viewInDialog(jv);
            }
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_trialListButtonActionPerformed

    private void beforeRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeRButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beforeRButtonActionPerformed

    private void afterRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterRButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afterRButtonActionPerformed

    private void examListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examListButtonActionPerformed
       try {
            if (allUpcomingRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/exam_reports/allUpcomingExamList.jrxml");
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, null);
                ReportConnector.viewInDialog(jv);
            } else if (beforeRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/exam_reports/beforeExamList.jrxml");
                HashMap map = new HashMap();
                map.put("date", sdf.format(beforeDateChooser.getDate()));
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, map);
                ReportConnector.viewInDialog(jv);
            }else if (afterRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/exam_reports/afterExamList.jrxml");
                HashMap map = new HashMap();
                map.put("date", sdf.format(afterDateChooser.getDate()));
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, map);
                ReportConnector.viewInDialog(jv);
            }else if (onRButton.isSelected()) {
                InputStream inputStream = getClass().getResourceAsStream("/dsms/reports/exam_reports/onExamList.jrxml");
                HashMap map = new HashMap();
                map.put("date", sdf.format(onDateChooser.getDate()));
                JasperViewer jv = ReportConnector.sendHashMapAndConn(inputStream, map);
                ReportConnector.viewInDialog(jv);
            }
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_examListButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UpcoimngTriaExamlList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                UpcoimngTriaExamlList dialog = new UpcoimngTriaExamlList(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser afterDateChooser;
    private javax.swing.JRadioButton afterRButton;
    private javax.swing.JRadioButton allUpcomingRButton;
    private com.toedter.calendar.JDateChooser beforeDateChooser;
    private javax.swing.JRadioButton beforeRButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton examListButton;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JDateChooser onDateChooser;
    private javax.swing.JRadioButton onRButton;
    private javax.swing.JButton trialListButton;
    // End of variables declaration//GEN-END:variables
}
