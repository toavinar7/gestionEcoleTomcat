<%@page import="modele.Coefficient"%>
<%@page import="modele.Matiere"%>
<%@page import="modele.Bulletin"%>
<%@page import="util.FonctionNote"%>
<%@page import="modele.Semestre"%>
<%@page import="modele.Classe"%>
<%@page import="modele.Etudiant"%>
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
    List<Etudiant> listeEtudiant = (ArrayList<Etudiant>) request.getAttribute("letudiant");
    List<Classe> classe = (ArrayList<Classe>) request.getAttribute("classe");
    List<Semestre> lsitSemestre = (ArrayList<Semestre>) request.getAttribute("lsitSemestre");
    List<Matiere> listeMatiere = (ArrayList<Matiere>) request.getAttribute("listeMatiere");

    List<Bulletin> listeBulletin = (ArrayList<Bulletin>) request.getAttribute("listeBulletin");
    List<Coefficient> listeCoefficient = new ArrayList<Coefficient>();
    FonctionNote note = new FonctionNote();


%>
<!DOCTYPE html>
<html>
    <title>index</title>
    <jsp:include page="tetePage.jsp"></jsp:include>
        <body class="hold-transition skin-blue sidebar-mini">
            <div class="wrapper">
            <%                if (request.getSession().getAttribute("admin") != null) {%>
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
                            <li><a href="#"><i class="fa fa-dashboard"></i> Acceuil</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                    <% if (classe != null) { %>
                    <div class="row">
                        <div class="col-lg-2">



                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    ajou semestre
                                </div>
                                <div class="panel-body">
                                    <form method="get" action="ServletSemestre">
                                        <div class="form-group">


                                            <div class=" input-group">
                                                <span class="input-group-addon">Classe:<% out.print(classe.get(0).getNomClasse());%></span>
                                                <input type="hidden" name="classe" class="form-control pull-right" value="<%=classe.get(0).getId()%>" placeholder="<% out.print(classe.get(0).getNomClasse()); %>">

                                            </div> 
                                        </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon">Examen</span>
                                                    <input type="text" class="form-control pull-right" name="nom" placeholder="nom Semestre" id="reservation">
                                                </div><!-- /.input group -->
                                            </div><!-- /.form group -->





                                        <!-- /.form group -->

                                        <button type="submit" class="btn btn-block btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                    </form>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    note Examen
                                </div>
                                <div class="panel-body">
                                    <form method="get" action="ServletNoteSemestre">
                                        <div class="form-group">
                                            <div class="form-group has-feedback">
                                                <select class="form-control select2"  name="idSemestre"  style="width: 100%">
                                                    <option selected="selected"></option>


                                                    <%
                                                        for (int i = 0; i < lsitSemestre.size(); i++) {
                                                    %> 
                                                    <option value="<%=lsitSemestre.get(i).getId()%>"><% out.print(lsitSemestre.get(i).getNomSemestre()); %></option>
                                                    <%}%>
                                                </select>
                                            </div>

                                            <div class="form-group input-group">

                                                <input type="hidden" name="idClasse" class="form-control" value="<%=classe.get(0).getId()%>" placeholder="<% out.print(classe.get(0).getNomClasse()); %>">

                                            </div>





                                        </div><!-- /.form group -->

                                        <button type="submit" class="btn btn-block btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                    </form>
                                </div>
                            </div>
                            <% if (listeMatiere != null) {%>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    coeff
                                </div>
                                <div class="panel-body">

                                    <% for (int i = 0; i < listeMatiere.size(); i++) {
                                            listeCoefficient = note.listeCoefficientMatiere(listeMatiere.get(i));
                                            if (listeCoefficient.size() == 0) {
                                    %>
                                    <form method="get" action="ServletAddCoef">
                                        <div class="form-group">
                                            <div class="form-group input-group">

                                                <input type="hidden" name="classe" class="form-control" value="<%=classe.get(0).getId()%>" placeholder="<% out.print(classe.get(0).getNomClasse()); %>">

                                            </div> 

                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><% out.print(listeMatiere.get(i).getNomMatiere());%></span>
                                                    <input type="hidden" name="matiere" value="<%=listeMatiere.get(i).getId()%>">

                                                    <input type="text" class="form-control pull-right" name="coef"  >
                                                </div><!-- /.input group -->
                                            </div><!-- /.form group -->




                                        </div><!-- /.form group -->

                                        <button type="submit" class="btn btn-block btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                    </form>
                                    <%} %>
                                    <%}%>

                                </div>
                            </div>
                            <%}%>


                        </div>
                        <div class="col-lg-10">
                            <% if (listeEtudiant != null && listeBulletin == null) { %>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>

                                                <th>matricul</th>
                                                <th>nom</th>
                                                <th>prenom</th>


                                                <th>total coef</th>

                                                <th>moyennne coef</th>
                                                <th>/x</th>
                                                <th>moyenne</th>
                                                <th>rang</th>
                                                <th>/x</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (int i = 0; i < listeEtudiant.size(); i++) { %>
                                            <tr>
                                                <td><% out.print(listeEtudiant.get(i).getImatricule()); %></td>
                                                <td><% out.print(listeEtudiant.get(i).getNom()); %></td> 
                                                <td><% out.print(listeEtudiant.get(i).getPrenom());%></td> 

                                                <td> </td>
                                                <td> </td>
                                                <td> </td>
                                                <td> </td>
                                                <td> </td>
                                                <td> </td>
                                            </tr>
                                            <%}%>

                                        </tbody>
                                    </table>


                                </div> 
                            </div><%}%>
                            <% if (listeBulletin != null) { %>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>

                                                <th>matricul</th>
                                                <th>nom</th>
                                                <th>prenom</th>


                                                <th>total coef</th>

                                                <th>moyennne coef</th>
                                                <th>/x</th>
                                                <th>moyenne</th>
                                                <th>rang</th>
                                                <th>/x</th>
                                                <th>DecisonConseil</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (int i = 0; i < listeBulletin.size(); i++) {%>
                                            <tr>
                                                <td><a href="DetailNoteBack?idEtudiant=<%=listeBulletin.get(i).getIdEtudiant().getId()%>&idSemestre=<%=listeBulletin.get(i).getIdSemestre().getId()%>&idBulletin=<%=listeBulletin.get(i).getId()%>"><% out.print(listeBulletin.get(i).getIdEtudiant().getImatricule());%></a></td>
                                                <td><a href="DetailNoteBack?idEtudiant=<%=listeBulletin.get(i).getIdEtudiant().getId()%>&idSemestre=<%=listeBulletin.get(i).getIdSemestre().getId()%>&idBulletin=<%=listeBulletin.get(i).getId()%>"><% out.print(listeBulletin.get(i).getIdEtudiant().getNom());%></a></td> 
                                                <td><a href="DetailNoteBack?idEtudiant=<%=listeBulletin.get(i).getIdEtudiant().getId()%>&idSemestre=<%=listeBulletin.get(i).getIdSemestre().getId()%>&idBulletin=<%=listeBulletin.get(i).getId()%>"><% out.print(listeBulletin.get(i).getIdEtudiant().getPrenom());%></a></td> 

                                                <td><% out.print(listeBulletin.get(i).getTotalCoefficient());%> </td>
                                                <td><% out.print(listeBulletin.get(i).getMoyenneCoefficient());%> </td>
                                                <td> <% out.print(listeBulletin.get(i).getCalculCoefficient());%></td>
                                                <td><% out.print(listeBulletin.get(i).getMoyenne());%> </td>
                                                <td><%=i + 1%></td>
                                                <td> <% out.print(listeBulletin.get(i).getEffectif());%> </td>
                                                <% if (listeBulletin.get(i).getDecisionConseil().equalsIgnoreCase("null")) {%>
                                                <td>

                                                    <form method="get" action="DecisonConseil">


                                                        <input type="hidden" name="idBulletin"value="<%=listeBulletin.get(i).getId()%>">

                                                        <input type="hidden" name="idClasse"value="<%=classe.get(0).getId()%>">
                                                        <input type="text" class="form-inline "  name="appreciation">

                                                        <button type="submit" class="btn btn-xs btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                                    </form>

                                                </td>
                                                <% } else { %>
                                                <td><% out.print(listeBulletin.get(i).getDecisionConseil()); %></td>
                                                <%}%>
                                            </tr>
                                            <%}%>

                                        </tbody>
                                    </table>


                                </div> 
                            </div><%}%>
                        </div>

                    </div>

                    <%}%>
                </section>
                kkkkkkkkkkkk
                <a href="pdf">pdf</a>
                
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

