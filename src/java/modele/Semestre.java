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
public class Semestre extends BaseModele{
    private String nomSemestre;
    private Classe idClasse;
    private String annee;

    public Semestre() {
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
    
}
