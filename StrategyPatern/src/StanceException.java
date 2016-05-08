
public class StanceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7932093196150214930L;
	private String message;
	
	public StanceException() {
		super();
		this.message = "You are already using this Stance";
	}

	public String getMessage() {
		return message;
	}

}
