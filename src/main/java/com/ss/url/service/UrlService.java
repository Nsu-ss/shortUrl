package com.ss.url.service;

import com.ss.url.bean.Url;

public interface UrlService {

    //保存
    Integer saveUrl(Url url);

    //查询link是否存在
    Url findUrlByLink(String url);

    //查询 短网址是否存在
    Url finUrlByShortUrl(String shortUrl);

    //设置shortkey
    Integer insertShortKey(Integer id ,String shortKey);

    //增加点击次数
    Integer addCount(Url url);


}
