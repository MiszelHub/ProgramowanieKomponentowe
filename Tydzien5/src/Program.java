import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Program {


	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);



		System.out.println("Podaj nazwe pliku");

		MyFileWriter fileRepo = new MyFileWriter(userInput.nextLine());

		System.out.println("Podaj tekst do zapisania do pliku");

		fileRepo.setFileContent(userInput.nextLine());

		fileRepo.WriteFile();

		System.out.println("Odczytalem znaki: "+ fileRepo.ReadFile()); 	// Wydruk

		// ZAPIS TABLICY DO PLIKU
		int zakres = 30;
		int i;
		int rozmiar = 15;
		int tab[] = new int[rozmiar];

		for (i=0; i< rozmiar; i++)
			tab[i] = (int)(Math.random()*zakres);
		try {
			DataOutputStream strumienTablicy = 		// Strumien zapisujacy liczby
				new DataOutputStream(new FileOutputStream("tablica.bin"));
			for (i=0; i< rozmiar; i++)
				strumienTablicy.writeInt(tab[i]);
		}
		catch (IOException io)
			{System.out.println(io.getMessage());}

		catch (Exception se)
			{System.err.println("blad sec");}

		// ODCZYT TABLICY Z PLIKU
		try {
		DataInputStream strumienTablicaZPliku =
					new DataInputStream(new FileInputStream("tablica.bin"));
			for (i=0; i< rozmiar; i++)
				tab[i] = strumienTablicaZPliku.readInt();
		}
		catch (FileNotFoundException io)
			{System.out.println(io.getMessage());}

		catch (IOException io)
			{System.out.println(io.getMessage());}

		printArray(tab);
		Arrays.sort(tab);

		printArray(tab);
		XMLEncoder enc=null;
		Human dave = new Human("Dave", 11, 124, 44);
		Human BraianBlessed = new Human("Brain",11, 144, 12313);
		ArrayList<Human> humans =  new ArrayList<Human>();
		humans.add(dave);
		humans.add(BraianBlessed);


		try {
			 enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("plik.xml")));


		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		 enc.writeObject(humans);
		 enc.close();
		 XMLDecoder dec=null;
			try {
				dec = new XMLDecoder(new BufferedInputStream( new FileInputStream("plik.xml")));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			ArrayList<Human> newhumans = (ArrayList<Human>) dec.readObject();
			System.out.println(newhumans.toString());
	}



	public static void printArray(int [] array)
	{
		for(int element : array)
		{
			System.out.print(element+" ");
		}
		System.out.println();
	}

}
