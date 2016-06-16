package controllers;
import view.AddEvent;
import view.View;
import model.AlarmSound;
import model.EventRepository;
/**
* Controller is a class that connects all other components
* of the application
*
*/
public class Controller {

	EventRepository repo;
	View view;
	AddEvent addEventView = null;
	SQLConnection sqlConnection;

	/**
	* Constructor need a refference to Event Repository View and SQLConnention
	* @param repo holdsa reference to EventRepository
	* @param view providesarefference to View Class
	* @param sqlConnection provides reference to database using {@link SQLConnection}
	* @see EventRepository
	* @see View
	* @see SQLConnection
	*/
	public Controller(EventRepository repo, View view, SQLConnection sqlConnection) {
		super();
		this.repo = repo;
		this.view = view;
		this.sqlConnection = sqlConnection;
		UserEventAction usrEvtAction = new UserEventAction(view, sqlConnection);
		this.view.addUserEventActionListener(usrEvtAction);
		this.view.addEditEventActionListener(new EditEventAction(view, sqlConnection));

		this.view.addDeleteBtnActionListener(new DeleteEventAction(sqlConnection, view));

		XMLActions.setEventRepo(this.repo);
		this.view.getEventList().setText(sqlConnection.PrintEvents());

		this.view.getMainMenu().setExportXmlBtn(new ExportXmlAction(view, sqlConnection));
		this.view.getMainMenu().setImportXmlBtn(new ImportXmlAction(view, sqlConnection, repo));

		this.view.addfilterEventsActionListener(new FilterEventsAction(view,sqlConnection));
		AlarmSound a = new AlarmSound("ohayou.wav");
		AlarmClock c = new AlarmClock(a, view, sqlConnection);
		c.checkForAlarm();
	}

	public EventRepository getRepo() {
		return repo;
	}

	public void setRepo(EventRepository repo) {
		this.repo = repo;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public AddEvent getAddEventView() {
		return addEventView;
	}

	public void setAddEventView(AddEvent addEventView) {
		this.addEventView = addEventView;
	}

	public SQLConnection getSqlConnection() {
		return sqlConnection;
	}

	public void setSqlConnection(SQLConnection sqlConnection) {
		this.sqlConnection = sqlConnection;

	}


//	public void printEventList(){
//		view.setEventList(repo.getEventList().toString());
////		return "Lista Event�w\n\n\n\nfjsgiejgio";
//	}
//
//	public static void addEvent(){
//		addEventToDatabaseTable
//	}


}