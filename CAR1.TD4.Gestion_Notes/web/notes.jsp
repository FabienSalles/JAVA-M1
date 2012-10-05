<%-- 
    Document   : notes
    Created on : 27 sept. 2012, 15:38:46
    Author     : fasalles
--%>

<%@page import="Model.Note"%>
<%@page errorPage="error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="notes" class="java.util.LinkedHashSet" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>Notes</h1>
                </header>
                <table class="table table-bordered table-striped" >
                    <thead>
                        <tr>
                            <th>Matières</th>
                            <th>Note</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Object note: notes){ %>
                            <% Note row = (Note) note; %>
                            <tr>
                                <td>
                                    <%= row.getModule().getIntitule() %>
                                </td>
                                <td>
                                    <%= row.getNote() %>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </section>
    </body>
</html>
