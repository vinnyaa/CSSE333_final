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

public class ViewAssignmentResultsGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField assignmentID;
	JTextField sectionID;
	JPanel myPanel;
	JButton completeButton;
	String username;
	String password;
	Boolean pressed = true;
	
	
	ViewAssignmentResultsGui() {
		
		frame = new JFrame("GradeBook Assistant");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l = new JLabel("Enter Assignment");
		l.setLocation(10,10);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		assignmentID = new JTextField();
		assignmentID.setColumns(15);
		assignmentID.setSize(assignmentID.getPreferredSize());
		
		assignmentID.setLocation(150, 10);
		//field.setToolTipText("Enter User Name");
		frame.add(assignmentID);
		
		l = new JLabel("Enter Assignment");
		l.setLocation(10,40);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		sectionID = new JTextField();
		sectionID.setColumns(15);
		sectionID.setSize(sectionID.getPreferredSize());
		
		assignmentID.setLocation(150, 40);
		//field.setToolTipText("Enter User Name");
		frame.add(sectionID);
		
		
		completeButton = new JButton("Done");
		completeButton.setSize(completeButton.getPreferredSize());
		completeButton.setLocation(150,120);
		frame.add(completeButton);
				
		frame.setVisible(true);
	}
	
	public int getAssignmentID(){
		return Integer.parseInt(assignmentID.getText());
	}
	
	public int getSectionID(){
		return Integer.parseInt(sectionID.getText());
	}
	

	public JButton getCompleteButton(){
		return completeButton;
	}

	
}

		

