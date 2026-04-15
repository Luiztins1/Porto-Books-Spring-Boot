package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.controller.dto.BookDTO;
import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import io.github.Luiztins1.com.portobook.pbsystem.service.BookService;
import jakarta.validation.Valid;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookDTO book){
        Book bookEntidade = book.mappedBook();
        bookService.saveBook(bookEntidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookEntidade.getId_book())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> listaBook = bookService.findAll();

        if(listaBook.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") UUID id, @RequestBody Book details){
        Optional<Book> bookUpdate = bookService.updateBook(id, details);

        if(bookUpdate.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") UUID id) {
        Optional<Book> bookId = bookService.findById(id);

        if(bookId.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
