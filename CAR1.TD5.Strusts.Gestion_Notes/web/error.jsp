<%-- 
    Document   : error
    Created on : 27 nov. 2012, 16:32:59
    Author     : fasalles
--%>
<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>Error</title>
    </head>
    <body>
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>Error</h1>
                </header>
                <article>
                    <p>
                       Message: <%=exception.getMessage()%> 
                    </p>
                    <p>
                        StackTrace:
                    <%
                            StringWriter stringWriter = new StringWriter();
                            PrintWriter printWriter = new PrintWriter(stringWriter);
                            exception.printStackTrace(printWriter);
                            out.println(stringWriter);
                            printWriter.close();
                            stringWriter.close();
                    %>
                    </p>
                    
                </article>
            </div>
        </section>
    </body>
</html:html>