/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

/**
 *
 * @author icbt
 */
public class DataCon {
    
    public static Connection getConnection() throws SQLException{
       String workingDir = System.getProperty("user.dir");
       //String url = "jdbc:sqlite:C:/sqlite/JTP.db";      
       Connection cn= DriverManager.getConnection("jdbc:sqlite"+workingDir+"\\Data.db");
       return cn;
    }
}
