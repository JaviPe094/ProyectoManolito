package proyectoAtos.recursos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import java.util.Base64;
import java.util.Random;

public class EmpleadoUtil {
	
	private static Random random;
	private static SecretKey key;
	
	private static String valoresAdmitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
	
	static {
		
		random = new Random();
		
		/*
		File storedFile = new File("resources");
		
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
			
			getKey(storedFile);

		}
		*/
		
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
			
			return Base64.getEncoder().encodeToString(cipher.doFinal(textInput.getBytes("UTF-8")));
							
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
			
		} catch (UnsupportedEncodingException uee) {
			
			uee.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public static String desencriptaString(String textInput) {
		
		String result = "";
		
		try {
			
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			
            return new String(cipher.doFinal(Base64.getDecoder().decode(textInput)));
							
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
			
			System.out.println("Llave generada!");
			
		}
		
		else {
			
			System.out.println("Llave no generada!");
			
		}
		
	}
	
	private static void getKey(File storedFile) {
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(storedFile);
			
			br = new BufferedReader(fr);
			
			String encodedKey = "";
			
			encodedKey = br.readLine();
			
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
					fr.close();
					
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		
	}

	public static String crearSHA1(String textInput) {
		
		String res = "";
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.reset();
			md.update(textInput.getBytes("UTF-8"), 0, textInput.length());
			
			res = DatatypeConverter.printHexBinary(md.digest());
			
		} catch (NoSuchAlgorithmException nsae) {
			
			nsae.printStackTrace();
			
		} catch (UnsupportedEncodingException usee) {
			
			usee.printStackTrace();
			
		}
		
		return res;
		
	}
	
	
}