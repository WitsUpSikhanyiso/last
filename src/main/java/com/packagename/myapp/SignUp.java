package com.packagename.myapp;



import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Sign up for Wits Tutor Tracker")
@Route("SignUp")
public class SignUp extends VerticalLayout {
	
/* COMMENTED - THEY WERE NEVER USED */
//	private Main_View main_window = new Main_View( );
//	private Database database = new Database();
	
//	private TextField userid = new TextField();
	private TextField name = new TextField();
	private TextField surname = new TextField(  );
	private TextField email = new  TextField(  );
	private TextField userid  = new TextField(  );
	private TextField phoneNumberField = new TextField(  );
	private TextField I = new TextField(  );
       
	
	private PasswordField password = new PasswordField();
	private PasswordField comfirmPassword = new PasswordField();
    
    private Button save = new Button("Register now");
    private Button backButton = new Button("Already registered ?");
		
	 public SignUp() {
		 
		   
		    setWidthFull();
		    setHeightFull();
		    setAlignItems(Alignment.CENTER);
	        getStyle().set("background", "#3c3c3c");
		    
	    	VerticalLayout layout = new VerticalLayout();
	    	
	    	layout.setWidthFull();
	        layout.setHeight("5%");
	        layout.getStyle().set("background", "black");
	        this.add( layout );
	        
	        /* WE DONT NEED IT */
	        /*
	    	Label labe = new Label("REGISTRATION FORM");
	     	labe.getStyle().set("color", "white");
	     	labe.getStyle().set("font-weight", "bold");
	     	labe.getStyle().set("font-size", "1.0em");
	     	labe.getStyle().set("position", "absolute");
	     	labe.getStyle().set("top", "0%");
	     	labe. getStyle().set("background", "black");
	     	add(labe);
	     	*/
	    	
	    	Label label = new Label("Create an account");
	    	label.getStyle().set("color", "#008080");
	    	label.getStyle().set("position", "absolute");
	    	label.getStyle().set("top", "0%");
	    	
	    	label.getStyle().set("font-size", "1.875em");
	    	add(label);
	    	
	     	name.setWidth("40%");
	     	name.setPlaceholder("Name");
	     	name.getStyle().set("background", "white").set("position", "absolute").set("top", "10%");
	    	add(name);
	    		
	    	
	    	surname.setWidth("40%");
	    	surname.setPlaceholder("Surname");
	    	surname.getStyle().set("background", "white").set("position", "absolute").set("top", "20%");
	    	add(surname);
	    	
	    	userid.setWidth("40%");
	    	userid.setPlaceholder("Student/Staff Number");
	    	userid.getStyle().set("background", "white");
	    	userid.getStyle().set("position", "absolute");
	    	userid.getStyle().set("top", "30%");
	    	add(userid);
	    	
	    	phoneNumberField.setWidth("40%");
	    	phoneNumberField.setPlaceholder("Phone Number");
	    	phoneNumberField.getStyle().set("background", "white");
	    	phoneNumberField.getStyle().set("position", "absolute");
	    	phoneNumberField.getStyle().set("top", "40%");
	    	add(phoneNumberField);
	    	

	    	email.setWidth("40%");
	    	email.setPlaceholder("Email Address");
	    	email.getStyle().set("background", "white");
	    	email.getStyle().set("position", "absolute");
	    	email.getStyle().set("top", "50%");
	    	add(email);
	    	
	    	password.setWidth("40%");
	    	password.setPlaceholder("Password");
	    	password.getStyle().set("background", "white");
	    	password.getStyle().set("position", "absolute");
	    	password.getStyle().set("top", "60%");
	    	add(password);

	    	comfirmPassword.setWidth("40%");
	    	comfirmPassword.setPlaceholder("Confirm Password");
	    	comfirmPassword.getStyle().set("background", "white");
	    	comfirmPassword.getStyle().set("position", "absolute");
	    	comfirmPassword.getStyle().set("top", "70%");
	    	add(this.comfirmPassword);
	    	
	     	//setting the width of the button
	    	save.setWidth("40%");
	    	save.getStyle().set("border-radius", "20px");
	    	save.getStyle().set("border" ,"2px solid #4CAF50");
	    	save.getStyle().set("position", "absolute");
	    	save.getStyle().set("top", "80%");
	    	save.getStyle().set("background", "#3c3c3c");
	    	save.getStyle().set("color","white");
	    	save.getStyle().set("alignItems", "center");
	    	
	    	add(save);
	    	this.save.addClickListener( e -> this.registerUser(  ) );
	    	
	    	
	    	backButton.setWidth("40%");
	    	backButton.getStyle().set("border-radius", "20px");
	    	backButton.getStyle().set("border" ,"2px solid #4CAF50");
	    	backButton.getStyle().set("position", "absolute");
	    	backButton.getStyle().set("top", "88%");
	    	backButton.getStyle().set("background", "#3c3c3c");
	    	backButton.getStyle().set("color","white");
	    	backButton.getStyle().set("alignItems", "center");
	    	
	    	add(backButton);
	    	
	    	this.backButton.addClickListener( e -> this.back() );
	        
	    }
	   
	 
	 public void back() {
		 
		 MainView mainView = new MainView( );
			
			
	    	this.getUI().get().navigate("login");
		 
	 }
	 
	 
//	 /*
//	 public void registerUser(  ) {
//		 
//		Database.getIntance().addUser( user );
//		Homepage homepage = new Homepage( );	
//	    this.getUI().get().navigate("home");
//		
//	}*/
	 
	    	
	    	
	  public void registerUser(  ) {
		  
			String userid = this.userid.getValue( );
	    	String name = this.name.getValue( );
	    	String surname = this.surname.getValue( );
	    	String email = this.email.getValue( );
	    	String password = this.password.getValue();
	    	String phonenum = this.phoneNumberField.getValue();
	    	
	    	User user = new User();
	    	
	    	user.setUserId( userid );
	    	user.setName( name );
	    	user.setSurname( surname );
	    	user.setEmail( email );
	    	user.setPassword(password);
	    	user.setPhoneNum(phonenum); 
	    	
	    	if( this.validInputs( ) ) {
	    		System.out.printf("ADDING USER\n");
	    		Database.getIntance().addUser( user );
	    		
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
