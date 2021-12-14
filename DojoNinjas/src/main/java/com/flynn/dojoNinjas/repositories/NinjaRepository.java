package com.flynn.dojoNinjas.repositories;

import org.springframework.stereotype.Repository;

import com.flynn.dojoNinjas.models.Ninja;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
