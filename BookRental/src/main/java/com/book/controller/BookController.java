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
	

	public void programStart() {
		String choice ="";
		// 원하는 Service
		
		do {
		// 첫 화면에 베스트셀러 출력하도록 하려면 controller에서 BookService.java를 이용하여 top5 book list받은 후 
		// systemStart()에 매개변수로 주어 bookView에서 출력해주기
		choice = bookView.programStart();
		switch(choice) {
		case "1":
			// 책 대여 서비스 메서드
			break;
		case "2":
			// 책 추가 서비스 메서드
			break;
		case "3":
			// 책 삭제 서비스 
			deleteBook();
			break;
		case "4":
			// 프로그램 종료. 자원해제
			bookView.programEnd();
			break;
		default:
			bookView.programErrorPage();
			
		}// end of switch (choice)--------------------------------
		
		}while(!("4".equals(choice)));
		
	} // end of public void systemStart() ------------------------
	
	// 책 삭제 서비스
	private void deleteBook() {
		int result = 0;
		
		// 파손된 책 정보 받기
		String brokenBook = bookView.deleteBook();
		// 정보에 맞는 파손된 책 삭제
		result = bookService.deleteBook(brokenBook);
		if(result> 0) { // 정삭적으로 삭제
			bookView.deleteBookSuccessPage(brokenBook);
		} else { // 삭제하는 과정에서 error발생 시
			bookView.deleteBookErrorPage(brokenBook);
		}	
	}

}
