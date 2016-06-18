<%-- 
    Document   : p-usuarios
    Created on : 15/06/2016, 08:35:01 AM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title" id="tituloPanel"></h3>
    </div>
    <div class="panel-body">
        <div class="row" >
            <div class="col-sm-6" ><button id="btnBuscarUsuariosEdicion" onclick="buscarUsuarios();" class="btn btn-primary" >Buscar</button></div>
            <div class="col-sm-6" ><button class="btn btn-primary" onclick="nuevoUsuario();"  >Nuevo Usuario</button></div>
        </div>
    </div>
</div>
<br>
<%@include file="../modals/modalEdicionUsuario.jsp" %>
<table id="tblPanelUsuarios"  class="display nowrap" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Usuario</th>
            <th>Fecha Nac</th>
            <th>Sexo</th>
            <th>DNI</th>
            <th>ESTADO</th>
            <th>...</th>
        </tr>
    </thead>
    <tbody  >
    </tbody>
</table>
<script src="/AppFinanzas/js/paneles/p-usuarios.js" type="text/javascript"></script>

