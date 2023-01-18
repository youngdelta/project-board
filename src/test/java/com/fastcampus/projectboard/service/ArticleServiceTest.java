package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDeleteDto;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    public void givenArticleInfo_whenSavingArticle_thenSaveArticle() {
        ArticleDto articleDto = ArticleDto.of(LocalDateTime.now(), "user", "title1", "CONTENT---1", "HASHTAG###");

        //given
        sut.saveArticle(articleDto);


        //when
        BDDMockito.given(articleRepository.save(BDDMockito.any(Article.class))).willReturn(null);


        //then
        BDDMockito.then(articleRepository).should().save(BDDMockito.any(Article.class));
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 수정한다.")
    @Test
    public void givenArticleInfo_whenModifyingArticle_thenUpdateArticle() {
    ArticleUpdateDto articleUpdateDto = ArticleUpdateDto.of(1L, "title1", "CONTENT---1", "HASHTAG###");

        //given
        sut.updateArticle(articleUpdateDto);


        //when
        BDDMockito.given(articleRepository.save(BDDMockito.any(Article.class))).willReturn(null);


        //then
        BDDMockito.then(articleRepository).should().save(BDDMockito.any(Article.class));
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 삭제한다.")
    @Test
    public void givenArticleInfo_whenDeleteArticle_thenDeleteArticle() {
//        ArticleDeleteDto articleDeleteDto = ArticleDeleteDto.of(1L);

        BDDMockito.willDoNothing().given(articleRepository).delete(BDDMockito.any(Article.class));
        //given
//        sut.deleteArticle(articleDeleteDto);
        sut.deleteArticle(1L);


        //when
        BDDMockito.given(articleRepository.save(BDDMockito.any(Article.class))).willReturn(null);


        //then
        BDDMockito.then(articleRepository).should().delete(BDDMockito.any(Article.class));
    }


}