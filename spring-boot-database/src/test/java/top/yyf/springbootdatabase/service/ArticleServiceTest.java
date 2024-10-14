package top.yyf.springbootdatabase.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yyf.springbootdatabase.entity.Article;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleServiceTest {

    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle(){
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot 从入门到精通")
                .build();
        Article saveArticle = articleService.saveArticle(article);
        log.info(String.valueOf(saveArticle));
    }


    @Test
    void deleteArticle() {
        articleService.deleteArticle(2L);
    }

    @Test
    void updateArticle() {
        Article article = articleService.getArticle(2L);
        article.setTitle("SpringBoot111");
        articleService.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleService.getArticle(2L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
        List<Article> articles = articleService.getAll();
        articles.forEach(article -> log.info(String.valueOf(article)));
    }
}