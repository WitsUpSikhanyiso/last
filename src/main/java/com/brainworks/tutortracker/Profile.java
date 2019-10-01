package com.brainworks.tutortracker;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
@Theme("mytheme")
public class Profile extends AbsoluteLayout  {

	
	
	private Database database = new Database();
	private TextField name = new TextField( "Name" );
	private TextField surname = new TextField( "Surname" );
	private TextField email = new  TextField( "Email" );
	private TextField studentNumber = new TextField( "Student Number" );
	// private TextField phone = new  TextField(" Phone Number");
	
	private PasswordField password = new PasswordField("Password");
	private PasswordField comfirmPassword = new PasswordField("Confirm Password");
    
    private Button save = new Button("Create");
    
   
    public 	Profile() {
    	
    	addStyleName("backColor");
       // addComponents(name, age, save);
    	Panel panel = new Panel("Create your Account");
    	panel.setSizeFull();
    	
    	addComponent(panel,"left: 38%; right: 34%;" +
                "top: 10%; bottom: 15%;");
    	
    	

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    	
    	
     	name.setWidth("40%");
    	addComponent(name, "left: 40%;; bottom: 75%;");
    	
    	surname.setWidth("40%");
    	addComponent(surname, "left: 40%;; bottom: 65%;");
    	
    	studentNumber.setWidth("40%");
    	addComponent(studentNumber, "left: 40%;; bottom: 55%;");
    	
    	email.setWidth("40%");
    	addComponent(email, "left: 40%;; bottom: 45%;");
    	
    	password.setWidth("40%");
    	addComponent(password, "left: 40%;; bottom: 35%;");

    	comfirmPassword.setWidth("40%");
    	addComponent(this.comfirmPassword, "left: 40%;; bottom: 25%;");
    	
     	//setting the width of the button
    	save.setWidth("40%");
    	addComponent(save, "left: 40%;; bottom: 15%;");
   
    	
    	
    	this.save.addClickListener( e->
    	
    	
    	
    	
    	this.createUser( ) );
        
    }
    
    public void createUser() {
    	Notification.show( "ADDING USER" );
    	System.out.print("pressed");
    	String name = this.name.getValue( );
    	String surname = this.surname.getValue( );
    	String email = this.email.getValue( );
    	String studentnumber = this.studentNumber.getValue( );
    	String password = this.password.getValue();
    	
    	User user = new User();
    	
    	//some prof functionality
    	/*if( name.equals("") ) {
    		Notification.show( String.format( "Please put your Name"));
    	}
    	
    	if( surname .equals("") ) {
    		Notification.show( String.format( "Please put your Surname"));
    	}
    	if( email .equals("") ) {
    		Notification.show( String.format( "Please put your Email"));
    	}
    	
    	if( !email.contains("@") ) {
    		Notification.show( String.format( "Please put your a valid Email Address"));
    	}
    	
    	if( studentnumber .equals("") ) {
    		
    		Notification.show( String.format( "Please put your Student Number"));
    		
    	}
    	*/
    	
    	
    	user.setName( name );
    	user.setSurname( surname );
    	user.setEmail( email );
    	user.setStudentNumber( studentnumber );
    	user.setPassword(password);
    	
    	if( this.validInputs( ) ) {
    		this.database.addUser( user );
    	}else {
    		Notification.show( "INCORRECT DETAILS" );
    	}
    	
    }
    
    
    // METHOD TO CHECK INPUT FORMAT ARE CORRECT
    public boolean validInputs() {
    	boolean result = true;
    	if( ! this.passwordMatch( ) ) {
    		result = false;
    	}
    	return result;
    }
    
    public boolean passwordMatch(  ) {
    	String pass = this.password.getValue( );
    	String comPass = this.comfirmPassword.getValue( );
    	if( pass.equals( comPass ) ) {
    		return true;
    	}
    	return false;
  
    }
   
   
		
	}

