import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class History implements ActionListener
{
	private String url = "jdbc:mysql://localhost:3306/onlinebanking";
	private String dbUser = "root";
	private String dbPass = "";
	
	private static String firstName;
	private static String lastName;
	
	private static JFrame historyFrame = new JFrame();
	private static JTable hisTbl;
	private JButton backButton = new JButton("Back");
	private JButton refreshButton = new JButton("Refresh");
	
	public History(String f, String l)
	{
		this.firstName = f;
		this.lastName = l;
		
		FrameList.addFrame(historyFrame);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, dbUser, dbPass);
			
			String lName = lastName;
			if(lastName.contains(" "))
	        {
	            lName = lastName.replaceAll("\\s", "");
	        }
			String sql = "SELECT * FROM `" + lName + "_HISTORY`";
			Statement stmt = connection.createStatement
			(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY
			);
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.last();
			int numRows = rs.getRow();
			
			String[] colName = { "DATE", "TRANSACTION", "INITIAL BALANCE", "FINAL BALANCE" };
			int numCols = colName.length;
			
			String[][] data = new String[numRows][numCols];
			
			int i = 0;
			do
			{
				data[i][0] = rs.getString(1);
				data[i][1] = rs.getString(2);
				data[i][2] = String.valueOf(rs.getInt(3));
				data[i][3] = String.valueOf(rs.getInt(4));
				i++;
			}
			while(rs.previous());
			
			hisTbl = new JTable(data, colName);
		}
		catch(Exception E)
		{
			JOptionPane.showMessageDialog(historyFrame, E);
		}
		
		historyFrame.setVisible(true);
		historyFrame.setLayout(null);
		historyFrame.setSize(615, 480);
		historyFrame.setResizable(false);
		historyFrame.setTitle("Transaction History - Online Banking");
		historyFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JScrollPane sp = new JScrollPane(hisTbl);
	    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    sp.setBounds(20, 20, 560, 330);
	    historyFrame.add(sp);
	    
	    backButton.setLocation(50, 370);
	    backButton.setSize(200, 50);
	    historyFrame.add(backButton);
	    backButton.addActionListener(this);
	    
	    refreshButton.setLocation(350, 370);
	    refreshButton.setSize(200, 50);
	    historyFrame.add(refreshButton);
	    refreshButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == backButton)
		{
			historyFrame.dispose();
			FrameList.removeFrame(historyFrame);
		}
		if(e.getSource() == refreshButton)
		{
			historyFrame.dispose();
			FrameList.removeFrame(historyFrame);
			History history = new History(firstName, lastName);
		}
	}
	
	public void close()
	{
		historyFrame.dispose();
	}
}
