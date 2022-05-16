package com.book_rental.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.book_rental.utils.DBUtils;



public class BookDAO {

	private PreparedStatement preparedStatement;
	private String title_name;
	private Scanner sc = new Scanner(System.in);
	private ResultSet rs;
	private String status_book;





	public int update()  {	
		
		final String selectQuery = "select * from book_list where title = ?";
		
		final String updateQuery = "update book_list set rental_status = ? where title = ?";
		int book_update = 0;
		
		
		System.out.println("반납할 책을 입력해주세요. :");
		title_name = sc.next();

		try(Connection connection = DBUtils.getConnection();
		    PreparedStatement pstmt = connection.prepareStatement(selectQuery);
			PreparedStatement preparedStatement = createPreparedStatement(connection, updateQuery);)

		{
			
			pstmt.setString(1, title_name);
			rs = pstmt.executeQuery();
			
			book_update = preparedStatement.executeUpdate();
				
				if(rs.next()) {
					title_name = rs.getString("title");
					status_book = rs.getString("rental_status");
					System.out.print(status_book);
					
				}
				if(status_book.equals("FALSE")) {
					System.out.println("반납되었습니다.");
					status_book = "TRUE";
				}
				else {
					System.out.println("대여하지 않은 책이거나 없는 책입니다. 다시 입력해주세요");
				}
								
				
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 안됨");
		}
		
		return book_update;
	}
	private PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, status_book);
		preparedStatement.setString(2,title_name);
		
		return preparedStatement;
	}
	
	

	
	

	

}
