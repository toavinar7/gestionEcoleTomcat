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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Matiere;
import util.FonctionNote;
import util.Fonction;
/*
 *
 * @author toavina
 */
public class ServletAddCoef extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("tonga ato le izy ");
        
        FonctionNote fonction=new FonctionNote();
        Fonction f=new Fonction();
        List<Matiere>listeMatiere=new ArrayList<Matiere>();
        int idClasse=Integer.parseInt(request.getParameter("classe"));
         int matiere=Integer.parseInt(request.getParameter("matiere"));
           int coef=Integer.parseInt(request.getParameter("coef"));
        try {
            int note=fonction.insererCoefficient(matiere, coef);
             response.sendRedirect("ListerEtudiantNote?idClasse="+idClasse);
        } catch (SQLException ex) {
            Logger.getLogger(ServletAddCoef.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
