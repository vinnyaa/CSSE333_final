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

public class ProfessorGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton createAssignButton;
//	JButton assignmentHistoryButton;
	JButton viewAssignResultsButton;
	JPanel myPanel;
	String username;
	String password;
//	Boolean pressed = true;
	
	
	ProfessorGui() {
//		
//		frame = new JFrame("GradeBook Assistant - Professor");
//		frame.setSize(500, 370);
//		frame.getContentPane().setBackground(Color.orange);
//		frame.setLocation(300, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets.set(10, 10, 10, 10);
		c.anchor = GridBagConstraints.NORTHWEST; // Basically is it centered, align left/right, up/down
		c.weightx = 1; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = .65; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		
		myPanel = new JPanel(layout);

		c.gridx = 0;
		c.gridy = 0;
		JLabel jlal = new JLabel ("Please Choose an Option:");
		jlal.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(jlal, c);

		
		studSchedButton = new JButton("Student Schedule Lookup");
		c.gridx = 1;
		myPanel.add(studSchedButton, c);
		
//		studSchedButton.addActionListener(new ActionListener() {
//          @Override
//          public void actionPerformed(ActionEvent event)
//          {
//             System.out.println("Stu Schedule has been pressed");
//          }
//		
//		});
		
		profSchedButton = new JButton("Professor Schedule Lookup");
		c.gridy = 1;
		myPanel.add(profSchedButton, c);
		
//		profSchedButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             System.out.println("Prof Schedule has been pressed");
//	          }
//			
//			});
//		
		
		
		gradeReportButton = new JButton("Grade Report");
		c.gridy = 2;
		myPanel.add(gradeReportButton, c);
		
//		gradeReportButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             System.out.println("Grade report has been pressed");
//	          }
//			
//			});
		
		createAssignButton = new JButton("Create Assignment");
		c.gridy = 3;
		myPanel.add(createAssignButton, c);
//		
//		createAssignButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             CreateAssignmentGui createGui = new CreateAssignmentGui();
//	        	 //System.out.println("create assign has been pressed");
//	          }
//			
//			});
//		
		viewAssignResultsButton = new JButton("Assignment Results");
		c.gridy = 4;
		myPanel.add(viewAssignResultsButton, c);
		
//		viewAssignResultsButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             System.out.println("Complete assign has been pressed");
//	          }
//			
//			});
		
		
		
//		assignmentHistoryButton = new JButton("Assignment History");
//		c.gridy = 5;
//		myPanel.add(assignmentHistoryButton, c);
//		
//		assignmentHistoryButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             System.out.println("Assignment history has been pressed");
//	          }
//			
//			});
		
		myPanel.setOpaque(false);
//		frame.add(myPanel);
//		frame.repaint();
			
		
		
		
	}
	
	public JButton createButton(){
		return createAssignButton;
	}
	
	public JButton profGradeReportButton(){
		return gradeReportButton;
	}
	
	
	public JButton viewResultsButton(){
		return viewAssignResultsButton;
	}
	
	
	public JButton studentScheduleButton(){
		return studSchedButton;
	}
	
	public JButton professorScheduleButton(){
		return profSchedButton;
	}
	


	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
