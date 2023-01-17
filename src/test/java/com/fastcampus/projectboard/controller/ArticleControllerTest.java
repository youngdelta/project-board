package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("View - 게시판 : 게시글 ")
@Import(SecurityConfig.class)
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
public class ArticleControllerTest {

    private final MockMvc mockMvc;


    public ArticleControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @DisplayName("[view][GET] 게시글 리스트 (게시판) - 정상 호출")
    @Test
    public void bbsListTest() throws Exception {
        //

        //

        mockMvc.perform(MockMvcRequestBuilders.get("/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
//                .andExpect(MockMvcResultMatchers.content().contentType("application/hal+json"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("articles"))
//                .andDo(MockMvcResultHandlers.print())
        ;

    }

    @DisplayName("게시글 상세 조회 API")
    @Test
    void testMvcDetailTest() {
        //given

        //when
        try {
//            mockMvc.perform(get("/api/articles")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
            mockMvc.perform(get("/articles/1"))
                    .andExpect(status().isOk())
//                    .andExpect(content().contentType(MediaType.TEXT_HTML))
                    .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("article"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("articleComments"))
//                .andDo(MockMvcResultHandlers.print())
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //then

    }


    @DisplayName("[View] [GET] 로그인 페이지 호출")
    @Test
    public void authTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
//                .andExpect(MockMvcResultMatchers.content().contentType("application/hal+json"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("login"))
//                .andDo(MockMvcResultHandlers.print())
        ;
    }




}
