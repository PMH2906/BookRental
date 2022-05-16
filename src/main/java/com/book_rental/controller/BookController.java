package com.book_rental.controller;


import com.book_rental.service.BookService;
import com.book_rental.view.BookView;

public class BookController {
	private final BookService bookService;
	private final BookView bookView;
	private Exception errorObject;
	
	public BookController() {
		this.bookView = new BookView();
		this.bookService = new BookService();
	}

	public void updateById() {
		int previudsBook = bookService.updateById();

		
		if(previudsBook != 0) {
			bookView.update();
		}else {
			errorObject = new Exception("수정 실패");
			bookView.errorPage(errorObject);
		}
		
	}
	

}
