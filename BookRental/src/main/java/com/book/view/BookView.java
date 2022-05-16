package com.book.view;

import java.util.List;

import com.book.model.Book;

public class BookView {

	// 베스트셀러 리스트 출력 서비스 실행 시 출력되는 문구
	
	public void findAll(List<Book> books) {
		System.out.println("베스트셀러 리스트입니다.");
		for(Book book : books) {
			System.out.println(book);
		}
	}



}
