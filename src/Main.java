
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JButton;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


	
public class Main {  

	public static String username = "user=KLVGradebook37;";
	public static String password = "password=Database37;";
	public static String SQL = "exec testproc"; // TODO: Test sproc by putting string here
	private static int userID;
	private static String userPass;
	private static StudentGui myStudentGui;
	private static ProfessorGui myProfessorGui = null;
	private static CreateAssignmentGui myCreateGui;
	
	public static void main(String[] args) throws SQLException {  
//		System.out.println("Attempting to connect to KLV_Gradebook");
//		// Create a variable for the connection string.  
//		String connectionUrl = "jdbc:sqlserver://golem.csse.rose-hulman.edu:1433;" +  
//			"databaseName=KLV_Gradebook;"
//			+ username
//			+ password;  
//
//		// Declare the JDBC objects.  
//		Connection con = null;  
//
//		try {  
//			// Establish the connection.  
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//			con = DriverManager.getConnection(connectionUrl);  
//			System.out.println("connection established");
//		} 	 
//
//		catch (Exception e) {  
//			e.printStackTrace();  
//		}  
		
		
//		Scanner input = new Scanner(System.in);
//		
//		String username;
//		String password;
//		
//		System.out.println("Log in:");
//		System.out.println("username: ");
//		username = input.next();
//		
//		System.out.println("password: ");
//		password = input.next();
		
		
		Gui myGui = new Gui();
		myGui.okButton().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event)
          {
             userID = myGui.getUserID();
             userPass = myGui.getPass();
             
            Connection myConnection = makeConnection();
             
//     		CallableStatement stmt;
     		
			//SQL = ("EXEC UserLogin @UserID_1 = " + userID);
			runStatement(myConnection);
			
//				stmt = myConnection.prepareCall("{call UserLogin(?,?)}");
//				stmt.setInt(1, userID);
//	    		stmt.setString(2, userPass);
//	    		stmt.execute();
			
	        myStudentGui = new StudentGui();
	        myProfessorGui = new ProfessorGui();
	        myProfessorGui.createButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  myCreateGui = new CreateAssignmentGui();
		        	  createAssignmentButtonPressed(myCreateGui.continueButton());
		        	          	  
		          }
			});
	        
	        
	        
			if (myConnection != null) try { myConnection.close(); } catch(Exception e) {}
			System.out.println("Connection Terminated");
    		
    		
    	//	runStatement(SQL, con);
          }
		});
		
		
		
		
		
		
		
		
		

		
//		SQL = "exec "
		
//		while (myGui.okNotPressed() == true){
//			System.out.print ("");
//		}
//		
//		String username = myGui.getUser();
//		String password = myGui.getPass();
		
//		System.out.print(username);
		
		

		
//		try{
		//SQL = ("EXEC UserLogin @UserID_1 = " + Integer.parseInt(username));
//		}
//		catch (Exception e){
//			System.out.print("here");
//		}
		

//              
//		if (con != null) try { con.close(); } catch(Exception e) {}
//		System.out.println("Connection Terminated");
      
   }
	   
	   
   // repeatable function that runs the sql statement represented by the string
   // TODO: create a preprocessing string to secure SQL statement from attacks
   static void runStatement(Connection con) {
	   CallableStatement stmt = null;  
	   ResultSet rs = null;
	   try {
//		   stmt = con.createStatement();  
		   	stmt = con.prepareCall("{call UserLogin(?,?)}");
//		   							ResultSet.TYPE_FORWARD_ONLY,
		   							//ResultSet.CONCUR_READ_ONLY, userID);
//		   							ResultSet.CLOSE_CURSORS_AT_COMMIT);
			stmt.setInt(1, userID);
			stmt.setString(2, userPass);
			//stmt.registerOutParameter(3, java.sql.Types.NVARCHAR);
			System.out.println("anything error");
			rs = stmt.executeQuery();
			
		//	String x = rs.getString(1);
			
	
			
			
			
			
//			System.out.println(rs.getObject(3));
			//System.out.println(rs.getMetaData());
//		   
		   
	      // rs = stmt.executeQuery(arg); 
	       if(!(rs == null)) {
		       int col_label_count = rs.getMetaData().getColumnCount();
		       System.out.println(col_label_count);
			   for (int i = 1; i <= col_label_count; i++){
			        System.out.print(rs.getMetaData().getColumnLabel(i) + "\t");
		        }
		        System.out.println("\b");
		         while (rs.next()) {  
		        	 for (int i = 1; i <= col_label_count; i++){
		 		        System.out.print(rs.getString(i) + "\t");
		 	        }
		 	        System.out.println("\b");
		         }  
	       }
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}  
	      if (rs != null) try { con.close(); } catch(Exception e) {}  
	      System.out.println("Statement Completed: ");
	   }  
   }
   
   // TODO: check for special characters and make sure that no attacks happen
   String secure_string(String arg) {
	   System.out.println("Test for special characters in the string here");
	   return arg;
   }
   
   public static Connection makeConnection(){
	   System.out.println("Attempting to connect to KLV_Gradebook");
		// Create a variable for the connection string.  
		String connectionUrl = "jdbc:sqlserver://golem.csse.rose-hulman.edu:1433;" +  
			"databaseName=KLV_Gradebook;"
			+ username
			+ password;  

		// Declare the JDBC objects.  
		Connection con = null;  

		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			System.out.println("connection established");
			return con;
		} 	 

		catch (Exception e) {  
			e.printStackTrace();  
		}  
		
		return null;
   }
   
   public static void createAssignmentButtonPressed(JButton myButton){
		myButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  
	        	  System.out.print(myCreateGui.getAssignmentID());
	          }
		});
	}
   
   
}  