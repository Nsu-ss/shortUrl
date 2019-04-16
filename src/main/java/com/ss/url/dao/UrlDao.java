package com.ss.url.dao;


import com.ss.url.bean.Url;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDao {

    Integer saveUrl(@Param("url") Url url);

    Url findUrlByLink(@Param("link") String url);

    Url finUrlByShortUrl(@Param("shortUrl") String shortUrl);

    Integer insertShortKey(@Param("id") Integer id,@Param("shortKey") String shortKey);

    Integer addCount(@Param("url") Url url);

}
