package com.example.springpractice.controller;

import com.example.springpractice.domain.Ticket;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.google.gson.Gson;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@WebAppConfiguration
//@ContextConfiguration
//@SpringBootTest
@Log4j2
class SampleControllerTests {

//    @Setter(onMethod_ = {@Autowired})
    @Autowired
//    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

//    @BeforeEach
//    public void setUp() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }

    @Test
    void testConvert() throws Exception {

        Ticket ticket = new Ticket();
        ticket.setTno(123);
        ticket.setOwner("Admin");
        ticket.setGrade("AAA");

        String jsonStr = new Gson().toJson(ticket); // Gson: java의 객체를 json 문자열로 변환하기 위해

        log.info(jsonStr);

        mockMvc.perform(post("/sample/ticket")  // get, post, delete, put, patch를 여기서 매칭시킴
                .contentType(MediaType.APPLICATION_JSON)    // 전달하는 데이터 타입 명시, json parse
                .content(jsonStr))                          // 요청하는 컨텐츠 contentType(json)으로 변경되어 body에 들어감
                .andExpect(status().is(200));       // 응답을 검증
    }
}
