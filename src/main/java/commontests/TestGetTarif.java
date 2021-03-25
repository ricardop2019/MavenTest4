/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commontests;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;  
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author R.Pereira
 */
public class TestGetTarif {
    
    public void openCSVGetTarif(Connection Connection) throws SQLException{
        
        /*NÃO ESQUECER USAR VERIFICACAO PARA AS / \
        
         String OS = System.getProperty("os.name").toLowerCase();
        String osSlash = OS.indexOf("win") >= 0 ? "\\" : "/";
        
        */
        
        String filename="C:\\Users\\R.Pereira\\Documents\\NetBeansProjects\\mavenproject\\docs\\data2.csv";
        //String filename = "..\\docs\\data2.csv";
        //String filename = "docs\\data2.csv";
        File file = new File(filename);
        try{
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String dataCSV = inputStream.next();
                String[] values = dataCSV.split(";");
                
             int idEnfant = Integer.parseInt(values[0]);
             String dateInsc = values[1];
             int idActivity = Integer.parseInt(values[2]);
             int typeInsc = Integer.parseInt(values[3]);
             int refYear = Integer.parseInt(values[4]);
             int computeMajoration = Integer.parseInt(values[5]);
             String prixHoraireString = values[6].replaceAll("^\"|\"$", "");
             double prixHoraire = Double.parseDouble(prixHoraireString.replace(",","."));

             double tarif = launchGetTarif(idEnfant, dateInsc, idActivity, typeInsc, refYear, computeMajoration, Connection);
             
             if(tarif == prixHoraire){
                 System.out.println("Passed");
             }else{
                 System.out.println("Failue - on the kid:"+idEnfant+" for the activity:"+idActivity+" on date inscription "+dateInsc+" Value Obtained:"+tarif+" Value Expected:"+prixHoraire);
             }
             
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public double launchGetTarif(int idEnfant, String dateInsc, int idActivity, int typeInsc, int refYear, int computeMajoration, Connection Connection) throws SQLException{
        
        Statement stmt = Connection.createStatement();
        
        
        double tarif = 0; 
        ResultSet rs = stmt.executeQuery("Select pck_gestion.f_get_tarif("+idEnfant+",'"+dateInsc+"',"+idActivity+","+typeInsc+","+refYear+","+computeMajoration+" ) from dual");
        while (rs.next()) {
            tarif =  rs.getDouble(1);
        }
        return tarif;
    }
}
