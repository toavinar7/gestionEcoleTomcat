/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author DERA PC
 */
public class EnseignantMatiere extends BaseModele{
    
    private int idMatiere;
    private int idEnseignant;

    public EnseignantMatiere() {
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    
}
