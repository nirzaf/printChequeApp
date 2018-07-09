/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import business.Cheque;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author icbt
 */
public class ChequeDAO implements DataAccess{
  public Connection cn;
    public ChequeDAO() {
       try{
          cn=DataCon.getConnection();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }       
    
    
    @Override
    public int add(Object ob) {
        int result=0;
        Cheque evt=(Cheque)ob;
        String insert="insert into Event(eventId,title,eDate,eTime,resPerson,contact,price) values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setInt(1, evt.getEventID());
            ps.setString(2, evt.getTitle());
            ps.setDate(3, evt.geteDate());
            ps.setString(4, evt.geteTime());
            ps.setString(5, evt.getResPerson());
            ps.setString(6, evt.getContact());
            ps.setDouble(7, evt.getPrice());
            result=ps.executeUpdate();
            ps.close();
            return result;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return result;
        }
    
    }

    @Override
    public int delete(int id) {
        int result = 0;
        String delete = "delete * from Event where eventID=?";
        try
        {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.setInt(1, id);
            result = ps.executeUpdate();
            ps.close();
            return result;
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return result;
                    
        }
    }

    @Override
    public int update(Object ob) {
       int result=0;
        Cheque evt=(Cheque)ob;
        String update="update Event set title=?, eDate=?, eTime=?, resPerson=?, contact=?, price=? where eventId=? ";
        try{
            PreparedStatement ps=cn.prepareStatement(update);            
            ps.setString(1, evt.getTitle());
            ps.setDate(2, evt.geteDate());
            ps.setString(3, evt.geteTime());
            ps.setString(4, evt.getResPerson());
            ps.setString(5, evt.getContact());
            ps.setDouble(6, evt.getPrice());
            ps.setInt(7, evt.getEventID());
            result=ps.executeUpdate();
            ps.close();
            return result;
        }catch(SQLException e){
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public Object get(int id) {
        Cheque ev = null;
        String select = "select * from Event where eventID=?";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next())
                    {
                        int eID = rs.getInt("eventID");
                        String title = rs.getString("title");
                        Date eDate = rs.getDate("eDate");
                        String eTime = rs.getString("eTime");
                        String resPerson = rs.getString("resPerson");
                        String contact = rs.getString("contact");
                        double price = rs.getDouble("price");
                        ev = new Cheque(eID, title, eDate, eTime, resPerson, contact, price);
                        
                        
                    
                    }
            
            rs.close();
            ps.close();
            return ev;
            
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return ev;
        }
    }

    @Override
    public ArrayList<Object> getAll() {
       ArrayList<Object>  evList = new ArrayList<>();
        String select = "select * from Event";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                int eID = rs.getInt("eventID");
                        String title = rs.getString("title");
                        Date eDate = rs.getDate("eDate");
                        String eTime = rs.getString("eTime");
                        String resPerson = rs.getString("resPerson");
                        String contact = rs.getString("contact");
                        double price = rs.getDouble("price");
                        Cheque ev = new Cheque(eID, title, eDate, eTime, resPerson, contact, price);
                
                        evList.add(ev);
            }
            rs.close();
            ps.close();
            return evList;
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return evList;
        }
    }
}
  
