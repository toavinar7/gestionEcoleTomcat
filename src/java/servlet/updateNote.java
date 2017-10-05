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
import modele.NoteEleve;
import util.FonctionNote;
/**
 *
 * @author toavina
 */
public class updateNote extends HttpServlet {

    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ato njayyy zao");
        
        FonctionNote noteFonction=new FonctionNote();
        
        long idNoteEleve=Long.parseLong(request.getParameter("idNoteEleve"));
        double note=Double.parseDouble(request.getParameter("noteEleve"));
        
        double note1=Double.parseDouble(request.getParameter("noteEleve1"));
        List<NoteEleve>noteEleve=new ArrayList<NoteEleve>();
        List<Bulletin>listeBulletin=new ArrayList<Bulletin>();
        
            try {
                if(note!=0){
                    noteFonction.updateNote1(idNoteEleve, note);
                }
                if(note1!=0){
                    noteFonction.updateNote2(idNoteEleve, note1); 
                }
                
                noteEleve=noteFonction.listerNoteEl11(idNoteEleve);
                System.out.println("noteEleve==="+noteEleve);
                noteFonction.moyenneNote1(idNoteEleve, noteEleve.get(0).getNote(),noteEleve.get(0).getNote2() , noteEleve.get(0).getCoefficient().getCoef());
                listeBulletin=noteFonction.listeBulletin1(0, noteEleve.get(0).getEtudiant().getId(), noteEleve.get(0).getSemestre().getId());
                
                System.out.println("idEtudiant="+noteEleve.get(0).getEtudiant().getId());
                System.out.println("idSemestre="+noteEleve.get(0).getSemestre().getId());
                System.out.println("idBulletin="+listeBulletin.get(0).getId());
               response.sendRedirect("DetailNoteBack?idEtudiant="+noteEleve.get(0).getEtudiant().getId()+"&idSemestre="+noteEleve.get(0).getSemestre().getId()+"&idBulletin="+listeBulletin.get(0).getId());
            } catch (SQLException ex) {
                Logger.getLogger(updateNote.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

   

}
