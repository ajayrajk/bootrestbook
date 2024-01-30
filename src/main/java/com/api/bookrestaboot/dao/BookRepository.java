package com.api.bookrestaboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.bookrestboot.entities.Book;

public interface  BookRepository extends CrudRepository<Book,Integer> {
	
	public Book findById(int id);

}
