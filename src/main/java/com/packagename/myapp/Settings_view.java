package com.packagename.myapp;

import javax.validation.constraints.Email;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("profile")
public class Settings_view extends HorizontalLayout{

	private static final long serialVersionUID = 1L;
	private Main_View main_window = new Main_View( );
	private TextField name = new TextField();
	
	NumberField phone = new NumberField();
	NumberField idnum = new NumberField();
	private TextField email = new  TextField();
	private TextField studentNumber = new TextField( );
	Button edit = new Button("Edit");
	Button save = new Button("Save");
       
	
	
    
    private Button sav = new Button("Register now");
	
	
	public Settings_view( ){
		
		setWidthFull();
	    setHeightFull();
	    setAlignItems(Alignment.CENTER);
        getStyle().set("background", "#3c3c3c");
	    
    	
        
    	Label labe = new Label("personal details");
     	labe.getStyle().set("color", "white");
     	labe.getStyle().set("font-size", "1.9em");
     	labe.getStyle().set("position", "absolute");
     	labe.getStyle().set("top", "5%");
     	labe.getStyle().set("left", "40%");
     	labe. getStyle().set("background", "#3c3c3c");
     	add(labe);
    	
    	
     	
     	
     	name.setPlaceholder("Full Name");
     	name.setWidth("40%");
     	name.getStyle().set("background", "white");
     	name.getStyle().set("position", "absolute");
    	name.getStyle().set("top", "20%");
    	name.getStyle().set("left", "30%");
    	name.setEnabled(false);
    	add(name);
    	
    	email.setWidth("40%");
    	email.setPlaceholder("Email");
    	email.getStyle().set("background", "white");
    	email.getStyle().set("position", "absolute");
    	email.getStyle().set("top", "30%");
    	email.getStyle().set("left", "30%");
    	email.setEnabled(false);
    	add(email);
    	
    	studentNumber.setWidth("40%");
    	studentNumber.setPlaceholder("Student Number");
    	studentNumber.getStyle().set("background", "white");
    	studentNumber.getStyle().set("position", "absolute");
    	studentNumber.getStyle().set("top", "40%");
    	studentNumber.getStyle().set("left", "30%");
    	studentNumber.setEnabled(false);
    	add(studentNumber);
    	
    	phone.setWidth("40%");
    	phone.setPlaceholder("Phone Number");
    	phone.setEnabled(false);
    	phone.getStyle().set("background", "white");
    	phone.getStyle().set("position", "absolute");
    	phone.getStyle().set("top", "50%");
    	phone.getStyle().set("left", "30%");
    	//phone.getStyle().set("right", "50.1%");
    	add(phone);
    	
    	
    	
    	idnum.setWidth("40%");
    	idnum.setEnabled(false);
    	idnum.getStyle().set("left", "30%");
    	idnum.setPlaceholder("ID number");
    	idnum.getStyle().set("background", "white");
    	idnum.getStyle().set("position", "absolute");
    	idnum.getStyle().set("top", "60%");
    	//idnum.getStyle().set("right", "50.1%");
    	add(idnum);
    	
    	
    	
    	
    	
    	edit.setWidth("40%");
    	edit.getStyle().set("border-radius", "20px");
    	edit.getStyle().set("border" ,"2px solid #4CAF50");
    	edit.getStyle().set("position", "absolute");
    	edit.getStyle().set("top", "75%");
    	edit.getStyle().set("left", "30%");
    	edit.getStyle().set("background", "#3c3c3c");
    	edit.getStyle().set("color","white");
    	
    	
    	add(edit);
    	
    	this.edit.addClickListener( e -> this.name() );
        
    	
   
				
	}
	
	public void saver() {
		
	 save.setVisible(false);
	 edit.setVisible(true);
	 
	    
		name.setEnabled(false);
		phone.setEnabled(false);
		idnum.setEnabled(false);
		email.setEnabled(true);
		studentNumber.setEnabled(false);
		
	}
	
	public void name() {
		
		
		edit.setEnabled(true);
		name.setEnabled(true);
		phone.setEnabled(true);
		idnum.setEnabled(true);
		email.setEnabled(true);
		studentNumber.setEnabled(true);
		
		
		edit.setVisible(false);
		
		save.setWidth("40%");
    	save.getStyle().set("border-radius", "20px");
    	save.getStyle().set("border" ,"2px solid #4CAF50");
    	save.getStyle().set("position", "absolute");
    	save.getStyle().set("top", "75%");
    	save.getStyle().set("left", "30%");
        save.getStyle().set("background", "#3c3c3c");
    	save.getStyle().set("color","white");
    	save.getStyle().set("alignItems", "center");
    	save.setVisible(true);
    	add(save);
    	
    	
    	this.save.addClickListener( e -> this.saver() );
		
		
		
	}
	
}
