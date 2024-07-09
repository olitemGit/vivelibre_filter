package com.vivelibre.filter.dto;

public class BookDate{
	
	public BookDate(Book book, String date) {
		super();
		this.book = book;
		this.date = date;
	}
	
	private Book book;
	private String date;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
