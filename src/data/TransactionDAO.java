/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import business.Registration;
import java.sql.*;;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author icbt
 */
public class TransactionDAO implements DataAccess{
    private Connection cn;
    public TransactionDAO() {
        try{
          cn=DataCon.getConnection();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    @Override
    public int add(Object ob) {
        int result=0;
        Registration rt=(Registration)ob;
        String insert="insert into Registration(regId,pID,eventID,regDate,paid) values(?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setInt(1, rt.getRegID());
            ps.setInt(2, rt.getpID());
            ps.setInt(3, rt.getEventID());
            ps.setDate(4, rt.getRegDate());
            ps.setString(5, rt.getPaid());
                      
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
        String delete = "delete * from Registration where regID=?";
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
        Registration r=(Registration)ob;
        String update="update Registration set pID=? ,eventID=?,regDate=?,paid=? where regID=? ";
        
        try{
            PreparedStatement ps=cn.prepareStatement(update);       
           
            ps.setInt(1, r.getpID());
            ps.setInt(2, r.getEventID());
            ps.setDate(3, r.getRegDate());
            ps.setString(4, r.getPaid());
             ps.setInt(5, r.getRegID());
           
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
        Registration r = null;
        String select = "select * from Registration where regID=?";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next())
                    {
                        int RegID = rs.getInt("regID");
                        int PID = rs.getInt("pID");
                        int EvtID = rs.getInt("eventID");
                   
                        Date RegDate = rs.getDate("regDate");
                        String Paid  = rs.getString("paid");
                         
                        
                        
       
            
            
         
                        r = new Registration(RegID, PID, EvtID, RegDate, Paid) ;
                        
                        
                    
                    }
            
            rs.close();
            ps.close();
            return r;
            
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return r;
        }
    }

    
    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> rList = new ArrayList<>();
        String select = "select * from Registration";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next())
                    {
                        int RegID = rs.getInt("regID");
                        int PID = rs.getInt("pID");
                        int EvtID = rs.getInt("eventID");
                   
                        Date RegDate = rs.getDate("regDate");
                        String Paid  = rs.getString("paid");
                        
                        Registration r = new Registration(RegID, PID, EvtID, RegDate, Paid);
                        rList.add(r);
                                              
                    
                    }
            
            rs.close();
            ps.close();
            return rList;
            
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    
}
