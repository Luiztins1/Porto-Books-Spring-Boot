package io.github.Luiztins1.com.portobook.pbsystem.validator;

import io.github.Luiztins1.com.portobook.pbsystem.model.Author;
import io.github.Luiztins1.com.portobook.pbsystem.repository.AuthorRepository;
import io.github.Luiztins1.com.portobook.pbsystem.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorValidator {

    private final AuthorRepository authorRepository;

    public void validate(Author author){

    }
}
