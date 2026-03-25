package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.Author;
import io.github.Luiztins1.com.portobook.pbsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping
    public Author save(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @PutMapping("/{id}")
    public Optional<Author> update(@PathVariable("id") UUID id, @RequestBody Author details){
        return authorService.updateAuthor(id, details);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        authorService.deleteAuthor(id);
    }

    @GetMapping("/{id}")
    public Optional<Author> findById(@PathVariable("id") UUID id){
        return authorService.findById(id);
    }
}
