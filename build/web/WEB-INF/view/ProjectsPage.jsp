<%-- 
    Document   : ProjectsPage
    Created on : May 17, 2017, 5:20:30 AM
    Author     : Mega
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        
        <title>Current Projects</title>
        
    </head>
    <body>
        <div class="form-container" style="width: 70%; margin: auto;">
            <h1 style="text-align: center;">${message}</h1>
            <br />
            <div class="row">
                <div class="col-xs-12">
                    <div id="example-1_wrapper" class="dataTables_wrapper form-inline">
                        <table id="projectData" class="table table-striped dt-responsive display dataTable dtr-inline">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Active</th>
                                    <th>Billable</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
    
    <script type="text/javascript">
        
        /* Formatting function for row details - modify as you need */
        function format(d) {
            // `d` is the original data object for the row
            return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
                '<tr>' +
                '<td>Number of tasks:</td>' +
                '<td>' + d.task_set.length + '</td>' +
                '</tr>' +
                '<tr>' +
                '<td>Number of Resources:</td>' +
                '<td>' + d.resource_set.length + '</td>' +
                '</tr>' +
                '</table>';
        }

        $(document).ready(function () {
            var bens = JSON.parse(${projects});
            var table = $('#projectData').DataTable({
                data : bens,
                "columns": [
                    {
                        "className": 'details-control',
                        "orderable": true,
                        "defaultContent": ''
                    },
                    { "data": "title" },
                    { "data": "description" },
                    { "data": "start_date" },
                    { "data": "end_date" },
                    { "data": "is_active" },
                    { "data": "is_billable" }
                ],
                "order": [[1, 'asc']]
            });

            // Add event listener for opening and closing details
            $('#projectData tbody').on('click', 'td.details-control', function () {
                    var tr = $(this).closest('tr');
                    var row = table.row(tr);

                    if (row.child.isShown()) {
                        // This row is already open - close it
                        row.child.hide();
                        tr.removeClass('shown');
                    }
                    else {
                        // Open this row
                        row.child(format(row.data())).show();
                        tr.addClass('shown');
                    }
                });
        });
        
    </script>
    
</html>
