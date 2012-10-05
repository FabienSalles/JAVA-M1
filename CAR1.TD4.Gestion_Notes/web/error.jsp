<%-- 
    Document   : error
    Created on : 5 oct. 2012, 12:43:16
    Author     : fasalles
--%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erreur</title>
    </head>
    <body>
         <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>Erreur</h1>
                </header>
                <article class="span6 offset2">
                    <h2>Exception :</h2>
                    <p><%= exception.toString() %></p>
                </article>
            </div>
        </section>
    </body>
</html>
