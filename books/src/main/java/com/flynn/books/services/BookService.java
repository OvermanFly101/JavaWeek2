package com.flynn.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flynn.books.models.Book;
import com.flynn.books.repositories.BooksRepository;

@Service
public class BookService {
	private final BooksRepository bookRepository;
	//final makes it a variable that cannot be changed
	
	public BookService(BooksRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
    // returns all the books
    public List<Book> allBooks() {
    	System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    // retrieves a book
    public Book findBook(Long id) {
    	//optional means it could exist or not when being found
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}