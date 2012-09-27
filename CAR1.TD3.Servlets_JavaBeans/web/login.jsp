<%-- 
    Document   : login
    Created on : 26 sept. 2012, 09:24:24
    Author     : fasalles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connection</title>
    </head>
    <body>
        <h1 style="text-align:center;">Connection</h1>
        <form style="margin:auto;" action="seconnecter" method="post">
            <div>
                <label for="login">Login : </label>
                <input type="text" id="login" name="login"/>
            </div>
            <div>
                <label for="pwd">Password : </label>
                <input type="password" id="pwd" name="pwd"/>
            </div>
            <div>
                <input type="submit" value="Se connecter" />
            </div>
        </form>
    </body>
</html>