
function grabar() {
    var rut = $("#txtRut").val();
    var rutDv = $("#txtRutDv").val();
    var nombres = document.querySelector("#txtNombres").value;	   
    var apellidos = $("#txtApellidos").val();
    var correo = $("#txtCorreo").val();
    var fechaNacimiento = $("#datepicker").val();
    var direccion = $("#txtDireccion").val();
    


    if (rut == "") {
        alert("Debe ingresar un rut");
        return false;
    }
    
    /*var Fn = {
	// Valida el rut con su cadena completa "XXXXXXXX-X"
	validaRut : function (rutCompleto) {
		if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test( rutCompleto ))
			return false;
		var tmp 	= rutCompleto.split('-');
		var digv	= tmp[1]; 
		var rut 	= tmp[0];
		if ( digv == 'K' ) digv = 'k' ;
		return (Fn.dv(rut) == digv );
	},
	dv : function(T){
		var M=0,S=1;
		for(;T;T=Math.floor(T/10))
			S=(S+T%10*(9-M++%6))%11;
		return S?S-1:'k';
	}


// Uso de la función
alert( Fn.validaRut('11111111-1') ? 'Valido' : 'inválido');
    }*/
    
    if (rutDv == "") {
        alert("Debe ingresar un digito verificador");
        return false;
    }
    if (nombres == "") {
       alert("Debe ingresar un nombre");
       return false;
    }
   	if(nombres != ""){

		var caracteres = nombres.length;
                var expresion =/^[a-z\s]+$/i;
		//var expresion = /^[a-zA-Z0-9]*$/;

		if(caracteres < 3 ){

			
                        alert('Nombre debe tener 3 o mas caracteres');
			return false;
		}
                if(caracteres > 70 ){

			
                        alert('Nombre debe ser menor o igual a 70 caracteres');
			return false;
		}

		if(!expresion.test(nombres)){

			//document.querySelector("label[for='usuarioRegistro']").innerHTML += "<br>No escriba caracteres especiales.";
                        alert('No esta permitido ingresar caracteres especiales ni numeros en nombres');
			return false;

		}

	//	if(nombres){

		//	document.querySelector("label[for='usuarioRegistro'] span").innerHTML = "<p>Este usuario ya existe en la base de datos</p>";

	//		return false;
	//	}

	}

    //if (!$.isNumeric(anio)) {
     //   alert("Año Invalido");
      //  return false;
   // }

    if (apellidos == "") {
        alert("Debe ingresar un apellido");
        return false;
    }
    
    if(apellidos != ""){

		var caracteres = apellidos.length;
                                //Expresion que permite el ingreso de espacios y no permite numeros ni caracteres especiales 
		var expresion = /^[a-z\s]+$/i;

		if(caracteres < 3 ){

			
                        alert('Apellidos deben tener 3 o mas caracteres');
			return false;
		}
                if(caracteres > 70 ){

			
                        alert('Apellidos deben ser menor o igual a 70 caracteres');
			return false;
		}

		if(!expresion.test(apellidos)){

			//document.querySelector("label[for='usuarioRegistro']").innerHTML += "<br>No escriba caracteres especiales.";
                        alert('No esta permitido ingresar caracteres especiales ni numeros en apellidos');
			return false;

		}

	//	if(apellidos){

		//	document.querySelector("label[for='usuarioRegistro'] span").innerHTML = "<p>Este usuario ya existe en la base de datos</p>";

		//	return false;
	//	}

	}
    
    if (correo == "") {
        alert("Debe ingresar un correo");
        return false;
    }
    
    if(correo != ""){

		var expresion = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;

		if(!expresion.test(correo)){

			alert('Formato de correo incorrecto debe ser ej : jperez@mail.com');

			return false;

		}

	//	if(emailExistente){

	//		document.querySelector("label[for='emailRegistro'] span").innerHTML = "<p>Este email ya existe en la base de datos</p>";

	//		return false;
	//	}

	}
    //if (fechaNacimiento == "") {
     //   alert("Debe ingresar una fecha de nacimiento");
      //  return false;
   // }
   

   
   
    if (direccion == "") {
        alert("Debe ingresar una direccion");
        return false;
    }
    
    	if(direccion != ""){

		var caracteres = direccion.length;
		//El \s permite espacios en las expresiones regulares
                //Valida letras, numeros y espacios , no permite caracteres invalidos
                var expresion = /^([a-zA-Z0-9\s]+)$/;

		if(caracteres < 7 ){

			
                        alert('Nombre debe tener entre 7 y 40  caracteres');
			return false;
		}
                if(caracteres > 40 ){

			
                        alert('Direccion debe ser menor o igual a 40 caracteres');
			return false;
		}

		if(!expresion.test(direccion)){

			//document.querySelector("label[for='usuarioRegistro']").innerHTML += "<br>No escriba caracteres especiales.";
                        alert('No esta permitido ingresar caracteres especiales en direccion');
			return false;

		}

	//	if(nombres){

		//	document.querySelector("label[for='usuarioRegistro'] span").innerHTML = "<p>Este usuario ya existe en la base de datos</p>";

	//		return false;
	//	}

	}

    var data = "accion=validar&rut=" + rut + "&rutDv=" + rutDv +
            "&nombres=" + nombres + "&apellidos=" + apellidos + "&correo=" + correo +
            "&fechaNacimiento=" + fechaNacimiento + "&direccion=" + direccion;

    $.ajax({
        type: "POST",
        url: "persona",
        data: data,
        success: function (result) {
            var json = JSON.parse(result);

            if (json.respuesta == 0) {

               var data = "accion=grabar&rut=" + rut + "&rutDv=" + rutDv +
            "&nombres=" + nombres + "&apellidos=" + apellidos + "&correo=" + correo +
            "&fechaNacimiento=" + fechaNacimiento + "&direccion=" + direccion;
                $.ajax({
                    type: "POST",
                    url: "persona",
                    data: data,
                    success: function (result) {
                        var json = JSON.parse(result);

                        if (json.respuesta == 0) {
                            alert("Persona almacenada correctamente");
                        } else {
                            alert("Ha ocurrido un error");
                        }
                    }
                });
            } else {
                alert(json.mensaje);

            }


        }
    });

}

function eliminar() {
    var rut = $("#txtRut").val();

    var data = "accion=eliminar&rut=" + rut;

    $.ajax({
        type: "POST",
        url: "persona",
        data: data,
        success: function (result) {
            var json = JSON.parse(result);

            if (json.respuesta == 0) {
                alert("Persona eliminada");
            } else {
                alert("No se ha podido eliminar persona");
            }
        }
    });


}

