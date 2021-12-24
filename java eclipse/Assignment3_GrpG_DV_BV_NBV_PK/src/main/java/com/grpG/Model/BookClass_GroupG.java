package com.grpG.Model;


public class BookClass_GroupG {
 
	private int bookId;
	private String title;
	private Double price;
	private String Available;
	private String Author;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAvailable() {
		return Available;
	}
	public void setAvailable(String available) {
		Available = available;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public BookClass_GroupG(int book_id,String title, Double price,String availability,String author) {
		super();
		this.bookId=book_id;
		this.title=title;
		this.price=price;
		this.Available=availability;
		this.Author=author;
	}
	public BookClass_GroupG(int book_id) {
		super();
		this.bookId=book_id;
	}
}
