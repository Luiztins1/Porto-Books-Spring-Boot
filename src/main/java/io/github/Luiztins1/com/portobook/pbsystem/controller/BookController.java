package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import io.github.Luiztins1.com.portobook.pbsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public Optional<Book> update(@PathVariable("id") UUID id, @RequestBody Book details){
        return bookService.updateBook(id, details);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable("id") UUID id){
        return bookService.findById(id);
    }
}
