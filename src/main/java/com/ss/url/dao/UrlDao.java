package com.ss.url.dao;


import com.ss.url.bean.Url;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDao {

    Url saveUrl(@Param("url") Url url);

    Url findUrl(@Param("link") String url);

}
