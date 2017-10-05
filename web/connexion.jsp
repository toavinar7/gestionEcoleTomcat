<%-- 
    Document   : connexion
    Created on : 8 mai 2017, 10:58:50
    Author     : nat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>connexion</title>
    <jsp:include page="tetePage.jsp"></jsp:include>
    <body class="hold-transition skin-green layout-top-nav">
        <div class="wrapper">

            <header class="main-header">
                <nav class="navbar navbar-static-top">
                    <div class="container">
                         <div class="navbar-header">
                            <a href="#" class="navbar-brand"><b>Institution </b><b>FJKM </b><b> RAINANDRIAMAMPANDRY</b></a>
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                                <i class="fa fa-bars"></i>
                            </button>
                        </div>

                    </div><!-- /.container-fluid -->
                </nav>
            </header>
            <!-- Full Width Column -->
            <div class="content-wrapper">
                <div class="container">

                    <section class="content">
                        <div class="login-box">
                            <div class="login-logo">
                                <a href="#"><b>AUTHENTIFICATION</b></a>
                            </div><!-- /.login-logo -->
                            <div class="login-box-body">
                                <div class="nav-tabs-custom">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a href="#etudiant" data-toggle="tab">ETUDIANT</a></li>
                                        <li><a href="#enseignant" data-toggle="tab">ENSEIGNANT</a></li>
                                        <li><a href="#parent" data-toggle="tab">PARENT</a></li>
                                        
                                    </ul>
                                    <div class="tab-content">
                                         <%if(request.getAttribute("msg")!=null){%>
                                            <div class="alert alert-warning alert-dismissable">
                                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                                <h4><i class="icon fa fa-warning"></i></h4>
                                                <%=(String)request.getAttribute("msg")%>
                                              </div>
                                        <%}%>
                                        <div class="active tab-pane" id="etudiant">
                                            <p class="login-box-msg active">Authentification Eleve</p>
                                            <form action="ConnexionServlet" method="POST">
                                                <div class="form-group has-feedback">
                                                    <input type="hidden" name="utilisateur" value="eleve">
                                                    <input type="text" name="loginUt" class="form-control" placeholder="login">
                                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                                </div>
                                                <div class="form-group has-feedback">
                                                    <input type="password" name="passUt" class="form-control" placeholder="Mot de passe">
                                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                                </div>
                                                <div class="row">
                                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Connecter</button>

                                                </div>
                                            </form>
                                        </div><!-- /.tab-pane -->
                                        <div class="tab-pane" id="enseignant">
                                            <p class="login-box-msg active">Authentification Enseignant</p>
                                            <form action="ConnexionServlet" method="POST">
                                                <div class="form-group has-feedback">
                                                    <input type="hidden" name="utilisateur" value="enseignant">
                                                    <input type="text" name="loginen" class="form-control" placeholder="login">
                                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                                </div>
                                                <div class="form-group has-feedback">
                                                    <input type="password" name="passen" class="form-control" placeholder="Mot de passe">
                                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                                </div>
                                                <div class="row">
                                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Connecter</button>

                                                </div>
                                            </form>
                                        </div><!-- /.tab-pane -->
                                        
                                         <div class="tab-pane" id="parent">
                                            <p class="login-box-msg active">Authentification Parent</p>
                                            <form action="ConnexionServlet" method="POST">
                                                <div class="form-group has-feedback">
                                                    <input type="hidden" name="utilisateur" value="parent">
                                                    <input type="text" name="loginpa" class="form-control" placeholder="login">
                                                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                                </div>
                                                <div class="form-group has-feedback">
                                                    <input type="password" name="passpa" class="form-control" placeholder="Mot de passe">
                                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                                </div>
                                                <div class="row">
                                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Connecter</button>

                                                </div>
                                            </form>
                                        </div><!-- /.tab-pane -->
                                       
                                    </div><!-- /.tab-content -->
                                </div><!-- /.nav-tabs-custom -->




                                

                            </div><!-- /.login-box-body -->
                        </div><!-- /.login-box -->

                    </section><!-- /.content -->
                </div><!-- /.container -->
            </div><!-- /.content-wrapper -->
               <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    
                </div>
               <strong>Copyright &copy; 2016 <a href="#"><b>Newman's</b> Technology</a>.</strong>
                reserved.
            </footer>

           
            
        </div>
        <jsp:include page="piedPages.jsp"></jsp:include>
    </body>
</html>
