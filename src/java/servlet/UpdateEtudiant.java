/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "UpdateEtudiant", urlPatterns = {"/UpdateEtudiant"})
public class UpdateEtudiant extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEt=Integer.parseInt(request.getParameter("idEt"));
        String mdpanc=request.getParameter("mdpanc");
        String mdpnew=request.getParameter("mdpnew");
        String mdpconf=request.getParameter("mdpconf");
        String login=request.getParameter("login");
        Fonction f=new Fonction();
        try {
                String rep=f.updateet(idEt, login, mdpanc, mdpnew, mdpconf);
                request.setAttribute("msg", rep);
                RequestDispatcher rdisp = request.getRequestDispatcher("modificationEtudiant.jsp");
                rdisp.forward(request, response);
               
        } catch (Exception ex) {
            Logger.getLogger(UpdateEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
