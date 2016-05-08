import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	private String filename;
	private String fileContent;
	public WriteToFile(String filename, String fileContent)
	{
		this.filename = filename;
		this.fileContent =fileContent;
	}
	public void WriteFile() 
	{
		FileWriter fileout=null;
		try {
			File file = new File(this.filename);
			file.createNewFile();
			fileout = new FileWriter(file);
			fileout.write(fileContent);
			fileout.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public String readFile()
	{
		char[] buffor = new char[10]; 
		try {
		FileReader readfile = new FileReader(filename);
		readfile.read(buffor,0,10);
		readfile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tmp = new String(buffor);
		return tmp;
		
	}
}
