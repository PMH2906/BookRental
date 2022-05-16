package com.book_rental.controller;

import com.book_rental.model.Book;
import com.book_rental.service.BookService;
import com.book_rental.view.BookView;


public class BookController {
	
	private final BookView bookView;
	private final BookService bookService;

	public BookController() {
		this.bookView = new BookView();
		this.bookService = new BookService();
	}
	
	public void save(Book newBook) {
		int result = bookService.save(newBook);
		
		if(result > 0) {
			bookView.successPage();
		} else {
			bookView.errorPage();
		}
	}


}
