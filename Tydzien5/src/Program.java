import java.io.*;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		
		
		System.out.println("Podaj nazwe pliku");
		DataRepository fileRepo = new DataRepository(userInput.nextLine());
		System.out.println("Podaj tekst do zapisania do pliku");
		fileRepo.setFileContent(userInput.nextLine());
		fileRepo.WriteFile();
		
		System.out.println("Odczytalem znaki: "+ fileRepo.ReadFile()); 	// Wydruk
	}

}
