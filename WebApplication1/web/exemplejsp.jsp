<%-- 
    Document   : exemplejsp
    Created on : 19 sept. 2012, 08:45:22
    Author     : fasalles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    int cpt = 0;
    int getCpt(){
        return cpt++;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Table des factorielles</h1>
        <%
            int i, fact;
            out.print("0!=1<br />");
            for(i=1, fact=1; i<5; i++, fact*=i)
                out.print((i)+"!="+fact+"<br />");
        %>
    </body>
</html>
