package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외시킴.")
@AutoConfigureMockMvc
//@WebMvcTest
@Transactional
@SpringBootTest
public class DataRestTest {

    private final MockMvc mockMvc;

    public DataRestTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @DisplayName("게시글 리스트 조회 API")
    @Test
    void testMvcTest() {
        //given

        //when
        try {
//            mockMvc.perform(get("/api/articles")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
            mockMvc.perform(get("/api/articles"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                    .andDo(MockMvcResultHandlers.print())
                    ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //then

    }
}
