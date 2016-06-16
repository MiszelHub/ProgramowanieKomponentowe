package exceptions;
/**
 * This Class represents custom exception.
 * This Exception is thrown when user defines wrong data format
 * usually it's handled by popping JOptionPane message
 */
public class DateFormatException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public DateFormatException(){
		this.message = "Uzyj nastepujacego formatu daty yyyy-mm-dd";
	}


	public String getMessage(){
		return this.message;
	}
}
