<%-- 
    Document   : module
    Created on : 28 nov. 2012, 12:30:21
    Author     : fasalles
--%>

<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="students" class="java.util.LinkedHashSet" scope="request" />
<jsp:useBean id="module" class="Model.Module" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>Module <%= module.getIntitule() %></title>
    </head>
    <body>
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>Module <%= module.getIntitule() %></h1>
                </header>
                <table class="table table-bordered table-striped" >
                    <thead>
                        <tr>
                            <th>Elèves</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Object row: students){ %>
                            <% Student student = (Student) row; %>
                            <tr>
                                <td>
                                   <%= student.getNom() %> <%= student.getPrenom() %>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </section>
    </body>
</html>