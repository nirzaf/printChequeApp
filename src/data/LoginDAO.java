/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.ArrayList;
import business.Login;
import java.sql.*;
import java.sql.Connection;   
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author icbt
 */
public class LoginDAO implements DataAccess{
    private Connection cn;
    public LoginDAO() {
       try{
          cn=DataCon.getConnection();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    

    @Override
    public int add(Object ob) {
         int result=0;
        Login lg=(Login)ob;
        String insert="insert into tbl_Login(userID,password,uStatus) values(?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setString(1, lg.getUserID());
            ps.setString(2, lg.getPassword());           
            ps.setString(3, lg.getuStatus());            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int deleteLogin(String userID){
        int result = 0;
        String delete = "delete * from Login where userID=?";
        try
        {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.setString(1, userID);
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
        Login lg=(Login)ob;
        String update="update Login set password=?, uStatus=? where userID=? ";
        try{
            PreparedStatement ps=cn.prepareStatement(update);            
            ps.setString(1, lg.getPassword());           
            ps.setString(2, lg.getuStatus());
            ps.setString(3, lg.getUserID());            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object getLogin(String userID){
         Login log = null;
        String select = "select * from Login where userID=?";        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();          
            
            if(rs.next())
                    {
                        String uID = rs.getString("userID");
                        String password = rs.getString("password");                       
                        String uStatus = rs.getString("uStatus");                        
                       log=new Login(userID, password, uStatus);
                    }            
            rs.close();
            ps.close();
            return log;            
        }      
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return log;
        }
    }

    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object>  loginList = new ArrayList<>();
        String select = "select * from Login";
        
        try
        {
            PreparedStatement ps = cn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                String uID = rs.getString("userID");
                String password = rs.getString("password");
                String uStatus = rs.getString("uStatus");
                Login log = new Login(uID, password, uStatus);
                loginList.add(log);
            }
            rs.close();
            ps.close();
            return loginList;
        }
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return loginList;
        }
    }
    
}
