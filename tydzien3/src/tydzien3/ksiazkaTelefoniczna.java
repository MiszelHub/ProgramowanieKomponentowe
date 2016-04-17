package tydzien3;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.Object;

public class KsiazkaTelefoniczna {

	private Kontakt [] ksiazka = new Kontakt[10];
	public KsiazkaTelefoniczna()
	{
			ksiazka[0] = new Kontakt("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 1);
			ksiazka[1] = new Kontakt("Jan", "Kowalski", 223123323, "Lodz", "Gdanska", 2);
			ksiazka[2] = new Kontakt("Jan", "Kowalski", 323123323, "Lodz", "Gdanska", 3);
			ksiazka[3] = new Kontakt("Jan", "Kowalski", 233123323, "Lodz", "Gdanska", 7);
			ksiazka[4] = new Kontakt("Jan", "Kowalski", 143123323, "Lodz", "Gdanska", 6);
			ksiazka[5] = new Kontakt("Jan", "Kowalski", 263123323, "Lodz", "Gdanska", 4);
			ksiazka[6] = new Kontakt("Jan", "Kowalski", 224123323, "Lodz", "Gdanska", 8);
			ksiazka[7] = new Kontakt("Jan", "Kowalski", 124523323, "Lodz", "Gdanska", 11);
			ksiazka[8] = new Kontakt("Jan", "Kowalski", 223343323, "Lodz", "Gdanska", 9);
			ksiazka[9] = new Kontakt("Jan", "Kowalski", 222222323, "Lodz", "Gdanska", 12);
	}
	public Kontakt[] getKsiazka() {
		return ksiazka;
	}
	public void setKsiazka(Kontakt[] ksiazka) {
		this.ksiazka = ksiazka;
	}
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for(int i=0; i< ksiazka.length; i++ )
		{
			String  s = new String();
			stb.append(ksiazka[i].toString()+"\n");
		}
		return stb.toString();
	}
	public void sortArray()
	{
		Arrays.sort(ksiazka);
	}
	public void sortWithComparator(Comparator c)
	{
		Arrays.sort(ksiazka, c);
	}
	
}
