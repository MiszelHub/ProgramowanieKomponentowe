package tydzien3;


public class ksiazkaTelefoniczna {
	private String imie;
	private String nazwisko;
	private int numer;
	private String miasto;
	private String ulica;
	private int numerDomu;
	
	
	public ksiazkaTelefoniczna(String imie, String nazwisko, int numer,String miasto, String ulica, int numerDomu)
	{
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.numer = numer;
		this.miasto = miasto;
		this.ulica = ulica;
		this.numerDomu = numerDomu;
	}
	public String toString()
	{
		return " " + this.imie +" "+ this.nazwisko +" "+ this.numer +" "+ this.miasto +" "+ this.ulica +" "+ this.numerDomu +" ";
	}
	public String getImie()
	{
		return this.imie;
	}
	public String getNazwisko()
	{
		return this.nazwisko;
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
	
	public void putImie(String imie)
	{
		this.imie = imie;
	}
	public void putNazwisko(String nazwisko)
	{
		this.nazwisko = nazwisko;
		
	}
	public void putNumer(int numer)
	{
		this.numer = numer;
	}
	public void putMiasto(String miasto)
	{
		this.miasto = miasto;
	}
	public void putUlica(String ulica)
	{
		this.ulica = ulica;
	}
	public void putNrDomu(int nrDomu)
	{
		this.numerDomu = nrDomu;
	}
	

}
