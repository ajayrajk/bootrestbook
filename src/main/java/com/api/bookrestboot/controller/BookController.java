package com.api.bookrestboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.bookrestboot.entities.Book;
import com.api.bookrestboot.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	public BookService bookService;

	//@RequestMapping(value="/books", method = RequestMethod.GET)
//	@GetMapping("/books")
//	public String getBooks() {
//		return "This is testing book first";
//	}
	
	//Get all book handler
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookService.getAllBooks();
	}
	
	
	//Get single book handler
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
	//new book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book b) {
		
		bookService.addBook(b);
		
		return b;
	}
	
	// delete book handler
	@DeleteMapping("/books/{bookid}")
	public void deleteBookById(@PathVariable("bookid") int id) {
		bookService.deleteBookById(id);
	}
	
	//update book handler 
	@PutMapping("/books/{bookid}")
	public Book updateBookById(@RequestBody Book book, @PathVariable("bookid") int bid) {
		bookService.updateBook(book,bid);
		return book;
	}
	
	
	
	
}
