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
@WebServlet(name = "ValidationAjoutServlet", urlPatterns = {"/ValidationAjoutServlet"})
public class ValidationAjoutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idClasse=Integer.parseInt(request.getParameter("classe"));
        int idEmploi=Integer.parseInt(request.getParameter("emploi"));
        int idEnseingant=Integer.parseInt(request.getParameter("matiere"));
        String jour=request.getParameter("jour");
        int heureDebut=Integer.parseInt(request.getParameter("hdebut"));
        int heureFin=Integer.parseInt(request.getParameter("hfin"));
        Fonction f=new Fonction();
        try {
                String rep=f.insererMatiereEmploi(idClasse, idEmploi, idEnseingant, jour, heureDebut, heureFin);
               if(rep.equalsIgnoreCase("reussite")){
                   Classe cls=new Classe();
                    cls=f.listeClasse(idClasse).get(0);
                    List<HeureMatiere> lmat= new ArrayList<HeureMatiere>();
                    lmat=f.listeheureMatiere(0, idClasse, 0,0); 
                    request.setAttribute("classe", cls);
                    request.setAttribute("listemat", lmat);
                    RequestDispatcher rdisp = request.getRequestDispatcher("emploiDuTemps.jsp");
                    rdisp.forward(request, response);
               }
               else{
                   
                   
                Classe classe= new Classe();
                EmploiDuTemp emploi= new EmploiDuTemp();
                List<Enseignant> lmat= new ArrayList<Enseignant>();
                classe=f.listeClasse(idClasse).get(0);
                emploi=f.listeEmploidutemp(idClasse).get(0);
                lmat=f.listeEnseignant(0,idClasse);
                request.setAttribute("lenseing", lmat);
                request.setAttribute("classe", classe);
                request.setAttribute("emploi", emploi);
                request.setAttribute("msg", rep);
                RequestDispatcher rdisp = request.getRequestDispatcher("formulaireAjoutMatiere.jsp");
                rdisp.forward(request, response);
               }
        } catch (Exception ex) {
            Logger.getLogger(AjoutMatiereServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
