var tblPanelUsuarios;
function p_usuarios()
{
    tblPanelUsuarios = $('#tblPanelUsuarios').dataTable({});
    $("#idFormModalEdicionUsuario").validate();
    $('#txtFechaNacimiento').datepicker({
        language: "es",
        endDate: "hoy",
        autoclose: true

    });

    $('#idFormModalEdicionUsuario').ajaxForm({
        url: "../usuarioServlet?accion=MODIFICARTHIS",
        type: "post",
        beforeSend: function (jqXHR, settings) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            if (data.msj.hayMensaje == true) {
                mostrarModalMensaje(data.msj.mensaje, data.msj.detalle, data.msj.tipo);
                $("#btnBuscarUsuariosEdicion").click();
                $("#modalEdicionUsuario").modal('hide');
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

}

function buscarUsuarios()
{
    $.ajax({
        url: "../usuarioServlet?accion=LISTARTB",
        type: 'POST',
        data: {
        },
        beforeSend: function (xhr) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            console.log(data);
            if (data.msj.hayMensaje != true) {
                tblPanelUsuarios.fnClearTable();
                tblPanelUsuarios.fnDestroy();
                $("#tblPanelUsuarios tbody").html(data.tbody);
                tblPanelUsuarios = $('#tblPanelUsuarios').dataTable({});
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

function nuevoUsuario()
{
    $("#modalEdicionUsuario").modal('show');
    $("#idFormModalEdicionUsuario").trigger('reset');
    $("#idFormModalEdicionUsuario .active").removeClass("active");
    $("#txtGuardarUsuario").val("true");
    $("#lblTextNombreFoto").text("Foto ");
    $('#txtFechaNacimiento').datepicker('destroy');
    $('#txtFechaNacimiento').datepicker({
        language: "es",
        endDate: "hoy",
        autoclose: true

    });

}

function editarUsuarioById(id)
{
    $("#modalEdicionUsuario").modal('show');
    $("#idFormModalEdicionUsuario").trigger('reset');
    $("#idFormModalEdicionUsuario .active").removeClass("active");
    $("#txtGuardarUsuario").val("false");
    $.ajax({
        url: "../usuarioServlet?accion=OBTENER",
        type: 'POST',
        data: {
            idUsuario: id
        },
        beforeSend: function (xhr) {
            NProgress.start();
        },
        success: function (data) {
            data = JSON.parse(data);
            console.log(data);
            if (data.msj.hayMensaje != true) {
                $("#txtNombres").val(data.usu.nombres);
                $("#txtApellidos").val(data.usu.apellidos);
                $("#txtFechaNacimiento").val(data.usu.fechaNacimineto);
                $("#txtUsuario").val(data.usu.username);
                $("#txtContrasenia").val(data.usu.nombres);
                $("#lblTextNombreFoto").text("Foto (Actualmente " + (data.usu.nombreFoto == undefined ? "sin foto" : data.usu.nombreFoto) + " )");
                $("#tipoUsuario").val(data.usu.idTipoUsuario);
                $("#txtDNI").val(data.usu.dni);
                $("#txtEstado").val(data.usu.eliminado.toString());
                $("#txtIdUsuario").val(data.usu.idUsuario);

                if (data.usu.sexo == true) {
                    $("#lblMasculino").addClass("active");
                    $("#lblMasculino").children().attr("checked", "checked");
                } else
                {
                    $("#lblFemenino").addClass("active");
                    $("#lblFemenino").children().attr("checked", "checked");
                }
                $('#txtFechaNacimiento').datepicker('destroy');
                $('#txtFechaNacimiento').datepicker({
                    language: "es",
                    endDate: "hoy",
                    autoclose: true

                });

                $("#modalEdicionUsuario").modal('show');
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