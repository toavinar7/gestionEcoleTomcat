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
import util.Fonction;

/**
 *
 * @author nat
 */
@WebServlet(name = "ListerDesClasse", urlPatterns = {"/ListerDesClasse"})
public class ListerDesClasse extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Fonction f=new Fonction();
        try {
           

                List<Classe> lmat= new ArrayList<Classe>();
                lmat=f.listeClasse(0);   
                request.setAttribute("listeclasse", lmat);
                RequestDispatcher rdisp = request.getRequestDispatcher("listesDesClasses.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListerDesClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
