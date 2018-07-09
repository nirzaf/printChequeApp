/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;
import java.sql.Date;
/**
 *
 * @author icbt
 */
public class Registration {
    private int regID;
    private int pID;
    private int eventID;
    private Date regDate;
    private String paid;

    public Registration() {
    }

    public Registration(int regID, int pID, int eventID, Date regDate, String paid) {
        this.regID = regID;
        this.pID = pID;
        this.eventID = eventID;
        this.regDate = regDate;
        this.paid = paid;
    }

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
   
    
    
}
