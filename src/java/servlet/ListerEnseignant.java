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
import modele.Enseignant;
import util.Fonction;

/**
 *
 * @author Jhool
 */
@WebServlet(name = "ListerEnseignant", urlPatterns = {"/ListerEnseignant"})
public class ListerEnseignant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Fonction f=new Fonction();
           int idClasse=Integer.parseInt(request.getParameter("idClasse"));
         try {
           
                Classe cls=new Classe();
                List<Enseignant> lenseignant= new ArrayList<Enseignant>();
                lenseignant=f.listeEnseignant(0,idClasse);  
                cls=f.listeClasse(idClasse).get(0);
                request.setAttribute("classe", cls);
                request.setAttribute("lenseignant", lenseignant);
                RequestDispatcher rdisp = request.getRequestDispatcher("listeEnseignant.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListerEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
