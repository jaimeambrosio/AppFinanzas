<%-- 
    Document   : p-miperfil
    Created on : 01/06/2016, 05:50:40 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title" id="tituloPanel"></h3>
    </div>
    <div class="panel-body">
        <form id="idFormMiPerfil" action="asd" >
            <div class="row" >
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Nombres </label>
                        <input  class="form-control" id="txtNombres" name="txtNombres" required="" >
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required">Apellidos </label>
                        <input  class="form-control" id="txtApellidos" name="txtApellidos" required="" >
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Fecha de nacimiento </label>
                        <input  class="form-control" id="txtFechaNacimiento" name="txtFechaNacimiento" required="" >
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Usuario</label>
                        <input  class="form-control" id="txtUsuario" name="txtUsuario" required=""  >
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Contrseña</label>
                        <input  class="form-control" type="password" id="txtContrasenia" name="txtContrasenia" required="" >
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Sexo</label>
                        <div class="input-group btn-group" data-toggle="buttons"  >
                            <label class="btn btn-default active">
                                <input type="radio" name="rbSexo" value="M"  autocomplete="off"  > Masculino
                            </label>
                            <label class="btn btn-default">
                                <input type="radio" name="rbSexo" value="F"  autocomplete="off" required="" > Femenino
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-8" >
                    <div class="form-group">
                        <label >Foto</label>
                        <input  accept="image/*"  class="form-control" type="file" id="txtFoto" name="txtFoto"  >
                    </div>
                </div>

                <div class="col-sm-4" >
                    <div class="form-group">
                        <label >DNI </label>
                        <input  class="form-control" type="text" id="txtFoto" name="txtDNI"  >
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-4" >
                    <div class="form-group">
                        <label class="required" >Tipo de usuario</label>
                        <select class="form-control" required=""  >  </select>
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                    </div>
                </div>
                <div class="col-sm-4" >
                    <div class="form-group">
                         <label ></label>
                        <input type="submit" class="form-control btn btn-primary" value="Guardar cambios">
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>
<script src="/AppFinanzas/js/paneles/p-miperfil.js" type="text/javascript"></script>