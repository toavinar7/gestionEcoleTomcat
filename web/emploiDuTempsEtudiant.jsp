<%@page import="modele.HeureMatiere"%>
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
%>
<%
    List<HeureMatiere> lclasse = (ArrayList<HeureMatiere>) request.getAttribute("listemat");
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
                                    <h3 class="box-title">Emploi du temp</h3>
                                  
                            </div>
                            <div class="box-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>HORAIRE</th>
                                            <th>LUNDI</th>
                                            <th>MARDI</th>
                                            <th>MERCREDI</th>
                                            <th>JEUDI</th>
                                            <th>VENDREDI</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <tr>
                                            <td>07h-08h</td>
                                            <%int j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("7h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("8h"))) {%>
                                                <td><% out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("7h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("8h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("7h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("8h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>

                                            <%}
                                                }
                                                if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("7h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("8h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>

                                            <%}
                                                }
                                                if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("7h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("8h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>

                                            <%}
                                                }
                                                if (j == 0) {%>
                                            <td></td>
                                            <%}%>

                                        </tr>
                                        <tr>
                                            <td>08h-09h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("8h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("9h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("8h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("9h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>

                                            <%}
                                                }
                                                if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("8h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("9h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("8h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("9h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("8h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("9h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>09h-10h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("9h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("10h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("9h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("10h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("9h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("10h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("9h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("10h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("9h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("10h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>10h-11h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("10h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("11h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("10h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("11h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("10h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("11h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("10h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("11h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("10h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("11h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>11h-12h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("11h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("12h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("11h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("12h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("11h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("12h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("11h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("12h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("11h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("12h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>14h-15h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("14h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("15h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("14h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("15h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("14h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("15h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("14h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("15h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("14h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("15h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>15h-16h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("15h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("16h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("15h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("16h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("15h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("16h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("15h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("16h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("15h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("16h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>16h-17h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("16h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("17h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("16h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("17h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("16h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("17h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("16h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("17h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("16h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("17h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1; %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>
                                        <tr>
                                            <td>17h-18h</td>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("LUNDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("17h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("18h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MARDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("17h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("18h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("MERCREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("17h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("18h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("JEUDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("17h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("18h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                            <%j = 0;
                                                for (int i = 0; i < lclasse.size(); i++) { %> 
                                            <%if ((lclasse.get(i).getJour().equalsIgnoreCase("VENDREDI")) && (lclasse.get(i).getHeuredebut().equalsIgnoreCase("17h")) && (lclasse.get(i).getHeureFin().equalsIgnoreCase("18h"))) {%>
                                                <td><%out.print(lclasse.get(i).getEnseignant().getMatiere().getNomMatiere());
                                                    j = 1;  %></td>
                                                <%}
                                                    }
                                                    if (j == 0) {%>
                                            <td></td>
                                            <%}%>
                                        </tr>

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

