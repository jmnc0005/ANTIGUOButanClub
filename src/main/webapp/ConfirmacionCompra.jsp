<%-- 
    Document   : ConfirmacionCompra
    Created on : 25-feb-2018, 17:35:40
    Author     : Pedro Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <!--<link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/font-awesome.css">  
        -->
        <%@include file="templates/estilos.jspf" %>
    </head> 
    <%@include file="templates/header.jspf" %>
    <%@include file="templates/navbar.jspf" %>
    <body>


        <div class="row justify-content-center">
            <div class="col-lg-8 box">
                <div class="row centrar-contenido">
                    <h1>Entradas compradas</h1>
                </div>
                <div class="row centrar-contenido">
                    <div class="col-md-4">
                        <%@include file="templates/modulos/datos-usuario.jspf" %>
                    </div>
                    <div class="col-md-4">
                        <%@include file="templates/modulos/datos-concierto.jspf" %>
                    </div>

                </div>
                <br>
                <div class="row centrar-contenido">
                    Numero de entardas:  <%= request.getParameter("numero-entradas")%>

                </div>
                <div class="row centrar-contenido">
                    <br>
                    <h2>Codigos de entradas:</h2>

                </div>
                <div class="row centrar-contenido">
                    <list>
                    <ul>
                        <%for(int i=0; i< Integer.parseInt(request.getParameter("numero-entradas"));i++){%>
                        <li> <%int a = (int)(Math.random()*999999); 
                            out.println(a);%> </li>
                        <%}%>
                    </ul>
                    </list>
                </div>
            </div>
        </div>
    </div>

</body>
<%@include file="templates/footer.jspf" %>
</html>

</html>
