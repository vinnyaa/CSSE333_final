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
		
		frame = new JFrame("GradeBook Assistant");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Color.orange);
		frame.setLocation(300, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		l = new JLabel("Enter User Name");
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
		
//		myButton.addActionListener(new ActionListener() {
//          @Override
//          public void actionPerformed(ActionEvent event)
//          {
//             username = field.getText();
//             password = passwordField.getText();
//             pressed = false;
//          }
//		});
		
		
		frame.setVisible(true);
		
		
		
		
	}
	
//	public static void main(String args[]){
//		Gui myGui = new Gui();
//		myGui.getUser();
//		myGui.getPass();
//	}
	
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
