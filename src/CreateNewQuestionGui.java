import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateNewQuestionGui {
	
	JFrame frame; //frame
//	JButton studSchedButton;
//	JButton profSchedButton;
//	JButton gradeReportButton;
//	JButton completeAssignButton;
//	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField idField;
	JTextField pointsField;
	JTextField promptField;
	JTextField correctField;
	JTextField option1Field;
	JTextField option2Field;
	JTextField option3Field;
	JTextField option4Field;
	JPanel myPanel;
	JButton completeButton;
	JButton continueButton;
	String username;
	String password;
//	Boolean pressed = true;
	
	
	CreateNewQuestionGui() {
		
		frame = new JFrame("Create New Question");
		frame.setSize(500, 400);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//QuestionID Field
		l = new JLabel("Enter QuestionID");
		l.setLocation(10,10);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		idField = new JTextField();
		idField.setColumns(15);
		idField.setSize(idField.getPreferredSize());
		
		idField.setLocation(150, 10);
		frame.add(idField);
		
		//Points field
		l = new JLabel("Enter Points");
		l.setLocation(10,40);
		l.setSize(l.getPreferredSize());
		frame.add(l);
		
		pointsField = new JTextField();
		pointsField.setColumns(15);
		pointsField.setSize(pointsField.getPreferredSize());
		
		pointsField.setLocation(150, 40);
		frame.add(pointsField);
		
		//prompt field
		l = new JLabel("Enter Prompt");
		l.setLocation(10,70);
		l.setSize(l.getPreferredSize());
		frame.add(l);
		
		promptField = new JTextField();
		promptField.setColumns(15);
		promptField.setSize(promptField.getPreferredSize());
		
		promptField.setLocation(150, 70);
		frame.add(promptField);

		//correct field
		l = new JLabel("Enter Correct Answer");
		l.setLocation(10,100);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		correctField = new JTextField();
		correctField.setColumns(15);
		correctField.setSize(correctField.getPreferredSize());
					
		correctField.setLocation(150, 100);
		frame.add(correctField);
		
		//option1 field
		l = new JLabel("Enter Option 1");
		l.setLocation(10,130);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		option1Field = new JTextField();
		option1Field.setColumns(15);
		option1Field.setSize(option1Field.getPreferredSize());
					
		option1Field.setLocation(150, 130);
		frame.add(option1Field);
		
		
		//option2 field
		l = new JLabel("Enter Option 2");
		l.setLocation(10,160);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		option2Field = new JTextField();
		option2Field.setColumns(15);
		option2Field.setSize(option2Field.getPreferredSize());
					
		option2Field.setLocation(150, 160);
		frame.add(option2Field);
		
		//option3 field
		l = new JLabel("Enter Option 3");
		l.setLocation(10,190);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		option3Field = new JTextField();
		option3Field.setColumns(15);
		option3Field.setSize(option3Field.getPreferredSize());
					
		option3Field.setLocation(150, 190);
		frame.add(option3Field);
		
		
		//option4 field
		l = new JLabel("Enter Option 4");
		l.setLocation(10,210);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		option4Field = new JTextField();
		option4Field.setColumns(15);
		option4Field.setSize(option4Field.getPreferredSize());
					
		option4Field.setLocation(150, 210);
		frame.add(option4Field);
				
		
		//buttons
		continueButton = new JButton("Continue Creating More Questions");
		continueButton.setSize(continueButton.getPreferredSize());
		continueButton.setLocation(150,240);
		frame.add(continueButton);
		
		completeButton = new JButton("Complete Assignment");
		completeButton.setSize(completeButton.getPreferredSize());
		completeButton.setLocation(150,270);
		frame.add(completeButton);
		
		
		frame.setVisible(true);
	}

	
	
	public int getIdField() {
		return Integer.parseInt(idField.getText());
	}
	
	public int getPointsField() {
		return Integer.parseInt(pointsField.getText());
	}

	public String getPromptField() {
		return promptField.getText();
	}

	public int getCorrectField() {
		return Integer.parseInt(correctField.getText());
	}

	public String getOption1Field() {
		return option1Field.getText();
	}

	public String getOption2Field() {
		return option2Field.getText();
	}
	

	public String getOption3Field() {
		return option3Field.getText();
	}

	public String getOption4Field() {
		return option4Field.getText();
	}
	
	
	
	
	public JButton getCompleteButton(){
		return completeButton;
	}
	
	public JButton getContinueButton(){
		return continueButton;
	}
	
}

		

