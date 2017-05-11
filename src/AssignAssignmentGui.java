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

public class AssignAssignmentGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField idField;
	JPanel myPanel;
	JButton completeButton;
	JButton continueButton;
	String username;
	String password;
	Boolean pressed = true;
	
	
	AssignAssignmentGui() {
		
		frame = new JFrame("GradeBook Assistant");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l = new JLabel("Enter Section");
		l.setLocation(10,10);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		idField = new JTextField();
		idField.setColumns(15);
		idField.setSize(idField.getPreferredSize());
		
		idField.setLocation(150, 10);
		//field.setToolTipText("Enter User Name");
		frame.add(idField);
		
		continueButton = new JButton("Assign to More Sections");
		continueButton.setSize(continueButton.getPreferredSize());
		continueButton.setLocation(150,80);
		frame.add(continueButton);
		
		completeButton = new JButton("Complete Assigning Sections");
		completeButton.setSize(completeButton.getPreferredSize());
		completeButton.setLocation(150,120);
		frame.add(completeButton);
				
		frame.setVisible(true);
	}
	
	public int getSectionID(){
		return Integer.parseInt(idField.getText());
	}
	
	public JButton getContinueButton(){
		return continueButton;
	}
	
	public JButton getCompleteButton(){
		return completeButton;
	}

	
}

		

