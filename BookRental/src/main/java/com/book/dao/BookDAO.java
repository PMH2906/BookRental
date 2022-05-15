package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.book.utils.DBUtils;

//Data Access Object, DB 접근을 담당하는 클래스.
public class BookDAO {
	private PreparedStatement preparedstatement;

	// 파손된 책 삭제
	private PreparedStatement createPreparedStatement(Connection connection, String sql, String brokenBook) throws SQLException {
		preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setString(1, brokenBook);
		preparedstatement.setString(2, brokenBook);
		return preparedstatement;
	}
	
	public int deleteBook(String brokenBook) {
		final String deleteQuery= "DELETE FROM book WHERE title = ? OR book_id = ?";
		int affectedRows= 0 ;
		
		try(Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = createPreparedStatement(connection,deleteQuery,brokenBook);
				) 
		{
			affectedRows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return affectedRows;
	}

	
}
