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
import modele.Devoir;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "ServletListerDevoirPr", urlPatterns = {"/ServletListerDevoirPr"})
public class ServletListerDevoirPr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProf = Integer.parseInt(request.getParameter("idProf"));
        int idClasse = Integer.parseInt(request.getParameter("idClasse"));
        List<Devoir>lsitdev=new ArrayList<Devoir>();
        Fonction f = new Fonction();
        try {
            lsitdev=f.listeDevoirClasse(idClasse,idProf);
            request.setAttribute("listeDevoir",lsitdev);
            request.getRequestDispatcher("listeDevoirEnseignant.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
