<%-- 
    Document   : p-miperfil
    Created on : 01/06/2016, 05:50:40 PM
    Author     : Jaime Ambrosio
--%>
<%@page import="java.util.List"%>
<%@page import="fina.usuario.entity.Tipousuario"%>
<%@page import="fina.usuario.dao.UsuarioDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fina.usuario.entity.Usuario"%>
<%
    Usuario usuarioLogeado = (Usuario) request.getSession().getAttribute("usuarioLogeado");
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title" id="tituloPanel"></h3>
    </div>
    <div class="panel-body">
        <form id="idFormMiPerfil" enctype="multipart/form-data" >
            <input  type="hidden" id="txtIdUsuario" name="txtIdUsuario" value="<%=usuarioLogeado.getIdUSUARIO()%>"  >
            <input  type="hidden" id="txtEstado" name="txtEstado" value="false"  >
            <div class="row" >
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Nombres </label>
                        <input  class="form-control" id="txtNombres" name="txtNombres" required="" value="<%=usuarioLogeado.getNombres()%>" >
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required">Apellidos </label>
                        <input  class="form-control" id="txtApellidos" name="txtApellidos" required="" value="<%=usuarioLogeado.getApellidos()%>">
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Fecha de nacimiento </label>
                        <input  class="form-control" id="txtFechaNacimiento" name="txtFechaNacimiento" required="" value="<%=format.format(usuarioLogeado.getFechaNacimiento())%>" >
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Usuario</label>
                        <input  class="form-control" id="txtUsuario" name="txtUsuario" required="" value="<%=usuarioLogeado.getUsername()%>"  >
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Contrseña</label>
                        <input  class="form-control" type="password" id="txtContrasenia" name="txtContrasenia" required=""  value="<%=usuarioLogeado.getContrasenia()%>">
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Sexo</label>
                        <div class="input-group btn-group" data-toggle="buttons"  >
                            <label class="btn btn-default <%=usuarioLogeado.getSexo() ? "active" : ""%>">
                                <input type="radio" name="rbSexo" value="M"  autocomplete="off"  <%=usuarioLogeado.getSexo() ? "checked" : ""%> > Masculino
                            </label>
                            <label class="btn btn-default <%=!usuarioLogeado.getSexo() ? "active" : ""%>">
                                <input type="radio" name="rbSexo" value="F"  autocomplete="off" required=""  <%=!usuarioLogeado.getSexo() ? "checked" : ""%> > Femenino
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-8" >
                    <div class="form-group">
                            <label >Foto (Actualmente <%=usuarioLogeado.getNombreFoto() == null
                                    ? "sin foto" : usuarioLogeado.getNombreFoto()%>)</label>
                        <input  accept="image/*"  class="form-control" type="file" id="txtFoto" name="txtFoto"   >
                    </div>
                </div>

                <div class="col-sm-4" >
                    <div class="form-group">
                        <label >DNI </label>
                        <input  class="form-control" type="text" id="txtDNI" name="txtDNI" value="<%=usuarioLogeado.getDni()%>"  >
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Tipo de usuario</label>
                        <select readonly=""  class="form-control" required="" id="tipoUsuario" name="tipoUsuario"  >  
                            <%
                                UsuarioDao usuarioDao = new UsuarioDao();
                                List<Tipousuario> listtipo = usuarioDao.listarTipousuario();
                            %>
                            <%  for (Tipousuario ti : listtipo) {%>

                            <option value="<%=ti.getIdTipoUsuario()%>" <%=ti.getIdTipoUsuario() == usuarioLogeado.getIdTipoUsuario().getIdTipoUsuario() ? "selected" : ""%> ><%=ti.getTitulo()%></option>
                            <%}%>
                        </select>
                        <input type="hidden" name="tipoUsuario" value="<%=usuarioLogeado.getIdTipoUsuario().getIdTipoUsuario()%>" >
                    </div>
                </div>
                
                <div class="col-sm-4" >
                    <div class="form-group">
                        <div class="form-group">
                            <label ></label>
                            <input  type="button" id="habilitarModificacion"  class="form-control btn btn-default" value="Habilitar modificacion">
                        </div>
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label ></label>
                        <input type="submit" id="btnGuardarCambios" style="display: none;" class="form-control btn btn-primary" value="Guardar cambios">
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>
<script src="/AppFinanzas/js/paneles/p-miperfil.js" type="text/javascript"></script>