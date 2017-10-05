/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author toavina
 */
public class Bulletin extends BaseModele{
    
    private Etudiant idEtudiant;
    private Classe idClasse;
    private Semestre idSemestre;
    private int totalCoefficient;
    private double moyenneCoefficient;
    private int calculCoefficient;
   
    private double moyenne;
    private double moyenneClasse;
    private int rang;
    private int effectif;
    
    private int etat;
    private String decisionConseil;
    
    public Bulletin() {
    }

    public Etudiant getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Etudiant idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public Semestre getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Semestre idSemestre) {
        this.idSemestre = idSemestre;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public int getTotalCoefficient() {
        return totalCoefficient;
    }

    public void setTotalCoefficient(int totalCoefficient) {
        this.totalCoefficient = totalCoefficient;
    }

    public double getMoyenneCoefficient() {
        return moyenneCoefficient;
    }

    public void setMoyenneCoefficient(double moyenneCoefficient) {
        this.moyenneCoefficient = moyenneCoefficient;
    }

    public int getCalculCoefficient() {
        return calculCoefficient;
    }

    public void setCalculCoefficient(int calculCoefficient) {
        this.calculCoefficient = calculCoefficient;
    }

    public double getMoyenneClasse() {
        return moyenneClasse;
    }

    public void setMoyenneClasse(double moyenneClasse) {
        this.moyenneClasse = moyenneClasse;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDecisionConseil() {
        return decisionConseil;
    }

    public void setDecisionConseil(String decisionConseil) {
        this.decisionConseil = decisionConseil;
    }
    
    
}
