package com.packagename.myapp;

import java.awt.Panel;
import java.util.ArrayList;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Session_view extends VerticalLayout{

	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	private ArrayList < Session > sessions = new ArrayList<Session>();
	
	public Session_view(  ){

		Session session = this.database.getSession("COMS3005");
		
		
		
	}
	
	public void addSession(Session session){
		this.sessions.add(session);
	}

	
	private class sessionPanel{
		
		sessionPanel(){
			Panel panel = new Panel();
			
		}
		
	}
	
	
}
