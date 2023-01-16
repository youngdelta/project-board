package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.config.JpaConfig;
import com.fastcampus.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Jpa 연결 테스트")
//@ActiveProfiles("testdb")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  //application.yaml 에서 test.database.rplace: none
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(JpaRepositoryTest.class);


    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        //given
        long previousCount = articleRepository.count();
        System.out.println(previousCount);
        logger.info("######## {}", previousCount);
        logger.info("########  previousCount : {}", previousCount);

        // when
//        Article savedArticle = articleRepository.save(Article.of("타이틀1", "내용입니다.", "#첫"));
        Article savedArticle = articleRepository.saveAndFlush(Article.of("타이틀1", "내용입니다.", "#첫"));
        logger.info("###   savedArticle : {}",savedArticle);

        logger.info("###   articleRepository.count() : {}",articleRepository.count());


        List<Article> articleList = articleRepository.findAll();

        //then
        assertThat(articleList).isNotNull();


    }
}