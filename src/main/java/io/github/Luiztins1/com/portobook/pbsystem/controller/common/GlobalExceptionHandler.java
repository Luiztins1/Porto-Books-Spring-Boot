package io.github.Luiztins1.com.portobook.pbsystem.controller.common;

import io.github.Luiztins1.com.portobook.pbsystem.controller.dto.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseError MethodArgumentNotValidException(MethodArgumentNotValidException e){
       // List<FieldError> errorList = e.getBindingResult().getFieldErrors().stream().map(fe -> new FieldError(fe.getField(), fe.getDefaultMessage())).collect(Collectors.toList());
        return ResponseError.standardError("Erro de validação");

    }
}
