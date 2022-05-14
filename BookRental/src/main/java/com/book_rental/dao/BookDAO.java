package com.book_rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.book_rental.model.Book;
import com.book_rental.utils.DBUtils;


public class BookDAO {
	
	private PreparedStatement preparedStatement;

	public int save(Book newBook) {
		String insertQuery = "INSERT INTO book (rank, book_Id, title, author, field, rental_Status) VALUES(?,?,?,?,?,?)";
		int affectedRows = 0;
		
		try (Connection connection = DBUtils.getConnection();
			PreparedStatement preparedStatement = createPreparedStatement(connection, insertQuery, newBook);)
		{
			affectedRows = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
	
	private PreparedStatement createPreparedStatement(Connection connection, String sql, Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getRank());
		preparedStatement.setLong(2, book.getBookId());
		preparedStatement.setString(3, book.getTitle());
		preparedStatement.setString(4, book.getAuthor());
		preparedStatement.setString(5, book.getField());
		preparedStatement.setBoolean(6, book.isRentalStatus());
		return preparedStatement;
	}

	
	

}
