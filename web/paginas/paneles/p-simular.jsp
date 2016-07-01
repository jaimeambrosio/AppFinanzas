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
                <section id="idSectionTimeline" class="cd-horizontal-timeline" style="display: none;" >   
                    <div class="timeline">
                        <div class="events-wrapper">
                            <div class="events">
                                <ol>
                                    <li><a href="#0" data-date="01/01/2014" class="selected">16 Jan</a></li>
                                    <li><a href="#0" data-date="01/01/2030">2030</a></li>
                                </ol>
                                <span style="display: none;" class="filling-line" aria-hidden="true"></span>
                            </div> <!-- .events -->
                        </div> <!-- .events-wrapper -->

                        <ul class="cd-timeline-navigation">
                            <li><a href="#0" class="prev inactive">Prev</a></li>
                            <li><a href="#0" class="next">Next</a></li>
                        </ul> 
                    </div> <!-- .timeline -->

                    <div class="events-content">
                        <ol>
                            <li class="selected" data-date="01/01/2014">
                                <h2>Horizontal Timeline</h2>
                                <em>01/01/2014</em>
                                <p>	
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illum praesentium officia, fugit recusandae ipsa, quia velit nulla adipisci? Consequuntur aspernatur at, eaque hic repellendus sit dicta consequatur quae, ut harum ipsam molestias maxime non nisi reiciendis eligendi! Doloremque quia pariatur harum ea amet quibusdam quisquam, quae, temporibus dolores porro doloribus.
                                </p>
                            </li>

                            <li data-date="01/01/2030">
                                <h2>Event title here</h2>
                                <em>01/01/2030</em>
                                <p>	
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illum praesentium officia, fugit recusandae ipsa, quia velit nulla adipisci? Consequuntur aspernatur at, eaque hic repellendus sit dicta consequatur quae, ut harum ipsam molestias maxime non nisi reiciendis eligendi! Doloremque quia pariatur harum ea amet quibusdam quisquam, quae, temporibus dolores porro doloribus.
                                </p>
                            </li>
                        </ol>
                    </div> <!-- .events-content -->
                </section>        
            </div>
        </div>


    </div>
</div>
<%@include file="../modals/modalEdicionSimulacion.jsp" %>
<link href="/AppFinanzas/libs/horizontal-timeline/css/reset.css" rel="stylesheet" type="text/css"/>
<link href="/AppFinanzas/libs/horizontal-timeline/css/style.css?1.2" rel="stylesheet" type="text/css"/>
<script src="/AppFinanzas/js/paneles/p-simular.js" type="text/javascript"></script>