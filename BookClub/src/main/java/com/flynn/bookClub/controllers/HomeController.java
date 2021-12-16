package com.flynn.bookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.flynn.bookClub.models.Book;
import com.flynn.bookClub.services.MainService;

@Controller
public class HomeController {
	
	@Autowired 
	MainService mainServ;
	
	@GetMapping("/books")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		Book newBook = new Book();
		
		model.addAttribute("newBook", newBook);
		List<Book> books = mainServ.allBooks();
		model.addAttribute("books", books);
		return "bookLog.jsp";
	}
	
	@GetMapping("/book/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			Book book = mainServ.oneBook(id);
			model.addAttribute("book", book);
			return "oneBook.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/new")
	public String newBook(HttpSession session, Model model) {
		if(session.getAttribute("user_id") != null) {
			model.addAttribute("book", new Book());
			return "newBook.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/books/new")
	public String processNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		}else {
			mainServ.saveBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			Book book = mainServ.oneBook(id);
			model.addAttribute("book", book);
			return "editBook.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PutMapping("/books/{id}/edit")
	public String processUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
			mainServ.editModelBook(book);
			return "redirect:/book/{id}";
		}
	}
}
