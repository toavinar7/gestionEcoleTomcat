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
import modele.Parent;
import util.Fonction;

/**
 *
 * @author Jhool
 */
@WebServlet(name = "ListerParent", urlPatterns = {"/ListerParent"})
public class ListerParent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           Fonction f=new Fonction();
           int idClasse=Integer.parseInt(request.getParameter("idClasse"));
         try {
           

                List<Parent> lparent= new ArrayList<Parent>();
                Classe cl=new Classe();
                cl=f.listeClasse(idClasse).get(0);
                lparent=f.listeParentClasse(idClasse); 
                request.setAttribute("classe", cl);
                request.setAttribute("lparent", lparent);
                RequestDispatcher rdisp = request.getRequestDispatcher("listeparent.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListerParent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
