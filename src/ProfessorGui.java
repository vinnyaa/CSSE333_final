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
		
		gradeReportButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("Grade report has been pressed");
	          }
			
			});
		
		createAssignButton = new JButton("Create Assignment");
		createAssignButton.setSize(createAssignButton.getPreferredSize());
		myPanel.add(createAssignButton, BorderLayout.CENTER);
		
		createAssignButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent event)
	          {
	             System.out.println("create assign has been pressed");
	          }
			
			});
		
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
