var tblTipoComisionXAfp ;
function p_tipocomisionxafp()
{
     tblTipoComisionXAfp = $('#tblTipoComisionXAfp').DataTable({
        
     });
    //console.log(tblTipoFondoXAfp);
    listarTiposComisionXafp();
}

function listarTiposComisionXafp()
{
    $.ajax({
        url: "../afpServlet?accion=TBCOMISIONES",
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
                tblTipoComisionXAfp.destroy();
                $("#tblTipoComisionXAfp").html(data.tbl);
                tblTipoComisionXAfp = $('#tblTipoComisionXAfp').DataTable({
             
                });
                formatoMontoChange("#tblTipoComisionXAfp input");
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

function actualizarValoresComisionXafp()
{
    var array = new Array();

    $("#tblTipoComisionXAfp .input-group").each(function(i,ele){
         array[i]=new  Object();
         array[i].afp = $("input[is=saldo]",ele).attr("afp");
         array[i].comision = $("input[is=saldo]",ele).attr("comision");
         array[i].comisionSaldo = $("input[is=saldo]",ele).val();
         array[i].comisionFlujo = $("input[is=flujo]",ele).val();
    });
    
    $.ajax({
        url: "../afpServlet?accion=ACTCOMXAFP",
        type: 'POST',
        data: {
            valores: JSON.stringify(array)
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
                listarTiposComisionXafp();
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