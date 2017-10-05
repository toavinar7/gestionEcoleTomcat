/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Etudiant;
import modele.Matiere;
import modele.Semestre;
import modele.Enseignant;
import util.Fonction;
import util.FonctionNote;

/**
 *
 * @author toavina
 */
@WebServlet(name = "ServletAddNote", urlPatterns = {"/ServletAddNote"})
public class ServletAddNote extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idProf = Integer.parseInt(request.getParameter("idProf"));
        
      //  System.out.println("iddddddProf=="+idProf);
        
        int idClasse = Integer.parseInt(request.getParameter("idClass"));
        
       // System.out.println("idClasse=="+idClasse);
        
        int examen = Integer.parseInt(request.getParameter("examen"));
        
      //  System.out.println("examenn=="+examen);
        
        
        FonctionNote fonction=new FonctionNote();
        Fonction f=new Fonction();
        List<Enseignant>listeEnseignant=new ArrayList<Enseignant>();
        List<Semestre>listeSemestre=new ArrayList<Semestre>();
        List<Etudiant>listeEtudiant=new ArrayList<Etudiant>();
        List<Matiere> listeMatiere = new ArrayList<Matiere>();
        String idClass=""+idClasse;
        try {
            listeEnseignant=f.listeEnseignant(idProf, idClasse);
            listeMatiere = fonction.listerMatiereEnseigant(idProf, idClasse);
            listeSemestre=fonction.listerSemestre(examen,0);
            listeEtudiant=f.listeEtudiant(0, null, idClasse);
         
            request.setAttribute("listeEtudiant1", listeEtudiant);
          //  System.out.println("tailllllllllllllllllllllllllllleeeeeeeeeeeeeeeeeeeeee===="+listeEtudiant.size());
            request.setAttribute("listeMatiereClasse1", listeMatiere);
        //    System.out.println("listeMatiereClasse1===="+listeMatiere);
            request.setAttribute("idClass1", idClass);
          //  System.out.println("idClasseeeee==="+idClass);
            request.setAttribute("lsitSemestre1", listeSemestre);
         //   System.out.println("listeSemestre===="+listeSemestre);
            RequestDispatcher rdisp = request.getRequestDispatcher("formulaireNoteEnseignant.jsp");
            rdisp.forward(request, response);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      

    }

}
