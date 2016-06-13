function mostrarModalMensaje(mensaje, detalle, tipo)
{
    if (detalle === undefined || detalle === null)
        detalle = "Sin detalle.";
    if (mensaje === undefined || mensaje === null)
        mensaje = "Sin mensaje.";

    $("#modalMensajesIconInformation").hide();
    $("#modalMensajesIconWarning").hide();
    $("#modalMensajesIconError").hide();
    $("#collapseModalMensajeDetalle").collapse("hide");

    if (tipo == "INFORMACION") {
        var titulo = '<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span> Información';
        $("#modalMensajesIconInformation").show();
        $("#modalMensajeTitle").html(titulo);
    } else if (tipo == "ERROR") {
        var titulo = '<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> Ha ocurrido algo inesperado';
        $("#modalMensajesIconError").show();
        $("#modalMensajeTitle").html(titulo);
    } else if (tipo == "ADVERTENCIA") {
        var titulo = '<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> Ten en cuenta lo siguiente';
        $("#modalMensajesIconWarning").show();
        $("#modalMensajeTitle").html(titulo);
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
    mostrarModalMensaje('The following example makes a button toggle the expanding and collapsing content of another element', 'The following example makes a button toggle the expanding and collapsing content of another element', "ADVERTENCIA");
}

function formatoMontoChange(idInput)
{
    $(idInput).change(function () {
        var input = $(this);
        var string = numeral(input.val()).format('0,0.00');
        input.val(string);
    });
}

function cargarCombo(idCombo,url)
{
    
}