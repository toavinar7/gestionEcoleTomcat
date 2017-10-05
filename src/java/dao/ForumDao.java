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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modele.Forum;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
public class ForumDao {
    Fonction fonction=new Fonction();
    public int insererForum(String personne,int idpersonne,String sujet, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
            String dateAujourdhui="";
            dateAujourdhui = sdf.format(new java.util.Date());
            
            int idforum=0;
            String sqlID = "select * from forum";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idforum=rSetIdGenerees.getInt(1);
            }
            idMessage = idforum + 1;
             String req="INSERT INTO forum(idForum, sujet, idPersonne, typePersonne,dateForum)\n" +
                    "    VALUES ("+idMessage+",'"+sujet+"',"+idpersonne+",'"+personne+"','"+dateAujourdhui+"')";
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
    public List<Forum> listerForum(Connection con,Statement stat,ResultSet rset,int idForum){
        String req;
        List<Forum> resultat = new ArrayList<Forum>();
          req=  "select * from forum";
          if(idForum!=0){
              req +=" where idForum="+idForum;
          }
          req+=" ORDER BY idForum DESC";
          
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Forum cdt = new Forum();
                   cdt.setId(rset.getInt(1));
                   cdt.setSujet(rset.getString(2));
                   cdt.setIdPersonne(rset.getInt(3));
                   cdt.setTypePersonne(rset.getString(4));
                   cdt.setDateForm(rset.getString(5));
                   if(cdt.getTypePersonne().equalsIgnoreCase("admin")){
                       cdt.setAdm(fonction.listeAdmin(cdt.getIdPersonne()).get(0));
                   }
                   else if(cdt.getTypePersonne().equalsIgnoreCase("etudiant")){
                       cdt.setEtud(fonction.listeEtudiant(cdt.getIdPersonne(),null,0).get(0));
                   }
                   else if(cdt.getTypePersonne().equalsIgnoreCase("enseignant")){
                       cdt.setEns(fonction.listeEnseignant(cdt.getIdPersonne(),0).get(0));
                   }
                   else if(cdt.getTypePersonne().equalsIgnoreCase("parent")){
                       cdt.setPart(fonction.listeParent(cdt.getIdPersonne()).get(0));
                   }
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
}
