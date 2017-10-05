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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Etudiant;
import modele.NotificationEleve;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "ListeDevoirEtudiant", urlPatterns = {"/ListeDevoirEtudiant"})
public class ListeDevoirEtudiant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Etudiant etudiant = new Etudiant();
        List<NotificationEleve> ldevoir = new ArrayList<NotificationEleve>();
        Fonction f = new Fonction();
        try {
            etudiant = (Etudiant) request.getSession().getAttribute("eleve");
            ldevoir = f.listeNotifDevoirEleve(etudiant.getId());
            request.setAttribute("listeDevoir",ldevoir);
            request.getRequestDispatcher("listeDevoirEtudiant.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
