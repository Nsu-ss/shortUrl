package com.ss.url;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UrlApplicationTests {


    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Before
    public void before(){

        if (mockMvc==null){
            mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        }

    }


    @Test
    public void contextLoads()throws Exception {

        String uri="/url/toShort";

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get(uri)

                .param("link","www.baidu.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(print())
                .andReturn();



    }





}
