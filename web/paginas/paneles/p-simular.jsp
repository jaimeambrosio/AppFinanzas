<%-- 
    Document   : p-inicio.jsp
    Created on : 31/05/2016, 07:49:06 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    .contenedor-linea{
        position: relative;
        overflow-x:     scroll;
        height: 100px;
        background: transparent;
        vertical-align:middle;
        margin: 30px;

    }
    .linea{
        position: absolute;
        left:0;
        height: 5px;
        width: 2000px;
        /* width will be set using JavaScript */
        background: #31b0d5;
        vertical-align:middle;
        top: 50%;
        cursor: pointer;
    }
    .hito{
        position: absolute;
        height: 15px;
        width:  15px;
        border-radius: 50%;
        border: 2px;
        background-color: #398439;
        top: -100%;

    }


</style>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title" id="tituloPanel"></h3>
    </div>
    <div class="panel-body">
        <div class="row" >
            <div class="col-sm-6" >
                <button id="btnBuscarUsuariosEdicion" onclick="nuevaSimulacion();" class="btn btn-primary" > 
                    <span class="glyphicon glyphicon-plus-sign" ></span>
                    Nueva Simulación
                </button>
            </div>
            <div class="col-sm-6" >                
                <button class="btn btn-primary" onclick="simulacionesAlmacenadas();"  >
                    <span class="glyphicon glyphicon-list-alt" ></span>
                    Simulaciones almacenadas
                </button>
            </div>
        </div>
        <br>
        <div class="panel panel-default">
            <div class="panel-body">
                <button id="btnNuevoHitoSimulacion" onclick="nuevoHito();" class="btn btn-primary" > 
                    <span class="glyphicon glyphicon-plus-sign" ></span>
                    Nuevo hito
                </button>
                <br>
                <br>
                
                <div id="sectionTimeLine" ></div>       
            </div>
        </div>


    </div>
</div>
<%@include file="../modals/modalEdicionSimulacion.jsp" %>

<div id="divModalListaSimulaciones" ></div>
<link href="/AppFinanzas/libs/horizontal-timeline/css/reset.css" rel="stylesheet" type="text/css"/>
<link href="/AppFinanzas/libs/horizontal-timeline/css/style.css?1.2" rel="stylesheet" type="text/css"/>
<script src="/AppFinanzas/js/paneles/p-simular.js" type="text/javascript"></script>