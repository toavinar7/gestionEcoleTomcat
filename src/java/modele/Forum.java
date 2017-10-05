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
public class Forum extends BaseModele{
    private String sujet;
    private int idPersonne;
    private String typePersonne;
    private String dateForm;
    private Etudiant etud;
    private Parent part;
    private Admin adm;
    private Enseignant ens;

    public Forum() {
    }

    public String getSujet() {
        return sujet;
    }

    public String getDateForm() {
        return dateForm;
    }

    public void setDateForm(String dateForm) {
        this.dateForm = dateForm;
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

    public void setSujet(String sujet) {
        this.sujet = sujet;
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
    
    
    
}
