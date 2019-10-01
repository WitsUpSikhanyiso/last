package com.packagename.myapp;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.vaadin.flow.component.notification.Notification;


// * MYSQL DATABASE INFORMATION
// * database name :  
// * database password : 
// * database login link : https://remotemysql.com/phpmyadmin
// * 
// * Tables : users { 
// * 	id int(11) auto_increment primary key,
// * 	userid varchar( 100 ),
// * 	email varchar (100 ),
// * 	phonenum varchar( 15 ),
// * 	name varchar( 100 ),
// * 	surname varchar( 100 ),
// * 	hash_password varchar( 64 ),
// * 	type varchar(20),
// * 	}
// * 
 



/**
 * 
 * @author 1497069
 * mysql database information
 */
public class Database {
	
	private String password;
	private String portNumber;
	private String databaseName; 
	private Connection connection;
	
	private static Database database = null;
	
	Database( ){
		
		this.password = "MAXpe5qGDs";
		this.portNumber = "3306";
		this.databaseName = "l18Jt8LSkG";
		

	}
	
	public static Database getIntance() {
		if( database == null ) {
			database  = new Database();
		}
		return database;
	}
	
	
	/*
	public void test(){
		
		this.connect();
		
		String sql = "select * from users";
		try{
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			System.out.printf("FETCH SIZE : %d\n", rs.getFetchSize());
			while( rs.next( ) ){
				
				String id = rs.getString(rs.findColumn("id"));
				String userId = rs.getString(rs.findColumn("userId"));
				String name = rs.getString(rs.findColumn("name"));
				String email = rs.getString(rs.findColumn("email"));
				String surname = rs.getString(rs.findColumn("surname"));
				String phoneNum = rs.getString(rs.findColumn("phonenum"));
				String hash_password = rs.getString(rs.findColumn("hash_password"));
				String type =  rs.getString(rs.findColumn("type"));
				
				User user = new User();
				
				user.setId(id);
				user.setUserId(userId);
				user.setName(name);
				user.setSurname(surname);
				user.setEmail(email);
				user.setHashPassword( hash_password );
				user.setType(type);
				user.setPhoneNum(phoneNum);
				
				System.out.println( user );
			}
		}
		catch( SQLException e ){
			 System.err.println("SQL exception: " + e.getMessage());
		}
		catch(  Exception e ){
			e.printStackTrace();
		}
		
		
		this.closeConnection();
		
	}
	*/
	
