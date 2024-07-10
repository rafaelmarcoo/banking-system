import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Withdraw implements ActionListener
{
	private String url = "jdbc:mysql://localhost:3306/onlinebanking";
	private String dbUser = "root";
	private String dbPass = "";
	
	private static String firstName;
	private static String lastName;
	
	private static JFrame withdrawFrame = new JFrame();
	private static JLabel numLbl = new JLabel();
	private static JTextField numField = new JTextField();
	private JButton confirmButton = new JButton();
	private JButton backButton = new JButton();
	
	public Withdraw(String f, String l)
	{
		this.firstName = f;
		this.lastName = l;
		
		FrameList.addFrame(withdrawFrame);
		
		withdrawFrame.setVisible(true);
		withdrawFrame.setLayout(null);
		withdrawFrame.setSize(400, 250);
		withdrawFrame.setResizable(false);
		withdrawFrame.setTitle("Withdraw - Online Banking");
		withdrawFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		numLbl.setText("Please enter an amount to be withdrawn:");
		numLbl.setBounds(52, 40, 300, 40);
		numLbl.setFont(new Font("Calibri", Font.BOLD, 16));
		withdrawFrame.add(numLbl);
		
		numField.setBounds(52, 70, 300, 40);
		//numField.setLocation
		numField.setSize(285, 30);
		withdrawFrame.add(numField);
		
		confirmButton.setText("Confirm");
		confirmButton.setLocation(215, 120);	
		confirmButton.setSize(120, 40);
		withdrawFrame.add(confirmButton);
		confirmButton.addActionListener(this);
		
		backButton.setText("Back");
		backButton.setLocation(55, 120);
		backButton.setSize(120, 40);
		withdrawFrame.add(backButton);
		backButton.addActionListener(this);
	}
	
	public void close()
	{
		withdrawFrame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == backButton)
		{
			withdrawFrame.dispose();
		}
		if(e.getSource() == confirmButton)
		{
			String amt = numField.getText();
			
			if(amt.replaceAll("\\s", "").equals("") || !amt.matches("\\d+"))
			{
				JOptionPane.showMessageDialog(withdrawFrame, "Please enter a valid amount! No letters, symbols or whitespaces!");
				return;
			}
			
			int intAmt = Integer.parseInt(amt);
			if(intAmt <= 0)
			{
				JOptionPane.showMessageDialog(withdrawFrame, "Please enter an amount more than $0!");
			}
			else
			{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection(url, dbUser, dbPass);
					
					String transaction = "Withdraw";
					String strDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
					
					String fetchBalanceSql = "SELECT Balance FROM `customerdetails` WHERE LastName = ?";
		            PreparedStatement fetchBalanceStmt = connection.prepareStatement(fetchBalanceSql);
		            fetchBalanceStmt.setString(1, lastName);
		            ResultSet rs = fetchBalanceStmt.executeQuery();
		            
		            int latestBal = 0;
		            if (rs.next()) 
		            {
		                latestBal = rs.getInt("Balance");
		            }
		            
		            if(intAmt > latestBal)
		            {
		            	JOptionPane.showMessageDialog(withdrawFrame, "You have insufficient funds to withdraw $" + intAmt);
		            	return;
		            }

		            int finalBal = latestBal - intAmt;
		            
		            String sql = "UPDATE `customerdetails` SET Balance = ? WHERE LastName = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, finalBal);
					statement.setString(2, lastName);
					int rowsOne = statement.executeUpdate();
		            
					String lName = lastName;
					if(lastName.contains(" "))
			        {
			            lName = lastName.replaceAll("\\s", "");
			        }
		            String sqlTwo = "INSERT INTO `" + lName + "_HISTORY` "
			        		+ "(Date, Transaction, InitialBalance, FinalBalance) "
			        		+ "VALUES (?, ?, ?, ?)";
					PreparedStatement statementTwo = connection.prepareStatement(sqlTwo);
					statementTwo.setString(1, strDate);
					statementTwo.setString(2, transaction);
					statementTwo.setInt(3, latestBal);
					statementTwo.setInt(4, finalBal);
					int rowsTwo = statementTwo.executeUpdate();
					
					if(rowsOne > 0 && rowsTwo > 0)
					{
						JOptionPane.showMessageDialog(withdrawFrame, "Withdraw successful!" + "\n" + "Current Balance = $" + finalBal);
						withdrawFrame.dispose();
						FrameList.removeFrame(withdrawFrame);
						Dashboard dashboard = new Dashboard(firstName, lastName, finalBal);
						connection.close();
					}
					else
					{
						JOptionPane.showMessageDialog(withdrawFrame, "Withdraw failed. Please try again.");
			            connection.close();
					}
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(withdrawFrame, E);
				}
			}
		}
		
	}
}
