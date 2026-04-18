package io.github.Luiztins1.com.portobook.pbsystem.service;

import io.github.Luiztins1.com.portobook.pbsystem.controller.dto.AuthorDTO;
import io.github.Luiztins1.com.portobook.pbsystem.model.Author;
import io.github.Luiztins1.com.portobook.pbsystem.repository.AuthorRepository;
import io.github.Luiztins1.com.portobook.pbsystem.validator.AuthorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorValidator authorValidator;

    public Author saveAuthor(Author author){
        authorValidator.validate(author);
        return authorRepository.save(author);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Optional<Author> updateAuthor(UUID id, Author details){
        return authorRepository.findById(id).map(existAuthor ->{
            existAuthor.setName(details.getName());
            existAuthor.setAge(details.getAge());
            existAuthor.setNationality(details.getNationality());
            authorValidator.validate(existAuthor);
            return authorRepository.save(existAuthor);
        });
    }

    public void deleteAuthor(UUID id){
        authorRepository.deleteById(id);
    }

    public Optional<Author> findById(UUID id){
        return authorRepository.findById(id);
    }


}
