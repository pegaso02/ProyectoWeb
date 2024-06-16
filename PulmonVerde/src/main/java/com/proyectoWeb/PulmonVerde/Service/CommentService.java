package com.proyectoWeb.PulmonVerde.Service;

import com.proyectoWeb.PulmonVerde.Model.Comment;
import com.proyectoWeb.PulmonVerde.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        comment.setCreationDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id,Comment comment) {
        Optional<Comment>  comment1 = commentRepository.findById(id);
        if (comment1.isPresent()) {
            Comment comment2 = comment1.get();
            comment2.setComment(comment.getComment());
            comment2.setAuthor(comment.getAuthor());
            comment2.setTittle(comment.getTittle());
            return commentRepository.save(comment2);
        }
        throw new RuntimeException("Comment not found");
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).get();
        if(comment.getComment() != null) {
            return comment;
        }
        throw new RuntimeException("Comment not found");
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
