package com.ss.url.controller;


import com.ss.url.bean.Url;
import com.ss.url.dto.AjaxDto;
import com.ss.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    /*以下可以写到配置文件中*/
    //盐
    public static final String key = "ss";
    //初始长度
    public static final Integer size = 3;
    //字符集
    public static final String fields="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     *
     * @param link 实际的url
     * @param ourKey 可自定义的key，默认 ”ss“
     * @param length 设置短网址的位数  默认 "从第三位开始自增"，
     * @param ourUrl 自定义的短码
     * @return
     */
    @RequestMapping("/toShort")
    @ResponseBody
    public AjaxDto test(String link, String ourKey, Integer length, String ourUrl){
        Url url = new Url();
        AjaxDto dto  = new AjaxDto();
        //验证urls
        if (link == null){
           return new AjaxDto(HttpStatus.BAD_REQUEST);
        }
        //验证link
        url = urlService.findUrl(link);
        if (url != null){
            dto.put("data",url);
            return dto;
        }
        url.setUrl(link);
        //保存link并返回id
        if (ourKey != null){
            url.setKey(ourKey);
        }
        if (ourUrl != null){
            url.setKey(ourKey);
        }

        //todo
        if (length != null){
            url.setKey(ourKey);
        }









        //更具参数来制定不同的服务



        return dto;
    }


}
