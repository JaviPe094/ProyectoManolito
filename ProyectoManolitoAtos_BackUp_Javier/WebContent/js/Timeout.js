/**
 * 
 */

var timer;
	function LogOut(){
		window.location.replace("formulario_login.jsp");
	}
	function iniciarTimeout(seg){
		timer=setTimeout(LogOut,1000*seg);
	}
	
	function reiniciarTimeout(seg){
		clearTimeout(timer);
		timer=setTimeout(LogOut,1000*seg);
	}