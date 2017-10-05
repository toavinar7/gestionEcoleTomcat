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
import modele.Semestre;
import util.FonctionNote;
/**
 *
 * @author toavina
 */
public class SemestreDao {
    
    FonctionNote fonctionNote=new FonctionNote();
      public List<Semestre> listerSemestre(Connection con,Statement stat,ResultSet rset,int id,int idClasse){
        String req;
        ArrayList<Semestre> resultat = new ArrayList<Semestre>();
          req=  "select * from semestre";
          if(id!=0){
              req +=" where idSemestre="+id;
          }
           if(idClasse!=0){
              req +=" where idClasse="+idClasse;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Semestre cdt = new Semestre();
                   cdt.setId(rset.getInt(1));
                   cdt.setNomSemestre(rset.getString(2));
                   cdt.setAnnee(rset.getString(3));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
          public List<Semestre> listerSemes(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        ArrayList<Semestre> resultat = new ArrayList<Semestre>();
          req=  "select * from semestre";
          if(id!=0){
              req +=" where idSemestre="+id;
          }
         
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Semestre cdt = new Semestre();
                   cdt.setId(rset.getInt(1));
                   cdt.setNomSemestre(rset.getString(2));
                   cdt.setAnnee(rset.getString(3));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    public int insererSemestre(String nomSemestre,int idClasse,String annee, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idmatiere=0;
            String sqlID = "select * from semestre";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idmatiere=rSetIdGenerees.getInt(1);
            }
            idMessage = idmatiere + 1;
             String req="INSERT INTO semestre(idSemestre, nomSemestre,idClasse,annee)\n" +
                    "    VALUES ("+idMessage+",'"+nomSemestre+"',"+idClasse+",'"+annee+"')";
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
