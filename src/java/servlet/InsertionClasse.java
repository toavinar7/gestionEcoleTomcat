/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Admin;
import util.Fonction;

/**
 *
 * @author nat
 */
@WebServlet(name = "InsertionClasse", urlPatterns = {"/InsertionClasse"})
public class InsertionClasse extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nom=request.getParameter("nom");
            Fonction f= new Fonction();
            try {
                f.insertClasse(nom);
                f.insertEmploiDuTemp(nom);
            } catch (SQLException ex) {
                Logger.getLogger(InsertionClasse.class.getName()).log(Level.SEVERE, null, ex);
            }
             response.sendRedirect("ListerDesClasse");
    }

}
