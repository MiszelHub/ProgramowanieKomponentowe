package view;

import java.awt.Button;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

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
	GregorianCalendar calendar = new GregorianCalendar();
	private JFrame frame;
	private JPanel contentPanel;
	private Button exitBtn, addBtn;
	private JTextField nameField, localizationField;
	private JLabel label;
	private JTextArea descriptionTxt;
	private JDateChooser date = new JDateChooser(calendar.getTime());
	JSpinField hour, minutes; 

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
		nameField = new JTextField();
		nameField.setSize(200, 20);
		nameField.setLocation(150, 20);
		contentPanel.add(nameField);
		
		//data
		date.setSize(200, 20);
		date.setLocation(150, 60);
		contentPanel.add(date);
		
		//godzina 
		hour = new JSpinField();
		hour.setMinimum(0);
		hour.setMaximum(23);
		hour.setValue(calendarDate.getTime().getHours());
		hour.setSize(40, 20);
		hour.setLocation(150, 100);
		contentPanel.add(hour);
		
		minutes = new JSpinField();
		minutes.setMinimum(0);
		minutes.setMaximum(59);
		minutes.setValue(calendarDate.getTime().getMinutes());
		minutes.setSize(40, 20);
		minutes.setLocation(200, 100);
		contentPanel.add(minutes);
		
		//lokalizacja
		localizationField = new JTextField();
		localizationField.setSize(200, 20);
		localizationField.setLocation(150, 140);
		contentPanel.add(localizationField);
		
//		localizationField = new JTextField();		//o co chodzi o.O 2x musze dodac to samo zeby sie wyswietlilo pole... dafaq?!
//		localizationField.setSize(200, 20);
//		localizationField.setLocation(150, 140);
//		contentPanel.add(localizationField);
		
		//opis
		descriptionTxt = new JTextArea();
		descriptionTxt.setSize(200, 60);
		descriptionTxt.setLocation(150, 180);
		contentPanel.add(descriptionTxt);

		
		addBtn = new Button("Zapisz");
		addBtn.setBounds(140, 280, 60, 30);
		contentPanel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(nameField.getText()+" "+localizationField.getText()+" "+
						descriptionTxt.getText()+" "+date.getDate().toString()+" "+
						hour.getValue()+":"+minutes.getValue());
			}
		});
		
		exitBtn = new Button("Anuluj");
		exitBtn.setBounds(280, 280, 60, 30);
		contentPanel.add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
	
	public void addAddBtnListener(ActionListener listener){
		addBtn.addActionListener(listener);
	}

	//getters and setters
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	public Button getExitBtn() {
		return exitBtn;
	}

	public void setExitBtn(Button exitBtn) {
		this.exitBtn = exitBtn;
	}

	public Button getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}

	public String getNameField() {
		return nameField.getText();
	}

	public String getLocalizationField() {
		return localizationField.getText();
	}

	public String getLabel() {
		return label.getText();
	}

	public String getDescriptionTxt() {
		return descriptionTxt.getText();
	}
	
	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}

	public String getDate() {
		return date.getDate().getYear()+"-"+date.getDate().getMonth()+"-"+date.getDate().getDay();
	}

	public int getHour() {
		return hour.getValue();
	}

	public int getMinutes() {
		return minutes.getValue();
		
	}
	
}
