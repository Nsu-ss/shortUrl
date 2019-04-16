package com.ss.url.dao;


import com.ss.url.bean.Url;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDao {

    Integer saveUrl(@Param("url") Url url);

    Url findUrlByLink(@Param("link") String url);

    Url finUrlByShortUrl(@Param("shortUrl") String shortUrl);

}
