<%-- 
    Document   : calculatrice
    Created on : 24 sept. 2012, 14:12:17
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
        <h1>CALCULATRICE</h1>
        <form method="POST" action="calculette.jsp">
            <input type="text" name="v1" placeholder="Valeur 1"/>
            <input type="text" name="operateur" placeholder="Operateur"/>
            <input type="text" name="v2" placeholder="Valeur 2"/>
            <input type="submit" value="Envoyer"/><br/>
        </form>
        <%@ page errorPage="error.jsp" %>
         <%
            double res = 0;
            if (request.getMethod().equals("POST")) {
                String valeur1 = request.getParameter("v1");
                String valeur2 = request.getParameter("v2");
                String operateur = request.getParameter("operateur");
                //double res = 0;
                if (!valeur1.isEmpty() || !valeur2.isEmpty() || !operateur.isEmpty()) {
                    double v1 = Double.parseDouble(valeur1);
                    double v2 = Double.parseDouble(valeur2);

                    if (operateur.equals("+")) {
                        res = v1 + v2;
                    } else if (operateur.equals("-")) {
                        res = v1 - v2;
                    } else if (operateur.equals("*")) {
                        res = v1 * v2;
                    } else if (operateur.equals("/")) {
                        if (v2 == 0) {
                            out.print("DIVISION PAR 0!");
                        } else {
                            res = v1 / v2;
                        }

                    }

                    out.print("Resultat : " + res);


                }
            }
        %>
    </body>
</html>
