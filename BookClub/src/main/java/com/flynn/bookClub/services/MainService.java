package com.flynn.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.flynn.bookClub.models.Book;
import com.flynn.bookClub.models.LoginUser;
import com.flynn.bookClub.models.User;
import com.flynn.bookClub.repositories.BookRepository;
import com.flynn.bookClub.repositories.UserRepository;

@Service
public class MainService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	//Book Services
	public Book oneBook(Long id) {
		Optional<Book> optionBook = bookRepo.findById(id);
		if(optionBook.isPresent()) {
			return optionBook.get();
		}else {
			return null;
		}
	}
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book editModelBook(Book book) {
		return bookRepo.save(book);
	}
	
	
	// ADD User Services
	
	public User register(User newUser, BindingResult result) {
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()){
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm password must match the password.");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			return user;
		}
	}
}
