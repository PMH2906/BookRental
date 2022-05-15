package com.book.controller;

import com.book.service.BookService;
import com.book.view.BookView;

public class BookController {
	private final BookView bookView;
	private final BookService bookService;
	
	public BookController() {
		this.bookView = new BookView();
		this.bookService = new BookService();
	}
	
	// 파손된 책을 삭제하는 서비스 실행 시 출력되는 문구
	public String startDeleteService() {
		return bookView.startDeleteService();
	}
	
	// 파손된 책 삭제 기능
	public void deleteBook(String brokenBook) {
		int result = 0;
		
		result = bookService.deleteBook(brokenBook);
		if(result> 0) { // 정삭적으로 삭제
			bookView.deleteBookSuccessPage(brokenBook);
		} else { // 삭제하는 과정에서 error발생 시
			bookView.deleteBookErrorPage(brokenBook);
		}	

	}
}
