import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	JButton assignmentHistoryButton;
	JButton viewAssignResultsButton;
	JPanel myPanel;
	String username;
	String password;
	Boolean pressed = true;
	
	
	ProfessorGui() {
		
		frame = new JFrame("GradeBook Assistant - Professor");
		frame.setSize(250, 300);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		myPanel = new JPanel();

		frame.add(myPanel, BorderLayout.CENTER);
		myPanel.add(new JLabel ("Please Choose an Option"));

		
		studSchedButton = new JButton("Student Schedule Lookup");
		studSchedButton.setSize(studSchedButton.getPreferredSize());
		myPanel.add(studSchedButton, BorderLayout.CENTER);
		
		studSchedButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event)
          {
             System.out.println("Stu Schedule has been pressed");
          }
		
		});
		
		profSchedButton = new JButton("Professor Schedule Lookup");
		profSchedButton.setSize(profSchedButton.getPreferredSize());
		myPanel.add(profSchedButton, BorderLayout.CENTER);
		
		profSchedButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Prof Schedule has been pressed");
	          }
			
			});
		
		
		
		gradeReportButton = new JButton("Grade Report");
		gradeReportButton.setSize(gradeReportButton.getPreferredSize());
		myPanel.add(gradeReportButton, BorderLayout.CENTER);
		
//		gradeReportButton.addActionListener(new ActionListener() {
//	          @Override
//	          public void actionPerformed(ActionEvent event)
//	          {
//	             System.out.println("Grade report has been pressed");
//	          }
//			
//			});
		
		createAssignButton = new JButton("Create Assignment");
		createAssignButton.setSize(createAssignButton.getPreferredSize());
		myPanel.add(createAssignButton, BorderLayout.CENTER);
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
		viewAssignResultsButton.setSize(viewAssignResultsButton.getPreferredSize());
		myPanel.add(viewAssignResultsButton, BorderLayout.CENTER);
		
		viewAssignResultsButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Complete assign has been pressed");
	          }
			
			});
		
		
		
		assignmentHistoryButton = new JButton("Assignment History");
		assignmentHistoryButton.setSize(assignmentHistoryButton.getPreferredSize());
		myPanel.add(assignmentHistoryButton, BorderLayout.CENTER);
		
		assignmentHistoryButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Assignment history has been pressed");
	          }
			
			});
		
		frame.repaint();
			
		
		
		
	}
	
	public JButton createButton(){
		return createAssignButton;
	}
	
	public JButton profGradeReportButton(){
		return gradeReportButton;
	}
	


	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
