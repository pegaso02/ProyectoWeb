package com.proyectoWeb.PulmonVerde.Repository;

import com.proyectoWeb.PulmonVerde.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Article findByTitle(String title);
}
