import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class MakePasswordGui {
	JPanel myPanel;
	private static JPasswordField passField;
	private static JPasswordField passField2;
	String username;
	String password;
	JLabel jlal;
	JFrame frame;
	JButton myButton;
	
	MakePasswordGui() {
		frame = new JFrame("Password Creation");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.set(10, 10, 10, 10);
		c.anchor = GridBagConstraints.NORTHWEST; // Basically is it centered, align left/right, up/down
		c.weightx = 1; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = .65; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		
		myPanel = new JPanel(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		jlal = new JLabel ("Please Enter A Password:");
		jlal.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(jlal, c);

		passField = new JPasswordField();
		c.gridx = 1;
		myPanel.add(passField, c);
		
		c.gridx = 0;
		c.gridy = 1;
		jlal = new JLabel ("Please Re-Enter Your Password:");
		jlal.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(jlal, c);

		passField2 = new JPasswordField();
		c.gridx = 1;
		myPanel.add(passField2, c);
		
		myButton = new JButton("Submit");
//		myButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             System.out.println(MakePasswordGui.getPassword());
//	             // TODO: Actually do something when we verify the password
//	          }
//			
//			});
		c.gridy = 2;
		myPanel.add(myButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public static String getPassword(){
		System.out.println(passField.hashCode());
		System.out.println(Arrays.toString(passField.getPassword()));
		if(Arrays.equals(passField.getPassword(), passField2.getPassword())) {
			return (Arrays.toString(passField.getPassword()));
		}
		return null;
	}
	
	public JButton getMyButton(){
		return myButton;
	}
}
