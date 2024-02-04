package com.api.bookrestaboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.bookrestboot.entities.Book;

public interface  BookRepository extends JpaRepository<Book,Integer> {
	
	public Book findById(int id);

}
