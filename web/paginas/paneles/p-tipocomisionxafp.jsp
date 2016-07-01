<%-- 
    Document   : p-tipocomisionxafp
    Created on : Jun 20, 2016, 8:00:37 PM
    Author     : alumnos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title" id="tituloPanel"></h3>
    </div>
    <div class="panel-body">
        <div class="well">
            <h4>Notas</h4>
            <ol>
                <li>La comision sobre flujo es mensual(TEM)</li>
                <li>La comision sobre saldo es anual(TEA)</li>
                <li>Fuente <a target="_blank" href="http://www.sbs.gob.pe/app/spp/empleadores/comisiones_spp/Paginas/comision_prima.aspx" >
                    http://www.sbs.gob.pe/app/spp/empleadores/comisiones_spp/Paginas/comision_prima.aspx
                    </a>
                </li>
            </ol>
        
        </div>
        <div class="row" >
            <div class="col-sm-12" >
                <button onclick="listarTiposComisionXafp();" class="btn btn-primary" > Refrescar</button>
            </div>
        </div>
        <br>
        <br>
        <div class="row" >    
            <div class="col-sm-12" >
                <table id="tblTipoComisionXAfp"   class="display nowrap" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th >AFP \ Tipo Comsion </th>
                            <th >COMISION FLUJO</th>
                            <th >COMISION MIXTA</th>
                        </tr>
                    </thead>
                    <tbody  >
                        <tr>
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
                <button onclick="actualizarValoresComisionXafp();" class="btn btn-primary" > Actualizar valores</button>
            </div>
        </div>
    </div>
</div>
<br>
<script src="/AppFinanzas/js/paneles/p-tipocomisionxafp.js" type="text/javascript"></script>