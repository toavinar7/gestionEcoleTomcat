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
import modele.Enseignant;
import modele.Etudiant;
import modele.Message;
import modele.Parent;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "ChatEtudiantServlet", urlPatterns = {"/ChatEtudiantServlet"})
public class ChatEtudiantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idContact=Integer.parseInt(request.getParameter("idCt"));
        String ctactType=request.getParameter("type");
        
        Etudiant etudiant = new Etudiant();
        List<Admin> lAdmin=new ArrayList<Admin>();
        List<Etudiant> lEtu=new ArrayList<Etudiant>();
        List<Enseignant> lEns= new ArrayList<Enseignant>();
        List<Parent> lPrnt=new ArrayList<Parent>();
        
        Fonction f= new Fonction();
        List<Message> lMsg=new ArrayList<Message>();
        try {
            etudiant = (Etudiant) request.getSession().getAttribute("eleve");
            lMsg=f.listeConversation(etudiant.getId(),"etudiant", idContact, ctactType);
            lAdmin=f.listeAdmin(0);
            lEtu=f.listeEtudiant(0,null, 0);
            lEns=f.listeEnseignant(0, 0);
            lPrnt=f.listeParent(0);
            
            request.setAttribute("idCtct",idContact);
            request.setAttribute("ctactType",ctactType);
            request.setAttribute("lMsg",lMsg);
            request.setAttribute("lAdmin",lAdmin);
            request.setAttribute("lEtu",lEtu);
            request.setAttribute("lEns",lEns);
            request.setAttribute("lPrnt",lPrnt);
            RequestDispatcher rdisp = request.getRequestDispatcher("messageEtudiant.jsp");
            rdisp.forward(request, response);
            }  catch (SQLException ex) {
            Logger.getLogger(ChatEtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idContact=Integer.parseInt(request.getParameter("idCtct"));
        String ctactType=request.getParameter("typeCtct");
        int idPers=Integer.parseInt(request.getParameter("idPers"));
        String typePers=request.getParameter("typePers");
        String message=request.getParameter("message");
        List<Admin> lAdmin=new ArrayList<Admin>();
        List<Etudiant> lEtu=new ArrayList<Etudiant>();
        List<Enseignant> lEns= new ArrayList<Enseignant>();
        List<Parent> lPrnt=new ArrayList<Parent>();
        
        Fonction f= new Fonction();
        List<Message> lMsg=new ArrayList<Message>();
        try {
            int a=f.insererMessage(typePers, idPers, ctactType, idContact, message);
            lMsg=f.listeConversation(idPers,typePers, idContact, ctactType);
            
            lAdmin=f.listeAdmin(0);
            lEtu=f.listeEtudiant(0,null, 0);
            lEns=f.listeEnseignant(0, 0);
            lPrnt=f.listeParent(0);
            request.setAttribute("idCtct",idContact);
            request.setAttribute("ctactType",ctactType);
            request.setAttribute("lMsg",lMsg);
            request.setAttribute("lAdmin",lAdmin);
            request.setAttribute("lEtu",lEtu);
            request.setAttribute("lEns",lEns);
            request.setAttribute("lPrnt",lPrnt);
            RequestDispatcher rdisp = request.getRequestDispatcher("messageEtudiant.jsp");
            rdisp.forward(request, response);
            }  catch (SQLException ex) {
            Logger.getLogger(ChatEtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
