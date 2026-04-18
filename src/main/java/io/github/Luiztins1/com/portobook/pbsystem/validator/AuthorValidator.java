package io.github.Luiztins1.com.portobook.pbsystem.validator;

import io.github.Luiztins1.com.portobook.pbsystem.exceptions.DuplicateRegisterException;
import io.github.Luiztins1.com.portobook.pbsystem.model.Author;
import io.github.Luiztins1.com.portobook.pbsystem.repository.AuthorRepository;
import io.github.Luiztins1.com.portobook.pbsystem.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorValidator {

    private final AuthorRepository authorRepository;

    public void validate(Author author){
        if(existDuplicateAuthor(author)){
            throw new DuplicateRegisterException("Autor já cadastrado");
        }
    }

    public boolean existDuplicateAuthor(Author author){
        Optional<Author> authorSearched = authorRepository.findByNameAndNationality(author.getName(), author.getNationality());

        //TODO: Estamos verificando se o autor já está cadastrado. o nosso Optional retornar true, então existe, se não, ele sai do bloco.
        if(author.getId_author() == null){
            return authorSearched.isPresent();
        }

        //TODO: Estamos verificando se o nosso autor não é igual ao autor encontrado e se o autor encontrado é presente.
        return !author.getId_author().equals(authorSearched.get().getId_author()) && authorSearched.isPresent();
    }
}
