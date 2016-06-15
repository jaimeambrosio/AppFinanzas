
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
                        });
                    });
                } else
                {
                    $("#modalPedidoPass").modal('show');
                    $("#data-link").val(link);
                    $("#data-constructor").val(nombreFuncion);
                }
                NProgress.done();



            });
        }
    });

}
//cuando se carga la pagina
$().ready(function () {

    NProgress.configure({showSpinner: false});
    configureMenu();
    $("#pInicio").click();
});


