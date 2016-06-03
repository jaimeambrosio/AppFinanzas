
function mostrarModalMensaje(mensaje, tipo)
{
    $("#modalMensajesIconInformation").hide();
    $("#modalMensajesIconWarning").hide();
    if (tipo == "INFORMACION") {
        var titulo = '<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Información';
        $("#modalMensajesIconInformation").show();
        $("#modalMensajeTitle").html(titulo);
    } else if (tipo == "ERROR") {
        var titulo = '<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> Ha ocurrido algo inesperado';
        $("#modalMensajesIconWarning").show();
        $("#modalMensajeTitle").html(titulo);
    } else {
        
    }
    $("#modalMensajesCuerpo").html(mensaje);
    $('#modalMensajes').modal('show');
}

$().ready(function () {

    NProgress.configure({showSpinner: false});
    $("#wrapper a").each(function (i) {
        var link = $(this).attr("data-content");
        if (link !== undefined) {
            var seccion = $(this).html();
            $(this).click(function () {
                NProgress.start();
                $("#contenedor-main").hide(function () {
                    $("#contenedor-main").load(link, {}, function (response, status, xhr) {
                        if (status != "error") {
                            $("#contenedor-main").show(500);
                        } else {
                            mostrarModalMensaje('No se pudo encontrar la seccion "' + seccion + '".\n\
                                                 Asegurate de tener una conexion activa a internet.', "ERROR");
                        }
                        console.log(xhr);
                        NProgress.done();
                    });

                });
            });
        }
    });
    $("#miCuenta").click();
    $("#pInicio").click();

});
function prueba() {
    mostrarModalMensaje("asdasdasd <br> ", "INFORMACION");
}


