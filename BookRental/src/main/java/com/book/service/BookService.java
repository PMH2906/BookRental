package com.book.service;

import com.book.dao.BookDAO;

public class BookService {
	private final BookDAO bookDAO;
	
	public BookService() {
		bookDAO = new BookDAO();
	}
	
	public int deleteBook(String brokenBook) {
		// 삭제 된 행
		return bookDAO.deleteBook(brokenBook);
	}
}
