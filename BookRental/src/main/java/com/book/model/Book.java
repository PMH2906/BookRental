package com.book.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Builder
@Getter
@ToString

public class Book {
	private int rank;
	private String bookId;
	private String title;
	private String author;
	private String field;
	private String rentalStatus;
	
	
}
