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
import util.Fonction;
/**
 *
 * @author nat
 */
public class ClasseDao {
    Fonction fonction=new Fonction();
    public int insererClasse(String nomClasse, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idclasse=0;
            String sqlID = "select * from classe";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idclasse=rSetIdGenerees.getInt(1);
            }
            idMessage = idclasse + 1;
             String req="INSERT INTO classe(idclasse, nomclasse)\n" +
                    "    VALUES ("+idMessage+",'"+nomClasse+"')";
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
    public List<Classe> listerClasse(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        List<Classe> resultat = new ArrayList<Classe>();
          req=  "select * from classe";
          if(id!=0){
              req +=" where idclasse="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Classe cdt = new Classe();
                   cdt.setId(rset.getInt(1));
                   cdt.setNomClasse(rset.getString(2));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    public List<Classe> listerClasseEnseignant(Connection con,Statement stat,ResultSet rset,int idEns){
        String req;
        List<Classe> resultat = new ArrayList<Classe>();
          req=  "select c.idClasse,c.NOMCLASSE from classe c join enseignantclasse ec on ec.idClasse=c.idClasse where ec.IDENSEIGNANT="+idEns;
          
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Classe cdt = new Classe();
                   cdt.setId(rset.getInt(1));
                   cdt.setNomClasse(rset.getString(2));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
}
