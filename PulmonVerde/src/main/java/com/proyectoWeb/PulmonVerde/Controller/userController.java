package com.proyectoWeb.PulmonVerde.Controller;

import com.proyectoWeb.PulmonVerde.Model.User;
import com.proyectoWeb.PulmonVerde.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class userController {

    @Autowired
    userService userService;



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        userService.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok().body("{\"message\": \"User registered successfully\"}");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> Login(@RequestBody User user){
        User u = userService.loginUser(user.getUsername(), user.getPassword());
        if(u != null){
            return ResponseEntity.ok().body(u);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }


}
