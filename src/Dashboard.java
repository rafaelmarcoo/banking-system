import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;

public class Dashboard implements ActionListener
{
	private static String firstName;
	private static String lastName;
	private static int balance;
	
	private static JFrame dashFrame = new JFrame();
	private static JLabel nameLbl = new JLabel();
	private static JLabel timeLbl = new JLabel();
	private static JLabel locationLbl = new JLabel();
	private static JLabel tempLbl = new JLabel();
	private static JLabel precLbl = new JLabel();
	private static JLabel balLbl = new JLabel();
	private JButton withdrawButton = new JButton("Withdraw");
	private JButton depositButton = new JButton("Deposit");
	private JButton historyButton = new JButton("View Transaction History");
	private JButton logoutButton = new JButton("Logout");
	
	public Dashboard(String f, String l, int b)
	{	
		this.firstName = f;
		this.lastName = l;
		this.balance = b;
		
		dashFrame.setVisible(true);
		dashFrame.setLayout(null);
		dashFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dashFrame.setSize(500, 500);
		dashFrame.setResizable(false);
		dashFrame.setTitle("Dashboard - Online Banking");
		
		nameLbl.setText("Welcome " + firstName + " " + lastName + "!");
		nameLbl.setBounds(10, 10, 350, 30);
		nameLbl.setFont(new Font("Calibri", Font.BOLD, 16));
		dashFrame.add(nameLbl);
		
		String strDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				String strTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
				timeLbl.setText(strDate + "  " + strTime);
			}
		}, 0, 1000);
		timeLbl.setBounds(10, 25, 250, 30);
		dashFrame.add(timeLbl);
		
		displayWeatherData();
		locationLbl.setText("Auckland");
		locationLbl.setBounds(10, 50, 250, 30);
		tempLbl.setBounds(10, 65, 250, 30);
		precLbl.setBounds(10, 80, 250, 30);
		dashFrame.add(locationLbl);
		dashFrame.add(tempLbl);
		dashFrame.add(precLbl);
		
		balLbl.setText("Balance: \n" + "$" + balance);
        balLbl.setBounds(350, 10, 200, 30);
        balLbl.setFont(new Font("Calibri", Font.BOLD, 16));
        dashFrame.add(balLbl);
		
		logoutButton.setLocation(10, 430);
		logoutButton.setSize(80, 20);
		dashFrame.add(logoutButton);
		logoutButton.addActionListener(this);
		
		historyButton.setLocation(155, 175);
		historyButton.setSize(180, 40);
		dashFrame.add(historyButton);
		historyButton.addActionListener(this);
		
		withdrawButton.setLocation(100, 300);
		withdrawButton.setSize(120, 40);
		dashFrame.add(withdrawButton);
		withdrawButton.addActionListener(this);
		
		depositButton.setLocation(270, 300);
		depositButton.setSize(120, 40);
		dashFrame.add(depositButton);
		depositButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == logoutButton)
		{
			FrameList.closeActiveFrames();
			JOptionPane.showMessageDialog(dashFrame, "Thank you for using Online Banking! Logging out ...");
			dashFrame.dispose();
			Login login = new Login();
		}
		if(e.getSource() == historyButton)
		{
			History history = new History(firstName, lastName);
		}
		if(e.getSource() == depositButton)
		{
			Deposit deposit = new Deposit(firstName, lastName);
		}
		if(e.getSource() == withdrawButton)
		{
			Withdraw withdraw = new Withdraw(firstName, lastName);
		}
	}
	
	public static void displayWeatherData()
	{
		String apiURL = "https://api.open-meteo.com/v1/forecast?latitude=-36.8485&longitude=174.7635&current=temperature_2m,precipitation&timezone=Pacific%2FAuckland&forecast_days=1";
		HttpURLConnection apiConnection = fetchApiResponse(apiURL);
		
		try 
		{
			if(apiConnection.getResponseCode() != 200)
			{
				JOptionPane.showMessageDialog(dashFrame, "Error: Could not connect to API");
				return;
			}
			
			String jsonResponse = readApiResponse(apiConnection);
			
			JSONParser parser = new JSONParser();
			JSONObject resultsJsonObj = (JSONObject) parser.parse(jsonResponse);
			JSONObject weatherData = (JSONObject) resultsJsonObj.get("current");
			
			double temp = (double) weatherData.get("temperature_2m");
			double precipitation = (double) weatherData.get("precipitation");
			tempLbl.setText("Current Temperature (C): " + temp);
			precLbl.setText("Precipitation (mm): " + precipitation);

		} 
		catch(Exception E) 
		{
			E.printStackTrace();
		}
	}
	
	public static HttpURLConnection fetchApiResponse(String urlString)
	{
		try
		{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			
			return conn;
		}
		catch(IOException E)
		{
			E.printStackTrace();
		}
		
		return null;
	}
	
	public static String readApiResponse(HttpURLConnection apiConnection)
	{
		try
		{
			StringBuilder resultJson = new StringBuilder();
			
			Scanner scan = new Scanner(apiConnection.getInputStream());
			
			while(scan.hasNext())
			{
				resultJson.append(scan.nextLine());
			}
			scan.close();
			
			return resultJson.toString();
		}
		catch(IOException E)
		{
			E.printStackTrace();
		}
		
		return null;
	}
}
