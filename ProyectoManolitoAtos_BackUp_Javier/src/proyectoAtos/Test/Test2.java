package proyectoAtos.Test;

import proyectoAtos.recursos.EmpleadoUtil;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String enclaro = EmpleadoUtil.generatePass(10);
		
		System.out.println(EmpleadoUtil.crearSHA1(enclaro));
		System.out.println(EmpleadoUtil.crearSHA1(enclaro));

	}

}
