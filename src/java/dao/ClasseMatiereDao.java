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
import modele.ClasseMatiere;
import modele.Matiere;
import util.Fonction;

/**
 *
 * @author toavina
 */
public class ClasseMatiereDao {
       Fonction fonction=new Fonction();
      public int insererClasseMatiere(int classe,int matiere, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idclasse=0;
            String sqlID = "select * from classematiere";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idclasse=rSetIdGenerees.getInt(1);
            }
            idMessage = idclasse + 1;
             String req="INSERT INTO classematiere(idClasseMatiere, idClasse,idMatiere)\n" +
                    "    VALUES ("+idMessage+","+classe+","+matiere+")";
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
    public List<ClasseMatiere> listerClasseMatiere(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        List<ClasseMatiere> resultat = new ArrayList<ClasseMatiere>();
          req=  "select * from classematiere";
          if(id!=0){
              req +=" where idClasseMatiere="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   ClasseMatiere cdt = new ClasseMatiere();
                   cdt.setId(rset.getInt(1));
                   cdt.setClasse(rset.getInt(2));
                   cdt.setMatiere(rset.getInt(3));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
}
