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

public class CreateAssignmentGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField idField;
	JPanel myPanel;
	JButton myButton;
	String username;
	String password;
	Boolean pressed = true;
	
	
	CreateAssignmentGui() {
		
		frame = new JFrame("GradeBook Assistant");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l = new JLabel("Enter AssignmentID");
		l.setLocation(10,10);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		idField = new JTextField();
		idField.setColumns(15);
		idField.setSize(idField.getPreferredSize());
		
		idField.setLocation(150, 10);
		//field.setToolTipText("Enter User Name");
		frame.add(idField);
		
		myButton = new JButton("Continue");
		myButton.setSize(myButton.getPreferredSize());
		myButton.setLocation(150,80);
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

		

