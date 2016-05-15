import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Program extends Applet implements ActionListener{

	Image img;
	
	public void paint (Graphics g) {
		g.drawLine(100, 10, 10, 150);
		g.drawLine(10, 150, 150, 150);
		g.drawLine(150, 150, 100, 10);
		

		// Powieksza rozmiar okna appletu
		setSize(600,600); // albo takze funkcja resize(400,400);
		
		// zmienia kolor linii
				g.setColor(Color.blue);
				
				// rysuje kwadrat lub prostokat
				g.drawRect(100,210,190,120); 
				
				g.drawRoundRect(160, 50, 110, 120, 50, 50);
				
				g.drawOval(10, 200, 40, 70);
				
				
				img = getImage(getCodeBase(),"welcome.jpg.");
				
				g.drawImage(img, 100, 400,this);
				
				// Ustawia kroj i parametry czcionki w applecie
				String s = new String ("Hello World !!!");
				Font appFont = new Font("Times New Roman", Font.PLAIN, 28);  
				
				g.setColor(Color.blue);
				g.setFont(appFont); 
				g.drawString(s,350, 300);		
			
				
	}
public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == przycisk1)
			oknoTekstowe.setText("Welcome");
		
		if (evt.getSource() == przycisk2)
			oknoTekstowe.setText(oknoTekstowe.getText()+" to JAVA !!!");
		
	}	// koniec funkcji actionPerformed
	
	
	
	// Deklaracje obiektow - zmiennych reprezentujacych przyciski i okno tekstowe
	Button 	przycisk1, 
			przycisk2; 
	
	TextField oknoTekstowe; 
	
	public void init(){
		
		oknoTekstowe = new TextField(20);	// inicjalizacja okienka tekstowego na 20 znakow 
		add(oknoTekstowe); 					// wyswietla okienko w obszarze appletu
			

		przycisk1 = new Button("Welcome");	// inicjalizacja przycisku
		add(przycisk1);						// wyswietla przycisk w oknie appletu
		przycisk1.addActionListener(this);	// przypisuje przyciskowi dzialanie opisane w actionPerformed
		
		przycisk2 = new Button("to JAVA !!!");	
		add(przycisk2);						
		przycisk2.addActionListener(this);	
		
	}	// koniec funkcji init
	
}		// koniec klasy Appletu

