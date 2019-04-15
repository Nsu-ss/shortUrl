package com.ss.url.controller;


import com.ss.url.bean.Url;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/url")
public class UrlController {

    /**
     *
     * @param urls 实际的url
     * @param ourKey 可自定义的key，默认 ”ss“
     * @param length 设置短网址的位数  默认 "从第三位开始自增"，
     * @param ourUrl 自定义的短码
     * @return
     */
    @RequestMapping("/toShort")
    public String test(String urls, String ourKey, Integer length, String ourUrl, ModelMap map){
        Url url = new Url();

        //验证urls
        if (urls == null){
            map.put("error","实际url不能为空");
        }
        //保存urls并返回id



        //更具参数来制定不同的服务



        return "short";
    }


}
