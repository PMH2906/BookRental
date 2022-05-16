package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.model.Book;
import com.book.utils.DBUtils;

//Data Access Object, DB 접근을 담당하는 클래스.
public class BookDAO {

	private PreparedStatement preparedStatement;

	// 파손된 책 삭제
	private PreparedStatement createPreparedStatement(Connection connection, String sql, String brokenBook) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, brokenBook);
		preparedStatement.setString(2, brokenBook);
		return preparedStatement;
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
	
	

	public int saveBook(Book saveBook) {
		
			String insertQuery = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?)";
			int affectedRows = 0;
			
			try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, insertQuery, saveBook);)
			{
				affectedRows = preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return affectedRows;
		}
	
	private PreparedStatement createPreparedStatement(Connection connection, String sql, Book savebook) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, savebook.getRank());
		preparedStatement.setLong(2, savebook.getBookId());
		preparedStatement.setString(3, savebook.getTitle());
		preparedStatement.setString(4, savebook.getAuthor());
		preparedStatement.setString(5, savebook.getField());
		preparedStatement.setBoolean(6, savebook.isRentalStatus());
		return preparedStatement;
	}
		
	
	
	public List<Book> findAll() {
		String selectQuery = "SELECT * FROM book ORDER BY rank_id limit 5";

		List<Book> books = new ArrayList<>();
		
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
				ResultSet resultSet = preparedStatement.executeQuery();

				)
		{
			while (resultSet.next()) {
				Book book = new Book(resultSet.getInt("rank_id"), 
								resultSet.getLong("book_id"), 
								resultSet.getString("title"), 
								resultSet.getString("author"), 
								resultSet.getString("field"), 
								resultSet.getBoolean("rental_status"));
			
				books.add(book);

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
		

	}
}
