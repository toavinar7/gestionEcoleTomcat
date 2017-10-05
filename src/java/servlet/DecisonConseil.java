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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Bulletin;
import util.FonctionNote;

/**
 *
 * @author toavina
 */
public class DecisonConseil extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         int idBulletin=Integer.parseInt(request.getParameter("idBulletin"));
         int idClasse=Integer.parseInt(request.getParameter("idClasse"));
      
         String appreciation=request.getParameter("appreciation");
         FonctionNote note=new FonctionNote();
         List<Bulletin>listeBulletin=new ArrayList<Bulletin>();
         System.out.println("idBulletin="+idBulletin+",appreciation="+appreciation);
        try {
            note.updateDecisonConseil(idBulletin, appreciation);
            listeBulletin=note.listeBulletin(idBulletin, 0, 0);
            int idSemestre=listeBulletin.get(0).getIdSemestre().getId();
            response.sendRedirect("ServletNoteSemestre?idClasse="+idClasse+"&idSemestre="+idSemestre);
        } catch (SQLException ex) {
            Logger.getLogger(DecisonConseil.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

  

}
