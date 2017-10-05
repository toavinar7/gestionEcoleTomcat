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
import modele.Parent;
import util.Fonction;

/**
 *
 * @author nat
 */
public class ParentDao {
     Fonction fonction=new Fonction();
    public int insererParent(String nom,String prenom,String type,String login,String mdp, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idparent=0;
            String sqlID = "select * from parent";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idparent=rSetIdGenerees.getInt(1);
            }
            idMessage = idparent + 1;
            //`parent`(`IDPARENT`, `IDELEVE`, `NOM`, `PRENOM`, `TYPE`, `LOGIN`, `MOTDEPASSE`) 
             String req="INSERT INTO parent(IDPARENT,NOM,PRENOM,TYPE,LOGIN,MOTDEPASSE)\n" +
                    "    VALUES ("+idMessage+",'"+nom+"','"+prenom+"','"+type+"','"+login+"','"+mdp+"')";
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
    public int insererParentEleve(int idEleve,int idParent, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idparent=0;
            String sqlID = "select * from parenteleves";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idparent=rSetIdGenerees.getInt(1);
            }
            idMessage = idparent + 1;
            //`parent`(`IDPARENT`, `IDELEVE`, `NOM`, `PRENOM`, `TYPE`, `LOGIN`, `MOTDEPASSE`) 
             String req="INSERT INTO parenteleves(IDPARENTELEVES,IDPARENT,IDELEVE)\n" +
                    "    VALUES ("+idMessage+","+idParent+","+idEleve+")";
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
    public List<Parent> listerParent(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        List<Parent> resultat = new ArrayList<Parent>();
          req=  "select * from parent";
          if(id!=0){
              req +=" where idparent="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Parent cdt = new Parent();
                   cdt.setId(rset.getInt(1));
                   cdt.setNom(rset.getString(2));
                   cdt.setPrenom(rset.getString(3));
                   cdt.setType(rset.getString(4));
                   cdt.setLogin(rset.getString(5));
                   cdt.setMdp(rset.getString(6));
                   cdt.setEleve(fonction.listeEtudiantParen(rset.getInt(1)));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
}
