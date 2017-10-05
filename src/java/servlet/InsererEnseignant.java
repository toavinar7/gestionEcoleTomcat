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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Classe;
import modele.Enseignant;
import modele.Matiere;
import util.Fonction;
import util.FonctionNote;

/**
 *
 * @author Jhool
 */
@WebServlet(name = "InsertionClasse", urlPatterns = {"/InsertionClasse"})
public class InsererEnseignant extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String[] classe=request.getParameterValues("classe");
        String login=request.getParameter("login");
        String mdp=request.getParameter("mdp");
        String nouveauMatiere=request.getParameter("matiere");
        String message=null;
        Enseignant en=new Enseignant();
        Matiere cl=new Matiere();
        Classe cls=new Classe();
        Fonction f= new Fonction();
        FonctionNote fonct=new FonctionNote();
        try {
            int matiere=f.insertMatiere(nouveauMatiere);
            int k=f.insererEnseignant(matiere,nom,prenom,login,mdp);
            int m=f.insererEnseignantMat(k, matiere);
            for(int i=0;i<classe.length;i++){
                int g=f.insererEnseignantClasse(k, Integer.parseInt(classe[i]));
                int l=fonct.insertClasseMatiere(Integer.parseInt(classe[i]), matiere);
                int j=fonct.insererEnseignantMatiere(matiere, g);
            }
            List<Classe> lclasse = new ArrayList<Classe>();
            List<Matiere> lmatiere = new ArrayList<Matiere>();
            lclasse = f.listeClasse(0);
            message="insertion reussite";
            request.setAttribute("listeclasse", lclasse);
            request.setAttribute("msg", message);
            RequestDispatcher rdisp = request.getRequestDispatcher("nouveauEnseignant.jsp");
            rdisp.forward(request, response);
            }  catch (SQLException ex) {
            Logger.getLogger(InsererEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
