package kg.it.academy.OnlineBank.util;

import kg.it.academy.OnlineBank.exceptions.ApiException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Map<HttpStatus, String>> handleFailException(ApiException apiException) {
        Map<HttpStatus, String> exceptionMessage = new HashMap<>();
        exceptionMessage.put(apiException.getHttpStatus(), apiException.getMessage());

        return new ResponseEntity<>(exceptionMessage, apiException.getHttpStatus());
    }
}
