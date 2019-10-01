package com.brainworks.tutortracker;


//package com.packagename.myapp.spring;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.vaadin.ui.Notification;

public class Database {
	
	private String username;
	private String password;
	private String portNumber;
	private String databaseName; 
	private Connection connection;
	
	Database( ){
		
		this.username = "l18Jt8LSkG";
		this.password = "vcVj5ay1JU";
		this.portNumber = "3306";
		this.databaseName = "l18Jt8LSkG";
	}
	
	public void connect() {
 	Notification.show("CONNECTED");
 	try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			// 
			this.connection = DriverManager.getConnection( "jdbc:mysql://remotemysql.com:3306/l18Jt8LSkG", "l18Jt8LSkG", "vcVj5ay1JU");  			 

		}
		catch( Exception e ){
			System.out.println( "ERROR OCCURED !!!" );
			e.printStackTrace( );
		} 
	}
	
	public void closeConnection(  ) {
		//Notification.show("CLOSING CONNECTION");
		try {
			this.connection.close( );
			
		}catch( Exception e ) {
			e.printStackTrace( );
		}
	}
	
	public void addUser( User user ) {
		
		this.connect( );
		
		String name = user.getName( );
		String email = user.getEmail( );
		String password = user.getPassword( );
		String surname = user.getSurname( );
		String studentNumber = user.getStudentNumber(); 
		
		String sql = "insert into users( name, surname, email, password, studentNumber ) values( '"+name+"', '"+surname+"', '"+email+"', '"+password+"', '"+studentNumber+"' )";
				
		try {
			
//			PreparedStatement preparedStatement = this.connection.prepareStatement( sql );
//			preparedStatement.setString(1, name );
//			preparedStatement.setString(2, surname );
//			preparedStatement.setString(3, email);
//			preparedStatement.setString(4, password);
//			preparedStatement.setString(5, studentNumber);
//			
//			preparedStatement.executeUpdate();
//			
			Statement statement = this.connection.createStatement(  );
			
			String[] values = { name, surname, email, password, studentNumber };
			
			statement.execute( sql, values);   //.executeUpdate( );
			
			// System.out.printf("NODE :::::::: %s\n", results.getString( 0 ) );
			
			//  this.closeConnection();
			
			Notification.show( String.format( "Succesful registered", user ) );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		this.closeConnection( );
	}
	
	
	public boolean authenticateUser( String studentNumber, String password ) {
		// String studentNumber = user.getStudentNumber( );
		// String password = user.getPassword();
		
		User user = this.getUser( studentNumber );
		if( user == null ) {
			
			//Notification.show( String.format( "No records of your student number in our records"));
			
			return false;
		}
		
		
		
		// this.getUser( studentNumber );
		String s = user.getPassword( );
		if( s.equals( password ) ) {
			
			
			
			return true;
		}else if (password.equals(" ")) {
			
			
			
			
			return false;
			
			
		}
		else {
			
			
			
			
			return false;
		}
	}
	
	public User getUser( String studentNumber) {
		try{
			
			String sql = "select * from users where studentNumber='"+studentNumber+"'";
			
			Statement statement = this.connection.createStatement();
			
			ResultSet results = statement.executeQuery( sql );   // execute( sql, values );
		
			try {
				System.out.println( "results" );
				if( results.next( ) ) {
					System.out.printf("%d id : %s password : %s email : %s surname : %s name : %s, studentNumber : %s\n"
							, 1 
							, results.getString( 1 )
							, results.getString( 2 )
							, results.getString( 3 )
							, results.getString( 4 ) 
							, results.getString( 5 )
							, results.getString( 6 ));
				}	
				
				String name = results.getString( 5 );
				String surname = results.getString( 4 ); 
				String email = results.getString( 3 );
				String password = results.getString( 2 );
				String studentnumber = results.getString( 6 );
				
				User user = new User();
				
				user.setName( name );
				user.setSurname( surname );
				user.setEmail( email );
				user.setStudentNumber( studentnumber );
				user.setPassword( password );
				
				System.out.printf("%s\n", user);
				
				return user;
				
			}catch( Exception e ) {
				e.printStackTrace();
				return null;
			}
			
			
		}catch ( Exception e ) {
			e.printStackTrace( );
			return null;
		}
	}
//	
//	public boolean authenticateUser( String username, String password ) {
//		
//		User user = this.getUser( username );
//		
//		if( user.getPassword( ).equals( password )  ) {
//			return true;
//		}
//		else {
//			return false;
//		}
//		
//	}
 
	public String getDatabaseName() {
		return this.databaseName;
	}
	
	public String getPassword( ) {
		return this.password;
	}
	
	public String getPornNumber( ) {
		return this.portNumber;
	}

	
}
