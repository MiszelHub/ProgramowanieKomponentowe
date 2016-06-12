package exceptions;

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
