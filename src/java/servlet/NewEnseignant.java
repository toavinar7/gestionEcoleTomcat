/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
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
import modele.Matiere;
import util.Fonction;

/**
 *
 * @author Jhool
 */
@WebServlet(name = "NewEnseignant", urlPatterns = {"/NewEnseignant"})
public class NewEnseignant extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fonction f = new Fonction();
        try {

            List<Classe> lclasse = new ArrayList<Classe>();
            List<Matiere> lmatiere = new ArrayList<Matiere>();
            lclasse = f.listeClasse(0);
            request.setAttribute("listeclasse", lclasse);
            RequestDispatcher rdisp = request.getRequestDispatcher("nouveauEnseignant.jsp");
            rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NewEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
