import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class NewAccountForm implements ActionListener
{
	private String url = "jdbc:mysql://localhost:3306/onlinebanking";
	private String dbUser = "root";
	private String dbPass = "";
	
	private JFrame formFrame = new JFrame();
	private JLabel title = new JLabel("Join Online Banking Form!");
	private JLabel fName = new JLabel("First Name*");
	private JTextField fNameField = new JTextField("");
	private JLabel lName = new JLabel("Last Name*");
	private JTextField lNameField = new JTextField("");
	private JLabel uNum = new JLabel("Unit");
	private JTextField uNumField = new JTextField("");
	private JLabel sNum = new JLabel("Street*");
	private JTextField sNumField = new JTextField("");
	private JLabel suburb = new JLabel("Suburb*");
	private JTextField suburbField = new JTextField("");
	private JLabel postCode = new JLabel("Postal Code*");
	private JTextField postCodeField = new JTextField("");
	private JLabel phoneNum = new JLabel("Phone Number*");
	private JTextField phoneNumField = new JTextField("");
	private JLabel email = new JLabel("Email*");
	private JTextField emailField = new JTextField("");
	private JLabel userName = new JLabel("Username");
	private JTextField userNameField = new JTextField("");
	private JLabel password = new JLabel("Password");
	private JPasswordField passwordField = new JPasswordField("");
	private JButton createButton = new JButton("Create!");
	private JButton backButton = new JButton("Back");
	
	public NewAccountForm()
	{
		formFrame.setVisible(true);
		formFrame.setLayout(null);
		formFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		formFrame.setSize(500, 500);
		formFrame.setResizable(false);
		formFrame.setTitle("Form - Join Online Banking");
		
		title.setBounds(130, 20, 250, 30);
		title.setFont(new Font("Calibri", Font.BOLD, 20));
		formFrame.add(title);
		
		fName.setBounds(100, 60, 100, 30);
		fNameField.setLocation(180, 67);
		fNameField.setSize(200, 20);
		formFrame.add(fName);
		formFrame.add(fNameField);
		
		lName.setBounds(100, 90, 100, 30);
		lNameField.setLocation(180, 97);
		lNameField.setSize(200, 20);
		formFrame.add(lName);
		formFrame.add(lNameField);
		
		uNum.setBounds(100, 120, 100, 30);
		uNumField.setLocation(180, 127);
		uNumField.setSize(200, 20);
		formFrame.add(uNum);
		formFrame.add(uNumField);
		
		sNum.setBounds(100, 150, 100, 30);
		sNumField.setLocation(180, 157);
		sNumField.setSize(200, 20);
		formFrame.add(sNum);
		formFrame.add(sNumField);
		
		suburb.setBounds(100, 180, 100, 30);
		suburbField.setLocation(180, 187);
		suburbField.setSize(200, 20);
		formFrame.add(suburb);
		formFrame.add(suburbField);
		
		postCode.setBounds(100, 210, 100, 30);
		postCodeField.setLocation(180, 217);
		postCodeField.setSize(200, 20);
		formFrame.add(postCode);
		formFrame.add(postCodeField);
		
		phoneNum.setBounds(100, 240, 100, 30);
		phoneNumField.setLocation(200, 247);
		phoneNumField.setSize(180, 20);
		formFrame.add(phoneNum);
		formFrame.add(phoneNumField);
		
		email.setBounds(100, 270, 100, 30);
		emailField.setLocation(180, 277);
		emailField.setSize(200, 20);
		formFrame.add(email);
		formFrame.add(emailField);
		
		userName.setBounds(100, 330, 100, 30);
		userNameField.setLocation(180, 337);
		userNameField.setSize(200, 20);
		formFrame.add(userName);
		formFrame.add(userNameField);
		
		password.setBounds(100, 360, 100, 30);
		passwordField.setLocation(180, 367);
		passwordField.setSize(200, 20);
		formFrame.add(password);
		formFrame.add(passwordField);
		
		createButton.setLocation(200, 400);
		createButton.setSize(100, 40);
		formFrame.add(createButton);
		createButton.addActionListener(this);
		
		backButton.setLocation(20, 22);
		backButton.setSize(80, 20);
		formFrame.add(backButton);
		backButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == createButton)
		{
			String firstName = fNameField.getText();
			String lastName = lNameField.getText();
			String unit = uNumField.getText();
			String street = sNumField.getText();
			String sub = suburbField.getText();
			String pc = postCodeField.getText();
			String pNum = phoneNumField.getText();
			String emailAdd = emailField.getText();
			String user = userNameField.getText();
			char[] temp = passwordField.getPassword();
			String pass = new String(temp);
			
			String strDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());

			if(firstName.replaceAll("\\s", "").equals("") ||
					lastName.replaceAll("\\s", "").equals("") ||
					street.replaceAll("\\s", "").equals("") ||
					sub.replaceAll("\\s", "").equals("") ||
					pc.replaceAll("\\s", "").equals("") ||
					pNum.replaceAll("\\s", "").equals("") ||
					emailAdd.replaceAll("\\s", "").equals("") ||
					user.replaceAll("\\s", "").equals("") ||
					pass.replaceAll("\\s", "").equals(""))
			{
				JOptionPane.showMessageDialog(formFrame, "Please fill up all required fields! Cannot be whitespaces!");
			}
			else if(firstName.matches(".*[0-9].*") || lastName.matches(".*[0-9].*"))
			{
				JOptionPane.showMessageDialog(formFrame, "First or last name should not contain any numbers or special characters!");
			}
			else if(!pNum.matches("^\\d+$") || !pc.matches("^\\d+$"))
			{
				JOptionPane.showMessageDialog(formFrame, "Phone Number and Postal Code should not contain any letters or special characters!");
			}
			else
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url, dbUser, dbPass);
					
					
					String sql = "INSERT INTO `customerdetails` (FirstName, LastName, Balance, Unit, Street, Suburb, PostalCode, PhoneNumber, Email, JoinDate, Username, Password)"
							+ " VALUES (?, ?, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, firstName);
			        statement.setString(2, lastName);
			        statement.setString(3, unit);
			        statement.setString(4, street);
			        statement.setString(5, sub);
			        statement.setString(6, pc);
			        statement.setString(7, pNum);
			        statement.setString(8, emailAdd);
			        statement.setString(9, strDate);
			        statement.setString(10, user);
			        statement.setString(11, pass);
			        int rowsOne = statement.executeUpdate();

			        
			        
			        lastName = lastName.replaceAll("\\s", "");
			        String sqlTwo = "CREATE TABLE " + lastName + "_HISTORY"
			        		+ " (Date varchar(50), "
			        		+ "Transaction varchar(100), "
			        		+ "InitialBalance int, "
			        		+ "FinalBalance int)";
			        Statement statementTwo = connection.createStatement();
			        int rowsTwo = statementTwo.executeUpdate(sqlTwo);
			        
			        
			        String transaction = "Opening Account";
			        String sqlThree = "INSERT INTO `" + lastName + "_HISTORY` "
			        		+ "(Date, Transaction, InitialBalance, FinalBalance) "
			        		+ "VALUES (?, ?, 0, 0)";
			        PreparedStatement statementThree = connection.prepareStatement(sqlThree);
					statementThree.setString(1, strDate);
			        statementThree.setString(2, transaction);
			        int rowsThree = statementThree.executeUpdate();
			        
			        if(rowsOne > 0 && rowsTwo == 0 && rowsThree > 0)
			        {
			        	JOptionPane.showMessageDialog(formFrame, "Congratulations! Welcome to OnlineBanking!" 
			        			+ "\n" + "Join Date: " + strDate
			        			+ "\n" + "Opening Balance: $0");
			        	formFrame.dispose();
			        	Login login = new Login();
			        	connection.close();
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(formFrame, "Creating new bank account failed. Please try again.");
			            connection.close();
			        }
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(formFrame, E);
				}
			}
		}
		
		if(e.getSource() == backButton)
		{
        	formFrame.dispose();
        	Login login = new Login();
		}
	}
	
}
