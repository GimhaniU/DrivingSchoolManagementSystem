/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class BackUp {

//    static File existsFile;

    public static void writeBackup() throws IOException {
//        existsFile = new File("F:/AD.sql");
//       existsFile.deleteOnExit();

        Runtime runTime = Runtime.getRuntime();
        runTime.exec("mysqldump DrivingSchool -h localhost -u root -p0213 -r database.txt");

    }

    public static void restoreBackup() throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "DrivingSchool", "--user=root", "--password=0213", "-e", " source database.txt"};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
    }

    public static int writeBackup(String path) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process runtimeProcess = runTime.exec("mysqldump DrivingSchool -h localhost -u root -p0213 -r " + path + ".txt");
        int res = runtimeProcess.waitFor();
        return res;
        
        
    }

    public static int restoreBackup(String path) throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "DrivingSchool", "--user=root", "--password=0213", "-e", " source " + path};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int res = runtimeProcess.waitFor();
        return res;
    }

    public static void main(String[] args) {
        try {
            writeBackup();
        } catch (IOException ex) {
            Logger.getLogger(BackUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
