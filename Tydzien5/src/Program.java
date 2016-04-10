import java.io.*;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Podaj tekst do zapisania do pliku");
		String textToFile = userInput.nextLine();
		File plik = new File("Plik_out"); 	
		

		try	{
			plik.createNewFile();								// Utworzenie pliku pod sciezka zapisana w plik 
			FileWriter strumienZapisu = new FileWriter(plik);	// Konstrukcja i otwarcie strumienia
			//strumienZapisu.write(textToFile, 0, 7);				// Zapis do pliku liter od 0 do 7 z txt  
			strumienZapisu.write(textToFile);
			strumienZapisu.close(); 							// Zamkniecie strumienia
		}
		catch (IOException io)												
		{System.out.println(io.getMessage());}

	catch (Exception se)
		{System.err.println("blad sec");}
		
		char buf[] = new char[10]; 					// bufor (tablica) na odczytane znaki
		try {
			FileReader strumienOdczytu = new FileReader(plik);	// Konstrukcja i otwarcie strumienia odczytujacego
			strumienOdczytu.read(buf, 0, 7);			// Odczytanie znakow od 0 do 7 ze strumienia do bufora  
		}	
		
		catch (FileNotFoundException io)												
			{System.out.println(io.getMessage());}
		
		catch (IOException io)												
		{System.out.println(io.getMessage());} 
		
		String tekstOdczytany = new String(buf);			// Konwersja zawartosci bufora na String
		System.out.println("Odczytalem znaki: "+ tekstOdczytany); 	// Wydruk
	}

}
