import java.io.*;


public class MyFileWriter {

	private String fileName;
	private String fileContent;
	private File file;
	
	public MyFileWriter(String filename)
	{
		this.fileName = filename;
		this.file = new File(this.fileName+".txt");
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	public void WriteFile()
	{
		if(this.fileContent == null)
			throw new NullPointerException();
		try	{
			file.createNewFile();								// Utworzenie pliku pod sciezka zapisana w plik 
			FileWriter strumienZapisu = new FileWriter(file);	// Konstrukcja i otwarcie strumienia
			//strumienZapisu.write(fileContent, 0, 7);				// Zapis do pliku liter od 0 do 7 z txt  
			strumienZapisu.write(fileContent);
			strumienZapisu.close(); 							// Zamkniecie strumienia
		}
		catch (IOException io)												
		{System.out.println(io.getMessage());}

	catch (Exception se)
		{System.err.println("blad sec");}
	}
	
	public String ReadFile()
	{
		
		char buf[] = new char[(int) this.file.length()];  // bufor (tablica) na odczytane znaki
		try {
			FileReader strumienOdczytu = new FileReader(file);	// Konstrukcja i otwarcie strumienia odczytujacego
			strumienOdczytu.read(buf, 0, (int) this.file.length());			// Odczytanie znakow od 0 do 7 ze strumienia do bufora  
			strumienOdczytu.close();
		}	
		
		
		catch (FileNotFoundException io)												
			{System.out.println(io.getMessage());}
		
		catch (IOException io)												
		{System.out.println(io.getMessage());} 
		
	 String tekstOdczytany = new String(buf);			// Konwer
	 return tekstOdczytany;
	}
	
	
	
}
