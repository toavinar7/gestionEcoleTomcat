/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Classe;
import modele.Etudiant;
import util.Fonction;

/**
 *
 * @author nat
 */
@WebServlet(name = "InsertionEtudiant", urlPatterns = {"/InsertionEtudiant"})
public class InsertionEtudiant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String im=request.getParameter("im");
        int classe=Integer.parseInt(request.getParameter("classe"));
        String message=null;
        Etudiant ut=new Etudiant();
        Classe cl=new Classe();
        Fonction f= new Fonction();
        try {
            f.insertEtudiant(classe, nom, prenom, im);
            }  catch (SQLException ex) {
            Logger.getLogger(InsertionEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
             response.sendRedirect("ListerEtudiant?idClasse="+classe);
    }

 
}
