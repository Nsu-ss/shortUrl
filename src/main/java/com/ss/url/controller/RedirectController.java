package com.ss.url.controller;


import com.ss.url.bean.Url;
import com.ss.url.dto.AjaxDto;
import com.ss.url.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RedirectController {

    private static Logger logger = LoggerFactory.getLogger(UrlController.class);

    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "/{shortUrl}")
    public void redirectTo(HttpServletResponse response,
                            @PathVariable("shortUrl") String shortUrl) throws Exception{
        logger.info(shortUrl);
       //获取信息
        Url url = urlService.finUrlByShortUrl(shortUrl);
        //增加点击次数
        url.setCount(url.getCount()+1);
        Integer flag = urlService.addCount(url);
        logger.info(flag+"");
        if (flag == 1){
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        }
        response.sendRedirect("http://"+url.getUrl());
    }


}
