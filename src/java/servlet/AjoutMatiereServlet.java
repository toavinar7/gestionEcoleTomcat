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
import modele.EmploiDuTemp;
import modele.Enseignant;

import modele.HeureMatiere;
import util.Fonction;

/**
 *
 * @author MAMPYUN
 */
@WebServlet(name = "AjoutMatiereServlet", urlPatterns = {"/AjoutMatiereServlet"})
public class AjoutMatiereServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Fonction f=new Fonction();
         
         int idMatiere=Integer.parseInt(request.getParameter("idClasse"));
        try {
                Classe classe= new Classe();
                EmploiDuTemp emploi= new EmploiDuTemp();
                List<Enseignant> lmat= new ArrayList<Enseignant>();
                classe=f.listeClasse(idMatiere).get(0);
                emploi=f.listeEmploidutemp(idMatiere).get(0);
                lmat=f.listeEnseignant(0,idMatiere);
                request.setAttribute("lenseing", lmat);
                request.setAttribute("classe", classe);
                request.setAttribute("emploi", emploi);
                RequestDispatcher rdisp = request.getRequestDispatcher("formulaireAjoutMatiere.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AjoutMatiereServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
