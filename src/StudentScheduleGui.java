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

public class StudentScheduleGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField studentIdField;
	JTextField courseIdField;
	JPanel myPanel;
	JButton myButton;
	String username;
	String password;
	Boolean pressed = true;
	
	
	StudentScheduleGui() {
		
		frame = new JFrame("Student Schedule Lookup");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//course ID field
		l = new JLabel("Student ID");
		l.setLocation(10,10);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		studentIdField = new JTextField();
		studentIdField.setColumns(15);
		studentIdField.setSize(studentIdField.getPreferredSize());
		
		studentIdField.setLocation(150, 10);
		//field.setToolTipText("Enter User Name");
		frame.add(studentIdField);
		
		//section ID field
		l = new JLabel("Course ID (Optional)");
		l.setLocation(10,40);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		courseIdField = new JTextField();
		courseIdField.setColumns(15);
		courseIdField.setSize(courseIdField.getPreferredSize());
		
		courseIdField.setLocation(150, 40);
		//field.setToolTipText("Enter User Name");
		frame.add(courseIdField);
		
		myButton = new JButton("Continue");
		myButton.setSize(myButton.getPreferredSize());
		myButton.setLocation(150,80);
		frame.add(myButton);
		
		
		
		frame.setVisible(true);
	}
	
	public int getStudentID(){
		return Integer.parseInt(studentIdField.getText());
	}
	
	public int getCourseID(){
		if (courseIdField.getText().equals("")){
			return -1;
		}
		else
		return Integer.parseInt(courseIdField.getText());
	}
	
	public JButton continueButton(){
		return myButton;
	}
	
}

		

