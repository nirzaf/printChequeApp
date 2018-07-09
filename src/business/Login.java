/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

/**
 *
 * @author icbt
 */
public class Login {
    private String userID;
    private String password;
    private String uStatus;

    public Login() {
    }

    public Login(String userID, String password, String uStatus) {
        this.userID = userID;
        this.password = password;
        this.uStatus = uStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }
    
    
}
