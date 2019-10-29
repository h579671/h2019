package no.hvl.dat108;

public class Validering {
	public static boolean isValidUsername(String username){
		if(username == null || username == "") {
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean isValidPassword(String password) {
		if(password.equals("passord")){
			return true;			
		}else {
			return false;
		}
	}
}
