package myapp.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExeptionHandler {
    @ExceptionHandler(BadRequestExeption.class)
    public ResponseEntity<?> handelBadRequestExeption(BadRequestExeption exeption){
        return ResponseEntity.badRequest().body(exeption.getMessage());
    }
}
