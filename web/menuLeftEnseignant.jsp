<%-- 
    Document   : menuLift
    Created on : 8 mai 2017, 12:36:24
    Author     : nat
--%>

<%@page import="util.FonctionNote"%>
<%@page import="modele.Classe"%>
<%@page import="modele.Enseignant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Fonction f = new Fonction();
   FonctionNote fo = new FonctionNote();
   List<Classe> listeClasse=new ArrayList<Classe>();
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
    listeClasse=f.listeClasseEnseignant(enseignantConnect.getId());
%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="bootstrap/dist/img/userifr.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><%=enseignantConnect.getPrenom() + " " + enseignantConnect.getNom()%></p>

            </div>
        </div>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MENU</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-home"></i> <span>Acceuil</span>
                </a>
            </li>
            <li class="treeview">
                
                <a href="GetEmploiDuTempEnseignant?idEnseing=<%=enseignantConnect.getId() %>">
                    <i class="fa fa-calendar"></i>
                    <span>Emploi du temps</span>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-file-text-o"></i>
                    <span>Note</span>
                        <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <% if(listeClasse!=null){ for(int i=0;i<listeClasse.size();i++){ %>
                    <li class="active"><a href="ServletMatiereProf?idClasse=<%=listeClasse.get(i).getId()%>&idProf=<%=enseignantConnect.getId()%>"><i class="fa fa-circle-o"></i> <% out.print(listeClasse.get(i).getNomClasse()); %></a></li>
                   <%}}%>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-file-text-o"></i>
                    <span>Devoir</span>
                        <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="active"><a href="nouveauDevoir.jsp"><i class="fa fa-plus-circle"></i> Nouveau</a></li>
                    <% if(listeClasse!=null){ for(int i=0;i<listeClasse.size();i++){ %>
                    <li class="active"><a href="ServletListerDevoirPr?idClasse=<%=listeClasse.get(i).getId()%>&idProf=<%=enseignantConnect.getId()%>"><i class="fa fa-circle-o"></i> <% out.print(listeClasse.get(i).getNomClasse()); %></a></li>
                   <%}}%>
                </ul>
            </li>

            <li class="treeview">
                <a href="ServletInsererForum?code=enseignant">
                    <i class="fa fa-forumbee"></i>
                    <span>Forum</span>
                    <span class="label label-primary pull-right"></span>
                </a>
            </li>
            <li class="treeview">
                <a href="MessageServlet?idpers=<%=enseignantConnect.getId()%>&typePers=enseignant">
                    <i class="fa fa-envelope-o"></i>
                    <span>Message</span>
                    <span class="label label-primary pull-right">4</span>
                </a>
            </li>

            <li class="header">-</li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
