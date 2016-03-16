package tydzien3;


public class ksiazkaTelefoniczna {
	private String imie;
	private int numer;
	private String miasto;
	private String ulica;
	private int numerDomu;
	
	
	public ksiazkaTelefoniczna(String imie, int numer,String miasto, String ulica, int numerDomu)
	{
		this.imie = imie;
		this.numer = numer;
		this.miasto = miasto;
		this.ulica = ulica;
	}
	public String getImie()
	{
		return this.imie;
	}
	public int getNumer()
	{
		return this.numer;
	}
	public String getMiasto()
	{
		return this.miasto;
	}
	public String getUlica()
	{
		return this.ulica;
	}
	public int getNrDomu()
	{
		return this.numerDomu;
	}

}
