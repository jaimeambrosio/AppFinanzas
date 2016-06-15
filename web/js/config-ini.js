
function configureMenu() {

    $("#divMenu ul").removeClass("in");
    $("#divMenu a").each(function (i) {
        var enlace = $(this);
        var link = enlace.attr("data-link");
        if (link !== undefined && link != "") {
            var seccion = enlace.html();
            var nombreFuncion = enlace.attr("data-constructor");
            var pass = enlace.attr("data-pass");
            $(this).click(function () {
                NProgress.start();

                if (pass != "1") {//si no requiere pass
                    $("#contenedor-main").hide(function () {
                        $("#contenedor-main").load(link, {}, function (response, status, xhr) {
                            if (status != "error") {
                                if (nombreFuncion !== undefined)
                                    eval(nombreFuncion);
                                $("#divMenu a").removeClass("active");
                                enlace.addClass("active");
                                $("#tituloPanel").html(seccion);
                                $("#contenedor-main").show(500);
                            } else {
                                mostrarModalMensaje('No se pudo encontrar la seccion "' + seccion + '". Asegurate de tener una conexion activa a internet.',
                                        xhr.responseText,
                                        "ERROR");
                            }
                            NProgress.done();
                        });
                    });
                } else
                {
                    $("#modalPedidoPass").modal('show');

                    $("#txtContrasenia").val("");
                    $("#data-link").val(link);
                    $("#data-constructor").val(nombreFuncion);
                    $("#seccion-titulo").val(seccion);

                    NProgress.done();
                }
            });
        }
    });
    $("#idFormContrasenia").validate();
    $("#idFormContrasenia").ajaxForm({
        url: "../usuarioServlet?accion=VALIDAPASS",
        type: "post",
        beforeSend: function (jqXHR, settings) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            $("#modalPedidoPass").modal('hide');
            if (data.msj.hayMensaje == true) {
                mostrarModalMensaje(data.msj.mensaje, data.msj.detalle, data.msj.tipo);
                NProgress.done();
            } else
            {
                var nombreFuncion = $("#data-constructor").val();
                var link = $("#data-link").val();
                var seccion = $("#seccion-titulo").val();

                $("#contenedor-main").hide(function () {
                    $("#contenedor-main").load(link, {}, function (response, status, xhr) {
                        if (status != "error") {
                            if (nombreFuncion !== undefined && nombreFuncion != "")
                                eval(nombreFuncion);
                            $("#divMenu a").removeClass("active");
                            // enlace.addClass("active");
                            $("#tituloPanel").html(seccion);
                            $("#contenedor-main").show(500);
                        } else {
                            mostrarModalMensaje('No se pudo encontrar la seccion "' + seccion + '". Asegurate de tener una conexion activa a internet.',
                                    xhr.responseText,
                                    "ERROR");
                        }
                        NProgress.done();
                    });
                });

            }
        },
        error: function (e) {
            $("#modalPedidoPass").modal('hide');
            mostrarModalMensaje('No se pudo establecer la comprobación, probablemente tengas un problema con tu conexion a internet.',
                    e.statusText,
                    "ERROR");
            NProgress.done();
        }
    });

}
//cuando se carga la pagina
$().ready(function () {

    NProgress.configure({showSpinner: false});
    configureMenu();
    $("#pInicio").click();
});


