/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import util.FonctionNote;
import modele.NoteEleve;

/**
 *
 * @author toavina
 */
public class DetailNoteBack extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
        int idSemestre = Integer.parseInt(request.getParameter("idSemestre"));
        int idBulletin=Integer.parseInt(request.getParameter("idBulletin"));
      
        System.out.println("idEtudiant=="+idEtudiant);
        System.out.println("idSemestre=="+idSemestre);
        System.out.println("idBulletin=="+idBulletin);
        FonctionNote noteFonction=new FonctionNote();
        
        List<NoteEleve>eleve=new ArrayList<NoteEleve>();
          List<Bulletin> listeBulletin = new ArrayList<Bulletin>();
        try {
            eleve=noteFonction.listerNoteEl(0, idEtudiant, idSemestre);
            listeBulletin=noteFonction.listeBulletin(idBulletin, 0, 0);
            request.setAttribute("eleve", eleve);
            request.setAttribute("listeBulletin", listeBulletin);
            RequestDispatcher rdisp = request.getRequestDispatcher("ModifierBulletinEleve.jsp");
            rdisp.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DetailNoteBack.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
