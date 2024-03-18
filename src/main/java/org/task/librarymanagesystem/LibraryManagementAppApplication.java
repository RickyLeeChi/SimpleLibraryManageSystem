package org.task.librarymanagesystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.task.librarymanagesystem.controller.BookController;
import org.task.librarymanagesystem.entity.Book;
import org.task.librarymanagesystem.service.BookResponse;

@SpringBootApplication
public class LibraryManagementAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LibraryManagementAppApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
		
	}
	
	@Bean
    public BookController getBookController(){
        return new BookController();
    }
	
	@Override
	public void run(String... args) throws Exception {
		BookController bc = getBookController();
		
		Scanner command = new Scanner(System.in);
    	
    	System.out.println("Welcome to Library Management System.");
    	System.out.println("Please enter your operation : ");
    	
    	System.out.print("# ");
    	
        boolean running = true;
        
        while(running){
        	String input = command.nextLine();
        	
        	List<String> inputs = spiltInput(input);
        	
        	if(inputs.get(0).contains("ADD_BOOK")) {
        		Book b = new Book();
        		b.setBookId(inputs.get(1));
        		b.setTitle(inputs.get(2));
        		b.setAuthor(inputs.get(3));
        		b.setCopies(Integer.valueOf(inputs.get(4)));
        		
        		bc.addBook(b);
        	}
        	
        	if(inputs.get(0).contains("CHECKOUT_BOOK")) {
        		System.out.println(bc.checkout(inputs.get(1)));
        	}
        	
        	if(inputs.get(0).contains("RETURN_BOOK")) {
        		System.out.println(bc.returnBook(inputs.get(1)));
        	}
        	
        	if(inputs.get(0).contains("LIST_AVAILABLE_BOOKS")) {
        		List<BookResponse> res = bc.getAllBooks();
        		if(res != null) {
        			for (int i = 0; i < res.size(); i++) {
						System.out.println(res.get(i).toString());
					}
        		}
        	}
        	
        	
        	if(inputs.get(0).contains("Exit") || inputs.get(0).contains("exit")) {
        		running = false;
        	}
        	
        	System.out.print("# ");
        }
        command.close();
        
        System.out.println("Thank you. Bye Bye.");
	}
	
	public List<String> spiltInput(String input) {
	    List<String> res = new LinkedList<String>();
    	String s = "";
    	boolean firstQuote = false;

	    for(int i=0; i<input.length(); i++) {
	    	char c = input.charAt(i);
	    	if(c == '"') {
	    		if(firstQuote == true) {
	    			res.add(s);
	    			s = "";
	    			firstQuote = false;
	    		} else {
	    			firstQuote = true;
	    		}
	    	} else if(c == ' ' && firstQuote != true) {
	    		if(s != "") {
		    		res.add(s);
		    		s = "";	
	    		}

	    	} else {
	    		s = s + c;
	    	}
	    }
	    
	    res.add(s);
	    return res;
	}
	
}