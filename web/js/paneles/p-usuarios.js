var tblPanelUsuarios;
function p_usuarios()
{
    tblPanelUsuarios = $('#tblPanelUsuarios').dataTable({});

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
}

function editarUsuarioById(id)
{
    $("#modalEdicionUsuario").modal('show');
    $("#idFormModalEdicionUsuario").trigger('reset');
    $("#idFormModalEdicionUsuario .active").removeClass("active");
    
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
            if (data.msj.hayMensaje != true) {
                
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