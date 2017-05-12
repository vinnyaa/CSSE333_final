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

public class StudentGui {
	
	JFrame frame; //frame
	JButton studSchedButton;
	JButton profSchedButton;
	JButton gradeReportButton;
	JButton completeAssignButton;
	JButton assignmentHistoryButton;
	JPanel myPanel;
	String username;
	String password;
	Boolean pressed = true;
	
	
	StudentGui() {
		
//		frame = new JFrame("GradeBook Assistant - Student");
//		frame.setSize(500, 300);
//		frame.getContentPane().setBackground(Color.orange);
//		frame.setLocation(300, 200);
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
		
		studSchedButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent event)
          {
             System.out.println("Stu Schedule has been pressed");
          }
		
		});
		
		profSchedButton = new JButton("Professor Schedule Lookup");
		c.gridy = 1;
		myPanel.add(profSchedButton, c);
		
		profSchedButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Prof Schedule has been pressed");
	          }
			
			});
		
		
		
		gradeReportButton = new JButton("Grade Report");
		c.gridy = 2;
		myPanel.add(gradeReportButton, c);
		
		gradeReportButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Grade report has been pressed");
	          }
			
			});
		
		completeAssignButton = new JButton("Complete Assignment");
		c.gridy = 3;
		myPanel.add(completeAssignButton, c);
		
		completeAssignButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Complete assign has been pressed");
	          }
			
			});
		
		
		assignmentHistoryButton = new JButton("Assignment History");
		c.gridy = 4;
		myPanel.add(assignmentHistoryButton, c);
		
		assignmentHistoryButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Assignment history has been pressed");
	          }
			
			});
		
//		c.gridx = 2;
//		c.gridy = 5;
//		myPanel.add(new JLabel(""), c);
//		
		
		//nah
		myPanel.setOpaque(false);
//		frame.add(myPanel);
//		frame.repaint();
			
		
		
		
	}
	


	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	//Note: Typically the main method will be in a
//    //separate class. As this is a simple one class
//    //example it's all in the one class.
//    public static void main(String[] args) {
//        
//        new Gui();
//    }
//
//    public Gui()
//    {
//        JFrame guiFrame = new JFrame();
//        
//        //make sure the program exits when the frame closes
//        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        guiFrame.setTitle("GradeBook Assistant");
//        guiFrame.setSize(300,250);
//      
//        //This will center the JFrame in the middle of the screen
//        guiFrame.setLocationRelativeTo(null);
//        
//        //Options for the JComboBox 
////        String[] fruitOptions = {"Apple", "Apricot", "Banana"
////                ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"};
//        
//        //Options for the JList
////        String[] vegOptions = {"Asparagus", "Beans", "Broccoli", "Cabbage"
////                , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom"
////                , "Pepper", "Radish", "Shallot", "Spinach", "Swede"
////                , "Turnip"};
//        
//        //The first JPanel contains a JLabel and JCombobox
//        final JPanel comboPanel = new JPanel();
//        JLabel comboLbl = new JLabel("Fruits:");
//        JComboBox fruits = new JComboBox(fruitOptions);
//        
//        comboPanel.add(comboLbl);
//        comboPanel.add(fruits);
//        
//        //Create the second JPanel. Add a JLabel and JList and
//        //make use the JPanel is not visible.
//        final JPanel listPanel = new JPanel();
//        listPanel.setVisible(false);
//        JLabel listLbl = new JLabel("Vegetables:");
//        JList vegs = new JList(vegOptions);
//        vegs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//          
//        listPanel.add(listLbl);
//        listPanel.add(vegs);
//        
//        JButton vegFruitBut = new JButton( "Fruit or Veg");
//        
//        //The ActionListener class is used to handle the
//        //event that happens when the user clicks the button.
//        //As there is not a lot that needs to happen we can 
//        //define an anonymous inner class to make the code simpler.
//        vegFruitBut.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent event)
//            {
//               //When the fruit of veg button is pressed
//               //the setVisible value of the listPanel and
//               //comboPanel is switched from true to 
//               //value or vice versa.
//               listPanel.setVisible(!listPanel.isVisible());
//               comboPanel.setVisible(!comboPanel.isVisible());
//
//            }
//        });
//        
//        //The JFrame uses the BorderLayout layout manager.
//        //Put the two JPanels and JButton in different areas.
//        guiFrame.add(comboPanel, BorderLayout.NORTH);
//        guiFrame.add(listPanel, BorderLayout.CENTER);
//        guiFrame.add(vegFruitBut,BorderLayout.SOUTH);
//        
//        //make sure the JFrame is visible
//        guiFrame.setVisible(true);
//
//}
//}
