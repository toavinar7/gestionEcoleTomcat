<%@page import="util.Fonction"%>
<%@page import="modele.Parent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Parent parent = new Parent();
    try {
        if (request.getSession().getAttribute("parent") == null) {
            response.sendRedirect("connexion.jsp");
        } else {
            parent = (Parent) request.getSession().getAttribute("parent");
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
                if (request.getSession().getAttribute("parent") != null) {%>
            <jsp:include page="headerParent.jsp"></jsp:include>
            <% }
            %>


            <jsp:include page="menuLeftParent.jsp"></jsp:include>
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

