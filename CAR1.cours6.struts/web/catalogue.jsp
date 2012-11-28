<%-- 
    Document   : catalogue.jsp
    Created on : 5 nov. 2012, 17:21:48
    Author     : fasalles
--%>
<%@page import="Catalogue.DVD"%>
<jsp:useBean id="query" scope="application" class="Catalogue.QueryDB" />
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
    </body>
</html>
