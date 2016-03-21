/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class Student {

    private String studentId;
    private String nameWithInitials;
    private String surName;
    private String address;
    private String nic;
    private String studentTel;
    private String gender;
    
    private Registration registration;
    
   

    public Student() {
    }

    public Student(String studentId, String nameWithInitials, String surName, String address, String nic, String studentTel, String gender) {
        this.studentId = studentId;
        this.nameWithInitials = nameWithInitials;
        this.surName = surName;
        this.address = address;
        this.nic = nic;
        this.studentTel = studentTel;
        this.gender = gender;
        
    }

    

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the nameWithInitials
     */
    public String getNameWithInitials() {
        return nameWithInitials;
    }

    /**
     * @param nameWithInitials the nameWithInitials to set
     */
    public void setNameWithInitials(String nameWithInitials) {
        this.nameWithInitials = nameWithInitials;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the studentTel
     */
    public String getStudentTel() {
        return studentTel;
    }

    /**
     * @param studentTel the studentTel to set
     */
    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel;
    }

   
    /**
     * @return the registration
     */
    public Registration getRegistration() {
        return registration;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

   
   

   
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
