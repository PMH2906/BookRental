package com;

import com.book.controller.BookController;

public class App 
{
    public static void main( String[] args )
    {
    	BookController boolController = new BookController();
    	
    	// System Start. 시작 메뉴 출력.
    	boolController.programStart();
    	
    	
    	
//    	// 파손된 책 삭제
//    	String brokenBook = boolController.startDeleteService();
//    	boolController.deleteBook(brokenBook);
    }
}