	public void connect() {
 	try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
//			Class.for
			this.connection = DriverManager.getConnection( "jdbc:mysql://remotemysql.com:3306/l18Jt8LSkG", "l18Jt8LSkG", "MAXpe5qGDs");  			 
		}
	 	catch( SQLException e ){
			 System.err.println("SQL exception: " + e.getMessage());
		}
		catch( Exception e ){
			System.out.println( "ERROR OCCURED !!!" );
			System.out.printf("<<<<<<<<<<<<<<<\n%s\n", e.getMessage() );
			e.printStackTrace( );
		} 
	}
	
	public void closeConnection(  ) {
		try {
			this.connection.close( );
		}catch( Exception e ) {
			e.printStackTrace( );
		}
	}
	

	public Course getCourse(String code) {
		this.connect();
		try {
			
		}catch( Exception e ) {
			e.printStackTrace();
			return null;
		}
		
		this.closeConnection();
		return null;
	}

	public void addUser( User user ) {
		this.connect( );
		
		String userid = user.getUserId();
		String name = user.getName( );
		String surname = user.getSurname( );
		String email = user.getEmail( );
		String phonenum = user.getPhoneNum( );
		String type = user.getType();
		String hash_password = Database.hashString( user.getPassword( ).concat(user.getUserId( ) ) );
		
		String sql = "insert into users( userid, name, surname, email, phonenum, hash_password, type ) values( ?, ?, ?, ?, ?, ?, ? )";
				
		try {
			
			PreparedStatement ps = this.connection.prepareStatement( sql );
			ps.setString(1, userid);
			ps.setString(2, name);
			ps.setString(3, surname);
			ps.setString(4, email);
			ps.setString(5, phonenum);
			ps.setString(6, hash_password);
			ps.setString(7, type );
			
			ps.executeUpdate();

		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		this.closeConnection( );
	}
	
	/*
	public boolean authenticateUser( String studentNumber, String password ) {
		User user = this.getUser( studentNumber );
		if( user != null ){
			String p = user.getPassword( );
//			String s = user.getStudentNumber();
			if( studentNumber.equals(s) && password.equals( p ) ) {
				return true;
			}
			else if (studentNumber.equals(s) ) {
		        Notification.show( String.format( "Invalid Password!"));
		        return false;
		    } 
			else if (p.equals( password )) {
		        Notification.show( String.format( "Invalid Username "));
		        return false;
			}
			else {
				Notification.show( String.format( "Invalid Username & Password!"));
				return false;
			}
		}
		else{
			return false;
		}
	}*/
	
	public User getUser( String user_id) {
		this.connect();
		User user = null;
		try{
			String sql = "select * from users where userid=?";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.setString(1, user_id);

			ResultSet rs = ps.executeQuery();	
			
			if( rs.next( ) ) {
				
				user = new User();
				
				String userid = rs.getString(rs.findColumn("userid"));
				String name = rs.getString( rs.findColumn("name") );
				String surname = rs.getString( rs.findColumn("surname") ); 
				String email = rs.getString( rs.findColumn("email") );
				String phonenum = rs.getString( rs.findColumn("phonenum") );
				String hash_password = rs.getString( rs.findColumn("hash_password") );
				
				user.setUserId(userid);
				user.setName( name );
				user.setSurname( surname );
				user.setEmail( email );
				user.setPhoneNum( phonenum );
				user.setHashPassword( hash_password );
				
				System.out.printf("USER : %s\n", user );

			}	
			
		}catch ( Exception e ) {
			e.printStackTrace( );
		}
		this.closeConnection();
		return user;
		
	}
	
	public Session getSession( String course_code ){
			
		Session session = null;
		this.connect();
		try{
			String sql = "select * from sessions where COURSE_CODE=?";
			PreparedStatement ps = this.connection.prepareStatement(sql);
//			Statement s = this.connection.createStatement();
			ps.setString(1, course_code);
			ResultSet rs = ps.executeQuery();   //executeUpdate();
			if( rs.next() ){
//				System.out.println( "ROWS : ");
				int id = rs.getInt(rs.getInt(1));
				String courseCode = rs.getString(2);
				String date = rs.getString(3);
				String start_time = rs.getString(4);
				String end_time = rs.getString(5);
				String venue = rs.getString(6);
				String notes = rs.getString(7);
				session = new Session( id, courseCode, date, start_time, end_time, venue, notes );
			}
			ps.close();
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		this.closeConnection();
		return session;
		
	}
	
	 
    public static String hashString( String text ){
    	String res = null;
    	try{
    		MessageDigest md = MessageDigest.getInstance("SHA-256");

    	    // Change this to UTF-16 if needed
    	    md.update(text.getBytes(StandardCharsets.UTF_8));
    	    byte[] digest = md.digest();

    	    res = String.format("%064x", new BigInteger(1, digest));
//    	    System.out.println(hex);
    	}catch( Exception e ){
    		e.printStackTrace();
    	}
    	return res;	
    }
    
   public boolean userExist( ){
	   Boolean userExist = false;
   }

 
	public String getDatabaseName() {
		return this.databaseName;
	}
	
	public String getPassword( ) {
		return this.password;
	}
	
	public String getPhoneNumber( ) {
		return this.portNumber;
	}
}



/*
	public void firebase_Initilise(){
		try{
			FileInputStream serviceAccount = new FileInputStream("cryptoportal-7b3d0-firebase-adminsdk-75hxu-c650b059cf.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://cryptoportal-7b3d0.firebaseio.com")
					.build();
			
			FirebaseApp.initializeApp(options);
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	
	public void test() {
		
		System.out.printf("TEST\n");
		
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference();
		DatabaseReference users_ref = database.getReference( "users" ); // .equalTo("user_name1", "name");
//		database.equ
		
		
//		User user = new User("user_name3", "user_surname3", "user_email3", "user_password3", "user_studentNumber_3");
//		Map<String, User> user_map = new HashMap<>();
		
//		users_ref.child("somechild").
		
//		users_ref.setValue("users", null);
//		user_map.put( "user_1", user );
//		users_ref.child("user_3").setValueAsync(user);
//		users_ref.;
//		users_ref.;
//		users_ref.equ
//		users_ref.setValueAsync(user_map);
//		users.put("random", new User("reuben", "matlala", "reuben_email", "reuben_password", "reuben_studentnumber"));
		
		ref	.addValueEventListener(new ValueEventListener() {
		  @Override
		  public void onDataChange(DataSnapshot dataSnapshot) {
			  System.out.printf("dataSnapshot : %s" , dataSnapshot );
			  long children_count = dataSnapshot.getChildrenCount();
			  System.out.printf("CHILDREN_COUNT : %d\n", children_count);
			  User user = dataSnapshot.getValue(User.class);
			  System.out.printf("USERS : /%s/\n", user);
//			  Map<String, Object> td = (HashMap<String,Object>) dataSnapshot.getValue();
//			  Collection<Object> values = td.values();
//			  System.out.printf( "VALUES : /%s/\n", values );
		  }
		
		  @Override
		  public void onCancelled(DatabaseError databaseError) {
		    System.out.println("The read failed: " + databaseError.getCode());
		  }
		});
		
	}
	
	
	public boolean firease_authenticate( int userId ){
		
		boolean correct_credits = false;
		
		
		
		return correct_credits;
		
	}
	
	public void firebase_create_user( User user ){
	

	}
	// Firestore db = FirestoreClient.getFirestore();

	
	public User firebase_get_user( int userId ){
		
		User user = new User();
		
		try{
			FileInputStream serviceAccount = new FileInputStream("cryptoportal-7b3d0-firebase-adminsdk-75hxu-c650b059cf.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .setDatabaseUrl("https://cryptoportal-7b3d0.firebaseio.com")
			  .build();
			
			FirebaseApp.initializeApp(options);
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void firebase( ){
		
//		try{
//			CreateRequest request = new CreateRequest()
//				    .setEmail("user@example.com")
//				    .setEmailVerified(false)
//				    .setPassword("secretPassword")
//				    .setPhoneNumber("+11234567890")
//				    .setDisplayName("John Doe")
//				    .setPhotoUrl("http://www.example.com/12345678/photo.png")
//				    .setDisabled(false);
//
//			UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
//			System.out.println("Successfully created new user: " + userRecord.getUid());
//
////			UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail("");
//		}
//		catch( Exception e ) {
//			e.printStackTrace();
//		}

		try{
			
			FirebaseDatabase database = FirebaseDatabase.getInstance();
			DatabaseReference ref = database.getReference();
			DatabaseReference users_ref = database.getReference( "users" ); // .equalTo("user_name1", "name");
			
//			database.equ
			
//			User user = new User("user_name3", "user_surname3", "user_email3", "user_password3", "user_studentNumber_3");
//			Map<String, User> user_map = new HashMap<>();
			
//			users_ref.child("somechild").
			
//			users_ref.setValue("users", null);
//			user_map.put( "user_1", user );
//			users_ref.child("user_3").setValueAsync(user);
//			users_ref.;
//			users_ref.;
//			users_ref.equ
//			users_ref.setValueAsync(user_map);
//			users.put("random", new User("reuben", "matlala", "reuben_email", "reuben_password", "reuben_studentnumber"));
			
				users_ref.orderByChild("users").equalTo("user_name1").addValueEventListener(new ValueEventListener() {
				  @Override
				  public void onDataChange(DataSnapshot dataSnapshot) {
					  long children_count = dataSnapshot.getChildrenCount();
					  System.out.printf("CHILDREN_COUNT : %d\n", children_count);
					  User user = dataSnapshot.getValue(User.class);
					  System.out.printf("USERS : /%s/\n", user);
					  Map<String, Object> td = (HashMap<String,Object>) dataSnapshot.getValue();
					  Collection<Object> values = td.values();
					  System.out.printf( "VALUES : /%s/\n", values );
				  }
				
				  @Override
				  public void onCancelled(DatabaseError databaseError) {
				    System.out.println("The read failed: " + databaseError.getCode());
				  }
			});
			
				
//			FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//			FirebaseAuth mAuth;
//			mAuth = FirebaseAuth.getInstance();
//			FirebaseUser currentUser = mAuth.getCurrentUser();
//		    updateUI(currentUser)
//			Map<String, User> users = new HashMap<>();
//			users.put("random", new User("reuben", "matlala", "reuben_email", "reuben_password", "reuben_studentnumber"));
//			ref.setValueAsync(users);
			
			
			
			System.out.printf( "REF KEY : %s\n", ref.getKey( ) );
			
			
			
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
 */