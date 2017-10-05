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
public class Devoir extends BaseModele {
   
   
    private String commentaire;
    private Classe idClasse;
    private Enseignant idEnseignant;
    private Matiere libele;
    private String pdfUrl;
    private String dateEntrer;
    private String dateCorrection;

    public Devoir() {
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public Enseignant getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Enseignant idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

       
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Matiere getLibele() {
        return libele;
    }

    public void setLibele(Matiere libele) {
        this.libele = libele;
    }


    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getDateEntrer() {
        return dateEntrer;
    }

    public void setDateEntrer(String dateEntrer) {
        this.dateEntrer = dateEntrer;
    }

    public String getDateCorrection() {
        return dateCorrection;
    }

    public void setDateCorrection(String dateCorrection) {
        this.dateCorrection = dateCorrection;
    }
    
    
    
}
