package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.book.model.Book;
import com.book.utils.DBUtils;

public class BookDAO {

	private PreparedStatement preparedStatement;
	private String title_name;

	private Scanner sc = new Scanner(System.in);
	private ResultSet rs;
	private int status_book;
	private Book book;

	public int rentalcheck() {
		
		final String selectQuery = "select * from book where title = ?";

		final String updateQuery = "update book set rental_status = ? where title = ?";
		int book_update = 0;

		System.out.print("대여 여부 확인할 책을 입력해주세요 :");
		title_name = sc.next();

		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, updateQuery);
				PreparedStatement pstmt = createPreparedStatement1(connection, selectQuery);)

		{

			pstmt.setString(1, title_name);
			rs = pstmt.executeQuery();
			
//			System.out.println(book.getTitle().equals(title_name) == true);

			while (rs.next()) {
				title_name = rs.getString("title");
				status_book = rs.getInt("rental_status");
			}

				if ( status_book == 0) {
					System.out.println("이미 대여 중입니다.");
//					System.exit(0);
				} 
				else {
					System.out.println("대여 가능합니다. 대여하시겠습니까? (예/아니오)");
					String answer = sc.next();
					if(answer == "예") {
						status_book = 1;
						System.out.println("대여되었습니다.");
					}else {
						System.exit(0);
					}
				}

			

			book_update = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 안됨");
		}

		return book_update;
	}
					
			
			
			

					
		

	public int update() {

		final String selectQuery = "select * from book where title = ?";

		final String updateQuery = "update book set rental_status = ? where title = ?";
		int book_update = 0;

		System.out.print("반납할 책을 입력해주세요. :");
		title_name = sc.next();

		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, updateQuery);
				PreparedStatement pstmt = createPreparedStatement1(connection, selectQuery);)

		{

			pstmt.setString(1, title_name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				title_name = rs.getString("title");
				status_book = rs.getInt("rental_status");
			}

			if ( status_book == 0) {
				status_book = 1;
				System.out.println("반납되었습니다.");
//				System.exit(0);
			} else {
				System.out.println("대여하지 않은 책이거나 없는 책입니다. 다시 입력해주세요");
			}

			book_update = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 안됨");
		}

		return book_update;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, status_book);
		preparedStatement.setString(2, title_name);

		return preparedStatement;
	}

	private PreparedStatement createPreparedStatement1(Connection connection, String sql) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, title_name);
		return preparedStatement;
	}

}
