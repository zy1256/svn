package com.itwill.test;
import java.sql.*;
public class  ConnectionFactory
{
	
	public ConnectionFactory(){
		
	}
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName(DBConf.ODRIVER);
			con=DriverManager.getConnection(DBConf.URL1);
		}catch(ClassNotFoundException e){
			System.out.println("ConnectionFactory.java Line 13");
		}catch(SQLException e){
			System.out.println("ConnectionFactory.java Line 15");
		}
		return con;
	}
	public void close(){
		
	}

}
