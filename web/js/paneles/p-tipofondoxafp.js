/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var tblTipoFondoXAfp;
function p_tipofondoxafp()
{
    tblTipoFondoXAfp = $('#tblTipoFondoXAfp').DataTable({});
    //console.log(tblTipoFondoXAfp);
    listarTiposFondoXAFP();
}

function listarTiposFondoXAFP()
{
    $.ajax({
        url: "../afpServlet?accion=TBRENTABILIDAD",
        type: 'POST',
        data: {
        },
        beforeSend: function (xhr) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            if (data.msj.hayMensaje != true) {
                // tblTipoFondoXAfp.fnClearTable();
                tblTipoFondoXAfp.destroy();
                $("#tblTipoFondoXAfp").html(data.tbl);
                tblTipoFondoXAfp = $('#tblTipoFondoXAfp').DataTable({
                });
                formatoMontoChange("#tblTipoFondoXAfp input");
                // $("#tblTipoFondoXAfp thead").empty();
            } else
            {
                mostrarModalMensaje(data.msj.mensaje, data.msj.detalle, data.msj.tipo);
            }
            NProgress.done();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mostrarModalMensaje('No se pudo invocar al servidor, probablemente tengas un problema con tu conexion a internet.',
                    jqXHR.responseText,
                    "ERROR");
            NProgress.done();
        }
    });
}

function actualizarRentabilidades()
{
    var datos = new Array();
    $("#tblTipoFondoXAfp tbody input").each(function (i) {
        var input = $(this);
        var afp = input.attr("afp");
        var fondo = input.attr("fondo");
        var valor = input.val();
        datos[i] = new Object();
        datos[i].afp = afp;
        datos[i].fondo = fondo;
        datos[i].valor = valor;
    });

    console.log(JSON.stringify(datos));
    $.ajax({
        url: "../afpServlet?accion=ACTRENTSUG",
        type: 'POST',
        data: {
        },
        beforeSend: function (xhr) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            if (data.msj.hayMensaje != true) {
                
            } else
            {
                mostrarModalMensaje(data.msj.mensaje, data.msj.detalle, data.msj.tipo);
                
            }
            NProgress.done();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            mostrarModalMensaje('No se pudo invocar al servidor, probablemente tengas un problema con tu conexion a internet.',
                    jqXHR.responseText,
                    "ERROR");
            NProgress.done();
        }
    });

}
