
function configureMenu() {
    $("#wrapper a").each(function (i) {
        var link = $(this).attr("data-content");
        if (link !== undefined) {
            var seccion = $(this).html();
            var nombreFuncion = $(this).attr("data-constructor");
            $(this).click(function () {
                NProgress.start();
                $("#contenedor-main").hide(function () {
                    $("#contenedor-main").load(link, {}, function (response, status, xhr) {
                        if (status != "error") {
                            if (nombreFuncion !== undefined)
                                eval(nombreFuncion);
                            $("#contenedor-main").show(500);
                        } else {
                            mostrarModalMensaje('No se pudo encontrar la seccion "' + seccion + '". Asegurate de tener una conexion activa a internet.',
                                    xhr.responseText,
                                    "ERROR");
                        }
                        NProgress.done();
                        //console.log(xhr);
                    });

                });
            });
        }
    });

}
//cuando se carga la pagina
$().ready(function () {

    NProgress.configure({showSpinner: false});
    configureMenu();  
 //   $("#miCuenta").click(); $("#miCuenta").click();
    $("#pInicio").click();
});


