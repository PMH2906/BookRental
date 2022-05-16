package com;

import com.book_rental.controller.BookController;
import com.book_rental.model.Book;


public class App 
{
    public static void main( String[] args )
    {
    	BookController bookController = new BookController();
    	
    	Book Book21 = new Book.Builder(9791191891072L)
        		.rank(21)
        		.title("나에게 고맙다(30만 부 기념 전면 개정판)")
        		.author("전승환")
        		.field("시/에세이")
        		.rentalStatus(false)
        		.build();
        
        
    	bookController.save(Book21);
    }
}
