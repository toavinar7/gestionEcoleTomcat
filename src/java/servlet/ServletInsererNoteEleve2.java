package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.NoteEleve;
import util.FonctionNote;

/**
 *
 * @author toavina
 */
public class ServletInsererNoteEleve2 extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProf = Integer.parseInt(request.getParameter("idProf"));
        int idClasse = Integer.parseInt(request.getParameter("idClass"));
        int examen = Integer.parseInt(request.getParameter("examen"));
            int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
        long idNotei = Long.parseLong(request.getParameter("idNote"));
        String note=request.getParameter("noteEtudiant");
        //idCoefficient
         int idCoefficient = Integer.parseInt(request.getParameter("idCoefficient"));
        FonctionNote fonctionNote=new FonctionNote();
        double noted=Double.parseDouble(note);
        List<NoteEleve> listerNoteEleve=new ArrayList<NoteEleve>();
        try {
            fonctionNote.updateNote2(idNotei, noted);
            //idEtudiant
            listerNoteEleve=fonctionNote.listerNoteEl(idNotei, idEtudiant, examen);
            fonctionNote.moyenneNote1(idNotei, listerNoteEleve.get(0).getNote(), listerNoteEleve.get(0).getNote2(),idCoefficient);
            response.sendRedirect("ServletAddNote?idProf="+idProf+"&idClass="+idClasse+"&examen="+examen);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }


}