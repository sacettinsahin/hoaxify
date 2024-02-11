package com.heaxyfy.ws.user;

import com.heaxyfy.ws.error.ApiError;
import com.heaxyfy.ws.shared.GenericMessage;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/api/v1/users")
    ResponseEntity<?> createUser(@Valid @RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok(new GenericMessage("User is created"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleMethodNotValidEx(MethodArgumentNotValidException exception){
        ApiError apiError = new ApiError();
        apiError.setPath("/api/v1/users");
        apiError.setMessage("Validation error");
        apiError.setStatus(400);
        Map<String,String> validationErrors = new HashMap<>();

        for (var fieldError: exception.getBindingResult().getFieldErrors()){
         validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage() );
       }

        apiError.setValidationErrors(validationErrors);
        return ResponseEntity.badRequest().body(apiError);
        
    }


}
