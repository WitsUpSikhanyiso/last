package com.packagename.myapp;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("tutoring")
public class TutoringTimetable extends VerticalLayout{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TutoringTimetable() {
		
		
		
	   
		
		VerticalLayout panel = new VerticalLayout();
        panel.getStyle().set("overflow", "auto");
        panel.getStyle().set("border", "1px solid");
        panel.setWidthFull();
        panel.setHeightFull();
        add(panel);

        VerticalLayout layout = new VerticalLayout();

        layout.getStyle().set("display","block");

        layout.setSizeUndefined();
        layout.add(new TextField("eins"));
        layout.add(new TextField("zwei"));
        layout.add(new TextField("drei"));

        panel.add(layout);

		
		
		
	}

}
