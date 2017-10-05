<%@page import="modele.Classe"%>
<%@page import="modele.Devoir"%>
<%@page import="java.util.ArrayList"%>
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
    List<Devoir> ldev = (ArrayList<Devoir>) request.getAttribute("listeDevoir");
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
                    <section class="content">
                        <div class="box box-default">

                            <div class="box-body">

                                <div class="box-header">
                                    <h3 class="box-title">Liste des devoir</h3>

                                </div>
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>CLASSE</th>
                                                <th>COMMENTAIRE</th>
                                                <th>LIBELE</th>
                                                <th>NOM du PDF</th>
                                                <th>DATE D' ENTRER</th>
                                                <th>DATE DE CORRECTION</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                        <%for (int i = 0; i < ldev.size(); i++) {%>
                                        <tr>
                                            <td><%=ldev.get(i).getId()%></td>
                                            <td><%=ldev.get(i).getIdClasse().getNomClasse()%></td>
                                            <td><%=ldev.get(i).getCommentaire()%></td>
                                            <td><%=ldev.get(i).getLibele().getNomMatiere()%></td>
                                            <td><%=ldev.get(i).getPdfUrl()%></td>
                                            <td><%=ldev.get(i).getDateEntrer()%></td>
                                            <td><%=ldev.get(i).getDateCorrection()%></td>
                                        </tr>
                                        <%}%>

                                    </tbody>
                                </table>
                            </div>
                        </div><!-- 
                                                      </div><!-- /.box-body -->
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

