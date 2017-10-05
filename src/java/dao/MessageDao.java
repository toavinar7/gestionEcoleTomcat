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
import modele.Message;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
public class MessageDao {
    Fonction fonction=new Fonction();
    public int envoiMessage(String personneEnvoi,int idpersonneEnvoi,String personneCont,int idpersonneCont,String message, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
         int idMessage = 0;
        try{
            
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
            String dateAujourdhui="";
            dateAujourdhui = sdf.format(new java.util.Date());
            
            int idms=0;
            String sqlID = "select * from message";
            rSetIdGenerees= stat.executeQuery(sqlID);
            while(rSetIdGenerees.next())
            {
                 idms=rSetIdGenerees.getInt(1);
            }
            idMessage = idms + 1;
             String req="INSERT INTO message(idMessage, corpMessage, dateMessage)\n" +
                    "    VALUES ("+idMessage+",'"+message+"','"+dateAujourdhui+"')";
            
            String reqenv="INSERT INTO boitemessage(idMessage, idPersonne, typePersonne,idContact,typeContact,typeMessage)\n" +
                    "    VALUES ("+idMessage+","+idpersonneEnvoi+",'"+personneEnvoi+"',"+idpersonneCont+",'"+personneCont+"','ENVOYE')";
            
            String reqRec="INSERT INTO boitemessage(idMessage, idPersonne, typePersonne,idContact,typeContact,typeMessage)\n" +
                    "    VALUES ("+idMessage+","+idpersonneCont+",'"+personneCont+"',"+idpersonneEnvoi+",'"+personneEnvoi+"','RECEP')";
            
           int a = stat.executeUpdate(req);
           int b = stat.executeUpdate(reqenv);
           int c = stat.executeUpdate(reqRec);
        }
        catch(Exception e){
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
         
            
        return idMessage;
    }
     public List<Message> listerConvesation(Connection con,Statement stat,ResultSet rset,int idPersEnv,String typePersEnv,int idPersCont,String typePersCont){
        String req;
        List<Message> resultat = new ArrayList<Message>();
          req=  "select m.idMessage,m.corpMessage,m.dateMessage,mb.idboiteMessage,mb.idPersonne, mb.typePersonne, mb.idContact, mb.typeContact, \n" +
                "mb.typeMessage  from message m join boitemessage mb on m.idMessage=mb.idMessage "+
                " where mb.idPersonne="+idPersEnv+" and mb.typePersonne='"+typePersEnv+"' and mb.idContact="+idPersCont+" and mb.typeContact='"+typePersCont+"' ORDER BY m.idMessage ASC ";
          
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Message cdt = new Message();
                   cdt.setId(rset.getInt(4));
                   cdt.setMessage(rset.getString(2));
                   cdt.setIdPersonne(rset.getInt(5));
                   cdt.setTypePersonne(rset.getString(6));
                   cdt.setDateMessage(rset.getString(3));
                   cdt.setIdPersonneCont(rset.getInt(7));
                   cdt.setTypePersonneCont(rset.getString(8));
                   cdt.setTypeMessage(rset.getString(9));
                   if(cdt.getTypePersonne().equalsIgnoreCase("admin")){
                       cdt.setAdm(fonction.listeAdmin(cdt.getIdPersonne()).get(0));
                   }
                   if(cdt.getTypePersonne().equalsIgnoreCase("etudiant")){
                       cdt.setEtud(fonction.listeEtudiant(cdt.getIdPersonne(),null,0).get(0));
                   }
                   if(cdt.getTypePersonne().equalsIgnoreCase("enseignant")){
                       cdt.setEns(fonction.listeEnseignant(cdt.getIdPersonne(),0).get(0));
                   }
                   if(cdt.getTypePersonne().equalsIgnoreCase("parent")){
                       cdt.setPart(fonction.listeParent(cdt.getIdPersonne()).get(0));
                   }
                   
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("admin")){
                       cdt.setAdmCt(fonction.listeAdmin(cdt.getIdPersonneCont()).get(0));
                   }
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("etudiant")){
                       cdt.setEtudCt(fonction.listeEtudiant(cdt.getIdPersonneCont(),null,0).get(0));
                   }
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("enseignant")){
                       cdt.setEnsCt(fonction.listeEnseignant(cdt.getIdPersonneCont(),0).get(0));
                   }
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("parent")){
                       cdt.setPartCt(fonction.listeParent(cdt.getIdPersonneCont()).get(0));
                   }
                   
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
     public List<Message> listerBoitMsg(Connection con,Statement stat,ResultSet rset,int idPersEnv,String typePersEnv,String typeMess){
        String req;
        List<Message> resultat = new ArrayList<Message>();
          req=  "select m.idMessage,m.corpMessage,m.dateMessage,mb.idboiteMessage,mb.idPersonne, mb.typePersonne, mb.idContact, mb.typeContact, \n" +
                "mb.typeMessage  from message m join boitemessage mb on m.idMessage=mb.idMessage "+
                " where mb.idPersonne="+idPersEnv+" and mb.typePersonne='"+typePersEnv+"' and mb.typeMessage='"+typeMess+"' ORDER BY m.idMessage DESC ";
          
          try{ 
               rset=stat.executeQuery(req);
               while(rset.next()){
                   Message cdt = new Message();
                   cdt.setId(rset.getInt(4));
                   cdt.setMessage(rset.getString(2));
                   cdt.setIdPersonne(rset.getInt(5));
                   cdt.setTypePersonne(rset.getString(6));
                   cdt.setDateMessage(rset.getString(3));
                   cdt.setIdPersonneCont(rset.getInt(7));
                   cdt.setTypePersonneCont(rset.getString(8));
                   cdt.setTypeMessage(rset.getString(9));
                   if(cdt.getTypePersonne().equalsIgnoreCase("admin")){
                       cdt.setAdm(fonction.listeAdmin(cdt.getIdPersonne()).get(0));
                   }
                   if(cdt.getTypePersonne().equalsIgnoreCase("etudiant")){
                       cdt.setEtud(fonction.listeEtudiant(cdt.getIdPersonne(),null,0).get(0));
                   }
                   if(cdt.getTypePersonne().equalsIgnoreCase("enseignant")){
                       cdt.setEns(fonction.listeEnseignant(cdt.getIdPersonne(),0).get(0));
                   }
                   if(cdt.getTypePersonne().equalsIgnoreCase("parent")){
                       cdt.setPart(fonction.listeParent(cdt.getIdPersonne()).get(0));
                   }
                   
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("admin")){
                       cdt.setAdmCt(fonction.listeAdmin(cdt.getIdPersonneCont()).get(0));
                   }
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("etudiant")){
                       cdt.setEtudCt(fonction.listeEtudiant(cdt.getIdPersonneCont(),null,0).get(0));
                   }
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("enseignant")){
                       cdt.setEnsCt(fonction.listeEnseignant(cdt.getIdPersonneCont(),0).get(0));
                   }
                   if(cdt.getTypePersonneCont().equalsIgnoreCase("parent")){
                       cdt.setPartCt(fonction.listeParent(cdt.getIdPersonneCont()).get(0));
                   }
                   
                   resultat.add(cdt);
                }      
         }
        catch(Exception e){
        } 
      return resultat; 
     }
}
