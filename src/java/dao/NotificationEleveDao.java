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
import modele.Etudiant;
import modele.Matiere;
import modele.NotificationEleve;
import util.Fonction;

/**
 *
 * @author Utilisateur
 */
public class NotificationEleveDao {

    Fonction fonction = new Fonction();

    public int insererNotificationEleve(NotificationEleve et, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        int a = 0;
        try {
            String req = "INSERT INTO notificationeleve(idEleve, idDevoir,notification)\n"
                    + "    VALUES (" + et.getIdEtudiant().getId() + "," + et.getDevoir().getId() + ",1)";
            System.out.println("req" + req);
            a = stat.executeUpdate(req);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }

        return a;
    }

    public List<NotificationEleve> listeNotifDevoirEleve(Connection con, Statement stat, ResultSet rset, int idEleve) {
        String req;
        List<NotificationEleve> resultat = new ArrayList<NotificationEleve>();
        req = "select n.idEleve, d.commentaire, m.nommatiere, d.dateEntrer, d.dateCorrection,n.notification,d.pdfurl,n.idDevoir,d.idclasse,d.idenseignant from notificationeleve n\n"
                + "join devoir d on d.idDevoir=n.idDevoir\n"
                + "join matiere m on m.idMatiere=d.libele\n"
                + "where n.idEleve='" + idEleve + "' order by d.dateEntrer desc";

        System.out.println("req =" + req);
        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                Devoir d = new Devoir();
                Matiere m = new Matiere();
                NotificationEleve n = new NotificationEleve();
                Etudiant e = new Etudiant();

                e.setId(rset.getInt(1));
                m.setNomMatiere(rset.getString(3));

                d.setCommentaire(rset.getString(2));
                d.setDateEntrer(rset.getString(4));
                d.setDateCorrection(rset.getString(5));
                d.setPdfUrl(rset.getString(7));
                d.setId(rset.getInt(8));
                d.setIdClasse(fonction.listeClasse(rset.getInt(9)).get(0));
                d.setIdEnseignant(fonction.listeEnseignant(rset.getInt(10), 0).get(0));
                d.setLibele(m);

                n.setIdEtudiant(e);
                n.setDevoir(d);
                n.setNomMatiere(m);
                n.setNotification(rset.getInt(6));

                resultat.add(n);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public void UpdateNotificationDevoir(int idDevoir, int idEleve, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        try {
            String req = "UPDATE notificationeleve set notification=0 where idEleve=" + idEleve + " and idDevoir=" + idDevoir + " ";

            System.out.println("req" + req);
            int a = stat.executeUpdate(req);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }

    }

    public int nbDevoirNonLusEleve(int idEleve, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        int nbDevoirNonLus = 0;

        String req = "select count(notification) as nbDevoirNonLus from notificationeleve where idEleve=" + idEleve + " and notification=1";
        System.out.println("req" + req);
        try {
            rSetIdGenerees = stat.executeQuery(req);
            while (rSetIdGenerees.next()) {
                nbDevoirNonLus = rSetIdGenerees.getInt(1);
            }

            System.out.println("wawa count " + nbDevoirNonLus);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }

        return nbDevoirNonLus;
    }

}
