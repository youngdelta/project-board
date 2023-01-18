package com.fastcampus.projectboard.dto;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.fastcampus.projectboard.domain.ArticleComment} entity
 */
public record ArticleCommentDto(LocalDateTime createdAt, String createdBy, String content) implements Serializable {

    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy, String content) {
        return new ArticleCommentDto(createdAt, createdBy, content);
    }
}