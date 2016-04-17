
public class tydzien4 {
	
		
public static void main(String[] args) {
		
		
KsiazkaTelefoniczna ksiazka = new KsiazkaTelefoniczna();
		
		System.out.println("Nasza kolekcja");
		System.out.println(ksiazka.toString());
		
		ksiazka.sortCollection();
		System.out.println("Po sortowaniu z uzyciem interface Comparable wzgledem numeru domu");
		System.out.println(ksiazka.toString());
		
		ksiazka.sortWithComparator(Comparators.compareNumerTelefonu);
		System.out.println("Po sortowaniu z uzyciem interface Comparator wzgledem numeru telefonu");
		System.out.println(ksiazka.toString());
	}
}
	
			
		

