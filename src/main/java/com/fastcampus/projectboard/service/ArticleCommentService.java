package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.ArticleComment;
import com.fastcampus.projectboard.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;


    public List<ArticleComment> searchArticleComment(Long articleId) {
        return List.of();
    }
}
