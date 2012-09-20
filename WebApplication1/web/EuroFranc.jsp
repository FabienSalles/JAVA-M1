<%-- 
    Document   : EuroFranc
    Created on : 17 sept. 2012, 16:21:04
    Author     : fasalles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Euro Franc</h1>
        
        <form method="post" action="eurofranc" style="margin:auto; text-align:center;">
            <div>
                <label for="chose">Choix</label>
                <input id="chose" name="chose" type="radio" value="0" checked="true" />Franc/Euro
                <input id="chose" name="chose" type="radio" value="1" />Euro/Franc
            </div>
            <div>
                <label for="number">Monnaie</label>
                <input id="number" name="number" type="number" />
            </div>
            <div><input type="submit" value="Valider" /></div>
        </form>
    </body>
</html>
