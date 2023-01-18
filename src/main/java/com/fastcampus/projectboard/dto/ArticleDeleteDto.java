package com.fastcampus.projectboard.dto;

/**
 * A DTO for the {@link com.fastcampus.projectboard.domain.Article} entity
 */

public record ArticleDeleteDto(
                Long id
                )
        //        implements Serializable
{

    /**
     *
     */
    public static ArticleDeleteDto of(Long id) {
        return new ArticleDeleteDto(id);
    }
}