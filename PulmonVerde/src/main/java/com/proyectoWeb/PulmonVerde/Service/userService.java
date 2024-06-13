package com.proyectoWeb.PulmonVerde.Service;

import com.proyectoWeb.PulmonVerde.Model.User;
import com.proyectoWeb.PulmonVerde.Repository.userRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class userService {

    public final userRepository repository;

    public userService(userRepository repository) {
        this.repository = repository;
    }


    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return repository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = repository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
