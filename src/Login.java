import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Login implements ActionListener
{
	private String url = "jdbc:mysql://localhost:3306/onlinebanking";
	private String dbUser = "root";
	private String dbPass = "";
	
	private JFrame loginFrame = new JFrame();
	private JLabel welcomeLabel = new JLabel("Welcome to Online Banking!");
	private JLabel numLabel = new JLabel("Username");
	private JTextField numField = new JTextField("");
	private JLabel passLabel = new JLabel("Password");
	private JPasswordField passField = new JPasswordField("");
	private JButton loginButton = new JButton("Login");
	private JButton newAcc = new JButton("Create Account");
	
	public Login()
	{
		loginFrame.setVisible(true);
		loginFrame.setLayout(null);	
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(500, 500);
		loginFrame.setResizable(false);
		loginFrame.setTitle("Login - OnlineBanking");
		
		welcomeLabel.setBounds(130, 45, 250, 30);
		welcomeLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		loginFrame.add(welcomeLabel);
		
		numLabel.setBounds(150, 100, 250, 30); 
		loginFrame.add(numLabel);
		
		numField.setLocation(150, 125);
		numField.setSize(200, 25);
		loginFrame.add(numField);
		
		passLabel.setBounds(150, 175, 250, 30);
		loginFrame.add(passLabel);
		
		passField.setLocation(150, 200);
		passField.setSize(200, 25);
		loginFrame.add(passField);
		
		loginButton.setLocation(175, 275);
		loginButton.setSize(150, 50);
		loginFrame.add(loginButton);
		loginButton.addActionListener(this);
		
		newAcc.setLocation(175, 400);
		newAcc.setSize(150, 20);
		loginFrame.add(newAcc);
		newAcc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == loginButton)
		{
			String user = numField.getText();
//			char[] temp = passField.getPassword();
			String pass = new String(passField.getPassword());
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url, dbUser, dbPass);
				String sql = "SELECT * FROM `customerdetails`"
						+ " WHERE Username = ? AND Password = ?";
				
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, user);
				stmt.setString(2, pass);
				
				ResultSet resultSet = stmt.executeQuery();
				
				if(resultSet.next())
				{
					String firstName = resultSet.getString(1);
					String lastName = resultSet.getString(2);
					int balance = resultSet.getInt(3);
					JOptionPane.showMessageDialog(loginFrame, "You have succesfully logged in!" + "\n" + "Welcome " 
					+ firstName + " " + lastName + "!");
					loginFrame.dispose();
					Dashboard dash = new Dashboard(firstName, lastName, balance);
					connection.close();
				}
				else
				{
					JOptionPane.showMessageDialog(loginFrame, "Incorrect username or password!");
					connection.close();
				}
			}
			catch(Exception E)
			{
				JOptionPane.showMessageDialog(loginFrame, E);
			}
		}
		if(e.getSource() == newAcc)
		{
			loginFrame.dispose();
			NewAccountForm form = new NewAccountForm();
		}
		
	}
	
}
