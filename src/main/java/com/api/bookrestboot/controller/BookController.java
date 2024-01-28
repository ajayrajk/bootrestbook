package com.api.bookrestboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> bList= this.bookService.getAllBooks();
		if(bList.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bList));
	}
	
	
	//Get single book handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book= bookService.getBookById(id);
		try {
			if(book==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
				return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	//new book handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b) {
		Book book=null;
		try {
			book=bookService.addBook(b);
			System.out.println(book);
			
          return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// delete book handler
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("bookid") int id) {
		try {
			bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
	//update book handler 
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Book> updateBookById(@RequestBody Book book, @PathVariable("bookid") int bid) {
		try {
		bookService.updateBook(book,bid);
		return ResponseEntity.of(Optional.of(book));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.
					status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
}
