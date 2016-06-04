package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public final class ToXML {
	private static XMLEncoder encoder;
	private static XMLDecoder decoder;
	
	private ToXML(){};
	
	public static void saveEventsToXML(ArrayList<EventBase> list)
	{
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Events.xml")));
			encoder.writeObject(list);
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static<E>ArrayList<E> loadEventsFromXML()
	{
		ArrayList<E> tmp = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Events.xml")));
			 tmp = (ArrayList<E>) decoder.readObject();
			 decoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
		
	}
}
