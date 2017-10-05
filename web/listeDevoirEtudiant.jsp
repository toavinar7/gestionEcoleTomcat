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
    List<NotificationEleve> ldevoir = (ArrayList<NotificationEleve>) request.getAttribute("listeDevoir");
   
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
                        <div class="box box-default">

                            <div class="box-body">

                                <div class="box-header">
                                    <h3 class="box-title">Liste des devoir</h3>

                                </div>
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>N°</th>
                                                <th>MATIERE</th>
                                                <th>PROF</th>
                                                <th>COMMENTAIRE</th>
                                                <th>NOM du PDF</th>
                                                <th>DATE D' ENTRER</th>
                                                <th>DATE DE CORRECTION</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                        <%for (int i = 0; i < ldevoir.size(); i++) {%>
                                        <%if (ldevoir.get(i).getNotification() == 1) {%> 
                                     
                                        <tr  class="trTableDevoir" bgcolor="#e0dfe3" id="<%=ldevoir.get(i).getDevoir().getId()%>" value="<%=ldevoir.get(i).getDevoir().getPdfUrl()%>">
                                            
   
                                            <td><%=ldevoir.get(i).getDevoir().getId()%></td>
                                            <td><%=ldevoir.get(i).getNomMatiere().getNomMatiere()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getIdEnseignant().getPrenom()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getCommentaire()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getPdfUrl()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getDateEntrer()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getDateCorrection()%></td>
                                            <td><a href="DetailDevoirEtudiant?idDevoir=<%= ldevoir.get(i).getDevoir().getId() %>"><button type="button" class="btn btn-info pull-right">Détail</button></a></td>
                                            <td><a href="DownloadDevoirEtudiant?devoir=<%=ldevoir.get(i).getDevoir().getPdfUrl() %>"><button type="button" class="btn btn-warning pull-right"> <i class="fa fa-download"></i> Télécharger</button></a></td>
                                           
                                        </tr>
                                     
                                        <%} else if (ldevoir.get(i).getNotification() == 0) {%>
                                        <tr class="trTableDevoir" bgcolor="white" id="<%=ldevoir.get(i).getDevoir().getId()%>"  value="<%=ldevoir.get(i).getDevoir().getPdfUrl()%>">
                                            
                                            <td><%=ldevoir.get(i).getDevoir().getId()%></td>
                                            <td><%=ldevoir.get(i).getNomMatiere().getNomMatiere()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getIdEnseignant().getPrenom()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getCommentaire()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getPdfUrl()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getDateEntrer()%></td>
                                            <td><%=ldevoir.get(i).getDevoir().getDateCorrection()%></td>
                                            <td><a href="DetailDevoirEtudiant?idDevoir=<%= ldevoir.get(i).getDevoir().getId() %>"><button type="button" class="btn btn-info pull-right">Détail</button></a></td>
                                            <td><a href="DownloadDevoirEtudiant?devoir=<%=ldevoir.get(i).getDevoir().getPdfUrl() %>"><button type="button" class="btn btn-warning pull-right"> <i class="fa fa-download"></i> Télécharger</button></a></td>
                                           
                                        </tr>
                                        <%}
                                            }%>

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
        
        <style>
            #example1 tr:hover {
                background-color: #ccc;
            }
            #example1 td:hover {
                cursor: pointer;
            }
        </style>
    </body>
</html>

