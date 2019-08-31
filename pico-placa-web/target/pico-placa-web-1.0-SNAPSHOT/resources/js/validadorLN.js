function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = ["37", "8", "9", "46", "39", "0"];

    tecla_especial = false
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) == -1) {
        if (!tecla_especial) {
            return false;
        }
    }
}
function soloNumeros(e)
{
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 8) || (keynum == 37) || (keynum == 0))
        return true;
    return /\d/.test(String.fromCharCode(keynum));
}

function soloNumerosDecimal(e)
{
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 8) || (keynum == 37) || (keynum == 0) || (keynum == 44))
        return true;
    return /\d/.test(String.fromCharCode(keynum));
}



function campovacio() {

    if (document.getElementById("frmEncomienda:nombresPersona").value == "") {
        alert('Campos incompletos');
        document.frmEncomienda.nombresPersona.focus();
        return false;
    }


    alert("Muchas gracias por enviar el formulario");

    return true;
}




