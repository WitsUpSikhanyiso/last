package com.packagename.myapp;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.internal.BeforeLeaveHandler;
import com.vaadin.flow.server.PWA;


@PageTitle("Sign in Wits Tutor Tracker")
@Route("login")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {


	private static final long serialVersionUID = 1L;

	private Database database = Database.getIntance();
	private TextField email;
	private PasswordField passwordField;
	
        public MainView( ) {
        	
    	System.out.printf("SHOWING START_UP PAGE\n");
    	
    	//setting up the width and heigh of the layout
    	setHeightFull();
    	setWidthFull();
    	
//    	this.getElement().addEventListener(eventType, listener)
    	
    	VerticalLayout layout = new VerticalLayout();
    	
    	layout.setWidthFull();
        layout.setHeight("8%");
        layout.getStyle().set("background", "black");
        this.add( layout );
         	 
        
        setAlignItems(Alignment.CENTER);
        getStyle().set("background", "#3c3c3c");
       
        /////////////////////////label///////////
     	Label label = new Label("Tutor Tracker");
     	label.getStyle().set("color", "white").set("font-size", "1.4em").set("font-weight", "bold").set("position", "absolute").set("top", "1%").set("background", "black");
     	add(label );
     	
     	Label labe = new Label("ACCOUNT LOGIN");
    	labe.getStyle().set("position", "absolute").set("top", "22%").set("color", "white").set("font-weight", "bold");
    	add(labe);
    	
    	HorizontalLayout lay = new HorizontalLayout();
    	lay.setWidth("50%");
    	lay.getStyle().set("position", "absolute");
    	lay.getStyle().set("top", "50%");
    	add(lay);
     	
     	
     	//////////////email/////////////////
    	//-fx-background-color: white;"
     	this.email = new  TextField();
     	email.setPlaceholder("Student Number");
     	//email.setInputPrompt("st");
     	this.email.setWidth("20%");
     	//this.email.getStyle().set("fx-background-color", "white");
     	this.email.getStyle().set("background", "white");
     	this.email.getStyle().set("position","absolute");
     	this.email.getStyle().set("top","30%");
     	add( this.email);
     	
     	// password
     	this.passwordField = new PasswordField();
     	this.passwordField.setPlaceholder("Password");
     	this.passwordField.getStyle().set("background", "white");
     	this.passwordField.setWidth("20%");
     	this.passwordField.getStyle().set("position","absolute");
     	this.passwordField.getStyle().set("top","40%");
     	add( this.passwordField);
     	
     	//////////////BUTTONS//////////////////////////////
     	
     	
     	Button sign_in_button = new Button( "Sign In" , new Icon(VaadinIcon.SIGN_IN));
     	sign_in_button.setWidth("20%");
        sign_in_button.getStyle().set("border" ,"2px solid #4CAF50");
        sign_in_button.getStyle().set("border-radius", "20px");
     	sign_in_button.getStyle().set("position","absolute");
     	sign_in_button.getStyle().set("top","55%");
     	sign_in_button.getStyle().set("background", "#3c3c3c");
     	sign_in_button.getStyle().set("color", "white");
     	add(sign_in_button);
     	sign_in_button.addClickListener(event -> this.login(  this.email.getValue(), this.passwordField.getValue() ) ) ;
     	sign_in_button.addClickShortcut(Key.ENTER);
     	
     	
     	Button sign_up_button = new Button( "Sign Up" , new Icon(VaadinIcon.LEVEL_UP));
     	sign_up_button.setWidth("8%");
     	sign_up_button.setHeight("5%");
        sign_up_button.getStyle().set("border" ,"2px solid #4CAF50");
        sign_up_button.getStyle().set("border-radius", "20px");
     	sign_up_button.getStyle().set("position","absolute");
     	sign_up_button.getStyle().set("top","1%");
     	sign_up_button.getStyle().set("left","90%");
     	sign_up_button.getStyle().set("background", "black");
     	sign_up_button.getStyle().set("color", "white");
     	sign_up_button.addClickListener(event-> do_sign_up() );
     	add(sign_up_button);
     	
     	Button forgot_button = new Button( "Forgot passsword?", new Icon(VaadinIcon.EDIT));
     	forgot_button.setWidth("20%");
        forgot_button.getStyle().set("border" ,"2px solid #4CAF50");
        forgot_button.getStyle().set("border-radius", "20px");
     	forgot_button.getStyle().set("position","absolute");
     	forgot_button.getStyle().set("top","64%");
     	forgot_button.getStyle().set("background", "#3c3c3c");
     	forgot_button.getStyle().set("color", "white");
     	add(forgot_button);
     	forgot_button.addClickListener( event-> forgot() );
     	
    }
        
        public void forgot() {
        	
        } 
    
    public void do_sign_up(){
    	System.out.print( "THIS IS THE SIGN UP METHOD\n" );
    	System.out.println("SHOW PROFILE");
		SignUp signUp = new SignUp( );
		
		
    	this.getUI().get().navigate("SignUp");
    }
    
    public void back_button(){
    	System.out.println( "BACK BUTTON CLICKED" );
//    	navigator.navigateTo("main");
//    	this.navigator.revertNavigation();   //.revertNavigation();
    }
    
   
    public void login( String user_id, String field_password )  {
    	
       	User user = this.database.getUser(user_id);
       	if( user != null ){
       		String hash_password = Database.hashString( field_password.concat(user_id) );
       		if( hash_password.equals( user.getHashPassword( ) ) == true){
       			System.out.println( "SUCCESSFUL LOGIN" );
       			this.getUI().get().navigate("home");
       		}
       		else{
       			System.out.println("INCORRECT PASSWORD");
       		}
       	}
       	else{
       		System.out.print("USER DOES NOT EXIST\n");
       	}
    
    }
}

