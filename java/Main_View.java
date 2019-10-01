package com.packagename.myapp;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Main_View extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Component inWiew;
	
	
	public Main_View( ){
	
	}
	
	
	public void setContent( Component comp ){
		
		int comp_count = this.getComponentCount();
		if( comp_count == 1 ){
			this.replace(this.inWiew, comp);
			this.inWiew = comp;
		}
		else if( comp_count == 0 ){
			this.inWiew = comp;
			this.add(comp);
		}
		else{
			System.out.printf("COMPONENT COUNT IN MAIN WINDOW > 1\n");
		}
	}
	
//	public void addContent(  Component comp ){
//		
//	}
	
}
