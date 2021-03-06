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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OutputScreenGui {
	
	JFrame frame; //frame
	JTextField field;
	JPasswordField passwordField;
	public static JTextArea l; //used for printing on frame
	public static JPanel myPanel;
	String username;
	String password;
	public static GridBagConstraints c;

	
	
	OutputScreenGui() {
		
		frame = new JFrame("Gradebook Assistant");
		frame.setSize(600, 400);
		frame.getContentPane().setBackground(Main.back_color);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
		GridBagLayout layout = new GridBagLayout();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.set(10, 10, 10, 10);
		c.anchor = GridBagConstraints.NORTHWEST; // Basically is it centered, align left/right, up/down
		c.weightx = .8; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = .65; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		
		myPanel = new JPanel(layout);
		
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		
		
		
		
	}
	

	
	public static void addToFrame(String s){
		
		c.weightx = .3;
		c.gridx = 0;
		c.gridy = 0;
		l = new JTextArea(s);
		l.setBackground(Main.back_color);
		myPanel.add(l,c);
		
		
	}
	
	public static void addTableToFrame(JTable jt) {
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(jt,c);
		
	}
	



	
}