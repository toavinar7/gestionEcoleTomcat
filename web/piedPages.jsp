<%-- 
    Document   : piedPages
    Created on : 24 avr. 2017, 10:44:51
    Author     : nat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="bootstrap/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="bootstrap/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="bootstrap/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bootstrap/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="bootstrap/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="bootstrap/dist/js/demo.js"></script>
<!-- DataTables -->
<script src="bootstrap/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="bootstrap/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script>
    $(function () {
        $("#example1").DataTable();
    });
</script>
<script src="bootstrap/plugins/select2/select2.full.min.js"></script>
<script>
    $(function () {
        $(".select2").select2();

    });
</script>
<style>
    table#tableDevoir {
        border-collapse: collapse;   
    }
    #tableDevoir tr {
    
        border-top: 1px solid #fff;
    }
    #tableDevoir tr:hover {
        background-color: #ccc;
    }
    #tableDevoir th {
        background-color: #fff;
    }
    #tableDevoir th, #tableDevoir td {
        padding: 3px 5px;
    }
    #tableDevoir td:hover {
        cursor: pointer;
    }
</style>