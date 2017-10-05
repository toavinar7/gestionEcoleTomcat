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
import modele.Etudiant;
import util.Fonction;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "NouveauParent", urlPatterns = {"/NouveauParent"})
public class NouveauParent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fonction f=new Fonction();
        List<Etudiant> letud=new ArrayList<Etudiant>();
        try {
                letud=f.listeEtudiant(0, null, 0);   
                request.setAttribute("listeetud", letud);
                RequestDispatcher rdisp = request.getRequestDispatcher("nouveauParent.jsp");
                rdisp.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NouveauParent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
