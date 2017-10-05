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
public class Message extends BaseModele{
    
    private int idPersonne;
    private String typePersonne;
    
    private int idPersonneCont;
    private String typePersonneCont;
    
    private String message;
    private String dateMessage;
    private String typeMessage;
    
    private Etudiant etud;
    private Parent part;
    private Admin adm;
    private Enseignant ens;
    
    private Etudiant etudCt;
    private Parent partCt;
    private Admin admCt;
    private Enseignant ensCt;

    public Message() {
    }

    public int getIdPersonneCont() {
        return idPersonneCont;
    }

    public void setIdPersonneCont(int idPersonneCont) {
        this.idPersonneCont = idPersonneCont;
    }

    public String getTypePersonneCont() {
        return typePersonneCont;
    }

    public void setTypePersonneCont(String typePersonneCont) {
        this.typePersonneCont = typePersonneCont;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public Etudiant getEtudCt() {
        return etudCt;
    }

    public void setEtudCt(Etudiant etudCt) {
        this.etudCt = etudCt;
    }

    public Parent getPartCt() {
        return partCt;
    }

    public void setPartCt(Parent partCt) {
        this.partCt = partCt;
    }

    public Admin getAdmCt() {
        return admCt;
    }

    public void setAdmCt(Admin admCt) {
        this.admCt = admCt;
    }

    public Enseignant getEnsCt() {
        return ensCt;
    }

    public void setEnsCt(Enseignant ensCt) {
        this.ensCt = ensCt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
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
