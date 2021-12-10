package com.flynn.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flynn.books.models.Book;
import com.flynn.books.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String Index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/book/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId ) {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
}
