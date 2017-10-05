<%@page import="modele.Classe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page import="modele.Etudiant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Etudiant etudiant = new Etudiant();
    try {
        if (request.getSession().getAttribute("eleve") == null) {
            response.sendRedirect("connexion.jsp");
        } else {
            etudiant = (Etudiant) request.getSession().getAttribute("eleve");
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
                if (request.getSession().getAttribute("eleve") != null) {%>
            <jsp:include page="headerEleve.jsp"></jsp:include>
            <% }
            %>


            <jsp:include page="menuLeftEtudiant.jsp"></jsp:include>
                <!-- Left side column. contains the logo and sidebar -->


                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <h1>
                            MODIFICATION
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
                                    <small style="color: red;"><%if (request.getAttribute("msg") != null) {
                                                out.print(request.getAttribute("msg"));
                                        }%></small>
                                    <form class="form" action="UpdateEtudiant" method="POST">
                                        <div class="box-body">
                                            <div class="form-group">
                                                <label >Nom</label>
                                                <select name="" class="form-control select2" disabled="disabled" style="width: 100%;">

                                                    <option value="" selected="selected"><%=etudiant.getNom() %></option>

                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label >Prenom</label>
                                                <select name="" class="form-control select2" disabled="disabled" style="width: 100%;">

                                                    <option value="" selected="selected"><%=etudiant.getPrenom() %></option>

                                                </select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label >Imatricule</label>
                                                <select name="" class="form-control select2" disabled="disabled" style="width: 100%;">

                                                    <option value="" selected="selected"><%=etudiant.getImatricule() %></option>

                                                </select>
                                            </div>
                                            
                                            <div class="form-group">
                                            <label>Classe</label>
                                            <select name="classe" class="form-control select2" disabled="disabled" style="width: 100%;">
                                              
                                                <option value="" selected="selected"><%=etudiant.getClasse().getNomClasse() %></option>
                                            
                                            </select>
                                        </div><!-- /.form-group -->
                                        <div class="form-group">
                                                <input type="hidden" name="idEt" value="<%=etudiant.getId()%>">
                                                <label >Nouveau login</label>
                                                <input type="text" name="login" class="form-control"  placeholder="Login">
                                            </div>
                                            <div class="form-group">
                                                <label >Ancien mot de passe</label>
                                                <input type="password" name="mdpanc" class="form-control"  placeholder="************">
                                            </div>
                                            <div class="form-group">
                                                <label >Nouveau mot de passe</label>
                                                <input type="password" name="mdpnew" class="form-control"  placeholder="************">
                                            </div>  
                                            <div class="form-group">
                                                <label >Confirmation mot de passe</label>
                                                <input type="password" name="mdpconf" class="form-control"  placeholder="***********">
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

