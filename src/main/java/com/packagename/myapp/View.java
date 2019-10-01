package com.packagename.myapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.Route;

import io.grpc.netty.shaded.io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;


@Route("view")

public class View extends HorizontalLayout{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public View() {
		
		
		

		setWidthFull();
	    setHeightFull();
	    setAlignItems(Alignment.CENTER);
        getStyle().set("background", "#3c3c3c");
        
	    ////////////////////////////////buttons/////////////////////
    	
        Button round = new Button(null , new Icon(VaadinIcon.COPYRIGHT));
        round.setIconAfterText(true);
        round.setWidth("5%");
        round.getStyle().set("top", "22%"); 
        round.getStyle().set("background", "#3c3c3c");
        round.getStyle().set("border-radius", "50%");
        round.getStyle().set("position", "absolute");
        round.getStyle().set("left", "48%");
     	add(round);
     	
     	
     	
     	 Icon icon = new Icon(VaadinIcon.CLUSTER);
     	 icon.setSize("40%");
     	 icon.setColor("red");
     	 Button roun = new Button(null , icon);
         roun.setIconAfterText(true);
         roun.setWidth("50%");
         roun.getStyle().set("top", "80%").set("background", "#3c3c3c").set("border-radius", "50%");
         roun.getStyle().set("position", "absolute");
         roun.getStyle().set("left", "24%");
      	 add(roun);
      	
      	
      	
      	
      	 
   
      	 
        
     	////////////////////////////
     	
     	
     	
     	
     	Label bea = new Label("Tutor Tracker brings ");
     	bea.getStyle().set("color", "white");
     	bea.getStyle().set("font-size", "1.1em");
     	bea.getStyle().set("position", "absolute");
     	bea.getStyle().set("top", "26%");
     	bea.getStyle().set("left", "44%");
     	
     	bea. getStyle().set("background", "#3c3c3c");
     	add(bea);
     	
        
    	Label labe = new Label("A better way to work ");
     	labe.getStyle().set("color", "white");
     	labe.getStyle().set("font-size", "3.9em");
     	labe.getStyle().set("position", "absolute");
     	labe.getStyle().set("top", "33%");
     	labe.getStyle().set("left", "31%");
     	labe.getStyle().set("font-weight", "bold");
     	labe. getStyle().set("background", "#3c3c3c");
     	add(labe);
     	
     	
     	Label lab = new Label("Tutor Tracker is a Wits Web based application that helps tutorers to");
     	lab.getStyle().set("color", "white");
     	lab.getStyle().set("font-size", "1.1em");
     	lab.getStyle().set("position", "absolute");
     	lab.getStyle().set("top", "50%");
     	lab.getStyle().set("left", "32%");
     	lab. getStyle().set("background", "#3c3c3c");
     	add(lab);
     	
     	
     	Label l = new Label("simplify their tutoring session");
     	l.getStyle().set("color", "white");
     	l.getStyle().set("font-size", "1.1em");
     	l.getStyle().set("position", "absolute");
     	l.getStyle().set("top", "57%");
     	l.getStyle().set("left", "42%");
     	l. getStyle().set("background", "#3c3c3c");
     	add(l);
     	
     	
     	
		
		
	}

}
