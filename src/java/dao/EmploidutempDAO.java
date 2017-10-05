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
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.EmploiDuTemp;

/**
 *
 * @author MAMPYUN
 */
public class EmploidutempDAO {
    public List<EmploiDuTemp> listerEmploidutemp(Connection con,Statement stat,ResultSet rset,int id){
          String req;
        List<EmploiDuTemp> resultat = new ArrayList<EmploiDuTemp>();
          req=  "select * from emploidutemps";
          if(id!=0){
              req +=" where idemploidutemp="+id;
          }
          System.out.println("req ="+req );
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   EmploiDuTemp cdt = new EmploiDuTemp();
                   cdt.setId(rset.getInt(1));
                   cdt.setNomEmployDuTemp(rset.getString(2));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
      public int insererEmploiDuTemp(String nom, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException {
         int idMessage = 0;
        try{
            int idclasse=0;
            String sqlID = "select * from emploidutemps";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idclasse=rSetIdGenerees.getInt(1);
            }
            idMessage = idclasse + 1;
             String req="INSERT INTO emploidutemps(IDEMPLOIDUTEMP, NOMEMLOIDUTEMP)\n" +
                    "    VALUES ("+idMessage+",'"+nom+"')";
            System.out.println("req"+req);
           int a = stat.executeUpdate(req);
        }
        catch(Exception e){
            e.printStackTrace();
            conn.rollback();
             try {
                 throw e;
             } catch (Exception ex) {
                 Logger.getLogger(EmploidutempDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         
            
        return idMessage;
    }
    
}
