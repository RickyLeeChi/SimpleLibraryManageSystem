package org.task.librarymanagesystem.service;

public class BookResponse {
    
    private String title;
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	private String author;
    public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	private int copies;
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	@Override
    public String toString(){
         return this.title + " by " + this.author + " - " + this.copies + " available";
    }
}
