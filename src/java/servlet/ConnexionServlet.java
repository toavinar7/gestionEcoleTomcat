/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
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
import modele.Commentaire;
import modele.Enseignant;
import modele.Etudiant;
import modele.Parent;
import util.Fonction;


/**
 *
 * @author toavina
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/ConnexionServlet"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String utilisateur=request.getParameter("utilisateur");
        String login = request.getParameter("loginUt");
        String pass = request.getParameter("passUt");
        
        String loginen = request.getParameter("loginen");
        String passen = request.getParameter("passen");
        
        String loginpa = request.getParameter("loginpa");
        String passpa = request.getParameter("passpa");
        
        String loginadm = request.getParameter("loginadm");
        String passadm = request.getParameter("passadm");
        
        Fonction f = new Fonction();
        Etudiant us = new Etudiant();
        Parent pa = new Parent();
        Admin adm = new Admin();
        Enseignant en = new Enseignant();
        try {
            if(utilisateur.equalsIgnoreCase("eleve")){
                us=f.findEtudiant(login, pass);
                if(us!=null){
                    request.getSession().setAttribute("eleve", us);	
                    response.sendRedirect("indexEleves.jsp");
                    
                }
                else{
                    request.setAttribute("msg", "Veuiller verifier ou Contacter l'administrateur");
                    RequestDispatcher rdisp = request.getRequestDispatcher("connexion.jsp");
                    rdisp.forward(request, response);
                }
            }
            else if(utilisateur.equalsIgnoreCase("enseignant")){
                en=f.findEnseignant(loginen, passen);
                if(en!=null){
                    request.getSession().setAttribute("enseignant", en);	
                    response.sendRedirect("indexEnseignant.jsp");
                    
                }
                else{
                    request.setAttribute("msg", "Veuiller verifier ou Contacter l'administrateur");
                    RequestDispatcher rdisp = request.getRequestDispatcher("connexion.jsp");
                    rdisp.forward(request, response);
                }
            }
            else if(utilisateur.equalsIgnoreCase("parent")){
                pa=f.findParent(loginpa, passpa);
                if(pa!=null){
                    request.getSession().setAttribute("parent", pa);	
                    response.sendRedirect("indexParent.jsp");
                    
                }
                else{
                    request.setAttribute("msg", "Veuiller verifier ou Contacter l'administrateur");
                    RequestDispatcher rdisp = request.getRequestDispatcher("connexion.jsp");
                    rdisp.forward(request, response);
                }
            }
            
            else if(utilisateur.equalsIgnoreCase("admin")){
                adm=f.findAdmin(loginadm, passadm);
                if(pa!=null){
                    request.getSession().setAttribute("admin", adm);	
                    response.sendRedirect("indexBackoffice.jsp");
                    
                }
                else{
                    request.setAttribute("msg", "Veuiller reesayer");
                    RequestDispatcher rdisp = request.getRequestDispatcher("connexionBack.jsp");
                    rdisp.forward(request, response);
                }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(ConnexionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}