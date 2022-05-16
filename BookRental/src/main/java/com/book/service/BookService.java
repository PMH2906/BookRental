package com.book.service;

import com.book.dao.BookDAO;
import com.book.model.Book;

public class BookService {
	private final BookDAO bookDAO;
	
	public BookService() {
		bookDAO = new BookDAO();
	}
	
	public int deleteBook(String brokenBook) {
		// 삭제 된 행
		return bookDAO.deleteBook(brokenBook);
	}

	public int saveBook(Book saveBook) {
		
		return bookDAO.saveBook(saveBook);
	}
}
