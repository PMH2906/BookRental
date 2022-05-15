package com.book.view;

import java.util.Scanner;

public class BookView {

	// 파손된 책을 삭제하는 서비스 실행 시 출력되는 문구
	public String startDeleteService() {
		System.out.println("파손된 책 이름 혹은 책 ID를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String brokenBook = sc.nextLine(); 
		return brokenBook;
	}

	// 파손된 책 정상적으로 삭제
	public void deleteBookSuccessPage(String brokenBook) {
		System.out.println(String.format("<%S> 책이 정상적으로 삭제되었습니다.",brokenBook));
		
	}
	// 파손된 책 삭제 과정에서 error발생
	public void deleteBookErrorPage(String brokenBook) {
		System.out.println(String.format("<%S> 책이 존재하지 않습니다.",brokenBook));
		
	}

}
