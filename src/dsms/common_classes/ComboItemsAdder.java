/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.common_classes;

import dsms.controllers.*;
import dsms.models.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author User
 */
public class ComboItemsAdder {

    public static void addAllVehicleClass(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<VehicleClassSet> c;
        combo.removeAllItems();
        c = VehicleClassController.getAllVehicleClasses();
        for (VehicleClassSet vehicleClassSet : c) {
            combo.addItem(vehicleClassSet.getClassType());
        }
    }

    public static void addInstructorsOfVehicleClass(JComboBox combo, String classId) throws SQLException, ClassNotFoundException {
        ArrayList<Instructor> c = InstructorController.searchInstructorByVehicleClass(classId);

        combo.removeAllItems();
        if (c != null) {
            for (Instructor instructor : c) {
                combo.addItem(instructor.getName());
            }
        }

    }

    public static void addAllInstructors(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Instructor> c = InstructorController.getAllInstructors();

        combo.removeAllItems();
        if (c != null) {
            for (Instructor instructor : c) {
                combo.addItem(instructor.getName() + "_" + instructor.getInstructorId());
            }
        }

    }

    public static void addAllPaymentDates(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<String> c = PaymentController.searchPaymentDates();

        combo.removeAllItems();
        if (c != null) {
            for (String date : c) {
                combo.addItem(date);
            }
        }

    }

    public static void addAllInstructorsId(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Instructor> c = InstructorController.getAllInstructors();

        combo.removeAllItems();
        if (c != null) {
            for (Instructor instructor : c) {
                combo.addItem(instructor.getInstructorId());
            }
        }

    }

    public static void addAllIUsers(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<LogIn> c = LogInController.getAllUsers();

        combo.removeAllItems();
        if (c != null) {
            for (LogIn logIn : c) {
                combo.addItem(logIn.getUser());
            }
        }

    }

    public static void addAllStudentID(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();
        c = StudentController.getAllStudent();
        for (Student student : c) {
            combo.addItem(student.getStudentId());
        }
    }
    public static void addAllStudent(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();
        c = StudentController.getAllStudent();
        for (Student student : c) {
            combo.addItem(student.getNameWithInitials()+"_"+student.getStudentId());
        }
    }

    public static void addAllStudentIDTraining(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();
        c = RegistrationController.getAllStudentTraining();
        for (Student student : c) {
            combo.addItem(student.getStudentId());
        }
    }
    public static void addAllStudentTraining(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();
        c = RegistrationController.getAllStudentTraining();
        for (Student student : c) {
            combo.addItem(student.getNameWithInitials()+"_"+student.getStudentId());
        }
    }

    public static void addAllStudentIDFinished(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();
        c = RegistrationController.getAllStudentFinished();
        for (Student student : c) {
            combo.addItem(student.getStudentId());
        }
    }
     public static void addAllStudentFinished(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();
        c = RegistrationController.getAllStudentFinished();
        for (Student student : c) {
            combo.addItem(student.getNameWithInitials()+"_"+student.getStudentId());
        }
    }

    public static void getStudentsOfInstructors(JComboBox combo, String iid) throws SQLException, ClassNotFoundException {
        ArrayList<Student> c;
        combo.removeAllItems();

        c = RegistrationController.searchStudentsOfInstructors(iid);
        for (Student student : c) {
            combo.addItem(student.getStudentId());
        }
    }

    public static void getStudentsOfTrial(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Registration> c;
        combo.removeAllItems();

        c = TrialDetailController.searchStudentsForTrial();
        for (Registration r : c) {
            
            Student student = StudentController.searchStudent(r.getStudentId());
            VehicleClassSet vcs = VehicleClassController.searchVehicleClassSet(r.getClassId());
            combo.addItem(student.getNic() + "_" + vcs.getClassType());

        }
    }

    public static void getStudentsOfExam(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Registration> c;
        System.out.println("agh");
        if (combo.getItemCount() > 0) {
            combo.removeAllItems();
        }
        System.out.println("abc");
        c = ExamDetailController.searchStudentsForExam();
        for (Registration r : c) {
            Student student = StudentController.searchStudent(r.getStudentId());
            VehicleClassSet vcs = VehicleClassController.searchVehicleClassSet(r.getClassId());
            combo.addItem(student.getNic() + "_" + vcs.getClassType());

        }
        System.out.println("pqr");
    }

    public static void getStudentsOfExamResult(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<ExamDetail> c;
        combo.removeAllItems();

        c = ExamDetailController.searchResultEnterSet();
        for (ExamDetail examDetail : c) {
            Registration r = RegistrationController.searchRegistration(examDetail.getRegistrationId());
            Student student = StudentController.searchStudent(r.getStudentId());
            VehicleClassSet vcs = VehicleClassController.searchVehicleClassSet(r.getClassId());
            combo.addItem(student.getNic() + "_" + vcs.getClassType());
        }
    }

    public static void getStudentsOfTrialResult(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<TrialDetail> c;
        combo.removeAllItems();

        c = TrialDetailController.searchResultEnterSet();
        for (TrialDetail trialDetail : c) {
            Registration r = RegistrationController.searchRegistration(trialDetail.getRegistrationId());
            Student student = StudentController.searchStudent(r.getStudentId());
            VehicleClassSet vcs = VehicleClassController.searchVehicleClassSet(r.getClassId());
            combo.addItem(student.getNic() + "_" + vcs.getClassType());
        }
    }

    public static void getComingLectures(JComboBox combo) throws SQLException, ClassNotFoundException {
        ArrayList<Lecture> c;
        combo.removeAllItems();

        c = LectureController.searchComingLectures();
        for (Lecture lecture : c) {

            combo.addItem(lecture.getLectureDate());
        }
    }

    public static void addAllRegistrationsOfAStudent(JComboBox combo, String sid) throws SQLException, ClassNotFoundException {
//        if (combo.getItemCount() > 0) {
//            combo.removeAllItems();
//            System.out.println("removd");
//        }
           combo.removeAllItems();
        ArrayList<Registration> registrations = RegistrationController.searchAllRegistrations(sid);
        for (Registration reg : registrations) {
            //    System.out.println(reg.getRegistrationId());
            combo.addItem(reg.getRegistrationId());
        }
    }
}
