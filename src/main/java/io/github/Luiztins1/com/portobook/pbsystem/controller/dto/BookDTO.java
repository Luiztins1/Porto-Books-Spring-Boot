package io.github.Luiztins1.com.portobook.pbsystem.controller.dto;

import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record BookDTO(

        @NotEmpty(message = "Preencha corretamente")
        UUID uuid,

        @NotBlank(message = "Preencha corretamente")
        String name,

        @NotBlank(message = "Preencha corretamente")
        String country,

        @NotEmpty(message = "Preencha corretamente")
        LocalDate age,

        @NotEmpty(message = "Preencha corretamente")
        BigDecimal price) {

    @NotNull
    public Book mappedBook(){
        Book book = new Book();
        book.setName(this.name);
        book.setCountry(this.country);
        book.setAge(this.age);
        book.setPrice(this.price);
        return book;
    }
}
