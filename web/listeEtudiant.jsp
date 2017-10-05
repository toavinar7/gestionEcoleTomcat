<%@page import="modele.Classe"%>
<%@page import="modele.Etudiant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page import="modele.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Admin admin = new Admin();
    try {
        if (request.getSession().getAttribute("admin") == null) {
            response.sendRedirect("connexionBack.jsp");
        } else {
            admin = (Admin) request.getSession().getAttribute("admin");
        }

    } catch (Exception ex) {
        throw ex;
    }
%>
<%
    List<Etudiant> letudiant = (ArrayList<Etudiant>) request.getAttribute("letudiant");
    Classe cls = (Classe) request.getAttribute("classe");
%>
<!DOCTYPE html>
<html>
    <title>index</title>
    <jsp:include page="tetePage.jsp"></jsp:include>
        <body class="hold-transition skin-blue sidebar-mini">
            <div class="wrapper">
            <%
                if (request.getSession().getAttribute("admin") != null) {%>
            <jsp:include page="headerBackoffice.jsp"></jsp:include>
            <% }
            %>


            <jsp:include page="menuLeftBackOffice.jsp"></jsp:include>
                <!-- Left side column. contains the logo and sidebar -->


                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>
                            BACKOFFICE
                            <small></small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="NouveauEtudiant?idclasse=<%=cls.getId()%>"><i class="fa fa-dashboard"></i> Nouveau</a></li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="box box-default">
                        <div class="box-header with-border">
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box">
                                        <div class="box-header">
                                            <h3 class="box-title">Listes des etudiants du <%=cls.getNomClasse()%></h3>
                                        </div><!-- /.box-header -->
                                        <div class="box-body">
                                            <table id="example1" class="table table-bordered table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>N°</th>
                                                        <th>NOM</th>
                                                        <th>PRENOM</th>
                                                        <th>CLASSE</th>
                                                        <th>IMATRICULE</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        if (letudiant.size() > 0) {
                                                            for (int i = 0; i < letudiant.size(); i++) {
                                                    %>

                                                    <tr>
                                                        <td><%=letudiant.get(i).getId()%></td>
                                                        <td><%=letudiant.get(i).getNom()%></td>

                                                        <td><%=letudiant.get(i).getPrenom()%></td>
                                                        <td><%=letudiant.get(i).getClasse().getNomClasse()%></td>
                                                        <td><%=letudiant.get(i).getImatricule()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    } else {

                                                    %>
                                                    <tr>
                                                        <td></td>

                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                    <%} %>
                                                   
                                                </tbody>
                                            </table>
                                        </div><!-- /.box-body -->
                                    </div><!-- /.box -->


                                </div>
                            </div><!-- /.row -->
                        </div><!-- /.box-body -->
                        <div class="box-footer">

                        </div>
                    </div><!-- /.box -->
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

