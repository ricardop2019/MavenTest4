/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commontests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author R.Pereira
 */
public class TestConnection {
    
    public Connection connectBD(String DBUrl, String Username, String Password) throws SQLException{
        
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        //System.out.println("Trying to get connection do Batgirl DB");   
        Connection conn = DriverManager.getConnection(DBUrl, Username, Password);
        return conn;
    }
}
