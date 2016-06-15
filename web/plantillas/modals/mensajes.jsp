<%-- 
    Document   : mensajes
    Created on : 02/06/2016, 09:41:56 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" data-backdrop="false" id="modalMensajes" tabindex="-1" role="dialog" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="" method="POST" autocomplete="off" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modalMensajeTitle"  >

                    </h4>
                </div>
                <div class="modal-body">
                    <div class="row" >
                        <div class="col-sm-3"  align="center">
                            <img  id="modalMensajesIconInformation" src="/AppFinanzas/img/information.png" alt=""/>
                            <img  id="modalMensajesIconWarning" src="/AppFinanzas/img/warning.png" alt=""/>
                            <img  id="modalMensajesIconError" src="/AppFinanzas/img/error.png" alt=""/>
                        </div>
                        <div class="col-sm-9"  >
                            <div id="modalMensajesCuerpo" ></div>
                            <br>
                            <div  >
                                <button class="btn btn-default" type="button" data-toggle="collapse" data-target="#collapseModalMensajeDetalle" aria-expanded="false" aria-controls="collapseModalMensajeDetalle">
                                    Mostrar detalles
                                </button>

                                <div class="collapse" id="collapseModalMensajeDetalle">
                                    <br>
                                    <div class="well" id="modalMensajesDetalle" >

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>                    
                    <div class="row" >

                    </div>                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<div class="modal fade" data-backdrop="false" id="modalPedidoPass" tabindex="-1" role="dialog" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title"   >
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                    Contraseña requerida 
                </h4>
            </div>
            <div class="modal-body">
                <div class="row" >
                    <div class="col-sm-3"  align="center">
                        <img  id="modalMensajesIconInformation" src="/AppFinanzas/img/information.png" alt=""/>
                    </div>
                    <div class="col-sm-9"  >
                        <div class="form-group">
                            <label class="required">Para ingresar en el apartado seleccionado requiere que vuelva a ingresar su contraseña </label>
                            <input type="password" class="form-control" id="txtContrasenia" name="txtContrasenia" required="" value="">
                        </div>

                    </div>

                </div>                    
                <div class="row" >

                </div>    
                <input type="hidden" id="data-link" >
                <input type="hidden" id="data-constructor" >

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" >Ingresar</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->