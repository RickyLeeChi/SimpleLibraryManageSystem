package org.task.librarymanagesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.task.librarymanagesystem.entity.Book;
import org.task.librarymanagesystem.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookResponse> findAll() {
    	 List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    	 
    	 List<BookResponse> bookResponse = new ArrayList<BookResponse>();
    			 
    	 for (int i  = 0; i < books.size(); i++) {
			Book book = books.get(i);
			
			if(book.getCopies() <= 0) {
				continue;
			}
			
			BookResponse bookRsp = new BookResponse();
			bookRsp.setTitle(book.getTitle());
			bookRsp.setAuthor(book.getAuthor());
			bookRsp.setCopies(book.getCopies());
			
			bookResponse.add(bookRsp);

    	 }
        return bookResponse;
    }

	public Book findByBookId(String bookId) {
		 return bookRepository.findByBookId(bookId);
	}
	
    public Book save(Book bookToSave) {
    	Book book = findByBookId(bookToSave.getBookId());
    	if (book != null) {
    		int copies = book.getCopies();
    		book.setCopies(copies + bookToSave.getCopies());
    		return bookRepository.save(book);
    	} else {
    		 return bookRepository.save(bookToSave);
    	}
    }

    public Book checkoutBook(String bookId) {
    	Book book = findByBookId(bookId);
    	if (book != null && book.getCopies() > 0) {
    		int copies = book.getCopies() - 1;
    		book.setCopies(copies);
    		bookRepository.save(book);
    		
    		return book;
    	}
    	
    	return null;
    }

    public Book returnBook(String bookId) {
    	Book book = findByBookId(bookId);
        if (book != null) {
        	int copies = book.getCopies() + 1;
    		book.setCopies(copies);
    		bookRepository.save(book);
    		
    		return book;
        }
        
        return null;
    }
}
