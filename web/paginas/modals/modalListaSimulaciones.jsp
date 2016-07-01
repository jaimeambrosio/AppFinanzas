<%-- 
    Document   : modalEdicionSimulacion
    Created on : 28/06/2016, 08:56:28 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="java.util.List"%>
<%@page import="fina.simulacion.entity.Simulacion"%>
<%@page import="fina.simulacion.dao.SimulacionDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SimulacionDao simulacionDao = new SimulacionDao();
    List<Simulacion> listSim = simulacionDao.listar();
%>
<div class="modal fade" data-backdrop="false" id="modalListaSimulaciones" tabindex="-1" role="dialog" >
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalListaSimulacionesTitle"  >
                    <span class="glyphicon glyphicon-list"></span>
                    Lista de simulaciónes
                </h4>
            </div>
            <div class="modal-body">
                <table id="tblListaSimulaciones"   class="display nowrap" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th >Alias</th>
                            <th >Fecha creación</th>
                            <th >...</th>
                        </tr>
                    </thead>
                    <tbody  >
                        <% for (Simulacion s : listSim) {%>
                        <tr>
                            <td><%=s.getAlias()%></td>
                            <td><%=s.getFechaCreacion()%></td>
                            <td>...</td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>