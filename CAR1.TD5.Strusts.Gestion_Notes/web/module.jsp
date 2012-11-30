<%-- 
    Document   : module
    Created on : 28 nov. 2012, 12:30:21
    Author     : fasalles
--%>

<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<jsp:useBean id="students" class="java.util.LinkedHashSet" scope="request" />
<jsp:useBean id="module" class="Model.Module" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>Module <%= module.getIntitule() %></title>
    </head>
    <body>
        <jsp:include page="navbar.jsp" />
        <section class="container">
            <div class="row">
                <header class="hero-unit">
                    <h1>Module <%= module.getIntitule() %></h1>
                </header>
                <html:errors />
                <table class="table table-bordered table-striped" >
                    <thead>
                        <tr>
                            <th>Elèves</th>
                            <th>Notes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Object row: students){ %>
                            <% Student student = (Student) row; %>
                            <tr>
                                <td><%= student.getNom() %> <%= student.getPrenom() %></td>
                                <td>
                                    <jsp:include page="rowStudentNote.jsp">
                                        <jsp:param name="netudiant" value="<%= student.getNetudiant() %>"/>
                                        <jsp:param name="id_module" value="<%= module.getId() %>"/>
                                        <jsp:param name="note" value="<%= student.getNote(module.getId()) %>"/>
                                    </jsp:include>        
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </section>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $.each($("form"),function(){
                    var $formBlock = $(this),
                        $infos     = $formBlock.find('.infos'),
                        $form      = $formBlock.find('.form'),
                        $edit      = $infos.find('.edit'),
                        $submit    = $form.find('input[type="submit"]');

                    $form.hide();

                    $edit.on('click',function(){
                        $infos.hide();
                        $form.show();
                    });
                    
                    $submit.on('click',function(e){
                        e.preventDefault();
                        
                        $.ajax({
                            type     : this.methode,
                            action   : this.action,
                            data     : $formBlock.serialize(),
                            complete : function(data){
                                console.log("complete",data);
                            },
                            success  : function(data){
                                console.log("success",data);
                            }
                        });
                        return 0;
                    });
                });
            });
        </script>
    </body>
</html>