<%-- 
    Document   : authentification
    Created on : 19 sept. 2012, 11:41:39
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
        <h1>Authentification</h1>
        <form style="margin: auto; text-align: center;" method="post" action="authentification">
            <div>
                <label for="login">Login : </label>
                <input type="text" name="login" id="login" />
            </div>
            <div>
                <label for="pwd">Mot de passe : </label>
                <input type="password" name="pwd" />
            </div>
            <input type="submit" Value="S'authentifier" />
        </form>
    </body>
</html>
