package com.proyectoWeb.PulmonVerde.Service;

import com.proyectoWeb.PulmonVerde.Model.Article;
import com.proyectoWeb.PulmonVerde.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        article.setPublishDate(LocalDate.now());
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article articleDetails) {
        Optional<Article> article1 = articleRepository.findById(id);
        if (article1.isPresent()) {
            Article article = article1.get();
            article.setAuthor(articleDetails.getAuthor());
            article.setTitle(articleDetails.getTitle());
            article.setContent(articleDetails.getContent());
            article.setUrlImage(articleDetails.getUrlImage());
            return articleRepository.save(article);
        } else {
            throw new RuntimeException("Article not found");
        }

    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
