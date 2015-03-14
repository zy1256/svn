package com.itwill.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDao extends RdbDao{
	public List<PhoneBook> selectAll() throws Exception {
		System.out.println("2.PhoneBookDao.selectAll()호출");
		System.out.println("3.List<PhoneBook>반환");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSql="select * from phonebook";
		List<PhoneBook> phoneBookList = new ArrayList<PhoneBook>();
		try{
			con = ConnectionFactory.getConnection();
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				phoneBookList.add(new PhoneBook(rs.getString("name"),rs.getString("phone"),rs.getString("address")));
			}
		}finally{
			if(rs!=null){
				rs.close();
			}
			if(con!=null){
				ConnectionFactory.releaseConnection(con);
			}
				
		}
		
		
		return phoneBookList;
	}
}
