
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


	
public class Main {  

	public static String username = "user=KLVGradebook37;";
	public static String password = "password=Database37;";
	public static String SQL = "exec testproc"; // TODO: Test sproc by putting string here
	static int userID;
	private static String userPassword;
	private static int assignmentID;
	private static Gui myGui;
	private static StudentGui myStudentGui;
	private static ProfessorGui myProfessorGui = null;
	private static CreateAssignmentGui myCreateGui;
	private static CreateNewQuestionGui newQuestionGui;
	private static ProfessorGradeReportGui myProfGradeReport;
	private static StudentGradeReportGui myStuGradeReport;
	private static AssignAssignmentGui myAssignAssignment;
	private static ViewAssignmentResultsGui myAssignmentResultsGui;
	private static StudentScheduleGui myStudentSchedule;
	private static ProfessorScheduleGui myProfessorSchedule;
	private static MakePasswordGui myPassGui;
	public static Color back_color = Color.orange;
   // The salt (probably) can be stored along with the encrypted data
   static byte[] salt = new String("12345678").getBytes();

   // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
   static int iterationCount = 40000;
   // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
  static int keyLength = 128;
  static String keyPassword;
  static SecretKeySpec key;
  
	public enum Mode {
	    LOGIN,
	    STUDENT,
	    PROFESSOR
	}
	private static Mode mode = Mode.LOGIN;
	
