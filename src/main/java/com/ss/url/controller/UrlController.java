package com.ss.url.controller;


import com.ss.url.bean.Url;
import com.ss.url.dto.AjaxDto;
import com.ss.url.service.UrlService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.security.MessageDigest;

@Controller
@RequestMapping(value = "/url")
public class UrlController {

    private static Logger logger = LoggerFactory.getLogger(UrlController.class);

    @Autowired
    private UrlService urlService;

    /*以下可以写到配置文件中*/
    //盐  可以设置key
    private static String key = "ss";
    //初始长度 可以设置长度
    private static Integer size = 5;
    //字符集  可以设置 字符集
    private static String fields = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * @param link   实际的url
     * @param ourKey 可自定义的key，默认 ”ss“
     * @param length 设置短网址的位数  默认 "从第5位开始自增"，
     * @param ourUrl 自定义的短码
     * @return
     */
    @RequestMapping("/toShort")
    @ResponseBody
    public AjaxDto test(String link, String ourKey, Integer length,String ourUrl) {
        Url url = new Url();

        logger.info(link);
        AjaxDto dto = new AjaxDto();
        //验证urls，权限验证
        if (link == null) {
            return new AjaxDto(HttpStatus.BAD_REQUEST);
        }

        //验证link 如果link已存在，则直接返回短网址即可
        url = urlService.findUrlByLink(link);
        if (url != null) {
            dto.put("data", url);
            return dto;
        }
        //自定义短网址
        if (ourUrl != null) {
            //验证ourUrl,如果不存在可以直接把 link,ourUrl,type插入数据库、实现自定义短网址
            url = urlService.finUrlByShortUrl(ourUrl);
            if (url == null) {
                //插入数据库
                url.setShortKey(ourKey);
                url.setUrl(link);
                url.setType(2);
                if (urlService.saveUrl(url) !=null){
                    dto.setMessage("成功");
                }
            } else {
                dto.setMessage("该短网址已被使用！");
            }
            dto.setCode(HttpStatus.OK);
            return dto;
        }

        url.setUrl(link);

        if (ourKey != null) {
            key = ourKey;
            url.setKey(key);
        }
        if (length != null && length >= 1) {
            size = length;
        }
        //保存网址，返回id
        Integer id = urlService.saveUrl(url);

        //制作短网址
        String shortUrl = getShortUrl(id, link, key, size);
        url.setShortKey(shortUrl);
        if (urlService.saveUrl(url) != null){
            dto.setCode(HttpStatus.OK);
            dto.put("data",url);
        }
        return dto;
    }

    //采用安全hash的方法
    private static String getShortUrl(Integer id, String link, String ourKey, Integer length) {

        String data = id + key;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA1");
        }catch (Exception e){
            e.printStackTrace();
        }

        String shai = DigestUtils.sha1Hex(data.getBytes());
        return  shai.substring(0,size);
    }

}
