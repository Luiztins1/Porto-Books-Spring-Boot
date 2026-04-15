package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.controller.dto.AuthorDTO;
import io.github.Luiztins1.com.portobook.pbsystem.model.Author;
import io.github.Luiztins1.com.portobook.pbsystem.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDTO> save(@RequestBody @Valid AuthorDTO author){
        Author autorEntidade = author.mappedAuthor();
        authorService.saveAuthor(autorEntidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntidade.getId_author())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        List<Author> listaAutores = authorService.findAll();

        if(listaAutores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaAutores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable("id") UUID id, @RequestBody Author details){
        Optional<Author> atualizado = authorService.updateAuthor(id, details);

        if(atualizado.isPresent()){
            return ResponseEntity.ok(atualizado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable("id") UUID id){
        Optional<Author> authorId = authorService.findById(id);

        if(authorId.isPresent()){
            return ResponseEntity.ok(authorId.get());
        }

        return ResponseEntity.notFound().build();
    }
}
