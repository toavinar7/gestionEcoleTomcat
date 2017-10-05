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
import modele.Admin;
import util.Fonction;
/**
 *
 * @author nat
 */
public class AdminDao {
    Fonction fonction=new Fonction();
    public int insererAdmin(Admin admin, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            int idAdmin=0;
            String sqlID = "select * from admin";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idAdmin=rSetIdGenerees.getInt(1);
            }
            idMessage = idAdmin + 1;
             String req="INSERT INTO admin(idadmin, nom, prenom, login, motdepasse)\n" +
                    "    VALUES ("+idMessage+",'"+admin.getNom()+"','"+admin.getPrenom()+"','"+admin.getLogin()+"','"+admin.getMdp()+"')";
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
    
    public List<Admin> listerAdmin(Connection con,Statement stat,ResultSet rset,int id){
        String req;
        List<Admin> resultat = new ArrayList<Admin>();
          req=  "select * from admin";
          if(id!=0){
              req +=" where idAdmin="+id;
          }
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Admin cdt = new Admin();
                   cdt.setId(rset.getInt(1));
                   cdt.setNom(rset.getString(2));
                   cdt.setPrenom(rset.getString(3));
                   cdt.setLogin(rset.getString(4));
                   cdt.setMdp(rset.getString(5));
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
    
}
