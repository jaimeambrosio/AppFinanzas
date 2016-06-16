<%-- 
    Document   : modalEdicionUsuario
    Created on : 15/06/2016, 04:14:15 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" data-backdrop="false" id="modalEdicionUsuario" tabindex="-1" role="dialog" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form  id="idFormModalEdicionUsuario" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title"   >
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        Usuario
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Nombres </label>
                                <input  class="form-control" id="txtNombres" name="txtNombres" required="" value="" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Nombres </label>
                                <input  class="form-control" id="txtNombres" name="txtNombres" required="" value="" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Ingresar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
