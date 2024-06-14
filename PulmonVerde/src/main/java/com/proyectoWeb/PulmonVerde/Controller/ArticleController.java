package com.proyectoWeb.PulmonVerde.Controller;

import com.proyectoWeb.PulmonVerde.Model.Article;
import com.proyectoWeb.PulmonVerde.Service.ArticleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Article")
@Data
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        Article article1 = articleService.createArticle(article);
        return ResponseEntity.ok().body(article1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article){
        Article article1 = articleService.updateArticle(id,article);
        return ResponseEntity.ok().body(article1);
    }

    @GetMapping
    public List<Article> getAllArticle(){
        return articleService.getAllArticles();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.ok().body(null);
    }




}
