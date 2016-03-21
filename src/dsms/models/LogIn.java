/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dsms.models;

/**
 *
 * @author User
 */
public class LogIn {
    private String user;
    private String password;
    private int ability;

    public LogIn() {
    }

    public LogIn(String user, String password, int ability) {
        this.user = user;
        this.password = password;
        this.ability = ability;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ability
     */
    public int getAbility() {
        return ability;
    }

    /**
     * @param ability the ability to set
     */
    public void setAbility(int ability) {
        this.ability = ability;
    }
    
}
