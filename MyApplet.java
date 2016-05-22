package tydzien9;

import javax.swing.*;

import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;

import java.awt.*;
import java.awt.event.*; 
import java.applet.*;


public class MyApplet extends Applet implements ActionListener, ItemListener {  

	
	boolean bokA = false,
			bokB = false,
			bokC = false;
	
	public void paint (Graphics g) {
		if (bokA == true) {
			g.setColor(this.getForeground()); 
			g.drawLine(50,50, 80, 190);
			przycisk1.setLabel("wylacz bokA");
		}
		else {
			g.setColor(this.getBackground()); 
			g.drawLine(50,50, 80, 190);
			przycisk1.setLabel("WLACZ bokA");
		}
		
		if (bokB == true) {
			g.setColor(Color.BLACK);
			g.drawLine(80, 190, 190, 50);
			przycisk2.setLabel("wylacz bokA");
		}
		else {
			g.setColor(Color.WHITE); 
			g.drawLine(80, 190, 190, 50);
			przycisk2.setLabel("WLACZ bokB");
		}
		
		if (bokC == true) {
			g.setColor(Color.BLACK);
			g.drawLine(190, 50, 50, 50);
				przycisk3.setLabel("wylacz bokC");
		}
		else {
			g.setColor(Color.WHITE);
			g.drawLine(190, 50, 50, 50);
				przycisk3.setLabel("WLACZ bokC");
		}
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		
		if (evt.getSource() == przycisk1) {
			bokA = !bokA; 
		}
		
		if (evt.getSource() == przycisk2){
			bokB = !bokB; 
		}
		
		if (evt.getSource() == przycisk3){
			bokC = !bokC;
		}
		
		repaint(); 	// WAZNE, zeby funkcja paint wywolywala sie ponownie 
	}	// koniec funkcji actionPerformed
	
	
	
	// Deklaracje obiektow - zmiennych reprezentujacych przyciski i okno tekstowe
	Button 	przycisk1, 
			przycisk2,
			przycisk3; 
	
	TextField oknoTekstowe;
    Checkbox checkbox1, checkbox2, checkbox3;
    Choice ColorChooser;
	
	public void init(){
		
		przycisk1 = new Button("WLACZ A");	// inicjalizacja przycisku
		add(przycisk1);						// wyswietla przycisk w oknie appletu
		przycisk1.addActionListener(this);	// przypisuje przyciskowi dzialanie opisane w actionPerformed
		
		przycisk2 = new Button("WLACZ B");	
		add(przycisk2);						
		przycisk2.addActionListener(this);	

		przycisk3 = new Button("WLACZ C");	
		add(przycisk3);						
		przycisk3.addActionListener(this);	
		
		
		
		checkbox1 = new Checkbox("1");
        add(checkbox1);
        checkbox1.addItemListener(this);
        
        checkbox2 = new Checkbox("2");
        add(checkbox2);
        checkbox2.addItemListener(this);

        checkbox3 = new Checkbox("3");
        add(checkbox3);
        checkbox3.addItemListener(this);
        
        
//        ColorChooser = new Choice();
//        ColorChooser.add("Green");
//        ColorChooser.add("Red");
//        ColorChooser.add("Blue");
//        add(ColorChooser);
//        ColorChooser.addItemListener(this);

	}	// koniec funkcji init


	@Override
	public void itemStateChanged(ItemEvent e) {
	    if(e.getItemSelectable() == checkbox1){
	    	bokA = !bokA; 
	    }
	
	    if(e.getItemSelectable() == checkbox2){
	    	bokB = !bokB; 
	    }
	
	    if(e.getItemSelectable() == checkbox3){
	    	bokC = !bokC; 
	    }	
	    
//	    if(e.getItemSelectable() == "Red")
	    
	    repaint();
	}
	
}		// koniec klasy Appletu

