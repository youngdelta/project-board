package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("게시글 service")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글 검색, 게시글 리스트 반환")
    @Test
    public void getArticleServiceTest(){

//        SerchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword....");
//        SerchParameters param = SearchParameters.of( "search keyword....");
        //
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE,"search keyword....");   //제목, 본문, ID, 닉네임, 해시태그


        //
        assertThat(articles).isNotNull();

    }

    @DisplayName("게시글 조회, 게시글 반환")
    @Test
    public void getArticleRetrieveTest(){

//        SerchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword....");
//        SerchParameters param = SearchParameters.of( "search keyword....");
        //
        ArticleDto article = sut.searchArticle(1L);   //제목, 본문, ID, 닉네임, 해시태그


        //
        assertThat(article).isNotNull();

    }

    @Test
    public void getArticlePagingTest(){

//        SerchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword....");
//        SerchParameters param = SearchParameters.of( "search keyword....");
        //
        Page<ArticleDto> articles = sut.pageArticles(SearchType.TITLE,"search keyword....");   //제목, 본문, ID, 닉네임, 해시태그


        //
        assertThat(articles).isNotNull();

    }


}