//    
/*	private class Before_Leave implements BeforeLeaveHandler{

		@Override
		public void beforeLeave(BeforeLeaveEvent event) {
			// TODO Auto-generated method stub
			System.out.println("BEFORE LEAVE");
		}
    	
    }*/

/*
    private class Handle_Login implements ValueEventListener{
    	
    	
    	private String id;
    	private String password;
    	
    	private boolean returned = false;
    	private boolean correctDetails = false;
    	
    	public Handle_Login( String id, String password ) {
    		this.id = id;
    		this.password = password;
    		System.out.printf("id : %s | password : %s\n", id, password);
    	}
    	 
    	@Override
		public void onDataChange(DataSnapshot dataSnapshot ) {
			  System.out.printf("dataSnapshot : %s\n", dataSnapshot );
			  
			  if( dataSnapshot.getChildrenCount() > 0 ) {
				  System.out.print("-----========\n");
				  Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
				  System.out.print("----->>>>>>>>dafadf\n");
				  User user = iterable.iterator().next().getValue(User.class);
				  System.out.printf("USER\n%s\n", user );
//	      		System.out.printf("user : %s\n", user);
				  System.out.printf("password : %s (%d) | user.getPassword() : %s (%d)\n", password, password.length(), user.getPassword(),  user.getPassword().length() );
				  if( password.equals( user.getPassword( ) ) == true ){
						System.out.printf("SUCCESSFUL LOGIN\n");
						this.correctDetails = true;
				  }
				  else{
					  System.out.println( "INCORRECT LOGIN" );
					  Notification.show("INCORRECT USER DETAILS");
				  }
				  System.out.printf("SETTING THIS.RETURNED = TRUE");
				  this.returned = true;
			  }
			  else{
				  System.out.printf("a-df-a-d-f-ads-f-asd-f-a-dsf-ads-f-a-dsf\n");
			  }
			  
			  this.returned = true;
		  }
		
		  @Override
		  public void onCancelled(DatabaseError databaseError) {
		    System.out.println("The read failed: " + databaseError.getCode());
		  }
		
		public boolean hasReturned() {
//			System.out.print("HASRETURNED() THIS.RETURNED : "+this.returned+"\n");
			return this.returned;
		}
		
		public boolean isCorrectDetails() {
			return this.correctDetails;
		}
    	
    }
 */
