package com.itwill.jdbc;

import java.sql.Connection;
/*
 * Connection �������ϰ� �����ϴ�
 * �������ϴ� Ŭ����
 */
import java.sql.DriverManager;

public class ConnectionFactory {
	
	
	private ConnectionFactory() {}
	/*
	 * Connection����
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
	 * Connection �ݳ�(�ݱ�)
	 */
	public static void releaseConnection(Connection con)throws Exception{
		con.close();
	}
	
}
