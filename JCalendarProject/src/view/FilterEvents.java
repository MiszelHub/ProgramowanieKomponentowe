package view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
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
/**
* this class represents a window for filtering events
*We can filter either by date or location
*
*/
public class FilterEvents {
	GregorianCalendar calendar = new GregorianCalendar();
	private JFrame frame;
	private JPanel contentPanel ;
	private JTextField localization;
	private Button exitBtn, addBtn;
	private JLabel label;
	private JCheckBox datebox, localizationbox;
	private JDateChooser date = new JDateChooser(calendar.getTime()), alarmDate = new JDateChooser(calendar.getTime());

	private JSpinField hour, minutes, alarmHour, alarmMinutes, eventId;

	/**
	 * Constructor uses {@link GregorianCalendar} for date setting
	 * @param calendarDate
	 */
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

//		label = new JLabel("Data:");
//		label.setSize(label.getPreferredSize());
//		label.setLocation(20, 20);
//		contentPanel.add(label);

		datebox = new JCheckBox("Data:");
		datebox.setSelected(false);
		datebox.setSize(100, 30);
		datebox.setLocation(20,20);
		datebox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!datebox.isSelected())
					date.setEnabled(false);
				else {date.setEnabled(true);}
			}
		});
		contentPanel.add(datebox);


//		label = new JLabel("Lokalizacja:");
//		label.setSize(label.getPreferredSize());
//		label.setLocation(20, 60);
//		contentPanel.add(label);
		localizationbox = new JCheckBox("Lokalizacja:");
		localizationbox.setSelected(false);
		localizationbox.setSize(100, 30);
		localizationbox.setLocation(20,60);
		localizationbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!localizationbox.isSelected())
					localization.setEnabled(false);
				else {localization.setEnabled(true);}

			}
		});
		contentPanel.add(localizationbox);

		label = new JLabel("Godzina:");
		label.setSize(label.getPreferredSize());
		label.setLocation(20, 100);
		contentPanel.add(label);

		//koniec labeli z nazwami pól

		//nazwa wydarzenia
		localization = new JTextField();
		localization.setSize(200, 20);
		localization.setLocation(150, 60);
		localization.setEnabled(false);
		contentPanel.add(localization);

		//data
		date.setDate(calendarDate.getTime());
		date.setSize(200, 20);
		date.setLocation(150, 20);
		date.setEnabled(false);
		contentPanel.add(date);
//		yearPanel = new JTextField();
//		yearPanel.setSize(200,20);
//		yearPanel.setLocation(150, 60);
//		contentPanel.add(yearPanel);

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

		addBtn = new Button("Filtruj");
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

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date.getDate());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	    fmt.setCalendar(cal);
	    String dateFormatted = fmt.format(cal.getTime());
		return dateFormatted;
	}
	public void addLocalizationBoxListener(ActionListener listener){
		this.localizationbox.addActionListener(listener);
	}
	public void addDateBoxListener(ActionListener listener){
		this.datebox.addActionListener(listener);
	}
	public JTextField getLocalization() {
		return localization;
	}
	public String getLocalizationContents(){
		return this.localization.getText();
	}
	public void setLocalization(JTextField localization) {
		this.localization = localization;
	}
	public JDateChooser getDateChooser(){
		return this.date;
	}
	public void setDate(JDateChooser date) {
		this.date = date;
	}
	public JCheckBox getDatebox() {
		return datebox;
	}
	public void setDatebox(JCheckBox datebox) {
		this.datebox = datebox;
	}
	public JCheckBox getLocalizationbox() {
		return localizationbox;
	}
	public void setLocalizationbox(JCheckBox localizationbox) {
		this.localizationbox = localizationbox;
	}
}
