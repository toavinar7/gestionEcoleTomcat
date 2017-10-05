/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.FonctionNote;

/**
 *
 * @author toavina
 */
public class ServletInsererAppreciations extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idProf = Integer.parseInt(request.getParameter("idProf"));
        int idClasse = Integer.parseInt(request.getParameter("idClass"));
        int examen = Integer.parseInt(request.getParameter("examen"));
        
        int idNotei = Integer.parseInt(request.getParameter("idNote"));
        String note=request.getParameter("appreciaitions");
        
        FonctionNote fonctionNote=new FonctionNote();
        //double noted=Double.parseDouble(note);
        try {
            fonctionNote.updateAppreciaiton(idNotei, note);
            response.sendRedirect("ServletAddNote?idProf="+idProf+"&idClass="+idClasse+"&examen="+examen);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

  

}
