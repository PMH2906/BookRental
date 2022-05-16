package com;

import java.util.Scanner;

import com.book_rental.controller.BookController;
import com.book_rental.model.Book;


public class App 
{
    public static void main( String[] args )
    {
    	Scanner saveInput = new Scanner(System.in);
    	System.out.println("등록할 book_id :");
    	Long saveBookId = saveInput.nextLong();
    	saveInput.nextLine();
    	System.out.println("등록할 rank_id :");
    	int saveRank = saveInput.nextInt();
    	saveInput.nextLine();
    	System.out.println("등록할 title :");
    	String saveTitle = saveInput.nextLine();
    	System.out.println("등록할 author :");
    	String saveAuthor = saveInput.nextLine();
    	System.out.println("등록할 field :");
    	String saveField = saveInput.nextLine();
    

    	BookController bookController = new BookController();
    	
    	Book newBook = new Book.Builder(saveBookId)
        		.rank(saveRank)
        		.title(saveTitle)
        		.author(saveAuthor)
        		.field(saveField)
        		.rentalStatus(true)
        		.build();
        
        
    	bookController.save(newBook);
    }
}
