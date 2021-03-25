/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commontests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;  
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author R.Pereira
 */
public class CommonTests {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    
    
    TestConnection connection = new TestConnection();

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        
        String dbURL = "jdbc:oracle:thin:@batgirl.agoraplus.fr:1521:agorapdb";
        String username = "agora";
        String password = "Agora+2016";
        
        //String dbURL = args[0];
        //String username = args[1];
        //String password = args[2];
        
        //TestConnection to make my connection to DB
        TestConnection connection = new TestConnection();
        Connection objConnection = connection.connectBD(dbURL, username, password);
        
        try{
            //Test on Get Tarif
            System.out.println("Starting test on Function Get Tarif");
            
            TestGetTarif objTestGetTarif = new TestGetTarif();
            objTestGetTarif.openCSVGetTarif(objConnection);
            
           /* System.out.println("Test Completed on Function Get Tarif");
            
            //Point and click Get Tarif test
            System.out.println("Starting test Admission to Get Tarif");
            
            TarifAdmissionTest objTarifAdmissionTest = new TarifAdmissionTest();
            objTarifAdmissionTest.tarifAdmission(objConnection);
            
            System.out.println("Test Completed Admission to Get Tarif");*/
            
                        
            System.out.println("Starting test Famille on Hulk");
            
            ficheFamille objFicheFamille = new ficheFamille();
            objFicheFamille.login();
            objFicheFamille.ficheparent();
            System.out.println("Test Famille Completed on Hulk");
            
         } catch (SQLException ex) {
             System.out.println("fail main class");
             ex.printStackTrace();
        } finally{
            objConnection.close();
        } 
        
    }

}
