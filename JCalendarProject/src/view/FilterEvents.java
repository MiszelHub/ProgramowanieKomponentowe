package view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.GregorianCalendar;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class FilterEvents {
	GregorianCalendar calendar = new GregorianCalendar();
	private JFrame frame;
	private JPanel contentPanel ;
	private JTextField yearPanel;
	private Button exitBtn, addBtn;
	private JLabel label;
	private JDateChooser date = new JDateChooser(calendar.getTime()), alarmDate = new JDateChooser(calendar.getTime());

	private JSpinField hour, minutes, alarmHour, alarmMinutes, eventId;
	
	public FilterEvents(GregorianCalendar calendarDate){
		frame = new JFrame("Filtruj wydarzenia");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setSize(450, 250);
		frame.setVisible(true);
		
		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 500, 250);
		frame.add(contentPanel);
		
		//labele z nazwami pól
		
		label = new JLabel("ID wydarzenia:");
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
		
		//koniec labeli z nazwami pól
		
		//nazwa wydarzenia
		eventId = new JSpinField();
		eventId.setSize(200, 20); 
		eventId.setLocation(150, 20);
		contentPanel.add(eventId);
		
		//data
//		date.setDate(calendarDate.getTime());
//		date.setSize(200, 20);
//		date.setLocation(150, 60);
//		contentPanel.add(date);
		yearPanel = new JTextField();
		yearPanel.setSize(200,20);
		yearPanel.setLocation(150, 60);
		contentPanel.add(yearPanel);
		
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
		
		addBtn = new Button("Zapisz");
		addBtn.setBounds(140, 150, 60, 30);
		contentPanel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(nameField.getText()+" "+
//						date.getDate().toString()+" "+
//						hour.getValue()+":"+minutes.getValue());
			}
		});
		
		exitBtn = new Button("Anuluj");
		exitBtn.setBounds(280, 150, 60, 30);
		contentPanel.add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	}
	public void addFilterButtonListener(ActionListener listener)
	{
		this.addBtn.addActionListener(listener);
	}
	public String getDate(){
		
		return this.yearPanel.getText();
	}
}
