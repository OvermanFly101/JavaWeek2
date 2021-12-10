package com.flynn.books.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flynn.books.models.Book;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long>{
	//retrieves all books from the database
	List<Book> findAll();
}
