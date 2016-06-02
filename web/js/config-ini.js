$().ready(function () {
    
    NProgress.configure({ showSpinner: false });
   

    $("#wrapper a").each(function (i) {
        var link = $(this).attr("data-content");
        if (link !== undefined) {
            $(this).click(function () {
                 NProgress.start();
                $("#contenedor-main").hide(function () {
                    $("#contenedor-main").load(link, {}, function () {
                        
                        $("#contenedor-main").show(500);
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
    $("#contenedor-main").hide(function () {
        $("#contenedor-main").show();

    });
    //  $("#contenedor-main").remove();
}


