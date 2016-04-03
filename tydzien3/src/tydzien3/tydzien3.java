package tydzien3;
import java.util.Arrays;
import java.util.Comparator;

public class tydzien3 {
	
	public static void printArray(Object array[])
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i].toString());
		}
	}
	
	public static void main(String[] args) {
		ksiazkaTelefoniczna [] ksiazka = new ksiazkaTelefoniczna[10];
		


		ksiazka[0] = new ksiazkaTelefoniczna("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 1);
		ksiazka[1] = new ksiazkaTelefoniczna("Jan", "Kowalski", 223123323, "Lodz", "Gdanska", 2);
		ksiazka[2] = new ksiazkaTelefoniczna("Jan", "Kowalski", 323123323, "Lodz", "Gdanska", 3);
		ksiazka[3] = new ksiazkaTelefoniczna("Jan", "Kowalski", 233123323, "Lodz", "Gdanska", 7);
		ksiazka[4] = new ksiazkaTelefoniczna("Jan", "Kowalski", 143123323, "Lodz", "Gdanska", 6);
		ksiazka[5] = new ksiazkaTelefoniczna("Jan", "Kowalski", 263123323, "Lodz", "Gdanska", 4);
		ksiazka[6] = new ksiazkaTelefoniczna("Jan", "Kowalski", 224123323, "Lodz", "Gdanska", 8);
		ksiazka[7] = new ksiazkaTelefoniczna("Jan", "Kowalski", 124523323, "Lodz", "Gdanska", 11);
		ksiazka[8] = new ksiazkaTelefoniczna("Jan", "Kowalski", 223343323, "Lodz", "Gdanska", 9);
		ksiazka[9] = new ksiazkaTelefoniczna("Jan", "Kowalski", 222222323, "Lodz", "Gdanska", 12);
		printArray(ksiazka);
		Arrays.sort(ksiazka);
	
		System.out.println();
		System.out.println("Po sortowaniu z uzyciem interface Comparable wzgledem numeru domu");
		printArray(ksiazka);
		
		Comparator<ksiazkaTelefoniczna> compareksiazka = new Comparator<ksiazkaTelefoniczna>() {

			@Override
			public int compare(ksiazkaTelefoniczna o1, ksiazkaTelefoniczna o2) {
				return o1.getNumer()-o2.getNumer();
				
			
			}
		};
			
		Arrays.sort(ksiazka, compareksiazka);
		System.out.println();
		System.out.println("Po sortowaniu z uzyciem interface Comparator wzgledem numeru telefonu");
		printArray(ksiazka);
	
	
	
	
	}
}
	
			
		

