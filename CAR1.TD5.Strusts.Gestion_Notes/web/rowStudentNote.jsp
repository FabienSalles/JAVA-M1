<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<% 
String netudiant = request.getParameter("netudiant"),
       id_module = request.getParameter("id_module"),
       note      = request.getParameter("note");
%>
<html:form action="noteModuleForm" styleClass="form-note">
    <div class="infos">
        <%= note %>
        <div class="pull-right">
            <a class="btn btn-mini edit" href="#"><i class="icon-pencil"></i></a>
        </div>
    </div>
    <div class="form">
        <html:hidden property="netudiant" value="<%= netudiant %>"/>
        <html:hidden property="idModule" value="<%= id_module %>" />
        <html:text property="note" value="<%= note %>"/>
        <html:errors property="note" />
        <div class="pull-right">
            <input type="submit" class="btn btn-mini" value="Valider"/>
        </div>
    </div>          
</html:form>