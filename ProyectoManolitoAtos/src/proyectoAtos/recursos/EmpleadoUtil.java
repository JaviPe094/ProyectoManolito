package proyectoAtos.recursos;

import javax.crypto.KeyGenerator;
import java.util.Random;

public class EmpleadoUtil {
	
	private static Random random;
	
	static {
		
		random = new Random();
		
	}
	
	public static String generatePass() {
		
		String res = "";
		
		for (int i = 0; i < 10; ++i) {
			
			res += Character.toChars(random.nextInt((255 - 1) + 1) + 255); 
			
		}
		
		return res;
		
	}

}
