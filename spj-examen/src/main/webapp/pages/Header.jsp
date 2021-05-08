<%@page import="com.mycompany.spj.examen.model.Usuario"%>

<% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
<header>
    <ul>
        <li>
            <img class="logo" src="${pageContext.request.contextPath}/images/logo.png" alt="Logo Principal"/>
        </li>
        <li>
            <a class="title">SPJ</a>
        </li>
    </ul>
    <div class="menu">
        <ul class="nav"> 
            <li> <a href="/spj-examen/index">Inicio</a> </li>
            <% if(usuario == null){ %>
                <li><a href="/spj-examen/login/show">Iniciar Sesión</a></li>         
            <% } %>
            <% if( usuario != null){ %>
                <% if(usuario.getAdministrador()){ %>
                    <li><a href="/spj-examen/administrador"></a></li>
                <%} else { %>
                     <li><a href="/spj-examen/player">Apuestas</a></li>
                <% } %>
                <li><a href="/spj-examen/login/logout">Cerrar Sesión</a></li>
            <% } %>
        </ul>
    </div>
</header>
