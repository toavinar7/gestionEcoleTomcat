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
import modele.Coefficient;
import modele.Enseignant;
import modele.Etudiant;
import modele.Matiere;
import modele.NoteEleve;
import modele.Semestre;
import util.Fonction;
import util.FonctionNote;

/**
 *
 * @author nat
 */
public class NoteDao {

    Fonction fonction = new Fonction();
    FonctionNote fonctNote = new FonctionNote();

    public List<Etudiant> listerEtudiant(Connection con, Statement stat, ResultSet rset, int id) {
        String req;
        List<Etudiant> resultat = new ArrayList<Etudiant>();
        req = "select * from eleve";
        if (id != 0) {
            req += " where IDELEVE=" + id;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                Classe c = new Classe();
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
        } catch (Exception e) {
        }
        return resultat;
    }

    public List<Classe> listerClasseEnseigant(Connection con, Statement stat, ResultSet rset, int idEnseignant) {
        String req;
        List<Classe> resultat = new ArrayList<Classe>();
        req = "SELECT c.idclasse ,c.nomclasse,e.idenseignant,e.nom,e.PRENOM,m.idMatiere , m.nommatiere FROM classe c join classematiere esM on c.IDCLASSE=esM.idClasse join matiere m on m.IDMATIERE=esM.idMatiere JOIN enseignant e on e.IDMATIERE=esM.idMatiere  ";
        if (idEnseignant != 0) {
            req += " where e.idenseignant=" + idEnseignant;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                Classe classe = new Classe();
                classe.setId(rset.getInt(1));
                classe.setNomClasse(rset.getString(2));
                resultat.add(classe);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public List<Matiere> listeMatiereEnseigant(Connection con, Statement stat, ResultSet rset, int idEnseignant, int idClasse) {
        String req;
        List<Matiere> resultat = new ArrayList<Matiere>();
        req = "SELECT m.idmatiere, m.nommatiere from matiere m join enseignatmatiere em on m.IDMATIERE=em.IDMATIERE "
                + "join enseignant e on e.IDENSEIGNANT=em.IDENSEIGNANT join classematiere cm on cm.idMatiere=e.IDMATIERE "
                + "JOIN classe cl on cl.IDCLASSE=cm.idClasse  ";

        if (idEnseignant != 0 && idClasse != 0) {
            req += " where e.idenseignant=" + idEnseignant + "" + " and cl.IDCLASSE=" + idClasse;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {

                Matiere m = new Matiere();

                m.setId(rset.getInt(1));
                m.setNomMatiere(rset.getString(2));
                resultat.add(m);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public List<Matiere> listeMatiereClasse(Connection con, Statement stat, ResultSet rset, int idClasse) {
        String req;
        List<Matiere> resultat = new ArrayList<Matiere>();
        req = "SELECT m.idmatiere, m.nommatiere from matiere m join classematiere cm on m.IDMATIERE=cm.IDMATIERE  ";

        if (idClasse != 0) {
            req += "where cm.IDCLASSE=" + idClasse;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                Classe classe = new Classe();
                Enseignant ens = new Enseignant();
                Matiere m = new Matiere();

                m.setId(rset.getInt(1));
                m.setNomMatiere(rset.getString(2));
                resultat.add(m);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public List<Matiere> listeMatiereEnseigantDvr(Connection con, Statement stat, ResultSet rset, int idEnseignant) {
        String req;
        List<Matiere> resultat = new ArrayList<Matiere>();
        req = "SELECT m.idmatiere, m.nommatiere from matiere m join enseignatmatiere em on m.IDMATIERE=em.IDMATIERE "
                + "join enseignant e on e.IDENSEIGNANT=em.IDENSEIGNANT join classematiere cm on cm.idMatiere=e.IDMATIERE "
                + "JOIN classe cl on cl.IDCLASSE=cm.idClasse  ";

        if (idEnseignant != 0) {
            req += " where e.idenseignant=" + idEnseignant;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {

                Matiere m = new Matiere();

                m.setId(rset.getInt(1));
                m.setNomMatiere(rset.getString(2));
                resultat.add(m);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public long insererNoteEleve(Etudiant et, Matiere matiere, int semestre, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        try {
            long idetud = 0;
            String sqlID = "select * from noteeleve";
            rSetIdGenerees = stat.executeQuery(sqlID);
            while (rSetIdGenerees.next()) {
                idetud = rSetIdGenerees.getLong(1);
            }
            idMessage = idetud + 1;
            List<Coefficient> listeCoefficient = new ArrayList<Coefficient>();
            listeCoefficient = fonctNote.listeCoefficientMatiere(matiere);
            String req = "INSERT INTO noteeleve(IDNOTEELEVE,IDELEVE ,IDCOEFFICIENT,IDMATIERE,IDSEMESTRE,NOTE1,NOTE2,MOYENNE,MOYENNECOEFFICIENT,COEFFICIENT2,APPRECIATIONS,ETAT)\n"
                    + "    VALUES (" + idMessage + "," + et.getId() + "," + listeCoefficient.get(0).getId() + "," + matiere.getId() + "," + semestre + ",'0','0','0','0','0','" + null + "','1')";

            int a = stat.executeUpdate(req);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }

        return idMessage;
    }

    public List<NoteEleve> listerNoteEleve(Connection con, Statement stat, ResultSet rset, long id, int idEtudiant, int idMatiere, int idSemestre) {
        String req;
        List<NoteEleve> resultat = new ArrayList<NoteEleve>();
        req = "select * from noteeleve where IDMATIERE=" + idMatiere + " and IDSEMESTRE=" + idSemestre + " and IDELEVE=" + idEtudiant;
        if (id != 0) {
            req += " and IDNOTEELEVE=" + id;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                //Note c=new Note();

                NoteEleve cdt = new NoteEleve();
                cdt.setIdNoteEleve(rset.getLong(1));
                cdt.setEtudiant(fonction.listeEtudiant(rset.getInt(2), null, 0).get(0));
                cdt.setCoefficient(fonctNote.listerCoefficient(rset.getInt(3)).get(0));
                cdt.setMatiere(fonction.listeMatiere(rset.getInt(4)).get(0));
                cdt.setSemestre(fonctNote.listerSemes(rset.getInt(5)).get(0));
                cdt.setNote(rset.getDouble(6));
                cdt.setNote2(rset.getDouble(7));
                cdt.setMoyenne(rset.getDouble(8));
                cdt.setMoyenneCoefficient(rset.getDouble(9));
                cdt.setCoefficient2(rset.getInt(10));
                cdt.setAppreciation(rset.getString(11));
                cdt.setEtat(rset.getInt(12));
                resultat.add(cdt);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public void updateNote1(long idNote, double note, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        try {
            String req9 = "update noteeleve set NOTE1=" + note + " , ETAT=2 where IDNOTEELEVE=" + idNote;
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }

    public void updateNote2(long idNote, double note, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        try {
            String req9 = "update noteeleve set NOTE2=" + note + " , ETAT=3 where idnoteeleve=" + idNote;
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }
    public void updateNoteAdmin1(int idNote,double note,Statement stat,Connection conn,ResultSet rSetIdGenerees)throws SQLException, Exception{
        long idMessage=0;
        try{
           String req9 = "update noteeleve set NOTE1=" + note + "  where idnoteeleve=" + idNote;
            int a = stat.executeUpdate(req9);   
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
     public void updateNoteAdmin2(int idNote,double note,Statement stat,Connection conn,ResultSet rSetIdGenerees)throws SQLException, Exception{
        long idMessage=0;
        try{
           String req9 = "update noteeleve set NOTE2=" + note + "  where idnoteeleve=" + idNote;
            int a = stat.executeUpdate(req9);   
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public void moyenneNote(int idNote, double note1, double note2, int coefficient, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        double moye = (note1 + note2) / 3;
        double moyenneCoefficient = moye * coefficient;
        int coef2 = coefficient * 20;
        try {
            String req9 = "update noteeleve set MOYENNE=" + moye + ",MOYENNECOEFFICIENT=" + moyenneCoefficient + " ,COEFFICIENT2=" + coef2 + " where idnoteeleve=" + idNote;
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }
     public void moyenneNote1(long idNote, double note1, double note2, int coefficient, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        double moye = (note1 + note2) / 3;
        double moyenneCoefficient = moye * coefficient;
        int coef2 = coefficient * 20;
        try {
            String req9 = "update noteeleve set MOYENNE=" + moye + ",MOYENNECOEFFICIENT=" + moyenneCoefficient + " ,COEFFICIENT2=" + coef2 + " where idnoteeleve=" + idNote;
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }
    public void updateAppreciaiton(int idNote, String appreciation, Statement stat, Connection conn, ResultSet rSetIdGenerees) throws SQLException, Exception {
        long idMessage = 0;
        try {
            String req9 = "update noteeleve set APPRECIATIONS='" + appreciation + "' , ETAT=4 where idnoteeleve=" + idNote;
            int a = stat.executeUpdate(req9);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        }
    }

    public List<NoteEleve> listerNoteEl(Connection con, Statement stat, ResultSet rset, long id, int idEtudiant, int idSemestre) {
        String req;
        List<NoteEleve> resultat = new ArrayList<NoteEleve>();
        req = "select * from noteeleve where IDELEVE=" + idEtudiant;
        if (idSemestre != 0) {
            req += " and IDSEMESTRE=" + idSemestre;
        }
        if (id != 0) {
            req += " and IDNOTEELEVE=" + id;
        }

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                //Note c=new Note();
                NoteEleve cdt = new NoteEleve();
                cdt.setIdNoteEleve(rset.getLong(1));
                cdt.setEtudiant(fonction.listeEtudiant(rset.getInt(2), null, 0).get(0));
                cdt.setCoefficient(fonctNote.listerCoefficient(rset.getInt(3)).get(0));
                cdt.setMatiere(fonction.listeMatiere(rset.getInt(4)).get(0));
                cdt.setSemestre(fonctNote.listerSemes(rset.getInt(5)).get(0));
                cdt.setNote(rset.getDouble(6));
                cdt.setNote2(rset.getDouble(7));
                cdt.setMoyenne(rset.getDouble(8));
                cdt.setMoyenneCoefficient(rset.getDouble(9));
                cdt.setCoefficient2(rset.getInt(10));
                cdt.setAppreciation(rset.getString(11));
                cdt.setEtat(rset.getInt(12));
                resultat.add(cdt);
            }
        } catch (Exception e) {
        }
        return resultat;
    }
    public List<NoteEleve> listerNoteEl11(Connection con, Statement stat, ResultSet rset, long idEtudiant) {
        String req;
        List<NoteEleve> resultat = new ArrayList<NoteEleve>();
        req = "select * from noteeleve where IDNOTEELEVE=" + idEtudiant;
     

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                //Note c=new Note();
                NoteEleve cdt = new NoteEleve();
                cdt.setIdNoteEleve(rset.getLong(1));
                cdt.setEtudiant(fonction.listeEtudiant(rset.getInt(2), null, 0).get(0));
                cdt.setCoefficient(fonctNote.listerCoefficient(rset.getInt(3)).get(0));
                cdt.setMatiere(fonction.listeMatiere(rset.getInt(4)).get(0));
                cdt.setSemestre(fonctNote.listerSemes(rset.getInt(5)).get(0));
                cdt.setNote(rset.getDouble(6));
                cdt.setNote2(rset.getDouble(7));
                cdt.setMoyenne(rset.getDouble(8));
                cdt.setMoyenneCoefficient(rset.getDouble(9));
                cdt.setCoefficient2(rset.getInt(10));
                cdt.setAppreciation(rset.getString(11));
                cdt.setEtat(rset.getInt(12));
                resultat.add(cdt);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

    public List<NoteEleve> listerElSemestre(Connection con, Statement stat, ResultSet rset, int idSemestre) {
        String req;
        List<NoteEleve> resultat = new ArrayList<NoteEleve>();
        req = "select * from noteeleve where IDSEMESTRE=" + idSemestre;

        try {
            rset = stat.executeQuery(req);
            while (rset.next()) {
                //Note c=new Note();
                NoteEleve cdt = new NoteEleve();
                cdt.setIdNoteEleve(rset.getLong(1));
                cdt.setEtudiant(fonction.listeEtudiant(rset.getInt(2), null, 0).get(0));
                cdt.setCoefficient(fonctNote.listerCoefficient(rset.getInt(3)).get(0));
                cdt.setMatiere(fonction.listeMatiere(rset.getInt(4)).get(0));
                cdt.setSemestre(fonctNote.listerSemes(rset.getInt(5)).get(0));
                cdt.setNote(rset.getDouble(6));
                cdt.setNote2(rset.getDouble(7));
                cdt.setMoyenne(rset.getDouble(8));
                cdt.setMoyenneCoefficient(rset.getDouble(9));
                cdt.setCoefficient2(rset.getInt(10));
                cdt.setAppreciation(rset.getString(11));
                cdt.setEtat(rset.getInt(12));
                resultat.add(cdt);
            }
        } catch (Exception e) {
        }
        return resultat;
    }

}
