package proyectoAtos.recursos;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.util.Random;

public class EmpleadoUtil {
	
	private static Random random;
	private static Key key;
	
	private static String valoresAdmitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
	
	static {
		
		random = new Random();
		//key = new 
		
	}
	
	public static String generatePass(int length) {
		
		String res = "";
		
		for (int i = 0; i < length; ++i) {
			
			//res += Integer.toString(random.nextInt((122 - 48) + 1) + 48);
			res += valoresAdmitidos.charAt(random.nextInt(valoresAdmitidos.length()));
			
		}
		
		return res;
		
	}
	
	public static String encriptaString(String input) {
		
		
		
	}

}
