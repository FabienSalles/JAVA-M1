<%-- 
    Document   : module
    Created on : 26 nov. 2012, 17:08:59
    Author     : fasalles
--%>

<%@page import="Model.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<jsp:useBean id="modules" class="java.util.LinkedHashSet" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title><bean:message key="module.title"/></title>
    </head>
    <body>
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1><bean:message key="module.title"/></h1>
                </header>
                <table class="table table-bordered table-striped" >
                    <thead>
                        <tr>
                            <th><bean:message key="module.table.label"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Object row: modules){ %>
                            <% Module module = (Module) row; %>
                            <tr>
                                <td>
                                    <a href="showModule.do?id=<%= module.getId() %>" title="<%= module.getIntitule() %>"><%= module.getIntitule() %></a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </section>
    </body>
</html>