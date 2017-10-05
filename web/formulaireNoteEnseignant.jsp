<%@page import="modele.Bulletin"%>
<%@page import="util.FonctionNote"%>
<%@page import="modele.NoteEleve"%>
<%@page import="modele.Semestre"%>
<%@page import="modele.Etudiant"%>
<%@page import="modele.Matiere"%>
<%@page import="modele.HeureMatiere"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modele.Enseignant"%>
<%@page import="util.Fonction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Fonction f = new Fonction();
    FonctionNote fonct = new FonctionNote();
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
%>
<%
    //listeMatiereClasse
    List<Matiere> listeMatiereClasse = (ArrayList<Matiere>) request.getAttribute("listeMatiereClasse");
    List<Etudiant> listeEtudiant = (ArrayList<Etudiant>) request.getAttribute("listeEtudiant");
    List<Semestre> lsitSemestre = (ArrayList<Semestre>) request.getAttribute("lsitSemestre");
    //idClass
    String idClass = (String) request.getAttribute("idClass");

    List<Matiere> listeMatiereClasse1 = (ArrayList<Matiere>) request.getAttribute("listeMatiereClasse1");
    List<Etudiant> listeEtudiant1 = (ArrayList<Etudiant>) request.getAttribute("listeEtudiant1");
    List<Semestre> lsitSemestre1 = (ArrayList<Semestre>) request.getAttribute("lsitSemestre1");
    //idClass
    List<NoteEleve> listerNoteEleve = new ArrayList<NoteEleve>();
    String idClass1 = (String) request.getAttribute("idClass1");
    List<Bulletin> listeBulletin = (ArrayList<Bulletin>) request.getAttribute("listeBulletin");
