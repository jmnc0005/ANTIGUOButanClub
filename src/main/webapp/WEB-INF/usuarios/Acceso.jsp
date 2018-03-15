<%-- 
    Document   : Acceso
    Created on : 19-feb-2018, 13:46:26
    Author     : josem
--%><%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%@include file="WEB-INF/templates/estilos.jspf" %>
    </head> 

 
<%@include file="WEB-INF/templates/navbar.jspf" %>
    <body>
        
        
        <div class="row justify-content-center">
            <div class="col-md-4 box">
                <center>
                    <form name="registro_usuarios" method="POST">
                    <fieldset>
                        <legend>
                            <h2>Nuevo Usuario</h2>
                         
                        </legend>
                        
                        <label>Nombre de Usuario:<input type="text" name="usuario" required class="form-control" ></label>
                        <label>Contraseña: <input type="password" name="pass" required class="form-control"></label>
                        <label>Confirme Contraseña: <input type="password" required name="confirmacion-pass" class="form-control"></label>
                        
                                <label>Nombre: <input type="text" name="nombre" required class="form-control"></label>
                                            
                                <label>Apellidos: <input type="text" name="apellidos" required class="form-control"></label>
                                                  
                                <label>E-mail: <input type="email" name="email" required class="form-control"></label>
                                                  
                                <label>Fecha Nacimiento: <input type="date" required name="fecha" class="form-control"></label>
                                                  
                                <label>Teléfono: <input type="tel" name="tlfn" required class="form-control"></label>
                            
                    </fieldset>
                   
                        <input type="submit" name="altaUsuario" value="Enviar" class="btn btn-primary">
                        <input type="reset" name="reset" value="Reestablecer" class="btn">
                    
                </form>
            </center>
            </div>
            <div class="col-md-4 box">
                <center>
                <form name="registro_usuarios" method="POST" action="infoUsuario.jsp">
                    <fieldset>
                        <legend>
                            <h2>Soy usuario.</h2>
                         
                        </legend>
                        
                        <label>Nombre de Usuario:<input type="text" name="usuario"  required class="form-control"></label><br>
                        <label>Contraseña: <input type="password" name="pass"  required class="form-control"></label><br>
                                                   
                    </fieldset>
                   
                        <input type="submit" name="Enviar" value="Enviar" class="btn btn-primary">
                </form>
                </center>   
            </div>
        </div>

    </body>
<%@include file="WEB-INF/templates/footer.jspf" %>
</html>