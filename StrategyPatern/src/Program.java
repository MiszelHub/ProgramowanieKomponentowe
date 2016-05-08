import java.util.ArrayList;
import java.io.*;
public class Program {

	public static void main(String[] args) {
		
		
		OrkMage gulldan = new OrkMage("Gulldan", 10, 2, 1, new MagicAttack());
		OrkWarrior garrosh = new OrkWarrior("Garrosh HellScream", 100, 0, 10, new MeleeAttack());
		
		System.out.println("Gulldan can attack with" +" "+ gulldan.trytoAttack());
		System.out.println("Garrosh can attack with" +" "+ garrosh.trytoAttack());
		
		Minion elemental=null;
		
		gulldan.summonMinion(elemental);

		elemental = new Minion("Myelemental", 1, 1);
		gulldan.summonMinion(elemental);
		
		gulldan.stealLife(gulldan.getMageMinion());
		
		garrosh.defensiveStance();
		System.out.println("Garrosh is using "+garrosh.getStance());
		
		garrosh.defensiveStance();
		
		garrosh.BerserkerStance();
		System.out.println("Garrosh is using "+garrosh.getStance());
		
		CompareOrkHealth OrkHealthComparator = new CompareOrkHealth();
		
		ArrayList<Ork> orks = new ArrayList<Ork>();
		orks.add(garrosh);
		orks.add(gulldan);
		try{
			OrkHealthComparator.compare(gulldan, garrosh);
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		try{
			serializeArrayListOfOrks(orks);
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		ArrayList<Ork> newOrks=null;
		try {
			newOrks = (ArrayList<Ork>)	DeserializeArrayListOfOrks();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		
		pritnArraylist(orks);
		WriteToFile file = new WriteToFile("Plik.txt", "HelloWorld");
		file.WriteFile();
		System.out.println(file.readFile());
		
	
	}
	public static void serializeArrayListOfOrks(ArrayList<Ork> orks) throws IOException
	{
		FileOutputStream fileout = new FileOutputStream("Orks.ser");
		ObjectOutputStream objOut = new ObjectOutputStream(fileout);
		objOut.writeObject(orks);
		objOut.close();
		fileout.close();
	
		
	}
	public static ArrayList<Ork> DeserializeArrayListOfOrks() throws IOException, ClassNotFoundException
	{
		FileInputStream fileIn = new FileInputStream("Orks.ser");
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		Object tmp;
		tmp = objIn.readObject();
		fileIn.close();
		objIn.close();
		return (ArrayList<Ork>) tmp;
		
		
	}
	public static <E> void pritnArraylist(ArrayList<E> orks)
	{
		for(E element : orks)
		{
			System.out.println(element.toString());
		}
	}
}
