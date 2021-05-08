<%@page import="com.mycompany.spj.examen.controller.login.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Map<String, String> errors =(Map<String,String>) request.getAttribute("errors"); %>
<% Model model = (Model) request.getAttribute("model"); %>
<% Map<String, String[]> credencials = (errors!=null)?request.getParameterMap():getCredencials(model); %>

<!DOCTYPE html>
<html>
    <head>
        <title>SPJ</title> 
        <%@ include file="/pages/Head.jsp" %>
    </head>
<body >
    <%@ include file="/pages/Header.jsp" %>
    <div class="container  ml-3">
        <h2>Iniciar Sesión</h2>
        <form name="form" action="/spj-examen/login/login" method="post">
            <table>
                <thead>
                    <tr>
                        <td>
                            Cedula 
                        </td>
                        <td>
                            <input class ="<%=verifyErrors("cedula",errors)%>" type="text" name="cedula" 
                            value="<%=credencials.get("cedula")[0]%>" title="<%=getTittle("cedula",errors)%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Clave
                        </td>
                         <td>
                            <input class ="<%=verifyErrors("clave",errors)%>" type="text" name="clave" 
                            value="<%=credencials.get("clave")[0]%>" title="<%=getTittle("clave",errors)%>"><br>
                        </td>
                    </tr>
                    <tr>
                        <td colspan = 2>
                            <input class="button" type="submit" value="Iniciar"> 
                        </td>
                    </tr>
                </thead>
            </table>
        </form>
    </div>
    <%@ include file="/pages/Footer.jsp" %>
</body>
</html>

<%!
    private String verifyErrors(String name, Map<String,String> errors){
        if(errors!=null && errors.get(name)!=null){ return "invalid"; }
        return "";
    }
    private String getTittle(String name, Map<String,String> errors){
        if(errors!=null && errors.get(name)!=null){ return errors.get(name); }
        return "";
    }
    
    private Map<String,String[]> getCredencials(Model model){
        Map<String,String[]> credencials = new HashMap<String,String[]>();
        credencials.put("cedula", new String[]{model.getCurrent().getCedula()});
        credencials.put("clave", new String[]{model.getCurrent().getClave()});
        return credencials;
    }
%>
