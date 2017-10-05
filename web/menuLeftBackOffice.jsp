<%-- 
    Document   : menuLift
    Created on : 8 mai 2017, 12:36:24
    Author     : nat
--%>

<%@page import="modele.Admin"%>
<%@page import="modele.Classe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Fonction f = new Fonction();
   Admin adminCnct = new Admin();
   List<Classe> cls=new ArrayList<Classe>();
    try {

        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("connexionBack.jsp");
        } else {
           adminCnct = (Admin) request.getSession().getAttribute("admin");
           cls=f.listeClasse(0);
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
                <p><%=adminCnct.getPrenom() + " " + adminCnct.getNom()%></p>

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
                <a href="ListerDesClasse">
                    <i class="fa fa-list-ol"></i> <span>Classe</span>
                </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-list-ol"></i> <span>Utilisateur</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                
                <li>
                  <a href="#"><i class="fa fa-circle-o"></i> Etudiant<i class="fa fa-angle-left pull-right"></i></a>
                  <ul class="treeview-menu">
                      <% for(int i=0;i<cls.size();i++){%>
                      <li><a href="ListerEtudiant?idClasse=<%=cls.get(i).getId() %>"><i class="fa fa-circle-o"></i> <%=cls.get(i).getNomClasse() %></a></li>
                    <%}%>
                  </ul>
                </li>
                <li>
                  <a href="#"><i class="fa fa-circle-o"></i> Parent<i class="fa fa-angle-left pull-right"></i></a>
                  <ul class="treeview-menu">
                      <li class="active"><a href="NouveauParent"><i class="fa fa-plus-circle"></i> Nouveau</a></li>
                    <% for(int i=0;i<cls.size();i++){%>
                      <li><a href="ListerParent?idClasse=<%=cls.get(i).getId() %>"><i class="fa fa-circle-o"></i> <%=cls.get(i).getNomClasse() %></a></li>
                    <%}%>
                  </ul>
                </li>
                <li>
                  <a href="#"><i class="fa fa-circle-o"></i> Enseignant<i class="fa fa-angle-left pull-right"></i></a>
                  <ul class="treeview-menu">
                      <li class="active"><a href="NewEnseignant"><i class="fa fa-plus-circle"></i> Nouveau</a></li>
                    <% for(int i=0;i<cls.size();i++){%>
                      <li><a href="ListerEnseignant?idClasse=<%=cls.get(i).getId() %>"><i class="fa fa-circle-o"></i> <%=cls.get(i).getNomClasse() %></a></li>
                    <%}%>
                  </ul>
                </li>
                <li>
                  <a href="#"><i class="fa fa-circle-o"></i> Admin</a>
                </li>
              </ul>
            </li> 
            <li class="treeview">
                
                <a href="#">
                    <i class="fa fa-calendar"></i>
                    <span>Emploi du temps</span>
                        <i class="fa fa-angle-left pull-right"></i>
                </a>
                
                <ul class="treeview-menu">
                    <% for(int i=0;i<cls.size();i++){%>
                    
                      <li><a href="FormulaireEmploi?id=<%=cls.get(i).getId() %>"><i class="fa fa-circle-o"></i> <%=cls.get(i).getNomClasse() %></a></li>
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
                    <% for(int i=0;i<cls.size();i++){%>
                    
                      <li><a href="ListerEtudiantNote?idClasse=<%=cls.get(i).getId() %>"><i class="fa fa-circle-o"></i> <%=cls.get(i).getNomClasse() %></a></li>
                    <%}%>
                </ul>
            </li>

            <li class="treeview">
                <a href="ServletInsererForum?code=admin">
                    <i class="fa fa-forumbee"></i>
                    <span>Forum</span>
                    <span class="label label-primary pull-right"></span>
                </a>
            </li>
            <li class="treeview">
                <a href="MessageServlet?idpers=<%=adminCnct.getId()%>&typePers=admin">
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
