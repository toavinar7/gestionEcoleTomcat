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
import modele.Etudiant;
import util.Fonction;
public class EtudiantDao {
    Fonction fonction=new Fonction();
    public int insererEtudiant(int idCls,String nom,String prenom,String im, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idetud=0;
            String sqlID = "select * from eleve";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idetud=rSetIdGenerees.getInt(1);
            }
            idMessage = idetud + 1;
            // `eleve`(`IDELEVE`, `IDCLASSE`, `NOM`, `PRENOM`, `IMATRICULE`, `LOGIN`, `MOTDEPASSE`) VALUES 
             String req="INSERT INTO eleve(IDELEVE, IDCLASSE,NOM,PRENOM,IMATRICULE,LOGIN,MOTDEPASSE)\n" +
                    "    VALUES ("+idMessage+","+idCls+",'"+nom+"','"+prenom+"','"+im+"','eleve"+idMessage+"','eleve"+idMessage+"')";
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
    public void updateEtudiant(int idet,String login,String mdp, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
             String req="update eleve set LOGIN='"+login+"', MOTDEPASSE = '"+mdp+"' where IDELEVE="+idet;
             System.out.println("req"+req);
           stat.executeUpdate(req);
        }
        catch(Exception e){
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }
    
    public List<Etudiant> listerEtudiant(Connection con,Statement stat,ResultSet rset,int id,String im,int idClasse){
        String req;
        List<Etudiant> resultat = new ArrayList<Etudiant>();
          req=  "select * from eleve";
          if(id!=0){
              req +=" where IDELEVE="+id;
          }
          if(im!=null){
              req +=" where IMATRICULE='"+im+"'";
          }
          if(idClasse!=0){
              req +=" where idClasse='"+idClasse+"'";
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Classe c=new Classe();
                   Etudiant cdt = new Etudiant();
                   cdt.setId(rset.getInt(1));
                   cdt.setClasse(fonction.listeClasse(rset.getInt(2)).get(0));
                   cdt.setNom(rset.getString(3));
                   cdt.setPrenom(rset.getString(4));
                   cdt.setImatricule(rset.getString(5));
                   cdt.setLogin(rset.getString(6));
                   cdt.setMdp(rset.getString(7));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
     public int comptEtudiantParent(Connection con,Statement stat,ResultSet rset,int idetudiant){
        String req;
        int resultat=0;
          req=  "select COUNT(*) from parenteleves where IDELEVE="+idetudiant;
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   resultat=rset.getInt(1);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
     public List<Etudiant> listerEtudiantParent(Connection con,Statement stat,ResultSet rset,int idParent){
        String req;
        List<Etudiant> resultat = new ArrayList<Etudiant>();
        //SELECT `IDELEVE`, `IDCLASSE`, `NOM`, `PRENOM`, `IMATRICULE`, `LOGIN`, `MOTDEPASSE` FROM `eleve` WHERE 1
          req=  "select e.IDELEVE,e.IDCLASSE,e.NOM,e.PRENOM,e.IMATRICULE,e.LOGIN,e.MOTDEPASSE from (eleve e join parenteleves pe on e.IDELEVE=pe.IDELEVE) join parent p on p.IDPARENT = pe.IDPARENT where p.IDPARENT="+idParent;
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Classe c=new Classe();
                   Etudiant cdt = new Etudiant();
                   cdt.setId(rset.getInt(1));
                   cdt.setClasse(fonction.listeClasse(rset.getInt(2)).get(0));
                   cdt.setNom(rset.getString(3));
                   cdt.setPrenom(rset.getString(4));
                   cdt.setImatricule(rset.getString(5));
                   cdt.setLogin(rset.getString(6));
                   cdt.setMdp(rset.getString(7));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
}
