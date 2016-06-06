package view;

import java.awt.Button;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import com.toedter.components.JSpinField;

public class AddEvent {
	
	private JFrame frame;
	private JPanel contentPanel;
	private Button exitBtn, addBtn, cancelBtn;
	private JTextField txtField;
	private JLabel label;
	private JTextArea descriptionTxt;
	
	public AddEvent(GregorianCalendar calendarDate){
		frame = new JFrame("Dodaj wydarzenie");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setSize(500, 400);
		frame.setVisible(true);
		
		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 500, 400);
		frame.add(contentPanel);
		
		//labele z nazwami pól
		
		label = new JLabel("Nazwa wydarzenia:");
		label.setSize(label.getPreferredSize());
		label.setLocation(20, 20);
		contentPanel.add(label);
		
		label = new JLabel("Data:");
		label.setSize(label.getPreferredSize());
		label.setLocation(20, 60);
		contentPanel.add(label);
		
		label = new JLabel("Godzina:");
		label.setSize(label.getPreferredSize());
		label.setLocation(20, 100);
		contentPanel.add(label);
		
		label = new JLabel("Lokalizacja:");
		label.setSize(label.getPreferredSize());
		label.setLocation(20, 140);
		contentPanel.add(label);

		label = new JLabel("Opis");
		label.setSize(label.getPreferredSize());
		label.setLocation(20, 180);
		contentPanel.add(label);
		
		//koniec labeli z nazwami pól
		
		//nazwa wydarzenia
		txtField = new JTextField();
		txtField.setSize(200, 20);
		txtField.setLocation(150, 20);
		contentPanel.add(txtField);
		
		//data
		JDateChooser date = new JDateChooser(calendarDate.getTime());
		date.setSize(200, 20);
		date.setLocation(150, 60);
		contentPanel.add(date);
		
		//godzina 
		JSpinField hour = new JSpinField();
		hour.setMinimum(0);
		hour.setMaximum(23);
		hour.setSize(40, 20);
		hour.setLocation(150, 100);
		contentPanel.add(hour);
		
		JSpinField minutes = new JSpinField();
		minutes.setMinimum(0);
		minutes.setMaximum(59);
		minutes.setSize(40, 20);
		minutes.setLocation(200, 100);
		contentPanel.add(minutes);
		
		//lokalizacja
		txtField = new JTextField();
		txtField.setSize(200, 20);
		txtField.setLocation(150, 140);
		contentPanel.add(txtField);
		
		txtField = new JTextField();		//o co chodzi o.O 2x musze dodac to samo zeby sie wyswietlilo pole... dafaq?!
		txtField.setSize(200, 20);
		txtField.setLocation(150, 140);
		contentPanel.add(txtField);
		
		//opis
		descriptionTxt = new JTextArea();
		txtField.setSize(200, 60);
		txtField.setLocation(150, 180);
		contentPanel.add(txtField);

		
		
		exitBtn = new Button("Zamknij");
		exitBtn.setBounds(120, 250, 60, 30);
		contentPanel.add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
	
	
}
