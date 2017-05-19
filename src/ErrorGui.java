import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorGui {
	JPanel myPanel;
	String password;
	JLabel jlal;
	JFrame frame;
	JButton myButton;
	


	ErrorGui(String errorMessage) {
				
		frame = new JFrame("Error");
		frame.setSize(400, 200);
		frame.getContentPane().setBackground(Color.white);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.set(10, 10, 10, 10);
		c.anchor = GridBagConstraints.NORTHWEST; // Basically is it centered, align left/right, up/down
		c.weightx = 1; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = 1; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		
		myPanel = new JPanel(layout);
		
		c.gridx = 0;
		c.gridy = 0;
		jlal = new JLabel (errorMessage);
		Font ft = jlal.getFont();
		Font newfont = new Font(ft.getFontName(), ft.getStyle(), 30);
		jlal.setFont(newfont);
		jlal.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(jlal, c);

		
		myButton = new JButton("Okay");
		myButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             frame.dispose();
	             // TODO: Actually do something when we verify the password
	          }
			
			});
		c.gridy = 1;
		myPanel.add(myButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
	}
}