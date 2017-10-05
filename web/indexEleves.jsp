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
                            <div class="col-md-4">
                                <!-- Widget: user widget style 1 -->
                                <div class="box box-widget widget-user">
                                    <!-- Add the bg color to the header using any of the bg-* classes -->
                                    <div class="widget-user-header bg-aqua-gradient">
                                        <h3 class="widget-user-username">Devoir Non Lu</h3>
                                        <h5 class="widget-user-desc"></h5>
                                    </div>
                                    <div class="widget-user-image">
                                        <img class="img-circle" src="bootstrap/dist/img/userifr.jpg" alt="User Avatar">
                                    </div>
                                    <div class="box-footer">
                                        <div class="row">
                                            <div class="col-sm-4 border-right">
                                                <div class="description-block">
                                                </div><!-- /.description-block -->
                                            </div><!-- /.col -->
                                            <div class="col-sm-4 border-right">
                                                <div class="description-block">
                                                    <h5 class="description-header">2</h5>
                                                <a href="ListerCommande?misy=mis"><span class="description-text">DEVOIR A FAIRE</span></a>
                                            </div><!-- /.description-block -->

                                        </div><!-- /.col -->
                                        <div class="col-sm-4">
                                            <div class="description-block">
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->

                                    </div><!-- /.row -->
                                </div>

                            </div><!-- /.widget-user -->
                        </div><!-- /.col -->
                        <div class="col-md-4">
                            <!-- Widget: user widget style 1 -->
                            <div class="box box-widget widget-user">
                                <!-- Add the bg color to the header using any of the bg-* classes -->
                                <div class="widget-user-header bg-aqua-active">
                                    <h3 class="widget-user-username">Message</h3>
                                    <h5 class="widget-user-desc"> </h5>
                                </div>
                                <div class="widget-user-image">
                                    <img class="img-circle" src="bootstrap/dist/img/userifr.jpg" alt="User Avatar">
                                </div>
                                <div class="box-footer">
                                    <div class="row">
                                        <div class="col-sm-4 border-right">
                                            <div class="description-block">
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->
                                        <div class="col-sm-4 border-right">
                                            <div class="description-block">
                                                <h5 class="description-header">0</h5>
                                                <a href="ListeLot?motif=epuiser"><span class="description-text">MESSAGE NON LU</span></a>
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->
                                        <div class="col-sm-4">
                                            <div class="description-block">
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div>
                            </div><!-- /.widget-user -->
                        </div><!-- /.col -->
                        <div class="col-md-4">
                            <!-- Widget: user widget style 1 -->
                            <div class="box box-widget widget-user">
                                <!-- Add the bg color to the header using any of the bg-* classes -->
                                <div class="widget-user-header bg-aqua-gradient">
                                    <h3 class="widget-user-username">Note</h3>
                                    <h5 class="widget-user-desc"> </h5>
                                </div>
                                <div class="widget-user-image">
                                    <img class="img-circle" src="bootstrap/dist/img/userifr.jpg" alt="User Avatar">
                                </div>
                                <div class="box-footer">
                                    <div class="row">
                                        <div class="col-sm-4 border-right">
                                            <div class="description-block">
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->
                                        <div class="col-sm-4 border-right">
                                            <div class="description-block">
                                                <h5 class="description-header">0</h5>
                                                <a href="ListeLot?motif=perimer"><span class="description-text">NOTE MODIFIER</span></a>
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->
                                        <div class="col-sm-4">
                                            <div class="description-block">
                                            </div><!-- /.description-block -->
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div>
                            </div><!-- /.widget-user -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->

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

