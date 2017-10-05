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
    List<Classe> lclasse = (ArrayList<Classe>) request.getAttribute("listeclasse");
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
                            <li><a href="nouveauclasse.jsp"><i class="fa fa-dashboard"></i>Nouveau</a></li>
                        </ol>
                    </section>

                    <section class="content">
                        <div class="box box-default">


                            <div class="box-header">
                                <h3 class="box-title">Liste des classes</h3>
                            </div>
                            <div class="box-body">
                                    <% for (int i = 0; i < lclasse.size(); i++) {%>
                                    <a class="btn btn-block btn-social btn-twitter">
                                        <i class="fa fa-archive"></i><%=lclasse.get(i).getNomClasse()%>
                                      </a>
                                    
                                    <%}%>
                        </div>
                        <div class="box-footer">

                        </div>
                    </div><!-- /.box-body -->
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

