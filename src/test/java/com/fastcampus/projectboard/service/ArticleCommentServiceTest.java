package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.ArticleComment;
import com.fastcampus.projectboard.repository.ArticleCommentRepository;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("댓글 서비스 테스트")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {
    @InjectMocks
    private ArticleCommentService articleCommentService;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 ID 조회 시 댓글 조회")
    @Test
    void given_when_then() {

        Long articleId = 1L;
        //given
        BDDMockito.given(articleRepository.findById(articleId)).willReturn(Optional.of(Article.of("title22","sodyd1111","####'")));

        //when
        List<ArticleComment> articleCommentList = articleCommentService.searchArticleComment(articleId);

        //then
        assertThat(articleCommentList).isNotNull();

    }

}