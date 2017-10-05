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
import modele.HeureMatiere;
import util.Fonction;

@WebServlet(name = "FormulaireEmploi", urlPatterns = {"/FormulaireEmploi"})
public class FormulaireEmploi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Fonction f=new Fonction();
         int id=Integer.parseInt(request.getParameter("id"));
        try {
                Classe cls=new Classe();
                cls=f.listeClasse(id).get(0);
                List<HeureMatiere> lmat= new ArrayList<HeureMatiere>();
                lmat=f.listeheureMatiere(0, id, 0,0);   
                request.setAttribute("classe", cls);
                request.setAttribute("listemat", lmat);
                RequestDispatcher rdisp = request.getRequestDispatcher("emploiDuTemps.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FormulaireEmploi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
