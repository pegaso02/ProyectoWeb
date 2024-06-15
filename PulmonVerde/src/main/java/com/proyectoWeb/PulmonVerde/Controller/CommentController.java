package com.proyectoWeb.PulmonVerde.Controller;

import com.proyectoWeb.PulmonVerde.Model.Comment;
import com.proyectoWeb.PulmonVerde.Service.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment ) {
        Comment newComment = commentService.addComment(comment);
        return ResponseEntity.ok().body(newComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id,@RequestBody Comment comment ) {
        Comment newComment = commentService.updateComment(id, comment);
        return ResponseEntity.ok().body(newComment);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        if(comment != null) {
            return ResponseEntity.ok().body(comment);
        }
        throw new RuntimeException("Comment not found");
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.getComments();
        return ResponseEntity.ok().body(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().body(null);
    }

}
