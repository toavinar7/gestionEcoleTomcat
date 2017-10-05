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
import modele.Coefficient;
import util.Fonction;
import util.FonctionNote;
import modele.Matiere;

/**
 *
 * @author toavina
 */
public class CoefficientDao {
     Fonction fonction = new Fonction();
    FonctionNote fonctNote=new FonctionNote();
    
   public int insererCoefficient(int matiere,int coef, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idclasse=0;
            String sqlID = "select * from coefficient";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idclasse=rSetIdGenerees.getInt(1);
            }
            idMessage = idclasse + 1;
             String req="INSERT INTO coefficient(IDCOEFFICIENT, IDMATIERE,COEF)\n" +
                    "    VALUES ("+idMessage+","+matiere+","+coef+")";
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
   
    public List<Coefficient> listerCoefficient(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        List<Coefficient> resultat = new ArrayList<Coefficient>();
          req=  "select * from coefficient";
          if(id!=0){
              req +=" where IDCOEFFICIENT="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Coefficient coef = new Coefficient();
                   coef.setId(rset.getInt(1));
                   coef.setMatiere(fonction.listeMatiere(rset.getInt(2)).get(0));
                   coef.setCoef(rset.getInt(3));
                   resultat.add(coef);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
    public List<Coefficient>listeCoefficientMatiere(Connection con,Statement stat,ResultSet rset,Matiere matiere ){
         String req;
        List<Coefficient> resultat = new ArrayList<Coefficient>();
          req=  "select * from coefficient";
          if(matiere!=null){
              req +=" where IDMATIERE="+matiere.getId();
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Coefficient coef = new Coefficient();
                   coef.setId(rset.getInt(1));
                   coef.setMatiere(fonction.listeMatiere(rset.getInt(2)).get(0));
                   coef.setCoef(rset.getInt(3));
                   resultat.add(coef);
                }      
         }
        catch(Exception e){
        } 
      return resultat;  
    }
}
