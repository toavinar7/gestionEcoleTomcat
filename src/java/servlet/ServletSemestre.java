/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Etudiant;
import modele.Matiere;
import util.Fonction;
import util.FonctionNote;

/**
 *
 * @author nat
 */
@WebServlet(name = "ServletSemestre", urlPatterns = {"/ServletSemestre"})
public class ServletSemestre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //insererNoteEleve
        int idClasse = Integer.parseInt(request.getParameter("classe"));
       // System.out.println("idClasse"+idClasse);
        String nomSemestre = request.getParameter("nom");
        FonctionNote fonct = new FonctionNote();
        String dat = fonct.dateNow();
        List<Matiere>matiere=new ArrayList<Matiere>();
        List<Etudiant>listeEtudiant=new ArrayList<Etudiant>();
        Fonction fonction=new Fonction();
        int[] retour = new int[3];
        retour = fonct.recupererMoi(dat);
        int date1 = retour[2];
        int date2 = date1 + 1;
        String annee = "" + date1 + "-" + date2;
        try {
          long idNoteEleve=0;
          long idBulletin=0;
            int idSemestre = fonct.insertSemestre(nomSemestre, idClasse, annee);
            System.out.println("idSemestre"+idSemestre);
           // matiere=fonct.
           matiere=fonct.listeMatiereClasse(idClasse);
             listeEtudiant=fonction.listeEtudiant(0, null, idClasse);
            for(int i=0;i<listeEtudiant.size();i++){
                idBulletin=fonct.insererBulletin(listeEtudiant.get(i).getId(), listeEtudiant.get(i).getClasse().getId(), idSemestre);
                for(int j=0;j<matiere.size();j++){
                idNoteEleve=fonct.insertNoteEleve(listeEtudiant.get(i), matiere.get(j), idSemestre);
                
                }
            }
            response.sendRedirect("ListerEtudiantNote2?idClasse="+idClasse+"&idSemestre="+idSemestre);
        } catch (SQLException ex) {
            Logger.getLogger(ServletSemestre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
