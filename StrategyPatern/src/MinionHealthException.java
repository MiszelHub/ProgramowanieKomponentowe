
public class MinionHealthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1219993199315483620L;
	private String message;
	
	public MinionHealthException() {
		super();
		this.message = "Your Minion doesn't have enough health";
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
