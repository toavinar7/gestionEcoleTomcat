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
import modele.Devoir;
import util.Fonction;

/**
 *
 * @author Rova
 */
public class DevoirDao {
    Fonction fonction=new Fonction();
     
    public List<Devoir> listeDevoir(Connection con,Statement stat,ResultSet rset,int id,int idEnseignant){
        String req;
        List<Devoir> resultat = new ArrayList<Devoir>();
          req=  "select * from devoir";
          if(id!=0){
              req +=" where iddevoir="+id;
          }
          if(idEnseignant!=0){
              req +=" where IDENSEIGNANT="+idEnseignant;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
              
               while(rset.next()){
                 
                   Devoir devoir = new Devoir();
                   devoir.setId(rset.getInt(1));              
                   devoir.setIdClasse(fonction.listeClasse(rset.getInt(2)).get(0));       
                   devoir.setIdEnseignant(fonction.listeEnseignant(rset.getInt(3),0).get(0) );
                   devoir.setCommentaire(rset.getString(4));                    
                   devoir.setLibele(fonction.listeMatiere(rset.getInt(5)).get(0));                    
                   devoir.setPdfUrl(rset.getString(6));                    
                   devoir.setDateEntrer(rset.getString(7));                   
                   devoir.setDateCorrection(rset.getString(8));                                        
                   resultat.add(devoir);
                  
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    public List<Devoir> listeDevoirClasse(Connection con,Statement stat,ResultSet rset,int idClasse,int idEnseignant){
        String req;
        List<Devoir> resultat = new ArrayList<Devoir>();
          req=  "select * from devoir where idclasse= "+idClasse+" and idenseignant="+idEnseignant;
          try{ 
               rset=stat.executeQuery(req);
              
               while(rset.next()){
                 
                   Devoir devoir = new Devoir();
                   devoir.setId(rset.getInt(1));              
                   devoir.setIdClasse(fonction.listeClasse(rset.getInt(2)).get(0));                    
                   devoir.setCommentaire(rset.getString(4));                    
                   devoir.setLibele(fonction.listeMatiere(rset.getInt(5)).get(0));                    
                   devoir.setPdfUrl(rset.getString(6));                    
                   devoir.setDateEntrer(rset.getString(7));                   
                   devoir.setDateCorrection(rset.getString(8));                                        
                   resultat.add(devoir);
                  
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
   
    public int insererDevoir(Devoir devoir, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idDevoir=0;
            String sqlID = "select * from devoir order by idDevoir";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idDevoir=rSetIdGenerees.getInt(1);
            }
            idMessage = idDevoir + 1;
             String req="INSERT INTO devoir(IDDEVOIR, IDCLASSE, IDENSEIGNANT, COMMENTAIRE, LIBELE,PDFURL,DATEENTRER,DATECORRECTION)\n" +
                    "    VALUES ("+idMessage+",'"+devoir.getIdClasse().getId()+"',"+devoir.getIdEnseignant().getId()+",'"+devoir.getCommentaire()+"','"+devoir.getLibele().getId()+"','"+devoir.getPdfUrl()+"','"+devoir.getDateEntrer()+"','"+devoir.getDateCorrection()+"' )";
            System.out.println("req"+req);
           int a = stat.executeUpdate(req);
        }
        catch(Exception e){
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
        devoir.setId(idMessage);
       
         
            
        return idMessage;
    }
    
    public List<Devoir> detailDevoir(Connection con,Statement stat,ResultSet rset,int idDevoir){
        String req;
        List<Devoir> resultat = new ArrayList<Devoir>();
          req=  "select * from devoir where IDDEVOIR= "+idDevoir+" ";
          try{ 
               rset=stat.executeQuery(req);
              
               while(rset.next()){
                 
                   Devoir devoir = new Devoir();
                   
                   devoir.setId(rset.getInt(1));              
                   devoir.setIdClasse(fonction.listeClasse(rset.getInt(2)).get(0));           
                   devoir.setIdEnseignant(fonction.listeEnseignant(rset.getInt(3),0).get(0) );
                   devoir.setCommentaire(rset.getString(4));                    
                   devoir.setLibele(fonction.listeMatiere(rset.getInt(5)).get(0));                    
                   devoir.setPdfUrl(rset.getString(6));                    
                   devoir.setDateEntrer(rset.getString(7));                   
                   devoir.setDateCorrection(rset.getString(8));                                        
                   resultat.add(devoir);
                  
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
  
}
