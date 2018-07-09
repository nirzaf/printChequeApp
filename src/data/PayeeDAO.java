/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import business.Payee;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author icbt
 */
public class PayeeDAO implements DataAccess{
    private Connection cn;

    public PayeeDAO() {
        try{
          cn=DataCon.getConnection();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }

    
    
    @Override
    public int add(Object ob) {
       int result=0;
        Payee pt=(Payee)ob;
        String insert="insert into Participant(pId,firstName,lastName,address,telephone,email) values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setInt(1, pt.getpID());
            ps.setString(2, pt.getFirstName());
            ps.setString(3, pt.getLastName());
            ps.setString(4, pt.getAddress());
            ps.setString(5, pt.getTelephone());
            ps.setString(6, pt.getEmail());           
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
        String delete = "delete * from Participant where pID=?";
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
        Payee pt=(Payee)ob;
        String update="update Participant set firstName=?, lastName=?, address=?, telephone=?, email=?where pId=? ";
        try{
            PreparedStatement ps=cn.prepareStatement(update);            
            ps.setString(1, pt.getFirstName());
            ps.setString(2, pt.getLastName());
            ps.setString(3, pt.getAddress());
            ps.setString(4, pt.getTelephone());
            ps.setString(5, pt.getEmail());            
            ps.setInt(6, pt.getpID());
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
        Payee pt = null;
        String select = "select * from Participant where pID=?";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next())
                    {
                        int pID = rs.getInt("pID");
                        String firstName = rs.getString("firstName");
                        String lastName = rs.getString("lastName");
                        String address = rs.getString("address");
                        String telephone = rs.getString("telephone");
                        String email = rs.getString("email");                        
                        pt = new Payee(pID, firstName, lastName, address, telephone, email);                                             
                    
                    }
            
            rs.close();
            ps.close();
            return pt;
    }
    catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return pt;
        }
    }
    @Override
    public ArrayList<Object> getAll() {
       ArrayList<Object>  pList = new ArrayList<>();
        String select = "select * from Participant";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                        int pID = rs.getInt("pID");
                        String firstName = rs.getString("firstName");
                        String lastName = rs.getString("lastName");
                        String address = rs.getString("address");
                        String telephone = rs.getString("telephone");
                        String email = rs.getString("email");                        
                        Payee  pt = new Payee(pID, firstName, lastName, address, telephone, email);
                        pList.add(pt);
                        
            }
            rs.close();
            ps.close();
            return pList;
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return pList;
        }
    }
    }


