
package modele;

import java.util.List;


public class Enseignant extends BaseModele{
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private Matiere matiere;
    private List<Classe> classe;

    public Enseignant() {
    }

    public String getNom() {
        return nom;
    }

    public List<Classe> getClasse() {
        return classe;
    }

    public void setClasse(List<Classe> classe) {
        this.classe = classe;
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
