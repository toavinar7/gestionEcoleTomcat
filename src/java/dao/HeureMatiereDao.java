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
import modele.EmploiDuTemp;
import modele.Enseignant;
import modele.HeureMatiere;
import util.Fonction;

/**
 *
 * @author MAMPYUN
 */
public class HeureMatiereDao {
     Fonction fonction=new Fonction();
     public List<HeureMatiere> listerHeureMatiere(Connection con,Statement stat,ResultSet rset,int id,int idclasse,int idEmploi,int idEnseignant){
        String req;
        List<HeureMatiere> resultat = new ArrayList<HeureMatiere>();
          req=  "select * from heurematiere";
          if(id!=0){
              req +=" where idheurematiere="+id;
          }
          if(idclasse!=0){
              req +=" where IDCLASSE="+idclasse;
          }
          if(idEmploi!=0){
              req +=" where IDEMPLOIDUTEMP="+idEmploi;
          }
          if(idEnseignant!=0){
              req +=" where IDENSEIGNANT="+idEnseignant;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Classe c=new Classe();
                   EmploiDuTemp emp=new EmploiDuTemp();
                   Enseignant cdt = new Enseignant();
                   HeureMatiere rep=new HeureMatiere();
                   rep.setId(rset.getInt(1));
                   rep.setClasse(fonction.listeClasse(rset.getInt(2)).get(0));
                   rep.setEmploidutemp(fonction.listeEmploidutemp(rset.getInt(3)).get(0));
                   rep.setEnseignant(fonction.listeEnseignant(rset.getInt(4),0).get(0));
                   rep.setJour(rset.getString(5));
                   rep.setHeuredebut(rset.getString(6));
                   rep.setHeureFin(rset.getString(7));
                   resultat.add(rep);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    public int insererHeureMatiere(int idclasse,int idEmploi,int idEnseig,String jour,String hdebut,String hfin, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idetud=0;
            String sqlID = "select * from heurematiere ORDER BY `IDHEUREMATIERE` ASC";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idetud=rSetIdGenerees.getInt(1);
            }
            idMessage = idetud + 1;
           
             String req="INSERT INTO heurematiere(IDHEUREMATIERE, IDCLASSE,IDEMPLOIDUTEMP,IDENSEIGNANT,JOUR,HEUREDEBUT,HEUREFIN)\n" +
                    "    VALUES ("+idMessage+","+idclasse+","+idEmploi+","+idEnseig+",'"+jour+"','"+hdebut+"','"+hfin+"')";
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
