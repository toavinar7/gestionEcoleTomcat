/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Bulletin;
import modele.Classe;
import modele.Etudiant;
import modele.Matiere;
import modele.Semestre;
import util.Fonction;
import util.FonctionNote;

/**
 *
 * @author toavina
 */
public class ListerEtudiantNote2 extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Fonction f=new Fonction();
          FonctionNote fonction = new FonctionNote();
         int idClasse=Integer.parseInt(request.getParameter("idClasse"));
         int idSemestre=Integer.parseInt(request.getParameter("idSemestre"));
         
        
            try {
           
                List<Classe>classe=new ArrayList<Classe>();
                List<Etudiant> letudiant= new ArrayList<Etudiant>();
                List<Matiere>listeMatiere=new ArrayList<Matiere>();
                
                List<Bulletin>listeBulletin=new ArrayList<Bulletin>();
                classe=f.listeClasse(idClasse);
                listeMatiere=fonction.listeMatiereClasse(idClasse);
                letudiant=f.listeEtudiant(0,null,idClasse);
                 List<Semestre>lsitSemestre=new ArrayList<Semestre>();
                  lsitSemestre=fonction.listerSemestre(0,idClasse);
                  if(idSemestre!=0){
                  listeBulletin=fonction.listeBulletin(0, 0, idSemestre);
                  }
                  request.setAttribute("listeMatiere", listeMatiere);
                request.setAttribute("classe", classe);
                request.setAttribute("letudiant", letudiant);
                request.setAttribute("lsitSemestre", lsitSemestre);
                request.setAttribute("listeBulletin", listeBulletin);
                RequestDispatcher rdisp = request.getRequestDispatcher("formulaireNoteBack.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListerEtudiantNote2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
