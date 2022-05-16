package com.book.controller;

import java.util.List;

import com.book.model.Book;
import com.book.service.BookService;
import com.book.view.BookView;

public class BookController {
	
	private List<Book> books;
	private final BookView bookView;
	private final BookService bookService;
//	private final Book books = new Book();
	
	
	public BookController() {
		this.bookView = new BookView();
		this.bookService = new BookService();
	}
	
	
		// 전체 데이터 조회 처리를 위한 분기
		public void findAll() {
			books = bookService.findAll();
			bookView.findAll(books);
		}

	}
	
