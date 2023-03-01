<%@ page import="com.configuracion.Conexion" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.modelo.EstudianteDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Filterable Table</h2>
    <p>Type something in the input field to search the table for first names, last names or emails:</p>
    <label for="myInput"></label><input class="form-control" id="myInput" type="text" placeholder="Search..">
    <br>
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <tr>
            <td>John</td>
            <td>Doe</td>
            <td>john@example.com</td>
        </tr>
        <tr>
            <td>Mary</td>
            <td>Moe</td>
            <td>mary@mail.com</td>
        </tr>
        <tr>
            <td>July</td>
            <td>Dooley</td>
            <td>july@greatstuff.com</td>
        </tr>
        <tr>
            <td>Anja</td>
            <td>Ravendale</td>
            <td>a_r@test.com</td>
        </tr>
        </tbody>
    </table>

    <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
</div>

<script>
    $(document).ready(function(){
        $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>



<script>
    <%
    EstudianteDAO estudiante = new EstudianteDAO();
    estudiante.listarEstudiantes();
    %>
    console.log(estudiante);
</script>

</body>
</html>




<%--
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    Conexion cn = new Conexion();
    Connection con;
    con = cn.getConexion();
%>
<h1><%= "Hello World!"%>
</h1>
<h2><%=con%> </h2>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>--%>
