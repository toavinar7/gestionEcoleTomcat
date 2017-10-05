/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nat
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/ConnexionServlet"})
public class DeconnexionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param=request.getParameter("dec");
        if(param.equalsIgnoreCase("eleve")){
            request.getSession().removeAttribute("eleve");
            response.sendRedirect("connexion.jsp");
        }
        if(param.equalsIgnoreCase("parent")){
            request.getSession().removeAttribute("parent");
            response.sendRedirect("connexion.jsp");
        }
        if(param.equalsIgnoreCase("admin")){
            request.getSession().removeAttribute("admin");
            response.sendRedirect("connexionBack.jsp");
        }
        
        
    }

}
