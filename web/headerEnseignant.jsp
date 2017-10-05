
<%@page import="modele.Enseignant"%>
<%@page import="modele.NotificationEleve"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Fonction f = new Fonction();
   Enseignant enseignantConnect = new Enseignant();
    try {

        if (request.getSession().getAttribute("enseignant") == null) {
            response.sendRedirect("connexion.jsp");
        } else {
           enseignantConnect = (Enseignant) request.getSession().getAttribute("enseignant");
        }

    } catch (Exception ex) {
        throw ex;
    }
%>
<header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>?</b>?<b>?</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Institution </b>nom <b> ...</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                        <span class="label label-success">1</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">Vous avez 1 message</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- start message -->
                                    <a href="#">
                                        <div class="pull-left">
                                            <img src="bootstrap/dist/img/userifr.jpg" class="img-circle" alt="User Image">
                                        </div>
                                        <h4>
                                            Dera
                                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                        </h4>
                                        <p>Misy devoir francais ao</p>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="footer"><a href="#">Voir tous les messages</a></li>
                    </ul>
                </li>
                <!-- Tasks: style can be found in dropdown.less -->
                
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="bootstrap/dist/img/userifr.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"><%=enseignantConnect.getPrenom()%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="bootstrap/dist/img/userifr.jpg" class="img-circle" alt="User Image">

                            <p>
                                <%=enseignantConnect.getPrenom() + " " + enseignantConnect.getNom()%> - Enseignant
                                <small>Classe <%=enseignantConnect.getLogin() %></small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Modifier</a>
                            </div>
                            <div class="pull-right">
                                <a href="DeconnexionServlet?dec=parent" class="btn btn-default btn-flat">Deconnecter</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <!-- <li>
                     <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                 </li>-->
            </ul>
        </div>
    </nav>
</header>
