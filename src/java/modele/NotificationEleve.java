/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Utilisateur
 */
public class NotificationEleve extends BaseModele {
    private Etudiant idEtudiant;
    private Devoir devoir;
    private int notification;
    private Matiere nomMatiere;

    public NotificationEleve() {
    }

    public Etudiant getIdEtudiant() {
        return idEtudiant;
    }

    public Devoir getDevoir() {
        return devoir;
    }

    public void setDevoir(Devoir devoir) {
        this.devoir = devoir;
    }

    public void setIdEtudiant(Etudiant idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    
    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
    }

    public Matiere getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(Matiere nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

     
}
