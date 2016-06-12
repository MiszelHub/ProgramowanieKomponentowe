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

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
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
	private JLabel label,alarmlabel;
	private JTextArea descriptionTxt;
	private JDateChooser date = new JDateChooser(calendar.getTime()), alarmDate = new JDateChooser(calendar.getTime());
	private JSpinField hour, minutes, alarmHour,alarmMinutes;
	private JCheckBox alarmbox;
	private JScrollPane descriptionScroll;

	public AddEvent(GregorianCalendar calendarDate){
		frame = new JFrame("Dodaj wydarzenie");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setSize(400, 450);
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
		date.setDate(calendarDate.getTime());
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
		descriptionScroll = new JScrollPane(descriptionTxt);
		descriptionScroll.setBounds(150, 180, 200, 60);
		contentPanel.add(descriptionScroll);

		alarmbox = new JCheckBox("Ustaw Alarm");
		alarmbox.setSelected(false);
		alarmbox.setSize(100, 30);
		alarmbox.setLocation(20,265);
		contentPanel.add(alarmbox);

		alarmDate.setSize(200, 20);
		alarmDate.setLocation(150, 270);
		alarmDate.setEnabled(false);
		alarmDate.setDate(date.getDate());
		contentPanel.add(alarmDate);

		alarmHour = new JSpinField();
		alarmHour.setMinimum(0);
		alarmHour.setMaximum(23);
		alarmHour.setValue(hour.getValue());
		alarmHour.setSize(40, 20);
		alarmHour.setLocation(150, 300);
		alarmHour.setEnabled(false);
		contentPanel.add(alarmHour);

		alarmMinutes = new JSpinField();
		alarmMinutes.setMinimum(0);
		alarmMinutes.setMaximum(59);
		alarmMinutes.setValue(minutes.getValue());
		alarmMinutes.setSize(40, 20);
		alarmMinutes.setLocation(200, 300);
		alarmMinutes.setEnabled(false);
		contentPanel.add(alarmMinutes);


		addBtn = new Button("Zapisz");
		addBtn.setBounds(140, 350, 60, 30);
		contentPanel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println(nameField.getText()+" "+localizationField.getText()+" "+
						descriptionTxt.getText()+" "+date.getDate().toString()+" "+
						hour.getValue()+":"+minutes.getValue());
			}
		});

		exitBtn = new Button("Anuluj");
		exitBtn.setBounds(280, 350, 60, 30);
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

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date.getDate());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	    fmt.setCalendar(cal);
	    String dateFormatted = fmt.format(cal.getTime());
		return dateFormatted;
//		return date.getDate().getYear()+"-"+date.getDate().getMonth()+"-"+date.getDate().getDay();
	}
	public String getAlarmDate(){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(alarmDate.getDate());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	    fmt.setCalendar(cal);
	    String dateFormatted = fmt.format(cal.getTime());
		
	    return dateFormatted;
	}

	public void setDate(Date date){
		this.date.setDate(date);
	}

	public int getHour() {
		return hour.getValue();
	}
	public int getAlarmHour(){
		return this.alarmHour.getValue();
	}

	public int getMinutes() {
		return minutes.getValue();

	}
	public int getAlarmMinutes(){
		return this.alarmMinutes.getValue();
	}

	public JSpinField getAlarmHourBox(){
		return this.alarmHour;
	}
	public JSpinField getAlarmMinutesBox(){
		return this.alarmMinutes;
	}
	public JDateChooser getAlarmDateChooser(){
		return this.alarmDate;
	}
	public void setAlarmDate(JDateChooser alarmDate) {
		this.alarmDate = alarmDate;
	}


	public JCheckBox getAlarmbox() {
		return alarmbox;
	}

	public void setAlarmbox(JCheckBox alarmbox) {
		this.alarmbox = alarmbox;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public void setLocalizationField(JTextField localizationField) {
		this.localizationField = localizationField;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public void setDescriptionTxt(JTextArea descriptionTxt) {
		this.descriptionTxt = descriptionTxt;
	}

	public void setDate(JDateChooser date) {
		this.date = date;
	}

	public void setHour(JSpinField hour) {
		this.hour = hour;
	}

	public void setMinutes(JSpinField minutes) {
		this.minutes = minutes;
	}

	public void AddAlarmAcionListener(ActionListener turnOnTheAlarm) {
		this.alarmbox.addActionListener(turnOnTheAlarm);

	}



}
