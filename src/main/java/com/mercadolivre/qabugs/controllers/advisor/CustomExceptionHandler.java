package com.mercadolivre.qabugs.controllers.advisor;

import com.mercadolivre.qabugs.errors.TestCaseDoesNotExists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = TestCaseDoesNotExists.class)
    protected ResponseEntity<Object> handleTestDoesNotExists(TestCaseDoesNotExists exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
