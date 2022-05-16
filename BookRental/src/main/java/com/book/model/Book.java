package com.book.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Book {

	private int rank;
	private long bookId;
	private String title;
	private String author;
	private String field;
	private boolean rentalStatus;
	
	public Book(Builder builder) {
		this.rank = builder.rank;
		this.bookId = builder.bookId;
		this.title = builder.title;
		this.author = builder.author;
		this.field = builder.field;
		this.rentalStatus = builder.rentalStatus;
	}

	
	public static class Builder {
		
		private int rank;
		private long bookId;
		private String title;
		private String author;
		private String field;
		private boolean rentalStatus;
		
		public Builder (long bookId) {
			this.bookId = bookId;
		}
		
		public Builder rank(int rank) {
			this.rank = rank;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		public Builder field(String field) {
			this.field = field;
			return this;
		}
		
		public Builder rentalStatus(boolean rentalStatus) {
			this.rentalStatus = rentalStatus;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
		
	}


	
	
	
}
