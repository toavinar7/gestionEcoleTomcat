<%-- 
    Document   : menuLift
    Created on : 8 mai 2017, 12:36:24
    Author     : nat
--%>

<%@page import="modele.Etudiant"%>
<%@page import="modele.Parent"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Fonction f = new Fonction();
   Parent parentConnect = new Parent();
    try {

        if (request.getSession().getAttribute("parent") == null) {
            response.sendRedirect("connexion.jsp");
        } else {
           parentConnect = (Parent) request.getSession().getAttribute("parent");
        }

    } catch (Exception ex) {
        throw ex;
    }
%>
<%
    List<Etudiant> lEtud=parentConnect.getEleve();
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
                <p><%=parentConnect.getPrenom() + " " + parentConnect.getNom()%></p>

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
                
                <a href="#">
                    <i class="fa fa-calendar"></i>
                    <span>Emploi du temps</span>
                        <i class="fa fa-angle-left pull-right"></i>
                </a>
                
                <ul class="treeview-menu">
                    <% for(int i=0;i<lEtud.size();i++){%>
                    
                      <li><a href="GetEmploiDuTempParent?id=<%=lEtud.get(i).getClasse().getId() %>"><i class="fa fa-circle-o"></i> <%=lEtud.get(i).getPrenom() %></a></li>
                    <%}%>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-file-text-o"></i>
                    <span>Note</span>
                        <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                     <% for(int i=0;i<lEtud.size();i++){%>
                    <li class="active"><a href="GetNoteParent?idEtudiant=<%=lEtud.get(i).getId() %>&idClasse=<%=lEtud.get(i).getClasse().getId()%>"><i class="fa fa-circle-o"></i><%=lEtud.get(i).getPrenom() %></a></li>
                      <%}%>
                </ul>
            </li>

            <li class="treeview">
                <a href="ServletInsererForum?code=parent">
                    <i class="fa fa-forumbee"></i>
                    <span>Forum</span>
                    <span class="label label-primary pull-right"></span>
                </a>
            </li>
            <li class="treeview">
                <a href="MessageServlet?idpers=<%=parentConnect.getId()%>&typePers=parent">
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
