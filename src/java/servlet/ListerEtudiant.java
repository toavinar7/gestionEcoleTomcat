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
import modele.Etudiant;
import util.Fonction;

/**
 *
 * @author nat
 */
@WebServlet(name = "ListerEtudiant", urlPatterns = {"/ListerEtudiant"})
public class ListerEtudiant extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           Fonction f=new Fonction();
           int idClasse=Integer.parseInt(request.getParameter("idClasse"));
         try {
           
                Classe cls=new Classe();
                List<Etudiant> letudiant= new ArrayList<Etudiant>();
                cls=f.listeClasse(idClasse).get(0);
                letudiant=f.listeEtudiant(0,null,idClasse);   
                request.setAttribute("classe", cls);
                request.setAttribute("letudiant", letudiant);
                RequestDispatcher rdisp = request.getRequestDispatcher("listeEtudiant.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListerEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
