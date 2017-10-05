/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.BaseDao;
import dao.BulletinDao;
import dao.ClasseDao;
import dao.ClasseMatiereDao;
import dao.CoefficientDao;
import dao.EtudiantDao;
import dao.NoteDao;
import dao.SemestreDao;
import dao.EnseignantMatiereDao;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.Bulletin;
import modele.Classe;
import modele.ClasseMatiere;
import modele.Coefficient;
import modele.Etudiant;
import modele.Matiere;
import modele.NoteEleve;
import modele.Semestre;

/**
 *
 * @author toavina
 */
public class FonctionNote {

    private Connection conn;
    private Statement stat;
    private ResultSet rset;
    Fonction fonction = new Fonction();

    public String dateNow() {
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dat = dateFormat.format(actuelle);

        return dat;
    }

    public int[] calculMoi(int debut, int duree) {
        int[] retour = new int[2];
        retour[0] = debut;
        retour[1] = duree;
        return retour;
    }

    public int[] recupererMoi(String moi) {
        int[] retour = new int[3];
        char[] test = new char[10];
        test = moi.toCharArray();
        String str, str1, str2 = null;
        //6/12/2017
        if (test[1] == '/' && test[3] != '/') {

            str = "0" + test[0];

            str1 = "" + test[2] + "" + test[3];

            str2 = "" + test[5] + "" + test[6] + "" + test[7] + "" + test[8];
            retour[0] = Integer.parseInt(str);
            retour[1] = Integer.parseInt(str1);
            retour[2] = Integer.parseInt(str2);
        } else//6/2/2017   
        {
            if (test[1] == '/' && test[3] == '/') {

                str = "0" + test[0];

                str1 = "0" + test[2];

                str2 = "" + test[4] + "" + test[5] + "" + test[6] + "" + test[7];
                retour[0] = Integer.parseInt(str);
                retour[1] = Integer.parseInt(str1);
                retour[2] = Integer.parseInt(str2);
            } else if (test[2] == '/' && test[4] == '/') {

                str = "" + test[0] + "" + test[1];
                str1 = "" + test[3];

                str2 = "" + test[5] + "" + test[6] + "" + test[7] + "" + test[8];
                retour[0] = Integer.parseInt(str);
                retour[1] = Integer.parseInt(str1);
                retour[2] = Integer.parseInt(str2);
            } else {
                str = "" + test[0] + "" + test[1];
                str1 = "" + test[3] + "" + test[4];

                str2 = "" + test[6] + "" + test[7] + "" + test[8] + "" + test[9];
                retour[0] = Integer.parseInt(str);
                retour[1] = Integer.parseInt(str1);
                retour[2] = Integer.parseInt(str2);
            }
        }
        //2/1/2019

        return retour;
    }

