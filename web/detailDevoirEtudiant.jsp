<%@page import="modele.Devoir"%>
<%@page import="modele.NotificationEleve"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
    List<Devoir> ldevoir = (ArrayList<Devoir>) request.getAttribute("listeDevoir");
    // System.out.println("isany = " + ldevoir.size());
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

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Devoir <%=ldevoir.get(0).getLibele().getNomMatiere()%> du Mr/Mme <%= ldevoir.get(0).getIdEnseignant().getPrenom()%></h3>
                        </div>
                        <!-- /.box-header -->
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Commentaire</label>
                                    <textarea class="form-control" placeholder="<%=ldevoir.get(0).getCommentaire()%> ." disabled></textarea>
                                </div>

                                <div class="form-group">
                                    <label>Entrer  le</label>
                                    <input type="text" class="form-control" placeholder="<%=ldevoir.get(0).getDateEntrer()%> " disabled>
                                </div>
                                <div class="form-group">
                                    <label>A rendre  le</label>
                                    <input type="text" class="form-control" placeholder="<%=ldevoir.get(0).getDateCorrection()%>" disabled>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <a href="ListeDevoirEtudiant"><button type="button" class="btn btn-info pull-left"> <i class="fa fa-mail-reply-all"></i> Lister devoir</button></a>
                                <a href="DownloadDevoirEtudiant?devoir=<%=ldevoir.get(0).getPdfUrl()%>"><button type="button" class="btn btn-warning pull-right"> <i class="fa fa-download"></i> Télécharger</button></a>

                            </div>
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

