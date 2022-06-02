$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var idpro = $(this).parent().find("#idpro").val();
        swal({
            title: "Esta seguro de eliminar?",
            text: "Once deleted, you will not be able to recover this imaginary file!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        eliminar(idpro);
                        swal("Poof! Your imaginary file has been deleted!", {
                            icon: "success",
                        }).then((willDelete) => {
                            if (willDelete) {
                                parent.location.href = "controlador?accion=Carrito";
                            }
                        });
                    } else {
                        swal("Registro no eliminado!");
                    }
                });
    });
    function eliminar(idpro) {
        var url = "controlador?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idpro=" + idpro,
            success: function (data, textStatus, jqXHR) {

            }
        })

    }
});


