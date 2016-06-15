
function p_miperfil()
{
    $('#txtFechaNacimiento').datepicker({
        language: "es",
        endDate: "hoy",
        autoclose: true
    });
    $("#idFormMiPerfil").validate();
    $("#idFormMiPerfil *").attr("disabled", true);
    $("#idFormMiPerfil #habilitarModificacion").attr("disabled", false);

    $("#idFormMiPerfil #habilitarModificacion").click(function () {
        $("#idFormMiPerfil *").attr("disabled", false);
        $("#idFormMiPerfil #btnGuardarCambios").show('fast');
        $(this).hide('fast');
        //$("#idFormMiPerfil #tipoUsuario").attr("disabled", true);
    });

    $('#idFormMiPerfil').ajaxForm({
        url: "../usuarioServlet?accion=MODIFICAR",
        type: "post",
        beforeSend: function (jqXHR, settings) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            if (data.msj.hayMensaje == true) {
                mostrarModalMensaje(data.msj.mensaje, data.msj.detalle, data.msj.tipo);
                $("#pMiPerfil").click();
            }
            NProgress.done();
        },
        error: function (e) {
            mostrarModalMensaje('No se pudo enviar los datos, probablemente tengas un problema con tu conexion a internet.',
                    e.statusText,
                    "ERROR");
            NProgress.done();
        }
    });
    //  alert("asdas");
}
