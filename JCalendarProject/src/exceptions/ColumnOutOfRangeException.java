package exceptions;


/**
 * This Class represents custom exception. 
 * This Exception is thrown when user exceeds number of characters in text box
 * usually it's handled by popping JOptionPane message
 */
public class ColumnOutOfRangeException extends Exception{


	private String message;
	private static final long serialVersionUID = 1L;
	public ColumnOutOfRangeException()
	{
		this.message = "Pole moze miec tylko 45 znakow";
	}

	public String getMessage()
	{
		return this.message;
	}

}
