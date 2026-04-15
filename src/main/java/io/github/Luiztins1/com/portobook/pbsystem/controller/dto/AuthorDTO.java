package io.github.Luiztins1.com.portobook.pbsystem.controller.dto;

import io.github.Luiztins1.com.portobook.pbsystem.model.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AuthorDTO(

        @NotBlank(message = "Preencha corretamente")
        String name,

        @NotNull(message = "Valor nulo. Preencha novamente")
        Integer age,

        @NotBlank(message = "Preencha corretamente")
        String nationality) {

        @NotNull
        public Author mappedAuthor(){
                Author author = new Author();
                author.setName(this.name);
                author.setAge(this.age);
                author.setNationality(this.nationality);
                return author;
        }
}
