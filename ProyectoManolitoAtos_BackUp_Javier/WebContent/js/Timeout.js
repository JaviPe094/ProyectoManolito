/**
 * 
 */
var timer;
function LogOut(){
	//window.location.replace("formulario_login.jsp");
	var http = new XMLHttpRequest();
	var url = "Controlador"; //URL del servidor
	var params = "instruccion=logout"; //PARAMETROS
	//Abres la conexion  la URL
	http.open("POST", url, true);
	 
	//Envias el header requerido para enviar parametros via POST
	http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	http.setRequestHeader("Content-length", params.length);
	http.setRequestHeader("Connection", "close");
	 
	http.onreadystatechange = function() {//Llama a la funcion cuando el estado cambia
		if(http.readyState == 4 && http.status == 200) {
			alert(http.responseText);
		}
	}
	http.send(params);
}
function iniciarTimeout(seg){
	timer=setTimeout(LogOut,1000*seg);
}
function reiniciarTimeout(seg){
	clearTimeout(timer);
	timer=setTimeout(LogOut,1000*seg);
}