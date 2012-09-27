<%-- 
    Document   : catalogue
    Created on : 25 sept. 2012, 14:53:53
    Author     : fasalles
--%>
<%@page import="Catalogue.DVD"%>
<jsp:useBean id="query" scope="application" class="Catalogue.QueryBD" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue de DVD</title>
    </head>
    <body>
        <h1 style="text-align:center">Contenu du catalogue de DVD</h1>
        <table style="margin:auto;">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Prix</th>
                </tr>
            </thead>
            <tbody>
                 <% for(DVD unDVD: query.getDVDs()){ %>
                 <tr>
                     <td><%= unDVD.getDescription() %></td>
                     <td><%= unDVD.getPrix() %></td>
                 </tr>
                 <% } %>
            </tbody>
        </table>
            <a href="login.jsp" title="Administrer"><button>Administration</button></a>
    </body>
</html>
