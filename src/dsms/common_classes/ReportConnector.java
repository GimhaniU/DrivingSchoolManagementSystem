/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.common_classes;

import dsms.views.ReportDialog;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ReportConnector {
    
    public static JasperViewer sendHashMapAndConn(InputStream inputStream, HashMap map) throws ClassNotFoundException, SQLException, JRException {
        JasperReport jr = JasperCompileManager.compileReport(inputStream);
        Connection conn = dbUtilities.DBConnection.getDBConnection().getConnection();
        JasperPrint fillReport = JasperFillManager.fillReport(jr, map, conn);
        JasperViewer jv = new JasperViewer(fillReport);
        return jv;
    }
    
    public static JasperViewer sendHashMap(InputStream inputStream, HashMap map) throws ClassNotFoundException, SQLException, JRException {
        // InputStream is = parent.class.getResourceAsStream("/reports/abc.jrxml");
        JasperReport jr = JasperCompileManager.compileReport(inputStream);
        JasperPrint fillReport = JasperFillManager.fillReport(jr, map);
        JasperViewer jv = new JasperViewer(fillReport);
        return jv;
    }

    public static JasperViewer sendTable(InputStream inputStream, HashMap map, DefaultTableModel dtm) throws ClassNotFoundException, SQLException, JRException {
        // InputStream is = parent.class.getResourceAsStream("/reports/abc.jrxml");
        JasperReport jr = JasperCompileManager.compileReport(inputStream);
        JasperPrint fillReport = JasperFillManager.fillReport(jr, map, new JRTableModelDataSource(dtm));
        JasperViewer jv = new JasperViewer(fillReport);
        return jv;
    }

    public static void viewInDialog(JasperViewer jv) throws ClassNotFoundException, SQLException, JRException {
        ReportDialog report = new ReportDialog(jv, true);
        report.setContentPane(jv.getContentPane());
        report.setSize(jv.getSize());
        report.setVisible(true);
    }
}
