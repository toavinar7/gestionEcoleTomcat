/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.AdminDao;
import dao.BaseDao;
import dao.ClasseDao;
import dao.CommentDao;
import dao.DevoirDao;
import dao.EmploidutempDAO;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.ForumDao;
import dao.HeureMatiereDao;
import dao.MatiereDao;
import dao.MessageDao;
import dao.NotificationEleveDao;
import dao.ParentDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Admin;
import modele.BaseModele;
import modele.Classe;
import modele.Commentaire;
import modele.Devoir;
import modele.EmploiDuTemp;
import modele.Enseignant;
import modele.Etudiant;
import modele.Forum;
import modele.HeureMatiere;
import modele.Matiere;
import modele.Message;
import modele.NotificationEleve;
import modele.Parent;

/**
 *
 * @author nat
 */
public class Fonction {

    private Connection conn;
    private Statement stat;
    private ResultSet rset;

    public int insertAdmin(Admin admin) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idAdmin = 0;
        AdminDao adao = new AdminDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idAdmin = adao.insererAdmin(admin, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idAdmin;
    }

    public int insertClasse(String nom) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idClasse = 0;
        ClasseDao cldao = new ClasseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idClasse = cldao.insererClasse(nom, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idClasse;
    }
    public int insertEmploiDuTemp(String nom) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idEploi = 0;
        EmploidutempDAO empdao = new EmploidutempDAO();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idEploi = empdao.insererEmploiDuTemp(nom, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idEploi;
    }

    public int insertMatiere(String nom) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idMatiere = 0;
        MatiereDao cldao = new MatiereDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatiere = cldao.insererMatiere(nom, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idMatiere;
    }

