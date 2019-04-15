package com.ss.url.service;

import com.ss.url.bean.Url;

public interface UrlService {

    Url saveUrl(Url url);

    Url findUrl(String url);


}
