<%-- 
    Document   : menuLift
    Created on : 8 mai 2017, 12:36:24
    Author     : nat
--%>

<%@page import="modele.Semestre"%>
<%@page import="util.FonctionNote"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Matiere"%>
<%@page import="java.util.List"%>
<%@page import="modele.Etudiant"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Fonction f = new Fonction();
   FonctionNote note=new FonctionNote();
   List<Semestre>listeSemestre=new ArrayList<Semestre>();
   Etudiant etudiant = new Etudiant();
   int idClasse=0;
   List<Matiere> lsMatiere=new ArrayList<Matiere>();
    try {

        if (request.getSession().getAttribute("eleve") == null) {
            response.sendRedirect("connexion.jsp");
        } else {
           etudiant = (Etudiant) request.getSession().getAttribute("eleve");
           idClasse=etudiant.getClasse().getId();
           listeSemestre=note.listerSemestre(0, idClasse);
        }

    } catch (Exception ex) {
        throw ex;
    }
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
                <p><%=etudiant.getPrenom() + " " + etudiant.getNom()%></p>

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
                <a href="GetEmploiDuTempEtudiant?idls=<%=idClasse%>">
                    <i class="fa fa-calendar"></i> <span>Emploi du Temps</span>
                </a>
            </li>
           <li class="treeview">
                <a href="#">
                    <i class="fa fa-file-text-o"></i>
                    <span>Note</span>
                        <i class="fa fa-angle-left pull-right"></i>
                </a>
                  <ul class="treeview-menu">
                    <% if(listeSemestre!=null){ for(int i=0;i<listeSemestre.size();i++){ %>
                    <li class="active"><a href="GetNoteEtudiant?idEtudiant=<%=etudiant.getId()%>&idSemestre=<%=listeSemestre.get(i).getId()%>"><i class="fa fa-circle-o"></i> <% out.print(listeSemestre.get(i).getNomSemestre()); %></a></li>
                   <%}}%>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="ListeDevoirEtudiant">
                    <i class="fa fa-pencil"></i>
                    <span>Devoir</span>
                </a>
            </li>

            <li class="treeview">
                <a href="ServletInsererForum?code=eleve">
                    <i class="fa fa-forumbee"></i>
                    <span>Forum</span>
                    <span class="label label-primary pull-right"></span>
                </a>
            </li>
            <li class="treeview">
                <a href="MessageServlet?idpers=<%=etudiant.getId()%>&typePers=etudiant">
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
