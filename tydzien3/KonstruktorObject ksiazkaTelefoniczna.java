package tydzien3;

import java.util.Comparator;

public class ksiazkaTelefoniczna implements Comparable<ksiazkaTelefoniczna> {
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
	
	public ksiazkaTelefoniczna(Object o)
	{
		if(o instanceof ksiazkaTelefoniczna)
		{
			ksiazkaTelefoniczna tmp = (ksiazkaTelefoniczna) o;
			imie = tmp.imie;
			nazwisko = tmp.nazwisko;
			numer = tmp.numer;
			miasto = tmp.miasto;
			ulica = tmp.ulica;
			numerDomu = tmp.numerDomu;
		}
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
	@Override
	public int compareTo(ksiazkaTelefoniczna o) {
		
		if(this.numerDomu == o.numerDomu)
		{
			return 0;
		}
		else if( this.numerDomu > o.numerDomu)
		{
			return 1;
		}
		else return -1;
//		
		
	}
//	@Override
//	public  int compare(ksiazkaTelefoniczna o1, ksiazkaTelefoniczna o2) {
//		return o1.imie.compareToIgnoreCase(o2.imie);
//		
//	}
	

}
