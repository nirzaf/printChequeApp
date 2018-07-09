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
public class Cheque {
    private int eventID;
    private String title;
    private Date eDate;
    private String eTime;
    private String resPerson;
    private String contact;
    private double price;

    public Cheque() {
    }

    public Cheque(int eventID, String title, Date eDate, String eTime, String resPerson, String contact, double price) {
        this.eventID = eventID;
        this.title = title;
        this.eDate = eDate;
        this.eTime = eTime;
        this.resPerson = resPerson;
        this.contact = contact;
        this.price = price;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getResPerson() {
        return resPerson;
    }

    public void setResPerson(String resPerson) {
        this.resPerson = resPerson;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void createPdf(String pdf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
