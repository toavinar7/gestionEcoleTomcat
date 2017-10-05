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
import modele.Admin;
import modele.Etudiant;
import modele.Message;
import modele.Enseignant;
import modele.Parent;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "MessageServlet", urlPatterns = {"/MessageServlet"})
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fonction f= new Fonction();
        List<Message> lMsg=new ArrayList<Message>();
        
        List<Admin> lAdmin=new ArrayList<Admin>();
        List<Etudiant> lEtu=new ArrayList<Etudiant>();
        List<Enseignant> lEns= new ArrayList<Enseignant>();
        List<Parent> lPrnt=new ArrayList<Parent>();
        
        int idPers=Integer.parseInt(request.getParameter("idpers"));
        String typePers=request.getParameter("typePers");
        try {
            lMsg=f.listeBoitMsg(idPers, typePers, "RECEP");
            
            lAdmin=f.listeAdmin(0);
            lEtu=f.listeEtudiant(0,null, 0);
            lEns=f.listeEnseignant(0, 0);
            lPrnt=f.listeParent(0);
            
            request.setAttribute("lMsg",lMsg);
            request.setAttribute("lAdmin",lAdmin);
            request.setAttribute("lEtu",lEtu);
            request.setAttribute("lEns",lEns);
            request.setAttribute("lPrnt",lPrnt);
            }  catch (SQLException ex) {
            Logger.getLogger(MessageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(typePers.equalsIgnoreCase("etudiant")){
            RequestDispatcher rdisp = request.getRequestDispatcher("acceuilMsgEtudiant.jsp");
            rdisp.forward(request, response);
        }
        if(typePers.equalsIgnoreCase("parent")){
            RequestDispatcher rdisp = request.getRequestDispatcher("acceuilMsgParent.jsp");
            rdisp.forward(request, response);
        }
        if(typePers.equalsIgnoreCase("enseignant")){
            RequestDispatcher rdisp = request.getRequestDispatcher("aceuilMsgEnseignant.jsp");
            rdisp.forward(request, response);
        }
        if(typePers.equalsIgnoreCase("admin")){
            RequestDispatcher rdisp = request.getRequestDispatcher("acceuilMsgAdmin.jsp");
            rdisp.forward(request, response);
        }
        
        
    }

}
