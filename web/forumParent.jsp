<%@page import="modele.Commentaire"%>
<%@page import="modele.Forum"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
    List<Forum> lForum = (ArrayList<Forum>) request.getAttribute("lForum");
    Fonction f=new Fonction();
    List<Commentaire> lcom= new ArrayList<Commentaire>();
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
                        <div class="row">
                            <div class="col-md-12">
                                <div class="nav-tabs-custom">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a href="#activity" data-toggle="tab">Forum</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="active tab-pane" id="activity">
                                            <div class="post">
                                                <div class="user-block">
                                                    <img class="img-circle img-bordered-sm" src="bootstrap/dist/img/userifr.jpg" alt="user image">
                                                    <span class="username">
                                                        <a href="#"><%=parent.getNom() + " " + parent.getPrenom()%></a>
                                                    <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                                                </span>
                                                <span class="description">Votre sujet à commenter</span>
                                            </div>
                                            <form method="post" action="ServletInsererForum" class="form-horizontal">
                                                <div class="form-group margin-bottom-none">
                                                    <input type="hidden" name="personne"value="parent">
                                                    <input type="hidden" name="idpersonne"value="<%=parent.getId()%>">
                                                    <div class="col-sm-11">
                                                        <textarea name="sujet" class="form-control input-sm" placeholder="Sujet..."></textarea>
                                                    </div>
                                                    <div class="col-sm-1">
                                                        <button type="submit" class="btn btn-warning pull-right btn-block btn-sm">Envoyer</button>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>
                                        <%if (lForum != null) {
                                                for (int i = 0; i < lForum.size(); i++) {
                                        %>
                                        <div class="post clearfix">
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="bootstrap/dist/img/userifr.jpg" alt="User Image">
                                                <span class="username">
                                                    <%if (lForum.get(i).getAdm() != null) {%>
                                                    <a href="#"><%=lForum.get(i).getAdm().getPrenom() + " " + lForum.get(i).getAdm().getNom() + " - ADMIN"%></a>
                                                    <%}%>
                                                    <%if (lForum.get(i).getEns() != null) {%>
                                                    <a href="#"><%=lForum.get(i).getEns().getPrenom() + " " + lForum.get(i).getEns().getNom() + " - ENSEIGNANT"%></a>
                                                    <%}%>
                                                    <%if (lForum.get(i).getEtud() != null) {%>
                                                    <a href="#"><%=lForum.get(i).getEtud().getPrenom() + " " + lForum.get(i).getEtud().getNom() + " - ETUDIANT"%></a>
                                                    <%}%>
                                                    <%if (lForum.get(i).getPart() != null) {%>
                                                    <a href="#"><%=lForum.get(i).getPart().getPrenom() + " " + lForum.get(i).getPart().getNom() + " - PARENT"%></a>
                                                    <%}%>
                                                    <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                                                </span>
                                                <span class="description">Sujet du <%=lForum.get(i).getDateForm()%></span>
                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                               <h5 style="color: #00a157;">Sujet : <%=lForum.get(i).getSujet()%></h5>
                                            </p>
                                            

                                            <h6>Commentaire</h6>
                                            <% lcom = f.listeComment(0, lForum.get(i).getId());
                                                if (lcom != null) {
                                                    for (int j = 0; j < lcom.size(); j++) {
                                            %>
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="bootstrap/dist/img/userifr.jpg" alt="User Image">
                                                <span class="username">
                                                    <%if (lcom.get(j).getAdm() != null) {%>
                                                    <h6><a href="#"><%=lcom.get(j).getAdm().getPrenom() + " " + lcom.get(j).getAdm().getNom() + " - ADMIN"%></a></h6>
                                                        <%}%>
                                                        <%if (lcom.get(j).getEns() != null) {%>
                                                    <h6><a href="#"><%=lcom.get(j).getEns().getPrenom() + " " + lcom.get(j).getEns().getNom() + " - ENSEIGNANT"%></a></h6>
                                                        <%}%>
                                                        <%if (lcom.get(j).getEtud() != null) {%>
                                                    <h6><a href="#"><%=lcom.get(j).getEtud().getPrenom() + " " + lcom.get(j).getEtud().getNom() + " - ETUDIANT"%></a></h6>
                                                        <%}%>
                                                        <%if (lcom.get(j).getPart() != null) {%>
                                                    <h6><a href="#"><%=lcom.get(j).getPart().getPrenom() + " " + lcom.get(j).getPart().getNom() + " - PARENT"%></a></h6>
                                                        <%}%>
                                                    <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                                                </span>
                                                <h6><span class="description">commentaire du <%=lcom.get(j).getDateComment()%></span></h6>
                                                <h6 style="color: #E98582;"> <%=lcom.get(j).getComment()%></h6>
                                            </div>
                                            <% }
                                                }
                                            %>

                                            <form method="get" action="ServletInsererForum" class="form-horizontal">
                                                <div class="form-group margin-bottom-none">
                                                    <input type="hidden" name="personne"value="parent">
                                                    <input type="hidden" name="code2"value="commentaire">
                                                    <input type="hidden" name="code"value="parent">
                                                    <input type="hidden" name="idpersonne"value="<%=parent.getId()%>">
                                                    <input type="hidden" name="idForum"value="<%=lForum.get(i).getId()%>">
                                                    <div class="col-sm-11">
                                                        <input type="text" name="comment" class="form-control input-sm" placeholder="Commentaire....">
                                                    </div>
                                                    <div class="col-sm-1">
                                                        <button type="submit" class="btn btn-danger pull-right btn-block btn-sm">Commenter</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <%}
                                            }%>
                                        <!-- /.post -->

                                        <!-- Post -->

                                        <!-- /.post -->
                                    </div>
                                    <!-- /.tab-pane -->

                                    <!-- /.tab-pane -->


                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div>
                            <!-- /.nav-tabs-custom -->
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

