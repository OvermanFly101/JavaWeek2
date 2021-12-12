package com.flynn.pokeBook.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flynn.pokeBook.models.PokeBook;


@Repository
public interface PokeRepository extends CrudRepository<PokeBook, Long>{
	//retrieves all books from the database
	List<PokeBook> findAll();
}
