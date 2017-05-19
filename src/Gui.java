import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
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
	JPanel myPanel;
	String username;
	String password;
    static // The salt (probably) can be stored along with the encrypted data
   byte[] salt = new String("12345678").getBytes();

   // Decreasing this speeds down startup time and can be useful during testing, but it also makes it easier for brute force attackers
   static int iterationCount = 40000;
   // Other values give me java.security.InvalidKeyException: Illegal key size or default parameters
  static int keyLength = 128;
  static String keyPassword;
  static SecretKeySpec key;

	
	Gui() throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		frame = new JFrame("GradeBook Assistant Login");
		frame.setSize(500, 200);
		frame.getContentPane().setBackground(Main.back_color);
		frame.setLocation(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.set(10, 10, 10, 10);
		c.anchor = GridBagConstraints.NORTHWEST; // Basically is it centered, align left/right, up/down
		c.weightx = .8; // how much of the grid square should the item fill in the x direction (.2 = 20%)
		c.weighty = .65; // how much of the grid to use vertically. 1 (100%) spaces our items out vertically
		
		myPanel = new JPanel(layout);
		
		c.weightx = .3;
		c.gridx = 0;
		c.gridy = 0;
		l = new JLabel("Enter User Name");
		l.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(l,c);
				
		c.gridx = 0;
		c.gridy = 1;
		l = new JLabel("Enter Password");
		l.setHorizontalAlignment(JLabel.CENTER);
		myPanel.add(l,c);
		
		c.gridy = 0;
		c.gridx = 1;
		field = new JTextField();	
		myPanel.add(field, c);
		
		c.gridy = 1;
		passwordField = new JPasswordField();		
		myPanel.add(passwordField, c);
		
		c.gridx = 1;
		c.gridy = 2;
		myButton = new JButton("OK");
		myPanel.add(myButton, c);
		
		myPanel.setOpaque(false);
		frame.add(myPanel);
		frame.setVisible(true);
		
		  keyPassword = "password";

	       key = createSecretKey(keyPassword.toCharArray(),
	               salt, iterationCount, keyLength);
		
		
		
		
	}
	
	
	public int getUserID(){
		return Integer.parseInt(field.getText());
	}
	
	public String getPass() throws UnsupportedEncodingException, GeneralSecurityException{
		
		if (passwordField.getText().equals("")){
			return "null pass";
		}
		else
			return encrypt(passwordField.getText(),key);
	}
	
	
	public JButton okButton(){
		return myButton;
	}

	private static SecretKeySpec createSecretKey(char[] password, byte[] salt, int iterationCount, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
	       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
	       PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, keyLength);
	       SecretKey keyTmp = keyFactory.generateSecret(keySpec);
	       return new SecretKeySpec(keyTmp.getEncoded(), "AES");
	   }

	   private static String encrypt(String property, SecretKeySpec key) throws GeneralSecurityException, UnsupportedEncodingException {
	       Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	       pbeCipher.init(Cipher.ENCRYPT_MODE, key);
	       AlgorithmParameters parameters = pbeCipher.getParameters();
	       IvParameterSpec ivParameterSpec = parameters.getParameterSpec(IvParameterSpec.class);
	       byte[] cryptoText = pbeCipher.doFinal(property.getBytes("UTF-8"));
	       byte[] iv = ivParameterSpec.getIV();
	       return base64Encode(iv) + ":" + base64Encode(cryptoText);
	   }

	   private static String base64Encode(byte[] bytes) {
	       return Base64.getEncoder().encodeToString(bytes);
	   }

	   private static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
	       String iv = string.split(":")[0];
	       String property = string.split(":")[1];
	       Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	       pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
	       return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
	   }

	   private static byte[] base64Decode(String property) throws IOException {
	       return Base64.getDecoder().decode(property);
	   }
		   

	
}