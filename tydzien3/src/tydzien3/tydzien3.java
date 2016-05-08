package tydzien3;

public class tydzien3 {
	
	public static void printArray(Object array[])
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i].toString());
		}
	}
	
	public static void main(String[] args) {
		KsiazkaTelefoniczna ksiazka = new KsiazkaTelefoniczna();
		
		System.out.println(ksiazka.toString());
		
		ksiazka.sortArray();
		System.out.println("Po sortowaniu z uzyciem interface Comparable wzgledem numeru domu");
		System.out.println(ksiazka.toString());
		
		ksiazka.sortWithComparator(Comparators.compareNumerTelefonu);
		System.out.println("Po sortowaniu z uzyciem interface Comparator wzgledem numeru telefonu");
		System.out.println(ksiazka.toString());
		
		Kontakt k1 = new Kontakt("asdasd", "asdasdas", 123123, "asdasdas", "qweqwe", 12);
		System.out.println(k1.toString());
		Kontakt k2 = new Kontakt(k1);
		System.out.println(k2.toString());
	}
}
	
			
		

