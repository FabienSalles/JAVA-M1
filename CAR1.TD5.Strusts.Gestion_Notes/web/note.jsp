<%-- 
    Document   : note
    Created on : 26 nov. 2012, 17:08:27
    Author     : fasalles
--%>

<%@page import="Model.Note"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<jsp:useBean id="notes" class="java.util.LinkedHashSet" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/main.css" rel="stylesheet" type="text/css">
        <title><bean:message key="note.title"/></title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1><bean:message key="note.title"/></h1>
                </header>
                <table class="table table-bordered table-striped" >
                    <thead>
                        <tr>
                            <th><bean:message key="note.label.module"/></th>
                            <th><bean:message key="note.label.note"/></th>
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
