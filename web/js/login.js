$().ready(function () {


    $("#idFormLogin").validate();
    $('#idFormLogin').ajaxForm({
        url: "usuarioServlet?accion=LOGIN",
        type: "post",
        success: function (data) {
            console.log(data);
        },
        error: function (e) {
             mostrarModalMensaje('No se pudo establecer la sesion, probablemente tengas un problema con tu conexion a internet.',
                                    e.statusText,
                                    "ERROR");
        }
    });
});