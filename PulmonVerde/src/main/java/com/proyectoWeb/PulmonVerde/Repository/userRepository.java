package com.proyectoWeb.PulmonVerde.Repository;

import com.proyectoWeb.PulmonVerde.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}
