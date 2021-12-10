package com.flynn.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flynn.books.models.Book;
import com.flynn.books.services.BookService;

@RestController
public class BooksAPI {
	private final BookService bookService;
	
	public BooksAPI(BookService bookService) {
		this.bookService = bookService;
	}
	
    @RequestMapping("/api/allBooks")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @PostMapping(value="/api/book")
    public Book create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String language, 
    		@RequestParam(value="pages") Integer pages) {
        Book book = new Book(title, description, language, pages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    @RequestMapping("/api/book/{id}")
    public void delete(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    }

}
