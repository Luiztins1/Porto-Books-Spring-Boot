package io.github.Luiztins1.com.portobook.pbsystem.controller.dto;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;

import java.util.List;

public record ResponseError(int status, String massege, List<FieldError> error) {

    public static ResponseError standardError(String defaultMessage){
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), defaultMessage, List.of());
    }
}
