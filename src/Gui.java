import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui {
	
	JFrame frame; //frame
	JTextField field;
	JPasswordField passwordField;
	JLabel l; //used for printing on frame
	JButton myButton;
	JPanel myPanel;
	String username;
	String password;
//	Boolean pressed = true;
	
	
	Gui() {
		
		frame = new JFrame("GradeBook Assistant Login");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Main.back_color);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.set(10, 10, 10, 10);
		c.anchor = GridBagConstraints.NORTHWEST; // Basically is it centered, align left/right, up/down
		c.weightx = .8; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = .65; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		
		myPanel = new JPanel(layout);
		
		c.weightx = .3;
		c.gridx = 0;
		c.gridy = 0;
		l = new JLabel("Enter User Name");
		l.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(l,c);
				
		c.gridx = 0;
		c.gridy = 1;
		l = new JLabel("Enter Password");
		l.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(l,c);
		
		c.gridy = 0;
		c.gridx = 1;
		field = new JTextField();	
		myPanel.add(field, c);
		
		c.gridy = 1;
		passwordField = new JPasswordField();		
		myPanel.add(passwordField, c);
		
		c.gridx = 1;
		c.gridy = 2;
		myButton = new JButton("OK");
		myPanel.add(myButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		
		
		
		
	}
	
	
	public int getUserID(){
		return Integer.parseInt(field.getText());
	}
	
	public int getPass(){
		
		if (passwordField.getText().equals("")){
			return -1;
		}
		else
			return Integer.parseInt(passwordField.getText());
	}
	
//	public boolean okNotPressed(){
//		return pressed;
//	}
	
	public JButton okButton(){
		return myButton;
	}


	
}