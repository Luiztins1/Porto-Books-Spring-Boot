package io.github.Luiztins1.com.portobook.pbsystem.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthorDTO(
        @NotBlank(message = "Preencha corretamente")
        String name,

        @NotNull(message = "Valor nulo. Preencha novamente")
        Integer age,

        @NotBlank(message = "Preencha corretamente")
        String nationality
) {
}
