import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompleteAssignmentGui {

	JFrame frame; //frame
	JButton submitAnswerButton;
	JLabel promptLabel; //used for printing on frame
//	JTextField answerField;
	JTextField courseIdField;
	JPanel myPanel;
	JComboBox assignmentIdBox;
	JComboBox questionIdBox;
	JComboBox answerBox;
	JButton promptButton;
	String username;
	String password;
	Boolean pressed = true;
	
	CompleteAssignmentGui() {
		frame = new JFrame("Complete Assignment");
		frame.setSize(700, 200);
		frame.getContentPane().setBackground(Color.orange);
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
				
		// jlabel for assignment id
		promptLabel = new JLabel("Assignment ID");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		myPanel.add(promptLabel,c);
		
		// jlabel for question id
		promptLabel = new JLabel("Question ID");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 1;
		myPanel.add(promptLabel,c);
		
		// jlabel for answer to question
		promptLabel = new JLabel("Answer to question");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 2;
		myPanel.add(promptLabel,c);
		
		// jcombobox for assignment id
		// TODO: query should happen here to get assignment id's
		String[] expampleAssignIDs = {"assign", "id", "strings", "go", "here"};
		assignmentIdBox = new JComboBox<String>(expampleAssignIDs);
		assignmentIdBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Use a cases statement to activate a query to find all 
				// questions in an assignment 
				
			}
		});
		c.gridx = 0;
		c.gridy = 1;
		myPanel.add(assignmentIdBox,c);
		
		// jcombobox for question id
		String[] expampleQuestionIDs = {"question", "id", "strings", "go", "here"};
		questionIdBox = new JComboBox<String>(expampleQuestionIDs);
		questionIdBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Use a cases statement to activate a query to find all 
				// answers in an assignment 
				
			}
		});
		c.gridx = 1;
		c.gridy = 1;
		myPanel.add(questionIdBox,c);
		
		// jtextfield or jcombobox for answer to the question????
		String[] expampleAnswers = {"Answers:", "textfield?", "or", "Combobox?", "here"};
		answerBox = new JComboBox<String>(expampleAnswers);
		answerBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Yeah we might not have to do much here. 
				
			}
		});
		c.gridx = 2;
		c.gridy = 1;
		myPanel.add(answerBox,c);
		
		// hidden jlabel for showing the prompt
		promptLabel = new JLabel("Prompt appears here");
		promptLabel.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 2;
		myPanel.add(promptLabel,c);
		
		// jbutton for showing the prompt
		promptButton = new JButton("Show prompt");
		promptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: retrieve the question's prompt and the answers
				// for the answerBox
				
			}
		});
		c.gridx = 1;
		myPanel.add(promptButton,c);
		
		
		// jbutton for submitting the answer
		submitAnswerButton = new JButton("Sumbit Answer");
		submitAnswerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: inset code here to send the current answer to the 
				// database if it's valid
				
			}
		});
		c.gridy = 2;
		c.gridx = 2;
		myPanel.add(submitAnswerButton,c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		frame.repaint();
	}
}
