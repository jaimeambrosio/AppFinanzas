<%-- 
    Document   : modalEdicionSimulacion
    Created on : 28/06/2016, 08:56:28 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="fina.afp.entity.Tipofondo"%>
<%@page import="java.util.List"%>
<%@page import="fina.afp.entity.Afp"%>
<%@page import="fina.afp.dao.AfpDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AfpDao afpDao = new AfpDao();
%>
<div class="modal fade" data-backdrop="false" id="modalEdicionSimulacion" tabindex="-1" role="dialog" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="" id="formEdicionSimulacion"  method="POST" autocomplete="off" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modalEdicionSimulacionTitle"  >
                        <span class="glyphicon glyphicon-plus-sign"></span>
                        Nueva simulación
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Alias </label>
                                <input  class="form-control" id="txtAlias" name="txtAlias" required="" value="" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Seleccione Afp </label>
                                <% List<Afp> listAfp = afpDao.listar(); %>
                                <select class="form-control" onchange="changeMostrarRentSug();" id="cbxAfp" name="cbxAfp">
                                    <% for (Afp afp : listAfp) {%>
                                    <option value="<%=afp.getIdAFP()%>"  ><%=afp.getTitulo()%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>
                    </div>                    
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Fecha desde </label>
                                <input class="form-control" id="txtFechaDesde" name="txtFechaDesde" required="">
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Tipo de fondo </label>
                                <% List<Tipofondo> listTipofondo = afpDao.listarTipofondo();

                                    for (Tipofondo tf : listTipofondo) {
                                %>
                                <div class="radio <%=!tf.getIsActivo() ? "disabled" : ""%>"> 
                                    <label data-toggle="tooltip" title="<%=tf.getDetalle()%>"  >
                                        <input onchange="changeMostrarRentSug();" type="radio" name="rbTipoFondo"  value="<%=tf.getIdTIPOFONDO()%>" <%=(!tf.getIsActivo()) ? "disabled" : ""%> required="" >
                                        <%=tf.getTitulo() + " - Fondo " + (tf.getIdTIPOFONDO() - 1) + " "%>  
                                    </label>
                                </div>
                                <%}%>

                            </div>
                        </div>
                    </div>                    
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Aportación mensual </label>
                                <div class="input-group">
                                    <input class="form-control" id="txtAportacionMensual" name="txtAportacionMensual" type="number" min="10" required="" >
                                    <div class="input-group-addon">%</div>
                                </div>
                            </div>
                        </div>  
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Rentabilidad probable </label>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" id="chRentSug" value="true" checked="checked" onchange="changeUsarRentSug();" >
                                        Usar rentabilidad sugerida
                                    </label>
                                </div>
                                <div class="input-group">
                                    <input readonly="readonly" class="form-control" id="txtRentabilidadProbable" name="txtRentabilidadProbable" type="number" max="10" min="0" required="" >
                                    <div class="input-group-addon">%</div>
                                </div>
                            </div>
                        </div>  
                    </div>                    
                    <div class="row" >
                        <div class="col-sm-6" >
                            <label  >Descripción </label>
                            <textarea id="txtDescripcionHito" name="txtDescripcionHito"  class="form-control" rows="2"></textarea>
                        </div>  
                        <div class="col-sm-6" >

                        </div>

                    </div>   
                    <br>
                    <label  >(<label class="required" ></label>)Campos obligatorios</label>
                    <input type="hidden" value="" id="accion" name="accion">
                </div>
                <div class="modal-footer">

                    <button type="submit" class="btn btn-primary" >Calcular</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>