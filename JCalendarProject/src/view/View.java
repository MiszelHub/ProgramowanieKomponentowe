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
import com.toedter.components.JSpinField;

import controllers.*;

/**
* this class represents a MainWindow of our Application
*it shows all events and Jcallendar also provides buttos for adding filtering
*and updating events
*/
public class View {

	private JCalendar calendar;
	private JFrame frame;
	private JPanel contentPanel, eventPanel, buttonPanel, calendarPanel;
	private JButton editEventbtn, userEventBtn, filterBtn, archEventsBtn, deleteEventBtn;
	private JTextPane eventList;
	private JScrollPane eventlistSlider;
	private JSpinField deleteEventId;
	private boolean todayBtnVisible = true;
	MainMenu mainMenu;

	
	/**
	 * constructor of the view class
	 */
	public View()
	{
		frame = new JFrame("Kalendarz");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(1210, 750);
		frame.setVisible(true);
		mainMenu = new MainMenu(this);
		frame.setJMenuBar(mainMenu.getMenuBar());
		frame.setResizable(true);

		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 500, 700);
		frame.add(contentPanel);

		buttonPanel = new JPanel(null);
		buttonPanel.setBounds(0, 0, 500, 100);
//		buttonPanel.setBackground(Color.cyan);
		contentPanel.add(buttonPanel);

		eventPanel = new JPanel(new BorderLayout());
		eventPanel.setBounds(550, -1, 700, 650);
//		eventPanel.setBackground(Color.MAGENTA);
		eventPanel.setBorder(new LineBorder(Color.gray, 1));

		contentPanel.add(eventPanel);


		eventList = new JTextPane();

//		eventList.setSize(700, 700);
//		eventList.setBounds(750, 100, 10, 70);
//		eventList.setText(Controller.printEventList());
		eventList.setEditable(false);
		eventlistSlider = new JScrollPane(eventList);
		eventlistSlider.setBounds(800, 100, 700, 700);

//		eventPanel.add(eventList);
		eventPanel.add(eventlistSlider);



		userEventBtn = new JButton("Dodaj wydarzenie");
		buttonPanel.add(userEventBtn);
		userEventBtn.setSize(userEventBtn.getPreferredSize());
		userEventBtn.setLocation(10, 15);


		editEventbtn = new JButton("Edytuj wydarzenie");
		editEventbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(calendar.getLocale().toString());
				calendar.getDayChooser().setForeground(Color.BLUE);
				calendar.getDayChooser().setMonth(0); //zaczyna sie styczen od 0
				calendar.getMonthChooser().setMonth(0);

			}
		});

		buttonPanel.add(editEventbtn);
		editEventbtn.setSize(editEventbtn.getPreferredSize());
		editEventbtn.setLocation(160, 15);

		filterBtn = new JButton("Filtruj wydarzenia");
		buttonPanel.add(filterBtn);
		filterBtn.setSize(filterBtn.getPreferredSize());
		filterBtn.setLocation(315, 15);
		
		archEventsBtn = new JButton("Archiwum Wydarzeñ");
		archEventsBtn.setSize(archEventsBtn.getPreferredSize());
		archEventsBtn.setLocation(20, 60);
		buttonPanel.add(archEventsBtn);

		deleteEventBtn = new JButton("Usuñ wydarzenie o ID:");
		deleteEventBtn.setSize(deleteEventBtn.getPreferredSize());
		deleteEventBtn.setLocation(200, 60);
		buttonPanel.add(deleteEventBtn);
		
		deleteEventId = new JSpinField();
		deleteEventId.setSize(60, deleteEventBtn.getHeight());
		deleteEventId.setLocation((int)deleteEventBtn.getLocation().getX()+deleteEventBtn.getWidth(), 60);
		buttonPanel.add(deleteEventId);

		calendarPanel = new JPanel(null);
		calendarPanel.setBounds(0, 100, 500, 650);
//		calendarPanel.setBackground(Color.gray);
		contentPanel.add(calendarPanel);

		calendar = new JCalendar();
		calendarPanel.add(calendar);
		calendar.setBounds(20, 20, calendarPanel.getWidth()-50, calendarPanel.getHeight()-120);
		calendar.setTodayButtonVisible(todayBtnVisible);

		calendar.setWeekOfYearVisible(true);

	}
	
	//getters and setters + assign events methods
	
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
		return editEventbtn;
	}

	public void setBtn(JButton btn) {
		this.editEventbtn = btn;
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

//	public void addEventListActionListener(AncestorListener listener){
//		eventList.addAncestorListener(listener);
//	}
	/**
	 * Action listener for edit button
	 * @param listener
	 */
	public void addEditEventActionListener(ActionListener listener){
		editEventbtn.addActionListener(listener);
	}
	/**
	 * Action listener for filter button
	 * @param listener
	 */
	public void addfilterEventsActionListener(ActionListener listener){
		filterBtn.addActionListener(listener);
	}
	/**
	 * this method shows {@link JOptionPane} with an error message
	 * @param message error message
	 */
	public void showMessage(String message)
	{
		JOptionPane.showMessageDialog(new JFrame(), message, "Ups!", JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * this method shows {@link JOptionPane} with an alarm message
	 * @param message alarm info
	 */
	public void showAlarmMessage(String message){
		JOptionPane.showMessageDialog(new JFrame(), message, "Upcomig Event!", JOptionPane.WARNING_MESSAGE);
	}

	public JButton getEditEventbtn() {
		return editEventbtn;
	}

	public void setEditEventbtn(JButton editEventbtn) {
		this.editEventbtn = editEventbtn;
	}

	public JButton getFilterBtn() {
		return filterBtn;
	}

	public void setFilterBtn(JButton filterBtn) {
		this.filterBtn = filterBtn;
	}

	public JScrollPane getEventlistSlider() {
		return eventlistSlider;
	}

	public void setEventlistSlider(JScrollPane eventlistSlider) {
		this.eventlistSlider = eventlistSlider;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public void setEventList(JTextPane eventList) {
		this.eventList = eventList;
	}
	
	public void addDeleteBtnActionListener(ActionListener listener){
		this.deleteEventBtn.addActionListener(listener);
	}
	
	public int getDeleteEventId(){
		return this.deleteEventId.getValue();
	}
	
	public void addArchiveBtnActionListener(ActionListener listener){
		this.archEventsBtn.addActionListener(listener);
	}
	
	
}
