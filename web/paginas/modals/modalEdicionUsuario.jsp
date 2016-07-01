<%-- 
    Document   : modalEdicionUsuario
    Created on : 15/06/2016, 04:14:15 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="fina.usuario.entity.Tipousuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="fina.usuario.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" data-backdrop="false" id="modalEdicionUsuario" tabindex="-1" role="dialog" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form  id="idFormModalEdicionUsuario" enctype="multipart/form-data" >
                <input  type="hidden" id="txtIdUsuario" name="txtIdUsuario" value=""  >
                <input  type="hidden" id="txtGuardarUsuario" name="txtGuardarUsuario" value=""  >
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
                            <div class="form-group">
                                <label class="required">Apellidos </label>
                                <input  class="form-control" id="txtApellidos" name="txtApellidos" required="" value="">
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Fecha de nacimiento </label>
                                <input  class="form-control" id="txtFechaNacimiento" name="txtFechaNacimiento" required="" value="" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Usuario</label>
                                <input  class="form-control" id="txtUsuario" name="txtUsuario" required="" minlength="5" >
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Contraseña</label>
                                <input  class="form-control" type="password" id="txtContrasenia" name="txtContrasenia" minlength="5" required="" >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Sexo</label>
                                <div class="input-group btn-group" data-toggle="buttons"  >
                                    <label id="lblMasculino" class="btn btn-default ">
                                        <input type="radio" name="rbSexo" value="M"  autocomplete="off"   > Masculino
                                    </label>
                                    <label id="lblFemenino" class="btn btn-default">
                                        <input type="radio" name="rbSexo" value="F"  autocomplete="off" required=""   > Femenino
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-12" >
                            <div class="form-group">
                                <label id="lblTextNombreFoto" >Foto </label>
                                <input  accept="image/*"  class="form-control" type="file" id="txtFoto" name="txtFoto"   >
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label >DNI </label>
                                <input  class="form-control" type="text" id="txtDNI" name="txtDNI" minlength="8"  >
                            </div>
                        </div>
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Tipo de usuario</label>
                                <select   class="form-control" required="" id="tipoUsuario" name="tipoUsuario"  >  
                                    <%
                                        UsuarioDao usuarioDao = new UsuarioDao();
                                        List<Tipousuario> listtipo = usuarioDao.listarTipousuario();
                                    %>
                                    <%  for (Tipousuario ti : listtipo) {%>

                                    <option value="<%=ti.getIdTipoUsuario()%>"  ><%=ti.getTitulo()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >
                            <div class="form-group">
                                <label class="required" >Estado </label>
                                <select  class="form-control" required="" id="txtEstado" name="txtEstado"  >  
                                    <option value="false" >No eliminado</option>
                                    <option value="true" >Eliminado</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6" >

                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-sm-6" >

                        </div>
                        <div class="col-sm-6" >

                        </div>
                    </div>
                    <br>
                    <label class="error" >(<label class="required" ></label>)Campos obligatorios</label>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" >Registrar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
