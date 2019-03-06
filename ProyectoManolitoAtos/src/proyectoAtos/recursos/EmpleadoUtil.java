package proyectoAtos.recursos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;
import java.util.Random;

public class EmpleadoUtil {
	
	private static Random random;
	private static SecretKey key;
	
	private static String valoresAdmitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
	
	static {
		
		random = new Random();
		
		File storedFile = new File("../resources.txt");
		
		if (!storedFile.exists()) {
			
			try {
				generateKey(storedFile);
				
			} catch (IOException ioe) {
				
				ioe.printStackTrace();
				
			} catch (NoSuchAlgorithmException nsae) {
				
				nsae.printStackTrace();
			}
			
		}
		
		else {
			
			try {
				
				generateKey(storedFile);
				
			} catch (NoSuchAlgorithmException nsae) {
				
				nsae.printStackTrace();
				
			} catch (IOException ioe) {
				
				ioe.printStackTrace();
				
			}
			
		}
		
	}
	
	public static String generatePass(int length) {
		
		String res = "";
		
		for (int i = 0; i < length; ++i) {
			
			//res += Integer.toString(random.nextInt((122 - 48) + 1) + 48);
			res += valoresAdmitidos.charAt(random.nextInt(valoresAdmitidos.length()));
			
		}
		
		return res;
		
	}
	
	public static String encriptaString(String textInput) {
		
		String result = "";
		
		try {
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encriptado = cipher.doFinal(textInput.getBytes());

			for (byte b : encriptado)
				result += Integer.toHexString(0xFF & b);
				
		} catch (NoSuchPaddingException nspe) {
			
			nspe.printStackTrace();
			
		} catch (NoSuchAlgorithmException nsae) {
			
			nsae.printStackTrace();
			
		} catch (InvalidKeyException ike) {
			
			ike.printStackTrace();
			
		} catch (BadPaddingException bpe) {
			
			bpe.printStackTrace();
			
		} catch (IllegalBlockSizeException ibsq) {
			
			ibsq.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public static String desencriptaString(String textInput) {
		
		String result = "";
		
		try {
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encriptado = cipher.doFinal(textInput.getBytes());

			for (byte b : encriptado)
				result += Integer.toHexString(0xFF & b);
				
		} catch (NoSuchPaddingException nspe) {
			
			nspe.printStackTrace();
			
		} catch (NoSuchAlgorithmException nsae) {
			
			nsae.printStackTrace();
			
		} catch (InvalidKeyException ike) {
			
			ike.printStackTrace();
			
		} catch (BadPaddingException bpe) {
			
			bpe.printStackTrace();
			
		} catch (IllegalBlockSizeException ibsq) {
			
			ibsq.printStackTrace();
			
		}
		
		return result;
		
	}
	
	private static void generateKey(File storeFile)
		throws NoSuchAlgorithmException, IOException {
		
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256);
		key = keyGen.generateKey();
		
		if (key != null) {
		
			FileWriter fileWriter = new FileWriter(storeFile);
		
			BufferedWriter bw = new BufferedWriter(fileWriter);
		
			bw.write(Base64.getEncoder().encodeToString(key.getEncoded()));
			
		}
		
	}
	
	private void getKey(File storedFile) {
		
		BufferedReader br = null;
		
		try {
			
			FileReader fr = new FileReader(storedFile);
			
			br = new BufferedReader(fr);
			
			String encodedKey = br.readLine();
			
			byte[] keyBytes = Base64.getDecoder().decode(encodedKey);
			
			key = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
			
		} catch (FileNotFoundException fnfe) {
			
			fnfe.printStackTrace();
			
		} catch (IOException ioe) {
		
			ioe.printStackTrace();
		
		} finally {
			
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		
	}


}
