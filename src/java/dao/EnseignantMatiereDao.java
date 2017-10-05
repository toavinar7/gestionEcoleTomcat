/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author toavina
 */
public class EnseignantMatiereDao {
    
    
     public int insererEnseignantMatiereDao(int idMatiere,int idEnseigant, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idmatiere=0;
            String sqlID = "select * from enseignatmatiere";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idmatiere=rSetIdGenerees.getInt(1);
            }
            idMessage = idmatiere + 1;
             String req="INSERT INTO enseignatmatiere(IDENSEIGNATMATIERE, IDMATIERE,IDENSEIGNANT)\n" +
                    "    VALUES ("+idMessage+",'"+idMatiere+"',"+idEnseigant+")";
            System.out.println("req"+req);
           int a = stat.executeUpdate(req);
        }
        catch(Exception e){
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
         
            
        return idMessage;
    }
}
