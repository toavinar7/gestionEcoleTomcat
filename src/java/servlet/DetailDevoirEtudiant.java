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
import modele.Devoir;
import modele.Etudiant;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "DetailDevoirEtudiant", urlPatterns = {"/DetailDevoirEtudiant"})
public class DetailDevoirEtudiant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Etudiant etudiant = new Etudiant();
        Fonction f = new Fonction();
        
            etudiant = (Etudiant) request.getSession().getAttribute("eleve");
          
           int idDevoir = Integer.parseInt(request.getParameter("idDevoir"));
           List<Devoir> ldevoir = new ArrayList<Devoir>();
        try {
         
            f.UpdateDevoir(idDevoir, etudiant.getId());
            etudiant = (Etudiant) request.getSession().getAttribute("eleve");
            ldevoir=f.detailDevoirEtudiant(idDevoir);
            request.setAttribute("listeDevoir",ldevoir);
        } catch (SQLException ex) {
            Logger.getLogger(DetailDevoirEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.getRequestDispatcher("detailDevoirEtudiant.jsp").forward(request, response);
    }

  
}
