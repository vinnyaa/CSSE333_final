import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

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
		frame.setSize(400, 150);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		// GridBayLayout() (GBL) just creates the layout manager that
		// we are passing to the jpanel when we make the jpanel
		GridBagLayout layout = new GridBagLayout();
		
		// A GBL needs to have constraints for every item added
		// to the panel
		GridBagConstraints c = new GridBagConstraints();
		
		// these variables are defaults we want to use for all 
		// additions to the jpanel
		c.fill = GridBagConstraints.HORIZONTAL; // only expand horizontally to fill grid
		c.anchor = GridBagConstraints.CENTER; // Basically is it centered, align left/right, up/down
		c.weightx = .4; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = 1; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		c.gridwidth = 1;
		
		JPanel myPanel = new JPanel(layout);
		
		l = new JLabel("Enter Assignment");
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(l,c);
				
		assignmentID = new JTextField();
		c.gridx = 1;
		c.gridy = 0;
		myPanel.add(assignmentID,c);
				
		l = new JLabel("Enter Section");
		c.gridx = 0;
		c.gridy = 1;
		myPanel.add(l,c);
		
		sectionID = new JTextField();
		c.gridx = 1;
		c.gridy = 1;
		myPanel.add(sectionID,c);
		
		completeButton = new JButton("Done");
		c.gridx = 1;
		c.gridy = 2;
		myPanel.add(completeButton,c);
				
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
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

		

