<%@page import="com.mycompany.spj.examen.model.Sorteo"%>
<%@page import="com.mycompany.spj.examen.controller.admin.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Model model = (Model) request.getAttribute("model"); %>
<% if(model == null) { model = new Model(); }%>

<!DOCTYPE html>
<html>
    <head>
        <title>SJP</title> 
        <%@ include file="/pages/Head.jsp" %>
    </head>
<body >
    <%@ include file="/pages/Header.jsp" %>
    <div class="container  ml-3">
        <div class="table">
            <h2>Sorteos Anteriores</h2>
            <table>
                <thead>
                    <tr>
                        <th> Motivo  </th>
                        <th> Fecha   </th>
                        <th> Retorno </th>
                        <th> Ganador </th>
                        <th> Número ganador <th>
                        <th>  <th>
                    </tr>
                </thead>
                <tbody>
                    <%for(Sorteo sorteo: model.getSorteos_terminados()){ %>
                    <tr>
                        <td>
                            <%= sorteo.getMotivo() %>
                        </td>
                        <td>
                             <%= sorteo.getStringDate() %>
                        </td >
                        <td>
                            <%= sorteo.getRetorno() %>
                        </td>
                         <td>
                            <%= sorteo.getNumero_ganador() %>
                        </td>
                        <form name="name" action="/spj-examen/admin/update/sort" method="post">
                            <input type="hidden" name="numero_sorteo" value="<%= sorteo.getNumero_sorteo() %>">
                            <td>
                                <input type="text" name="numero_ganador" >
                            </td>
                            <td>
                                <input class="button" type="submit" value="Actualizar"> 
                            </td>
                        </form>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
    <%@ include file="/pages/Footer.jsp" %>
</body>
</html>