package exceptions;

public class DateFormatException extends Exception{
	private String message;
	
	public DateFormatException(){
		this.message = "Uzyj nastepujacego formatu daty yyyy-mm-dd";
	}

	
	public String getMessage(){
		return this.message;
	}
}
