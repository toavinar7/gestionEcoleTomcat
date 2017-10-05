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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Bulletin;
import modele.NoteEleve;
import modele.Semestre;
import util.FonctionNote;
/**
 *
 * @author toavina
 */
public class GetNoteDuTempParent extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
        int idClasse = Integer.parseInt(request.getParameter("idClasse"));
        FonctionNote noteFonction = new FonctionNote();
        List<Bulletin> listeBulletin = new ArrayList<Bulletin>();
        List<NoteEleve> noteEleve = new ArrayList<NoteEleve>();
        List<Semestre>listeSemestre=new ArrayList<Semestre>();
        try {
            listeSemestre=noteFonction.listerSemestre(0, idClasse);
           
            listeBulletin = noteFonction.listeBulletin1(0, idEtudiant, listeSemestre.get(0).getId());
            noteEleve = noteFonction.listerNoteEl(0, idEtudiant, listeSemestre.get(0).getId());
            request.setAttribute("idClasse", idClasse);
            request.setAttribute("Semestre", listeSemestre);
            request.setAttribute("listeBulletin", listeBulletin);
            request.setAttribute("noteEleve", noteEleve);
            RequestDispatcher rdisp = request.getRequestDispatcher("listeNoteParent.jsp");
            rdisp.forward(request, response);

        } catch (SQLException ex) {
        
            ex.printStackTrace();
        }
         
    }

  

}