	public static void main(String[] args) throws SQLException, GeneralSecurityException, IOException {  
		   keyPassword = "password";

	       key = createSecretKey(keyPassword.toCharArray(),
	               salt, iterationCount, keyLength);
       
		myGui = new Gui();
	
		myGui.okButton().addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event)
          {
             userID = myGui.getUserID();
             try {
				userPassword = myGui.getPass();
			} catch (UnsupportedEncodingException | GeneralSecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

             
             
            Connection myConnection = makeConnection();
			String userType = runUserLoginStatement(myConnection);
			
			if (userType.equals("invalid password")){
				ErrorGui myErrorGui = new ErrorGui("Incorrect Password");
				return;
			}
			if (userType.equals("invalid username")){
				ErrorGui myErrorGui = new ErrorGui("Incorrect Username");
				return;
			}
			
			if (userType.equals("professor")){
				myProfessorGui = new ProfessorGui();
				Main.switchToProfessorGui();
				
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
		        myProfessorGui.studentScheduleButton().addActionListener(new ActionListener() {
			          @Override
			          public void actionPerformed(ActionEvent event)
			          {
			        	  myStudentSchedule = new StudentScheduleGui();
			        	  studentScheduleLookup(myStudentSchedule);
			          }
				});
		        myProfessorGui.professorScheduleButton().addActionListener(new ActionListener() {
			          @Override
			          public void actionPerformed(ActionEvent event)
			          {
			        	  myProfessorSchedule = new ProfessorScheduleGui();
			        	  professorScheduleLookup(myProfessorSchedule);
			          }
				});
			}
			else{
		        myStudentGui = new StudentGui();
		        Main.switchToStudentGui();
			    
			        myStudentGui.studGradeReportButton().addActionListener(new ActionListener() {
				          @Override
				          public void actionPerformed(ActionEvent event)
				          {
				        	  myStuGradeReport = new StudentGradeReportGui();
				        	  studentGradeReport(myStuGradeReport.continueButton(), myStuGradeReport);
				          }
					});
			        
			        myStudentGui.studentScheduleButton().addActionListener(new ActionListener() {
				          @Override
				          public void actionPerformed(ActionEvent event)
				          {
				        	  myStudentSchedule = new StudentScheduleGui();
				        	  studentScheduleLookup(myStudentSchedule);
				          }
					});
			        myStudentGui.professorScheduleButton().addActionListener(new ActionListener() {
				          @Override
				          public void actionPerformed(ActionEvent event)
				          {
				        	  myProfessorSchedule = new ProfessorScheduleGui();
				        	  professorScheduleLookup(myProfessorSchedule);
				          }
					});
					myStudentGui.completeAssignmentButton().addActionListener(new ActionListener() {
			          @Override
			          public void actionPerformed(ActionEvent event)
			          {
			             CompleteAssignmentGui assignGui = new CompleteAssignmentGui();
			          }
					
					});
			}
			

			if (myConnection != null) try { myConnection.close(); } catch(Exception e) {}

          }
		});
		
		
      
   }
	   
	
	static void switchToStudentGui() {
		back_color = Color.green;
		myGui.frame.remove(myGui.myPanel);
        myGui.frame.add(myStudentGui.myPanel);
        myGui.frame.setTitle("GradeBook Assistant - Student");
        myGui.frame.setSize(500,260);
		myGui.frame.getContentPane().setBackground(Main.back_color);
        myGui.frame.repaint();
	}
	
	static void switchToProfessorGui() {
		back_color = Color.red;
		myGui.frame.remove(myGui.myPanel);
        myGui.frame.add(myProfessorGui.myPanel);
        myGui.frame.setTitle("GradeBook Assistant - Professor");
        myGui.frame.setSize(500,370);
		myGui.frame.getContentPane().setBackground(Main.back_color);
        myGui.frame.repaint();
	}
	
	static void switchToLoginGui() {
		back_color = Color.orange;
		if(mode == Mode.STUDENT) {
			myGui.frame.remove(myStudentGui.myPanel);
		} else if (mode == Mode.PROFESSOR){
			myGui.frame.remove(myGui.myPanel);
		}
		myGui.frame.getContentPane().setBackground(Main.back_color);

	}
	
	
	   
   // repeatable function that runs the sql statement represented by the string
   // TODO: CHANGE PASSWORD TO A INTEGER.PARSEINT();
   static String runUserLoginStatement(Connection con) {
	   CallableStatement stmt = null;  
	   ResultSet rs = null;
	   
	   try {

		   	stmt = con.prepareCall("{call UserLogin(?,?,?,?,?,?)}");
			stmt.setInt(1, userID);		
			
			
			if (!(userPassword.equals("null pass")))
				stmt.setString(2, userPassword);
			else
				stmt.setString(2, "null");
			
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(6, java.sql.Types.VARCHAR);

			stmt.execute();
			System.out.println(stmt.getString(3));
			System.out.println(stmt.getString(4));
			System.out.println(stmt.getString(5));
			System.out.println(stmt.getString(6));
			
			if (stmt.getString(6).equals("User Not Found")){
				return "invalid username";
			}
			if (stmt.getString(4).equals("t")){
				myPassGui = new MakePasswordGui();
				makePassword(myPassGui);
			}
			else{
				if (!(decrypt((stmt.getString(5)), key).equals(decrypt(userPassword, key)))){
					return "invalid password";
				}
			}
			

			return stmt.getString(3);


	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}  
	      if (rs != null) try { con.close(); } catch(Exception e) {}  

	   }
	   return null;
 
   }
   
   // TODO: check for special characters and make sure that no attacks happen
   String secure_string(String arg) {
//	   System.out.println("Test for special characters in the string here");
	   return arg;
   }
   
   public static Connection makeConnection(){
//	   System.out.println("Attempting to connect to KLV_Gradebook");
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
			
			stmt.execute();

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
	   }  
   }
   
   public static void handleCreateQuestion(){
	   newQuestionGui.getCompleteButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  Connection myConnection = makeConnection();
	        	  runCreateQuestionStatement(myConnection, newQuestionGui.getIdField(), newQuestionGui.getPointsField(),
	        			  					newQuestionGui.getPromptField(), newQuestionGui.getCorrectField(), 
	        			  					newQuestionGui.getOption1Field(), newQuestionGui.getOption2Field(),
	        			  					newQuestionGui.getOption3Field(), newQuestionGui.getOption4Field());
	        	  AssignAssignmentGui myAssignAssignment = new AssignAssignmentGui();
	        	  handleAssignSection(myAssignAssignment, myCreateGui.getAssignmentID());
	          }
		});
	   newQuestionGui.getContinueButton().addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	        	  Connection myConnection = makeConnection();
	        	  runCreateQuestionStatement(myConnection, newQuestionGui.getIdField(), newQuestionGui.getPointsField(),
	        			  					newQuestionGui.getPromptField(), newQuestionGui.getCorrectField(), 
	        			  					newQuestionGui.getOption1Field(), newQuestionGui.getOption2Field(),
	        			  					newQuestionGui.getOption3Field(), newQuestionGui.getOption4Field());
	        	  newQuestionGui = new CreateNewQuestionGui();
	        	  handleCreateQuestion();
	          }
		});
   }
   
   static void runCreateQuestionStatement(Connection con, int id, int points, String prompt, int correct, String op1, String op2, String op3, String op4) {
	   
	   CallableStatement stmt = null; 



	   try {

		   	stmt = con.prepareCall("{call CreateQuestion(?,?,?,?,?,?,?,?,?,?)}");
			stmt.setInt(1, userID);
			stmt.setInt(2, assignmentID);
		   	stmt.setInt(3, id);
			stmt.setInt(4, points);
			stmt.setString(5, prompt);
			stmt.setInt(6, correct);
			stmt.setString(7, op1);
			stmt.setString(8, op2);
			stmt.setString(9, op3);
			stmt.setString(10, op4);
			stmt.execute();

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
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
	   String resultString = "";

	   try {

		   	stmt = con.prepareCall("{call ProfessorGradeReport(?,?,?)}");
			stmt.setInt(1, userID);
			
			if (-1 != course)
				stmt.setInt(2, course);
			else
				stmt.setInt(2, -1);
			
			if (-1 != section)
				stmt.setInt(3, section);
			else
				stmt.setInt(3, -1);
			

			rs = stmt.executeQuery();
			
			if(!(rs == null)) {
			       int col_label_count = rs.getMetaData().getColumnCount();
			       // start try
			       ArrayList<Object> results = new ArrayList<Object>();
			       ArrayList<Object> meta_results = new ArrayList<Object>();
			       
			       System.out.println(col_label_count);
			       ArrayList<String> headers = new ArrayList<String>();
			       // end try
				   for (int i = 1; i <= col_label_count; i++){
				        resultString = resultString + (rs.getMetaData().getColumnLabel(i) + "\t");
				        headers.add(rs.getMetaData().getColumnLabel(i));
			        }
			        resultString = resultString + "\n";;
			         while (rs.next()) { 
			        	results = new ArrayList<Object>();

			        	 for (int i = 1; i <= col_label_count; i++){
			 		        resultString = resultString + (rs.getString(i) + "\t");
			 		        results.add(rs.getString(i));
			 	        }
			        	meta_results.add(results);
			 	        resultString = resultString + "\n";;
			         }
			         System.out.println(headers.toString());
			         System.out.println(meta_results.toString());
			         Object[] header_array = new Object[headers.size()];
			         header_array = headers.toArray(header_array);
			         Object[][] results_array = new Object[meta_results.size() + 1][results.size()];
			         results_array[0] = header_array;
			         for (int i = 0; i < meta_results.size(); i++) {
			        	 String[] thing = new String[((ArrayList<String>) meta_results.get(i)).size()];
			        	 thing = ((ArrayList<String>) meta_results.get(i)).toArray(thing);
			        	 results_array[i + 1] = thing;
			         }
			         JTable la_table = new JTable(results_array, header_array);
			         la_table.setGridColor(back_color);
			         OutputScreenGui myOutput = new OutputScreenGui();
//			         myOutput.addToFrame(resultString);
			         myOutput.addTableToFrame(la_table);
		       }

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
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
		   String resultString = "";
	
		   try {
	
			   	stmt = con.prepareCall("{call AssignSectionAssignments(?,?,?)}");
				stmt.setInt(1, userID);
			    stmt.setInt(2, section);
			    stmt.setInt(3, assignment);
	
				stmt.execute();
				
		       
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
		   String resultString = "";
	
		   try {
	
			   	stmt = con.prepareCall("{call ViewResultsOfAssignment(?,?,?)}");
				stmt.setInt(1, userID);
			    stmt.setInt(2, section);
			    stmt.setInt(3, assignment);
	
				rs = stmt.executeQuery();
				
				if(!(rs == null)) {
					
				}
				
				if(!(rs == null)) {
				       int col_label_count = rs.getMetaData().getColumnCount();
					   for (int i = 1; i <= col_label_count; i++){
					        resultString = resultString + (rs.getMetaData().getColumnLabel(i) + "\t");
				        }
				        resultString = resultString + "\n";;
				         while (rs.next()) {  
				        	 for (int i = 1; i <= col_label_count; i++){
				 		        resultString = resultString + (rs.getString(i) + "\t");
				 	        }
				 	        resultString = resultString + "\n";;
				         } 
				         OutputScreenGui myOutput = new OutputScreenGui();
				         myOutput.addToFrame(resultString);
			       }
	
		       
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
		      if (stmt != null) try { con.close(); } catch(Exception e) {}   
		   }  
	   }
	
	   public static void studentGradeReport(JButton myButton, StudentGradeReportGui myGui){
			myButton.addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  Connection myConnection = makeConnection();
		        	  runStudentGradeReport(myConnection, myGui.getCourseID());
		        	  
		          }
			});
		}
	   
	   static void runStudentGradeReport(Connection con, int course) {
		   
		   CallableStatement stmt = null; 
		   ResultSet rs = null;
		   String resultString = "";

		   try {

			   	stmt = con.prepareCall("{call StudentGradeReport(?,?,?)}");
				stmt.setInt(1, userID);

				if (-1 != course)
					stmt.setInt(2, course);
				else
					stmt.setInt(2, -1);
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				

				rs = stmt.executeQuery();
				
				if(!(rs == null)) {
				       int col_label_count = rs.getMetaData().getColumnCount();
				       // start try
				       ArrayList<Object> results = new ArrayList<Object>();
				       ArrayList<Object> meta_results = new ArrayList<Object>();
				       
				       System.out.println(col_label_count);
				       ArrayList<String> headers = new ArrayList<String>();
				       // end try
					   for (int i = 1; i <= col_label_count; i++){
					        resultString = resultString + (rs.getMetaData().getColumnLabel(i) + "\t");
					        headers.add(rs.getMetaData().getColumnLabel(i));
				        }
				        resultString = resultString + "\n";;
				         while (rs.next()) { 
				        	results = new ArrayList<Object>();

				        	 for (int i = 1; i <= col_label_count; i++){
				 		        resultString = resultString + (rs.getString(i) + "\t");
				 		        results.add(rs.getString(i));
				 	        }
				        	meta_results.add(results);
				 	        resultString = resultString + "\n";;
				         }
				         System.out.println(headers.toString());
				         System.out.println(meta_results.toString());
				         Object[] header_array = new Object[headers.size()];
				         header_array = headers.toArray(header_array);
				         Object[][] results_array = new Object[meta_results.size() + 1][results.size()];
				         results_array[0] = header_array;
				         for (int i = 0; i < meta_results.size(); i++) {
				        	 String[] thing = new String[((ArrayList<String>) meta_results.get(i)).size()];
				        	 thing = ((ArrayList<String>) meta_results.get(i)).toArray(thing);
				        	 results_array[i + 1] = thing;
				         }
				         JTable la_table = new JTable(results_array, header_array);
				         la_table.setGridColor(back_color);
				         OutputScreenGui myOutput = new OutputScreenGui();
//				         myOutput.addToFrame(resultString);
				         myOutput.addTableToFrame(la_table);
			       }

		       
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
		      if (stmt != null) try { con.close(); } catch(Exception e) {}   
		   }  
	   }
	   
	   public static void studentScheduleLookup(StudentScheduleGui myGui){
			myGui.continueButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  Connection myConnection = makeConnection();
		        	  runStudentScheduleLookup(myConnection, myGui.getStudentID(), myGui.getCourseID());
		        	  
		          }
			});
		}
	   
	   static void runStudentScheduleLookup(Connection con, int studentID, int courseID) {
		   
		   CallableStatement stmt = null; 
		   ResultSet rs = null;
		   String resultString = "";

		   try {

			   	stmt = con.prepareCall("{call StudentSchedule(?,?)}");
				stmt.setInt(1, studentID);
				if (-1 != courseID)
					stmt.setInt(2, courseID);
				else
					stmt.setInt(2, -1);

				rs = stmt.executeQuery();
				
				if(!(rs == null)) {
				       int col_label_count = rs.getMetaData().getColumnCount();
				       // start try
				       ArrayList<Object> results = new ArrayList<Object>();
				       ArrayList<Object> meta_results = new ArrayList<Object>();
				       
				       System.out.println(col_label_count);
				       ArrayList<String> headers = new ArrayList<String>();
				       // end try
					   for (int i = 1; i <= col_label_count; i++){
					        resultString = resultString + (rs.getMetaData().getColumnLabel(i) + "\t");
					        headers.add(rs.getMetaData().getColumnLabel(i));
				        }
				        resultString = resultString + "\n";;
				         while (rs.next()) { 
				        	results = new ArrayList<Object>();

				        	 for (int i = 1; i <= col_label_count; i++){
				 		        resultString = resultString + (rs.getString(i) + "\t");
				 		        results.add(rs.getString(i));
				 	        }
				        	meta_results.add(results);
				 	        resultString = resultString + "\n";;
				         }
				         System.out.println(headers.toString());
				         System.out.println(meta_results.toString());
				         Object[] header_array = new Object[headers.size()];
				         header_array = headers.toArray(header_array);
				         Object[][] results_array = new Object[meta_results.size() + 1][results.size()];
				         results_array[0] = header_array;
				         for (int i = 0; i < meta_results.size(); i++) {
				        	 String[] thing = new String[((ArrayList<String>) meta_results.get(i)).size()];
				        	 thing = ((ArrayList<String>) meta_results.get(i)).toArray(thing);
				        	 results_array[i + 1] = thing;
				         }
				         JTable la_table = new JTable(results_array, header_array);
				         la_table.setGridColor(back_color);
				         OutputScreenGui myOutput = new OutputScreenGui();
//				         myOutput.addToFrame(resultString);
				         myOutput.addTableToFrame(la_table);
			       }

		       
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
		      if (stmt != null) try { con.close(); } catch(Exception e) {}   
		   }  
	   }
	   
	   public static void professorScheduleLookup(ProfessorScheduleGui myGui){
			myGui.continueButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  Connection myConnection = makeConnection();
		        	  runProfessorScheduleLookup(myConnection, myGui.getProfessorID(), myGui.getCourseID());
		        	  
		          }
			});
		}
	   
	   static void runProfessorScheduleLookup(Connection con, int professorID, int courseID) {
		   
		   CallableStatement stmt = null; 
		   ResultSet rs = null;
		   String resultString = "";

		   try {

			   	stmt = con.prepareCall("{call ProfessorSchedule(?,?)}");
				stmt.setInt(1, professorID);
				
				if (-1 != courseID)
					stmt.setInt(2, courseID);
				else
					stmt.setInt(2, -1);

				rs = stmt.executeQuery();
				
				if(!(rs == null)) {
				       int col_label_count = rs.getMetaData().getColumnCount();
				       // start try
				       ArrayList<Object> results = new ArrayList<Object>();
				       ArrayList<Object> meta_results = new ArrayList<Object>();
				       
				       System.out.println(col_label_count);
				       ArrayList<String> headers = new ArrayList<String>();
				       // end try
					   for (int i = 1; i <= col_label_count; i++){
					        resultString = resultString + (rs.getMetaData().getColumnLabel(i) + "\t");
					        headers.add(rs.getMetaData().getColumnLabel(i));
				        }
				        resultString = resultString + "\n";;
				         while (rs.next()) { 
				        	results = new ArrayList<Object>();

				        	 for (int i = 1; i <= col_label_count; i++){
				 		        resultString = resultString + (rs.getString(i) + "\t");
				 		        results.add(rs.getString(i));
				 	        }
				        	meta_results.add(results);
				 	        resultString = resultString + "\n";;
				         }
				         System.out.println(headers.toString());
				         System.out.println(meta_results.toString());
				         Object[] header_array = new Object[headers.size()];
				         header_array = headers.toArray(header_array);
				         Object[][] results_array = new Object[meta_results.size() + 1][results.size()];
				         results_array[0] = header_array;
				         for (int i = 0; i < meta_results.size(); i++) {
				        	 String[] thing = new String[((ArrayList<String>) meta_results.get(i)).size()];
				        	 thing = ((ArrayList<String>) meta_results.get(i)).toArray(thing);
				        	 results_array[i + 1] = thing;
				         }
				         JTable la_table = new JTable(results_array, header_array);
				         la_table.setGridColor(back_color);
				         OutputScreenGui myOutput = new OutputScreenGui();
//				         myOutput.addToFrame(resultString);
				         myOutput.addTableToFrame(la_table);
			       }

		       
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
		      if (stmt != null) try { con.close(); } catch(Exception e) {}   
		   }  
	   }
	   
	   public static void makePassword(MakePasswordGui myGui){
		   
			myGui.getMyButton().addActionListener(new ActionListener() {
		          @Override
		          public void actionPerformed(ActionEvent event)
		          {
		        	  Connection myConnection = makeConnection();
		        	  try {
		        		if (myGui.getPassword().equals("invalid")){
		        			ErrorGui myErrorGui = new ErrorGui("Passwords do not match");
		        		}
		        		else{
						runMakePassword(myConnection, myGui.getPassword());
		        		}
					} catch (NumberFormatException | UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (GeneralSecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	  
		          }
			});
		}
	   
	   static void runMakePassword(Connection con, String newPassword) {
		   
		   CallableStatement stmt = null; 
		   ResultSet rs = null;
		   String resultString = "";

		   try {

			   	stmt = con.prepareCall("{call CreatePassword(?,?)}");
				stmt.setInt(1, userID);
				stmt.setString(2, newPassword);

				stmt.execute();

		       
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
		      if (stmt != null) try { con.close(); } catch(Exception e) {}   
		   }  
	   }
	   


   private static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
       PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
       SecretKey keyTmp = keyFactory.generateSecret(keySpec);
       return new SecretKeySpec(keyTmp.getEncoded(), "AES");
   }

   private static String encrypt(String property, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
       Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
       pbeCipher.init(Cipher.ENCRYPT_MODE, key);
       AlgorithmParameters parameters = pbeCipher.getParameters();
       IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
       byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
       byte[] iv = ivParameterSpec.getIV();
       return base64Encode(iv) + ":" + base64Encode(cryptoText);
   }

   private static String base64Encode(byte[] bytes) {
       return Base64.getEncoder().encodeToString(bytes);
   }

   private static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
       String iv = string.split(":")[0];
       String property = string.split(":")[1];
       Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
       pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
       return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
   }

   private static byte[] base64Decode(String property) throws IOException {
       return Base64.getDecoder().decode(property);
   }
	   

   
   
}  