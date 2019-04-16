package com.ss.url.service.impl;

import com.ss.url.bean.Url;
import com.ss.url.dao.UrlDao;
import com.ss.url.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDao urlDao;


    @Override
    public Integer saveUrl(Url url) {
        return urlDao.saveUrl(url);
    }


    @Override
    public Url findUrlByLink(String url) {
        try {
            return urlDao.findUrlByLink(url);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Url finUrlByShortUrl(String shortUrl) {
        try {
            return urlDao.finUrlByShortUrl(shortUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
