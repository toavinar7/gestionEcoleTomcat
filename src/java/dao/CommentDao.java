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
import modele.Commentaire;
import modele.Forum;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
public class CommentDao {
    Fonction fonction=new Fonction();
    public int insererComment(String personne,int idpersonne,String comment,int idForum, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
            String dateAujourdhui="";
            dateAujourdhui = sdf.format(new java.util.Date());
            
            int idforum=0;
            String sqlID = "select * from commentaireforum";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idforum=rSetIdGenerees.getInt(1);
            }
            idMessage = idforum + 1;
             String req="INSERT INTO commentaireforum (idCommentaire, idPersonne, typePersonne, comment,idForum,dateCommment)\n" +
                    "    VALUES ("+idMessage+","+idpersonne+",'"+personne+"','"+comment+"',"+idForum+",'"+dateAujourdhui+"')";
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
    public List<Commentaire> listerCommentaire(Connection con,Statement stat,ResultSet rset,int idComment,int idForum){
        String req;
        List<Commentaire> resultat = new ArrayList<Commentaire>();
          req=  "select * from commentaireforum";
          if(idForum!=0){
              req +=" where idForum="+idForum;
          }
          if(idComment!=0){
              req +=" where idCommentaire="+idComment;
          }
          req+=" ORDER BY idCommentaire DESC";
          System.out.println("req commentaire = "+req);
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Commentaire cdt = new Commentaire();
                   cdt.setId(rset.getInt(1));
                   cdt.setComment(rset.getString(4));
                   cdt.setIdPersonne(rset.getInt(2));
                   cdt.setTypePersonne(rset.getString(3));
                   cdt.setIdForum(rset.getInt(5));
                   cdt.setDateComment(rset.getString(6));
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
