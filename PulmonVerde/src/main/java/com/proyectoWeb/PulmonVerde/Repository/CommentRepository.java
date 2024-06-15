package com.proyectoWeb.PulmonVerde.Repository;

import com.proyectoWeb.PulmonVerde.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
