package com.concast.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
public void getDbconnection(String url, String username, String password) throws SQLException{
	try {
Driver d=new Driver();
DriverManager.registerDriver(d);
con = DriverManager.getConnection(url, username, password);
	}
	catch(Exception e) {
	}
}

public void getDbconnection() throws SQLException{
	try {
Driver d=new Driver();
DriverManager.registerDriver(d);
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	catch(Exception e) {
	}
}

	public void closeDBConnection() throws SQLException
	{
		try {
		con.close();}
		catch (Exception e) {
			
		}
	
	}
	public ResultSet executeselectQuery(String query) throws SQLException{
	ResultSet result=null;
	try{
	Statement st=con.createStatement();
	 result=st.executeQuery(query);
}catch(Exception e)
	{}	
	return result;
	}
	public int executeNonselectQuery(String query) throws SQLException{
		int result=0;
		try{
		Statement st=con.createStatement();
		 result=st.executeUpdate(query);
	}catch(Exception e)
		{}	
		return result;
}
}
