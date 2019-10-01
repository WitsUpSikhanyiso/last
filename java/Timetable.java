package com.packagename.myapp;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;


@Route("time")
public class Timetable extends AppLayout {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Timetable() {
		
		
		
		
		   VerticalLayout layout = new VerticalLayout();
		   layout.setWidthFull();
		   layout.setHeight("35%");
		   layout.getStyle().set("background", "black");
		   addToNavbar(layout);
		
		   
		   
		    View view = new View();
	        setContent(view);
		
		    Label homeLabel = new Label("Schedule and Timetable");
	        homeLabel.getStyle().set("position", "absolute");
	        homeLabel.getStyle().set("left", "50%");
	       // homeLabel.getStyle().set("top", "40%");
	        homeLabel.getStyle().set("top", "0%");
	        homeLabel.getStyle().set("background", "black");
	     	homeLabel.getStyle().set("color", "white");
	        homeLabel.getStyle().set("font-weight", "bold");
	        addToNavbar(homeLabel);
	         
	        
	        Icon home = new Icon(VaadinIcon.HOME_O);
	        home.setSize("11%");
	        home.setColor("white");
	        Button backbtn = new Button(null,home);
	        
	        backbtn.setIconAfterText(true);
	        //backbtn.setWidth("8%");
	     	backbtn.setWidth("8%");
	     	backbtn.setHeight("5%");
	     	backbtn.getStyle().set("border-radius", "20px");
	     	//backbtn.getStyle().set("border" ,"2px solid #4CAF50");
	     	backbtn.getStyle().set("background", "black");
	     	backbtn.getStyle().set("color", "blue");
	     	backbtn.getStyle().set("position","absolute");
	     	backbtn.getStyle().set("top", "0%");
	     	backbtn.getStyle().set("left", "80%");
	     	backbtn.getStyle().set("left", "90%");
	     	//backbtn.getStyle().set("border-color", "white");
	     	
	     	addToNavbar(backbtn);
	     	backbtn.addClickListener( event -> backHome());
	     	
	      
	             
	       // addToNavbar(new DrawerToggle(), homeLabel);
	       
	        
	        
	        Tabs tabs = new Tabs();
	        tabs.setWidthFull();
	        tabs.setHeightFull();
	        tabs.getStyle().set("background", "#1E90FF");
	        
         //appLayout.add(tabs);
            addToDrawer(tabs);
	      
	       
	        
	        
	        Tab sTab = new Tab();
	        sTab.setEnabled(false);
	        sTab.getStyle().set("font-weight", "bold");
	        sTab.getStyle().set("font-size", "1.9em");
	        sTab.getStyle().set("position", "absolute");
	        sTab.getStyle().set("top", "0%");
	        sTab.getStyle().set("left", "5%");
	        sTab.getStyle().set("color", "white");
	        sTab.setVisible(false);
	        tabs.add(sTab);
	        
	        
	      
	        
	        
	        
	        Button profilebtn = new Button("Set Schedule", new Icon(VaadinIcon.USER));
	        profilebtn.getStyle().set("color", "white");
	        profilebtn.getStyle().set("position", "absolute");
	        profilebtn.getStyle().set("left", "10%");
	        profilebtn.getStyle().set("border-radius", "20px");
	     	//signoT1.getStyle().set("border" ,"2px solid #4CAF50");
	        profilebtn.getStyle().set("top", "30%");
	        tabs.add(profilebtn);
	      //  profilebtn.addClickListener( event -> this.showProfile());
	        
	        
			
	        
	        Button timetablebtn = new Button("Tutoring Timetable", new Icon(VaadinIcon.CALENDAR_USER));
	        timetablebtn.getStyle().set("color", "white");
	        timetablebtn.getStyle().set("position", "absolute");
	        timetablebtn.getStyle().set("left", "10%");
	        timetablebtn.getStyle().set("border-radius", "20px");
	     	//signoT2.getStyle().set("border" ,"2px solid #4CAF50");
	        timetablebtn.getStyle().set("top", "40%");
	        tabs.add(timetablebtn);
	        timetablebtn.addClickListener(event ->
	        
	                        tutoringtime()     		
	        		);
	        
	        Button historybtn= new Button("Academic Timetable", new Icon(VaadinIcon.MINUS));
	        historybtn.getStyle().set("color", "white");
	        historybtn.getStyle().set("position", "absolute");
	        historybtn.getStyle().set("left", "10%");
	        historybtn.getStyle().set("border-radius", "20px");
	     	//signoT3.getStyle().set("border" ,"2px solid #4CAF50");
	        historybtn.getStyle().set("top", "50%");
	        tabs.add(historybtn);
	        
	        
	        
	        
	        
	        
	       
	       // signoutbtn.addClickListener( event -> loginpage());
		
		
		

		
		
	}
	
	public void tutoringtime() {
		
		TutoringTimetable tutoring = new TutoringTimetable();
		//   setContent(tutoringTimetable);
        setContent(tutoring);
		
		  
	}

 public boolean backHome() {
		 
		 setDrawerOpened(true);
		 
		 this.getUI().get().navigate("home");
		return true;
		 
		 
	 }
	
}
