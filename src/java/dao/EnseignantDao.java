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
import modele.Enseignant;
import util.Fonction;


/**
 *
 * @author nat
 */
public class EnseignantDao {
    Fonction fonction=new Fonction();
    public int insererEnseignant(int idMatiere,String nom,String prenom,String login,String mdp, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idetud=0;
            String sqlID = "select * from enseignant";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idetud=rSetIdGenerees.getInt(1);
            }
            idMessage = idetud + 1;
             String req="INSERT INTO enseignant(IDENSEIGNANT, IDMATIERE,NOM,PRENOM,LOGIN,MOTDEPASSE)\n" +
                    "    VALUES ("+idMessage+","+idMatiere+",'"+nom+"','"+prenom+"','"+login+"','"+mdp+"')";
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
    public int insererEnseignantClasse(int idEns,int idClasse, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idetud=0;
            String sqlID = "select * from enseignantclasse";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idetud=rSetIdGenerees.getInt(1);
            }
            idMessage = idetud + 1;
             String req="INSERT INTO enseignantclasse(idenseignantClasse, idEnseignant,idClasse)\n" +
                    "    VALUES ("+idMessage+","+idEns+","+idClasse+")";
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
    public int insererEnseignantMatiere(int idEns,int idMatiere, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idetud=0;
            String sqlID = "select * from enseignatmatiere";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idetud=rSetIdGenerees.getInt(1);
            }
            idMessage = idetud + 1;
             String req="INSERT INTO enseignatmatiere(IDENSEIGNATMATIERE, IDMATIERE,IDENSEIGNANT)\n" +
                    "    VALUES ("+idMessage+","+idMatiere+","+idEns+")";
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
    public List<Enseignant> listerEnseignant(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        List<Enseignant> resultat = new ArrayList<Enseignant>();
          req=  "select * from enseignant";
          if(id!=0){
              req +=" where idenseignant="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Matiere c=new Matiere();
                   Enseignant cdt = new Enseignant();
                   cdt.setId(rset.getInt(1));
                   cdt.setMatiere(fonction.listeMatiere(rset.getInt(2)).get(0));
                   cdt.setNom(rset.getString(3));
                   cdt.setPrenom(rset.getString(4));
                   cdt.setLogin(rset.getString(5));
                   cdt.setMdp(rset.getString(6));
                   cdt.setClasse(fonction.listeClasseEnseignant(rset.getInt(1)));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    public List<Enseignant> listerClasseEnseignant(Connection con,Statement stat,ResultSet rset,int classe){
        String req;
        List<Enseignant> resultat = new ArrayList<Enseignant>();
          req= "SELECT e.IDENSEIGNANT, e.IDMATIERE, e.NOM, e.PRENOM, e.LOGIN, e.MOTDEPASSE FROM enseignant e join enseignantclasse ec on ec.IDENSEIGNANT=e.IDENSEIGNANT where ec.idClasse="+classe;
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Matiere c=new Matiere();
                   Enseignant cdt = new Enseignant();
                   cdt.setId(rset.getInt(1));
                   cdt.setMatiere(fonction.listeMatiere(rset.getInt(2)).get(0));
                   cdt.setNom(rset.getString(3));
                   cdt.setPrenom(rset.getString(4));
                   cdt.setLogin(rset.getString(5));
                   cdt.setMdp(rset.getString(6));
                   cdt.setClasse(fonction.listeClasseEnseignant(rset.getInt(1)));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
    }
}
