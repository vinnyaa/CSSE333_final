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
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField idField;
	JTextField pointsField;
	JTextField promptField;
	JTextField correctField;
	JTextField option1Field;
	JTextField choice1Field;
	JTextField option2Field;
	JTextField choice2Field;
	JPanel myPanel;
	JButton myButton;
	String username;
	String password;
	Boolean pressed = true;
	
	
	CreateNewQuestionGui() {
		
		frame = new JFrame("New Question");
		frame.setSize(500, 400);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
//		//choice1 field
//		l = new JLabel("Enter Choice 1");
//		l.setLocation(10,160);
//		l.setSize(l.getPreferredSize());
//		frame.add(l);
//			
//		choice1Field = new JTextField();
//		choice1Field.setColumns(15);
//		choice1Field.setSize(choice1Field.getPreferredSize());
//					
//		choice1Field.setLocation(150, 160);
//		frame.add(choice1Field);
		
		//option2 field
		l = new JLabel("Enter Option 2");
		l.setLocation(10,190);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		option2Field = new JTextField();
		option2Field.setColumns(15);
		option2Field.setSize(option2Field.getPreferredSize());
					
		option2Field.setLocation(150, 190);
		frame.add(option2Field);
		
		//choice2 field
		l = new JLabel("Enter Choice 2");
		l.setLocation(10,220);
		l.setSize(l.getPreferredSize());
		frame.add(l);
			
		choice2Field = new JTextField();
		choice2Field.setColumns(15);
		choice2Field.setSize(choice2Field.getPreferredSize());
					
		choice1Field.setLocation(150, 220);
		frame.add(choice2Field);
		
		
		
		
		
		
		myButton = new JButton("Complete Assignment");
		myButton.setSize(myButton.getPreferredSize());
		myButton.setLocation(150,250);
		frame.add(myButton);
		
		
		
		frame.setVisible(true);
	}
	
	public int getAssignmentID(){
		return Integer.parseInt(idField.getText());
	}
	
	public JButton continueButton(){
		return myButton;
	}
	
}

		

