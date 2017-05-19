import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.UserDataHandler;

public class CompleteAssignmentGui {

	JFrame frame; //frame
	JButton submitAnswerButton;
	JLabel promptLabel; //used for printing on frame
//	JTextField answerField;
	JTextField courseIdField;
	JPanel myPanel;
	JComboBox<Integer> assignmentIdBox;
	JComboBox<Integer> questionIdBox;
	JComboBox<Integer> answerBox;
	ArrayList<Integer> assignID;
	ArrayList<Integer> questID;
	ArrayList<Integer> answerNumber;
	ArrayList<String> answerText;
	JLabel currentAnswerLabel;
	String username;
	String password;
	Boolean pressed = true;
	
	CompleteAssignmentGui() {
		frame = new JFrame("Complete Assignment");
		frame.setSize(700, 200);
		frame.getContentPane().setBackground(Main.back_color);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL; // only expand horizontally to fill grid
		c.anchor = GridBagConstraints.CENTER; // Basically is it centered, align left/right, up/down
		c.insets.set(10, 10, 10, 10);
		c.weightx = .4; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = 1; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		c.gridwidth = 1;
		
		myPanel = new JPanel(layout);
				
		// jlabel for assignment id
		promptLabel = new JLabel("Assignment ID");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(promptLabel,c);
		
		// jlabel for question id
		promptLabel = new JLabel("Question ID");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 1;
		myPanel.add(promptLabel,c);
		
		// jlabel for answer to question
		promptLabel = new JLabel("Answer to question");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 2;
		myPanel.add(promptLabel,c);
		
		// jcombobox for assignment id
		// TODO: query should happen here to get assignment id's
		
		assignmentIdBox = new JComboBox<Integer>();
		assignmentIdBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Use a cases statement to activate a query to find all 
				// questions in an assignment 
				makeQuestionArray();
				
			}
		});
		c.gridx = 0;
		c.gridy = 1;
		myPanel.add(assignmentIdBox,c);
		
		// jcombobox for question id
