function mostrarModalMensaje(mensaje, detalle, tipo)
{
    if (detalle === undefined || detalle === null)
        detalle = "Sin detalle.";
    if (mensaje === undefined || mensaje === null)
        mensaje = "Sin mensaje.";

    $("#modalMensajesIconInformation").hide();
    $("#modalMensajesIconWarning").hide();
    $("#collapseModalMensajeDetalle").collapse("hide");

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

    var i = detalle.indexOf("<body>");
    if (i > -1) {
        var j = detalle.indexOf("</body>");
        detalle = detalle.substring(i, j);
    }
    $("#modalMensajesDetalle").html(detalle);
    $('#modalMensajes').modal('show');
}

function prueba() {
    mostrarModalMensaje('The following example makes a button toggle the expanding and collapsing content of another element', 'The following example makes a button toggle the expanding and collapsing content of another element', "ERROR");

}

function formatoMontoChange(idInput)
{
    $(idInput).change(function () {
       var input = $(this);
       var string = numeral(input.val()).format('0,0.00');
       input.val(string);
    });
}