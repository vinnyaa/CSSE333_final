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

public class CreateAssignmentGui {
	
	JFrame frame; //frame
	JLabel l; //used for printing on frame
	JTextField idField;
	JPanel myPanel;
	JButton myButton;
	String username;
	String password;
	
	
	CreateAssignmentGui() {
		
		frame = new JFrame("Create Assignment");
		frame.setSize(500, 150);
		frame.getContentPane().setBackground(Main.back_color);
		frame.setLocation(300, 200);
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
		
		l = new JLabel("Enter AssignmentID");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(l, c);
				
		idField = new JTextField();
		c.gridx = 1;
		myPanel.add(idField, c);
		
		
		myButton = new JButton("Continue");
		c.gridy = 1;
		myPanel.add(myButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);		
		frame.setVisible(true);
		frame.repaint();
	}
	
	public int getAssignmentID(){
		return Integer.parseInt(idField.getText());
	}
	
	public JButton continueButton(){
		return myButton;
	}
	
}

		

