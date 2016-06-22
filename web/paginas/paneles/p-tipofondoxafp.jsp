<%-- 
    Document   : p-tipofondoxafp
    Created on : 18/06/2016, 10:35:20 PM
    Author     : Jaime Ambrosio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title" id="tituloPanel"></h3>
    </div>
    <div class="panel-body">
        <div class="row" >
            <div class="col-sm-12" >
                <button onclick="listarTiposFondoXAFP();" class="btn btn-primary" > Refrescar</button>
            </div>
        </div>
        <br>
        <br>
        <div class="row" >    
            <div class="col-sm-12" >
                <table id="tblTipoFondoXAfp"   class="display nowrap" cellspacing="0" width="100%">
                    <thead>
                            <tr>
                                <th>AFP \\ Tipo fondo</th>
                                <th>Fondo 0</th>
                                <th>Fondo 1</th>
                                <th>Fondo 2</th>
                                <th>Fondo 3</th>
                            </tr>
                        
                    </thead>
                    <tbody  >
                        <tr>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                            <td>...</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row" >    
            <div class="col-sm-4" ></div>
            <div class="col-sm-4" ></div>
            <div class="col-sm-4" >
                  <button onclick="actualizarRentabilidades();" class="btn btn-primary" > Actualizar valores</button>
            </div>
        </div>
    </div>
</div>
<br>
<script src="/AppFinanzas/js/paneles/p-tipofondoxafp.js" type="text/javascript"></script>