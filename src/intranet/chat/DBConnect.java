package intranet.chat;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vishu
 */
public class DBConnect {
    
            String url = "jdbc:mysql://localhost/alldata";
            String user = "root";
            String password = "";
            
       private Connection con = null;
       private PreparedStatement pre = null;
       private ResultSet rs = null;
            
            DBConnect(){
                
                try {
                    con = DriverManager.getConnection(url,user,password);
                    
                } catch (SQLException ex) {
                    
                }
                
            }

    public Connection getCon() {
        return con;
    }

    public PreparedStatement getPre() {
        return pre;
    }

    public ResultSet getRs() {
        return rs;
    }
            
            
            
            
            
            
            
                    
            
            
  

    
}
