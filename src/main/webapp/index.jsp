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
            <div class="col-lg-8 ">
                <form name="registro_usuarios" method="POST" action="respuesta.jsp">
                    <fieldset>
                        <legend>
                            Datos de Usuario
                        </legend>
                        <div class="row">
                            <div class="col-md-4">
                                <label>Nombre: <input type="text" name="nombre" class="form-control"></label>
                            </div>
                            <div class="col-md-4">
                                <label>Apellidos: <input type="text" name="apellidos" class="form-control"></label>
                            </div>
                            <div class="col-md-4">
                                <label>E-mail: <input type="email" name="mail" class="form-control"></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <label>Contraseña: <input type="password" name="password" class="form-control"></label>
                            </div>
                            <div class="col-md-4">
                                <label>Fecha Nacimiento: <input type="date" name="fecha" class="form-control"></label>
                            </div>
                            <div class="col-md-4">
                                <label>Teléfono: <input type="number" name="tlfn" class="form-control"></label>
                            </div>
                        </div>
                    </fieldset>
                    <center>
                        <input type="submit" name="Enviar" value="Enviar" class="btn btn-primary">
                        <input type="reset" name="reset" value="Reestablecer" class="btn">
                    </center>
                </form>
                <!-- Hey Webmaster! Place this html code where you'd like the game to appear. -->
<iframe src="https://www.silvergames.com/es/pacman/iframe" width="450" height="500" style="margin:0;padding:0;border:0"></iframe>
<p style="text-align:center">¡Un <a href="https://www.silvergames.com/es/t/retro">Juegos Retro</a> en Silvergames.com!</p>
<!-- End of game embed code -->
    
            </div>
        </div>

    </body>
    <%@include file="templates/footer.jspf" %>
</html>
