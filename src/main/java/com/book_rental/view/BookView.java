package com.book_rental.view;



public class BookView {
	
	public void update() {
//		System.out.println("하나의 데이터 결과 조회입니다.");
//		System.out.println(String.format("%s , %s 입니다.", book.getTitle(), book.getRental_status()));
//	    System.out.println();
	}

	public void successPage() {
		System.out.println("정상 등록되었습니다.");
	}

	public void errorPage(Exception errorObject) {
		System.out.println("문제가 발생하였습니다.");
	}
	
	public void update(int previudsTodo) {
		System.out.println("정상 수정 되었습니다.");
		
	}

	
}
