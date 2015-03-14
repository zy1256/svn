package com.itwill.jdbc;

import java.sql.Connection;
/*
 * Connection 을생성하고 해제하는
 * 역할을하는 클래스
 */
import java.sql.DriverManager;

public class ConnectionFactory {
	
	
	private ConnectionFactory() {}
	/*
	 * Connection생성
	 */
	public static  Connection  getConnection()throws Exception{
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.2.26:1521:XE";
		String user = "scott";
		String password = "tiger";
		Connection con=null;
		Class.forName(driverClass);
		con=DriverManager.getConnection(url, user,password);
		return con;
	}
	/*
	 * Connection 반납(닫기)
	 */
	public static void releaseConnection(Connection con)throws Exception{
		con.close();
	}
	
}
