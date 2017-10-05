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
   List<Classe> lclasse=(ArrayList<Classe>) request.getAttribute("listeclasse");
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
                            <li><a href="#"><i class="fa fa-dashboard"></i> Nouveau</a></li>
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
                                    <%if(request.getAttribute("msg")!=null){%>
                                            <div class="alert alert-warning alert-dismissable">
                                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                                <h4><i class="icon fa fa-warning"></i></h4>
                                                <%=(String)request.getAttribute("msg")%>
                                              </div>
                                        <%}%>
                                    <form class="form" action="InsererEnseignant" method="GET">
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
                                            <label>Classe</label>
                                            <select name="classe" class="form-control select2" multiple="multiple" data-placeholder="Selectionner classe(s)" style="width: 100%;">
                                            
                                                <%for(int i=0;i<lclasse.size();i++){ %>
                                                <option value="<%=lclasse.get(i).getId() %>"><%=lclasse.get(i).getNomClasse() %></option>
                                                <%}%>
                                            </select>
                                        </div><!-- /.form-group -->
                                            
                                            <div class="form-group">
                                            <label>Matiere</label>
                                            <input type="text" name="matiere" class="form-control" placeholder="Enter Matiere">
                                        </div><!-- /.form-group -->
                                        <div class="form-group">
                                                <label >Login</label>
                                                <input type="text" name="login" class="form-control"  placeholder="Login">
                                            </div>
                                            <div class="form-group">
                                                <label >Mot de passe</label>
                                                <input type="password" name="mdp" class="form-control"  placeholder="Mot de passe">
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

