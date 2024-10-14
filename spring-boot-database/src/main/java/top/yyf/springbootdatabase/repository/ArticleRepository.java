package top.yyf.springbootdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.yyf.springbootdatabase.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
