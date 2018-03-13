<%-- 
    Document   : respuesta
    Created on : 16-feb-2018, 16:26:26
    Author     : josem
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%@include file="WEB-INF/templates/tipoUsuario.jspf" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <!--<link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/font-awesome.css">  
        -->
        <%@include file="WEB-INF/templates/estilos.jspf" %>
    </head> 


     
    <%@include file="WEB-INF/templates/navbar.jspf" %>
    <body>
        <div class="box">

            <%-- saludo --%>
            <div class="row centrar-contenido">
                
                <h1> Bienvenido <%= request.getParameter("usuario")%>.
                    <br>
                </h1>
               
            </div>
        </div>
        <div class="box">
            <%-- informacion de usuarios --%>
            <div class="row centrar-contenido">
                <h2>Tus conciertos</h2>
                <br>
            </div>
            <%@include file="WEB-INF/templates/modulos/conciertos-usuario.jspf" %>

        </div>
        <%if (request.getParameter("tipoUsuario") != null) {%>
        <%String posibleUsuario = request.getParameter("posible-usuario");%>

        <%if (posibleUsuario.equals("Artista")) {%>
        <div class="box">
            <%-- informacion de artistas --%>
            <DIV class="row centrar-contenido">
                <h2>Solicitar sala</h2>
            </DIV>
            <%@include file="WEB-INF/templates/modulos/solicitar-sala.jspf" %>                          



        </div>
        <%}%>
        <%if (posibleUsuario.equals("Administrador")) {%>
        <div class="box">
            <%-- informacion de administradoes gestionar conciertos --%>
            <div class="row centrar-contenido">
                <h2>Gestión de conciertos</h2>
            </div>
            
            <%@include file="WEB-INF/templates/modulos/gestion-conciertos.jspf" %>  
        </div>
        <div class="box">
            <%-- informacion de administradoes gestionar usuarios --%>
             <div class="row centrar-contenido">
                <h2>Gestión de usuarios</h2>
            </div>
            
            <%@include file="WEB-INF/templates/modulos/gestion-usuarios.jspf" %>  
        </div>
        <%}%>
        <%}%>
    </body>
    <%@include file="WEB-INF/templates/footer.jspf" %>
</html>

