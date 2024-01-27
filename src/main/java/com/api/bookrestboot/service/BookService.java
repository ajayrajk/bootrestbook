package com.api.bookrestboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.bookrestboot.entities.Book;

@Service
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(12,"Java Complte Reference Book","XYZ"));
		list.add(new Book(34,"Head First to Java","ABC"));
		list.add(new Book(48,"Think in Java","LMN"));
	}
	
	//get All Books 
	 public List<Book> getAllBooks() {
	      return list;
	 }  

	//get Single Book by id
	public Book getBookById(int id) {
		Book book=list.stream().filter(b->b.getId()==id).findFirst().get();
		return book;
	}
	
	
	//add a single book 
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	// delete single book
	public void  deleteBookById(int id) {
		
		list=list.stream().filter(b->b.getId()!=id).
				collect(Collectors.toList());
	}
	
	//update book by id
	public void updateBook(Book book, int bid) {
		list.stream().map(b-> {
			if(b.getId()==bid) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
	
	
}