//		String[] expampleQuestionIDs = {"question", "id", "strings", "go", "here"};
		
		questionIdBox = new JComboBox<Integer>();
		questionIdBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Use a cases statement to activate a query to find all 
				// answers in an assignment 
				showQuestion();

				makeAnswerArray(); // doesn't work
				
			}
		});
		c.gridx = 1;
		c.gridy = 1;
		myPanel.add(questionIdBox,c);
		
		
		// jtextfield or jcombobox for answer to the question????
		answerBox = new JComboBox<Integer>();
		answerBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerBox.getSelectedIndex() == -1) return;
				currentAnswerLabel.setText(answerText.get(answerBox.getSelectedIndex()));
				
			}
		});
		c.gridx = 2;
		c.gridy = 1;
		myPanel.add(answerBox,c);
		
		// hidden jlabel for showing the prompt
		promptLabel = new JLabel("Prompt appears here");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 1;
		c.gridy = 2;
		myPanel.add(promptLabel,c);
		
		// jbutton for showing the prompt
		currentAnswerLabel = new JLabel("Current Answer Appears Here");
		currentAnswerLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 2;
		c.gridy = 2;
		myPanel.add(currentAnswerLabel,c);
		
		
		// jbutton for submitting the answer
		submitAnswerButton = new JButton("Submit Answer");
		submitAnswerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: inset code here to send the current answer to the 
				// database if it's valid
				submitAnswer();
				
				
				
			}
		});
		c.gridy = 2;
		c.gridx = 0;
		myPanel.add(submitAnswerButton,c);
		
		makeAssignmentArray();
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
	}
	
	private void makeAssignmentArray(){
		Connection con = Main.makeConnection();
		CallableStatement stmt = null;
		assignID = new ArrayList<Integer>();
		assignmentIdBox.removeAllItems();
		try {

		   	stmt = con.prepareCall("{call GetAssignments(?)}");
			stmt.setInt(1, Main.userID);
			ResultSet rs = stmt.executeQuery();			
			
			if(!(rs == null)) {
				int col_label_count = rs.getMetaData().getColumnCount();
		         while (rs.next()) {  
		        	 for (int i = 1; i <= col_label_count; i++){
		 		        assignID.add(rs.getInt(i));
		 	        }
		         }  
	       }
			
//			System.out.println("OUTPUT ARRAY of assignments: " + assignID.toString());

	       
		} catch (Exception e) {
		   e.printStackTrace();
	   	} finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
//	      System.out.println("Statement Completed: ");
	   	}  
		for(int i = 0; i < assignID.size(); i++) {
			assignmentIdBox.addItem(assignID.get(i));
		}
	}
	
	private void makeQuestionArray(){
		if(assignmentIdBox.getSelectedIndex() < 0) return;
		Connection con = Main.makeConnection();
		CallableStatement stmt = null;
		questID = new ArrayList<Integer>();
		questionIdBox.removeAllItems();
		try {

		   	stmt = con.prepareCall("{call GetQuestions(?,?)}");
		   	stmt.setInt(1, Main.userID);
			stmt.setInt(2, assignID.get(assignmentIdBox.getSelectedIndex()));
			ResultSet rs = stmt.executeQuery();			
			
			if(!(rs == null)) {
//				int col_label_count = rs.getMetaData().getColumnCount();
		         while (rs.next()) {  
	 		        questID.add(rs.getInt(1));
		         }  
	       }
			
//			System.out.println("OUTPUT ARRAY of questions: " + questID.toString());

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
//	      System.out.println("Statement Completed: ");
	   }
		for(int i = 0; i < questID.size(); i++) {
			questionIdBox.addItem(questID.get(i));
		}
	}
	
	private void makeAnswerArray(){
		if(assignmentIdBox.getSelectedIndex() < 0 || questionIdBox.getSelectedIndex() < 0) return;
		Connection con = Main.makeConnection();
		CallableStatement stmt = null;
		answerBox.removeAllItems();
		answerNumber = new ArrayList<Integer>();
		answerText = new ArrayList<String>();
		try {

		   	stmt = con.prepareCall("{call GetChoices(?,?)}");
			stmt.setInt(1, assignID.get(assignmentIdBox.getSelectedIndex()));
			stmt.setInt(2, questID.get(questionIdBox.getSelectedIndex()));
			ResultSet rs = stmt.executeQuery();			
//			System.out.println(rs.getMetaData().getColumnName(1));
//			System.out.println(rs.getMetaData().getColumnName(2));
			if(!(rs == null)) {
//				int col_label_count = rs.getMetaData().getColumnCount();
				
//				System.out.println(rs.getMetaData().getColumnCount());
		         while (rs.next()) {  
		        	 answerText.add(rs.getString(2));
		        	 answerNumber.add(rs.getInt(1));
		         }
	       }
			
//			System.out.println("OUTPUT ARRAY of answers:numbers " + answerText.toString() + ":" + answerNumber.toString());

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
//	      System.out.println("Statement Completed: ");
	   }
		for(int i = 0; i < answerNumber.size(); i++) {
			answerBox.addItem(answerNumber.get(i));
		}
	}
	
	private void showQuestion() {
		if(assignmentIdBox.getSelectedIndex() < 0 || questionIdBox.getSelectedIndex() < 0) return;
		Connection con = Main.makeConnection();
		CallableStatement stmt = null;
		try {
		   	stmt = con.prepareCall("{call GetPrompt(?,?)}");
			stmt.setInt(1, assignID.get(assignmentIdBox.getSelectedIndex()));
			stmt.setInt(2, questID.get(questionIdBox.getSelectedIndex()));
			ResultSet rs = stmt.executeQuery();
			rs.next();
//			System.out.println("Prompt: " + rs.getString(1));
			promptLabel.setText(rs.getString(1));

	       
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
	      if (stmt != null) try { con.close(); } catch(Exception e) {}   
//	      System.out.println("Statement Completed: ");
	   }
	}
	
	private void submitAnswer() {
		Connection con = Main.makeConnection();
		CallableStatement stmt = null;
		try {
		   	stmt = con.prepareCall("{call AnswerQuestion(?,?,?,?)}");
			stmt.setInt(1, assignID.get(assignmentIdBox.getSelectedIndex()));
			stmt.setInt(2, questID.get(questionIdBox.getSelectedIndex()));
			stmt.setInt(3, Main.userID);
			stmt.setInt(4, answerNumber.get(answerBox.getSelectedIndex()));
			stmt.execute();
		}
		 catch (Exception e) {
			   e.printStackTrace();
		   } finally {
		      if (stmt != null) try { con.close(); } catch(Exception e) {}   
//		      System.out.println("Statement Completed: ");
		   }  
	}
	
}
