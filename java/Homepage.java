package com.packagename.myapp;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import io.grpc.netty.shaded.io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;


@PageTitle("Tutor tracker Home page")
@Route("home")
public class Homepage extends AppLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Main_View main_window = new Main_View( );
	
	public Homepage() {
		
	
	        View view = new View();
	        setContent(view);
	        
	       
	        Label homeLabel = new Label("Tutor Homepage");
	        homeLabel.getStyle().set("position", "absolute");
	        homeLabel.getStyle().set("left", "50%");
	        homeLabel.getStyle().set("top", "40%");
	        homeLabel.getStyle().set("font-weight", "bold");
	        
	        
	        Icon home = new Icon(VaadinIcon.HOME_O);
	        home.setSize("11%");
	        home.setColor("blue");
	        Button backbtn = new Button(null,home);
	        
	        backbtn.setIconAfterText(true);
	     	backbtn.setWidth("8%");
	     	backbtn.getStyle().set("border-radius", "20px");
	     	backbtn.getStyle().set("border" ,"2px solid #4CAF50");
	     	backbtn.getStyle().set("position","absolute");
	     	backbtn.getStyle().set("left", "80%");
	     	backbtn.getStyle().set("background", "white");
	     	backbtn.getStyle().set("color", "blue");
	     	backbtn.getStyle().set("top", "2%");
	     	backbtn.getStyle().set("left", "90%");
	     	backbtn.getStyle().set("border-color", "white");
	     	
	     	addToNavbar(backbtn);
	     	backbtn.addClickListener( event -> backHome());
	     	
	      
	             
	        addToNavbar(new DrawerToggle(), homeLabel);
	       
	        
	        
	        Tabs tabs = new Tabs();
	        tabs.setWidthFull();
	        tabs.setHeightFull();
	        tabs.getStyle().set("background", "#1E90FF");
	        
            //appLayout.add(tabs);
            addToDrawer(tabs);
	      
	       
	        
	        
	        Tab sTab = new Tab("Welcome ");
	        sTab.setEnabled(false);
	        sTab.getStyle().set("font-weight", "bold");
	        sTab.getStyle().set("font-size", "1.9em");
	        sTab.getStyle().set("position", "absolute");
	        sTab.getStyle().set("top", "10%");
	        sTab.getStyle().set("left", "5%");
	        sTab.getStyle().set("color", "white");
	        tabs.add(sTab);
	        
	        
	      
	        
	        
	        
	        Button profilebtn = new Button("Profile", new Icon(VaadinIcon.USER));
	        profilebtn.getStyle().set("color", "white");
	        profilebtn.getStyle().set("position", "absolute");
	        profilebtn.getStyle().set("left", "25%");
	        profilebtn.getStyle().set("border-radius", "20px");
	     	//signoT1.getStyle().set("border" ,"2px solid #4CAF50");
	        profilebtn.getStyle().set("top", "25%");
	        tabs.add(profilebtn);
	        profilebtn.addClickListener( event -> this.showProfile());
	        
	        Button timetablebtn = new Button("Timetable", new Icon(VaadinIcon.CALENDAR_USER));
	        timetablebtn.getStyle().set("color", "white");
	        timetablebtn.getStyle().set("position", "absolute");
	        timetablebtn.getStyle().set("left", "25%");
	        timetablebtn.getStyle().set("border-radius", "20px");
	     	//signoT2.getStyle().set("border" ,"2px solid #4CAF50");
	        timetablebtn.getStyle().set("top", "35%");
	        tabs.add(timetablebtn);
	        timetablebtn.addClickListener( event -> timetable());
	        
	        Button historybtn= new Button("History", new Icon(VaadinIcon.MINUS));
	        historybtn.getStyle().set("color", "white");
	        historybtn.getStyle().set("position", "absolute");
	        historybtn.getStyle().set("left", "25%");
	        historybtn.getStyle().set("border-radius", "20px");
	     	//signoT3.getStyle().set("border" ,"2px solid #4CAF50");
	        historybtn.getStyle().set("top", "45%");
	        tabs.add(historybtn);
	        
	        
	        Button settingsbtn= new Button("Settings" ,new Icon(VaadinIcon.SCREWDRIVER));
	        settingsbtn.getStyle().set("color", "white");
	        settingsbtn.getStyle().set("position", "absolute");
	        settingsbtn.getStyle().set("left", "25%");
	        settingsbtn.getStyle().set("border-radius", "20px");
	     	//signoT3.getStyle().set("border" ,"2px solid #4CAF50");
	        settingsbtn.getStyle().set("top", "55%");
	        tabs.add(settingsbtn);
	        settingsbtn.addClickListener( event -> set());
	        
	        
	        
	        
	        
	        Button signoutbtn = new Button("Sign Out", new Icon(VaadinIcon.SIGN_OUT));
	        signoutbtn.setWidth("60%");
	        signoutbtn.getStyle().set("color", "white");
	        signoutbtn.getStyle().set("position", "absolute");
	        signoutbtn.getStyle().set("left", "15%");
	        signoutbtn.getStyle().set("border-radius", "20px");
	     	signoutbtn.getStyle().set("border" ,"2px solid #4CAF50");
	     	signoutbtn.getStyle().set("border-color", "white");
	        signoutbtn.getStyle().set("top", "65%");
	        tabs.add(signoutbtn);
	        signoutbtn.addClickListener( event -> loginpage());
	        
	        
	        Button closebtn = new Button(null,new Icon(VaadinIcon.CLOSE_CIRCLE_O));
	        closebtn.setIconAfterText(true);
	        closebtn.setWidth("5%");
	        closebtn.getStyle().set("top", "10%"); 
	        closebtn.getStyle().set("background", "white");
	        closebtn.getStyle().set("position", "absolute");
	        closebtn.getStyle().set("left", "63%");
	        closebtn.getStyle().set("border-radius", "50%");
	     	//signo.getStyle().set("border" ,"2px solid #4CAF50");
	     	//signo.getStyle().set("border-color", "white");
	       
	        tabs.add(closebtn);
	        
	        closebtn.addClickListener( event -> setDrawerOpened(false));
	        
	        
	        
	        
	       ;
	        tabs.setOrientation(Tabs.Orientation.VERTICAL);
	        addToDrawer(tabs);
		
		
	}
	
	public void timetable() {
		
		 Timetable timetable = new Timetable();
		
		 this.getUI().get().navigate("time");
		 
	}
	
	public void loginpage() {
		
		MainView mainView = new MainView();
		this.getUI().get().navigate("login");
		//setContent(mainView);
	}
	
	
	 public boolean backHome() {
		 
		 setDrawerOpened(true);
		 View view = new View();
		 setContent(view);
		return true;
		 
		 
	 }
	
	public void showSchedule( ){
//		this.main_window.setContent(comp);
		
		
		
		
	}
	
	
	public void set() {
	// [firebase-database-worker] WARN com.google.firebase.database.connection.PersistentConnection - [pc_0] Using an unspecified index. Consider adding '".indexOn": "users"' at users to your security and Firebase Database rules for better performance	
		
		
		setDrawerOpened(false);
		Test test = new Test();
		setContent(test);
		
	}
	
	
	
	public void showProfile(  ){
//		this.change_view();
		System.out.println("SHOW PROFILE");
		Settings_view settings_view = new Settings_view( );
		
    	
           
    	
    	   setContent(settings_view);
    	   setDrawerOpened(false);
    	
    	
    	
    	
	}

}
