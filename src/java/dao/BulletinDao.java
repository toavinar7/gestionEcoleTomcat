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
import util.Fonction;
import modele.Bulletin;
import modele.Classe;
import modele.Etudiant;
import modele.Semestre;
import util.FonctionNote;

/**
 *
 * @author toavina
 */
public class BulletinDao {
    
     Fonction fonction=new Fonction();
     FonctionNote fonctionNote=new FonctionNote();
    public int insererBulletin(int  etudiant,int classe,int semestre, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idclasse=0;
            String sqlID = "select * from BULLETIN";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idclasse=rSetIdGenerees.getInt(1);
            }
            idMessage = idclasse + 1;
             String req="INSERT INTO BULLETIN(IDBULLETIN, IDETUDIANT,IDCLASSE,IDSEMESTRE,TOALCOEF,MOYENNECOEF,CALCULCOEF,MOYENNE,MOYENNEDECLASSE,RANG,EFFECTIF,ETAT,DECISIONCONSEIL)\n" +
                    "    VALUES ("+idMessage+","+etudiant+","+classe+","+semestre+",'0','0','0','0','0','0','0','0','" + null + "')";
           // System.out.println("req"+req);
           int a = stat.executeUpdate(req);
        }
        catch(Exception e){
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
         
            
        return idMessage;
    } 
    public List<Bulletin>listeBulletin(int idBulletin,int idEtudiant,int idSemestre,Connection con,Statement stat,ResultSet rset){
          String req;
        ArrayList<Bulletin> resultat = new ArrayList<Bulletin>();
          req=  "select * from BULLETIN";
          if(idBulletin!=0){
              req +=" where IDBULLETIN="+idBulletin;
          }
           if(idEtudiant!=0){
              req +=" where IDETUDIANT="+idEtudiant;
          }
              if(idSemestre!=0){
              req +=" where IDSEMESTRE="+idSemestre;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Bulletin cdt = new Bulletin();
                   Etudiant etudiant=new Etudiant();
                   Classe classe=new Classe();
                   Semestre semestre=new Semestre();
                   cdt.setId(rset.getInt(1));
                   //fonction.listeMatiere(rset.getInt(2)).get(0)
                   cdt.setIdEtudiant(fonctionNote.listeEtudiant(rset.getInt(2)).get(0));
                   cdt.setIdClasse(fonction.listeClasse(rset.getInt(3)).get(0));
                   cdt.setIdSemestre(fonctionNote.listerSemes(rset.getInt(4)).get(0));
                   cdt.setTotalCoefficient(rset.getInt(5));
                   cdt.setMoyenneCoefficient(rset.getDouble(6));
                   cdt.setCalculCoefficient(rset.getInt(7));
                   cdt.setMoyenne(rset.getDouble(8));
                   cdt.setMoyenneClasse(rset.getDouble(9));
                   cdt.setRang(rset.getInt(10));
                   cdt.setEffectif(rset.getInt(11));
                   cdt.setEtat(rset.getInt(12));
                   cdt.setDecisionConseil(rset.getString(13));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
    }
     public List<Bulletin>listeBulletin1(int idBulletin,int idEtudiant,int idSemestre,Connection con,Statement stat,ResultSet rset){
          String req;
        ArrayList<Bulletin> resultat = new ArrayList<Bulletin>();
          req=  "select * from BULLETIN";
          if(idBulletin!=0){
              req +=" where IDBULLETIN="+idBulletin;
          }
           if(idEtudiant!=0){
              req +=" where IDETUDIANT="+idEtudiant;
          }
              if(idSemestre!=0){
              req +=" and IDSEMESTRE="+idSemestre;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Bulletin cdt = new Bulletin();
                   Etudiant etudiant=new Etudiant();
                   Classe classe=new Classe();
                   Semestre semestre=new Semestre();
                   cdt.setId(rset.getInt(1));
                   //fonction.listeMatiere(rset.getInt(2)).get(0)
                   cdt.setIdEtudiant(fonctionNote.listeEtudiant(rset.getInt(2)).get(0));
                   cdt.setIdClasse(fonction.listeClasse(rset.getInt(3)).get(0));
                   cdt.setIdSemestre(fonctionNote.listerSemes(rset.getInt(4)).get(0));
                   cdt.setTotalCoefficient(rset.getInt(5));
                   cdt.setMoyenneCoefficient(rset.getDouble(6));
                   cdt.setCalculCoefficient(rset.getInt(7));
                   cdt.setMoyenne(rset.getDouble(8));
                   cdt.setMoyenneClasse(rset.getDouble(9));
                   cdt.setRang(rset.getInt(10));
                   cdt.setEffectif(rset.getInt(11));
                   cdt.setEtat(rset.getInt(12));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
    }
    //TOALCOEF,MOYENNECOEF,CALCULCOEF,MOYENNE,MOYENNEDECLASSE,RANG,EFFECTIF,ETAT
    public void updateBulletin(int etudiant,int idSemestre,int totalCoefficient,double moyenneCoef,int calculCoef,double moyenne,double moyenneClasse
            ,int rang,int effectif,Connection con,Statement stat,ResultSet rset)throws SQLException, Exception {
        try {
            String req9 = "update BULLETIN set TOALCOEF=" + totalCoefficient + " ,MOYENNECOEF="+moyenneCoef+",CALCULCOEF="+calculCoef+",MOYENNE="+moyenne+",MOYENNEDECLASSE="+moyenneClasse+",RANG="+rang+",EFFECTIF="+effectif+", ETAT=1 where IDETUDIANT=" + etudiant+" AND IDSEMESTRE="+idSemestre+"";
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
            throw e;
        }
    }
      public void updateDecisonConseil(int idBulletin, String Conseil, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        try {
            String req9 = "update BULLETIN set ETAT=2 , DECISIONCONSEIL='" + Conseil + "' where IDBULLETIN=" + idBulletin;
            System.out.println("reqqqqwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww=="+req9);
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }
}
