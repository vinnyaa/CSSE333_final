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

public class ProfessorScheduleGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField professorIdField;
	JTextField courseIdField;
	JPanel myPanel;
	JButton myButton;
	String username;
	String password;
	Boolean pressed = true;
	
	
	ProfessorScheduleGui() {
		
		frame = new JFrame("Professor Schedule Lookup");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
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
		
		//course ID field
		l = new JLabel("Professor ID");
		l.setHorizontalAlignment(JLabel.CENTER);
//		l.setLocation(10,10);
//		l.setSize(l.getPreferredSize());
//		frame.add(l);
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(l,c);
				
		professorIdField = new JTextField();
//		professorIdField.setColumns(15);
//		professorIdField.setSize(professorIdField.getPreferredSize());
		
//		professorIdField.setLocation(150, 10);
		//field.setToolTipText("Enter User Name");
//		frame.add(professorIdField);
		c.gridx = 1;
		c.gridy = 0;
		myPanel.add(professorIdField,c);
		
		//section ID field
		l = new JLabel("Course ID (Optional)");
		l.setHorizontalAlignment(JLabel.CENTER);
//		l.setLocation(10,40);
//		l.setSize(l.getPreferredSize());
//		frame.add(l);
		c.gridx = 0;
		c.gridy = 1;
		myPanel.add(l,c);
				
		courseIdField = new JTextField();
//		courseIdField.setColumns(15);
//		courseIdField.setSize(courseIdField.getPreferredSize());
		
//		courseIdField.setLocation(150, 40);
		//field.setToolTipText("Enter User Name");
//		frame.add(courseIdField);
		c.gridx = 1;
		c.gridy = 1;
		myPanel.add(courseIdField,c);
		
		myButton = new JButton("Continue");
//		myButton.setSize(myButton.getPreferredSize());
//		myButton.setLocation(150,80);
//		frame.add(myButton);
		c.gridx = 1;
		c.gridy = 2;
		myPanel.add(myButton,c);
		
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public int getProfessorID(){
		return Integer.parseInt(professorIdField.getText());
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

		

