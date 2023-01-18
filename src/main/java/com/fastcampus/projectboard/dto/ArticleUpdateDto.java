package com.fastcampus.projectboard.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.fastcampus.projectboard.domain.Article} entity
 */

public record ArticleUpdateDto(
                Long id
                , String title
                , String content
                , String hashtag)
        //        implements Serializable
{

    /**
     *
     * @param title
     * @param content
     * @param hashtag
     * @return
     */
    public static ArticleUpdateDto of(Long id, String title, String content, String hashtag) {
        return new ArticleUpdateDto(id, title, content, hashtag);
    }
}