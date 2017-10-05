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
public class Commentaire extends BaseModele{
    private String comment;
    private int idPersonne;
    private String typePersonne;
    private String dateComment;
    private int idForum;
    private Etudiant etud;
    private Parent part;
    private Admin adm;
    private Enseignant ens;

    public Commentaire() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(String typePersonne) {
        this.typePersonne = typePersonne;
    }

    public String getDateComment() {
        return dateComment;
    }

    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public Etudiant getEtud() {
        return etud;
    }

    public void setEtud(Etudiant etud) {
        this.etud = etud;
    }

    public Parent getPart() {
        return part;
    }

    public void setPart(Parent part) {
        this.part = part;
    }

    public Admin getAdm() {
        return adm;
    }

    public void setAdm(Admin adm) {
        this.adm = adm;
    }

    public Enseignant getEns() {
        return ens;
    }

    public void setEns(Enseignant ens) {
        this.ens = ens;
    }
    
    
}
