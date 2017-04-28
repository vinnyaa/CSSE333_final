
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

	
public class Main {  

	public static String username = "user=KLVGradebook37;";
	public static String password = "password=Database37;";
	public static String SQL = "exec testproc"; // TODO: Test sproc by putting string here
	
	public static void main(String[] args) {  
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
		} 	 

		catch (Exception e) {  
			e.printStackTrace();  
		}  
		runStatement(SQL, con);
              
		if (con != null) try { con.close(); } catch(Exception e) {}
		System.out.println("Connection Terminated");
      
   }
	   
	   
   // repeatable function that runs the sql statement represented by the string
   // TODO: create a preprocessing string to secure SQL statement from attacks
   static void runStatement(String arg, Connection con) {
	   Statement stmt = null;  
	   ResultSet rs = null;
	   try {
		   stmt = con.createStatement();  
	       rs = stmt.executeQuery(arg); 
	       if(!(rs == null)) {
		       int col_label_count = rs.getMetaData().getColumnCount();
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
	      System.out.println("Statement Completed: " + arg);
	   }  
   }
   
   // TODO: check for special characters and make sure that no attacks happen
   String secure_string(String arg) {
	   System.out.println("Test for special characters in the string here");
	   return arg;
   }
}  