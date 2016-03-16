package tydzien3;

public class tydzien3 {

	public static void main(String[] args) {
		ksiazkaTelefoniczna [] ksiazka = new ksiazkaTelefoniczna[10];
		Object [] object = new Object[10];
		for(int i=0;i<ksiazka.length;i++)
		{
			ksiazka[i] = new ksiazkaTelefoniczna("Jan", "Kowalski", 123123323, "Lodz", "Gdanska", 22);
		}
		for(int i=0;i<ksiazka.length;i++)
		{
			System.out.println(ksiazka[i].toString());
		}
		
		for(int i=0;i<ksiazka.length;i++)
		{
			object[i] = ksiazka[i];
		}
		//cos sobie probowa³em mniejsza o to :D
		System.out.println("===============================================");
		
		for(int i=0;i<object.length;i++)
		{
			System.out.println(object[i].toString());
		}
	}

}
