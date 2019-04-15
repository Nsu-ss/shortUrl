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
    public Url saveUrl(Url url) {
        return urlDao.saveUrl(url);
    }


    @Override
    public Url findUrl(String url) {
        try {
            return urlDao.findUrl(url);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
