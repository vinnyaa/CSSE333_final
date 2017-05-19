import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		frame.getContentPane().setBackground(Main.back_color);
		frame.setLocation(300, 200);
//		frame.setLayout(null);
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
		
		//QuestionID Field
		l = new JLabel("Enter QuestionID");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(l, c);
		
		idField = new JTextField();
		c.gridx = 1;
		myPanel.add(idField, c);
		
		//Points field
		l = new JLabel("Enter Points");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 1;
		myPanel.add(l, c);
		
		pointsField = new JTextField();
		c.gridx = 1;
		myPanel.add(pointsField, c);
		
		//prompt field
		l = new JLabel("Enter Prompt");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 2;
		myPanel.add(l, c);
		
		promptField = new JTextField();
		c.gridx = 1;
		c.gridy = 2;
		myPanel.add(promptField, c);
		
		//correct field
		l = new JLabel("Enter Correct Answer");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 3;
		myPanel.add(l, c);
			
		correctField = new JTextField();
		c.gridx = 1;
		myPanel.add(correctField, c);
		
		//option1 field
		l = new JLabel("Enter Option 1");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 4;
		myPanel.add(l, c);
			
		option1Field = new JTextField();
		c.gridx = 1;
		myPanel.add(option1Field, c);
		
		
		//option2 field
		l = new JLabel("Enter Option 2");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 5;
		myPanel.add(l, c);
			
		option2Field = new JTextField();
		c.gridx = 1;
		myPanel.add(option2Field, c);
		
		//option3 field
		l = new JLabel("Enter Option 3");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 6;
		myPanel.add(l, c);
			
		option3Field = new JTextField();
		c.gridx = 1;
		myPanel.add(option3Field, c);
		
		
		//option4 field
		l = new JLabel("Enter Option 4");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 7;
		myPanel.add(l, c);
			
		option4Field = new JTextField();
		c.gridx = 1;
		myPanel.add(option4Field, c);
						
		
		//buttons
		continueButton = new JButton("Continue Creating More Questions");
		c.gridx = 0;
		c.gridy = 8;
		myPanel.add(continueButton, c);
		
		completeButton = new JButton("Complete Assignment");
		c.gridx = 1;
		myPanel.add(completeButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);		
		frame.setVisible(true);
		frame.repaint();
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

		

