package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;


    /**
     * @param title          제목
     * @param search_keyword 검색어
     * @return
     */
    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticles(SearchType title, String search_keyword) {

        return List.of(
//                ArticleDto.of(LocalDateTime.now(), "user", "", "")
        );
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return new ArticleDto(LocalDateTime.now(), "user", "테스트1", "테스트 내용1", "#test");

    }

    public Page<ArticleDto> pageArticles(SearchType title, String s) {
        return null;
    }
}
