<%@page import="com.mycompany.spj.examen.model.Sorteo"%>
<%@page import="com.mycompany.spj.examen.model.Apuesta"%>
<%@page import="com.mycompany.spj.examen.controller.player.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Map<String, String> errors =(Map<String,String>) request.getAttribute("errors"); %>
<% Model model = (Model) request.getAttribute("model"); %>
<% Map<String, String[]> credencials = (errors!=null)?request.getParameterMap():getCredencials(model); %>

<!DOCTYPE html>
<html>
    <head>
        <title>Jugador</title> 
        <%@ include file="/pages/Head.jsp" %>
    </head>
    <body>
        <%@ include file="/pages/Header.jsp" %>
        <div class="container  ml-3">
            <h2>Sorteos Anteriores</h2>
            <table>
                <thead>
                    <tr>
                        <th> Motivo  </th>
                        <th> Fecha   </th>
                        <th> Retorno </th>
                        <th> Ganador </th>
                        <th> Casas <th>
                        <th> Premio <th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Apuesta apuesta : model.getLista_apuestas()) {%>
                    <tr>
                        <td>
                            <%= apuesta.getSorteo().getMotivo()%>
                        </td>
                        <td>
                            <%=  apuesta.getSorteo().getStringDate()%>
                        </td >
                        <td>
                            <%=  apuesta.getSorteo().getRetorno()%>
                        </td>
                        <td>
                            <% if(apuesta.getSorteo().getNumero_ganador() != null){ %> 
                                <%= apuesta.getSorteo().getNumero_ganador() %>
                            <%} else {%>
                                null
                            <%}%>
                        </td>
                        <td>
                            (₡ <%=  apuesta.getMonto_apuesta()%>, <%=  apuesta.getNumero_juego()%> )
                        </td>
                        <td>
                            <%=  apuesta.getMonto_premio() %>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <form name="form" action="/spj-examen/player/bet" method="post">
                <table>
                    <thead>
                        <tr>
                            <td>
                                Sorteo 
                            </td>
                            <td>
                                <select name="numero_sorteo">
                                    <%for(Sorteo sorteo : model.getLista_sorteos()){ %>
                                        <option value="<%= sorteo.getNumero_sorteo() %>"> <%= sorteo.getStringDate() %> - <%= sorteo.getMotivo() %> </option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Numero
                            </td>
                             <td>
                                <input class ="<%=verifyErrors("numero_juego",errors)%>" type="text" name="numero_juego" 
                                value="<%=credencials.get("numero_juego")[0]%>" title="<%=getTittle("numero_juego",errors)%>">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Monto
                            </td>
                             <td>
                                <input class ="<%=verifyErrors("monto_apuesta",errors)%>" type="text" name="monto_apuesta" 
                                value="<%=credencials.get("monto_apuesta")[0]%>" title="<%=getTittle("monto_apuesta",errors)%>">
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
        credencials.put("monto_apuesta", new String[]{model.getMonto_apuesta()});
        credencials.put("numero_juego", new String[]{model.getNumero_juego()});
        return credencials;
    }
%>
