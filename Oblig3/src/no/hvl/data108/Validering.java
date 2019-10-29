package no.hvl.data108;

public class Validering {
	
	    public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
	    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
	    public static final String THREE_TIMES = "{8}";
	    public static final String ZERO_OR_MORE_TIMES = "*";

	    /**
	     * 
	     * @param username Brukernavnet som skal valideres
	     * @return Om brukenavnet er gyldig eller ikke
	     * 
	     *         Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
	     *         er bokstaver (små og store) inkl. de norske bokstavene, og tall.
	     *         Brukernavnet kan ikke begynne med et tall.
	     */
	    public static boolean isValidUsername(String username) {

	        if (username == null) {
	            return false;
	        }
	        return username.matches("^" + ANY_LETTER_OR_DIGIT + THREE_TIMES 
	                + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
	    }
	
	
	/*
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
	
	*/
	
}
