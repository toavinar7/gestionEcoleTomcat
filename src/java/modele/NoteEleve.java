/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author toavina
 */
public class NoteEleve {
    private long idNoteEleve; 
    private Etudiant etudiant;
    private Matiere matiere;
    private Coefficient coefficient;
    private Semestre semestre;
    private double note;
    private double note2;
    private double moyenne;
    private double moyenneCoefficient;
    private int coefficient2;
    private String appreciation;
    private int etat;

    public NoteEleve() {
    }

    public long getIdNoteEleve() {
        return idNoteEleve;
    }

    public void setIdNoteEleve(long idNoteEleve) {
        this.idNoteEleve = idNoteEleve;
    }
    

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public double getNote2() {
        return note2;
    }

    public void setNote2(double note2) {
        this.note2 = note2;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Coefficient getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Coefficient coefficient) {
        this.coefficient = coefficient;
    }

    public double getMoyenneCoefficient() {
        return moyenneCoefficient;
    }

    public void setMoyenneCoefficient(double moyenneCoefficient) {
        this.moyenneCoefficient = moyenneCoefficient;
    }

    public int getCoefficient2() {
        return coefficient2;
    }

    public void setCoefficient2(int coefficient2) {
        this.coefficient2 = coefficient2;
    }
    
    
}
