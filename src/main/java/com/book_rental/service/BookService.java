package com.book_rental.service;

import com.book_rental.dao.BookDAO;


public class BookService {
	private final BookDAO bookDAO;
	
	public BookService() {
		bookDAO = new BookDAO();
	}

	public int updateById() {
		return bookDAO.update();
	}


}
