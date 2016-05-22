import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Program extends Applet implements ActionListener, ItemListener{

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
	CheckboxGroup checkboxgroup1;
	Checkbox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5;
	TextField text1;
	Choice choice1;

	public void init(){
		
		oknoTekstowe = new TextField(20);	// inicjalizacja okienka tekstowego na 20 znakow 
		add(oknoTekstowe); 					// wyswietla okienko w obszarze appletu
			

		przycisk1 = new Button("Welcome");	// inicjalizacja przycisku
		add(przycisk1);						// wyswietla przycisk w oknie appletu
		przycisk1.addActionListener(this);	// przypisuje przyciskowi dzialanie opisane w actionPerformed
		
		przycisk2 = new Button("to JAVA !!!");	
		add(przycisk2);						
		przycisk2.addActionListener(this);	
		
//===================================checkboxy==============================		
     
//         checkbox1 = new Checkbox("1");
//         add(checkbox1);
//         checkbox1.addItemListener(this);
//         
//         checkbox2 = new Checkbox("2");
//         add(checkbox2);
//         checkbox2.addItemListener(this);
//
//         checkbox3 = new Checkbox("3");
//         add(checkbox3);
//         checkbox3.addItemListener(this);
//
//         checkbox4 = new Checkbox("4");
//         add(checkbox4);
//         checkbox4.addItemListener(this);
//
//         checkbox5 = new Checkbox("5");
//         add(checkbox5);
//         checkbox5.addItemListener(this);
//
//         text1 = new TextField(20);
//         add(text1);
		
//===================================radialboxy==============================		
		
//		 checkboxgroup1 = new CheckboxGroup();
//
//         checkbox1 = new Checkbox("1", false, checkboxgroup1);
//         add(checkbox1);
//         checkbox1.addItemListener(this);
//
//         checkbox2 = new Checkbox("2", false, checkboxgroup1);
//         add(checkbox2);
//         checkbox2.addItemListener(this);
//
//         checkbox3 = new Checkbox("3", false, checkboxgroup1);
//         add(checkbox3);
//         checkbox3.addItemListener(this);
//
//         checkbox4 = new Checkbox("4", false, checkboxgroup1);
//         add(checkbox4);
//         checkbox4.addItemListener(this);
//
//         checkbox5 = new Checkbox("5", false, checkboxgroup1);
//         add(checkbox5);
//         checkbox5.addItemListener(this);
//
//         text1 = new TextField(20);
//         add(text1);
         
         
         text1 = new TextField(20);
         add(text1);
         choice1 = new Choice();
         choice1.add("Pozycja 1");
         choice1.add("Pozycja 2");
         choice1.add("Pozycja 3");
         choice1.add("Pozycja 4");
         add(choice1); 
         choice1.addItemListener(this);
	
	}	// koniec funkcji init
	
	public void itemStateChanged(ItemEvent e) {
		
//===================================checkboxy==============================	
		
//	    if(e.getItemSelectable() == checkbox1){
//	            text1.setText("Check box 1 clicked!");
//	    }
//
//	    if(e.getItemSelectable() == checkbox2){
//	            text1.setText("Check box 2 clicked!");
//	    }
//
//	    if(e.getItemSelectable() == checkbox3){
//	            text1.setText("Check box 3 clicked!");
//	    }
//
//	    if(e.getItemSelectable() == checkbox4){
//	            text1.setText("Check box 4 clicked!");
//	    }
//
//	    if(e.getItemSelectable() == checkbox5){
//	            text1.setText("Check box 5 clicked!");
//	    }
		
//===================================radialboxy==============================	
		
//        if(e.getItemSelectable() == checkbox1){
//            text1.setText("Radio button 1 clicked!");
//	    }
//	    if(e.getItemSelectable() == checkbox2){
//	            text1.setText("Radio button 2 clicked!");
//	    }
//	    if(e.getItemSelectable() == checkbox3){
//	            text1.setText("Radio button 3 clicked!");
//	    }
//	    if(e.getItemSelectable() == checkbox4){
//	            text1.setText("Radio button 4 clicked!");
//	    }
//	    if(e.getItemSelectable() == checkbox5){
//	            text1.setText("Radio button 5 clicked!");
//	    }
	    
	    
	    if(e.getItemSelectable() == choice1){
            text1.setText(((Choice)e.getItemSelectable()).getSelectedItem());
	    }
	}	// koniec funkcji itemStateChanged
}		// koniec klasy Appletu

