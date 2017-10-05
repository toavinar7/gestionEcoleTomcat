<%@page import="modele.Admin"%>
<%@page import="modele.NotificationEleve"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Fonction f = new Fonction();
    Admin admin = new Admin();
    try {
            admin = (Admin) request.getSession().getAttribute("admin");

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
              
                <!-- Tasks: style can be found in dropdown.less -->
                
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="bootstrap/dist/img/userifr.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"><%=admin.getPrenom()%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="bootstrap/dist/img/userifr.jpg" class="img-circle" alt="User Image">

                            <p>
                                <%=admin.getPrenom() + " " + admin.getNom()%> - Admin
                                <small>Classe <%=admin.getLogin() %></small>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">Modifier</a>
                            </div>
                            <div class="pull-right">
                                <a href="DeconnexionServlet?dec=admin" class="btn btn-default btn-flat">Deconnecter</a>
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
