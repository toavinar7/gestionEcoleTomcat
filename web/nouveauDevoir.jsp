<%@page import="modele.Matiere"%>
<%@page import="modele.Classe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="modele.Enseignant"%>
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
<!DOCTYPE html>
<html>
    <title>index</title>
    <jsp:include page="tetePage.jsp"></jsp:include>
        <body class="hold-transition skin-blue sidebar-mini">
            <div class="wrapper">
            <%
                if (request.getSession().getAttribute("enseignant") != null) {%>
            <jsp:include page="headerEnseignant.jsp"></jsp:include>
            <% }
            %>


            <jsp:include page="menuLeftEnseignant.jsp"></jsp:include>
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

                        <!-- SELECT2 EXAMPLE -->
                        <div class="box box-default">
                            <div class="box-header with-border">
                                <h3 class="box-title">Nouveau Devoir</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                                </div>
                            </div><!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="form" action="AjoutDevoir" method="POST"  enctype="multipart/form-data">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <label>Classe</label>
                                                    <select name="classe" class="form-control select2" style="width: 100%;">
                                                        <option value="" selected="selected">selectionner</option>
                                                    <%for (int i = 0; i < enseignantConnect.getClasse().size(); i++) {%>
                                                    <option value="<%=enseignantConnect.getClasse().get(i).getId()%>"><%=enseignantConnect.getClasse().get(i).getNomClasse()%></option>
                                                    <%}%>
                                                </select>
                                            </div><!-- /.form-group -->
                                            <div class="form-group">
                                                <label>Matière</label>
                                                <select name="matiere" class="form-control select2" style="width: 100%;">
                                                    <option value="" selected="selected">selectionner</option>
                                                    <option value="<%=enseignantConnect.getMatiere().getId()%>"><%=enseignantConnect.getMatiere().getNomMatiere()%></option>
                                                   
                                                </select>
                                            </div><!-- /.form-group -->
                                            <div class="form-group">
                                                <label >Description</label>
                                                <input type="text" name="description" class="form-control" placeholder="Enter description">
                                            </div>
                                            <div class="form-group">
                                                <label >Date devoir a rendre</label>
                                                <input type="text" class="form-control pull-right" name="dateRendre" placeholder="Enter date a rendre" id="reservation">
                                               
                                            </div>
                                            <div class="form-group">
                                                <label >document upload</label>
                                                <input type="file" name="file" size="50" />
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
        <script src="bootstrap/bootstrap-datepicker.js"></script>
        <script>
                    $(function () {
                        $('#reservation').datepicker();
                    });
        </script> 
    </body>
</html>

