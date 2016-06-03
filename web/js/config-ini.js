
function mostrarModalMensaje(mensaje, detalle, tipo)
{
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
    /*
    var i = detalle.search("<body>");
    if (i > -1) {
        var j = detalle.search("</body>");
        detalle = detalle.substring(i, j);
    }
    */
    $("#modalMensajesDetalle").html(detalle);
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
                            mostrarModalMensaje('No se pudo encontrar la seccion "' + seccion + '". Asegurate de tener una conexion activa a internet.',
                                    xhr.responseText,
                                    "ERROR");
                        }
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
    // NProgress.start();
    //mostrarModalMensaje('adadad', '<!DOCTYPE html><html><head><title>Apache Tomcat/8.0.27 - Informe de Error</title><style type="text/css">H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}.line {height: 1px; background-color: #525D76; border: none;}</style> </head><body><h1>Estado HTTP 404 - /AppFinanzas/paginas/paneles/p-miperfill.jsp</h1><div class="line"></div><p><b>type</b> Informe de estado</p><p><b>mensaje</b> <u>/AppFinanzas/paginas/paneles/p-miperfill.jsp</u></p><p><b>descripción</b> <u>El recurso requerido no está disponible.</u></p><hr class="line"><h3>Apache Tomcat/8.0.27</h3></body></html>',"INFORMACION");
    mostrarModalMensaje('The following example makes a button toggle the expanding and collapsing content of another element', 'The following example makes a button toggle the expanding and collapsing content of another element',"ERROR");
    // NProgress.done();
}


