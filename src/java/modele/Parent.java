/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author nat
 */
public class Parent extends BaseModele{
    private List<Etudiant> eleve;
    private String nom;
    private String prenom;
    private String type;
    private String login;
    private String mdp;

    public Parent() {
    }

    public List<Etudiant> getEleve() {
        return eleve;
    }

    public void setEleve(List<Etudiant> eleve) {
        this.eleve = eleve;
    }

    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
}
