package org.task.librarymanagesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.task.librarymanagesystem.entity.Book;
import org.task.librarymanagesystem.service.BookResponse;
import org.task.librarymanagesystem.service.BookService;

import java.util.List;

@Configuration
@Component
public class BookController {

    @Autowired
    private BookService bookService;

    public List<BookResponse> getAllBooks() {
        return bookService.findAll();
    }
    

    public Book getBookByBookId(String bookId) {
        return bookService.findByBookId(bookId);
    }

    public Book addBook(Book bookToSave) {
    	return bookService.save(bookToSave);
    }

    public String checkout(String bookId) {
    	Book book = bookService.checkoutBook(bookId);
    	if (book != null) {   		
    		return "Checked out ["+ book.getTitle() + "]";
    	}
    	
    	return "Book not available";
    }

    public String returnBook(String bookId) {
    	Book book = bookService.returnBook(bookId);
        if (book != null) {
    		return "Returned ["+ book.getTitle() + "]";
        }
        
        return "No book found";
    }
}
