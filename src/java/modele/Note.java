/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author nat
 */
public class Note extends BaseModele{
    private Matiere matiere;
    private Etudiant eleve;
    private float note;
    private float deuxnote;
    private float examen;
    private String trimestre;
    private String anneeScolaire;
    private float moyenne;

    public Note() {
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    
    public Matiere getMatiere() {
        return matiere;
    }

    public float getDeuxnote() {
        return deuxnote;
    }

    public void setDeuxnote(float deuxnote) {
        this.deuxnote = deuxnote;
    }

    public float getExamen() {
        return examen;
    }

    public void setExamen(float examen) {
        this.examen = examen;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEleve() {
        return eleve;
    }

    public void setEleve(Etudiant eleve) {
        this.eleve = eleve;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
    
    
}
