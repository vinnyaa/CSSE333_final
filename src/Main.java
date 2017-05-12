
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
	private static ProfessorGradeReportGui myProfGradeReport;
	private static AssignAssignmentGui myAssignAssignment;
	private static ViewAssignmentResultsGui myAssignmentResultsGui;
	
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
	        myGui.frame.remove(myGui.myPanel);
	        myGui.frame.add(myStudentGui.myPanel);
	        myGui.frame.setTitle("GradeBook Assistant - Student");
	        myGui.frame.setSize(500,300);
	        myGui.frame.repaint();
	        myProfessorGui = new ProfessorGui();
	        myProfessorGui.createButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  myCreateGui = new CreateAssignmentGui();
		        	  createAssignmentButtonPressed(myCreateGui.continueButton());
		        	          	  
		          }
			});
	        myProfessorGui.profGradeReportButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  myProfGradeReport = new ProfessorGradeReportGui();
		        	  professorGradeReport(myProfGradeReport.continueButton(), myProfGradeReport);
		          }
			});
	        myProfessorGui.viewResultsButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  myAssignmentResultsGui = new ViewAssignmentResultsGui();
		        	  assignmentResults(myAssignmentResultsGui);
		          }
			});
	        
	        
	        
			if (myConnection != null) try { myConnection.close(); } catch(Exception e) {}
			System.out.println("Connection Terminated");

          }
		});
		
		
      
   }
	   
	   
   // repeatable function that runs the sql statement represented by the string
   // TODO: CHANGE PASSWORD TO A INTEGER.PARSEINT();
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
	        	  Connection myConnection = makeConnection();
	        	  runCreateQuestionStatement(myConnection, newQuestionGui.getIdField(), newQuestionGui.getPointsField(),
	        			  					newQuestionGui.getPromptField(), newQuestionGui.getCorrectField(), 
	        			  					newQuestionGui.getOption1Field(), newQuestionGui.getOption2Field());
	        	  AssignAssignmentGui myAssignAssignment = new AssignAssignmentGui();
	        	  handleAssignSection(myAssignAssignment, myCreateGui.getAssignmentID());
	          }
		});
	   newQuestionGui.getContinueButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  System.out.println("Continue button pressed");
	        	  Connection myConnection = makeConnection();
	        	  runCreateQuestionStatement(myConnection, newQuestionGui.getIdField(), newQuestionGui.getPointsField(),
	        			  					newQuestionGui.getPromptField(), newQuestionGui.getCorrectField(), 
	        			  					newQuestionGui.getOption1Field(), newQuestionGui.getOption2Field());
	        	  newQuestionGui = new CreateNewQuestionGui();
	        	  handleCreateQuestion();
	          }
		});
   }
   
   static void runCreateQuestionStatement(Connection con, int id, int points, String prompt, int correct, int op1, int op2) {
	   
	   CallableStatement stmt = null; 



	   try {

		   	stmt = con.prepareCall("{call CreateQuestion(?,?,?,?,?,?,?,?)}");
			stmt.setInt(1, userID);
			stmt.setInt(2, assignmentID);
		   	stmt.setInt(3, id);
			stmt.setInt(4, points);
			stmt.setString(5, prompt);
			stmt.setInt(6, correct);
			stmt.setInt(7, op1);
			stmt.setInt(8, op2);
			
			stmt.executeQuery();

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
	      System.out.println("Statement Completed: ");
	   }  
   }
   
   public static void professorGradeReport(JButton myButton, ProfessorGradeReportGui myGui){
		myButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  Connection myConnection = makeConnection();
	        	  runProfGradeReport(myConnection, myGui.getCourseID(), myGui.getSectionID());
	        	  
	          }
		});
	}
   
   static void runProfGradeReport(Connection con, int course, int section) {
	   
	   CallableStatement stmt = null; 
	   ResultSet rs = null;

	   try {

		   	stmt = con.prepareCall("{call ProfessorGradeReport(?,?,?)}");
			stmt.setInt(1, userID);
			
			if (-1 != course)
				stmt.setInt(2, course);
			else
				stmt.setNull(2, java.sql.Types.INTEGER);
			
			if (-1 != section)
				stmt.setInt(3, section);
			else
				stmt.setNull(3, java.sql.Types.INTEGER);
			

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
	      System.out.println("Statement Completed: ");
	   }  
   }
   
   public static void handleAssignSection(AssignAssignmentGui myGui,int assignID){
	   myGui.getCompleteButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  Connection myConnection = makeConnection();
	        	  runAssignSectionStatement(myConnection, myGui.getSectionID(), assignID);

	          }
		});
	   myGui.getContinueButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  Connection myConnection = makeConnection();
	        	  runAssignSectionStatement(myConnection, myGui.getSectionID(), assignID);
	        	  AssignAssignmentGui newGui = new AssignAssignmentGui();
	        	  handleAssignSection(newGui, assignID);  
	        	  
	          }
		});
   }
   
	static void runAssignSectionStatement(Connection con, int section, int assignment) {
		   
		   CallableStatement stmt = null; 
		   ResultSet rs = null;
	
		   try {
	
			   	stmt = con.prepareCall("{call AssignSectionAssignments(?,?,?)}");
				stmt.setInt(1, userID);
			    stmt.setInt(2, section);
			    stmt.setInt(3, assignment);
	
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
		      System.out.println("Statement Completed: ");
		   }  
	   }

	public static void assignmentResults(ViewAssignmentResultsGui myGui){
		   myGui.getCompleteButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  Connection myConnection = makeConnection();
		        	  runResultsStatement(myConnection, myGui.getSectionID(), myGui.getAssignmentID());
	
		          }
			});

	}
	static void runResultsStatement(Connection con, int section, int assignment) {
		   
		   CallableStatement stmt = null; 
		   ResultSet rs = null;
	
		   try {
	
			   	stmt = con.prepareCall("{call ViewResultsOfAssignment(?,?,?)}");
				stmt.setInt(1, userID);
			    stmt.setInt(2, section);
			    stmt.setInt(3, assignment);
	
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
		      System.out.println("Statement Completed: ");
		   }  
	   }

   
   
}  