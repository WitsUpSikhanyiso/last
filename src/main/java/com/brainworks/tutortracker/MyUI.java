package com.brainworks.tutortracker;


import com.brainworks.tutortracker.Profile;
import com.mysql.cj.xdevapi.Statement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	private Database database = new Database();
	private TextField email;
	private PasswordField passwordField;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	
    	/////////////////layout///////////////
    	AbsoluteLayout layout = new AbsoluteLayout();
    	layout.setWidth("100%");
    	layout.setHeight("100%");
   
    	  	/////////////////// panel////////////////////////////
    	 
    	Panel panel = new Panel(" " +"Welcome to Tutor Tracker");
    	panel.setSizeFull(); // Fill the specified area
    	panel.addStyleName("yellow");
    	layout.addComponent(panel, "left: 37%; right: 37%;" +
    	                           "top: 30%; bottom: 23%;");
    	//////////////////Button/////////////////////////////
    	
    	Button buttBrRelative = new Button( "Sign In");
    	buttBrRelative.setWidth("35%");
    	layout.addStyleName("backColor");
    	layout.addComponent(buttBrRelative, "left: 40%; bottom: 35%;");
    	
    	Button buttBrRelative1 = new Button( "Sign Up");
    	buttBrRelative1.setWidth("35%");
    	layout.addStyleName("backColor");
    	layout.addComponent(buttBrRelative1, "left: 40%; bottom: 25%;");
    	
    	/////email filed/////////
    	this.email = new  TextField("Email");
    	//email.setInputPrompt("email");
    	this.email.setWidth("35%");
    	layout.addComponent( this.email, "left: 40%;; bottom: 55%;");
    	
    	////////password//////////////
    	this.passwordField = new PasswordField("Password");
    	this.passwordField.setWidth("35%");
    	//tf.setInputPrompt("password");
    	layout.addComponent( this.passwordField, "left: 40%; bottom: 45%;");

    	
    	
    	//////////////progess bar///////////
    	
    	//ProgressBar bar = new ProgressBar();
    	///bar.setIndeterminate(true);
    	//layout.addComponent(bar, "left: 49%; bottom: 41%");
    	
    	////////////////label//////////
    	
    	
    	
    	
    	
    	this.database.connect();
    	//this.database.closeConnection();
    	
    	
    	buttBrRelative.addClickListener( clickEvent -> 
    	
    	this.login( )
    	//
    	//db() 
    	);   
    	
    	//nagivating to create page
    	
    	buttBrRelative1.addClickListener( clickEvent -> 
    	
    	
    	setContent(new Profile())
    	    	
    	    	);   
    	

        
    	setContent(layout);
    }
    
    
   
    
    public void login()  {
    	System.out.printf("LOGIN\n");
    	String email = this.email.getValue( );
    	String password = this.passwordField.getValue( );
    	
    	boolean correct = this.database.authenticateUser( email, password );
    	
    	if( correct ) {
    		Notification.show("Logged in");
    	}
    	else {
    		Notification.show("INCORRECT USER DETAILS");
    	}
    }
   

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}