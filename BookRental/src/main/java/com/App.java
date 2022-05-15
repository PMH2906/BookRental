package com;

import com.book.controller.BookController;

public class App 
{
    public static void main( String[] args )
    {
    	BookController boolController = new BookController();
    	
    	// 파손된 책 삭제
    	String brokenBook = boolController.startDeleteService();
    	boolController.deleteBook(brokenBook);
    }
}
