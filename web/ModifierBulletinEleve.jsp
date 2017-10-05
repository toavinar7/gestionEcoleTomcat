<%@page import="modele.Admin"%>
<%@page import="modele.Semestre"%>
<%@page import="modele.Matiere"%>
<%@page import="util.FonctionNote"%>
<%@page import="modele.NoteEleve"%>
<%@page import="modele.Bulletin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="util.Fonction"%>
<%@page import="modele.Etudiant"%>
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
    List<Bulletin> listeBulletin = (ArrayList<Bulletin>) request.getAttribute("listeBulletin");

    List<NoteEleve> noteEleve = (ArrayList<NoteEleve>) request.getAttribute("eleve");
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


                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                          <% if (noteEleve != null) {%>

                        <h3>
                        <% out.print(listeBulletin.get(0).getIdEtudiant().getNom()); %><% out.print(listeBulletin.get(0).getIdEtudiant().getPrenom()); %>
                           
                        </h3>
                        <%}%>
                        <ol class="breadcrumb">
                            <li><a href="#"><i class="fa fa-dashboard"></i> Bulletin </a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">
                        <div class="row">
                        <% if (noteEleve != null) {%>




                        <div class="col-lg-12">
                            <table id="example1" class="table table-hover table-striped">
                                <thead>
                                    <tr>


                                        <td>matiere</td>
                                        <td>NoteJ</td>
                                        <td>modifier</td>
                                        <td>/x</td>
                                        <td>Comp</td>
                                        <td>modifier</td>
                                        <td>/x</td>
                                        <td>moyenne</td>
                                        <td>/x</td>
                                        <td>Coef</td>
                                        <td>moyenneCoef</td>
                                        <td>/x</td>
                                        <td>Appreciation</td>
                                    </tr>
                                </thead>
                                <% for (int i = 0; i < noteEleve.size(); i++) { %>
                                <tr>


                                    <td><% out.print(noteEleve.get(i).getMatiere().getNomMatiere()); %></td>
                                    <td><% out.print(noteEleve.get(i).getNote()); %></td>
                                    <td>
                                        
                                         <form method="get" action="updateNote">
                                            <input type="hidden" name="idNoteEleve" value="<%=noteEleve.get(i).getIdNoteEleve()%>">
                                            <input type="text" name="noteEleve" value="00" >
                                            <input type="hidden" name="noteEleve1" value="00" >
                                            <button type="submit" class="btn btn-xs btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                        </form>
                                    </td>
                                    <td>20</td>
                                    <td><% out.print(noteEleve.get(i).getNote2());%></td>
                                    <td>
                                        <form method="get" action="updateNote">
                                            <input type="hidden" name="idNoteEleve" value="<%=noteEleve.get(i).getIdNoteEleve()%>">
                                            <input type="hidden" name="noteEleve" value="00" >
                                            <input type="text" name="noteEleve1" value="00" >
                                            <button type="submit" class="btn btn-xs btn-primary btn-xs"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                                        </form>

                                    </td>
                                    <td>40</td>
                                    <td><% out.print(noteEleve.get(i).getMoyenne()); %></td>
                                    <td>20</td>

                                    <td><% out.print(noteEleve.get(i).getCoefficient().getCoef()); %></td>
                                    <td><% out.print(noteEleve.get(i).getMoyenneCoefficient()); %></td>
                                    <td><% out.print(noteEleve.get(i).getCoefficient2()); %></td>
                                    <td><% out.print(noteEleve.get(i).getAppreciation()); %></td>
                                </tr>
                                <%}%>
                                <tr>



                                    <td>.</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>total</td>
                                    <td><% out.print(listeBulletin.get(0).getTotalCoefficient()); %></td>
                                    <td><% out.print(listeBulletin.get(0).getMoyenneCoefficient()); %></td>
                                    <td><% out.print(listeBulletin.get(0).getCalculCoefficient()); %></td>
                                    <td></td>
                                </tr>
                                <tr>


                                    <td>.</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>moyenne trimestriel</td>
                                    <td></td>


                                    <td><% out.print(listeBulletin.get(0).getMoyenne()); %></td>
                                    <td>20</td>
                                    <td></td>
                                </tr>
                                <tr>


                                    <td>.</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>

                                    <td>moyenne de Classe</td>
                                    <td></td>

                                    <td>x</td>
                                    <td>20</td>
                                    <td></td>
                                </tr>
                                <tr>



                                    <td> .</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Rang</td>
                                    <td></td>

                                    <td>x</td>
                                    <td><% out.print(listeBulletin.get(0).getEffectif()); %></td>
                                    <td></td>
                                </tr>
                            </table>
                        </div>


                        <%}%>
                        <div id="content-outer1">
                            <!-- start content -->
                            <div id="content1">

                                <!--  start page-heading -->

                                <!-- end page-heading -->

                                <table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table1">
                                    <tr>
                                        <th rowspan="3" class="sized"><img src="images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
                                        <th class="topleft"></th>
                                        <td id="tbl-border-top1">&nbsp;</td>
                                        <th class="topright"></th>
                                        <th rowspan="3" class="sized"><img src="images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
                                    </tr>
                                    <tr>
                                        <td id="tbl-border-left1"></td>
                                        <td>
                                            <!--  start content-table-inner ...................................................................... START -->
                                            <div id="content-table-inner1">

                                                <!--  start table-content  -->
                                                <div id="table-content1">
                                                    <!-- ato zany ny asina ny asa rehetra-->

                                                    <div class="box box-body">
                                                        <div class="box-header with-border">
                                                            <h3 class="box-title">Graphe</h3>

                                                        </div>
                                                        <div class="box-body">
                                                            <div class="chart">
                                                                <canvas id="areaChart" style="height:250px"></canvas>
                                                            </div>
                                                        </div><!-- /.box-body -->
                                                    </div>


                                                    <!-- tapitra eto zany ny asa rehetra ann-->
                                                </div>
                                                <!--  end table-content  -->

                                                <div class="clear"></div>

                                            </div>
                                            <!--  end content-table-inner ............................................END  -->
                                        </td>
                                        <td id="tbl-border-right1"></td>
                                    </tr>
                                    <tr>
                                        <th class="sized bottomleft"></th>
                                        <td id="tbl-border-bottom1">&nbsp;</td>
                                        <th class="sized bottomright"></th>
                                    </tr>
                                </table>
                                <div class="clear">&nbsp;</div>

                            </div>
                            <!--  end content -->
                            <div class="clear">&nbsp;</div>
                        </div>
                    </div>
                </section>
                <!-- /.content -->

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


            <script src="bootstrap/plugins/jQuery/jQuery-2.1.4.min.js"></script>
            <!-- Bootstrap 3.3.5 -->
            <script src="bootstrap/bootstrap/js/bootstrap.min.js"></script>
            <!-- ChartJS 1.0.1 -->
            <script src="bootstrap/plugins/chartjs/Chart.min.js"></script>
            <!-- FastClick -->
            <script src="bootstrap/plugins/fastclick/fastclick.min.js"></script>
            <!-- AdminLTE App -->
            <script src="bootstrap/dist/js/app.min.js"></script>
            <!-- AdminLTE for demo purposes -->
            <script src="bootstrap/dist/js/demo.js"></script>
            <!-- page script -->
            <script>
                $(function () {
                /* ChartJS
                 * -------
                 * Here we will create a few charts using ChartJS
                 */

                //--------------
                //- AREA CHART -
                //--------------

                // Get context with jQuery - using jQuery's .get() method.
                var areaChartCanvas = $("#areaChart").get(0).getContext("2d");
                // This will get the first returned node in the jQuery collection.
                var areaChart = new Chart(areaChartCanvas);
                var areaChartData = {
                labels: [<% for (int i = 0; i < noteEleve.size(); i++) {%>"<%=noteEleve.get(i).getMatiere().getNomMatiere()%>",<%}%>],
                        datasets: [
                        {
                        label: "Electronics",
                                fillColor: "rgba(210, 214, 222, 1)",
                                strokeColor: "rgba(210, 214, 222, 1)",
                                pointColor: "rgba(210, 214, 222, 1)",
                                pointStrokeColor: "#c1c7d1",
                                pointHighlightFill: "#fff",
                                pointHighlightStroke: "rgba(220,220,220,1)",
                                data: [<% for (int i = 0; i <= 20; i++) {%>"<%=i%>",<%}%>]
                        },
                        {
                        label: "Digital Goods",
                                fillColor: "rgba(60,141,188,0.9)",
                                strokeColor: "rgba(60,141,188,0.8)",
                                pointColor: "#3b8bba",
                                pointStrokeColor: "rgba(60,141,188,1)",
                                pointHighlightFill: "#fff",
                                pointHighlightStroke: "rgba(60,141,188,1)",
                                data: [<% for (int i = 0; i < noteEleve.size(); i++) {%>"<%=noteEleve.get(i).getMoyenne()%>",<%}%>]
                        }
                        ]
                };
                var areaChartOptions = {
                //Boolean - If we should show the scale at all
                showScale: true,
                        //Boolean - Whether grid lines are shown across the chart
                        scaleShowGridLines: false,
                        //String - Colour of the grid lines
                        scaleGridLineColor: "rgba(0,0,0,.05)",
                        //Number - Width of the grid lines
                        scaleGridLineWidth: 1,
                        //Boolean - Whether to show horizontal lines (except X axis)
                        scaleShowHorizontalLines: true,
                        //Boolean - Whether to show vertical lines (except Y axis)
                        scaleShowVerticalLines: true,
                        //Boolean - Whether the line is curved between points
                        bezierCurve: true,
                        //Number - Tension of the bezier curve between points
                        bezierCurveTension: 0.3,
                        //Boolean - Whether to show a dot for each point
                        pointDot: false,
                        //Number - Radius of each point dot in pixels
                        pointDotRadius: 4,
                        //Number - Pixel width of point dot stroke
                        pointDotStrokeWidth: 1,
                        //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                        pointHitDetectionRadius: 20,
                        //Boolean - Whether to show a stroke for datasets
                        datasetStroke: true,
                        //Number - Pixel width of dataset stroke
                        datasetStrokeWidth: 2,
                        //Boolean - Whether to fill the dataset with a color
                        datasetFill: true,
                        //String - A legend template

                        //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                        maintainAspectRatio: true,
                        //Boolean - whether to make the chart responsive to window resizing
                        responsive: true
                };
                //Create the line chart
                areaChart.Line(areaChartData, areaChartOptions);
                //-------------
                //- LINE CHART -
                //--------------
                var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
                var lineChart = new Chart(lineChartCanvas);
                var lineChartOptions = areaChartOptions;
                lineChartOptions.datasetFill = false;
                lineChart.Line(areaChartData, lineChartOptions);
                //-------------
                //- PIE CHART -
                //-------------
                // Get context with jQuery - using jQuery's .get() method.
                var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
                var pieChart = new Chart(pieChartCanvas);
                var PieData = [
                {
                value: 700,
                        color: "#f56954",
                        highlight: "#f56954",
                        label: "Chrome"
                },
                {
                value: 500,
                        color: "#00a65a",
                        highlight: "#00a65a",
                        label: "IE"
                },
                {
                value: 400,
                        color: "#f39c12",
                        highlight: "#f39c12",
                        label: "FireFox"
                },
                {
                value: 600,
                        color: "#00c0ef",
                        highlight: "#00c0ef",
                        label: "Safari"
                },
                {
                value: 300,
                        color: "#3c8dbc",
                        highlight: "#3c8dbc",
                        label: "Opera"
                },
                {
                value: 100,
                        color: "#d2d6de",
                        highlight: "#d2d6de",
                        label: "Navigator"
                }
                ];
                var pieOptions = {
                //Boolean - Whether we should show a stroke on each segment
                segmentShowStroke: true,
                        //String - The colour of each segment stroke
                        segmentStrokeColor: "#fff",
                        //Number - The width of each segment stroke
                        segmentStrokeWidth: 2,
                        //Number - The percentage of the chart that we cut out of the middle
                        percentageInnerCutout: 50, // This is 0 for Pie charts
                        //Number - Amount of animation steps
                        animationSteps: 100,
                        //String - Animation easing effect
                        animationEasing: "easeOutBounce",
                        //Boolean - Whether we animate the rotation of the Doughnut
                        animateRotate: true,
                        //Boolean - Whether we animate scaling the Doughnut from the centre
                        animateScale: false,
                        //Boolean - whether to make the chart responsive to window resizing
                        responsive: true,
                        // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                        maintainAspectRatio: true,
                        //String - A legend template

                };
                //Create pie or douhnut chart
                // You can switch between pie and douhnut using the method below.
                pieChart.Doughnut(PieData, pieOptions);
                //-------------
                //- BAR CHART -
                //-------------
                var barChartCanvas = $("#barChart").get(0).getContext("2d");
                var barChart = new Chart(barChartCanvas);
                var barChartData = areaChartData;
                barChartData.datasets[1].fillColor = "#00a65a";
                barChartData.datasets[1].strokeColor = "#00a65a";
                barChartData.datasets[1].pointColor = "#00a65a";
                var barChartOptions = {
                //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
                scaleBeginAtZero: true,
                        //Boolean - Whether grid lines are shown across the chart
                        scaleShowGridLines: true,
                        //String - Colour of the grid lines
                        scaleGridLineColor: "rgba(0,0,0,.05)",
                        //Number - Width of the grid lines
                        scaleGridLineWidth: 1,
                        //Boolean - Whether to show horizontal lines (except X axis)
                        scaleShowHorizontalLines: true,
                        //Boolean - Whether to show vertical lines (except Y axis)
                        scaleShowVerticalLines: true,
                        //Boolean - If there is a stroke on each bar
                        barShowStroke: true,
                        //Number - Pixel width of the bar stroke
                        barStrokeWidth: 2,
                        //Number - Spacing between each of the X value sets
                        barValueSpacing: 5,
                        //Number - Spacing between data sets within X values
                        barDatasetSpacing: 1,
                        //String - A legend template

                        //Boolean - whether to make the chart responsive
                        responsive: true,
                        maintainAspectRatio: true
                };
                barChartOptions.datasetFill = false;
                barChart.Bar(barChartData, barChartOptions);
                });
        </script>
    </body>
</html>

