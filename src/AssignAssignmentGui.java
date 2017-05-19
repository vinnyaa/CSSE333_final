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

public class AssignAssignmentGui {
	
	JFrame frame; //frame
//	JButton studSchedButton;
//	JButton profSchedButton;
//	JButton gradeReportButton;
//	JButton completeAssignButton;
//	JButton assignmentHistoryButton;
	JLabel l; //used for printing on frame
	JTextField idField;
	JPanel myPanel;
	JButton completeButton;
	JButton continueButton;
	String username;
	String password;
//	Boolean pressed = true;
	
	
	AssignAssignmentGui() {
		
		frame = new JFrame("Assign Assignment to Section");
		frame.setSize(500, 200);
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
		
		l = new JLabel("Enter Section");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(l, c);
				
		idField = new JTextField();
		c.gridx = 1;
		myPanel.add(idField, c);
		
		continueButton = new JButton("Assign to More Sections");
		c.gridx = 0;
		c.gridy = 1;
		myPanel.add(continueButton, c);
		
		completeButton = new JButton("Complete Assigning Sections");
		c.gridx = 1;
		myPanel.add(completeButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
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

		

