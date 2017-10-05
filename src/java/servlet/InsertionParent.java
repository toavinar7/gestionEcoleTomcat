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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Etudiant;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "InsertionParent", urlPatterns = {"/InsertionParent"})
public class InsertionParent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String login=request.getParameter("login");
        String mdp=request.getParameter("mdp");
        String type=request.getParameter("type");
        String[] enfant=request.getParameterValues("enfant");
        Fonction f= new Fonction();
        String msg=null;
        List<Etudiant> letud=new ArrayList<Etudiant>();
        try {
            
            int id=f.insertPArent(nom, prenom, type, login, mdp);
            for(int i=0;i<enfant.length;i++){
                int a=f.insertParentEleve(Integer.parseInt(enfant[i]),id);
            }
            msg="insertion reussit";
                letud=f.listeEtudiant(0, null, 0);   
                request.setAttribute("listeetud", letud);
                request.setAttribute("msg", msg);
                RequestDispatcher rdisp = request.getRequestDispatcher("nouveauParent.jsp");
                rdisp.forward(request, response);
            }  catch (SQLException ex) {
            Logger.getLogger(InsertionParent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
