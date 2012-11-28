<%-- 
    Document   : login.jsp
    Created on : 23 nov. 2012, 15:14:04
    Author     : fasalles
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title><bean:message key="index.title"/></title>
    </head>
    <body>
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1><bean:message key="index.title"/></h1>
                </header>
                <html:form action="login">
                    <html:errors property="global"/>
                    <div class="control-group">
                        <html:errors property="login"/>
                        <label class="control-label" for="login"><bean:message key="label.login"/></label>
                        <div class="controls">
                            <html:text property="login" />
                        </div>
                    </div>
                    <div class="control-group">
                        <html:errors property="password" />
                        <label class="control-label" for="pwd"><bean:message key="label.password"/></label>
                        <div class="controls">
                            <html:password property="password" />
                        </div>
                    </div>
                    <div class="control-group">
                        <html:errors property="type" />
                        <label class="control-label" for="type"><bean:message key="label.type"/></label>
                        <div class="controls">
                            <label class="radio"><html:radio property="type" value="1" /><bean:message key="label.type.student"/></label>
                            <label class="radio"><html:radio property="type" value="2" /><bean:message key="label.type.teacher"/></label>
                            <html:submit styleClass="btn" titleKey="label.connect" />
                        </div>
                    </div>
                </html:form>
            </div>
        </section>
    </body>
</html:html>