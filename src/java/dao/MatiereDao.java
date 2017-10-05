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
import java.util.ArrayList;
import java.util.List;
import modele.Classe;
import modele.Matiere;

/**
 *
 * @author Rova
 */
public class MatiereDao {
     public List<Matiere> listerMatiere(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        ArrayList<Matiere> resultat = new ArrayList<Matiere>();
          req=  "select * from matiere";
          if(id!=0){
              req +=" where idMatiere="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Matiere cdt = new Matiere();
                   cdt.setId(rset.getInt(1));
                   cdt.setNomMatiere(rset.getString(2));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    public int insererMatiere(String nomMatiere, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idmatiere=0;
            String sqlID = "select * from matiere";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idmatiere=rSetIdGenerees.getInt(1);
            }
            idMessage = idmatiere + 1;
             String req="INSERT INTO matiere(idmatiere, nommatiere)\n" +
                    "    VALUES ("+idMessage+",'"+nomMatiere+"')";
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