    public List<Classe> listeClasse(int id) throws SQLException {
        List<Classe> lister = new ArrayList<Classe>();
        ClasseDao req = new ClasseDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerClasse(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
    public List<Classe> listeClasseEnseignant(int idEns) throws SQLException {
        List<Classe> lister = new ArrayList<Classe>();
        ClasseDao req = new ClasseDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerClasseEnseignant(conn, stat, rset, idEns);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public List<HeureMatiere> listeheureMatiere(int id, int idclasse, int idEmploi,int idEns) throws SQLException {
        List<HeureMatiere> lister = new ArrayList<HeureMatiere>();
        HeureMatiereDao req = new HeureMatiereDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerHeureMatiere(conn, stat, rset, id, idclasse, idEmploi,idEns);

        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public List<EmploiDuTemp> listeEmploidutemp(int id) throws SQLException {
        List<EmploiDuTemp> lister = new ArrayList<EmploiDuTemp>();
        EmploidutempDAO req = new EmploidutempDAO();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerEmploidutemp(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public List<Matiere> listeMatiere(int id) throws SQLException {
        List<Matiere> lister = new ArrayList<Matiere>();
        MatiereDao req = new MatiereDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerMatiere(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

   /* public List<Note> listeNote(int id) throws SQLException {
        List<Note> lister = new ArrayList<Note>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerNote(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }*/

    public int insertEtudiant(int idcls,String nom,String prenom,String im) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        EtudiantDao adao = new EtudiantDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererEtudiant(idcls, nom, prenom, im, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }

    public int insererEnseignant(int idMatiere,String nom,String prenom,String login,String mdp) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        EnseignantDao adao = new EnseignantDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererEnseignant(idMatiere,nom,prenom,login,mdp, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }
    public int insererEnseignantClasse(int idEns,int idClasse) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        EnseignantDao adao = new EnseignantDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererEnseignantClasse(idEns,idClasse, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }
    public int insererEnseignantMat(int idEns,int idmat) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        EnseignantDao adao = new EnseignantDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererEnseignantMatiere(idEns,idmat, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }

    public List<Etudiant> listeEtudiant(int id, String im, int idClasse) throws SQLException {
        List<Etudiant> lister = new ArrayList<Etudiant>();
        EtudiantDao req = new EtudiantDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerEtudiant(conn, stat, rset, id, im, idClasse);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public List<Enseignant> listeEnseignant(int id,int idclasse) throws SQLException {
        List<Enseignant> lister = new ArrayList<Enseignant>();
        List<Enseignant> retour = new ArrayList<Enseignant>();
        EnseignantDao req = new EnseignantDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            //lister = 
            if(idclasse!=0){
                retour=req.listerClasseEnseignant(conn, stat, rset, idclasse);
            }
            else{
                retour=req.listerEnseignant(conn, stat, rset, id);
            }
            
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retour;
    }

    
    public List<Admin> listeAdmin(int id) throws SQLException {
        List<Admin> lister = new ArrayList<Admin>();
        AdminDao req = new AdminDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerAdmin(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public int insertPArent(String nom,String prenom,String type,String login,String mdp) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        ParentDao adao = new ParentDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererParent(nom,prenom,type,login,mdp, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }

    public int insertParentEleve(int idEleve, int idparent) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        ParentDao adao = new ParentDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererParentEleve(idEleve, idparent, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }

    public List<Parent> listeParent(int id) throws SQLException {
        List<Parent> lister = new ArrayList<Parent>();
        ParentDao req = new ParentDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerParent(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public List<Parent> listeParentClasse(int idClasse) throws SQLException {
        List<Parent> lister = new ArrayList<Parent>();
        List<Parent> listerep = new ArrayList<Parent>();
        ParentDao req = new ParentDao();
        BaseDao basedao = new BaseDao();
        try {
            lister = this.listeParent(0);
            for(int i=0;i<lister.size();i++){
                for(int j=0;j<lister.get(i).getEleve().size();j++){
                    if((lister.get(i).getEleve().get(j).getClasse().getId())==idClasse){
                        listerep.add(lister.get(i));
                    }
                }
            }
        } catch (Exception e) {
        }

        return listerep;
    }

    public boolean verificationMatricule(String im) throws SQLException {
        List<Etudiant> le = new ArrayList<Etudiant>();
        le = this.listeEtudiant(0, null, 0);
        for (int i = 0; i < le.size(); i++) {
            if ((le.get(i).getImatricule()).equalsIgnoreCase(im)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificationType(int idEtudiant) throws SQLException {

        EtudiantDao req = new EtudiantDao();
        BaseDao basedao = new BaseDao();
        int nombre = 0;
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            nombre = req.comptEtudiantParent(conn, stat, rset, idEtudiant);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        if (nombre != 0) {
            return true;
        }

        return false;
    }

    public Etudiant findEtudiant(String login, String pass) throws SQLException, Exception {
        List<Etudiant> us = new ArrayList<Etudiant>();
        us = this.listeEtudiant(0, null, 0);
        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getLogin().equals(login) && us.get(i).getMdp().equals(pass)) {
                return us.get(i);
            }
        }
        return null;
    }

    public Parent findParent(String login, String pass) throws SQLException, Exception {
        List<Parent> us = new ArrayList<Parent>();
        us = this.listeParent(0);
        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getLogin().equals(login) && us.get(i).getMdp().equals(pass)) {
                return us.get(i);
            }
        }
        return null;
    }
    public Admin findAdmin(String login, String pass) throws SQLException, Exception {
        List<Admin> us = new ArrayList<Admin>();
        us = this.listeAdmin(0);
        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getLogin().equals(login) && us.get(i).getMdp().equals(pass)) {
                return us.get(i);
            }
        }
        return null;
    }

    public Enseignant findEnseignant(String login, String pass) throws SQLException, Exception {
        List<Enseignant> us = new ArrayList<Enseignant>();
        us = this.listeEnseignant(0,0);
        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getLogin().equals(login) && us.get(i).getMdp().equals(pass)) {
                return us.get(i);
            }
        }
        return null;
    }

    public int insererDevoir(Devoir devoir) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idDevoir = 0;
        DevoirDao adao = new DevoirDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idDevoir = adao.insererDevoir(devoir, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idDevoir;
    }

    public List<Devoir> listeDevoir(int id,int idEnseignant) throws SQLException {
        List<Devoir> lister = new ArrayList<Devoir>();
        DevoirDao req = new DevoirDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeDevoir(conn, stat, rset, id,idEnseignant);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
    public List<Devoir> listeDevoirClasse(int idClasse,int idEnseignant) throws SQLException {
        List<Devoir> lister = new ArrayList<Devoir>();
        DevoirDao req = new DevoirDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeDevoirClasse(conn, stat, rset, idClasse,idEnseignant);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public int insererNotificationEleve(NotificationEleve et) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idNotification = 0;
        NotificationEleveDao adao = new NotificationEleveDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idNotification = adao.insererNotificationEleve(et, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idNotification;
    }

    public List<NotificationEleve> listeNotifDevoirEleve(int idEleve) throws SQLException {
        List<NotificationEleve> lister = new ArrayList<NotificationEleve>();
        NotificationEleveDao req = new NotificationEleveDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeNotifDevoirEleve(conn, stat, rset, idEleve);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }

    public float moyennee(float note1, float note2, float exam) {
        return (note1 + note2 + exam) / 3;
    }

    public String insererMatiereEmploi(int idClasse, int idEmploi, int idEnseignant, String jour, int hdebut, int hfin) throws SQLException {
        BaseDao basedao = new BaseDao();
        HeureMatiereDao adao = new HeureMatiereDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            List<HeureMatiere> lister = new ArrayList<HeureMatiere>();
            lister = this.listeheureMatiere(0, 0, 0,0);
            List<HeureMatiere> lister2 = new ArrayList<HeureMatiere>();
            lister2 = this.listeheureMatiere(0,idClasse, 0,0);
            if (hdebut < hfin) {
                int comp = 0;
                int comp2 = 0;
                for (int i = 0; i < lister.size(); i++) {
                    if (lister.get(i).getEnseignant().getId() == idEnseignant) {
                        if (lister.get(i).getJour().equalsIgnoreCase(jour)) {
                            for (int j = hdebut; j < hfin; j++) {
                                if (lister.get(i).getHeuredebut().equalsIgnoreCase(j + "h")) {
                                    comp++;
                                }
                            }
                        }
                    }

                }
                for (int i = 0; i < lister2.size(); i++) {
                        if (lister2.get(i).getJour().equalsIgnoreCase(jour)) {
                            for (int j = hdebut; j < hfin; j++) {
                                if (lister2.get(i).getHeuredebut().equalsIgnoreCase(j + "h")) {
                                    comp2++;
                                }
                            }
                        }

                }
                if (comp2 != 0) {
                    return "cette horaire est déjà occupé";
                }
                if (comp != 0) {
                    return "cette prof a deja travailler a cet heure";
                }
                conn = basedao.getConn();
                stat = conn.createStatement();
                for (int i = hdebut; i < hfin; i++) {
                    adao.insererHeureMatiere(idClasse, idEmploi, idEnseignant, jour, i + "h", (i + 1) + "h", stat, conn, rset);
                }

            } else {
                return "erreur de l'heure";
            }

        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return "reussite";
    }
    
     public void UpdateDevoir(int idDevoir,int idEleve) throws SQLException {
        BaseDao basedao = new BaseDao();
        
        NotificationEleveDao adao = new NotificationEleveDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            adao.UpdateNotificationDevoir(idDevoir,idEleve, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
    }
     
    public int nbDevoirNonLusEleve(int idEleve) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idNotification = 0;
        NotificationEleveDao adao = new NotificationEleveDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idNotification = adao.nbDevoirNonLusEleve(idEleve, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idNotification;
    }
    public List<Etudiant> listeEtudiantParen(int idParent) throws SQLException {
        List<Etudiant> lister = new ArrayList<Etudiant>();
        EtudiantDao req = new EtudiantDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerEtudiantParent(conn, stat, rset, idParent);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
     public List<Devoir> detailDevoirEtudiant(int idDevoir) throws SQLException {
        List<Devoir> lister = new ArrayList<Devoir>();
        DevoirDao req = new DevoirDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.detailDevoir(conn, stat, rset, idDevoir);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
    public String splitCaractere(String nom ){              
        return nom.replace(" ", "-");
    }
    public int insertForum(String personne, int idpersonne,String sujet) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        ForumDao adao = new ForumDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererForum(personne, idpersonne, sujet, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }

    public List<Forum> listeForum(int id) throws SQLException {
        List<Forum> lister = new ArrayList<Forum>();
        ForumDao req = new ForumDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerForum(conn, stat, rset, id);
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
    public int insertComment(String personne, int idpersonne,String comment,int idForum) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idet = 0;
        CommentDao adao = new CommentDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.insererComment(personne, idpersonne, comment,idForum, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }

    public List<Commentaire> listeComment(int idComment,int idForum) throws SQLException {
        List<Commentaire> lister = new ArrayList<Commentaire>();
        CommentDao req = new CommentDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerCommentaire(conn, stat, rset,idComment,idForum );
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
    public int insererMessage(String persEnv,int idPersEnv,String persCt,int idPersCt,String msg) throws SQLException{
        BaseDao basedao = new BaseDao();
        int idet = 0;
        MessageDao adao = new MessageDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idet = adao.envoiMessage(persEnv, idPersEnv, persCt,idPersCt,msg, stat, conn, rset);
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return idet;
    }
    public List<Message> listeConversation(int idpersEnv,String persEnv,int idPersCnt,String persCnt) throws SQLException {
        List<Message> lister = new ArrayList<Message>();
        MessageDao req = new MessageDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerConvesation(conn, stat, rset,idpersEnv,persEnv,idPersCnt,persCnt );
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
     public List<Message> listeBoitMsg(int idpersEnv,String persEnv,String typeMsg) throws SQLException {
        List<Message> lister = new ArrayList<Message>();
        MessageDao req = new MessageDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerBoitMsg(conn, stat, rset,idpersEnv,persEnv,typeMsg );
        } catch (Exception e) {
        } finally {

            if (rset != null) {
                rset.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return lister;
    }
     public String updateet(int idet,String login,String mdpanc,String mdpnew,String mdpconf) throws SQLException {
        BaseDao basedao = new BaseDao();
        EtudiantDao adao = new EtudiantDao();
        Etudiant lister = new Etudiant();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister=this.listeEtudiant(idet,null,0).get(0);
            if(lister.getMdp().equals(mdpanc)){
                if(mdpnew.equals(mdpconf)){
                    conn = basedao.getConn();
                    stat = conn.createStatement();
                    adao.updateEtudiant(idet, login, mdpnew, stat, conn, rset);
                    return "Modification reussite";
                }
                else{
                    return "Erreur sur confirmation mot de passe";
                }
            }
            else{
                return "Erreur de mot de passe";
            }
            
        } catch (Exception e) {
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    
    

}
