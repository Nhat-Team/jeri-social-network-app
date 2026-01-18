package io.github.nhatteam.project.core.exception.handle;

import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import lombok.NonNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(@NonNull Exception e) {
        return "Server Error: " + e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleMethodArgumentNotValidException(@NonNull MethodArgumentNotValidException e) {
        return e.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }

    @ExceptionHandler(QueryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleQueryNotFoundException(@NonNull QueryNotFoundException e) {
        return "Resource Not Found: " + e.getMessage();
    }
}
