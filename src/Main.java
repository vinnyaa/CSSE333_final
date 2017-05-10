
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
	private static int assignmentID;
	private static StudentGui myStudentGui;
	private static ProfessorGui myProfessorGui = null;
	private static CreateAssignmentGui myCreateGui;
	private static CreateNewQuestionGui newQuestionGui;
	
	public static void main(String[] args) throws SQLException {  
	
		
		Gui myGui = new Gui();
		myGui.okButton().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event)
          {
             userID = myGui.getUserID();
             userPass = myGui.getPass();
             
            Connection myConnection = makeConnection();
			runUserLoginStatement(myConnection);
			
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

          }
		});
		
		
      
   }
	   
	   
   // repeatable function that runs the sql statement represented by the string
   // TODO: create a preprocessing string to secure SQL statement from attacks
   static void runUserLoginStatement(Connection con) {
	   CallableStatement stmt = null;  
	   ResultSet rs = null;
	   try {

		   	stmt = con.prepareCall("{call UserLogin(?,?)}");
			stmt.setInt(1, userID);
			stmt.setString(2, userPass);

			rs = stmt.executeQuery();

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
	        	  assignmentID = myCreateGui.getAssignmentID();
	        	  Connection myConnection = makeConnection();
	        	  runCreateAssignmentStatement(myConnection);
	        	  
	        	  newQuestionGui = new CreateNewQuestionGui();
	        	  handleCreateQuestion();
	          }
		});
	}
   

   static void runCreateAssignmentStatement(Connection con) {
	   CallableStatement stmt = null; 

	   try {

		   	stmt = con.prepareCall("{call CreateAssignment(?,?)}");
			stmt.setInt(1, userID);
			stmt.setInt(2, assignmentID);
			
			stmt.executeQuery();

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
	      System.out.println("Statement Completed: ");
	   }  
   }
   
   public static void handleCreateQuestion(){
	   newQuestionGui.getCompleteButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  System.out.println("Complete button pressed");
	          }
		});
	   newQuestionGui.getContinueButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  System.out.println("Continue button pressed");
	          }
		});
   }
   
   
}  