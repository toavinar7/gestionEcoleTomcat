<%@page import="modele.Classe"%>
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
   Classe lclasse=(Classe) request.getAttribute("listeclasse");
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
                            <li><a href="NouveauEtudiant"><i class="fa fa-dashboard"></i> Nouveau</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        
                        <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">Etudiant</h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="form" action="InsertionEtudiant" method="GET">
                                        <div class="box-body">
                                            <div class="form-group">
                                                <label >Nom</label>
                                                <input type="text" name="nom" class="form-control" placeholder="Enter Nom">
                                            </div>
                                            <div class="form-group">
                                                <label >Prenom</label>
                                                <input type="text" name="prenom" class="form-control" placeholder="Enter Prenom">
                                            </div>
                                            
                                            <div class="form-group">
                                                <label >Imatricule</label>
                                                <input type="text" name="im" class="form-control"  placeholder="Imatricule">
                                            </div>
                                            
                                            <div class="form-group">
                                            <label>Classe</label>
                                            <input type="hidden" name="classe" value="<%=lclasse.getId()%>">
                                            <select name="classe" class="form-control select2" disabled="disabled" style="width: 100%;">
                                              
                                                <option value="" selected="selected"><%=lclasse.getNomClasse() %></option>
                                            
                                            </select>
                                        </div>
                                        </div><!-- /.box-body -->
                                        

                                        <div class="box-footer">
                                            <button type="submit" class="btn btn-primary">Valider</button>
                                            <button type="reset" class="btn btn-danger">Annuler</button>
                                        </div>
                                    </form>


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

