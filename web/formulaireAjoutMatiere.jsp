<%@page import="modele.EmploiDuTemp"%>
<%@page import="modele.Classe"%>
<%@page import="modele.Enseignant"%>
<%@page import="modele.HeureMatiere"%>
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
    List<Enseignant> lmat = (ArrayList<Enseignant>) request.getAttribute("lenseing");;
    Classe classe = (Classe) request.getAttribute("classe");
    EmploiDuTemp emploi=(EmploiDuTemp)request.getAttribute("emploi");
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
                            <li><a href="#"><i class="fa fa-dashboard"></i> Ajouter Matiere</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">

                        <div class="box box-default">
                            <div class="box-header with-border">
                                <h3 class="box-title">Ajout Emploi du temp</h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                                </div>
                            </div><!-- /.box-header -->
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-10">
                                        <small style="color: red;"><%if (request.getAttribute("msg") != null) {
                                                out.print("erreur : " + request.getAttribute("msg"));
                                        }%></small>
                                    <form action="ValidationAjoutServlet" method="GET">
                                        <div class="box-body">
                                            <div class="form-group">
                                                <label>Classe</label>
                                                <input type="hidden" name="classe" value="<%=classe.getId()%>">
                                                <select class="form-control select2" disabled="disabled" style="width: 100%;">
                                                    <option selected="selected" ><%=classe.getNomClasse()%></option>
                                                </select>
                                                
                                            </div><!-- /.form-group -->


                                            <div class="form-group">
                                                <label>Nom Emploi du temp</label>
                                                <input type="hidden" name="emploi" value="<%=emploi.getId()%>">
                                                <select class="form-control select2" disabled="disabled" style="width: 100%;">
                                                    <option selected="selected" ><%=emploi.getNomEmployDuTemp()%></option>
                                                </select>
                                            </div><!-- /.form-group -->

                                            <div class="form-group">
                                                <label>Matiere</label>
                                                <select name="matiere" class="form-control select2" style="width: 100%;">
                                                    <option value="" selected="selected">selectionner</option>
                                                    <%for (int i = 0; i < lmat.size(); i++) {%>
                                                    <option value="<%=lmat.get(i).getId()%>"><%=lmat.get(i).getNom()%> -- <%=lmat.get(i).getMatiere().getNomMatiere()%></option>
                                                    <%}%>
                                                </select>
                                            </div><!-- /.form-group -->

                                            <div class="form-group">
                                                <label>Jour</label>
                                                <select name="jour" class="form-control select2" style="width: 100%;">
                                                    <option value="" selected="selected">selectionner</option>
                                                    <option value="lundi">LUNDI</option>
                                                    <option value="mardi">MARDI</option>
                                                    <option value="mercredi">MERCREDI</option>
                                                    <option value="jeudi">JEUDI</option>
                                                    <option value="vendredi">VENDREDI</option>
                                                </select>
                                            </div><!-- /.form-group -->

                                            <div class="form-group">
                                                <label>Heure debut</label>
                                                <select name="hdebut" class="form-control select2" style="width: 100%;">
                                                    <option value="" selected="selected">selectionner</option>
                                                    <option value="7">07H</option>
                                                    <option value="8">08H</option>
                                                    <option value="9">09H</option>
                                                    <option value="10">10H</option>
                                                    <option value="11">11H</option>
                                                    <option value="14">14H</option>
                                                    <option value="15">15H</option>
                                                    <option value="16">16H</option>
                                                    <option value="17">17H</option>

                                                </select>
                                            </div><!-- /.form-group -->

                                            <div class="form-group">
                                                <label>Heure fin</label>
                                                <select name="hfin" class="form-control select2" style="width: 100%;">
                                                    <option value="" selected="selected">selectionner</option>
                                                    <option value="8">08H</option>
                                                    <option value="9">09H</option>
                                                    <option value="10">10H</option>
                                                    <option value="11">11H</option>
                                                    <option value="12">12H</option>
                                                    <option value="15">15H</option>
                                                    <option value="16">16H</option>
                                                    <option value="17">17H</option>
                                                    <option value="18">18H</option>
                                                </select>
                                            </div><!-- /.form-group -->
                                        </div><!-- /.box-body -->

                                        <div class="box-footer">
                                            <button type="reset" class="btn btn-default">Annuler</button>
                                            <button type="submit" class="btn btn-info pull-right">Valider</button>
                                        </div>
                                    </form><!-- /.col -->
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

