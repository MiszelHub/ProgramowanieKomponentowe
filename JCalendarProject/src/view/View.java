package view;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.toedter.calendar.JCalendar;

import controllers.*;


public class View {

	private JCalendar calendar;
	private JFrame frame;
	private JPanel contentPanel, eventPanel, buttonPanel, calendarPanel;
	private JButton btn, userEventBtn;
	private JTextPane eventList;
	private JScrollPane eventlistSlider;
	private boolean todayBtnVisible = true;

	public JCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}

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

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JPanel getCalendarPanel() {
		return calendarPanel;
	}

	public void setCalendarPanel(JPanel calendarPanel) {
		this.calendarPanel = calendarPanel;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

	public JButton getUserEventBtn() {
		return userEventBtn;
	}

	public void setUserEventBtn(JButton userEventBtn) {
		this.userEventBtn = userEventBtn;
	}

	public boolean isTodayBtnVisible() {
		return todayBtnVisible;
	}

	public void setTodayBtnVisible(boolean todayBtnVisible) {
		this.todayBtnVisible = todayBtnVisible;
	}

	public JPanel getEventPanel() {
		return eventPanel;
	}

	public void setEventPanel(JPanel eventPanel) {
		this.eventPanel = eventPanel;
	}

	public JTextPane getEventList() {
		return eventList;
	}

	public void setEventList(String eventList) {
		this.eventList.setText(eventList);
	}

	//adding action listener connected with controller
	public void addUserEventActionListener(ActionListener listener){
		userEventBtn.addActionListener(listener);
	}
	public void addEventListActionListener(AncestorListener listener){
		eventList.addAncestorListener(listener);
	}
	public void showMessage(String message)
	{
		JOptionPane.showMessageDialog(new JFrame(), message, "Ups!", JOptionPane.ERROR_MESSAGE);
	}
	public View()
	{
		frame = new JFrame("Kalendarz");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(1334, 700);
		frame.setVisible(true);
		MainMenu mainMenu = new MainMenu(this);
		frame.setJMenuBar(mainMenu.getMenuBar());
		frame.setResizable(false);

		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 500, 700);
		frame.add(contentPanel);

		buttonPanel = new JPanel(null);
		buttonPanel.setBounds(0, 0, 500, 50);
//		buttonPanel.setBackground(Color.cyan);
		contentPanel.add(buttonPanel);

		eventPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		eventPanel.setBounds(500, -1, 950, 701);
//		eventPanel.setBackground(Color.MAGENTA);
		eventPanel.setBorder(new LineBorder(Color.gray, 1));
		contentPanel.add(eventPanel);


		eventList = new JTextPane();

		eventList.setSize(1, 1);
//		eventList.setText(Controller.printEventList());
		eventList.setEditable(false);
		eventlistSlider = new JScrollPane(eventList);
	
		eventPanel.add(eventlistSlider);



		userEventBtn = new JButton("Dodaj wydarzenie");
		buttonPanel.add(userEventBtn);
		userEventBtn.setSize(userEventBtn.getPreferredSize());
		userEventBtn.setLocation(10, 15);


		btn = new JButton("przycisk 1");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(calendar.getLocale().toString());
				calendar.getDayChooser().setForeground(Color.BLUE);
				calendar.getDayChooser().setMonth(0); //zaczyna sie styczen od 0
				calendar.getMonthChooser().setMonth(0);

			}
		});
		buttonPanel.add(btn);
		btn.setSize(btn.getPreferredSize());
		btn.setLocation(160, 15);

		calendarPanel = new JPanel(null);
		calendarPanel.setBounds(0, 50, 500, 650);
//		calendarPanel.setBackground(Color.gray);
		contentPanel.add(calendarPanel);

		calendar = new JCalendar();
		calendarPanel.add(calendar);
		calendar.setBounds(20, 20, calendarPanel.getWidth()-50, calendarPanel.getHeight()-120);
		calendar.setTodayButtonVisible(todayBtnVisible);

		calendar.setWeekOfYearVisible(true);

//		//Wypisuje dzie� kt�ry zosta� klikni�ty
//		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
//		    public void propertyChange(PropertyChangeEvent e) {
//		    	int day = calendar.getDayChooser().getDay();
//		    	int month = calendar.getMonthChooser().getMonth()+1;
//		    	int year = calendar.getYearChooser().getYear();
////				System.out.println(e.getPropertyName()+ ": " + e.getNewValue());
//		    	System.out.println(day+"."+month+"."+year);
//
//			}
//		});
//		calendar.addPropertyChangeListener(new PropertyChangeListener() {
//
//			public void propertyChange(PropertyChangeEvent arg0) {
//				// TODO Auto-generated method stub
//			   	int day = calendar.getDayChooser().getDay();
//		    	int month = calendar.getMonthChooser().getMonth();
//		    	int year = calendar.getYearChooser().getYear();
////				System.out.println(e.getPropertyName()+ ": " + e.getNewValue());
//		    	date.set(year, month, day);
//		    	System.out.println(date.getTime().toString());
//
//			}
//		});
	}
}
