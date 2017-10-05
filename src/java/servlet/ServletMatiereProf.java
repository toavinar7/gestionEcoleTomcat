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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Etudiant;
import modele.Matiere;
import modele.Semestre;
import util.Fonction;
import util.FonctionNote;

/**
 *
 * @author nat
 */
@WebServlet(name = "ServletMatiereProf", urlPatterns = {"/ServletMatiereProf"})
public class ServletMatiereProf extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int idProf = Integer.parseInt(request.getParameter("idProf"));

        int idClasse = Integer.parseInt(request.getParameter("idClasse"));
        
        FonctionNote fonction = new FonctionNote();
        Fonction f = new Fonction();
        List<Matiere> listeMatiere = new ArrayList<Matiere>();
        List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
        List<Semestre>lsitSemestre=new ArrayList<Semestre>();
        String idClass=""+idClasse;
        try {
            listeMatiere = fonction.listerMatiereEnseigant(idProf, idClasse);
            listeEtudiant = f.listeEtudiant(0, null, idClasse);
            lsitSemestre=fonction.listerSemestre(0,idClasse);
            request.setAttribute("listeEtudiant", listeEtudiant);
            request.setAttribute("listeMatiereClasse", listeMatiere);
            request.setAttribute("idClass", idClass);
            request.setAttribute("lsitSemestre", lsitSemestre);
            RequestDispatcher rdisp = request.getRequestDispatcher("formulaireNoteEnseignant.jsp");
            rdisp.forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
  
}
