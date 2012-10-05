<%-- 
    Document   : showModule
    Created on : 4 oct. 2012, 22:25:46
    Author     : fasalles
--%>

<%@page import="Model.Etudiant"%>
<%@page errorPage="error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="students" class="java.util.LinkedHashSet" scope="request" />
<jsp:useBean id="module" class="Model.Module" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>Liste des élèves du module <%= module.getIntitule() %></title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>Liste des élèves du module <%= module.getIntitule() %></h1>
                </header>
                <table class="table table-bordered table-striped" >
                    <thead>
                        <tr>
                            <th>Elèves</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Object row: students){ %>
                            <% Etudiant student = (Etudiant) row; %>
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
