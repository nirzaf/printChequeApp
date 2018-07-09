/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.sql.*;
/**
 *
 * @author icbt
 */
public class DataCon {
    
    public static Connection getConnection() throws SQLException{
       String workingDir = System.getProperty("user.dir");
       Connection cn= DriverManager.getConnection("jdbc:ucanaccess:"+workingDir+"\\EventDB.accdb");
        //String connstr= "jdbc:odbc:;Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "d:/eventapp/EventDB.accdb";  
         // Connection  cn= DriverManager.getConnection(connstr); 
        return cn;
    }
}
