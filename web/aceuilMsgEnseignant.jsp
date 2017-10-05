<%@page import="modele.Message"%>
<%@page import="modele.Parent"%>
<%@page import="modele.Etudiant"%>
<%@page import="modele.Admin"%>
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
    List<Admin> ladm = (ArrayList<Admin>) request.getAttribute("lAdmin");
    List<Etudiant> letud = (ArrayList<Etudiant>) request.getAttribute("lEtu");
    List<Enseignant> lens = (ArrayList<Enseignant>) request.getAttribute("lEns");
    List<Parent> lpar = (ArrayList<Parent>) request.getAttribute("lPrnt");
    List<Message> lmess = (ArrayList<Message>) request.getAttribute("lMsg");
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
                            Boîte de message
                            <small>13 nouveau messages</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Acceuil</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="box box-solid">
                                    <div class="box-header with-border">
                                        <div class="box-tools">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        </div>
                                    </div>
                                    <div class="box-body no-padding">
                                        <ul class="nav nav-pills nav-stacked">
                                            <li class="active"><a href="#"><i class="fa fa-inbox"></i> Boîte de réception
                                                    <span class="label label-primary pull-right">12</span></a></li>
                                            <li><a href="#"><i class="fa fa-envelope-o"></i> Message Envoyé</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="box box-solid">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Contact</h3>
                                        <div class="box-tools">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="box-body no-padding">
                                        <ul class="nav nav-pills nav-stacked">
                                        <%
                                            if (ladm.size() > 0) {
                                                for (int i = 0; i < ladm.size(); i++) {
                                        %>

                                        <li><a href="ChatEnseignantServlet?idCt=<%=ladm.get(i).getId()%>&type=admin"><i class="fa fa-circle-o text-light-blue"></i> <%=ladm.get(i).getPrenom() + " " + ladm.get(i).getNom()%> - admin</a></li>

                                        <%
                                            }
                                        } if (letud.size() > 0) {
                                            for (int i = 0; i < letud.size(); i++) {
                                        %>
                                        <li><a href="ChatEnseignantServlet?idCt=<%=letud.get(i).getId()%>&type=etudiant"><i class="fa fa-circle-o text-light-blue"></i> <%=letud.get(i).getPrenom() + " " + letud.get(i).getNom()%> - etudiant</a></li>
                                            <%
                                                }
                                            } if (lens.size() > 0) {
                                                for (int i = 0; i < lens.size(); i++) {
                                            %>
                                        <li><a href="ChatEnseignantServlet?idCt=<%=lens.get(i).getId()%>&type=enseignant"><i class="fa fa-circle-o text-light-blue"></i> <%=lens.get(i).getPrenom() + " " + lens.get(i).getNom()%> - enseignant</a></li>
                                            <%
                                                }
                                            }if (lpar.size() > 0) {
                                                for (int i = 0; i < lpar.size(); i++) {
                                            %>
                                        <li><a href="ChatEnseignantServlet?idCt=<%=lpar.get(i).getId()%>&type=parent"><i class="fa fa-circle-o text-light-blue"></i> <%=lpar.get(i).getPrenom() + " " + lpar.get(i).getNom()%> - parent</a></li>
                                            <%
                                                }
                                            } else {
                                            %>
                                        <li></li>
                                            <%}%>

                                    </ul>
                                </div>
                            </div>

                        </div>

                        <div class="col-md-9">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Message</h3>

                                    <div class="box-tools pull-right">
                                        <div class="has-feedback">
                                            <input type="text" class="form-control input-sm" placeholder="Search Mail">
                                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                        </div>
                                    </div>
                                    <!-- /.box-tools -->
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="mailbox-controls">
                                        <!-- Check all button -->
                                        <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                                        </button>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                        </div>
                                        <!-- /.btn-group -->
                                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>

                                        <!-- /.pull-right -->
                                    </div>
                                    <div class="table-responsive mailbox-messages">
                                        <table class="table table-hover table-striped">
                                            <tbody>
                                                <%
                                                    if (lmess.size() > 0) {
                                                        for (int i = 0; i < lmess.size(); i++) {
                                                %>
                                                <tr>
                                                    <td><input type="checkbox"></td>
                                                    <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                                    <td class="mailbox-name">
                                                        <%if (lmess.get(i).getAdmCt() != null) {%>
                                                        <a href="ChatEnseignantServlet?idCt=<%=lmess.get(i).getAdmCt().getId()%>&type=admin"><%=lmess.get(i).getAdmCt().getPrenom() + " " + lmess.get(i).getAdmCt().getNom() + " - Admin"%></a>
                                                        <%}%>
                                                        <%if (lmess.get(i).getEnsCt()!= null) {%>
                                                        <a href="ChatEnseignantServlet?idCt=<%=lmess.get(i).getEnsCt().getId()%>&type=enseignant"><%=lmess.get(i).getEnsCt().getPrenom() + " " + lmess.get(i).getEnsCt().getNom() + " - Enseignant"%></a>
                                                        <%}%>
                                                        <%if (lmess.get(i).getEtudCt() != null) {%>
                                                        <a href="ChatEnseignantServlet?idCt=<%=lmess.get(i).getEtudCt().getId()%>&type=etudiant"><%=lmess.get(i).getEtudCt().getPrenom() + " " + lmess.get(i).getEtudCt().getNom() + " - Etudiant"%></a>
                                                        <%}%>
                                                        <%if (lmess.get(i).getPartCt() != null) {%>
                                                        <a href="ChatEnseignantServlet?idCt=<%=lmess.get(i).getPartCt().getId()%>&type=parent"><%=lmess.get(i).getPartCt().getPrenom() + " " + lmess.get(i).getPartCt().getNom() + " - Parent"%></a>
                                                        <%}%>
                                                    </td>
                                                    <td class="mailbox-subject"><b><%=lmess.get(i).getMessage()%></td>
                                                </tr>
                                                <%
                                                    }
                                                } else {
                                                %>
                                                <tr>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                <%
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                        <!-- /.table -->
                                    </div>
                                    <!-- /.mail-box-messages -->
                                </div>
                                <!-- /.box-body -->
                                <div class="box-footer no-padding">
                                    <div class="mailbox-controls">
                                        <!-- Check all button -->
                                        <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                                        </button>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                        </div>
                                        <!-- /.btn-group -->
                                        <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                    </div>
                                    <!-- /.btn-group -->
                                </div>
                                <!-- /.pull-right -->
                            </div>
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

