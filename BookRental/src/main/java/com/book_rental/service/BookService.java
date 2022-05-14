package com.book_rental.service;

import com.book_rental.dao.BookDAO;
import com.book_rental.model.Book;

public class BookService {
	
	private final BookDAO bookDAO;
	
	public BookService() {
		bookDAO = new BookDAO();
	}

	public int save(Book newBook) {
		return bookDAO.save(newBook);
	}

}
