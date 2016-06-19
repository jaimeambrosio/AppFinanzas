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
                            <th>Nombres</th>
                            <th>Apellidos</th>

                        </tr>
                    </thead>
                    <tbody  >
                        <tr>
                            <td><input></td>
                            <td><input class="form-control" value="123" ></td>
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