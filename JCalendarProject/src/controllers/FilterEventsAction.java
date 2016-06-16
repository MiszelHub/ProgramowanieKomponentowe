package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import view.FilterEvents;
import view.View;

class FilterEventsAction implements ActionListener{
	View view;
	FilterEvents filterEvents;
	SQLConnection sqlconnection;

	public FilterEventsAction(View view, SQLConnection sqlconnection) {
		super();
		this.view = view;
		this.sqlconnection = sqlconnection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		filterEvents = new FilterEvents(new GregorianCalendar());

		class FilterButtonClicked implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {

				if(filterEvents.getDateChooser().isEnabled() && !filterEvents.getLocalization().isEnabled())
				//view.getEventList().setText(sqlconnection.filterEventsByYear(filterEvents.getDate()));
				view.getEventList().setText(sqlconnection.filterEventsByDate(filterEvents.getDate()).toString());
				
				else if((!filterEvents.getDateChooser().isEnabled()) && filterEvents.getLocalization().isEnabled())
					view.getEventList().setText(sqlconnection.filtereventsByLocation(filterEvents.getLocalizationContents()));
					
				
				else if(filterEvents.getDateChooser().isEnabled() && filterEvents.getLocalization().isEnabled())
						view.getEventList().setText(sqlconnection.filtereventsByLocationAndDate(filterEvents.getLocalizationContents(), filterEvents.getDate()));
			}

		}
		
		this.filterEvents.addFilterButtonListener(new FilterButtonClicked());

	}

}