    public List<Classe> listerClasseEnseigant(int id) throws SQLException {
        List<Classe> lister = new ArrayList<Classe>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerClasseEnseigant(conn, stat, rset, id);
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

    public List<Matiere> listerMatiereEnseigant(int idProf, int idClasse) throws SQLException {
        List<Matiere> lister = new ArrayList<Matiere>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeMatiereEnseigant(conn, stat, rset, idProf, idClasse);
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

    public List<Matiere> listeMatiereClasse(int idClasse) throws SQLException {
        List<Matiere> lister = new ArrayList<Matiere>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeMatiereClasse(conn, stat, rset, idClasse);
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

    public List<Matiere> listerMatiereEnseigantDvr(int idProf) throws SQLException {
        List<Matiere> lister = new ArrayList<Matiere>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeMatiereEnseigantDvr(conn, stat, rset, idProf);
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

    public int insertSemestre(String nomSemestre, int idClasse, String anne) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idMatiere = 0;
        SemestreDao cldao = new SemestreDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatiere = cldao.insererSemestre(nomSemestre, idClasse, anne, stat, conn, rset);
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

    public int insererCoefficient(int ma, int coefficient) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idMatiere = 0;
        CoefficientDao cldao = new CoefficientDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatiere = cldao.insererCoefficient(ma, coefficient, stat, conn, rset);
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
    //listerCoefficient

    public List<Coefficient> listerCoefficient(int id) throws SQLException {
        List<Coefficient> lister = new ArrayList<Coefficient>();
        CoefficientDao req = new CoefficientDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerCoefficient(conn, stat, rset, id);
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
    //listeCoefficientMatiere

    public List<Coefficient> listeCoefficientMatiere(Matiere matiere) throws SQLException {
        List<Coefficient> lister = new ArrayList<Coefficient>();
        CoefficientDao req = new CoefficientDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeCoefficientMatiere(conn, stat, rset, matiere);
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

    public List<Semestre> listerSemes(int id) throws SQLException {
        List<Semestre> lister = new ArrayList<Semestre>();
        SemestreDao req = new SemestreDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerSemes(conn, stat, rset, id);
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

    public int insererBulletin(int etudiant, int classe, int semestre) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idMatiere = 0;
        BulletinDao cldao = new BulletinDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatiere = cldao.insererBulletin(etudiant, classe, semestre, stat, conn, rset);
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

    public void updateBulletin(int idEtudiant, int idSemestre, int totalCoefficient, double moyenneCoef,
            int calculCoef, double moyenne, double moyenneClasse, int rang, int effectif) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        BulletinDao dao = new BulletinDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            dao.updateBulletin(idEtudiant, idSemestre, totalCoefficient, moyenneCoef, calculCoef, moyenne, moyenneClasse, rang, effectif, conn, stat, rset);
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

    public List<Bulletin> listeBulletin(int idBulletin, int idEtudiant, int idSemestre) throws SQLException {
        List<Bulletin> lister = new ArrayList<Bulletin>();
        BulletinDao req = new BulletinDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeBulletin(idBulletin, idEtudiant, idSemestre, conn, stat, rset);
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

    public List<Bulletin> listeBulletin1(int idBulletin, int idEtudiant, int idSemestre) throws SQLException {
        List<Bulletin> lister = new ArrayList<Bulletin>();
        BulletinDao req = new BulletinDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listeBulletin1(idBulletin, idEtudiant, idSemestre, conn, stat, rset);
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

    public List<Semestre> listerSemestre(int id, int idClasse) throws SQLException {
        List<Semestre> lister = new ArrayList<Semestre>();
        SemestreDao req = new SemestreDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerSemestre(conn, stat, rset, id, idClasse);
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

    public long insertNoteEleve(Etudiant etudiant, Matiere matiere, int semestre) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao cldao = new NoteDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatiere = cldao.insererNoteEleve(etudiant, matiere, semestre, stat, conn, rset);
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

    public void updateNote1(long idnote, double note) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao cldao = new NoteDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            cldao.updateNote1(idnote, note, stat, conn, rset);
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

    public void updateNote2(long idnote, double note) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao cldao = new NoteDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            cldao.updateNote2(idnote, note, stat, conn, rset);
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

    //moyenneNote
    public void updatenoteAdmin1(int idNote, double note) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao noteDao = new NoteDao();

        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            noteDao.updateNote1(idNote, note, stat, conn, rset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public void updatenoteAdmin2(int idNote, double note) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao noteDao = new NoteDao();

        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            noteDao.updateNote2(idNote, note, stat, conn, rset);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void moyenneNote1(long idnote, double note1, double note2, int coefficient) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao cldao = new NoteDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            cldao.moyenneNote1(idnote, note1, note2, coefficient, stat, conn, rset);
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

    public void updateAppreciaiton(int idnote, String appreciation) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        NoteDao cldao = new NoteDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            cldao.updateAppreciaiton(idnote, appreciation, stat, conn, rset);
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

    public void updateDecisonConseil(int idBulletin, String conseil) throws SQLException {
        BaseDao basedao = new BaseDao();
        long idMatiere = 0;
        BulletinDao cldao = new BulletinDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            cldao.updateDecisonConseil(idBulletin, conseil, stat, conn, rset);
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

    public List<NoteEleve> listerNoteEleve(long id, int idEtudiant, int idMatiere, int idSemestre) throws SQLException {
        List<NoteEleve> lister = new ArrayList<NoteEleve>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerNoteEleve(conn, stat, rset, id, idEtudiant, idMatiere, idSemestre);
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
//listerNoteEl11
     public List<NoteEleve> listerNoteEl11(long id) throws SQLException {
        List<NoteEleve> lister = new ArrayList<NoteEleve>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerNoteEl11(conn, stat, rset, id);
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
    public List<NoteEleve> listerNoteEl(long id, int idEtudiant, int idSemestre) throws SQLException {
        List<NoteEleve> lister = new ArrayList<NoteEleve>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerNoteEl(conn, stat, rset, id, idEtudiant, idSemestre);
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

    public List<NoteEleve> listerElSemestre(int idSemestre) throws SQLException {
        List<NoteEleve> lister = new ArrayList<NoteEleve>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerElSemestre(conn, stat, rset, idSemestre);
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

    public List<Etudiant> listeEtudiant(int id) throws SQLException {
        List<Etudiant> lister = new ArrayList<Etudiant>();
        NoteDao req = new NoteDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerEtudiant(conn, stat, rset, id);
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

    public int insertClasseMatiere(int classe, int matiere) throws SQLException {
        BaseDao basedao = new BaseDao();
        int idMatiere = 0;
        ClasseMatiereDao cldao = new ClasseMatiereDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatiere = cldao.insererClasseMatiere(classe, matiere, stat, conn, rset);
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
    public int insererEnseignantMatiere(int idMatiere,int idEnseigant)throws SQLException{
          BaseDao basedao = new BaseDao();
        int idMatieree = 0;
        EnseignantMatiereDao cldao = new EnseignantMatiereDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            idMatieree = cldao.insererEnseignantMatiereDao(idMatiere, idEnseigant, stat, conn, rset);
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
    
    public List<ClasseMatiere> listeClasseMatiere(int id) throws SQLException {
        List<ClasseMatiere> lister = new ArrayList<ClasseMatiere>();
        ClasseMatiereDao req = new ClasseMatiereDao();
        BaseDao basedao = new BaseDao();
        try {
            conn = basedao.getConn();
            stat = conn.createStatement();
            lister = req.listerClasseMatiere(conn, stat, rset, id);
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

    public void moyennePondere(int idEtudiant, int idSemestre) throws SQLException {

        List<NoteEleve> listerNoteEl = new ArrayList<NoteEleve>();
        List<NoteEleve> listerNoteEl2 = new ArrayList<NoteEleve>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        listeEtudiant = fonction.listeEtudiant(idEtudiant, null, 0);
        listeEtudiant = this.listeEtudiant(idEtudiant);
        listerNoteEl = this.listerNoteEl(0, idEtudiant, idSemestre);
        listerNoteEl2 = this.listerElSemestre(idSemestre);

        double moyenne = 0;
        double moyenneCoef = 0;
        double moyenneClasse = 0;
        int calculCoef = 0;
        int totalCoef = 0;
        int n = listerNoteEl.size();

        for (int i = 0; i < listerNoteEl.size(); i++) {
            moyenne = moyenne + listerNoteEl.get(i).getMoyenne();
            totalCoef = totalCoef + listerNoteEl.get(i).getCoefficient().getCoef();
            moyenneCoef = moyenneCoef + listerNoteEl.get(i).getMoyenneCoefficient();
            calculCoef = calculCoef + listerNoteEl.get(i).getCoefficient2();
        }
        int effectifElevte = listerNoteEl2.size();
        int rang = 0;
        double moyenne1 = moyenneCoef / totalCoef;

        for (int j = 0; j < listerNoteEl2.size(); j++) {
            moyenneClasse = moyenneClasse + listerNoteEl2.get(j).getMoyenne();

        }
        if (moyenneClasse > 0) {
            double moyenneClasse1 = moyenneClasse / effectifElevte;
            this.updateBulletin(idEtudiant, idSemestre, totalCoef, moyenneCoef, calculCoef, moyenne1, moyenneClasse1, 0, effectifElevte);
        } else {
            this.updateBulletin(idEtudiant, idSemestre, totalCoef, moyenneCoef, calculCoef, 0, 0, 0, effectifElevte);
        }

    }
}
