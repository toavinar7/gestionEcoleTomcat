/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author MAMPYUN
 */
public class HeureMatiere extends BaseModele{
    private Classe classe;
    private EmploiDuTemp emploidutemp;
    private Enseignant enseignant;
    private String jour;
    private String heuredebut;
    private String heureFin;

    public HeureMatiere() {
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public EmploiDuTemp getEmploidutemp() {
        return emploidutemp;
    }

    public void setEmploidutemp(EmploiDuTemp emploidutemp) {
        this.emploidutemp = emploidutemp;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(String heuredebut) {
        this.heuredebut = heuredebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
    
}
