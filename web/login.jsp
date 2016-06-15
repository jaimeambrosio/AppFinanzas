<%-- 
    Document   : login.jsp
    Created on : 31/05/2016, 12:35:23 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="plantillas/styles.jsp" %>
        <title>Sistema financiero - AFP - Ingreso al sistema</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Simulador de fondo de pensiones</h1>
                <h2>y otros utilitarios financieros</h2>
                <p>Este simulador te ayudará a planificar tus aportaciones en rangos de fechas para que puedas disfrutar del nivel de vida que deseas a la jubilación. Con el tambien podra comparar las diferentes AFP existentes en lo referido a comisiones.</p>
            </div>
            <div class="row">
                <div class="col-md-4">

                </div>
                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Ingresar al sistema</h3>
                        </div>
                        <div class="panel-body">
                            <form id="idFormLogin"  method="POST">
                                <div class="form-group">
                                    <label class="required">Usuario</label>
                                    <input type="text" minlength="5" class="form-control" name="txtUsuario" value="admin" id="txtUsuario" placeholder="Usuario" required="">
                                </div>
                                <div class="form-group">
                                    <label class="required">Contraseña</label>
                                    <input type="password" minlength="5" name="txtContrasenia" id="txtContrasenia" value="admin" class="form-control"  placeholder="Contraseña" required>
                                </div>

                                <div class="form-group">
                                    <div class="checkbox">
                                        <label>
                                            <input name="txtRecordarP" id="txtRecordarP" type="checkbox" value="true"> Recordar contraseña
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group" align="center" >

                                    <button type="submit" class="btn btn-primary">Ingresar al sistema</button>
                                    <br>
                                    <br>
                                    <a href="#">Soy nuevo en el sistema </a>
                                </div>

                            </form>    
                        </div>
                    </div>
                </div>
                <div class="col-md-4">

                </div>
                <div>
                    <%@include  file="plantillas/modals/mensajes.jsp" %>
                </div>
            </div>
        </div>
        <%@include file="plantillas/scripts.jsp" %>
        <script src="js/login.js" type="text/javascript"></script>
    </body>
</html>
