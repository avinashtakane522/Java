import java.util.Base64;

class Validate{
	public static void main(String args[]){
		String psw = SecurityCheck.encryptPassword("123");
		System.out.println("password :"+psw);
		psw = SecurityCheck.encryptPassword("123");
		System.out.println("password :"+psw);
	}
}

public class SecurityCheck {
	// Method to encrypt password
   public static String encryptPassword(String password) {
	   // Convert password to bytes
	   byte[] passwordBytes = password.getBytes();
	   
	   // Encode bytes to Base64
	   String encodedPassword = Base64.getEncoder().encodeToString(passwordBytes);
	   
	   return encodedPassword;
   }}