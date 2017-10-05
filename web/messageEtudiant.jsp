<%@page import="modele.Message"%>
<%@page import="modele.Parent"%>
<%@page import="modele.Enseignant"%>
<%@page import="modele.Admin"%>
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
    int idCtct=(Integer)request.getAttribute("idCtct");
    String typeCtct=(String)request.getAttribute("ctactType");
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
                            SMS
                            <small></small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Acceuil</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">

                            <!-- /.col -->

                            <div class="col-md-8">
                                <!-- USERS LIST -->
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


                                    </div>
                                    <!-- /.col -->
                                    <div class="col-md-9">
                                        <div class="box box-warning direct-chat direct-chat-warning" >
                                            <div class="box-header with-border">
                                                <h3 class="box-title">Chat</h3>
                                                <a href="ChatEtudiantServlet?idCt=<%=idCtct%>&type=<%=typeCtct%>"><button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button></a>

                                                <div class="box-tools pull-right">

                                                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                                    </button>
                                                    <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Contacts" data-widget="chat-pane-toggle">
                                                        <i class="fa fa-comments"></i></button>
                                                    <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i>
                                                    </button>
                                                </div>
                                            </div>
                                            <!-- /.box-header -->
                                            <div class="box-body">
                                                <!-- Conversations are loaded here -->
                                                <div class="direct-chat-messages" style="height: 410px">
                                                    <!-- Message. Default to the left -->
                                                <%
                                                    if (lmess.size() > 0) {
                                                        for (int i = 0; i < lmess.size(); i++) {
                                                            if ((lmess.get(i).getTypeMessage()).equalsIgnoreCase("ENVOYE")) {
                                                %>
                                                <div class="direct-chat-msg">
                                                    <div class="direct-chat-info clearfix">
                                                        <span class="direct-chat-name pull-left">
                                                            <%if (lmess.get(i).getAdm() != null) {%>
                                                            <a href="#"><%=lmess.get(i).getAdm().getPrenom() + " " + lmess.get(i).getAdm().getNom()%></a>
                                                            <%}%>
                                                            <%if (lmess.get(i).getEns() != null) {%>
                                                            <a href="#"><%=lmess.get(i).getEns().getPrenom() + " " + lmess.get(i).getEns().getNom()%></a>
                                                            <%}%>
                                                            <%if (lmess.get(i).getEtud() != null) {%>
                                                            <a href="#"><%=lmess.get(i).getEtud().getPrenom() + " " + lmess.get(i).getEtud().getNom()%></a>
                                                            <%}%>
                                                            <%if (lmess.get(i).getPart() != null) {%>
                                                            <a href="#"><%=lmess.get(i).getPart().getPrenom() + " " + lmess.get(i).getPart().getNom()%></a>
                                                            <%}%>

                                                        </span>
                                                        <span class="direct-chat-timestamp pull-right"><%=lmess.get(i).getDateMessage()%></span>
                                                    </div>
                                                    <!-- /.direct-chat-info -->
                                                    <img class="direct-chat-img" src="bootstrap/dist/img/userifr.jpg" alt="message user image"><!-- /.direct-chat-img -->
                                                    <div class="direct-chat-text">
                                                        <%=lmess.get(i).getMessage()%>
                                                    </div>
                                                    <!-- /.direct-chat-text -->
                                                </div>
                                                <%}
                                                    if ((lmess.get(i).getTypeMessage()).equalsIgnoreCase("RECEP")) {%>
                                                <div class="direct-chat-msg right">
                                                    <div class="direct-chat-info clearfix">
                                                        <span class="direct-chat-name pull-right">
                                                            <%if (lmess.get(i).getAdmCt() != null) {
                                                            %>
                                                            <a href="#"><%=lmess.get(i).getAdmCt().getPrenom() + " " + lmess.get(i).getAdmCt().getNom() + " - ADMIN"%></a>
                                                            <%}%>
                                                            <%if (lmess.get(i).getEnsCt() != null) {
                                                            %>
                                                            <a href="#"><%=lmess.get(i).getEnsCt().getPrenom() + " " + lmess.get(i).getEnsCt().getNom() + " - ENSEIGNANT"%></a>
                                                            <%}%>
                                                            <%if (lmess.get(i).getEtudCt() != null) {
                                                            %>
                                                            <a href="#"><%=lmess.get(i).getEtudCt().getPrenom() + " " + lmess.get(i).getEtudCt().getNom() + " - ETUDIANT"%></a>
                                                            <%}%>
                                                            <%if (lmess.get(i).getPartCt() != null) {
                                                            %>
                                                            <a href="#"><%=lmess.get(i).getPartCt().getPrenom() + " " + lmess.get(i).getPartCt().getNom() + " - PARENT"%></a>
                                                            <%}%>

                                                        </span>
                                                        <span class="direct-chat-timestamp pull-left"><%=lmess.get(i).getDateMessage()%></span>
                                                    </div>
                                                    <!-- /.direct-chat-info -->
                                                    <img class="direct-chat-img" src="bootstrap/dist/img/userifr.jpg" alt="message user image"><!-- /.direct-chat-img -->
                                                    <div class="direct-chat-text">
                                                        <%=lmess.get(i).getMessage()%>
                                                    </div>
                                                    <!-- /.direct-chat-text -->
                                                </div>
                                                <%
                                                            }
                                                        }
                                                    }
                                                %>


                                            </div>
                                            <!--/.direct-chat-messages-->

                                            <!-- Contacts are loaded here -->
                                            <div class="direct-chat-contacts" style="height: 410px">

                                                <ul class="contacts-list">
                                                    <%
                                                        if (ladm.size() > 0) {
                                                            for (int i = 0; i < ladm.size(); i++) {
                                                    %>

                                                    <li>
                                                        <a href="ChatEtudiantServlet?idCt=<%=ladm.get(i).getId() %>&type=admin">
                                                            <img class="contacts-list-img" src="bootstrap/dist/img/userifr.jpg" alt="User Image">

                                                            <div class="contacts-list-info">
                                                                <span class="contacts-list-name">
                                                                    <%=ladm.get(i).getPrenom() + " " + ladm.get(i).getNom()%> - admin
                                                                </span>
                                                            </div>
                                                            <!-- /.contacts-list-info -->
                                                        </a>
                                                    </li>



                                                    <%
                                                            }
                                                        }
                                                        if (letud.size() > 0) {
                                                            for (int i = 0; i < letud.size(); i++) {
                                                    %>

                                                    <li>
                                                        <a href="ChatEtudiantServlet?idCt=<%=letud.get(i).getId() %>&type=etudiant">
                                                            <img class="contacts-list-img" src="bootstrap/dist/img/userifr.jpg" alt="User Image">

                                                            <div class="contacts-list-info">
                                                                <span class="contacts-list-name">
                                                                    <%=letud.get(i).getPrenom() + " " + letud.get(i).getNom()%> - etudiant
                                                                </span>
                                                            </div>
                                                            <!-- /.contacts-list-info -->
                                                        </a>
                                                    </li>
                                                    <%
                                                            }
                                                        }
                                                        if (lens.size() > 0) {
                                                            for (int i = 0; i < lens.size(); i++) {
                                                    %>

                                                    <li>
                                                        <a href="ChatEtudiantServlet?idCt=<%=lens.get(i).getId() %>&type=enseignant">
                                                            <img class="contacts-list-img" src="bootstrap/dist/img/userifr.jpg" alt="User Image">

                                                            <div class="contacts-list-info">
                                                                <span class="contacts-list-name">
                                                                    <%=lens.get(i).getPrenom() + " " + lens.get(i).getNom()%> - enseignant
                                                                </span>
                                                            </div>
                                                            <!-- /.contacts-list-info -->
                                                        </a>
                                                    </li>
                                                    <%
                                                            }
                                                        }
                                                        if (lpar.size() > 0) {
                                                            for (int i = 0; i < lpar.size(); i++) {
                                                    %>

                                                    <li>
                                                        <a href="ChatEtudiantServlet?idCt=<%=lpar.get(i).getId() %>&type=parent">
                                                            <img class="contacts-list-img" src="bootstrap/dist/img/userifr.jpg" alt="User Image">

                                                            <div class="contacts-list-info">
                                                                <span class="contacts-list-name">
                                                                    <%=lpar.get(i).getPrenom() + " " + lpar.get(i).getNom()%> - parent
                                                                </span>
                                                            </div>
                                                            <!-- /.contacts-list-info -->
                                                        </a>
                                                    </li>
                                                    <%
                                                        }
                                                    } else {
                                                    %>
                                                    <li></li>
                                                        <%}%>

                                                </ul>
                                                <!-- /.contatcts-list -->
                                            </div>
                                            <!-- /.direct-chat-pane -->
                                        </div>
                                        <!-- /.box-body -->
                                        <div class="box-footer">
                                            <form action="ChatEtudiantServlet" method="post">
                                                <div class="input-group">
                                                    <input type="hidden" name="idCtct" value="<%=idCtct %>">
                                                    <input type="hidden" name="typeCtct" value="<%=typeCtct %>">
                                                    <input type="hidden" name="idPers" value="<%=etudiant.getId() %>">
                                                    <input type="hidden" name="typePers" value="etudiant">
                                                    <input type="text" name="message" placeholder="Message ..." class="form-control">
                                                    <span class="input-group-btn">
                                                        <button type="submit" class="btn btn-warning btn-flat">Envoyer</button>
                                                    </span>
                                                </div>
                                            </form>
                                        </div>
                                        <!-- /.box-footer-->
                                    </div>
                                    <!-- /. box -->
                                </div>
                                <!-- /.col -->
                            </div>
                            <!--/.box -->
                        </div>
                        <!-- /.col -->
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

