<%-- 
    Document   : index
    Created on : 26 sept. 2012, 11:09:06
    Author     : fasalles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<jsp:useBean id="user" class="Model.Utilisateur" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>S'authentifier</title>
    </head>
    <body>
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>S'authentifier</h1>
                </header>
                <form class="span6 offset2 form-horizontal" action="index" method="post">
                    <%= user.getErrors().renderGlobalErrors() %>
                    <div class="control-group">
                        <%= user.getErrors().renderError("login") %>
                        <label class="control-label" for="login">Login : </label>
                        <div class="controls">
                            <input type="text" id="login" name="login" value="<% if(user.getLogin() != null)%><%= user.getLogin() %>"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <%= user.getErrors().renderError("password") %>
                        <label class="control-label" for="pwd">Password : </label>
                        <div class="controls">
                            <input type="password" id="pwd" name="pwd" value="<% if(user.getPassword() != null)%><%= user.getPassword() %>"/>
                    
                        </div>
                    </div>
                    <div class="control-group">
                        <%= user.getErrors().renderError("type") %>
                        <label class="control-label" for="type">Personne : </label>
                        <div class="controls">
                            <label class="radio"><input type="radio" value="1" name="type" <% if(user.getType()!= null &&  user.getType() == 1) %><%= "checked='true'" %>/> Etudiant</label>
                            <label class="radio"><input type="radio" value="2" name="type" <% if(user.getType()!= null &&  user.getType() == 2) %><%= "checked='true'" %>/> Enseignant</label>
                            <input class="btn" type="submit" value="Se connecter" />
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </body>
</html>

.