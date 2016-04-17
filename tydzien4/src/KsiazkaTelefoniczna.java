import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class KsiazkaTelefoniczna {

	private Vector<Kontakt> ksiazkaVector = new Vector<Kontakt>();
	
	
	public KsiazkaTelefoniczna()
	{
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 223123323, "Lodz", "Gdanska", 1));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 323123323, "Lodz", "Gdanska", 2));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 3));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 623123323, "Lodz", "Gdanska", 4));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 5));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 223123323, "Lodz", "Gdanska", 6));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 7));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 723123323, "Lodz", "Gdanska", 8));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 9));
		ksiazkaVector.add(new Kontakt("Jan", "Kowalski", 923123323, "Lodz", "Gdanska", 10));
	}
	public Vector<Kontakt> getKsiazka() {
		return ksiazkaVector;
	}
	public void setKsiazka(Vector<Kontakt> ksiazka) {
		this.ksiazkaVector = ksiazka;
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for(int i=0; i< ksiazkaVector.size(); i++ )
		{
			stb.append(ksiazkaVector.elementAt(i).toString()+"\n");
		}
		return stb.toString();
	}
	
	public void sortCollection()
	{
		Collections.sort(ksiazkaVector);
	}
	public void sortWithComparator(Comparator<Kontakt> c)
	{
		Collections.sort(ksiazkaVector, c);
	}
	
}
