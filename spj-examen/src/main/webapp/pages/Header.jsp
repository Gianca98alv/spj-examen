<%@page import="com.mycompany.spj.examen.model.Usuario"%>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<header>
    <ul>
        <li>
            <img class="logo" src="${pageContext.request.contextPath}/images/logo.png" alt="Logo Principal"/>
        </li>
        <li>
            <a class="title">Sociedad Protectora de Jovenes</a>
        </li>
    </ul>
    <div class="menu">
        <ul class="nav"> 
            <li> <a href="/spj-examen/index">Inicio</a> </li>
            <% if(usuario == null){ %>
                <li><a href="/spj-examen/login/show">Iniciar sesión</a></li>         
            <% } %>
            <% if( usuario != null){ %>
                <% if(usuario.getAdministrador()){ %>
                    <li><a href="/spj-examen/administrador">Actualizar sorteos</a></li>
                <%} else { %>
                     <li><a href="/spj-examen/player">Apuestas</a></li>
                <% } %>
                <li><a href="/spj-examen/login/logout">Cerrar sesión</a></li>
            <% } %>
        </ul>
    </div>
</header>
