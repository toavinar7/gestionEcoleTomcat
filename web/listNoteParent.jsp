<%@page import="modele.Semestre"%>
<%@page import="util.FonctionNote"%>
<%@page import="modele.Matiere"%>
<%@page import="modele.NoteEleve"%>
<%@page import="modele.Bulletin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page import="modele.Parent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Parent parent = new Parent();
    try {
        if (request.getSession().getAttribute("parent") == null) {
            response.sendRedirect("connexion.jsp");
        } else {
            parent = (Parent) request.getSession().getAttribute("parent");
        }

    } catch (Exception ex) {
        throw ex;
    }

    List<Bulletin> listeBulletin = (ArrayList<Bulletin>) request.getAttribute("listeBulletin");

    List<NoteEleve> noteEleve = (ArrayList<NoteEleve>) request.getAttribute("noteEleve");
    Fonction f = new Fonction();
    FonctionNote note = new FonctionNote();
    List<Matiere> matiere = new ArrayList<Matiere>();
    List<Semestre> semestre = new ArrayList<Semestre>();
%>
<!DOCTYPE html>
<html>
    <title>index</title>
    <jsp:include page="tetePage.jsp"></jsp:include>
        <body class="hold-transition skin-blue sidebar-mini">
            <div class="wrapper">
            <%
                if (request.getSession().getAttribute("parent") != null) {%>
            <jsp:include page="headerParent.jsp"></jsp:include>
            <% }
            %>


            <jsp:include page="menuLeftParent.jsp"></jsp:include>
                <!-- Left side column. contains the logo and sidebar -->


                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>
                            ACCEUIL
                            <small></small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Acceuil</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                        <% if (noteEleve != null) {%>




                        <div class="col-lg-10">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>


                                        <td>matiere</td>
                                        <td>semestre</td>

                                        <td>note</td>

                                    </tr>
                                </thead>
                                <%  for (int i = 0; i < noteEleve.size(); i++) {
                                        matiere = f.listeMatiere(noteEleve.get(i).getMatiere().getId());
                                        semestre = note.listerSemes(noteEleve.get(i).getSemestre().getId());
                                %>
                                <tr>


                                    <td><% out.print(matiere.get(0).getNomMatiere()); %></td>
                                    <td><% out.print(semestre.get(0).getNomSemestre()); %></td>

                                     <%if(noteEleve.get(i).getNote()>=0){%>
                                    <td><% out.print(noteEleve.get(i).getNote()); %></td>
                                    <%}else{%>
                                    <td></td>
                                    <%}%>

                                </tr>
                                <%}%>
                            </table>
                        </div>

                        <%}%>
                        <%if (listeBulletin != null) {%>
                        <div class="col-lg-2">
                            <div class="box box-solid">
                                <div class="box-header with-border">
                                    <h3 class="box-title">moyenne</h3>

                                    <div class="box-tools">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="box-body no-padding">
                                    <ul class="nav nav-pills nav-stacked">
                                        <% for (int i = 0; i < listeBulletin.size(); i++) { %>
                                        <li><a href="#"> <% out.print(listeBulletin.get(i).getIdSemestre().getNomSemestre()); %> =<% out.print(listeBulletin.get(i).getMoyenne()); %></a>

                                        </li>
                                        <%}%>


                                    </ul>
                                </div>
                            </div>
                        </div>
                        <%}%>
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs">

                </div>
              
            </footer>



        </div>
        <jsp:include page="piedPages.jsp"></jsp:include>
    </body>
</html>

