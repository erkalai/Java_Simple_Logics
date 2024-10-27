package New_Package;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptData {
	
	
	public static String EncryptData(String data, String key)throws Exception{
	    
	    Cipher cipher = Cipher.getInstance("AES");
	    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),"AES");
	    cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
	    byte[] encrybtByte = cipher.doFinal(data.getBytes());
	    String finalData= Base64.getEncoder().encodeToString(encrybtByte);
	    System.out.println("Encrypt Data : " + finalData);
	    return finalData;
	}


	public static void DecryptData(String encrybtData, String key)throws Exception{
	    
	    
	    Cipher cipher = Cipher.getInstance("AES");
	    SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),"AES");
	    cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
	    byte[] decodeByte = Base64.getDecoder().decode(encrybtData);
	    byte[] decryptByte = cipher.doFinal(decodeByte);
	    System.out.println("Decrypt Data : " + new String(decryptByte));

	}

	public static void main(String[] args) throws Exception {
		
		String data = "Welcome Mr.K";
		String key = "1234567812345678";
		
		DecryptData(EncryptData(data,key),key);

	}
}