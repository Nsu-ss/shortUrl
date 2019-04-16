package com.ss.url;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

        //只是生成短地址
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("link","www.baidu.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //自定义key生产短地址
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("link","www.tencent.com")
                .param("ourKey","123456")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //自定义key和短地址位数生产短地址
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("link","www.weibo.com")
                .param("ourKey","123456")
                .param("length","2")
                 )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //完全自定义短地址
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("link","www.aiwote.com")
                .param("ourUrl","awt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }





}
