package io.github.Luiztins1.com.portobook.pbsystem.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ResponseError(int status, String massege, List<FildError> error) {

    public static ResponseError standardError(String massege){
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), massege, List.of());
    }
}