%>
<!DOCTYPE html>
<html>
    <title>index</title>
    <jsp:include page="tetePage.jsp"></jsp:include>
        <body class="hold-transition skin-blue sidebar-mini">
            <div class="wrapper">
            <%                if (request.getSession().getAttribute("enseignant") != null) {%>
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

                            <small>ACCEUIL</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Acceuil</a></li>
                        </ol>
                    </section>

                    <section class="content">

                        <div class="row">
                        <% if (lsitSemestre != null && idClass != null) { %>
                        <div class="col-lg-2">

                            <div class="panel-heading"><i class="icon-th-list"></i>
                                ajouter note <% out.print(idClass);%> 
                                <form method="get" action="ServletAddNote">
                                    <div class="form-group">

                                        <input type="hidden" name="idClass" value="<%=idClass%>">

                                        <input type="hidden" name="idProf" value="<%=enseignantConnect.getId()%>">
                                        <div class="form-group has-feedback">
                                            <select class="form-control select2"  name="examen"  style="width: 100%">
                                                <option selected="selected"></option>


                                                <%
                                                    for (int i = 0; i < lsitSemestre.size(); i++) {
                                                %> 
                                                <option value="<%=lsitSemestre.get(i).getId()%>"><% out.print(lsitSemestre.get(i).getNomSemestre()); %></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-block btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                </form>
                            </div>
                            <div class="panel-heading"><i class="icon-th-list"></i>
                                Bulletin 
                                <form method="get" action="ServletBulletinEnseignant">
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

                                            <input type="hidden" name="idClasse" class="form-control" value="<%=idClass%>" >

                                        </div>





                                    </div><!-- /.form group -->

                                    <button type="submit" class="btn btn-block btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>


                                </form>
                            </div>

                        </div>
                        <%}%>
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
                                                <th>DecisionConseil</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (int i = 0; i < listeBulletin.size(); i++) {%>
                                            <tr>
                                                <td><a href="GetNoteEnsei?idEtudiant=<%=listeBulletin.get(i).getIdEtudiant().getId()%>&idSemestre=<%=listeBulletin.get(i).getIdSemestre().getId()%>&idBulletin=<%=listeBulletin.get(i).getId()%>"><% out.print(listeBulletin.get(i).getIdEtudiant().getImatricule()); %></a></td>
                                                <td><a href="GetNoteEnsei?idEtudiant=<%=listeBulletin.get(i).getIdEtudiant().getId()%>&idSemestre=<%=listeBulletin.get(i).getIdSemestre().getId()%>&idBulletin=<%=listeBulletin.get(i).getId()%>"><% out.print(listeBulletin.get(i).getIdEtudiant().getNom()); %></a></td> 
                                                <td><a href="GetNoteEnsei?idEtudiant=<%=listeBulletin.get(i).getIdEtudiant().getId()%>&idSemestre=<%=listeBulletin.get(i).getIdSemestre().getId()%>&idBulletin=<%=listeBulletin.get(i).getId()%>"><% out.print(listeBulletin.get(i).getIdEtudiant().getPrenom());%></a></td> 

                                                <td><% out.print(listeBulletin.get(i).getTotalCoefficient());%> </td>
                                                <td><% out.print(listeBulletin.get(i).getMoyenneCoefficient());%> </td>
                                                <td> <% out.print(listeBulletin.get(i).getCalculCoefficient());%></td>
                                                <td><% out.print(listeBulletin.get(i).getMoyenne());%> </td>
                                                <td><% out.print(listeBulletin.get(i).getRang());%>  </td>
                                                <td> <% out.print(listeBulletin.get(i).getEffectif());%> </td>
                                                <% if (listeBulletin.get(i).getDecisionConseil() != null) { %>
                                                <td> <% out.print(listeBulletin.get(i).getDecisionConseil());%> </td>
                                                <%} else {%>
                                                <td></td>
                                                <%}%>

                                            </tr>
                                            <%}%>

                                        </tbody>
                                    </table>


                                </div> 
                            </div><%}%>
                        </div>

                        <% if (lsitSemestre1 != null && idClass1 != null) { %>


                        <div class="panel-heading"><i class="icon-th-list">   
                                
                                
                                <h3><% out.print(lsitSemestre1.get(0).getNomSemestre()); %></h3> </i>





                        </div>






                        <%}%>
                        <% if (listeMatiereClasse1 != null && listeEtudiant1 != null && lsitSemestre1 != null) {%>
                        
                        <div class="table-responsive">

                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                    <tr>

                                        <th>matricul</th>
                                        <th>nom</th>
                                        <th>prenom</th>
                                            <% for (int i = 0; i < listeMatiereClasse1.size(); i++) { %>
                                        <th><% out.print(listeMatiereClasse1.get(i).getNomMatiere()); %>(J/20)</th>
                                        <th><% out.print(listeMatiereClasse1.get(i).getNomMatiere()); %>(C/40)</th>
                                        <th>Moyenne(/20)</th>
                                        <th>Moyenne(Coef)</th>
                                        <th> appreciations</th>
                                            <%}%>

                                    </tr>
                                </thead>
                                <tbody>

                                    <% for (int i = 0; i < listeEtudiant1.size(); i++) { %>

                                    <tr>
                                        <td><% out.print(listeEtudiant1.get(i).getImatricule()); %></td>
                                        <td><% out.print(listeEtudiant1.get(i).getNom()); %></td> 
                                        <td><% out.print(listeEtudiant1.get(i).getPrenom()); %></td> 

                                        <% for (int j = 0; j < listeMatiereClasse1.size(); j++) {
                                                listerNoteEleve = fonct.listerNoteEleve(0, listeEtudiant1.get(i).getId(), listeMatiereClasse1.get(j).getId(), lsitSemestre1.get(0).getId());
                                        %>


                                        <%  if (listerNoteEleve.get(j).getEtat() == 1) {%>
                                        <td>
                                            <form method="get" action="ServletInsererNoteEleve1">
                                                <input type="text" class="form-inline " name="noteEtudiant"  >

                                                <input type="hidden" name="idProf"value="<%=enseignantConnect.getId()%>">
                                                <input type="hidden" name="idClass"value="<%=idClass1%>">
                                                <input type="hidden" name="examen"value="<%=lsitSemestre1.get(0).getId()%>">

                                                <input type="hidden" name="idNote"value="<%=listerNoteEleve.get(j).getIdNoteEleve()%>">

                                                <button type="submit" class="btn btn-xs btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                            </form>
                                        </td>
                                        <td>
                                            <form method="get" action="#">
                                                <input type="text" class="form-inline " name="noteEtudiant"  >

                                                <input type="hidden" name="idProf"value="<%=enseignantConnect.getId()%>">
                                                <input type="hidden" name="idClass"value="<%=idClass1%>">
                                                <input type="hidden" name="examen"value="<%=lsitSemestre1.get(0).getId()%>">

                                                <input type="hidden" name="idNote"value="<%=listerNoteEleve.get(j).getIdNoteEleve()%>">


                                            </form>
                                        </td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <%} else if (listerNoteEleve.get(j).getEtat() == 2) {%>
                                        <td><%=listerNoteEleve.get(j).getNote()%></td>

                                        <td>
                                            <form method="get" action="ServletInsererNoteEleve2">

                                                <input type="text" class="form-inline " name="noteEtudiant"  >

                                                <input type="hidden" name="idProf"value="<%=enseignantConnect.getId()%>">
                                                <input type="hidden" name="idClass"value="<%=idClass1%>">
                                                <input type="hidden" name="examen"value="<%=lsitSemestre1.get(0).getId()%>">
                                                <input type="hidden" name="idEtudiant"value="<%=listeEtudiant1.get(i).getId()%>">
                                                <input type="hidden" name="idNote"value="<%=listerNoteEleve.get(j).getIdNoteEleve()%>">
                                                <input type="hidden" name="idCoefficient"value="<%=listerNoteEleve.get(j).getCoefficient().getCoef()%>">
                                                <button type="submit" class="btn btn-xs btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                            </form>
                                        </td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <%} else if (listerNoteEleve.get(j).getEtat() == 3) {%>
                                        <td><%=listerNoteEleve.get(j).getNote()%></td>
                                        <td><%=listerNoteEleve.get(j).getNote2()%></td>
                                        <td><% out.print(listerNoteEleve.get(j).getMoyenne()); %></td>
                                        <td><% out.print(listerNoteEleve.get(j).getMoyenneCoefficient());%></td>
                                        <td>
                                            <form method="get" action="ServletInsererAppreciations">
                                                <input type="text" class="form-inline " name="appreciaitions" placeholder="appreciaitions" >

                                                <input type="hidden" name="idProf"value="<%=enseignantConnect.getId()%>">
                                                <input type="hidden" name="idClass"value="<%=idClass1%>">
                                                <input type="hidden" name="examen"value="<%=lsitSemestre1.get(0).getId()%>">

                                                <input type="hidden" name="idNote"value="<%=listerNoteEleve.get(j).getIdNoteEleve()%>" >

                                                <button type="submit" class="btn btn-xs btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                            </form>
                                        </td>

                                        <%} else if (listerNoteEleve.get(j).getEtat() == 4) {%>
                                        <td><%=listerNoteEleve.get(j).getNote()%></td>
                                        <td><%=listerNoteEleve.get(j).getNote2()%></td>
                                        <td><% out.print(listerNoteEleve.get(j).getMoyenne()); %></td>
                                        <td><% out.print(listerNoteEleve.get(j).getMoyenneCoefficient()); %></td>
                                        <td><% out.print(listerNoteEleve.get(j).getAppreciation()); %></td>
                                        <%}
                                            }%>

                                    </tr>

                                    <%}%>

                                </tbody>
                            </table>


                        </div> 

                        <%}%>
                    </div>
                </section>
                <!-- /.content -->
                </div>
            <!-- /.content-wrapper -->
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

