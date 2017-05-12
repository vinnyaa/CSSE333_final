import java.awt.BorderLayout;
import java.awt.Color;
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
	String username;
	String password;
	Boolean pressed = true;
	
	
	Gui() {
		
		frame = new JFrame("GradeBook Assistant Login");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		l = new JLabel("Enter User Name");
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setLocation(10,10);
		l.setSize(l.getPreferredSize());
		frame.add(l);
				
		field = new JTextField();
		field.setColumns(15);
		field.setSize(field.getPreferredSize());
		
		field.setLocation(150, 10);
		//field.setToolTipText("Enter User Name");
		frame.add(field);
		
		l = new JLabel("Enter Password");
		l.setLocation(10,40);
		l.setSize(l.getPreferredSize());
		frame.add(l);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		passwordField.setSize(passwordField.getPreferredSize());
		
		passwordField.setLocation(150, 40);
		//field.setToolTipText("Enter User Name");
		frame.add(passwordField);
		
		myButton = new JButton("OK");
		myButton.setSize(myButton.getPreferredSize());
		myButton.setLocation(150,80);
		frame.add(myButton);
		
		
		frame.setVisible(true);
		
		
		
		
	}
	
	
	public int getUserID(){
		return Integer.parseInt(field.getText());
	}
	
	public String getPass(){
		return passwordField.getText();
	}
	
	public boolean okNotPressed(){
		return pressed;
	}
	
	public JButton okButton(){
		return myButton;
	}


	
}