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
			g.drawLine(150,150, 180, 290);
			przycisk1.setLabel("wylacz bokA");
		}
		else {
			g.setColor(this.getBackground()); 
			g.drawLine(150,150, 180, 290);
			przycisk1.setLabel("WLACZ bokA");
		}
		
		if (bokB == true) {
			g.setColor(Color.BLACK);
			g.drawLine(180, 290, 290, 150);
			przycisk2.setLabel("wylacz bokA");
		}
		else {
			g.setColor(Color.WHITE); 
			g.drawLine(180, 290, 290, 150);
			przycisk2.setLabel("WLACZ bokB");
		}
		
		if (bokC == true) {
			g.setColor(Color.BLACK);
			g.drawLine(290, 150, 150, 150);
				przycisk3.setLabel("wylacz bokC");
		}
		else {
			g.setColor(Color.WHITE);
			g.drawLine(290, 150, 150, 150);
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
		
		if(evt.getSource() == changeColor)
		{
			if(colorChooser.getSelectedItem() == "Red")
				oknoTekstowe.setForeground(Color.RED);
			if(colorChooser.getSelectedItem() == "Blue")
				oknoTekstowe.setForeground(Color.BLUE);
			if(colorChooser.getSelectedItem() == "Green")
				oknoTekstowe.setForeground(Color.GREEN);
		}
		
		repaint(); 	// WAZNE, zeby funkcja paint wywolywala sie ponownie 
	}	// koniec funkcji actionPerformed
	
	class InnerClass extends MouseAdapter implements ActionListener, ItemListener, MouseMotionListener{
		
		InnerClass(){}
		
		public void actionPerformed(ActionEvent evt){
			
			if(evt.getSource() == innerClassButton){
				
				oknoKlas.setText("inner Class1");
			}
		}

		public void itemStateChanged(ItemEvent evt) {
			
			if(evt.getItemSelectable() == checkbox11){
				
				oknoKlas.setText("inner Class2");
			}
		}		
		
		public void mousePressed(MouseEvent evt){
			
			oknoKlas.setText("Adaptive Class1");
		}
		
		public void mouseEntered(MouseEvent evt){
			oknoKlas.setText("Adapitve Class2 (mouseEntered)");
		}
	}
	
	// Deklaracje obiektow - zmiennych reprezentujacych przyciski i okno tekstowe
	static Button 	przycisk1, 
			przycisk2,
			przycisk3,
			changeColor,
			innerClassButton,
			outerClassButton,
			localClassButton,
			anonymousClassButton; 
	
	static TextField 	oknoTekstowe, 
						oknoKlas,
						oknoAdaptacyjne;
    static Checkbox checkbox1, checkbox2, checkbox3, checkbox11, checkbox22, checkbox33, checkbox44, checkbox55;
    Choice colorChooser;
    Font coloredText;
	
	public void init(){
		
		InnerClass inner = new InnerClass();
		OuterClass outer = new OuterClass();

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
        
        
        oknoTekstowe = new TextField("Zmien kolor!");
		coloredText = new Font("Verdana", Font.PLAIN, 12);
		oknoTekstowe.setFont(coloredText);
		add(oknoTekstowe);
        
		
        colorChooser = new Choice();
        colorChooser.add("Green");
        colorChooser.add("Red");
        colorChooser.add("Blue");
        add(colorChooser);
        
        changeColor = new Button("Change text color");
        changeColor.addActionListener(this);
        add(changeColor);
        
        
        oknoKlas = new TextField("Klasa aktywowana przez Handler");
        add(oknoKlas);
        
        
        innerClassButton = new Button("Inner Class");
        innerClassButton.addActionListener(inner);
        add(innerClassButton);
        outerClassButton = new Button("outer Class");
        outerClassButton.addActionListener(outer);
        add(outerClassButton);
        anonymousClassButton = new Button("Anonymous Class");
        anonymousClassButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				MyApplet.oknoKlas.setText("Anonymous Class1");
			}
		});
        add(anonymousClassButton);
        
        
        checkbox11 = new Checkbox("inner");
        add(checkbox11);
        checkbox11.addItemListener(inner);
        
        checkbox22 = new Checkbox("outer");
        add(checkbox22);
        checkbox22.addItemListener(outer);

//        checkbox33 = new Checkbox("local");
//        add(checkbox33);
//        checkbox33.addItemListener(this);

        checkbox44 = new Checkbox("anonymous");
        add(checkbox44);
        checkbox44.addItemListener(new ItemListener(){
        	public void itemStateChanged(ItemEvent evt) {
    			MyApplet.oknoKlas.setText("Anonymous Class2");
        	}
        });
        
        oknoAdaptacyjne = new TextField("Naciœnij mnie");
        add(oknoAdaptacyjne);
        oknoAdaptacyjne.addMouseListener(inner);

	}	// koniec funkcji init

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
	    
	    repaint();
	}
	
//	public void localClassMethod(){
//		class LocalClass implements ActionListener, ItemListener {
//
//			public void actionPerformed(ActionEvent evt){
//				if(evt.getSource() == MyApplet.localClassButton)
//				{
//					MyApplet.oknoKlas.setText("Local Class1");
//				}
//			}
//
//			public void itemStateChanged(ItemEvent evt) {
//				if(evt.getItemSelectable() == MyApplet.checkbox33)
//				{
//					MyApplet.oknoKlas.setText("Local Class2");
//				}
//			}		
//			
//		}
//	}
	
}		// koniec klasy Appletu

