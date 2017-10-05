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
import modele.Forum;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "ServletInsererForum", urlPatterns = {"/ServletInsererForum"})
public class ServletInsererForum extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fonction f= new Fonction();
        String code=request.getParameter("code");
        List<Forum> lForum=new ArrayList<Forum>();
        try {
            if(request.getParameter("code2")!=null){
                String personne=request.getParameter("personne");
                int idpersonne=Integer.parseInt(request.getParameter("idpersonne"));
                int idForum=Integer.parseInt(request.getParameter("idForum"));
                String comment=request.getParameter("comment");
                int ins=f.insertComment(personne, idpersonne, comment, idForum);
            }
            lForum=f.listeForum(0);
            request.setAttribute("lForum",lForum);
            }  catch (SQLException ex) {
            Logger.getLogger(InsererEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(code.equalsIgnoreCase("eleve")){
            RequestDispatcher rdisp = request.getRequestDispatcher("forumEtudiant.jsp");
            rdisp.forward(request, response);
        }
        if(code.equalsIgnoreCase("parent")){
            RequestDispatcher rdisp = request.getRequestDispatcher("forumParent.jsp");
            rdisp.forward(request, response);
        }
        if(code.equalsIgnoreCase("enseignant")){
            RequestDispatcher rdisp = request.getRequestDispatcher("forumEnseignant.jsp");
            rdisp.forward(request, response);
        }
        if(code.equalsIgnoreCase("admin")){
            RequestDispatcher rdisp = request.getRequestDispatcher("forumAdmin.jsp");
            rdisp.forward(request, response);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String personne=request.getParameter("personne");
        int idpersonne=Integer.parseInt(request.getParameter("idpersonne"));
        String sujet=request.getParameter("sujet");
        Fonction f= new Fonction();
        List<Forum> lForum=new ArrayList<Forum>();
        try {
            int matiere=f.insertForum(personne, idpersonne, sujet);
            lForum=f.listeForum(0);
            request.setAttribute("lForum",lForum);
            if(personne.equalsIgnoreCase("etudiant")){
                RequestDispatcher rdisp = request.getRequestDispatcher("forumEtudiant.jsp");
                rdisp.forward(request, response);
            }
            if(personne.equalsIgnoreCase("parent")){
                RequestDispatcher rdisp = request.getRequestDispatcher("forumParent.jsp");
                rdisp.forward(request, response);
            }
            if(personne.equalsIgnoreCase("enseignant")){
                RequestDispatcher rdisp = request.getRequestDispatcher("forumEnseignant.jsp");
                rdisp.forward(request, response);
            }
            if(personne.equalsIgnoreCase("admin")){
                RequestDispatcher rdisp = request.getRequestDispatcher("forumAdmin.jsp");
                rdisp.forward(request, response);
            }
            
            
            }  catch (SQLException ex) {
            Logger.getLogger(InsererEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
