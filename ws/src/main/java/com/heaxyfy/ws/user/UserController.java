package com.heaxyfy.ws.user;

import com.heaxyfy.ws.shared.GenericMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/api/v1/users")
    GenericMessage createUser(@RequestBody User user){
        userService.saveUser(user);
        return new GenericMessage("User is created.");
    }
}
